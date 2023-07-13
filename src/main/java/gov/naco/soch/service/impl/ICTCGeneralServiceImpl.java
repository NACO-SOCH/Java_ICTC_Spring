package gov.naco.soch.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import gov.naco.soch.aop.NotificationAspect;
import gov.naco.soch.domain.ArtBeneficiary;
import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.BeneficiaryAppointment;
import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.domain.BeneficiaryMultiFacilityService;
import gov.naco.soch.domain.BeneficiaryVisitRegister;
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.domain.UserMaster;
import gov.naco.soch.projection.BeneficiaryClinicalTreatmentSyphilisProjection;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryAppointmentRepository;
import gov.naco.soch.repository.BeneficiaryClinicalTreatmentRepository;
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.repository.BeneficiaryMultiFacilityServiceRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.ICTCBeneficiaryRepository;
import gov.naco.soch.repository.ICTCFollowUpRepository;
import gov.naco.soch.service.AddressService;
import gov.naco.soch.service.BeneficiaryFacilityMappingService;
import gov.naco.soch.service.BeneficiaryFamilyDetailsService;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.BeneficiaryReferralService;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.FacilityService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCFollowUpService;
import gov.naco.soch.service.ICTCGeneralService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.IctcPartnerDetailsService;
import gov.naco.soch.service.dto.AddressDTO;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;
import gov.naco.soch.service.dto.ICTCPregancyFollowUpDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.dto.IctcBeneficiaryDeleteDTO;
import gov.naco.soch.service.dto.IctcPartnerDetailsDTO;
import gov.naco.soch.service.dto.InfantMotherDetailsDTO;
import gov.naco.soch.service.dto.UpdateRelationshipDTO;
import gov.naco.soch.service.dto.UpdateTestResultDTO;
import gov.naco.soch.service.mapper.AddressMapper;
import gov.naco.soch.service.mapper.BeneficiaryMapper;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;
import gov.naco.soch.service.mapper.ICTCFollowUpMapper;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;
import gov.naco.soch.service.mapper.ICTCTestResultMapper;
import gov.naco.soch.service.mapper.ICTCVisitMapper;
import gov.naco.soch.util.UserUtils;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

@Service
public class ICTCGeneralServiceImpl implements ICTCGeneralService {
	
	private final Logger log = LoggerFactory.getLogger(ICTCGeneralServiceImpl.class);
	
	private static final String ENTITY_NAME = "SOCH_ICTC_BENEFICIARY";

    private final AddressService addressService;
    
    private final BeneficiaryService beneficiaryService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCVisitService ictcVisitService;
    
    private final ICTCVisitMapper ictcVisitMapper;
    
    private final ICTCBeneficiaryMapper ictcBeneficiaryMapper;
    
    private final BeneficiaryMapper beneficiaryMapper;
    
    private final AddressMapper addressMapper;
    
    private final ICTCBeneficiaryRepository ictcBeneficiaryRepository;
    
    private final ICTCFollowUpService followUpService;
    
    private final ICTCFollowUpMapper followUpMapper;
    
    private final ICTCFollowUpRepository followUpRepository;
    
    private final BeneficiaryReferralService referralService;
    
    private final FacilityService facilityService;
    
    private final IctcPartnerDetailsService partnerDetailsService;
    
    private final BeneficiaryFacilityMappingService beneficiaryFacilityMappingService;
    
    private final BeneficiaryFamilyDetailsService familyDetailsService;
    
    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;
    
    private final ArtBeneficiaryRepository artBeneficiaryRepository;
    
    private final BeneficiaryMultiFacilityServiceRepository beneficiaryMultiFacilityServiceRepository;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
    
    private final BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;
    
    private final BeneficiaryAppointmentRepository beneficiaryAppointmentRepository;
    private final NotificationAspect aspect;
    
    private final ICTCSampleCollectionService ictcSampleCollectionService;
    
    private final ICTCTestResultService ictcTestResultService;
    
    private final ICTCSampleCollectionMapper ictcSampleCollectionMapper;
    
    private final ICTCTestResultMapper ictcTestResultMapper;

	private final BeneficiaryClinicalTreatmentRepository beneficiaryClinicalTreatmentRepository;
	
    @Value("${ictc.registration.backdatestatusfromjanuary.enabled:false}")
    private Boolean registrationBackDateStatusFromJanuary;

	public ICTCGeneralServiceImpl(AddressService addressService, BeneficiaryService beneficiaryService,
			ICTCBeneficiaryService ictcBeneficiaryService, ICTCVisitService ictcVisitService,
			ICTCVisitMapper ictcVisitMapper, ICTCTestResultMapper ictcTestResultMapper,
			ICTCBeneficiaryMapper ictcBeneficiaryMapper, BeneficiaryMapper beneficiaryMapper,
			AddressMapper addressMapper, ICTCBeneficiaryRepository ictcBeneficiaryRepository,
			ICTCFollowUpService followUpService, ICTCFollowUpMapper followUpMapper,
			ICTCFollowUpRepository followUpRepository, BeneficiaryReferralService referralService,
			FacilityService facilityService, IctcPartnerDetailsService partnerDetailsService,
			ICTCSampleCollectionMapper ictcSampleCollectionMapper,
			BeneficiaryFacilityMappingService beneficiaryFacilityMappingService,
			BeneficiaryFamilyDetailsService familyDetailsService,
			BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository,
			ArtBeneficiaryRepository artBeneficiaryRepository,
			BeneficiaryMultiFacilityServiceRepository beneficiaryMultiFacilityServiceRepository,
			ICTCTestResultService ictcTestResultService,
			BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService,
			ICTCSampleCollectionService ictcSampleCollectionService,
			BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository,
			BeneficiaryAppointmentRepository beneficiaryAppointmentRepository, NotificationAspect aspect,
			BeneficiaryClinicalTreatmentRepository beneficiaryClinicalTreatmentRepository) {
		this.addressService = addressService;
		this.beneficiaryService = beneficiaryService;
		this.ictcBeneficiaryService = ictcBeneficiaryService;
		this.ictcVisitService = ictcVisitService;
		this.ictcVisitMapper = ictcVisitMapper;
		this.ictcBeneficiaryMapper = ictcBeneficiaryMapper;
		this.beneficiaryMapper = beneficiaryMapper;
		this.addressMapper = addressMapper;
		this.ictcBeneficiaryRepository = ictcBeneficiaryRepository;
		this.followUpService = followUpService;
		this.followUpMapper = followUpMapper;
		this.followUpRepository = followUpRepository;
		this.referralService = referralService;
		this.facilityService = facilityService;
		this.partnerDetailsService = partnerDetailsService;
		this.beneficiaryFacilityMappingService = beneficiaryFacilityMappingService;
		this.familyDetailsService = familyDetailsService;
		this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
		this.artBeneficiaryRepository = artBeneficiaryRepository;
		this.beneficiaryMultiFacilityServiceRepository = beneficiaryMultiFacilityServiceRepository;
		this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
		this.beneficiaryVisitRegisterRepository = beneficiaryVisitRegisterRepository;
		this.beneficiaryAppointmentRepository = beneficiaryAppointmentRepository;
		this.aspect = aspect;
		this.ictcSampleCollectionMapper = ictcSampleCollectionMapper;
		this.ictcTestResultMapper = ictcTestResultMapper;
		this.ictcSampleCollectionService = ictcSampleCollectionService;
		this.ictcTestResultService = ictcTestResultService;
		this.beneficiaryClinicalTreatmentRepository = beneficiaryClinicalTreatmentRepository;
	}
    
