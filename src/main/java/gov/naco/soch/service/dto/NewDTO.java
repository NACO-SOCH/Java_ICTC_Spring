package gov.naco.soch.service.dto;
import java.io.Serializable;
//import java.time.Date;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCBeneficiaryVisit} entity.
 */
public class NewDTO implements Serializable {

	private static final Long serialVersionUID = 1L;

	private int id;

	private String pid;

	private String uid;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date visitDate;

	private Integer beneficiaryId;

	private String mobileNumber;

	private String age;

//	private String category;

	private Boolean isPregnant;

//	private String gender;

	private Date testedDate;

	private Date reportReceivedDate;

	private Date reportDeliveryDate;

	private Integer hivStatus;

	private Integer hivType;

	private Integer infantBreastFed;

	private Date dateOfBirth;

	private String barcode;

	private Integer resultStatus;

	private Integer visitId;

	private String infantMotherArtNo;

	private Integer infantMotherArtId;

	private String infantMotherLastName;

	private String infantMotherFirstName;

	private String infantCode;

	private Integer occupationId;

	private Integer maritalStatusId;

	private Integer testType;

	private Boolean isConsentDocumented;

	private Integer beneficiaryStatus;

	private Integer currentTestResultId;

//	private Integer relationshipRecordId;
//
//	private Integer relationshipType;
//
//	private String relationshipFirstName;
//
//	private String relationshipLastName;
//
//	private String relationshipMiddleName;
//
//	private Integer testSequence;

	private Integer tiReferralId;

	private String tiReferralName;

	private Integer artReferralId;

	private String artReferralName;

	private Integer dsrcReferralId;

	private String dsrcReferralName;

	private Integer rntcpReferralId;

	private String rntcpReferralName;

	private Integer batchId;

	private String consignmentId;

	private Integer labId;

	private String labName;

	private String labCode;

	private Date sampleCollectionDate;

	private Integer facilityId;

	private Integer categoryId;

	private Integer genderId;

	private Integer deletedReason;

	private String deletedReasonComment;

	private Boolean isActive;

	private Boolean isDeleted;

	private Integer registeredFacilityId;

	private Integer infantMotherBeneficiaryId;
	
	private String hivStatusDesc;

	private String beneficiaryStatusDesc;

	private String testTypeDesc;
	
