package gov.naco.soch.service.dto;

import java.time.LocalDateTime;

/**
 * A DTO for saving fictcmonthlyreport - request.
 */
public class FICTCMonthlyReportRequestDto {
	private Long id;
	private Integer facilityId;

	//Page1 pre-test counselling
	private Integer prtcAncCount;
	private Integer prtcDirectInLabour;
	private Integer prtcMaleClients;
	private Integer prtcFemaleClients;
	private Integer prtcTgClients;

	//Page2 - t is for tested
	private Integer tHivAncCount;
	private Integer tHivDirectInLabour;
	private Integer tHivMaleClients;
	private Integer tHivFemaleClients;
	private Integer tHivTgClients;
	
	//Page3 post-test counselling
	private Integer potcAncCount;
	private Integer potcDirectInLabour;
	private Integer potcMaleClients;
	private Integer potcFemaleClients;
	private Integer potcTgClients;

	
	//Page4 No. of clients detected HIV reactive
	private Integer hivReactiveAncCount;
	private Integer hivReactiveDirectInLabour;
	private Integer hivReactiveMaleClients;
	private Integer hivReactiveFemaleClients;
	private Integer hivReactiveTgClients;
	
	//Page5
	private Integer ancClientsRegistered;
	private Integer ancClientsTested;
	private Integer ancClientsReactive;
	
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
	private Integer rnctpInreferral;
	private Integer rnctpOutreferral;
	private Integer sticClinicInreferral;
	private Integer sticClinicOutreferral;
	private Integer otherInreferral;
	private Integer otherOutreferral;
	
	//Page8
	private Integer diagnosedStiRtiMale;
	private Integer diagnosedStiRtiFemale;
	private Integer testedForSyphillisMale;
	private Integer testedForSyphillisFemale;
	private Integer reactiveForSyphillisMale;
	private Integer reactiveForSyphillisFemale;
	private Boolean availabilityDrugType;

	private String userAction;//save or submit
	private Integer reportMonth;
	private Integer reportYear;

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

	public Integer getDiagnosedStiRtiMale() {
		return diagnosedStiRtiMale;
	}

	public void setDiagnosedStiRtiMaleClients(Integer diagnosedStiRtiMale) {
		this.diagnosedStiRtiMale = diagnosedStiRtiMale;
	}

	public Integer getDiagnosedStiRtiFemale() {
		return diagnosedStiRtiFemale;
	}

	public void setDiagnosedStiRtiFemale(Integer diagnosedStiRtiFemale) {
		this.diagnosedStiRtiFemale = diagnosedStiRtiFemale;
	}

	public Integer getTestedForSyphillisMale() {
		return testedForSyphillisMale;
	}

	public void setTestedForSyphillisMale(Integer testedForSyphillisMale) {
		this.testedForSyphillisMale = testedForSyphillisMale;
	}

	public Integer getTestedForSyphillisFemale() {
		return testedForSyphillisFemale;
	}

	public void setTestedForSyphillisFemale(Integer testedForSyphillisFemale) {
		this.testedForSyphillisFemale = testedForSyphillisFemale;
	}

	public Integer getReactiveForSyphillisMale() {
		return reactiveForSyphillisMale;
	}

	public void setReactiveForSyphillisMale(Integer reactiveForSyphillisMale) {
		this.reactiveForSyphillisMale = reactiveForSyphillisMale;
	}

	public Integer getReactiveForSyphillisFemale() {
		return reactiveForSyphillisFemale;
	}

	public void setReactiveForSyphillisFemale(Integer reactiveForSyphillisFemale) {
		this.reactiveForSyphillisFemale = reactiveForSyphillisFemale;
	}

	public Boolean getAvailabilityDrugType() {
		return availabilityDrugType;
	}

	public void setAvailabilityDrugType(Boolean availabilityDrugType) {
		this.availabilityDrugType = availabilityDrugType;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getReportMonth() {
		return reportMonth;
	}

	public void setReportMonth(Integer reportMonth) {
		this.reportMonth = reportMonth;
	}

	public Integer getReportYear() {
		return reportYear;
	}

	public void setReportYear(Integer reportYear) {
		this.reportYear = reportYear;
	}
	
}
