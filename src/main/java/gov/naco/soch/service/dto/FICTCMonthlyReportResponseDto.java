package gov.naco.soch.service.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

/**
 * A DTO for the fictcmonthlyreport entity.
 */
public class FICTCMonthlyReportResponseDto {
	private Long id;
	private Integer facilityId;

	//Page1 pre-test counselling
	private Integer prtcAncCount;
	private Integer prtcDirectInLabour;
	private Integer prtcMaleClients;
	private Integer prtcFemaleClients;
	private Integer prtcTgClients;
	private Integer prtcPncCount;

	//Page2 - t is for tested
	private Integer tHivAncCount;
	private Integer tHivDirectInLabour;
	private Integer tHivMaleClients;
	private Integer tHivFemaleClients;
	private Integer tHivTgClients;
	private Integer tHivPncCount;
	
	//Page3 post-test counselling
	private Integer potcAncCount;
	private Integer potcDirectInLabour;
	private Integer potcMaleClients;
	private Integer potcFemaleClients;
	private Integer potcTgClients;
	private Integer potcPncCount;

	
	//Page4 No. of clients detected HIV reactive
	private Integer hivReactiveAncCount;
	private Integer hivReactiveDirectInLabour;
	private Integer hivReactiveMaleClients;
	private Integer hivReactiveFemaleClients;
	private Integer hivReactiveTgClients;
	private Integer hivReactivePncCount;
	private Integer linkedSaIctcAncCount;
	private Integer linkedSaIctcDirectInLabour;
	private Integer linkedSaIctcPncCount;
	private Integer linkedSaIctcMaleClients;
	private Integer linkedSaIctcFemaleClients;
	private Integer linkedSaIctcTgClients;
	
	//Page5
	private Integer ancClientsRegistered;
	private Integer ancClientsTested;
	private Integer ancClientsReactive;
	private Integer ancClientsTreated;
	
	//Page6
	private String hivKitName;
	private String hivBatchNumber;
	private LocalDateTime hivExpiryDate;
	private Integer hivOpeningStock;
	private Integer hivReceivedQuantity;
	private Integer hivConsumedQuantity;
	private Integer hivControlQuantity;
	private Integer hivWastageQuantity;
	private Integer hivQuantityIndent;

	private String bloodKitName;
	private String bloodBatchNumber;
	private LocalDateTime bloodExpiryDate;
	private Integer bloodOpeningStock;
	private Integer bloodReceivedQuantity;
	private Integer bloodConsumedQuantity;
	private Integer bloodQuantityIndent;
	private Integer bloodWastageQuantity;

	
	//Page7
	private Integer obgGynInreferral;
	private Integer obgGynOutreferral;
	private Integer tiNgosInreferral;
	private Integer tiNgosOutreferral;
	private Integer linkWorkerInreferral;
	private Integer linkWorkerOutreferral;
	private Integer rnctpInreferral;//This field has been changed to NTEP from RNTCP on UI - 13th May 2021 - Adarsh/Vikram
	private Integer rnctpOutreferral;//This field has been changed to NTEP from RNTCP on UI - 13th May 2021 - Adarsh/Vikram
	private Integer sticClinicInreferral;
	private Integer sticClinicOutreferral;
	private Integer otherInreferral;
	private Integer otherOutreferral;
	private Integer walkinInreferral;
	private Integer walkinOutreferral;
	
	//Page8
	private Integer diagnosedStiRtiMale;
	//private Integer diagnosedStiRtiFemale;
	private Integer diagnosedStiRtiPregnantFemale;
	private Integer diagnosedStiRtiNonPregnantFemale;
	private Integer diagnosedStiRtiTransgender;
	
	private Integer testedForSyphillisMale;
	//private Integer testedForSyphillisFemale;
	private Integer testedForSyphillisPregnantFemale;
	private Integer testedForSyphillisNonPregnantFemale;
	private Integer testedForSyphillisTransgender;
	
