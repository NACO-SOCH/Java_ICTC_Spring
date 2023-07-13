
package gov.naco.soch.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.domain.FICTCMonthlyReportEntity;
import gov.naco.soch.domain.Facility;
import gov.naco.soch.domain.FictcBeneficiary;
import gov.naco.soch.projection.FICTCBeneficiaryProjection;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.FICTCBeneficiaryEntityRepository;
import gov.naco.soch.repository.FICTCMonthlyReportsRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.security.JwtTokenUtil;
import gov.naco.soch.security.UserAuthenticationToken;
import gov.naco.soch.service.FICTCService;
import gov.naco.soch.service.dto.FICTCMonthlyReportMonthsViewDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportMonthsViewResponseDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportRequestDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportResponseDto;
import gov.naco.soch.service.dto.FICTCOutReferralHistoryRequestDto;
import gov.naco.soch.service.dto.FICTCOutReferralHistoryResponseDto;
import gov.naco.soch.service.mapper.FICTCMapperUtil;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.jsonwebtoken.Claims;
import io.undertow.util.BadRequestException;

@Service
public class FICTCServiceImpl implements FICTCService {

	private final static Logger log = LoggerFactory.getLogger(FICTCServiceImpl.class);

	@Autowired
	private FICTCBeneficiaryEntityRepository fictcBeneficiaryRepository;
	@Autowired
	private FICTCMonthlyReportsRepository fictcMonthlyReportsRepository;
	@Autowired
	JwtTokenUtil tokenUtil;
	@Autowired
	BeneficiaryReferralRepository beneficiaryReferralRepository;
	@Autowired
	FacilityRepository facilityRepository;

	/**
	 * This method fetches all the in progress beneficiaries for an FICTC centre
	 * profileStatus false beneficiaries will be picked.
	 */
	@Override
	public List<FICTCBeneficiaryProjection> getAllInProgressBeneficiariesForFictc() {
		Long createdBy = getUseridFromToken();
		List<FICTCBeneficiaryProjection> beneficiaryList =  fictcBeneficiaryRepository.getAllInProgressBeneficiariesForFictc(createdBy);
		return beneficiaryList;
	}
	
	@Override
	public Optional<FictcBeneficiary> getBeneficiariesDetailById(Long id){
		Optional<FictcBeneficiary> beneficiary = fictcBeneficiaryRepository.findById(id);
		if(!beneficiary.isPresent()) {
			return null;
		}
		return beneficiary;
		
	}
	
	@Override
	public int markBeneficiaryAsDeleted(Long id) {
		return  fictcBeneficiaryRepository.markBeneficiaryAsDeleted(id);
	}
	
	/**
	 * This method saves the FICTC monthly report into database
	 */
	@Transactional
	@Override
	public FICTCMonthlyReportResponseDto saveMonthlyReportsForFictc(
			FICTCMonthlyReportRequestDto fictcMonthlyReportReqDto) throws BadRequestException {
		log.info("entering into saveFICTCMonthlyReports method");
		Optional<FICTCMonthlyReportEntity> existingEntity = null;
		
		if(fictcMonthlyReportReqDto.getId() != null) {
			existingEntity = fictcMonthlyReportsRepository.findById(fictcMonthlyReportReqDto.getId());
		}
		
		FICTCMonthlyReportEntity fictcMonthlyReportEntity = 
				FICTCMapperUtil.mapMonthlyReportRequestToEntity(fictcMonthlyReportReqDto, getUseridFromToken());
		
		
		if(existingEntity!= null && existingEntity.isPresent() &&  fictcMonthlyReportEntity.getId() !=null) {
			fictcMonthlyReportEntity.setCreatedTime(existingEntity.get().getCreatedTime());
		}
		try {
			fictcMonthlyReportEntity = fictcMonthlyReportsRepository.save(fictcMonthlyReportEntity);
		}catch(Exception ex) {
			if(ex.getLocalizedMessage().contains("fictc_monthly_report_report_month_report_year_key")) {
				throw new BadRequestAlertException("This month report already exists for this user: " + getUseridFromToken()
				+ " for month " + fictcMonthlyReportReqDto.getReportMonth() +" year "+ fictcMonthlyReportReqDto.getReportYear(),
				"saveMonthlyReport", "405");
			}
		}
		FICTCMonthlyReportResponseDto fictcMonthlyReportResponseDto = 
				FICTCMapperUtil.mapEntityToMonthlyReportResponse(fictcMonthlyReportEntity);
		provideTotalValuesForMonthlyReports(fictcMonthlyReportResponseDto);
		
		return fictcMonthlyReportResponseDto;
	}