    /**
     * To save ICTC beneficiary
     * 
     * @param beneficiaryDO beneficiaryDO
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDTO createICTCBeneficiary(ICTCBeneficiaryDO beneficiaryDO) {
    	AddressDTO addressDTO = beneficiaryDO.getAddress();
    	addressDTO.setIsActive(true);
    	addressDTO.setIsDelete(false);
    	addressDTO = addressService.save(addressDTO);
    	BeneficiaryDTO beneficiaryDTO = beneficiaryDO.getBeneficiary();
    	beneficiaryDTO.setIsActive(true);
    	beneficiaryDTO.setIsDelete(false);
    	beneficiaryDTO.setAddressId(addressDTO.getId());
    	beneficiaryDTO.setPid(beneficiaryDO.getIctcBeneficiary().getPid());
    	ICTCBeneficiaryDTO ictcBeneficiaryDTO = beneficiaryDO.getIctcBeneficiary();
    	
    	Optional<ICTCBeneficiary> optionalIctcBeneficiary = ictcBeneficiaryRepository.findByPidAndDeleteReasonNot(ictcBeneficiaryDTO.getPid());
    	if(optionalIctcBeneficiary.isPresent() && (!optionalIctcBeneficiary.get().getId().equals(ictcBeneficiaryDTO.getId()))) {
    		if(optionalIctcBeneficiary.get().getRecentVisitId() == null) {
    			throw new BadRequestAlertException("$" + optionalIctcBeneficiary.get().getId(), ENTITY_NAME, "ART_PID_EXISTS");
    		} else {
    			throw new BadRequestAlertException("Duplicate PID", ENTITY_NAME, "DUPLICATE_PID");
    		}
    	}
    	
    	if(beneficiaryDTO.getCategoryId() == 1 && ictcBeneficiaryDTO.getInfantCode()!=null) {
    		Optional<ICTCBeneficiary> optionalIctcBen = ictcBeneficiaryRepository.findByInfantCodeAndDeleteReasonNot(ictcBeneficiaryDTO.getInfantCode());
    		if(optionalIctcBen.isPresent() && (!optionalIctcBen.get().getId().equals(ictcBeneficiaryDTO.getId()))) {
    			throw new BadRequestAlertException("Duplicate Infant Code", ENTITY_NAME, "DUPLICATE_INFANT_CODE");
            }
    	}
//    	temporaryFix(beneficiaryDTO); //to remove
    	if(beneficiaryDTO.getCategoryId() == 1) {
    		beneficiaryDTO.setHivStatusId(4);
    	}
    	if(beneficiaryDO.getBeneficiaryReferralId() != null) {
    		updateBeneficiaryReferralDetails(beneficiaryDO);
    	}
    	beneficiaryDTO = beneficiaryService.save(beneficiaryDTO);
		if (beneficiaryDTO != null 
				&& beneficiaryDTO.getUid() == null) {
			beneficiaryDTO.setUid(beneficiaryService.generateUid(beneficiaryDTO.getId()));
			beneficiaryDTO.setRegDate((beneficiaryDO.getVisit() != null && beneficiaryDO.getVisit().getVisitDate() != null) ? beneficiaryDO.getVisit().getVisitDate() : getCurrentTimeInIndia().toLocalDate());
			beneficiaryDTO = beneficiaryService.save(beneficiaryDTO);
		}
		if(beneficiaryDO.getFollowUpId() != null) {
    		followUpRepository.markEntryAsInActiveAndCompleted(beneficiaryDO.getFollowUpId());
    		Optional<ICTCFollowUp> optionalFollowUp = followUpService.find(beneficiaryDO.getFollowUpId());
    		if(optionalFollowUp.isPresent()) {
    			ICTCFollowUp followUp = optionalFollowUp.get();
    			if(followUp.getFollowUpType() == 2) {
    				BeneficiaryFamilyDetailsDTO familyDetails = new BeneficiaryFamilyDetailsDTO();
    				familyDetails.setBeneficiaryId(followUp.getIctcBeneficiary().getBeneficiary().getId());
    				familyDetails.setMemberBeneficiaryId(beneficiaryDTO.getId());
    				familyDetails.setRelationshipId(19);
    				familyDetails.setFamilyUid(followUp.getIctcBeneficiary().getBeneficiary().getId().toString());
    				familyDetails.setCreatedTime(LocalDate.now());
    				familyDetails.setIsActive(true);
    				familyDetails.setIsDelete(false);
    				familyDetails.setFamilyUid("UID-" + RandomUtils.nextDouble());
    				familyDetails.setIsBeneficiary(true);
    				familyDetailsService.save(familyDetails);
    				
    				BeneficiaryFamilyDetailsDTO familyDetailsPartner = new BeneficiaryFamilyDetailsDTO();
    				familyDetailsPartner.setMemberBeneficiaryId(followUp.getIctcBeneficiary().getBeneficiary().getId());
    				familyDetailsPartner.setBeneficiaryId(beneficiaryDTO.getId());
    				familyDetailsPartner.setRelationshipId(19);
    				familyDetailsPartner.setFamilyUid(followUp.getIctcBeneficiary().getBeneficiary().getId().toString());
    				familyDetailsPartner.setCreatedTime(LocalDate.now());
    				familyDetailsPartner.setIsActive(true);
    				familyDetailsPartner.setIsDelete(false);
    				familyDetailsPartner.setIsBeneficiary(true);
    				familyDetails.setFamilyUid("UID-" + RandomUtils.nextDouble());
    				familyDetailsService.save(familyDetailsPartner);
    			}
    		}
    	}
		
    	
    	ictcBeneficiaryDTO.setBeneficiaryId(beneficiaryDTO.getId());
    	ictcBeneficiaryDTO.setIsActive(true);
    	ictcBeneficiaryDTO.setIsDeleted(false);
    	ictcBeneficiaryDTO.setCreatedTime(LocalDateTime.now());
    	if ((beneficiaryDO.getIsArtRegistered() == null || (beneficiaryDO.getIsArtRegistered() != null && !beneficiaryDO.getIsArtRegistered())) && ictcBeneficiaryDTO.getId() != null && beneficiaryDO.getBeneficiaryReferralId() == null) {
            throw new BadRequestAlertException("A new iCTCBeneficiary cannot already have an ID", ENTITY_NAME, "idexists");
        }
    	
    	ictcBeneficiaryDTO = ictcBeneficiaryService.save(ictcBeneficiaryDTO);
    	beneficiaryDO.setIctcBeneficiary(ictcBeneficiaryDTO);
    	
    	ICTCVisitDTO visit = beneficiaryDO.getVisit();
    	if(ictcBeneficiaryDTO.getRegistrationDate() == null) {
    		ictcBeneficiaryDTO.setRegistrationDate(visit.getVisitDate() != null ? visit.getVisitDate() : getCurrentTimeInIndia().toLocalDate());
    	}
    	visit.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
    	Integer currentStatus = null;
    	if(!beneficiaryDO.getIctcBeneficiary().getIsConsentDocumented()) {
        	visit.setBeneficiaryStatus(4);
        	ictcBeneficiaryDTO.setBeneficiaryStatus(4);
        	currentStatus = 4;
    	}
    	else {
    		visit.setBeneficiaryStatus(1);
    		ictcBeneficiaryDTO.setBeneficiaryStatus(1);
    		currentStatus = 1;
    	}
    	if(beneficiaryDTO.getCategoryId() == 1) {
    		visit.setBeneficiaryStatus(51);  //infant -  Under EID
    		ictcBeneficiaryDTO.setBeneficiaryStatus(51);
    		currentStatus = 51;
    	}
    	
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(beneficiaryDTO.getId(), currentStatus, null, ictcBeneficiaryDTO.getFacilityId(), null);
    	
    	visit.setIsActive(true);
    	visit.setIsDeleted(false);
    	visit.setIsMultiFacilityService(false);
    	visit = ictcVisitService.save(visit);
    	updateBeneficiaryMultiFacilityLinking(beneficiaryDTO.getId(), visit.getFacilityId(), ictcBeneficiaryDTO, visit, beneficiaryDTO.getCategoryId());
    	
    	if(!(beneficiaryDO.getIsArtRegistered() != null && beneficiaryDO.getIsArtRegistered())) {
	    	BeneficiaryFacilityMappingDTO beneficiaryFacilityMapping = new BeneficiaryFacilityMappingDTO();
	    	beneficiaryFacilityMapping.setBeneficiaryId(beneficiaryDTO.getId());
	    	beneficiaryFacilityMapping.setFacilityId(visit.getFacilityId());
	    	beneficiaryFacilityMapping.setCreatedTime(LocalDate.now());
	    	beneficiaryFacilityMapping.setIsActive(true);
	    	beneficiaryFacilityMapping.setIsDelete(false);
	    	beneficiaryFacilityMapping.setMappingDate(LocalDate.now());
	    	beneficiaryFacilityMappingService.save(beneficiaryFacilityMapping);
    	}
    	
    	if(beneficiaryDTO.getCategoryId() == 1) {
    		log.debug("Inside create sample for infant");
    	} else {
    		ICTCSampleCollectionDTO sample = new ICTCSampleCollectionDTO();
        	sample.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
        	sample.setVisitId(visit.getId());
        	sample.setIsActive(true);
    		sample.setIsDeleted(false);
    		sample.setFacilityId(visit.getFacilityId());
    		sample.setTestType(11);
    		sample.setCreatedTime(LocalDateTime.now());
    		sample.setSampleCollectionDate(getCurrentTimeInIndia().toLocalDateTime());
    		sample = ictcSampleCollectionService.save(sample);
        	
        	ICTCTestResultDTO result = new ICTCTestResultDTO();
        	result.setResultStatus(1);
        	result.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
        	result.setVisitId(visit.getId());
        	result.setIsActive(true);
        	result.setIsDeleted(false);
    		result.setSampleId(sample.getId());
    		result = ictcTestResultService.save(result);

    		ictcBeneficiaryDTO.setCurrentTestResultId(result.getId());
    	}
    	if(beneficiaryDO.getReferrals() != null) {
    		for(BeneficiaryReferralDTO referral : beneficiaryDO.getReferrals()) {
    			Integer type = referral.getReferralTypeId();
    			referral.setIsActive(true);
    			referral.setIsDelete(false);
				referral.setReferralStatusId(1);
    			referral.setCreatedTime(LocalDateTime.now());
    			referral.setModifiedTime(LocalDateTime.now());
    			referral.setBeneficiaryId(beneficiaryDTO.getId());
    			referral = referralService.save(referral);
    			switch(type) {
    			case 1: ictcBeneficiaryDTO.setArtReferralId(referral.getId());
    					ictcBeneficiaryDTO.setArtReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			case 2: ictcBeneficiaryDTO.setTiReferralId(referral.getId());
    					ictcBeneficiaryDTO.setTiReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			case 3: ictcBeneficiaryDTO.setDsrcReferralId(referral.getId());
    					ictcBeneficiaryDTO.setDsrcReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			case 4: ictcBeneficiaryDTO.setRntcpReferralId(referral.getId());
    					ictcBeneficiaryDTO.setRntcpReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    					break;
    			default: break;
    			}
    		}
    	}
    	ictcBeneficiaryDTO.setRecentVisitId(visit.getId());
    	ictcBeneficiaryService.save(ictcBeneficiaryDTO);
    	if(beneficiaryDO.getInfantMotherDetails() != null) {
    		if(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId() != null) {
	    		List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(beneficiaryDTO.getId(), 4);
	    		if(!motherDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
	    			motherDetail.setMemberBeneficiaryId(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId());
	    			motherDetail.isBeneficiary(true);
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		} else {
	    			BeneficiaryFamilyDetails motherDetail = new BeneficiaryFamilyDetails();
	    			motherDetail.setBeneficiaryId(beneficiaryDTO.getId());
	    			motherDetail.setMemberBeneficiaryId(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId());
	    			motherDetail.setIsActive(true);
	    			motherDetail.setIsDelete(false);
	    			motherDetail.isBeneficiary(true);
	    			motherDetail.setRelationshipId(4);
	    			motherDetail.setCreatedTime(LocalDate.now());
	    			motherDetail.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		}
	    		List<BeneficiaryFamilyDetails> mothersRelationToInfantDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId(), beneficiaryDTO.getId());
	    		if(!mothersRelationToInfantDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherRelationToInfant = mothersRelationToInfantDetails.get(0);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(beneficiaryDTO.getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (beneficiaryDTO.getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		} else {
	    			BeneficiaryFamilyDetails motherRelationToInfant = new BeneficiaryFamilyDetails();
	    			motherRelationToInfant.setBeneficiaryId(beneficiaryDO.getInfantMotherDetails().getBeneficiaryId());
	    			motherRelationToInfant.setMemberBeneficiaryId(beneficiaryDTO.getId());
	    			motherRelationToInfant.setIsActive(true);
	    			motherRelationToInfant.setIsDelete(false);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(beneficiaryDTO.getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (beneficiaryDTO.getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			motherRelationToInfant.setCreatedTime(LocalDate.now());
	    			motherRelationToInfant.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		}
    		}
    	}
        return ictcBeneficiaryDTO;
    }
    
    
    /**
     * Update beneficiary referal details
     * 
     * @param beneficiaryReferralId beneficiaryReferralId
     */
    public void updateBeneficiaryReferralDetails(ICTCBeneficiaryDO beneficiaryDO) {
		Optional<BeneficiaryReferralDTO> optional = referralService.findOne(beneficiaryDO.getBeneficiaryReferralId());
		List<BeneficiaryReferralDTO> referralList = referralService.findByBeneficiaryIdAndReferedToAndReferralStatusId(
				beneficiaryDO.getBeneficiary().getId(), optional.get().getReferedTo());
		referralList.stream().findFirst().ifPresent(e -> {
			BeneficiaryReferralDTO referral = e;
			referral.setAcceptedDate(LocalDate.now());
			referral.setReferralStatusId(3); // Accepted
			referral.setIctcBeneficiaryId(beneficiaryDO.getIctcBeneficiary().getId());
			referral.setAcceptedFacility(beneficiaryDO.getIctcBeneficiary().getFacilityId());
			referralService.save(referral);
		});

		referralList.stream().skip(1).forEach(e -> {
			BeneficiaryReferralDTO referral = e;
			referral.setAcceptedDate(LocalDate.now());
			referral.setReferralStatusId(4); // Declined
			referral.setIctcBeneficiaryId(beneficiaryDO.getIctcBeneficiary().getId());
			referral.setAcceptedFacility(beneficiaryDO.getIctcBeneficiary().getFacilityId());
			referralService.save(referral);
		});
//    	
//    	if(!optional.isPresent()) {
//    		throw new BadRequestAlertException("Invalid beneficiary referral id", "", "Invalid beneficiary referral id");
//    	}
//    	BeneficiaryReferralDTO referral = optional.get();
//    	referral.setAcceptedDate(LocalDate.now());
//    	referral.setReferralStatusId(3);
//    	referral.setIctcBeneficiaryId(beneficiaryDO.getIctcBeneficiary().getId());
////    	validateDuplicateIctcRecord(referral.getBeneficiaryId());
//    	referralService.save(referral);
    }
    
