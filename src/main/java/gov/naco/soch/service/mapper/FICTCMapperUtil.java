	package gov.naco.soch.service.mapper;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.naco.soch.domain.FICTCMonthlyReportEntity;
import gov.naco.soch.service.dto.FICTCMonthlyReportRequestDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportResponseDto;

public class FICTCMapperUtil {

	private final static Logger log = LoggerFactory.getLogger(FICTCMapperUtil.class);
	
//	public static FictcBeneficiary mapFictcBeneficiaryRequestToEntity(FICTCBeneficiaryRequestDto fictcBeneficiaryRequestDto, Long id) {
//		FictcBeneficiary fictcBeneficiaryEntity = new FictcBeneficiary();
//		fictcBeneficiaryEntity.setProfileStatus(true);
//		if (fictcBeneficiaryRequestDto.getUserAction().equalsIgnoreCase("save")) {
//			fictcBeneficiaryEntity.setProfileStatus(false);
//		} 
//
//		fictcBeneficiaryEntity.setFirstName(fictcBeneficiaryRequestDto.getFirstName());
//		fictcBeneficiaryEntity.setLastName(fictcBeneficiaryRequestDto.getLastName());
//		fictcBeneficiaryEntity.setAddressLineOne(fictcBeneficiaryRequestDto.getAddressLineOne());
//		fictcBeneficiaryEntity.setAddressLineTwo(fictcBeneficiaryRequestDto.getAddressLineTwo());
//		fictcBeneficiaryEntity.setMobileNumber(fictcBeneficiaryRequestDto.getMobileNumber());
//		fictcBeneficiaryEntity.setAge(fictcBeneficiaryRequestDto.getAge());
//		fictcBeneficiaryEntity.setDateOfBirth(fictcBeneficiaryRequestDto.getDateOfBirth());
//		fictcBeneficiaryEntity.setMiddleName(fictcBeneficiaryRequestDto.getMiddleName());
//		fictcBeneficiaryEntity.setGender(fictcBeneficiaryRequestDto.getGender());
//		fictcBeneficiaryEntity.setReferredTo(fictcBeneficiaryRequestDto.getReferredTo());
//		fictcBeneficiaryEntity.setReferredFrom(fictcBeneficiaryRequestDto.getReferredFrom());
//		fictcBeneficiaryEntity.setPregnancyStatus(fictcBeneficiaryRequestDto.getPregnancyStatus());
//		fictcBeneficiaryEntity.setState(fictcBeneficiaryRequestDto.getState());
//		fictcBeneficiaryEntity.setDistrict(fictcBeneficiaryRequestDto.getDistrict());
//		fictcBeneficiaryEntity.setPinCode(fictcBeneficiaryRequestDto.getPinCode());
//		fictcBeneficiaryEntity.setPregnant(fictcBeneficiaryRequestDto.isPregnant());
//		
//		fictcBeneficiaryEntity.setHivScreeningDate(fictcBeneficiaryRequestDto.getHivScreeningDate());
//		
//		fictcBeneficiaryEntity.setCreatedBy(id);
//		fictcBeneficiaryEntity.setCreatedTime(LocalDateTime.now());
//		fictcBeneficiaryEntity.setModifiedBy(id);
//		fictcBeneficiaryEntity.setModifiedTime(LocalDateTime.now());
//		if(fictcBeneficiaryRequestDto.getId() != null) {
//			fictcBeneficiaryEntity.setId(fictcBeneficiaryRequestDto.getId());
//		}
//		
//		return fictcBeneficiaryEntity;
//	}

	
	public static FICTCMonthlyReportEntity mapMonthlyReportRequestToEntity(
			FICTCMonthlyReportRequestDto fictcMonthlyReportReqDto, Long id) {
		FICTCMonthlyReportEntity fictcMonthlyReportEntity = new FICTCMonthlyReportEntity();
		
		fictcMonthlyReportEntity.setFacilityId(fictcMonthlyReportReqDto.getFacilityId());
		fictcMonthlyReportEntity.setReportSubmitStatus(true);
		if (fictcMonthlyReportReqDto.getUserAction().equalsIgnoreCase("save")) {
			fictcMonthlyReportEntity.setReportSubmitStatus(false);
		}
		// Page1
		fictcMonthlyReportEntity.setPrtcAncCount(fictcMonthlyReportReqDto.getPrtcAncCount());
		fictcMonthlyReportEntity.setPrtcDirectInLabour(fictcMonthlyReportReqDto.getPrtcDirectInLabour());
		fictcMonthlyReportEntity.setPrtcFemaleClients(fictcMonthlyReportReqDto.getPrtcFemaleClients());
		fictcMonthlyReportEntity.setPrtcMaleClients(fictcMonthlyReportReqDto.getPrtcMaleClients());
		fictcMonthlyReportEntity.setPrtcTgClients(fictcMonthlyReportReqDto.getPrtcTgClients());

		// Page2
		fictcMonthlyReportEntity.settHivAncCount(fictcMonthlyReportReqDto.gettHivAncCount());
		fictcMonthlyReportEntity.settHivDirectInLabour(fictcMonthlyReportReqDto.gettHivDirectInLabour());
		fictcMonthlyReportEntity.settHivFemaleClients(fictcMonthlyReportReqDto.gettHivFemaleClients());
		fictcMonthlyReportEntity.settHivMaleClients(fictcMonthlyReportReqDto.gettHivMaleClients());
		fictcMonthlyReportEntity.settHivTgClients(fictcMonthlyReportReqDto.gettHivTgClients());

		// Page3
		fictcMonthlyReportEntity.setPotcAncCount(fictcMonthlyReportReqDto.getPotcAncCount());
		fictcMonthlyReportEntity.setPotcDirectInLabour(fictcMonthlyReportReqDto.getPotcDirectInLabour());
		fictcMonthlyReportEntity.setPotcMaleClients(fictcMonthlyReportReqDto.getPotcMaleClients());
		fictcMonthlyReportEntity.setPotcFemaleClients(fictcMonthlyReportReqDto.getPotcFemaleClients());
		fictcMonthlyReportEntity.setPotcTgClients(fictcMonthlyReportReqDto.getPotcTgClients());

		// Page4
		fictcMonthlyReportEntity.setHivReactiveAncCount(fictcMonthlyReportReqDto.getHivReactiveAncCount());
		fictcMonthlyReportEntity
				.setHivReactiveDirectInLabour(fictcMonthlyReportReqDto.getHivReactiveDirectInLabour());
		fictcMonthlyReportEntity.setHivReactiveFemaleClients(fictcMonthlyReportReqDto.getHivReactiveFemaleClients());
		fictcMonthlyReportEntity.setHivReactiveMaleClients(fictcMonthlyReportReqDto.getHivReactiveMaleClients());
		fictcMonthlyReportEntity.setHivReactiveTgClients(fictcMonthlyReportReqDto.getHivReactiveTgClients());

		// Page5
		fictcMonthlyReportEntity.setAncClientsRegistered(fictcMonthlyReportReqDto.getAncClientsRegistered());
		fictcMonthlyReportEntity.setAncClientsTested(fictcMonthlyReportReqDto.getAncClientsTested());
		fictcMonthlyReportEntity.setAncClientsReactive(fictcMonthlyReportReqDto.getAncClientsReactive());

		// Page6
		fictcMonthlyReportEntity.setHivKitName(fictcMonthlyReportReqDto.getHivKitName());
		fictcMonthlyReportEntity.setHivBatchNumber(fictcMonthlyReportReqDto.getHivBatchNumber());
		fictcMonthlyReportEntity.setHivExpiryDate(fictcMonthlyReportReqDto.getHivExpiryDate());
		fictcMonthlyReportEntity.setHivOpeningStock(fictcMonthlyReportReqDto.getHivOpeningStock());
		fictcMonthlyReportEntity.setHivReceivedQuantity(fictcMonthlyReportReqDto.getHivReceivedQuantity());
		fictcMonthlyReportEntity.setHivConsumedQuantity(fictcMonthlyReportReqDto.getHivConsumedQuantity());
		fictcMonthlyReportEntity.setHivControlQuantity(fictcMonthlyReportReqDto.getHivControlQuantity());
		fictcMonthlyReportEntity.setHivWastageQuantity(fictcMonthlyReportReqDto.getHivWastageQuantity());
		fictcMonthlyReportEntity.setHivQuantityIndent(fictcMonthlyReportReqDto.getHivQuantityIndent());

		fictcMonthlyReportEntity.setBloodKitName(fictcMonthlyReportReqDto.getBloodKitName());
		fictcMonthlyReportEntity.setBloodBatchNumber(fictcMonthlyReportReqDto.getBloodBatchNumber());
		fictcMonthlyReportEntity.setBloodExpiryDate(fictcMonthlyReportReqDto.getBloodExpiryDate());
		fictcMonthlyReportEntity.setBloodOpeningStock(fictcMonthlyReportReqDto.getBloodOpeningStock());
		fictcMonthlyReportEntity.setBloodReceivedQuantity(fictcMonthlyReportReqDto.getBloodReceivedQuantity());
		fictcMonthlyReportEntity.setBloodConsumedQuantity(fictcMonthlyReportReqDto.getBloodConsumedQuantity());
		fictcMonthlyReportEntity.setBloodQuantityIndent(fictcMonthlyReportReqDto.getBloodQuantityIndent());
		fictcMonthlyReportEntity.setBloodWastageQuantity(fictcMonthlyReportReqDto.getBloodWastageQuantity());

		// Page7
		fictcMonthlyReportEntity.setLinkWorkerInreferral(fictcMonthlyReportReqDto.getLinkWorkerInreferral());
		fictcMonthlyReportEntity.setLinkWorkerOutreferral(fictcMonthlyReportReqDto.getLinkWorkerOutreferral());
		fictcMonthlyReportEntity.setObgGynInreferral(fictcMonthlyReportReqDto.getObgGynInreferral());
		fictcMonthlyReportEntity.setObgGynOutreferral(fictcMonthlyReportReqDto.getObgGynOutreferral());
		fictcMonthlyReportEntity.setOtherInreferral(fictcMonthlyReportReqDto.getOtherInreferral());
		fictcMonthlyReportEntity.setOtherOutreferral(fictcMonthlyReportReqDto.getOtherOutreferral());
		fictcMonthlyReportEntity.setRnctpInreferral(fictcMonthlyReportReqDto.getRnctpInreferral());
		fictcMonthlyReportEntity.setRnctpOutreferral(fictcMonthlyReportReqDto.getRnctpOutreferral());
		fictcMonthlyReportEntity.setSticClinicInreferral(fictcMonthlyReportReqDto.getSticClinicInreferral());
		fictcMonthlyReportEntity.setSticClinicOutreferral(fictcMonthlyReportReqDto.getSticClinicOutreferral());
		fictcMonthlyReportEntity.setTiNgosInreferral(fictcMonthlyReportReqDto.getTiNgosInreferral());
		fictcMonthlyReportEntity.setTiNgosOutreferral(fictcMonthlyReportReqDto.getTiNgosOutreferral());

		// Page8
		fictcMonthlyReportEntity
				.setDiagnosedStiRtiMale(fictcMonthlyReportReqDto.getDiagnosedStiRtiMale());
		fictcMonthlyReportEntity
				.setDiagnosedStiRtiFemale(fictcMonthlyReportReqDto.getDiagnosedStiRtiFemale());

		fictcMonthlyReportEntity.setTestedForSyphillisMale(fictcMonthlyReportReqDto.getTestedForSyphillisMale());
		fictcMonthlyReportEntity.setTestedForSyphillisFemale(fictcMonthlyReportReqDto.getTestedForSyphillisFemale());

		fictcMonthlyReportEntity.setReactiveForSyphillisMale(fictcMonthlyReportReqDto.getReactiveForSyphillisMale());
		fictcMonthlyReportEntity
				.setReactiveForSyphillisFemale(fictcMonthlyReportReqDto.getReactiveForSyphillisFemale());

		fictcMonthlyReportEntity.setAvailabilityDrugType(fictcMonthlyReportReqDto.getAvailabilityDrugType());

		fictcMonthlyReportEntity.setReportMonth(fictcMonthlyReportReqDto.getReportMonth());
		fictcMonthlyReportEntity.setReportYear(fictcMonthlyReportReqDto.getReportYear());
		
		//meta-columns
		fictcMonthlyReportEntity.setCreatedBy(id);
		fictcMonthlyReportEntity.setCreatedTime(LocalDateTime.now());
		fictcMonthlyReportEntity.setModifiedBy(id);
		fictcMonthlyReportEntity.setModifiedTime(LocalDateTime.now());
		if(fictcMonthlyReportReqDto.getId() != null) {
			fictcMonthlyReportEntity.setId(fictcMonthlyReportReqDto.getId());
		}
		
		return fictcMonthlyReportEntity;
	}
	
