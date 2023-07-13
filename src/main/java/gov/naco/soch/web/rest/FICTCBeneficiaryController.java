package gov.naco.soch.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gov.naco.soch.domain.FictcBeneficiary;
import gov.naco.soch.projection.FICTCBeneficiaryProjection;
import gov.naco.soch.service.FICTCService;
import gov.naco.soch.service.FictcGeneralService;
import gov.naco.soch.service.dto.FICTCMonthlyReportMonthsViewResponseDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportRequestDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportResponseDto;
import gov.naco.soch.service.dto.FICTCOutReferralHistoryRequestDto;
import gov.naco.soch.service.dto.FICTCOutReferralHistoryResponseDto;
import gov.naco.soch.service.dto.FictcBeneficiaryCreateDTO;
import io.undertow.util.BadRequestException;

@RestController
@RequestMapping("/api")
public class FICTCBeneficiaryController {

	private final Logger log = LoggerFactory.getLogger(FICTCBeneficiaryController.class);

	@Autowired(required = true)
	FICTCService fictcService;
	
	@Autowired
	private FictcGeneralService fictcGeneralService;

	  @PostMapping("/create-fictc-beneficiary-referral")
	    public FictcBeneficiaryCreateDTO createFictcBeneficiaryAndInitiateReferral(@Valid @RequestBody FictcBeneficiaryCreateDTO details) {
	        log.debug("Create fictc-beneficiary and initiate referral");
	        return fictcGeneralService.createBeneficiaryAndInitiateReferral(details);
	    }
	  

	    @GetMapping("/fictc-beneficiary-referral")
	    public List<FICTCBeneficiaryProjection> getAllInProgressBeneficiariesForFictc() throws URISyntaxException{
	        log.debug("getAllInProgressBeneficiariesForFictc method is invoked");
	        return fictcService.getAllInProgressBeneficiariesForFictc();
	    }

	    @GetMapping("/fictc-beneficiary-referral/{id}")
	    public ResponseEntity<FictcBeneficiary> getBeneficiariesDetailById(@PathVariable Long id) throws URISyntaxException,NotFoundException {
	        log.debug("getBeneficiariesDetailById method is invoked");
	        Optional<FictcBeneficiary> beneficiary = fictcService.getBeneficiariesDetailById(id);
	        return ResponseEntity.of(beneficiary);
	    }

	    @DeleteMapping("/fictc-beneficiary-referral/{id}")
	    public String markBeneficiaryAsDeleted(@PathVariable Long id) {
	        log.debug("markBeneficiaryAsDeleted method is invoked");
	        if (fictcService.markBeneficiaryAsDeleted(id) == 1) {
	            return "deleted";
	        } else {
	            return null;
	        }
	    }

	    @GetMapping("/show-months-to-view")
	    public FICTCMonthlyReportMonthsViewResponseDto showMonthsToView() {
	        log.debug("showMonthsToView method is invoked");
	        return fictcService.showMonthsToView();
	    }

	    @PostMapping("/fictc-monthly-reports")
	    public FICTCMonthlyReportResponseDto saveFICTCMonthlyReports(@Valid @RequestBody FICTCMonthlyReportRequestDto fictcMonthlyReportDto) throws BadRequestException {
	        log.debug("saveFICTCMonthlyReports method is invoked");
	        return fictcService.saveMonthlyReportsForFictc(fictcMonthlyReportDto);
	    }

	    @GetMapping("/fictc-monthly-reports/{reportId}")
	    public FICTCMonthlyReportResponseDto getMonthlyReportsForFictc(@PathVariable Long reportId) {
	        log.debug("getMonthlyReportsForFictc method is invoked");
	        return fictcService.getDetailsOfMonthlyReport(reportId);
	    }

	    @PostMapping("/out-referral-history")
	    public List<FICTCOutReferralHistoryResponseDto> outReferralHistoryReport(@RequestBody FICTCOutReferralHistoryRequestDto requestDto) {
	        log.debug("outReferralHistoryReport method is invoked");
	        return fictcService.outReferralHistoryReport(requestDto);
	    }