    public void validateDuplicateIctcRecord(Long beneficiaryId) {
    	if(ictcBeneficiaryRepository.countByBeneficiaryId(beneficiaryId) > 0) {
    		throw new BadRequestAlertException("Duplicate Referral", ENTITY_NAME, "DUPLICATE_REFERRAL");
    	}
    }
    
    /**
     * Get ICTC Beneficiary Details
     * 
     * @param ictcBeneficiaryId ictcBeneficiaryId
     * @return
     */
    public ICTCBeneficiaryDO getICTCBeneficiaryDetails(Long ictcBeneficiaryId, Boolean isPregnant) {
    	Optional<ICTCBeneficiary> ictcBeneficiaryOptional = ictcBeneficiaryService.find(ictcBeneficiaryId);
    	if(!ictcBeneficiaryOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid ICTCBeneficiaryId", "", "Invalid ICTCBeneficiaryId");
    	}
    	ICTCBeneficiaryDO response = new ICTCBeneficiaryDO();
    	ICTCBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
    	response.setIctcBeneficiary(ictcBeneficiaryMapper.toDto(ictcBeneficiary));
    	response.setBeneficiary(beneficiaryMapper.toDto(ictcBeneficiary.getBeneficiary()));
    	response.setAddress(addressMapper.toDto(ictcBeneficiary.getBeneficiary().getAddress()));
    	if(ictcBeneficiary.getCurrentTestResultId() != null) {
    		Optional<ICTCTestResult> resultOptional = ictcTestResultService.find(ictcBeneficiary.getCurrentTestResultId());
    		if(resultOptional.isPresent()) {
    			response.setResult(ictcTestResultMapper.toDto(resultOptional.get()));
    			response.setSample(ictcSampleCollectionMapper.toDto(resultOptional.get().getSample()));
    		}
    	}
    	if(ictcBeneficiary.getRecentVisitId() != null) {
    		Optional<ICTCVisitDTO> visitOptional = ictcVisitService.findOne(ictcBeneficiary.getRecentVisitId());
    		if(visitOptional.isPresent()) {
    			response.setVisit(visitOptional.get());
    		}
    	} else {
    		response.setVisit(new ICTCVisitDTO());
    	}
    	
    	if(ictcBeneficiary.getBeneficiary().getCategoryId() == 1) {
    		List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(ictcBeneficiary.getBeneficiary().getId(), 4);
    		if(!motherDetails.isEmpty()) {
    			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
    			Optional<ArtBeneficiary> artOptional = artBeneficiaryRepository.findByBeneficiaryId(motherDetail.getMemberBeneficiary().getId());
    			InfantMotherDetailsDTO details = new InfantMotherDetailsDTO();
    			details.setFirstName(motherDetail.getMemberBeneficiary().getFirstName());
    			details.setMiddleName(motherDetail.getMemberBeneficiary().getMiddleName());
    			details.setLastName(motherDetail.getMemberBeneficiary().getLastName());
    			details.setBeneficiaryId(motherDetail.getMemberBeneficiary().getId());
    			details.setArtDetailsFound(false);
    			if(artOptional.isPresent()) {
    				details.setArtDetailsFound(true);
    				ArtBeneficiary artBeneficiary = artOptional.get();
    				details.setArtNumber(motherDetail.getMemberBeneficiary().getArtNumber());
        			details.setPreArtNumber(motherDetail.getMemberBeneficiary().getPreArtNumber());
        			details.setArtCenterId(artBeneficiary.getFacility().getId());
        			details.setArtCode(artBeneficiary.getFacility().getCode());
        			details.setMotherArtCenter(artBeneficiary.getFacility());
    			}
    			response.setInfantMotherDetails(details);
    		}
    	}
    	if(isPregnant != null && isPregnant == true) {
    		Optional<BeneficiaryVisitRegister> optionalGlobalVisit = beneficiaryVisitRegisterRepository.findFirstByIsPregnantOrderByDesc(ictcBeneficiary.getBeneficiary().getId());
    		if(optionalGlobalVisit.isPresent()) {
    			response.setBeneficiaryVisitRegister(optionalGlobalVisit.get());
    		}
    	}
		Optional<BeneficiaryClinicalTreatmentSyphilisProjection> optionalClinicalSyphilis = beneficiaryClinicalTreatmentRepository
				.findSyphilisTestResultDetailsInClinicalTreatment(ictcBeneficiary.getBeneficiary().getId());
		if (optionalClinicalSyphilis.isPresent()) {
			response.setDsrcSyphilisDetails(optionalClinicalSyphilis.get());
		}
    	return response;
    }
    