	@Override
	public FICTCMonthlyReportResponseDto getDetailsOfMonthlyReport(Long reportId) {
		log.info("entering into getMonthlyReportsForFictc method");
		FICTCMonthlyReportResponseDto response = null;
		Long createdBy = getUseridFromToken();
		FICTCMonthlyReportEntity reportEntity = fictcMonthlyReportsRepository.getDetailsOfMonthlyReport(createdBy, reportId);
		if(reportEntity != null) {
		response = FICTCMapperUtil.mapEntityToMonthlyReportResponse(reportEntity);
		provideTotalValuesForMonthlyReports(response);
		}
		return response;
	}


	private FICTCMonthlyReportResponseDto provideTotalValuesForMonthlyReports(FICTCMonthlyReportResponseDto report) {
		report.setPrtcPwTotal(makeNullAsZero(report.getPrtcAncCount())+makeNullAsZero(report.getPrtcDirectInLabour()));
		report.setPrtcGcTotal(makeNullAsZero(report.getPrtcMaleClients()) + makeNullAsZero(report.getPrtcFemaleClients()) + makeNullAsZero(report.getPrtcTgClients()));
		
		report.setPotcPwTotal(makeNullAsZero(report.getPotcAncCount())+makeNullAsZero(report.getPotcDirectInLabour()));
		report.setPotcGcTotal(makeNullAsZero(report.getPotcMaleClients()) + makeNullAsZero(report.getPotcFemaleClients()) + makeNullAsZero(report.getPotcTgClients()));
		
		report.settHivPwTotal(makeNullAsZero(report.gettHivAncCount())+makeNullAsZero(report.gettHivDirectInLabour()));
		report.settHivGcTotal(makeNullAsZero(report.gettHivMaleClients()) + makeNullAsZero(report.gettHivFemaleClients()) + makeNullAsZero(report.gettHivTgClients()));
		
		report.setHivReactivePwTotal(makeNullAsZero(report.getHivReactiveAncCount())+makeNullAsZero(report.getHivReactiveDirectInLabour()));
		report.setHivReactiveGcTotal(makeNullAsZero(report.getHivReactiveMaleClients()) + makeNullAsZero(report.getHivReactiveFemaleClients()) + makeNullAsZero(report.getHivReactiveTgClients()));
		report.setLinkedSaIctcPwTotal(makeNullAsZero(report.getLinkedSaIctcAncCount())+makeNullAsZero(report.getLinkedSaIctcDirectInLabour()));
		report.setLinkedSaIctcGcTotal(makeNullAsZero(report.getLinkedSaIctcMaleClients()) + makeNullAsZero(report.getLinkedSaIctcFemaleClients()) + makeNullAsZero(report.getLinkedSaIctcTgClients()));
		
		report.setHivClosingStockTotal(makeNullAsZero(report.getHivOpeningStock())+makeNullAsZero(report.getHivReceivedQuantity())-makeNullAsZero(report.getHivConsumedQuantity())-makeNullAsZero(report.getHivControlQuantity())-makeNullAsZero(report.getHivWastageQuantity()));
		report.setBloodClosingStockTotal(makeNullAsZero(report.getBloodOpeningStock())+makeNullAsZero(report.getBloodReceivedQuantity())-makeNullAsZero(report.getBloodConsumedQuantity())-makeNullAsZero(report.getBloodWastageQuantity()));
		
		report.setDiagnosedStiRtiTotal(makeNullAsZero(report.getDiagnosedStiRtiMale()) + makeNullAsZero(report.getDiagnosedStiRtiPregnantFemale())
		+ makeNullAsZero(report.getDiagnosedStiRtiNonPregnantFemale()) + makeNullAsZero(report.getDiagnosedStiRtiTransgender()));
		
		report.setTestedForSyphillisTotal(makeNullAsZero(report.getTestedForSyphillisMale()) + makeNullAsZero(report.getTestedForSyphillisPregnantFemale())
		+ makeNullAsZero(report.getTestedForSyphillisNonPregnantFemale()) + makeNullAsZero(report.getTestedForSyphillisTransgender()));
		
		report.setReactiveForSyphillisTotal(makeNullAsZero(report.getReactiveForSyphillisMale()) + makeNullAsZero(report.getReactiveForSyphillisPregnantFemale())
				 + makeNullAsZero(report.getReactiveForSyphillisNonPregnantFemale()) + makeNullAsZero(report.getReactiveForSyphillisTransgender()));
		
		report.setTreatmentForSyphillisTotal(makeNullAsZero(report.getTreatmentForSyphillisMale()) + makeNullAsZero(report.getTreatmentForSyphillisPregnantFemale())
		 + makeNullAsZero(report.getTreatmentForSyphillisNonPregnantFemale()) + makeNullAsZero(report.getTreatmentForSyphillisTransgender()));
		
		report.setFourSPwTotal(makeNullAsZero(report.getFourSAncCount())+makeNullAsZero(report.getFourSDirectInLabour()));
		report.setFourSGcTotal(makeNullAsZero(report.getFourSMaleClients()) + makeNullAsZero(report.getFourSFemaleClients()) + makeNullAsZero(report.getFourSTgClients()));
		
		return report;
	}
	
