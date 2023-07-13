package gov.naco.soch.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.service.AddressService;
import gov.naco.soch.service.BeneficiaryFacilityMappingService;
import gov.naco.soch.service.BeneficiaryReferralService;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.FictcBeneficiaryService;
import gov.naco.soch.service.FictcGeneralService;
import gov.naco.soch.service.dto.AddressDTO;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.dto.BeneficiaryFacilityMappingDTO;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;
import gov.naco.soch.service.dto.FictcBeneficiaryCreateDTO;
import gov.naco.soch.service.dto.FictcBeneficiaryDTO;

@Service
public class FictcGeneralServiceImpl implements FictcGeneralService {

	@Autowired
	private BeneficiaryService beneficiaryService;

	@Autowired
	private BeneficiaryReferralService referralService;

	@Autowired
	private FictcBeneficiaryService fictcBeneficiaryService;

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private BeneficiaryFacilityMappingService beneficiaryFacilityMappingService;

	@Transactional
	public FictcBeneficiaryCreateDTO createBeneficiaryAndInitiateReferral(FictcBeneficiaryCreateDTO details) {
		if(details.getId() == null) {
		AddressDTO address = new AddressDTO();
		address.setAddressLineOne(details.getAddressLineOne());
		address.setAddressLineTwo(details.getAddressLineTwo());
		address.setStateId(details.getStateId());
		address.setDistrictId(details.getDistrictId());
		address.setPincode(details.getPincode());
		address.setIsActive(true);
		address.setIsDelete(false);
		address = addressService.save(address);

		BeneficiaryDTO beneficiary = new BeneficiaryDTO();
		beneficiary.setAddressId(address.getId());
		beneficiary.setFirstName(details.getFirstName());
		beneficiary.setMiddleName(details.getMiddleName());
		beneficiary.setLastName(details.getLastName());
		beneficiary.setMobileNumber(details.getMobileNumber());
		beneficiary.setCategoryId(details.getCategoryId());
		beneficiary.setGenderId(details.getGenderId());
		beneficiary.setDateOfBirth(details.getDateOfBirth());
		beneficiary.setAge(details.getAge());
		beneficiary.setRegDate(getCurrentTimeInIndia().toLocalDate());
		beneficiary.setIsActive(true);
    	beneficiary.setIsDelete(false);
    	beneficiary = beneficiaryService.save(beneficiary);
    	
    	beneficiary.setUid(beneficiaryService.generateUid(beneficiary.getId()));
    	
    	beneficiary = beneficiaryService.save(beneficiary);
    	
    	details.setBeneficiaryId(beneficiary.getId());
    	
    	FictcBeneficiaryDTO fictcBeneficiary = new FictcBeneficiaryDTO();
    	fictcBeneficiary.setIsPregnant(details.isPregnant());
    	fictcBeneficiary.setPregnancyTypeId(details.getPregnancyTypeId());
    	fictcBeneficiary.setIsActive(true);
    	fictcBeneficiary.setIsDelete(false);
    	fictcBeneficiary.setBeneficiaryId(beneficiary.getId());
    	fictcBeneficiary.setFacilityId(details.getFacilityId());
    	fictcBeneficiary.setHivScreeningDate(details.getHivScreeningDate());
    	fictcBeneficiary.setProfileStatus(details.getProfileStatus());
    	fictcBeneficiary.setPnc(details.getPnc());
    	fictcBeneficiary = fictcBeneficiaryService.save(fictcBeneficiary);
    	details.setFictcBeneficiaryId(fictcBeneficiary.getId());
    	details.setId(fictcBeneficiary.getId());
    	
    	if(details.getProfileStatus()) {
	    	BeneficiaryReferralDTO referral = new BeneficiaryReferralDTO();
	    	referral.setBeneficiaryId(beneficiary.getId());
	    	referral.setIsActive(true);
	    	referral.setIsDelete(false);
	    	referral.setReferralStatusId(1);
	    	referral.setReferDate(getCurrentTimeInIndia().toLocalDate());
	    	referral.setCreatedTime(getCurrentTimeInIndia().toLocalDateTime());
	    	referral.setReferedFrom(details.getFacilityId());
	    	referral.setReferedTo(details.getReferredToIctcFacilityId());
	    	referral = referralService.save(referral);
	    	details.setReferralId(referral.getId());
    	
    	
	    	BeneficiaryFacilityMappingDTO beneficiaryFacilityMapping = new BeneficiaryFacilityMappingDTO();
	    	beneficiaryFacilityMapping.setBeneficiaryId(beneficiary.getId());
	    	beneficiaryFacilityMapping.setFacilityId(details.getFacilityId());
	    	beneficiaryFacilityMapping.setCreatedTime(LocalDate.now());
	    	beneficiaryFacilityMapping.setIsActive(true);
	    	beneficiaryFacilityMapping.setIsDelete(false);
	    	beneficiaryFacilityMapping.setMappingDate(LocalDate.now());
	    	beneficiaryFacilityMappingService.save(beneficiaryFacilityMapping);
    	}
		}else {
			FictcBeneficiaryDTO fictcBeneficiary = fictcBeneficiaryService.findOne(details.getId()).get();
			
			BeneficiaryDTO beneficiary = beneficiaryService.findOne(fictcBeneficiary.getBeneficiaryId()).get();
			AddressDTO address =addressService.findOne(beneficiary.getAddressId()).get();
			address.setId(address.getId());
			address.setAddressLineOne(details.getAddressLineOne());
			address.setAddressLineTwo(details.getAddressLineTwo());
			address.setStateId(details.getStateId());
			address.setDistrictId(details.getDistrictId());
			address.setPincode(details.getPincode());
			address.setIsActive(true);
			address.setIsDelete(false);
			address = addressService.save(address);

			beneficiary.setId(beneficiary.getId());
			beneficiary.setAddressId(address.getId());
			beneficiary.setFirstName(details.getFirstName());
			beneficiary.setMiddleName(details.getMiddleName());
			beneficiary.setLastName(details.getLastName());
			beneficiary.setMobileNumber(details.getMobileNumber());
			beneficiary.setCategoryId(details.getCategoryId());
			beneficiary.setGenderId(details.getGenderId());
			beneficiary.setDateOfBirth(details.getDateOfBirth());
			beneficiary.setAge(details.getAge());
			//beneficiary.setRegDate(getCurrentTimeInIndia().toLocalDate());
			beneficiary.setIsActive(true);
	    	beneficiary.setIsDelete(false);
	    	beneficiary = beneficiaryService.save(beneficiary);
	    	
	    	//beneficiary.setUid(beneficiaryService.generateUid(beneficiary.getId()));
	    	
	    	//beneficiary = beneficiaryService.save(beneficiary);
	    	
	    	//details.setBeneficiaryId(beneficiary.getId());
	    	
	    	
	    	fictcBeneficiary.setIsPregnant(details.isPregnant());
	    	fictcBeneficiary.setPregnancyTypeId(details.getPregnancyTypeId());
	    	fictcBeneficiary.setIsActive(true);
	    	fictcBeneficiary.setIsDelete(false);
	    	fictcBeneficiary.setBeneficiaryId(beneficiary.getId());
	    	fictcBeneficiary.setFacilityId(details.getFacilityId());
	    	fictcBeneficiary.setHivScreeningDate(details.getHivScreeningDate());
	    	fictcBeneficiary.setProfileStatus(details.getProfileStatus());
	    	fictcBeneficiary.setPnc(details.getPnc());
	    	fictcBeneficiary = fictcBeneficiaryService.save(fictcBeneficiary);
	    	details.setFictcBeneficiaryId(fictcBeneficiary.getId());
	    	details.setId(fictcBeneficiary.getId());
	    	if(details.getProfileStatus()) {
		    	BeneficiaryReferralDTO referral = new BeneficiaryReferralDTO();
		    	referral.setBeneficiaryId(beneficiary.getId());
		    	referral.setIsActive(true);
		    	referral.setIsDelete(false);
		    	referral.setReferralStatusId(1);
		    	referral.setReferDate(getCurrentTimeInIndia().toLocalDate());
		    	referral.setCreatedTime(getCurrentTimeInIndia().toLocalDateTime());
		    	referral.setReferedFrom(details.getFacilityId());
		    	referral.setReferedTo(details.getReferredToIctcFacilityId());
		    	referral = referralService.save(referral);
		    	details.setReferralId(referral.getId());
	    	
	    	
		    	BeneficiaryFacilityMappingDTO beneficiaryFacilityMapping = new BeneficiaryFacilityMappingDTO();
		    	beneficiaryFacilityMapping.setBeneficiaryId(beneficiary.getId());
		    	beneficiaryFacilityMapping.setFacilityId(details.getFacilityId());
		    	beneficiaryFacilityMapping.setCreatedTime(LocalDate.now());
		    	beneficiaryFacilityMapping.setIsActive(true);
		    	beneficiaryFacilityMapping.setIsDelete(false);
		    	beneficiaryFacilityMapping.setMappingDate(LocalDate.now());
		    	beneficiaryFacilityMappingService.save(beneficiaryFacilityMapping);
	    	}
		}
    	
		return details;
	}

	private ZonedDateTime getCurrentTimeInIndia() {
		ZonedDateTime currentTime = ZonedDateTime.now();
		ZoneId india = ZoneId.of("Asia/Kolkata");
		currentTime = currentTime.withZoneSameInstant(india);
		return currentTime;
	}
}