    /**
     * Update beneficiary details
     * 
     * @param details
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDO updateICTCBeneficiaryDetails(ICTCBeneficiaryDO details) {
    	if(details.getIsArtRegistered() != null && details.getIsArtRegistered()) {
    		createICTCBeneficiary(details);
    	}
		if (details.getBeneficiaryReferralId() != null) {
			updateBeneficiaryReferralDetails(details);
		}
    	if(details.getIctcBeneficiary() != null) {
    		if(details.getIctcBeneficiary().getId() != null) {
    			ICTCBeneficiaryDTO ictcBeneficiaryDTO = details.getIctcBeneficiary();
    			if(details.getReferrals() != null) {
    	    		for(BeneficiaryReferralDTO referral : details.getReferrals()) {
    	    			Integer type = referral.getReferralTypeId();
    	    			referral.setIsActive(true);
    	    			referral.setIsDelete(false);
						referral.setReferralStatusId(1);
    	    			referral.setCreatedTime(LocalDateTime.now());
    	    			referral.setModifiedTime(LocalDateTime.now());
//    	    			referral.setReferDate(LocalDate.now());
    	    			referral.setBeneficiaryId(details.getBeneficiary().getId());
    	    			referral = referralService.save(referral);
    	    			switch(type) {
    	    			case 1: ictcBeneficiaryDTO.setArtReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setArtReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			case 2: ictcBeneficiaryDTO.setTiReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setTiReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			case 3: ictcBeneficiaryDTO.setDsrcReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setDsrcReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			case 4: ictcBeneficiaryDTO.setRntcpReferralId(referral.getId());
    	    					ictcBeneficiaryDTO.setRntcpReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
    	    					break;
    	    			default: break;
    	    			}
    	    		}
    	    	}
				if (details.getVisit() != null) {
					if (details.getVisit().getId() != null) {
						ICTCVisitDTO visit = details.getVisit();
						visit.setIctcBeneficiaryId(ictcBeneficiaryDTO.getId());
						if (details.getBeneficiary().getCategoryId() == 1) {
							if (details.getIctcBeneficiary().getBeneficiaryStatus() != 51) {
								ictcBeneficiaryDTO.setIsConsentDocumented(true);
							}
						} else {
							if (!ictcBeneficiaryDTO.getIsConsentDocumented()
									&& details.getIctcBeneficiary().getBeneficiaryStatus() == 1) {
								visit.setBeneficiaryStatus(4);
								ictcBeneficiaryDTO.setBeneficiaryStatus(4);
							} else if (ictcBeneficiaryDTO.getIsConsentDocumented()
									&& details.getIctcBeneficiary().getBeneficiaryStatus() == 4) {
								visit.setBeneficiaryStatus(1);
								ictcBeneficiaryDTO.setBeneficiaryStatus(1);
							} else {
								ictcBeneficiaryDTO.setIsConsentDocumented(true);
							}
						}
						visit.setIsActive(true);
						visit.setModifiedTime(LocalDateTime.now());
						ictcVisitService.save(visit);
					}
				}
    			ictcBeneficiaryService.save(details.getIctcBeneficiary());
    		}
    	}
    	if(details.getBeneficiary() != null) {
    		if(details.getBeneficiary().getId() != null) {
    			beneficiaryService.save(details.getBeneficiary());
    		}
    	}
    	if(details.getAddress() != null) {
    		if(details.getAddress().getId() != null) {
    			addressService.save(details.getAddress());
    		}
    	}
    	if(details.getVisit() != null) {
    		if(details.getVisit().getId() != null) {
    			ICTCVisitDTO visit = details.getVisit();
    			visit.setIsActive(true);
    			if(visit.getIsMultiFacilityService() == null) {
    				visit.setIsMultiFacilityService(false);
    			}
    			details.setVisit(ictcVisitService.save(visit));
    		}
    	}
    	if(details.getSample() != null) {
    		if(details.getSample().getId() != null) {
    			ictcSampleCollectionService.save(details.getSample());
    		}
    	}
    	if(details.getResult() != null) {
    		if(details.getResult().getId() != null) {
    			ictcTestResultService.save(details.getResult());
    		}
    	}
    	
//    	if(details.getReferrals() != null && details.getReferrals().size() != 0) {
//    		for(int i=0; i<details.getReferrals().size(); i++) {
//    			referralService.save(details.getReferrals().get(i));
//    		}
//    	}
    	
       	if(details.getFollowups() != null) {
    		for(ICTCFollowUpDTO followUpDTO : details.getFollowups()) {
    			followUpDTO.setCreatedTime(LocalDateTime.now());
    			followUpDTO.setIsCompleted(false);
    			followUpDTO.setIsActive(true);
    			followUpDTO.setIsDeleted(false);
    			followUpService.save(followUpDTO);
    		}
    	}
       	if(details.getInfantMotherDetails() != null) {
       		if(details.getInfantMotherDetails().getBeneficiaryId() != null) {
	    		List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(details.getBeneficiary().getId(), 4);
	    		if(!motherDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
	    			motherDetail.setIsBeneficiary(true);
	    			motherDetail.setMemberBeneficiaryId(details.getInfantMotherDetails().getBeneficiaryId());
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		} else {
	    			BeneficiaryFamilyDetails motherDetail = new BeneficiaryFamilyDetails();
	    			motherDetail.setBeneficiaryId(details.getBeneficiary().getId());
	    			motherDetail.setMemberBeneficiaryId(details.getInfantMotherDetails().getBeneficiaryId());
	    			motherDetail.setIsActive(true);
	    			motherDetail.setIsDelete(false);
	    			motherDetail.setRelationshipId(4);
	    			motherDetail.setIsBeneficiary(true);
	    			motherDetail.setCreatedTime(LocalDate.now());
	    			motherDetail.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherDetail);
	    		}
	    		List<BeneficiaryFamilyDetails> mothersRelationToInfantDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(details.getInfantMotherDetails().getBeneficiaryId(), details.getBeneficiary().getId());
	    		if(!mothersRelationToInfantDetails.isEmpty()) {
	    			BeneficiaryFamilyDetails motherRelationToInfant = mothersRelationToInfantDetails.get(0);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(details.getBeneficiary().getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (details.getBeneficiary().getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		} else {
	    			BeneficiaryFamilyDetails motherRelationToInfant = new BeneficiaryFamilyDetails();
	    			motherRelationToInfant.setBeneficiaryId(details.getInfantMotherDetails().getBeneficiaryId());
	    			motherRelationToInfant.setMemberBeneficiaryId(details.getBeneficiary().getId());
	    			motherRelationToInfant.setIsActive(true);
	    			motherRelationToInfant.setIsDelete(false);
	    			motherRelationToInfant.setIsBeneficiary(true);
	    			if(details.getBeneficiary().getGenderId() == 1) {
	    				motherRelationToInfant.setRelationshipId(5);
	    			} else if (details.getBeneficiary().getGenderId() == 2) {
	    				motherRelationToInfant.setRelationshipId(6);
	    			}
	    			motherRelationToInfant.setCreatedTime(LocalDate.now());
	    			motherRelationToInfant.setFamilyUid("UID" + RandomUtils.nextDouble());
	    			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
	    		}
	       	}
    	}
    	
    	return details;
    }
    
    /**
     * Update Test Result
     * 
     * @param updateTestResultDTO updateTestResultDTO
     * @return
     */
    @Transactional
    public UpdateTestResultDTO updateTestResult(UpdateTestResultDTO updateTestResultDTO) {
    	 log.debug("REST request to update test result : {}", updateTestResultDTO);
         if (updateTestResultDTO.getResultId() == null) {
             throw new BadRequestAlertException("Invalid Sample id", ENTITY_NAME, "id null");
         }
         Optional<ICTCTestResult> resultOptional = ictcTestResultService.find(updateTestResultDTO.getResultId());
    	 if(!resultOptional.isPresent()) {
    		 throw new BadRequestAlertException("Result not found", ENTITY_NAME, "Result not found");
    	 }
    	 ICTCTestResult result = resultOptional.get();
    	 result.setHivStatus(updateTestResultDTO.getHivStatus());
    	 result.setHivType(updateTestResultDTO.getHivType());
    	 
    	 LocalDateTime testedDateTime = getCurrentTimeInIndia().toLocalDateTime();
    	 testedDateTime = testedDateTime.withYear(updateTestResultDTO.getTestedDate().getYear());
    	 testedDateTime = testedDateTime.withMonth(updateTestResultDTO.getTestedDate().getMonthValue());
    	 testedDateTime = testedDateTime.withDayOfMonth(updateTestResultDTO.getTestedDate().getDayOfMonth());
    	 
    	 result.setTestedDate(testedDateTime);
    	 result.setReportDeliveryDate(updateTestResultDTO.getReportDeliveryDate());
    	 result.setReportReceivedDate(updateTestResultDTO.getReportReceivedDate());
    	 result.setResultStatus(4);
    	 
    	 if(updateTestResultDTO.getLabInchargeId() != null) {
    		 ICTCSampleCollection sample = result.getSample();
    		 sample.setLabIncharge(new UserMaster(updateTestResultDTO.getLabInchargeId()));
    		 ictcSampleCollectionService.save(ictcSampleCollectionMapper.toDto(sample));
    	 }
  
    	 ICTCVisit visit = result.getVisit();
    	 
    	 Integer prevStatus = visit.getBeneficiaryStatus();
    	 visit.setBeneficiaryStatus(2); //"PENDING_POST_TC" if removed, please set modified time
    	 ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
    	 ictcBeneficiary.setBeneficiaryStatus(2);
    	 
    	 Beneficiary beneficiary = visit.getIctcBeneficiary().getBeneficiary();
    	 if(beneficiary.getCategoryId() != 1) {
	    	 beneficiary.setHivStatusId(result.getHivStatus());
	    	 beneficiary.setHivTypeId(result.getHivType());
	    	 beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
    	 }
    	 
		if (beneficiary.getCategoryId() == 1) {
			Integer newBeneficiaryStatus = null;
			switch (result.getSample().getTestType()) {
			case 11:
				newBeneficiaryStatus = 46; // Antibody-I-Result Posted
				break;
			case 12:
				newBeneficiaryStatus = 48; // Antibody-II-Result Posted
				break;
			case 13:
				newBeneficiaryStatus = 50; // Antibody-III-Result Posted
				if(beneficiary.getHivStatusId() == 2) {
					if(result.getHivStatus() != 2 && (result.getSample().getIsEighteenPlus() != null && result.getSample().getIsEighteenPlus())) {
						beneficiary.setIsSerodiscordant(true);
						beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
					}
				} else {
					if (result.getHivStatus() == 1 || (result.getSample().getIsEighteenPlus() != null && result.getSample().getIsEighteenPlus() && result.getHivStatus() == 2)) {
						beneficiary.setHivStatusId(result.getHivStatus());
						beneficiary.setHivTypeId(result.getHivType());
						beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
					}
				}
				break;
			case 14:
				newBeneficiaryStatus = 56; // Antibody-IV-Result Posted
				if (result.getHivStatus() != 3) {
					beneficiary.setHivStatusId(result.getHivStatus());
					beneficiary.setHivTypeId(result.getHivType());
					beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
				}
				break;
			default:
				break;
			}
			visit.setBeneficiaryStatus(newBeneficiaryStatus);
			ictcBeneficiary.setBeneficiaryStatus(newBeneficiaryStatus);
			result.setResultStatus(4);
		}
    	 
    	 beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), visit.getBeneficiaryStatus(), prevStatus, visit.getFacility().getId(), null);
    	 
    	 ictcVisitService.save(visit);
    	 ictcTestResultService.save(ictcTestResultMapper.toDto(result));
    	 ictcBeneficiaryService.save(ictcBeneficiary);
    	 return updateTestResultDTO;
    }
    
    /**
     * Revoke Test Result
     * 
     * @param testResultId testResultId
     */
    @Transactional
    public void revokeTestResult(Long testResultId) {
		if (testResultId == null) {
			throw new BadRequestAlertException("Invalid Test Result id", ENTITY_NAME, "id null");
		}
		Optional<ICTCTestResult> resultOptional = ictcTestResultService.find(testResultId);
		if (!resultOptional.isPresent()) {
			throw new BadRequestAlertException("Result not found", ENTITY_NAME, "Result not found");
		}
		ICTCTestResult result = resultOptional.get();
		result.setHivStatus(null);
   	 	result.setHivType(null);
   	 	result.setTestedDate(null);
   	 	result.setReportDeliveryDate(null);
   	 	result.setReportReceivedDate(null);
   	 	result.setResultStatus(1);
   	 	ICTCVisit visit = result.getVisit();
    	 
    	 
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), 1, visit.getBeneficiaryStatus(), visit.getFacility().getId(), null);
    	 
    	visit.setBeneficiaryStatus(1); //"PENDING"
    	 
    	ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
    	ictcBeneficiary.setBeneficiaryStatus(1);
    	 
    	Beneficiary beneficiary = visit.getIctcBeneficiary().getBeneficiary();
    	beneficiary.setHivStatusId(null);
    	beneficiary.setHivTypeId(null);
    	beneficiaryService.save(beneficiaryMapper.toDto(beneficiary));
    	 
    	ictcVisitService.save(visit);
    	ictcTestResultService.save(ictcTestResultMapper.toDto(result));
    	ictcBeneficiaryService.save(ictcBeneficiary);
    }
    
    /**
     * Delete and entity(Soft Delete)
     * 
     * @param id id
     */
    @Transactional
    public void deleteICTCBeneficiary(Long id) {
    	ictcBeneficiaryRepository.markEntryAsDeletedAndInActive(id);
    }
    
    
    /**
     * Update post counselling details
     * 
     * @param details details
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDO updatePostCounselling(ICTCBeneficiaryDO details) {
    	ICTCVisitDTO visitForUpdate = null;
    	ICTCBeneficiaryDTO ictcBeneficiary = null;
    	Integer hivStatus = null;
    	Integer prevStatus = null;
    	Integer currentStatus = null;
    	if(details.getVisit() != null) {
    		ICTCVisitDTO visit = details.getVisit();
    		if(visit.getIsMultiFacilityService() == null) {
    			visit.setIsMultiFacilityService(false);
    		}
    		prevStatus = visit.getBeneficiaryStatus();
    		visit.setBeneficiaryStatus(5);
    		currentStatus = 5;
    		visit.setIsActive(true);
    		visit = ictcVisitService.save(visit);
    		visitForUpdate = visit;
    		details.setVisit(visit);
    	}
    	if(details.getIctcBeneficiary() != null) {
    		ictcBeneficiary = details.getIctcBeneficiary();
    		if(details.getReferrals() != null) {
    			List<BeneficiaryReferralDTO> referrals = new ArrayList<>();
        		for(BeneficiaryReferralDTO referral : details.getReferrals()) {
        			Integer type = referral.getReferralTypeId();
        			referral.setIsActive(true);
        			referral.setIsDelete(false);
					referral.setReferralStatusId(1);
        			referral.setCreatedTime(LocalDateTime.now());
        			referral.setModifiedTime(LocalDateTime.now());
        			referral = checkAndUpdateReferralIfArtLinked(referral);
        			referral = referralService.save(referral);
        			switch(type) {
        			case 1: ictcBeneficiary.setArtReferralId(referral.getId());
        					ictcBeneficiary.setArtReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					currentStatus = processArtReferral(visitForUpdate, referral, currentStatus);
        					break;
        			case 2: ictcBeneficiary.setTiReferralId(referral.getId());
        					ictcBeneficiary.setTiReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					break;
        			case 3: ictcBeneficiary.setDsrcReferralId(referral.getId());
        					ictcBeneficiary.setDsrcReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					break;
        			case 4: ictcBeneficiary.setRntcpReferralId(referral.getId());
        					ictcBeneficiary.setRntcpReferralName(facilityService.getFacilityFromFacilityId(referral.getReferedTo()));
        					break;
        			default: break;
        			}
        			referrals.add(referral);
        		}
        		details.setReferrals(referrals);
        	}
//    		ictcBeneficiary = ictcBeneficiaryService.save(ictcBeneficiary);
    		if(details.getPartnerDetails() != null) {
    			for(IctcPartnerDetailsDTO partnerDetails : details.getPartnerDetails()) {
    				if(partnerDetails.getPartnerTestFollowUpDate() != null) {
    					ICTCFollowUpDTO followUp = new ICTCFollowUpDTO();
    					followUp.setIsActive(true);
    					followUp.setIsDeleted(false);
    					followUp.setIsCompleted(false);
    					followUp.setCreatedTime(LocalDateTime.now());
    					followUp.setFollowUpType(2);
    					followUp.setFollowUpDate(partnerDetails.getPartnerTestFollowUpDate());
    					followUp.setVisitId(partnerDetails.getVisitId());
    					followUp.setTestResultId(partnerDetails.getResultId());
    					followUp.setFacilityId(partnerDetails.getFacilityId());
    					followUp.setIctcBeneficiaryId(partnerDetails.getIctcBeneficiaryId());
    					followUp = followUpService.save(followUp);
    					partnerDetails.setFollowUpId(followUp.getId());
    				}
    				partnerDetails.setCreatedDate(LocalDate.now());
    				partnerDetailsService.save(partnerDetails);
    			}
    		}
    		details.setIctcBeneficiary(ictcBeneficiary);
    	}
    	if(details.getResult() != null) {
    		ICTCTestResultDTO result = ictcTestResultService.save(details.getResult());
    		details.setResult(result);
    		hivStatus = result.getHivStatus();
    	}
    	if(details.getSample() != null) {
    		ICTCSampleCollectionDTO sample = ictcSampleCollectionService.save(details.getSample());
    		details.setSample(sample);
    	}
    	if(details.getBeneficiary() != null) {
    		BeneficiaryDTO beneficiary = details.getBeneficiary();
    		if(hivStatus != null) {
    			beneficiary.setHivStatusId(hivStatus);
    		}
    		beneficiary = beneficiaryService.save(details.getBeneficiary());
    		details.setBeneficiary(beneficiary);
    	}
    	if(details.getFollowups() != null) {
    		List<ICTCFollowUpDTO> followUps = new ArrayList<>();
    		for(ICTCFollowUpDTO followUpDTO : details.getFollowups()) {
    			if(visitForUpdate != null && followUpDTO.getFollowUpType() == 1) {
    				visitForUpdate.setBeneficiaryStatus(3);
    				currentStatus = 3;
    				visitForUpdate.setIsActive(true);
    				ictcVisitService.save(visitForUpdate);
    			}
    			followUpDTO.setCreatedTime(LocalDateTime.now());
    			followUpDTO.setIsCompleted(false);
    			followUpDTO.setIsActive(true);
    			followUpDTO.setIsDeleted(false);
    			followUps.add(followUpService.save(followUpDTO));
    		}
    		details.setFollowups(followUps);
    	}
    	ictcBeneficiary.setBeneficiaryStatus(currentStatus);
    	ictcBeneficiaryService.save(ictcBeneficiary);
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(details.getBeneficiary().getId(), currentStatus, prevStatus, details.getVisit().getFacilityId(), null);
    	updateBeneficiaryMultiFacilityLinking(ictcBeneficiary.getBeneficiaryId(), details.getSample().getFacilityId(), ictcBeneficiary, visitForUpdate, details.getBeneficiary().getCategoryId());
    	return details;
    }
    
    public BeneficiaryReferralDTO checkAndUpdateReferralIfArtLinked(BeneficiaryReferralDTO referral) {
    	Optional<ArtBeneficiary> optional = artBeneficiaryRepository.findActiveArtBeneficiaryByBeneficiaryId(referral.getBeneficiaryId());
    	if(optional.isPresent()) {
    		referral.setModifiedTime(LocalDateTime.now());
    		referral.setAcceptedDate(optional.get().getArtRegistrationDate());
    		referral.setReferralStatusId(3);
    		referral.setAcceptedFacility(optional.get().getFacility().getId());
    	}
    	return referral;
    }
    
    private Integer processArtReferral(ICTCVisitDTO visitForUpdate, BeneficiaryReferralDTO referral, Integer currentStatus) {
    	if(visitForUpdate != null) {
			LocalDate expDate = getCurrentTimeInIndia().toLocalDate().minusDays(7);
			if(referral.getReferralStatusId().equals(3)) {
				visitForUpdate.setBeneficiaryStatus(8);
				currentStatus = 8;
			} else if(expDate.compareTo(referral.getReferDate()) > 0) {
				visitForUpdate.setBeneficiaryStatus(7);
				currentStatus = 7;
			} else {
				visitForUpdate.setBeneficiaryStatus(6);
				currentStatus = 6;
			}
			visitForUpdate.setIsActive(true);
			ictcVisitService.save(visitForUpdate);
			aspect.beneficiaryArtReferralNotification(referral.getReferedTo(), UserUtils.getLoggedInUserDetails().getToken());
		}
    	return currentStatus;
    }
    	
    /**
     * Update ictcbeneficiary relationship
     * 
     * @param ictcBeneficiaryId ictcBeneficiaryId
     * @param relationshipRecordId
     * @param relationshipType
     * @return
     */
    @Transactional
    public ICTCBeneficiaryDTO updateInfantRelationship(UpdateRelationshipDTO relationship) {
    	if(relationship.getFollowUpId() != null) {
    		followUpRepository.markEntryAsInActiveAndCompleted(relationship.getFollowUpId());
    	}
    	Optional<ICTCBeneficiary> beneficiaryOptional = ictcBeneficiaryService.find(relationship.getIctcBeneficiaryId());
    	if(!beneficiaryOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid ICTCBeneficiary Id", ENTITY_NAME, "Invalid ICTCBeneficiary Id");
    	}
    	Optional<ICTCBeneficiary> relationOptional = ictcBeneficiaryService.find(relationship.getRelationshipRecordId());
    	if(!relationOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid relationshipRecordId Id", ENTITY_NAME, "Invalid relationshipRecordId Id");
    	}
    	ICTCBeneficiary infant = beneficiaryOptional.get();
    	ICTCBeneficiary mother = relationOptional.get();
    	
    	List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(infant.getBeneficiary().getId(), 4);
		if(!motherDetails.isEmpty()) {
			BeneficiaryFamilyDetails motherDetail = motherDetails.get(0);
			motherDetail.setMemberBeneficiaryId(mother.getBeneficiary().getId());
			motherDetail.setIsBeneficiary(true);
			beneficiaryFamilyDetailsRepository.save(motherDetail);
		} else {
			BeneficiaryFamilyDetails motherDetail = new BeneficiaryFamilyDetails();
			motherDetail.setBeneficiaryId(infant.getBeneficiary().getId());
			motherDetail.setMemberBeneficiaryId(mother.getBeneficiary().getId());
			motherDetail.setIsActive(true);
			motherDetail.setIsDelete(false);
			motherDetail.setIsBeneficiary(true);
			motherDetail.setRelationshipId(4);
			motherDetail.setCreatedTime(LocalDate.now());
			motherDetail.setFamilyUid("UID" + RandomUtils.nextDouble());
			beneficiaryFamilyDetailsRepository.save(motherDetail);
		}
		List<BeneficiaryFamilyDetails> mothersRelationToInfantDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(mother.getBeneficiary().getId(), infant.getBeneficiary().getId());
		if(!mothersRelationToInfantDetails.isEmpty()) {
			BeneficiaryFamilyDetails motherRelationToInfant = mothersRelationToInfantDetails.get(0);
			motherRelationToInfant.setIsBeneficiary(true);
			if(infant.getBeneficiary().getGenderId() == 1) {
				motherRelationToInfant.setRelationshipId(5);
			} else if (infant.getBeneficiary().getGenderId() == 2) {
				motherRelationToInfant.setRelationshipId(6);
			}
			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
		} else {
			BeneficiaryFamilyDetails motherRelationToInfant = new BeneficiaryFamilyDetails();
			motherRelationToInfant.setIsBeneficiary(true);
			motherRelationToInfant.setBeneficiaryId(mother.getBeneficiary().getId());
			motherRelationToInfant.setMemberBeneficiaryId(infant.getBeneficiary().getId());
			motherRelationToInfant.setIsActive(true);
			motherRelationToInfant.setIsDelete(false);
			if(infant.getBeneficiary().getGenderId() == 1) {
				motherRelationToInfant.setRelationshipId(5);
			} else if (infant.getBeneficiary().getGenderId() == 2) {
				motherRelationToInfant.setRelationshipId(6);
			}
			motherRelationToInfant.setCreatedTime(LocalDate.now());
			motherRelationToInfant.setFamilyUid("UID" + RandomUtils.nextDouble());
			beneficiaryFamilyDetailsRepository.save(motherRelationToInfant);
		}
    
    	
//    	beneficiary.setRelationshipRecordId(relationship.getRelationshipRecordId());
//    	beneficiary.setRelationshipType(relationship.getRelationshipType());
    	infant = ictcBeneficiaryService.save(infant);
    	return ictcBeneficiaryMapper.toDto(infant);
    }
    
    /**
     * Initiate ICTC follow up
     * 
     * @param followUpId followUpId
     * @return ICTCBeneficiaryDO
     */
    @Transactional
    public ICTCBeneficiaryDTO initiateIctcFollowUpVisit(Long followUpId, Long facilityId) {
    	Optional<ICTCFollowUp> optional = followUpService.find(followUpId);
    	if(!optional.isPresent()) {
    		throw new BadRequestAlertException("Invalid Follow Up Id", ENTITY_NAME, "Invalid");
    	}
    	ICTCFollowUp ictcFollowUp = optional.get();
    	ictcFollowUp.setIsActive(false);
    	ictcFollowUp.setIsCompleted(true);
    	followUpService.save(followUpMapper.toDto(ictcFollowUp));
    	ICTCBeneficiary ictcBeneficiary = ictcFollowUp.getIctcBeneficiary();
    	
    	ICTCVisitDTO visit = ictcVisitMapper.toDto(ictcFollowUp.getVisit());
    	visit.setId(null);
    	visit.setIsMultiFacilityService(false);
    	visit.setIctcBeneficiaryId(ictcBeneficiary.getId());
    	
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(ictcBeneficiary.getBeneficiary().getId(), 1, visit.getBeneficiaryStatus(), facilityId, null);
    	visit.setBeneficiaryStatus(1);
    	ictcBeneficiary.setBeneficiaryStatus(1);
    	
    	visit.setVisitDate(LocalDate.now());
    	visit.setIsActive(true);
    	visit.setIsDeleted(false);
    	visit = ictcVisitService.save(visit);
    	if(facilityId != null) {
    		updateBeneficiaryMultiFacilityLinking(ictcBeneficiary.getBeneficiary().getId(), facilityId, ictcBeneficiaryMapper.toDto(ictcBeneficiary), visit, ictcFollowUp.getIctcBeneficiary().getBeneficiary().getCategoryId());
    	}
    	
    	ICTCSampleCollectionDTO sample = new ICTCSampleCollectionDTO();
    	sample.setIctcBeneficiaryId(ictcBeneficiary.getId());
    	sample.setVisitId(visit.getId());
    	sample.setTestType(11);
    	sample.setIsActive(true);
		sample.setIsDeleted(false);
		sample.setCreatedTime(LocalDateTime.now());
		sample.setSampleCollectionDate(getCurrentTimeInIndia().toLocalDateTime());
		sample.setFacilityId(visit.getFacilityId());
    	
    	ICTCTestResultDTO result = new ICTCTestResultDTO();
    	result.setResultStatus(1);
    	result.setIctcBeneficiaryId(ictcBeneficiary.getId());
    	result.setVisitId(visit.getId());
    	result.setIsActive(true);
    	result.setIsDeleted(false);
    	
    	sample = ictcSampleCollectionService.save(sample);
    	result.setSampleId(sample.getId());
    	result = ictcTestResultService.save(result);
    	ictcBeneficiary.setCurrentTestResultId(result.getId());
    	ictcBeneficiary.setRecentVisitId(visit.getId());
    	return ictcBeneficiaryService.save(ictcBeneficiaryMapper.toDto(ictcBeneficiary));
    }

	/**
	 * Attend appointment
	 * @param ictcBeneficiaryId ictcBeneficiaryId
	 * @param appointmentId     appointmentId
	 * @param facilityId        facilityId
	 * @return ICTCBeneficiaryDO
	 */
	@Transactional
	public void attendAppointment(Long ictcBeneficiaryId, Long facilityId, Long appointmentId) {
		Optional<BeneficiaryAppointment> appointmentOptional = beneficiaryAppointmentRepository.findById(appointmentId);
		if (!appointmentOptional.isPresent()) {
			throw new BadRequestAlertException("Invalid Appointment Id", ENTITY_NAME, "INVALID_APPOINTMENT_ID");
		}
		beneficiaryAppointmentRepository.attendAppoinmentInIctc(appointmentId);
		Optional<ICTCBeneficiary> ictcBeneficiaryOptional = ictcBeneficiaryService.find(ictcBeneficiaryId);
		if (!ictcBeneficiaryOptional.isPresent()) {
			throw new BadRequestAlertException("Invalid IctcBeneficiary Id", ENTITY_NAME, "INVALID_ID");
		}
		ICTCBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
		if (ictcBeneficiary.getPid() == null) {
			throw new BadRequestAlertException("Invalid IctcBeneficiary Pid", ENTITY_NAME, "NO_PID");
		}
		if (ictcBeneficiary.getRecentVisitId() == null) {
			throw new BadRequestAlertException("Insufficient Data", ENTITY_NAME, "DATA_INSUFFICIENT");
		}
		Optional<ICTCVisit> optionalVisit = ictcVisitService.find(ictcBeneficiary.getRecentVisitId());
		if (!optionalVisit.isPresent()) {
			throw new BadRequestAlertException("Visit does not exist", ENTITY_NAME, "INVALID_VISIT");
		}

		ICTCVisitDTO visit = ictcVisitMapper.toDto(optionalVisit.get());

		visit.setId(null);
		visit.setIsMultiFacilityService(false);
		visit.setIctcBeneficiaryId(ictcBeneficiary.getId());

		beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(ictcBeneficiary.getBeneficiary().getId(),
				1, visit.getBeneficiaryStatus(), facilityId, null);
		visit.setBeneficiaryStatus(1);
		ictcBeneficiary.setBeneficiaryStatus(1);

		visit.setVisitDate(LocalDate.now());
		visit.setIsActive(true);
		visit.setIsDeleted(false);
		visit = ictcVisitService.save(visit);
		if (facilityId != null) {
			updateBeneficiaryMultiFacilityLinking(ictcBeneficiary.getBeneficiary().getId(), facilityId,
					ictcBeneficiaryMapper.toDto(ictcBeneficiary), visit,
					ictcBeneficiary.getBeneficiary().getCategoryId());
		}

//    	LabTestSample sample = new LabTestSample();//was previously DTO
//    	sample.setBeneficiary(new Beneficiary(ictcBeneficiary.getBeneficiary().getId()));
//    	sample.setIctcBeneficiary(new ICTCBeneficiary(ictcBeneficiary.getId()));
//    	sample.setVisit(new ICTCVisit(visit.getId()));
//		sample.setIsDelete(false);
//		sample.setCreatedTime(LocalDateTime.now());
//		sample.setSampleCollectedDate(getCurrentTimeInIndia().toLocalDateTime());
//		sample.setFacility(new Facility(visit.getFacilityId()));
//    	sample.setMasterResultStatus(1);
//    	sample.setTestTypeId(11);
//    	sample = labTestSampleService.save(sample);

		ICTCSampleCollectionDTO sample = new ICTCSampleCollectionDTO();
		sample.setIctcBeneficiaryId(ictcBeneficiary.getId());
		sample.setVisitId(visit.getId());
		sample.setIsActive(true);
		sample.setIsDeleted(false);
		sample.setFacilityId(visit.getFacilityId());
		sample.setTestType(11);
		sample.setCreatedTime(LocalDateTime.now());
		sample.setSampleCollectionDate(getCurrentTimeInIndia().toLocalDateTime());
		sample = ictcSampleCollectionService.save(sample);

		ICTCTestResultDTO result = new ICTCTestResultDTO();
		result.setResultStatus(1);
		result.setIctcBeneficiaryId(ictcBeneficiary.getId());
		result.setVisitId(visit.getId());
		result.setIsActive(true);
		result.setIsDeleted(false);
		result.setSampleId(sample.getId());
		result = ictcTestResultService.save(result);

		ictcBeneficiary.setCurrentTestResultId(result.getId());

//    	ictcBeneficiary.setCurrentTestResultId(sample.getId());
		ictcBeneficiary.setRecentVisitId(visit.getId());
		ictcBeneficiaryService.save(ictcBeneficiaryMapper.toDto(ictcBeneficiary));
	}

    /**
     * To update pregnancy follow up details
     * 
     * @param details details
     * @return
     */
    @Transactional
    public ICTCPregancyFollowUpDTO updatePregrancyFollowUpDetails(ICTCPregancyFollowUpDTO details) {
    	if(details.getVisitId() == null) {
    		throw new BadRequestAlertException("Visit Id is null", "", "Visit Id is null");
    	}
    	Optional<ICTCVisitDTO> visitOptional = ictcVisitService.findOne(details.getVisitId());
    	if(!visitOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid visitId", "", "Invalid visitId");
    	}
    	ICTCVisitDTO visit = visitOptional.get();
    	if(visit.getIsMultiFacilityService() == null) {
    		visit.setIsMultiFacilityService(false);
    	}
    	visit.setDeliveryOutcome(details.getDeliveryOutcome());
    	visit.setGravida(details.getGravida());
    	visit.setDeliveryDate(details.getDeliveryDate());
    	ictcVisitService.save(visit);
    	if(details.getFollowUps()!=null) {
    		List<ICTCFollowUpDTO> followUps = new ArrayList<>();
    		for (ICTCFollowUpDTO followUp : details.getFollowUps()) {
    			followUp.setCreatedTime(LocalDateTime.now());
    			followUp.setIsActive(true);
    			followUp.setIsDeleted(false);
    			if(details.getDeliveryDate() != null) {
    				followUp.setFollowUpDate(details.getDeliveryDate().plusWeeks(6));
    			} else {
    				followUp.setFollowUpDate(LocalDate.now().plusWeeks(6));
    			}
    			followUps.add(followUpService.save(followUp));
    		}
    		details.setFollowUps(followUps);
    	}
    	if(details.getFollowUpId() == null) {
    		throw new BadRequestAlertException("Invalid follow up id", "", "Invalid follow up id");
    	}
    	followUpRepository.markEntryAsInActiveAndCompleted(details.getFollowUpId());
    	return details;
    }
    
    /**
     * TO delete an ICTC beneficiary
     * 
     * @param beneficiaryDeleteDTO beneficiaryDeleteDTO details 
     */
    @Transactional
    public void deleteIctcBeneficiaryWithReason(IctcBeneficiaryDeleteDTO beneficiaryDeleteDTO) {
    	Optional<ICTCBeneficiary> ictcBeneficiaryOptional = ictcBeneficiaryService.find(beneficiaryDeleteDTO.getIctcBeneficiaryId());
    	if(!ictcBeneficiaryOptional.isPresent()) {
    		throw new BadRequestAlertException("Invalid follow up id", "", "INVALID_ICTC_BENEFICIARY");
    	}
    	ICTCBeneficiary ictcBeneficiary = ictcBeneficiaryOptional.get();
    	ictcBeneficiary.setIsActive(false);
    	ictcBeneficiary.setIsDeleted(true);
    	ictcBeneficiary.setDeleteReason(beneficiaryDeleteDTO.getDeletedReason());
    	ictcBeneficiary.setDeleteReasonComment(beneficiaryDeleteDTO.getDeletedReasonComment());
    	ictcBeneficiaryService.save(ictcBeneficiary);
    }
    
    private ZonedDateTime getCurrentTimeInIndia() {
    	ZonedDateTime currentTime = ZonedDateTime.now();
    	ZoneId india = ZoneId.of("Asia/Kolkata");
    	currentTime = currentTime.withZoneSameInstant(india);
    	return currentTime;
    }
    
    private void updateBeneficiaryMultiFacilityLinking(Long beneficiaryId, Long facilityId, ICTCBeneficiaryDTO ictcBeneficiary, ICTCVisitDTO visit, Integer category) {
    	List<BeneficiaryMultiFacilityService> list = beneficiaryMultiFacilityServiceRepository.findAllByBeneficiaryIdAndVisitedFacilityId(beneficiaryId, facilityId);
    	if(list.isEmpty()) {
    		BeneficiaryMultiFacilityService beneficiaryMultiFacilityService = new BeneficiaryMultiFacilityService();
    		if(category == 1) {
    			beneficiaryMultiFacilityService.setIsIctcPostTestCounsellingCompleted(true);
    		} else if(ictcBeneficiary.getBeneficiaryStatus() == 1 || ictcBeneficiary.getBeneficiaryStatus() == 2 || ictcBeneficiary.getBeneficiaryStatus() == 4) {
    			beneficiaryMultiFacilityService.setIsIctcPostTestCounsellingCompleted(false);
    		}
    		beneficiaryMultiFacilityService.setBeneficiaryId(beneficiaryId);
    		beneficiaryMultiFacilityService.setIctcVisitId(visit.getId());
    		beneficiaryMultiFacilityService.setRegisteredFacilityId(ictcBeneficiary.getFacilityId());
    		beneficiaryMultiFacilityService.setVisitedFacilityId(facilityId);
    		beneficiaryMultiFacilityService.setVisitDate(LocalDate.now());
    		beneficiaryMultiFacilityService.setCreatedBy(facilityId);
    		beneficiaryMultiFacilityService.setCreatedTime(LocalDateTime.now());
    		beneficiaryMultiFacilityService.setIsActive(true);
    		beneficiaryMultiFacilityService.setIsDeleted(false);
    		beneficiaryMultiFacilityServiceRepository.save(beneficiaryMultiFacilityService);
    		if(!ictcBeneficiary.getFacilityId().equals(facilityId)) {
	    		visit.setIsMultiFacilityService(true);
	    		ictcVisitService.save(visit);
    		}
    	} else {
    		BeneficiaryMultiFacilityService beneficiaryMultiFacilityService = list.get(0);
    		if(category != 1 && (ictcBeneficiary.getBeneficiaryStatus() == 1 || ictcBeneficiary.getBeneficiaryStatus() == 2 || ictcBeneficiary.getBeneficiaryStatus() == 4)) {
    			beneficiaryMultiFacilityService.setIsIctcPostTestCounsellingCompleted(false);
    			beneficiaryMultiFacilityServiceRepository.save(beneficiaryMultiFacilityService);
    		} else if(category != 1 && !(ictcBeneficiary.getBeneficiaryStatus() == 1 || ictcBeneficiary.getBeneficiaryStatus() == 2 || ictcBeneficiary.getBeneficiaryStatus() == 4)) {
    			beneficiaryMultiFacilityService.setIsIctcPostTestCounsellingCompleted(true);
    			beneficiaryMultiFacilityServiceRepository.save(beneficiaryMultiFacilityService);
    		}
    	}
	}

	public Boolean getRegistrationBackDateStatus() {
		return registrationBackDateStatusFromJanuary;
	}
}