	private Integer reactiveForSyphillisMale;
	//private Integer reactiveForSyphillisFemale;
	private Integer reactiveForSyphillisPregnantFemale;
	private Integer reactiveForSyphillisNonPregnantFemale;
	private Integer reactiveForSyphillisTransgender;
	
	private Boolean availabilityDrugType;
	
	private Integer treatmentForSyphillisMale;
	private Integer treatmentForSyphillisPregnantFemale;
	private Integer treatmentForSyphillisNonPregnantFemale;
	private Integer treatmentForSyphillisTransgender;
	
	private Integer fourSAncCount;
	private Integer fourSDirectInLabour;
	private Integer fourSMaleClients;
	private Integer fourSFemaleClients;
	private Integer fourSTgClients;
	private Integer fourSPncCount;
	

	private Boolean reportSubmitStatus;
	private Long createdBy;
	private LocalDateTime createdTime;
	private Long modifiedBy;
	private LocalDateTime modifiedTime;
	
	
	private long prtcPwTotal;
	private long prtcGcTotal;
	private long tHivPwTotal;
	private long tHivGcTotal;
	private long potcPwTotal;
	private long potcGcTotal;
	private long hivReactivePwTotal;
	private long hivReactiveGcTotal;
	private long hivClosingStockTotal;
	private long bloodClosingStockTotal;
	private long diagnosedStiRtiTotal;
	private long testedForSyphillisTotal;
	private long reactiveForSyphillisTotal;
	
	private long linkedSaIctcPwTotal;
	private long linkedSaIctcGcTotal;
	private long treatmentForSyphillisTotal;
	private long fourSPwTotal;
	private long fourSGcTotal;
	