	private Date resultModifiedTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer integer) {
		this.id = integer;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}

	public Date getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(Date testedDate) {
		this.testedDate = testedDate;
	}

	public Date getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(Date reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public Integer getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Integer hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Integer getHivType() {
		return hivType;
	}

	public void setHivType(Integer hivType) {
		this.hivType = hivType;
	}

	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public String getInfantMotherArtNo() {
		return infantMotherArtNo;
	}

	public void setInfantMotherArtNo(String infantMotherArtNo) {
		this.infantMotherArtNo = infantMotherArtNo;
	}

	public Integer getInfantMotherArtId() {
		return infantMotherArtId;
	}

	public void setInfantMotherArtId(Integer infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public String getInfantMotherLastName() {
		return infantMotherLastName;
	}

	public void setInfantMotherLastName(String infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}

	public String getInfantMotherFirstName() {
		return infantMotherFirstName;
	}

	public void setInfantMotherFirstName(String infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
	}

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

//	public String getOccupation() {
//		return occupation;
//	}
//
//	public void setOccupation(String occupation) {
//		this.occupation = occupation;
//	}
//
//	public String getMaritalStatus() {
//		return maritalStatus;
//	}
//
//	public void setMaritalStatus(String maritalStatus) {
//		this.maritalStatus = maritalStatus;
//	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public Date getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(Date reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Boolean getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public Integer getCurrentTestResultId() {
		return currentTestResultId;
	}

	public void setCurrentTestResultId(Integer currentTestResultId) {
		this.currentTestResultId = currentTestResultId;
	}

//	public String getRelationshipFirstName() {
//		return relationshipFirstName;
//	}
//
//	public void setRelationshipFirstName(String relationshipFirstName) {
//		this.relationshipFirstName = relationshipFirstName;
//	}
//
//	public String getRelationshipLastName() {
//		return relationshipLastName;
//	}
//
//	public void setRelationshipLastName(String relationshipLastName) {
//		this.relationshipLastName = relationshipLastName;
//	}
//
//	public String getRelationshipMiddleName() {
//		return relationshipMiddleName;
//	}
//
//	public void setRelationshipMiddleName(String relationshipMiddleName) {
//		this.relationshipMiddleName = relationshipMiddleName;
//	}
//
//	public Integer getRelationshipRecordId() {
//		return relationshipRecordId;
//	}
//
//	public void setRelationshipRecordId(Integer relationshipRecordId) {
//		this.relationshipRecordId = relationshipRecordId;
//	}
//
//	public Integer getRelationshipType() {
//		return relationshipType;
//	}
//
//	public void setRelationshipType(Integer relationshipType) {
//		this.relationshipType = relationshipType;
//	}
//
//	public Integer getTestSequence() {
//		return testSequence;
//	}
//
//	public void setTestSequence(Integer testSequence) {
//		this.testSequence = testSequence;
//	}

	public Integer getTiReferralId() {
		return tiReferralId;
	}

	public void setTiReferralId(Integer tiReferralId) {
		this.tiReferralId = tiReferralId;
	}

	public String getTiReferralName() {
		return tiReferralName;
	}

	public void setTiReferralName(String tiReferralName) {
		this.tiReferralName = tiReferralName;
	}

	public Integer getArtReferralId() {
		return artReferralId;
	}

	public void setArtReferralId(Integer integer) {
		this.artReferralId = integer;
	}

	public String getArtReferralName() {
		return artReferralName;
	}

	public void setArtReferralName(String artReferralName) {
		this.artReferralName = artReferralName;
	}

	public Integer getDsrcReferralId() {
		return dsrcReferralId;
	}

	public void setDsrcReferralId(Integer dsrcReferralId) {
		this.dsrcReferralId = dsrcReferralId;
	}

	public String getDsrcReferralName() {
		return dsrcReferralName;
	}

	public void setDsrcReferralName(String dsrcReferralName) {
		this.dsrcReferralName = dsrcReferralName;
	}

	public Integer getRntcpReferralId() {
		return rntcpReferralId;
	}

	public void setRntcpReferralId(Integer rntcpReferralId) {
		this.rntcpReferralId = rntcpReferralId;
	}

	public String getRntcpReferralName() {
		return rntcpReferralName;
	}

	public void setRntcpReferralName(String rntcpReferralName) {
		this.rntcpReferralName = rntcpReferralName;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public Date getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(Date sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(Integer deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String getDeletedReasonComment() {
		return deletedReasonComment;
	}

	public void setDeletedReasonComment(String deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
	}
	
	public Integer getRegisteredFacilityId() {
		return registeredFacilityId;
	}

	public void setRegisteredFacilityId(Integer registeredFacilityId) {
		this.registeredFacilityId = registeredFacilityId;
	}

	public Integer getInfantMotherBeneficiaryId() {
		return infantMotherBeneficiaryId;
	}

	public void setInfantMotherBeneficiaryId(Integer infantMotherBeneficiaryId) {
		this.infantMotherBeneficiaryId = infantMotherBeneficiaryId;
	}
	
	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getHivStatusDesc() {
		return hivStatusDesc;
	}

	public void setHivStatusDesc(String hivStatusDesc) {
		this.hivStatusDesc = hivStatusDesc;
	}

	public String getBeneficiaryStatusDesc() {
		return beneficiaryStatusDesc;
	}

	public void setBeneficiaryStatusDesc(String beneficiaryStatusDesc) {
		this.beneficiaryStatusDesc = beneficiaryStatusDesc;
	}

	public String getTestTypeDesc() {
		return testTypeDesc;
	}

	public void setTestTypeDesc(String testTypeDesc) {
		this.testTypeDesc = testTypeDesc;
	}
	
	public Date getResultModifiedTime() {
		return resultModifiedTime;
	}

	public void setResultModifiedTime(Date resultModifiedTime) {
		this.resultModifiedTime = resultModifiedTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO = (ICTCBeneficiaryVisitDTO) o;
		if (iCTCBeneficiaryVisitDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), iCTCBeneficiaryVisitDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryVisitDTO [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", visitDate=" + visitDate
				+ ", beneficiaryId=" + beneficiaryId + ", mobileNumber=" + mobileNumber + ", age=" + age
				+ ", isPregnant=" + isPregnant + ", testedDate=" + testedDate + ", reportReceivedDate="
				+ reportReceivedDate + ", reportDeliveryDate=" + reportDeliveryDate + ", hivStatus=" + hivStatus
				+ ", hivType=" + hivType + ", infantBreastFed=" + infantBreastFed + ", dateOfBirth=" + dateOfBirth
				+ ", barcode=" + barcode + ", resultStatus=" + resultStatus + ", visitId=" + visitId
				+ ", infantMotherArtNo=" + infantMotherArtNo + ", infantMotherArtId=" + infantMotherArtId
				+ ", infantMotherLastName=" + infantMotherLastName + ", infantMotherFirstName=" + infantMotherFirstName
				+ ", infantCode=" + infantCode + ", occupationId=" + occupationId + ", maritalStatusId="
				+ maritalStatusId + ", testType=" + testType + ", isConsentDocumented=" + isConsentDocumented
				+ ", beneficiaryStatus=" + beneficiaryStatus + ", currentTestResultId=" + currentTestResultId
				+ ", tiReferralId=" + tiReferralId + ", tiReferralName=" + tiReferralName + ", artReferralId="
				+ artReferralId + ", artReferralName=" + artReferralName + ", dsrcReferralId=" + dsrcReferralId
				+ ", dsrcReferralName=" + dsrcReferralName + ", rntcpReferralId=" + rntcpReferralId
				+ ", rntcpReferralName=" + rntcpReferralName + ", batchId=" + batchId + ", consignmentId="
				+ consignmentId + ", labId=" + labId + ", labName=" + labName + ", labCode=" + labCode
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", facilityId=" + facilityId + ", categoryId="
				+ categoryId + ", genderId=" + genderId + ", deletedReason=" + deletedReason + ", deletedReasonComment="
				+ deletedReasonComment + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", registeredFacilityId=" + registeredFacilityId + ", infantMotherBeneficiaryId="
				+ infantMotherBeneficiaryId + ", hivStatusDesc=" + hivStatusDesc + ", beneficiaryStatusDesc="
				+ beneficiaryStatusDesc + ", testTypeDesc=" + testTypeDesc + "]";
	}

}

