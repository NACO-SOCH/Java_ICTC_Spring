package gov.naco.soch.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fictc_monthly_report")

public class FICTCMonthlyReportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "facility_id")
	private Integer facilityId;
	
	//Page1
	@Column(name = "prtc_anc_count")
	private Integer prtcAncCount;
	@Column(name = "prtc_direct_in_labour")
	private Integer prtcDirectInLabour;
	@Column(name = "prtc_male_clients")
	private Integer prtcMaleClients;
	@Column(name = "prtc_female_clients")
	private Integer prtcFemaleClients;
	@Column(name = "prtc_tg_clients")
	private Integer prtcTgClients;
	
	//Page2
	@Column(name = "t_hiv_anc_count")
	private Integer tHivAncCount;
	@Column(name = "t_hiv_direct_in_labour")
	private Integer tHivDirectInLabour;
	@Column(name = "t_hiv_male_clients")
	private Integer tHivMaleClients;
	@Column(name = "t_hiv_female_clients")
	private Integer tHivFemaleClients;
	@Column(name = "t_hiv_tg_clients")
	private Integer tHivTgClients;
	
	//Page3
	@Column(name = "potc_anc_count")
	private Integer potcAncCount;
	@Column(name = "potc_direct_in_labour")
	private Integer potcDirectInLabour;
	@Column(name = "potc_male_clients")
	private Integer potcMaleClients;
	@Column(name = "potc_tg_clients")
	private Integer potcTgClients;
	@Column(name = "potc_female_clients")
	private Integer potcFemaleClients;
	

	//Page4
	@Column(name = "hiv_reactive_anc_count")
	private Integer hivReactiveAncCount;
	@Column(name = "hiv_reactive_direct_in_labour")
	private Integer hivReactiveDirectInLabour;
	@Column(name = "hiv_reactive_male_clients")
	private Integer hivReactiveMaleClients;
	@Column(name = "hiv_reactive_female_clients")
	private Integer hivReactiveFemaleClients;
	@Column(name = "hiv_reactive_tg_clients")
	private Integer hivReactiveTgClients;

	//Page5
	@Column(name = "anc_clients_registered")
	private Integer ancClientsRegistered;
	@Column(name = "anc_clients_tested")
	private Integer ancClientsTested;
	@Column(name = "anc_clients_reactive")
	private Integer ancClientsReactive;

	//Page6
	@Column(name = "hiv_kit_name")
	private String hivKitName;
	@Column(name = "hiv_batch_number")
	private String hivBatchNumber;
	@Column(name = "hiv_expiry_date")
	private LocalDateTime hivExpiryDate;
	@Column(name = "hiv_opening_stock")
	private Integer hivOpeningStock;
	@Column(name = "hiv_recieved_quantity")
	private Integer hivReceivedQuantity;
	@Column(name = "hiv_consumed_quantity")
	private Integer hivConsumedQuantity;
	@Column(name = "hiv_control_quantity")
	private Integer hivControlQuantity;
	@Column(name = "hiv_wastage_quantity")
	private Integer hivWastageQuantity;
	@Column(name = "hiv_quantity_indent")
	private Integer hivQuantityIndent;

	@Column(name = "blood_kit_name")
	private String bloodKitName;
	@Column(name = "blood_batch_number")
	private String bloodBatchNumber;
	@Column(name = "blood_expiry_date")
	private LocalDateTime bloodExpiryDate;
	@Column(name = "blood_opening_stock")
	private Integer bloodOpeningStock;
	@Column(name = "blood_recieved_quantity")
	private Integer bloodReceivedQuantity;
	@Column(name = "blood_consumed_quantity")
	private Integer bloodConsumedQuantity;
	@Column(name = "blood_quantity_indent")
	private Integer bloodQuantityIndent;
	@Column(name = "blood_wastage_quantity")
	private Integer bloodWastageQuantity;


	//Page7
	@Column(name = "obg_gyn_inreferral")
	private Integer obgGynInreferral;
	@Column(name = "obg_gyn_outreferral")
	private Integer obgGynOutreferral;
	@Column(name = "ti_ngos_inreferral")
	private Integer tiNgosInreferral;
	@Column(name = "ti_ngos_outreferral")
	private Integer tiNgosOutreferral;
	@Column(name = "linkworker_inreferral")
	private Integer linkWorkerInreferral;
	@Column(name = "linkworker_outreferral")
	private Integer linkWorkerOutreferral;
	@Column(name = "rnctp_inreferral")
	private Integer rnctpInreferral;
	@Column(name = "rnctp_outreferral")
	private Integer rnctpOutreferral;
	@Column(name = "sticlinic_inreferral")
	private Integer sticClinicInreferral;
	@Column(name = "sticlinic_outreferral")
	private Integer sticClinicOutreferral;
	@Column(name = "other_inreferral")
	private Integer otherInreferral;
	@Column(name = "other_outreferral")
	private Integer otherOutreferral;

	
	//Page8
	@Column(name = "sti_rti_male_clients")
	private Integer diagnosedStiRtiMale;
	@Column(name = "sti_rti_female")
	private Integer diagnosedStiRtiFemale;
	@Column(name = "t_sti_rti_male_clients")
	private Integer testedForSyphillisMale;
	@Column(name = "t_sti_rti_female_clients")
	private Integer testedForSyphillisFemale;
	@Column(name = "reactive_sti_rti_male_clients")
	private Integer reactiveForSyphillisMale;
	@Column(name = "reactive_sti_rti_female_clients")
	private Integer reactiveForSyphillisFemale;
	@Column(name = "availability_drug_type")
	private Boolean availabilityDrugType;
	

	@Column(name = "report_status")
	private Boolean reportSubmitStatus;//true=report is submitted, false=report is just saved and not submitted
	@Column(name = "report_month")
	private Integer reportMonth;
	@Column(name = "report_year")
	private Integer reportYear;

	//meta-columns

	@Column(name = "created_by")
	private Long createdBy;
	@Column(name = "created_time")
	private LocalDateTime createdTime;
	@Column(name = "modified_by")
	private Long modifiedBy;
	@Column(name = "modified_time")
	private LocalDateTime modifiedTime;
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
	public void setDiagnosedStiRtiMale(Integer diagnosedStiRtiMale) {
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
	public Boolean getReportSubmitStatus() {
		return reportSubmitStatus;
	}
	public void setReportSubmitStatus(Boolean reportSubmitStatus) {
		this.reportSubmitStatus = reportSubmitStatus;
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

}