	private Integer reportYear;
	private Integer reportMonth;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}
	public Integer getPrtcAncCount() {
		return prtcAncCount;
	}
	public void setPrtcAncCount(Integer prtcAncCount) {
		this.prtcAncCount = prtcAncCount;
	}
	public Integer getPrtcDirectInLabour() {
		return prtcDirectInLabour;
	}
	public void setPrtcDirectInLabour(Integer prtcDirectInLabour) {
		this.prtcDirectInLabour = prtcDirectInLabour;
	}
	public Integer getPrtcMaleClients() {
		return prtcMaleClients;
	}
	public void setPrtcMaleClients(Integer prtcMaleClients) {
		this.prtcMaleClients = prtcMaleClients;
	}
	public Integer getPrtcFemaleClients() {
		return prtcFemaleClients;
	}
	public void setPrtcFemaleClients(Integer prtcFemaleClients) {
		this.prtcFemaleClients = prtcFemaleClients;
	}
	public Integer getPrtcTgClients() {
		return prtcTgClients;
	}
	public void setPrtcTgClients(Integer prtcTgClients) {
		this.prtcTgClients = prtcTgClients;
	}
	public Integer getPrtcPncCount() {
		return prtcPncCount;
	}
	public void setPrtcPncCount(Integer prtcPncCount) {
		this.prtcPncCount = prtcPncCount;
	}
	public Integer gettHivAncCount() {
		return tHivAncCount;
	}
	public void settHivAncCount(Integer tHivAncCount) {
		this.tHivAncCount = tHivAncCount;
	}
	public Integer gettHivDirectInLabour() {
		return tHivDirectInLabour;
	}
	public void settHivDirectInLabour(Integer tHivDirectInLabour) {
		this.tHivDirectInLabour = tHivDirectInLabour;
	}
	public Integer gettHivMaleClients() {
		return tHivMaleClients;
	}
	public void settHivMaleClients(Integer tHivMaleClients) {
		this.tHivMaleClients = tHivMaleClients;
	}
	public Integer gettHivFemaleClients() {
		return tHivFemaleClients;
	}
	public void settHivFemaleClients(Integer tHivFemaleClients) {
		this.tHivFemaleClients = tHivFemaleClients;
	}
	public Integer gettHivTgClients() {
		return tHivTgClients;
	}
	public void settHivTgClients(Integer tHivTgClients) {
		this.tHivTgClients = tHivTgClients;
	}
	public Integer gettHivPncCount() {
		return tHivPncCount;
	}
	public void settHivPncCount(Integer tHivPncCount) {
		this.tHivPncCount = tHivPncCount;
	}
	public Integer getPotcAncCount() {
		return potcAncCount;
	}
	public void setPotcAncCount(Integer potcAncCount) {
		this.potcAncCount = potcAncCount;
	}
	public Integer getPotcDirectInLabour() {
		return potcDirectInLabour;
	}
	public void setPotcDirectInLabour(Integer potcDirectInLabour) {
		this.potcDirectInLabour = potcDirectInLabour;
	}
	public Integer getPotcMaleClients() {
		return potcMaleClients;
	}
	public void setPotcMaleClients(Integer potcMaleClients) {
		this.potcMaleClients = potcMaleClients;
	}
	public Integer getPotcFemaleClients() {
		return potcFemaleClients;
	}
	public void setPotcFemaleClients(Integer potcFemaleClients) {
		this.potcFemaleClients = potcFemaleClients;
	}
	public Integer getPotcTgClients() {
		return potcTgClients;
	}
	public void setPotcTgClients(Integer potcTgClients) {
		this.potcTgClients = potcTgClients;
	}
	public Integer getPotcPncCount() {
		return potcPncCount;
	}
	public void setPotcPncCount(Integer potcPncCount) {
		this.potcPncCount = potcPncCount;
	}
	public Integer getHivReactiveAncCount() {
		return hivReactiveAncCount;
	}
	public void setHivReactiveAncCount(Integer hivReactiveAncCount) {
		this.hivReactiveAncCount = hivReactiveAncCount;
	}
	public Integer getHivReactiveDirectInLabour() {
		return hivReactiveDirectInLabour;
	}
	public void setHivReactiveDirectInLabour(Integer hivReactiveDirectInLabour) {
		this.hivReactiveDirectInLabour = hivReactiveDirectInLabour;
	}
	public Integer getHivReactiveMaleClients() {
		return hivReactiveMaleClients;
	}
	public void setHivReactiveMaleClients(Integer hivReactiveMaleClients) {
		this.hivReactiveMaleClients = hivReactiveMaleClients;
	}
	public Integer getHivReactiveFemaleClients() {
		return hivReactiveFemaleClients;
	}
	public void setHivReactiveFemaleClients(Integer hivReactiveFemaleClients) {
		this.hivReactiveFemaleClients = hivReactiveFemaleClients;
	}
	public Integer getHivReactiveTgClients() {
		return hivReactiveTgClients;
	}
	public void setHivReactiveTgClients(Integer hivReactiveTgClients) {
		this.hivReactiveTgClients = hivReactiveTgClients;
	}
	public Integer getHivReactivePncCount() {
		return hivReactivePncCount;
	}
	public void setHivReactivePncCount(Integer hivReactivePncCount) {
		this.hivReactivePncCount = hivReactivePncCount;
	}
	public Integer getLinkedSaIctcAncCount() {
		return linkedSaIctcAncCount;
	}
	public void setLinkedSaIctcAncCount(Integer linkedSaIctcAncCount) {
		this.linkedSaIctcAncCount = linkedSaIctcAncCount;
	}
	public Integer getLinkedSaIctcDirectInLabour() {
		return linkedSaIctcDirectInLabour;
	}
	public void setLinkedSaIctcDirectInLabour(Integer linkedSaIctcDirectInLabour) {
		this.linkedSaIctcDirectInLabour = linkedSaIctcDirectInLabour;
	}
	public Integer getLinkedSaIctcPncCount() {
		return linkedSaIctcPncCount;
	}
	public void setLinkedSaIctcPncCount(Integer linkedSaIctcPncCount) {
		this.linkedSaIctcPncCount = linkedSaIctcPncCount;
	}
	public Integer getLinkedSaIctcMaleClients() {
		return linkedSaIctcMaleClients;
	}
	public void setLinkedSaIctcMaleClients(Integer linkedSaIctcMaleClients) {
		this.linkedSaIctcMaleClients = linkedSaIctcMaleClients;
	}
	public Integer getLinkedSaIctcFemaleClients() {
		return linkedSaIctcFemaleClients;
	}
	public void setLinkedSaIctcFemaleClients(Integer linkedSaIctcFemaleClients) {
		this.linkedSaIctcFemaleClients = linkedSaIctcFemaleClients;
	}
	public Integer getLinkedSaIctcTgClients() {
		return linkedSaIctcTgClients;
	}
	public void setLinkedSaIctcTgClients(Integer linkedSaIctcTgClients) {
		this.linkedSaIctcTgClients = linkedSaIctcTgClients;
	}
	public Integer getAncClientsRegistered() {
		return ancClientsRegistered;
	}
	public void setAncClientsRegistered(Integer ancClientsRegistered) {
		this.ancClientsRegistered = ancClientsRegistered;
	}
	public Integer getAncClientsTested() {
		return ancClientsTested;
	}
	public void setAncClientsTested(Integer ancClientsTested) {
		this.ancClientsTested = ancClientsTested;
	}
	public Integer getAncClientsReactive() {
		return ancClientsReactive;
	}
	public void setAncClientsReactive(Integer ancClientsReactive) {
		this.ancClientsReactive = ancClientsReactive;
	}
	public Integer getAncClientsTreated() {
		return ancClientsTreated;
	}
	public void setAncClientsTreated(Integer ancClientsTreated) {
		this.ancClientsTreated = ancClientsTreated;
	}
	public String getHivKitName() {
		return hivKitName;
	}
	public void setHivKitName(String hivKitName) {
		this.hivKitName = hivKitName;
	}
	public String getHivBatchNumber() {
		return hivBatchNumber;
	}
	public void setHivBatchNumber(String hivBatchNumber) {
		this.hivBatchNumber = hivBatchNumber;
	}
	public LocalDateTime getHivExpiryDate() {
		return hivExpiryDate;
	}
	public void setHivExpiryDate(LocalDateTime hivExpiryDate) {
		this.hivExpiryDate = hivExpiryDate;
	}
	public Integer getHivOpeningStock() {
		return hivOpeningStock;
	}
	public void setHivOpeningStock(Integer hivOpeningStock) {
		this.hivOpeningStock = hivOpeningStock;
	}
	public Integer getHivReceivedQuantity() {
		return hivReceivedQuantity;
	}
	public void setHivReceivedQuantity(Integer hivReceivedQuantity) {
		this.hivReceivedQuantity = hivReceivedQuantity;
	}
	public Integer getHivConsumedQuantity() {
		return hivConsumedQuantity;
	}
	public void setHivConsumedQuantity(Integer hivConsumedQuantity) {
		this.hivConsumedQuantity = hivConsumedQuantity;
	}
	public Integer getHivControlQuantity() {
		return hivControlQuantity;
	}
	public void setHivControlQuantity(Integer hivControlQuantity) {
		this.hivControlQuantity = hivControlQuantity;
	}
	public Integer getHivWastageQuantity() {
		return hivWastageQuantity;
	}
	public void setHivWastageQuantity(Integer hivWastageQuantity) {
		this.hivWastageQuantity = hivWastageQuantity;
	}
	public Integer getHivQuantityIndent() {
		return hivQuantityIndent;
	}
	public void setHivQuantityIndent(Integer hivQuantityIndent) {
		this.hivQuantityIndent = hivQuantityIndent;
	}
	public String getBloodKitName() {
		return bloodKitName;
	}
	public void setBloodKitName(String bloodKitName) {
		this.bloodKitName = bloodKitName;
	}
	public String getBloodBatchNumber() {
		return bloodBatchNumber;
	}
	public void setBloodBatchNumber(String bloodBatchNumber) {
		this.bloodBatchNumber = bloodBatchNumber;
	}
	public LocalDateTime getBloodExpiryDate() {
		return bloodExpiryDate;
	}
	public void setBloodExpiryDate(LocalDateTime bloodExpiryDate) {
		this.bloodExpiryDate = bloodExpiryDate;
	}
	public Integer getBloodOpeningStock() {
		return bloodOpeningStock;
	}
	public void setBloodOpeningStock(Integer bloodOpeningStock) {
		this.bloodOpeningStock = bloodOpeningStock;
	}
	public Integer getBloodReceivedQuantity() {
		return bloodReceivedQuantity;
	}
	public void setBloodReceivedQuantity(Integer bloodReceivedQuantity) {
		this.bloodReceivedQuantity = bloodReceivedQuantity;
	}
	public Integer getBloodConsumedQuantity() {
		return bloodConsumedQuantity;
	}
	public void setBloodConsumedQuantity(Integer bloodConsumedQuantity) {
		this.bloodConsumedQuantity = bloodConsumedQuantity;
	}
	public Integer getBloodQuantityIndent() {
		return bloodQuantityIndent;
	}
	public void setBloodQuantityIndent(Integer bloodQuantityIndent) {
		this.bloodQuantityIndent = bloodQuantityIndent;
	}
	public Integer getBloodWastageQuantity() {
		return bloodWastageQuantity;
	}
	public void setBloodWastageQuantity(Integer bloodWastageQuantity) {
		this.bloodWastageQuantity = bloodWastageQuantity;
	}
	public Integer getObgGynInreferral() {
		return obgGynInreferral;
	}
	public void setObgGynInreferral(Integer obgGynInreferral) {
		this.obgGynInreferral = obgGynInreferral;
	}
	public Integer getObgGynOutreferral() {
		return obgGynOutreferral;
	}
	public void setObgGynOutreferral(Integer obgGynOutreferral) {
		this.obgGynOutreferral = obgGynOutreferral;
	}
	public Integer getTiNgosInreferral() {
		return tiNgosInreferral;
	}
	public void setTiNgosInreferral(Integer tiNgosInreferral) {
		this.tiNgosInreferral = tiNgosInreferral;
	}
	public Integer getTiNgosOutreferral() {
		return tiNgosOutreferral;
	}
	public void setTiNgosOutreferral(Integer tiNgosOutreferral) {
		this.tiNgosOutreferral = tiNgosOutreferral;
	}
	public Integer getLinkWorkerInreferral() {
		return linkWorkerInreferral;
	}
	public void setLinkWorkerInreferral(Integer linkWorkerInreferral) {
		this.linkWorkerInreferral = linkWorkerInreferral;
	}
	public Integer getLinkWorkerOutreferral() {
		return linkWorkerOutreferral;
	}
	public void setLinkWorkerOutreferral(Integer linkWorkerOutreferral) {
		this.linkWorkerOutreferral = linkWorkerOutreferral;
	}
	public Integer getRnctpInreferral() {
		return rnctpInreferral;
	}
	public void setRnctpInreferral(Integer rnctpInreferral) {
		this.rnctpInreferral = rnctpInreferral;
	}
	public Integer getRnctpOutreferral() {
		return rnctpOutreferral;
	}
	public void setRnctpOutreferral(Integer rnctpOutreferral) {
		this.rnctpOutreferral = rnctpOutreferral;
	}
	public Integer getSticClinicInreferral() {
		return sticClinicInreferral;
	}
	public void setSticClinicInreferral(Integer sticClinicInreferral) {
		this.sticClinicInreferral = sticClinicInreferral;
	}
	public Integer getSticClinicOutreferral() {
		return sticClinicOutreferral;
	}
	public void setSticClinicOutreferral(Integer sticClinicOutreferral) {
		this.sticClinicOutreferral = sticClinicOutreferral;
	}
	public Integer getOtherInreferral() {
		return otherInreferral;
	}
	public void setOtherInreferral(Integer otherInreferral) {
		this.otherInreferral = otherInreferral;
	}
	public Integer getOtherOutreferral() {
		return otherOutreferral;
	}
	public void setOtherOutreferral(Integer otherOutreferral) {
		this.otherOutreferral = otherOutreferral;
	}
	public Integer getWalkinInreferral() {
		return walkinInreferral;
	}
	public void setWalkinInreferral(Integer walkinInreferral) {
		this.walkinInreferral = walkinInreferral;
	}
	public Integer getWalkinOutreferral() {
		return walkinOutreferral;
	}
	public void setWalkinOutreferral(Integer walkinOutreferral) {
		this.walkinOutreferral = walkinOutreferral;
	}
	public Integer getDiagnosedStiRtiMale() {
		return diagnosedStiRtiMale;
	}
	public void setDiagnosedStiRtiMale(Integer diagnosedStiRtiMale) {
		this.diagnosedStiRtiMale = diagnosedStiRtiMale;
	}
	public Integer getDiagnosedStiRtiPregnantFemale() {
		return diagnosedStiRtiPregnantFemale;
	}
	public void setDiagnosedStiRtiPregnantFemale(Integer diagnosedStiRtiPregnantFemale) {
		this.diagnosedStiRtiPregnantFemale = diagnosedStiRtiPregnantFemale;
	}
	public Integer getDiagnosedStiRtiNonPregnantFemale() {
		return diagnosedStiRtiNonPregnantFemale;
	}
	public void setDiagnosedStiRtiNonPregnantFemale(Integer diagnosedStiRtiNonPregnantFemale) {
		this.diagnosedStiRtiNonPregnantFemale = diagnosedStiRtiNonPregnantFemale;
	}
	public Integer getDiagnosedStiRtiTransgender() {
		return diagnosedStiRtiTransgender;
	}
	public void setDiagnosedStiRtiTransgender(Integer diagnosedStiRtiTransgender) {
		this.diagnosedStiRtiTransgender = diagnosedStiRtiTransgender;
	}
	public Integer getTestedForSyphillisMale() {
		return testedForSyphillisMale;
	}
	public void setTestedForSyphillisMale(Integer testedForSyphillisMale) {
		this.testedForSyphillisMale = testedForSyphillisMale;
	}
	public Integer getTestedForSyphillisPregnantFemale() {
		return testedForSyphillisPregnantFemale;
	}
	public void setTestedForSyphillisPregnantFemale(Integer testedForSyphillisPregnantFemale) {
		this.testedForSyphillisPregnantFemale = testedForSyphillisPregnantFemale;
	}
	public Integer getTestedForSyphillisNonPregnantFemale() {
		return testedForSyphillisNonPregnantFemale;
	}
	public void setTestedForSyphillisNonPregnantFemale(Integer testedForSyphillisNonPregnantFemale) {
		this.testedForSyphillisNonPregnantFemale = testedForSyphillisNonPregnantFemale;
	}
	public Integer getTestedForSyphillisTransgender() {
		return testedForSyphillisTransgender;
	}
	public void setTestedForSyphillisTransgender(Integer testedForSyphillisTransgender) {
		this.testedForSyphillisTransgender = testedForSyphillisTransgender;
	}
	public Integer getReactiveForSyphillisMale() {
		return reactiveForSyphillisMale;
	}
	public void setReactiveForSyphillisMale(Integer reactiveForSyphillisMale) {
		this.reactiveForSyphillisMale = reactiveForSyphillisMale;
	}
	public Integer getReactiveForSyphillisPregnantFemale() {
		return reactiveForSyphillisPregnantFemale;
	}
	public void setReactiveForSyphillisPregnantFemale(Integer reactiveForSyphillisPregnantFemale) {
		this.reactiveForSyphillisPregnantFemale = reactiveForSyphillisPregnantFemale;
	}
	public Integer getReactiveForSyphillisNonPregnantFemale() {
		return reactiveForSyphillisNonPregnantFemale;
	}
	public void setReactiveForSyphillisNonPregnantFemale(Integer reactiveForSyphillisNonPregnantFemale) {
		this.reactiveForSyphillisNonPregnantFemale = reactiveForSyphillisNonPregnantFemale;
	}
	public Integer getReactiveForSyphillisTransgender() {
		return reactiveForSyphillisTransgender;
	}
	public void setReactiveForSyphillisTransgender(Integer reactiveForSyphillisTransgender) {
		this.reactiveForSyphillisTransgender = reactiveForSyphillisTransgender;
	}
	public Boolean getAvailabilityDrugType() {
		return availabilityDrugType;
	}
	public void setAvailabilityDrugType(Boolean availabilityDrugType) {
		this.availabilityDrugType = availabilityDrugType;
	}
	public Integer getTreatmentForSyphillisMale() {
		return treatmentForSyphillisMale;
	}
	public void setTreatmentForSyphillisMale(Integer treatmentForSyphillisMale) {
		this.treatmentForSyphillisMale = treatmentForSyphillisMale;
	}
	public Integer getTreatmentForSyphillisPregnantFemale() {
		return treatmentForSyphillisPregnantFemale;
	}
	public void setTreatmentForSyphillisPregnantFemale(Integer treatmentForSyphillisPregnantFemale) {
		this.treatmentForSyphillisPregnantFemale = treatmentForSyphillisPregnantFemale;
	}
	public Integer getTreatmentForSyphillisNonPregnantFemale() {
		return treatmentForSyphillisNonPregnantFemale;
	}
	public void setTreatmentForSyphillisNonPregnantFemale(Integer treatmentForSyphillisNonPregnantFemale) {
		this.treatmentForSyphillisNonPregnantFemale = treatmentForSyphillisNonPregnantFemale;
	}
	public Integer getTreatmentForSyphillisTransgender() {
		return treatmentForSyphillisTransgender;
	}
	public void setTreatmentForSyphillisTransgender(Integer treatmentForSyphillisTransgender) {
		this.treatmentForSyphillisTransgender = treatmentForSyphillisTransgender;
	}
	public Integer getFourSAncCount() {
		return fourSAncCount;
	}
	public void setFourSAncCount(Integer fourSAncCount) {
		this.fourSAncCount = fourSAncCount;
	}
	public Integer getFourSDirectInLabour() {
		return fourSDirectInLabour;
	}
	public void setFourSDirectInLabour(Integer fourSDirectInLabour) {
		this.fourSDirectInLabour = fourSDirectInLabour;
	}
	public Integer getFourSMaleClients() {
		return fourSMaleClients;
	}
	public void setFourSMaleClients(Integer fourSMaleClients) {
		this.fourSMaleClients = fourSMaleClients;
	}
	public Integer getFourSFemaleClients() {
		return fourSFemaleClients;
	}
	public void setFourSFemaleClients(Integer fourSFemaleClients) {
		this.fourSFemaleClients = fourSFemaleClients;
	}
	public Integer getFourSTgClients() {
		return fourSTgClients;
	}
	public void setFourSTgClients(Integer fourSTgClients) {
		this.fourSTgClients = fourSTgClients;
	}
	public Integer getFourSPncCount() {
		return fourSPncCount;
	}
	public void setFourSPncCount(Integer fourSPncCount) {
		this.fourSPncCount = fourSPncCount;
	}
	public Boolean getReportSubmitStatus() {
		return reportSubmitStatus;
	}
	public void setReportSubmitStatus(Boolean reportSubmitStatus) {
		this.reportSubmitStatus = reportSubmitStatus;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public long getPrtcPwTotal() {
		return prtcPwTotal;
	}
	public void setPrtcPwTotal(long prtcPwTotal) {
		this.prtcPwTotal = prtcPwTotal;
	}
	public long getPrtcGcTotal() {
		return prtcGcTotal;
	}
	public void setPrtcGcTotal(long prtcGcTotal) {
		this.prtcGcTotal = prtcGcTotal;
	}
	public long gettHivPwTotal() {
		return tHivPwTotal;
	}
	public void settHivPwTotal(long tHivPwTotal) {
		this.tHivPwTotal = tHivPwTotal;
	}
	public long gettHivGcTotal() {
		return tHivGcTotal;
	}
	public void settHivGcTotal(long tHivGcTotal) {
		this.tHivGcTotal = tHivGcTotal;
	}
	public long getPotcPwTotal() {
		return potcPwTotal;
	}
	public void setPotcPwTotal(long potcPwTotal) {
		this.potcPwTotal = potcPwTotal;
	}
	public long getPotcGcTotal() {
		return potcGcTotal;
	}
	public void setPotcGcTotal(long potcGcTotal) {
		this.potcGcTotal = potcGcTotal;
	}
	public long getHivReactivePwTotal() {
		return hivReactivePwTotal;
	}
	public void setHivReactivePwTotal(long hivReactivePwTotal) {
		this.hivReactivePwTotal = hivReactivePwTotal;
	}
	public long getHivReactiveGcTotal() {
		return hivReactiveGcTotal;
	}
	public void setHivReactiveGcTotal(long hivReactiveGcTotal) {
		this.hivReactiveGcTotal = hivReactiveGcTotal;
	}
	public long getHivClosingStockTotal() {
		return hivClosingStockTotal;
	}
	public void setHivClosingStockTotal(long hivClosingStockTotal) {
		this.hivClosingStockTotal = hivClosingStockTotal;
	}
	public long getBloodClosingStockTotal() {
		return bloodClosingStockTotal;
	}
	public void setBloodClosingStockTotal(long bloodClosingStockTotal) {
		this.bloodClosingStockTotal = bloodClosingStockTotal;
	}
	public long getDiagnosedStiRtiTotal() {
		return diagnosedStiRtiTotal;
	}
	public void setDiagnosedStiRtiTotal(long diagnosedStiRtiTotal) {
		this.diagnosedStiRtiTotal = diagnosedStiRtiTotal;
	}
	public long getTestedForSyphillisTotal() {
		return testedForSyphillisTotal;
	}
	public void setTestedForSyphillisTotal(long testedForSyphillisTotal) {
		this.testedForSyphillisTotal = testedForSyphillisTotal;
	}
	public long getReactiveForSyphillisTotal() {
		return reactiveForSyphillisTotal;
	}
	public void setReactiveForSyphillisTotal(long reactiveForSyphillisTotal) {
		this.reactiveForSyphillisTotal = reactiveForSyphillisTotal;
	}
	public long getLinkedSaIctcPwTotal() {
		return linkedSaIctcPwTotal;
	}
	public void setLinkedSaIctcPwTotal(long linkedSaIctcPwTotal) {
		this.linkedSaIctcPwTotal = linkedSaIctcPwTotal;
	}
	public long getLinkedSaIctcGcTotal() {
		return linkedSaIctcGcTotal;
	}
	public void setLinkedSaIctcGcTotal(long linkedSaIctcGcTotal) {
		this.linkedSaIctcGcTotal = linkedSaIctcGcTotal;
	}
	
	public long getFourSPwTotal() {
		return fourSPwTotal;
	}
	public void setFourSPwTotal(long fourSPwTotal) {
		this.fourSPwTotal = fourSPwTotal;
	}
	public long getFourSGcTotal() {
		return fourSGcTotal;
	}
	public void setFourSGcTotal(long fourSGcTotal) {
		this.fourSGcTotal = fourSGcTotal;
	}
	public Integer getReportYear() {
		return reportYear;
	}
	public void setReportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}
	public Integer getReportMonth() {
		return reportMonth;
	}
	public void setReportMonth(Integer reportMonth) {
		this.reportMonth = reportMonth;
	}
	public long getTreatmentForSyphillisTotal() {
		return treatmentForSyphillisTotal;
	}
	public void setTreatmentForSyphillisTotal(long treatmentForSyphillisTotal) {
		this.treatmentForSyphillisTotal = treatmentForSyphillisTotal;
	}
	
}