	private int makeNullAsZero(Integer input) {
		if(input != null)
			return input;
		return 0;
	}

	private Long getUseridFromToken() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String token = ((UserAuthenticationToken) authentication).getUserToken();
		log.info("token------------->" + token);
		Claims tokenClaims = tokenUtil.getClaimsFromToken(token);
		log.info("tokenClaims-------->" + tokenClaims);
		Long userId = ((Integer) tokenClaims.get("userId")).longValue();
		log.info("userId--------->" + userId);
		return userId;
	}

	@Override
	public List<FICTCOutReferralHistoryResponseDto> outReferralHistoryReport(FICTCOutReferralHistoryRequestDto requestDto) {
		List<FictcBeneficiary> beneficiaryEntityList = null;
		int month = requestDto.getHivScreeningDate().getMonth().getValue();
		int year = requestDto.getHivScreeningDate().getYear();
		Long referredFrom = requestDto.getReferredFromFacilityId();
		
		beneficiaryEntityList =  fictcBeneficiaryRepository.outReferralHistoryDataForAllIctc(month, year, referredFrom);

		return prepareResponseForOutReferralHistory(beneficiaryEntityList, referredFrom);
		
	}

	private List<FICTCOutReferralHistoryResponseDto> prepareResponseForOutReferralHistory(
			List<FictcBeneficiary> beneficiaryEntityList, Long referredFromFacilityId) {
		List<FICTCOutReferralHistoryResponseDto> responseList = new ArrayList<FICTCOutReferralHistoryResponseDto>();
		for(FictcBeneficiary entity: beneficiaryEntityList) {
			FICTCOutReferralHistoryResponseDto responseDto = new FICTCOutReferralHistoryResponseDto();
			responseDto.setAge(entity.getBeneficiary().getAge());
			responseDto.setBeneficiaryName(entity.getBeneficiary().getFirstName() + " " +entity.getBeneficiary().getMiddleName() + " " + entity.getBeneficiary().getLastName());
			responseDto.setDateOfReferral(entity.getCreatedTime());
			responseDto.setGender(getGender(entity.getBeneficiary().getGenderId()));
			responseDto.setHivScreeningDate(entity.getHivScreeningDate());
			responseDto.setReferredToIctcDetails(getReferedICTCDetails(entity.getBeneficiary().getId(), referredFromFacilityId));
			responseDto.setMobileNumber(entity.getBeneficiary().getMobileNumber());
			responseDto.setNumberOfDaysSinceScreening(ChronoUnit.DAYS.between(entity.getHivScreeningDate(), LocalDateTime.now()));
			responseDto.setPid(entity.getBeneficiary().getPid());
			if(entity.getPregnancyType()!= null) {
				responseDto.setPregnancyStatus(entity.getPregnancyType().getDescription());
			}
			responseDto.setPregnant(entity.getIsPregnant());
			responseList.add(responseDto);
			
		}
		return responseList;
	}


	private Facility getReferedICTCDetails(Long beneficiaryId, Long referredFromFacilityId) {
		//ReferredICTC referredIctc = new ReferredICTC();
		log.info("Getting referred facility details for beneficiary: [{}] and referredFromFacilityId: [{}]", beneficiaryId, referredFromFacilityId);
		BeneficiaryReferral referral = beneficiaryReferralRepository.getReferredIctc(beneficiaryId, referredFromFacilityId);
		Facility referrredToFacility = referral.getReferedTo();
		return referrredToFacility;
	}

	private String getGender(Integer genderId) {
		String gender = null;
		switch(genderId) {
			case 1: gender = "Male";
			break;
			case 2: gender = "Female";
			break;
			case 3: gender = "Transgender";
			break;
		}
		return gender;
	}

	@Override
	public FICTCMonthlyReportMonthsViewResponseDto showMonthsToView() {
		FICTCMonthlyReportMonthsViewResponseDto response = new FICTCMonthlyReportMonthsViewResponseDto();
		
		Long userId = getUseridFromToken();
		//check if there is any record for particular user
		List<FICTCMonthlyReportEntity> entities = fictcMonthlyReportsRepository.getAllMonthlyReportsForUser(userId);
		if(entities.isEmpty()) {
			List<FICTCMonthlyReportMonthsViewDto> prepareReportList = new ArrayList<FICTCMonthlyReportMonthsViewDto>();
			prepareReportList = prepareMonthsForFirstTimeUser(userId);
			response.setPrepareReports(prepareReportList);
			response.setSubmittedReports(new ArrayList<>());
		}else {
			List<FICTCMonthlyReportMonthsViewDto> prepareReportList = new ArrayList<FICTCMonthlyReportMonthsViewDto>();
			List<FICTCMonthlyReportMonthsViewDto> submittedReportList = new ArrayList<FICTCMonthlyReportMonthsViewDto>();
			for(FICTCMonthlyReportEntity entity: entities) {
				 if(entity.getReportSubmitStatus() == null || !entity.getReportSubmitStatus()){//prepareReportList
					List<Integer> currentAndPreviousMonthList = getMonthsNumber(2);
				    FICTCMonthlyReportMonthsViewDto report = new FICTCMonthlyReportMonthsViewDto();
				    if(currentAndPreviousMonthList.contains(entity.getReportMonth())){
					    report.setId(entity.getId());
					    report.setMonthNumber(entity.getReportMonth());
					    report.setMonthName(Month.of(entity.getReportMonth()).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
					    report.setYear(entity.getReportYear());
					    report.setEdited(entity.getReportSubmitStatus());	
					    prepareReportList.add(report);
				    }
				}else if(entity.getReportSubmitStatus()!=null || entity.getReportSubmitStatus()) {//submittedReportsList
					List<Integer> monthsList = getMonthsNumber(5);//fetches current month no. + 4 previous months no.
					FICTCMonthlyReportMonthsViewDto report = new FICTCMonthlyReportMonthsViewDto();
					if(monthsList.contains(entity.getReportMonth())){
					    report.setId(entity.getId());
					    report.setMonthNumber(entity.getReportMonth());
					    report.setMonthName(Month.of(entity.getReportMonth()).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
					    report.setYear(entity.getReportYear());
					    report.setEdited(entity.getReportSubmitStatus());	
					    submittedReportList.add(report);
					}
				}
			}
			response.setPrepareReports(prepareReportList);
			response.setSubmittedReports(submittedReportList);
		}
		return response;
	}

	private List<Integer> getMonthsNumber(int numberOfMonthsRequired) {
		List<Integer> monthsNumberList = new ArrayList<Integer>();
		LocalDate now = LocalDate.now();
		int currentMonthNumber = now.getMonth().getValue();
		monthsNumberList.add(currentMonthNumber);
		for(int i=1;i<numberOfMonthsRequired;i++) {
			int monthNumber = now.minusMonths(i).getMonth().getValue();
			monthsNumberList.add(monthNumber);
		}
		return monthsNumberList;
	}

	private List<FICTCMonthlyReportMonthsViewDto> prepareMonthsForFirstTimeUser(Long userId) {
		List<FICTCMonthlyReportMonthsViewDto> monthsList = new ArrayList<FICTCMonthlyReportMonthsViewDto>();
		/* Setting current month data - START */
		LocalDate now = LocalDate.now(); 
	    int currentMonthNumber = now.getMonth().getValue();
	    int currentYear = now.getYear();
	    
	    FICTCMonthlyReportEntity currentMonthEntity = new FICTCMonthlyReportEntity();
	    
	    currentMonthEntity.setReportMonth(currentMonthNumber);
	    currentMonthEntity.setReportYear(currentYear);
	    currentMonthEntity.setReportSubmitStatus(null);
	    currentMonthEntity.setCreatedTime(LocalDateTime.now());
	    currentMonthEntity.setCreatedBy(userId);
	    
	    currentMonthEntity = fictcMonthlyReportsRepository.save(currentMonthEntity);
	    
	    FICTCMonthlyReportMonthsViewDto reportCurrentMonth = new FICTCMonthlyReportMonthsViewDto();
	    reportCurrentMonth.setId(currentMonthEntity.getId());
	    reportCurrentMonth.setMonthNumber(currentMonthEntity.getReportMonth());
	    reportCurrentMonth.setMonthName(Month.of(currentMonthEntity.getReportMonth()).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
	    reportCurrentMonth.setYear(currentMonthEntity.getReportYear());
	    reportCurrentMonth.setEdited(null);
	    
	    /* Setting current month data - END */
	    
	    /* Setting previous month data - START */
	    FICTCMonthlyReportEntity previousMonthEntity = new FICTCMonthlyReportEntity();
	    LocalDate previous = now.minusMonths(1);
	    int previousMonthNumber = previous.getMonth().getValue();
	    int previousYear = previous.getYear();
	    
	    previousMonthEntity.setReportMonth(previousMonthNumber);
	    previousMonthEntity.setReportYear(previousYear);
	    previousMonthEntity.setReportSubmitStatus(null);
	    previousMonthEntity.setCreatedTime(LocalDateTime.now());
	    previousMonthEntity.setCreatedBy(userId);
	    
	    previousMonthEntity = fictcMonthlyReportsRepository.save(previousMonthEntity);
	    
	    FICTCMonthlyReportMonthsViewDto reportPreviousMonth = new FICTCMonthlyReportMonthsViewDto();
	    reportPreviousMonth.setId(previousMonthEntity.getId());
	    reportPreviousMonth.setMonthNumber(previousMonthEntity.getReportMonth());
	    reportPreviousMonth.setMonthName(Month.of(previousMonthEntity.getReportMonth()).getDisplayName(TextStyle.FULL, Locale.ENGLISH));
	    reportPreviousMonth.setYear(previousMonthEntity.getReportYear());
	    reportPreviousMonth.setEdited(null);
	    /* Setting previous month data - END */
	    
	    monthsList.add(reportCurrentMonth);
	    monthsList.add(reportPreviousMonth);
	    
	    return monthsList;
	}

	@Override
	public FICTCMonthlyReportResponseDto getDetailsOfMonthlyReportWeb(Integer facilityId, Integer reportYear,
			Integer reportMonth) {
		log.info("entering into getDetailsOfMonthlyReportWeb method");
		FICTCMonthlyReportResponseDto response = null;
		FICTCMonthlyReportEntity reportEntity = fictcMonthlyReportsRepository.getFictcMonthlyReportWeb(facilityId,
				reportYear, reportMonth);
		if (reportEntity != null) {
			response = FICTCMapperUtil.mapEntityToMonthlyReportResponse(reportEntity);
			provideTotalValuesForMonthlyReports(response);
		}
		return response;
	}

}