	    @GetMapping("/fictc-monthly-reports-web")
	    public FICTCMonthlyReportResponseDto getMonthlyReportsForFictcWeb(
	            @RequestParam(required = true) Integer facilityId, @RequestParam(required = true) Integer reportYear,
	            @RequestParam(required = true) Integer reportMonth) {
	        log.debug("getMonthlyReportsForFictcWeb method is invoked");
	        return fictcService.getDetailsOfMonthlyReportWeb(facilityId, reportYear, reportMonth);
	    }

//	/**
//	 * API to create an FICTC-Beneficiary and Initiate Referral 
//	 * 
//	 * @param details details to create beneficiary and initiate referral to an ictc
//	 * @return details with beneficiaryId, referralId and fictcBeneficiaryId
//	 */
//	@PostMapping("/create-fictc-beneficiary-referral")
//	public FictcBeneficiaryCreateDTO createFictcBeneficiaryAndInitiateReferral(@RequestBody FictcBeneficiaryCreateDTO details) {
//		log.debug("Create fictc-beneficiary are initiate referral");
//		return fictcGeneralService.createBeneficiaryAndInitiateReferral(details);
//	}
//
//	
//	/**
//	 * This API fetches all the IN-PROGRESS beneficiaries for an FICTC center
//	 * profileStatus should be false
//	 */
//	@GetMapping("/fictc-beneficiary-referral")
//	public List<FICTCBeneficiaryProjection> getAllInProgressBeneficiariesForFictc()
//			throws URISyntaxException {
//		log.debug("getAllFictcBeneficiaries method is invoked");
//
//		List<FICTCBeneficiaryProjection> beneficiaryList = fictcService.getAllInProgressBeneficiariesForFictc();
//		return beneficiaryList;
//
//	}
//	
//	/**
//	 * This API fetches details of the beneficiary based on id passed 
//	 */
//	@GetMapping("/fictc-beneficiary-referral/{id}")
//	public Optional<FictcBeneficiary> getBeneficiariesDetailById(@PathVariable Long id)
//			throws URISyntaxException, NotFoundException {
//		log.debug("getBeneficiariesDetailById method is invoked");
//		return fictcService.getBeneficiariesDetailById(id);
//
//	}
//	
//	/**
//	 * This API marks the in-progress beneficiary as DELETED
//	 * @throws BadRequestException 
//	 */
//	@DeleteMapping("/fictc-beneficiary-referral/{id}")
//	public String markBeneficiaryAsDeleted(@PathVariable Long id)
//			throws URISyntaxException {
//		log.debug("getBeneficiariesDetailById method is invoked");
//			if(fictcService.markBeneficiaryAsDeleted(id) == 1) 
//				return "deleted";
//			else
//				return null;
//	}
//	
//	/**
//	 * This API will return the months for which monthly report has to be shown
//	 * @return
//	 * @throws URISyntaxException
//	 */
//	@GetMapping("/show-months-to-view")
//	public FICTCMonthlyReportMonthsViewResponseDto showMonthsToView() throws URISyntaxException {
//		log.debug("showMonthsToView method is invoked");
//		
//		FICTCMonthlyReportMonthsViewResponseDto result = fictcService.showMonthsToView();
//		return result;
//	}
//
//	/**
//	 * POST /savemonthlyreports : to save the monthly report
//	 * @throws BadRequestException 
//	 * 
//	 */
//
//	@PostMapping("/fictc-monthly-reports")
//	public FICTCMonthlyReportResponseDto saveFICTCMonthlyReports(@RequestBody FICTCMonthlyReportRequestDto fictcMonthlyReportDto)
//			throws URISyntaxException, BadRequestException {
//		log.debug("saveFICTCMonthlyReports method is invoked");
//
//		FICTCMonthlyReportResponseDto result = fictcService.saveMonthlyReportsForFictc(fictcMonthlyReportDto);
//		return result;
//
//	}
//
//	@GetMapping("/fictc-monthly-reports/{reportId}")
//	public FICTCMonthlyReportResponseDto getMonthlyReportsForFictc(@PathVariable Long reportId) throws URISyntaxException {
//		log.debug("getMonthlyReports method is invoked");
//		
//		FICTCMonthlyReportResponseDto result = fictcService.getDetailsOfMonthlyReport(reportId);
//		return result;
//	}
//	
//	@PostMapping("/out-referral-history")
//	public List<FICTCOutReferralHistoryResponseDto> outReferralHistoryReport(@RequestBody FICTCOutReferralHistoryRequestDto requestDto) throws URISyntaxException {
//		log.debug("outReferralHistoryReport method is invoked");
//		return fictcService.outReferralHistoryReport(requestDto);
//	}
//
//	@GetMapping("/fictc-monthly-reports-web")
//	public FICTCMonthlyReportResponseDto getMonthlyReportsForFictcWeb(
//			@RequestParam(required = true) Integer facilityId, @RequestParam(required = true) Integer reportYear,
//			@RequestParam(required = true) Integer reportMonth) throws URISyntaxException {
//		log.debug("getMonthlyReportsForFictcWeb method is invoked");
//		FICTCMonthlyReportResponseDto result = fictcService.getDetailsOfMonthlyReportWeb(facilityId, reportYear,
//				reportMonth);
//		return result;
//	}
}