	public static FICTCMonthlyReportResponseDto mapEntityToMonthlyReportResponse(
			FICTCMonthlyReportEntity fictcMonthlyReportEntity) {
		FICTCMonthlyReportResponseDto fictcMonthlyReportRespDto = new FICTCMonthlyReportResponseDto();
		
		fictcMonthlyReportRespDto.setId(fictcMonthlyReportEntity.getId());
		
		fictcMonthlyReportRespDto.setFacilityId(fictcMonthlyReportEntity.getFacilityId());
		fictcMonthlyReportRespDto.setReportSubmitStatus(fictcMonthlyReportEntity.getReportSubmitStatus());
		
		// Page1
		fictcMonthlyReportRespDto.setPrtcAncCount(fictcMonthlyReportEntity.getPrtcAncCount());
		fictcMonthlyReportRespDto.setPrtcDirectInLabour(fictcMonthlyReportEntity.getPrtcDirectInLabour());
		fictcMonthlyReportRespDto.setPrtcFemaleClients(fictcMonthlyReportEntity.getPrtcFemaleClients());
		fictcMonthlyReportRespDto.setPrtcMaleClients(fictcMonthlyReportEntity.getPrtcMaleClients());
		fictcMonthlyReportRespDto.setPrtcTgClients(fictcMonthlyReportEntity.getPrtcTgClients());

		// Page2
		fictcMonthlyReportRespDto.settHivAncCount(fictcMonthlyReportEntity.gettHivAncCount());
		fictcMonthlyReportRespDto.settHivDirectInLabour(fictcMonthlyReportEntity.gettHivDirectInLabour());
		fictcMonthlyReportRespDto.settHivFemaleClients(fictcMonthlyReportEntity.gettHivFemaleClients());
		fictcMonthlyReportRespDto.settHivMaleClients(fictcMonthlyReportEntity.gettHivMaleClients());
		fictcMonthlyReportRespDto.settHivTgClients(fictcMonthlyReportEntity.gettHivTgClients());

		// Page3
		fictcMonthlyReportRespDto.setPotcAncCount(fictcMonthlyReportEntity.getPotcAncCount());
		fictcMonthlyReportRespDto.setPotcDirectInLabour(fictcMonthlyReportEntity.getPotcDirectInLabour());
		fictcMonthlyReportRespDto.setPotcMaleClients(fictcMonthlyReportEntity.getPotcMaleClients());
		fictcMonthlyReportRespDto.setPotcFemaleClients(fictcMonthlyReportEntity.getPotcFemaleClients());
		fictcMonthlyReportRespDto.setPotcTgClients(fictcMonthlyReportEntity.getPotcTgClients());

		// Page4
		fictcMonthlyReportRespDto.setHivReactiveAncCount(fictcMonthlyReportEntity.getHivReactiveAncCount());
		fictcMonthlyReportRespDto
				.setHivReactiveDirectInLabour(fictcMonthlyReportEntity.getHivReactiveDirectInLabour());
		fictcMonthlyReportRespDto.setHivReactiveFemaleClients(fictcMonthlyReportEntity.getHivReactiveFemaleClients());
		fictcMonthlyReportRespDto.setHivReactiveMaleClients(fictcMonthlyReportEntity.getHivReactiveMaleClients());
		fictcMonthlyReportRespDto.setHivReactiveTgClients(fictcMonthlyReportEntity.getHivReactiveTgClients());

		// Page5
		fictcMonthlyReportRespDto.setAncClientsRegistered(fictcMonthlyReportEntity.getAncClientsRegistered());
		fictcMonthlyReportRespDto.setAncClientsTested(fictcMonthlyReportEntity.getAncClientsTested());
		fictcMonthlyReportRespDto.setAncClientsReactive(fictcMonthlyReportEntity.getAncClientsReactive());

		// Page6
		fictcMonthlyReportRespDto.setHivKitName(fictcMonthlyReportEntity.getHivKitName());
		fictcMonthlyReportRespDto.setHivBatchNumber(fictcMonthlyReportEntity.getHivBatchNumber());
		fictcMonthlyReportRespDto.setHivExpiryDate(fictcMonthlyReportEntity.getHivExpiryDate());
		fictcMonthlyReportRespDto.setHivOpeningStock(fictcMonthlyReportEntity.getHivOpeningStock());
		fictcMonthlyReportRespDto.setHivReceivedQuantity(fictcMonthlyReportEntity.getHivReceivedQuantity());
		fictcMonthlyReportRespDto.setHivConsumedQuantity(fictcMonthlyReportEntity.getHivConsumedQuantity());
		fictcMonthlyReportRespDto.setHivControlQuantity(fictcMonthlyReportEntity.getHivControlQuantity());
		fictcMonthlyReportRespDto.setHivWastageQuantity(fictcMonthlyReportEntity.getHivWastageQuantity());
		fictcMonthlyReportRespDto.setHivQuantityIndent(fictcMonthlyReportEntity.getHivQuantityIndent());

		fictcMonthlyReportRespDto.setBloodKitName(fictcMonthlyReportEntity.getBloodKitName());
		fictcMonthlyReportRespDto.setBloodBatchNumber(fictcMonthlyReportEntity.getBloodBatchNumber());
		fictcMonthlyReportRespDto.setBloodExpiryDate(fictcMonthlyReportEntity.getBloodExpiryDate());
		fictcMonthlyReportRespDto.setBloodOpeningStock(fictcMonthlyReportEntity.getBloodOpeningStock());
		fictcMonthlyReportRespDto.setBloodReceivedQuantity(fictcMonthlyReportEntity.getBloodReceivedQuantity());
		fictcMonthlyReportRespDto.setBloodConsumedQuantity(fictcMonthlyReportEntity.getBloodConsumedQuantity());
		fictcMonthlyReportRespDto.setBloodQuantityIndent(fictcMonthlyReportEntity.getBloodQuantityIndent());
		fictcMonthlyReportRespDto.setBloodWastageQuantity(fictcMonthlyReportEntity.getBloodWastageQuantity());

		// Page7
		fictcMonthlyReportRespDto.setLinkWorkerInreferral(fictcMonthlyReportEntity.getLinkWorkerInreferral());
		fictcMonthlyReportRespDto.setLinkWorkerOutreferral(fictcMonthlyReportEntity.getLinkWorkerOutreferral());
		fictcMonthlyReportRespDto.setObgGynInreferral(fictcMonthlyReportEntity.getObgGynInreferral());
		fictcMonthlyReportRespDto.setObgGynOutreferral(fictcMonthlyReportEntity.getObgGynOutreferral());
		fictcMonthlyReportRespDto.setOtherInreferral(fictcMonthlyReportEntity.getOtherInreferral());
		fictcMonthlyReportRespDto.setOtherOutreferral(fictcMonthlyReportEntity.getOtherOutreferral());
		fictcMonthlyReportRespDto.setRnctpInreferral(fictcMonthlyReportEntity.getRnctpInreferral());
		fictcMonthlyReportRespDto.setRnctpOutreferral(fictcMonthlyReportEntity.getRnctpOutreferral());
		fictcMonthlyReportRespDto.setSticClinicInreferral(fictcMonthlyReportEntity.getSticClinicInreferral());
		fictcMonthlyReportRespDto.setSticClinicOutreferral(fictcMonthlyReportEntity.getSticClinicOutreferral());
		fictcMonthlyReportRespDto.setTiNgosInreferral(fictcMonthlyReportEntity.getTiNgosInreferral());
		fictcMonthlyReportRespDto.setTiNgosOutreferral(fictcMonthlyReportEntity.getTiNgosOutreferral());

		// Page8
		fictcMonthlyReportRespDto
				.setDiagnosedStiRtiMale(fictcMonthlyReportEntity.getDiagnosedStiRtiMale());
		fictcMonthlyReportRespDto
				.setDiagnosedStiRtiFemale(fictcMonthlyReportEntity.getDiagnosedStiRtiFemale());

		fictcMonthlyReportRespDto.setTestedForSyphillisMale(fictcMonthlyReportEntity.getTestedForSyphillisMale());
		fictcMonthlyReportRespDto.setTestedForSyphillisFemale(fictcMonthlyReportEntity.getTestedForSyphillisFemale());

		fictcMonthlyReportRespDto.setReactiveForSyphillisMale(fictcMonthlyReportEntity.getReactiveForSyphillisMale());
		fictcMonthlyReportRespDto
				.setReactiveForSyphillisFemale(fictcMonthlyReportEntity.getReactiveForSyphillisFemale());

		fictcMonthlyReportRespDto.setAvailabilityDrugType(fictcMonthlyReportEntity.getAvailabilityDrugType());

		fictcMonthlyReportRespDto.setReportYear(fictcMonthlyReportEntity.getReportYear());
		fictcMonthlyReportRespDto.setReportMonth(fictcMonthlyReportEntity.getReportMonth());
		
		//meta-columns
		fictcMonthlyReportRespDto.setCreatedBy(fictcMonthlyReportEntity.getCreatedBy());
		fictcMonthlyReportRespDto.setCreatedTime(fictcMonthlyReportEntity.getCreatedTime());
		fictcMonthlyReportRespDto.setModifiedBy(fictcMonthlyReportEntity.getModifiedBy());
		fictcMonthlyReportRespDto.setModifiedTime(fictcMonthlyReportEntity.getModifiedTime());
		
		
		return fictcMonthlyReportRespDto;
	}
}