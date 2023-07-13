package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCBeneficiaryVisit} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCBeneficiaryVisitResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-beneficiary-visits?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link  } class are used, we need to use
 * fix type specific filters.
 */
public class ICTCBeneficiaryVisitCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long  id;

	private String  pid;

	private String  uid;

	private String  firstName;

	private String  middleName;

	private String  lastName;

	private Date  visitDate;

	private Long  beneficiaryId;

	private String  mobileNumber;

	private String  age;

//	private String  category;

	private Boolean  isPregnant;

//	private String  gender;

//	private Date  testedDate;

	private Date  reportReceivedDate;
	
	private Date  reportDeliveryDate;

	private Integer  hivStatus;

	private Integer  hivType;

	private Integer  infantBreastFed;

	private Date  dateOfBirth;

	private String  barcode;

	private Integer  resultStatus;

	private Long  visitId;

	private String  infantMotherArtNo;

	private Long  infantMotherArtId;

	private String  infantMotherFirstName;
	
	private String  infantMotherLastName;

	private String  infantCode;

	private Integer  occupationId;

	private Integer  maritalStatusId;

	private Integer  testType;
	
	private Boolean  isConsentDocumented;
	
	private Integer  beneficiaryStatus;
	
	private Long  batchId;

	private String  consignmentId;

	private Long  labId;

	private String  labName;

	private String  labCode;
	
	private Long  facilityId;
	
	private Integer  categoryId;

	private Integer  genderId;
	
	private Integer  deletedReason;
	
	private String  deletedReasonComment;
	
	private Boolean  isActive;

	private Boolean  isDeleted;
	
	private String  hivStatusDesc;

	private String  beneficiaryStatusDesc;

	private String  testTypeDesc;

    public ICTCBeneficiaryVisitCriteria() {
    }


	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public String  getPid() {
		return pid;
	}

	public void setPid(String  pid) {
		this.pid = pid;
	}

	public String  getUid() {
		return uid;
	}

	public void setUid(String  uid) {
		this.uid = uid;
	}

	public String  getFirstName() {
		return firstName;
	}

	public void setFirstName(String  firstName) {
		this.firstName = firstName;
	}

	public String  getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String  middleName) {
		this.middleName = middleName;
	}

	public String  getLastName() {
		return lastName;
	}

	public void setLastName(String  lastName) {
		this.lastName = lastName;
	}

	public Date  getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date  visitDate) {
		this.visitDate = visitDate;
	}

	public Long  getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long  beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String  getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String  mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String  getAge() {
		return age;
	}

	public void setAge(String  age) {
		this.age = age;
	}

//	public String  getCategory() {
//		return category;
//	}
//
//	public void setCategory(String  category) {
//		this.category = category;
//	}

	public Boolean  getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean  isPregnant) {
		this.isPregnant = isPregnant;
	}

//	public String  getGender() {
//		return gender;
//	}
//
//	public void setGender(String  gender) {
//		this.gender = gender;
//	}

//	public Date  getTestedDate() {
//		return testedDate;
//	}
//
//	public void setTestedDate(Date  testedDate) {
//		this.testedDate = testedDate;
//	}

	public Date  getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(Date  reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public Date  getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(Date  reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Integer  getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Integer  hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Integer  getHivType() {
		return hivType;
	}

	public void setHivType(Integer  hivType) {
		this.hivType = hivType;
	}

	public Integer  getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer  infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Date  getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date  dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String  getBarcode() {
		return barcode;
	}

	public void setBarcode(String  barcode) {
		this.barcode = barcode;
	}

	public Integer  getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer  resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long  getVisitId() {
		return visitId;
	}

	public void setVisitId(Long  visitId) {
		this.visitId = visitId;
	}

	public String  getInfantMotherArtNo() {
		return infantMotherArtNo;
	}

	public void setInfantMotherArtNo(String  infantMotherArtNo) {
		this.infantMotherArtNo = infantMotherArtNo;
	}

	public Long  getInfantMotherArtId() {
		return infantMotherArtId;
	}

	public void setInfantMotherArtId(Long  infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public String  getInfantMotherFirstName() {
		return infantMotherFirstName;
	}

	public void setInfantMotherFirstName(String  infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
	}

	public String  getInfantMotherLastName() {
		return infantMotherLastName;
	}

	public void setInfantMotherLastName(String  infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}

	public String  getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String  infantCode) {
		this.infantCode = infantCode;
	}

//	public String  getOccupation() {
//		return occupation;
//	}
//
//	public void setOccupation(String  occupation) {
//		this.occupation = occupation;
//	}
//
//	public String  getMaritalStatus() {
//		return maritalStatus;
//	}
//
//	public void setMaritalStatus(String  maritalStatus) {
//		this.maritalStatus = maritalStatus;
//	}

	public Integer  getTestType() {
		return testType;
	}

	public Integer  getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer  occupationId) {
		this.occupationId = occupationId;
	}

	public Integer  getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer  maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public void setTestType(Integer  testType) {
		this.testType = testType;
	}
	

	public Boolean  getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean  isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public Integer  getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer  beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}
	
	public Long  getBatchId() {
		return batchId;
	}

	public void setBatchId(Long  batchId) {
		this.batchId = batchId;
	}

	public String  getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String  consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Long  getLabId() {
		return labId;
	}

	public void setLabId(Long  labId) {
		this.labId = labId;
	}

	public String  getLabName() {
		return labName;
	}

	public void setLabName(String  labName) {
		this.labName = labName;
	}

	public String  getLabCode() {
		return labCode;
	}

	public void setLabCode(String  labCode) {
		this.labCode = labCode;
	}
	
	public Long  getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long  facilityId) {
		this.facilityId = facilityId;
	}
	
	public Integer  getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer  categoryId) {
		this.categoryId = categoryId;
	}

	public Integer  getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer  genderId) {
		this.genderId = genderId;
	}
	
	public Integer  getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(Integer  deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String  getDeletedReasonComment() {
		return deletedReasonComment;
	}

	public void setDeletedReasonComment(String  deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
	}

	public Boolean  getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean  isActive) {
		this.isActive = isActive;
	}

	public Boolean  getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean  isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public String  getHivStatusDesc() {
		return hivStatusDesc;
	}

	public void setHivStatusDesc(String  hivStatusDesc) {
		this.hivStatusDesc = hivStatusDesc;
	}

	public String  getBeneficiaryStatusDesc() {
		return beneficiaryStatusDesc;
	}

	public void setBeneficiaryStatusDesc(String  beneficiaryStatusDesc) {
		this.beneficiaryStatusDesc = beneficiaryStatusDesc;
	}

	public String  getTestTypeDesc() {
		return testTypeDesc;
	}

	public void setTestTypeDesc(String  testTypeDesc) {
		this.testTypeDesc = testTypeDesc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, barcode, batchId, beneficiaryId, beneficiaryStatus, beneficiaryStatusDesc, categoryId,
				consignmentId, dateOfBirth, deletedReason, deletedReasonComment, facilityId, firstName, genderId,
				hivStatus, hivStatusDesc, hivType, id, infantBreastFed, infantCode, infantMotherArtId,
				infantMotherArtNo, infantMotherFirstName, infantMotherLastName, isActive, isConsentDocumented,
				isDeleted, isPregnant, labCode, labId, labName, lastName, maritalStatusId, middleName, mobileNumber,
				occupationId, pid, reportDeliveryDate, reportReceivedDate, resultStatus, testType, testTypeDesc, uid,
				visitDate, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCBeneficiaryVisitCriteria other = (ICTCBeneficiaryVisitCriteria) obj;
		return Objects.equals(age, other.age) && Objects.equals(barcode, other.barcode)
				&& Objects.equals(batchId, other.batchId) && Objects.equals(beneficiaryId, other.beneficiaryId)
				&& Objects.equals(beneficiaryStatus, other.beneficiaryStatus)
				&& Objects.equals(beneficiaryStatusDesc, other.beneficiaryStatusDesc)
				&& Objects.equals(categoryId, other.categoryId) && Objects.equals(consignmentId, other.consignmentId)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(deletedReason, other.deletedReason)
				&& Objects.equals(deletedReasonComment, other.deletedReasonComment)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(genderId, other.genderId) && Objects.equals(hivStatus, other.hivStatus)
				&& Objects.equals(hivStatusDesc, other.hivStatusDesc) && Objects.equals(hivType, other.hivType)
				&& Objects.equals(id, other.id) && Objects.equals(infantBreastFed, other.infantBreastFed)
				&& Objects.equals(infantCode, other.infantCode)
				&& Objects.equals(infantMotherArtId, other.infantMotherArtId)
				&& Objects.equals(infantMotherArtNo, other.infantMotherArtNo)
				&& Objects.equals(infantMotherFirstName, other.infantMotherFirstName)
				&& Objects.equals(infantMotherLastName, other.infantMotherLastName)
				&& Objects.equals(isActive, other.isActive)
				&& Objects.equals(isConsentDocumented, other.isConsentDocumented)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(isPregnant, other.isPregnant)
				&& Objects.equals(labCode, other.labCode) && Objects.equals(labId, other.labId)
				&& Objects.equals(labName, other.labName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(maritalStatusId, other.maritalStatusId)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(occupationId, other.occupationId) && Objects.equals(pid, other.pid)
				&& Objects.equals(reportDeliveryDate, other.reportDeliveryDate)
				&& Objects.equals(reportReceivedDate, other.reportReceivedDate)
				&& Objects.equals(resultStatus, other.resultStatus) && Objects.equals(testType, other.testType)
				&& Objects.equals(testTypeDesc, other.testTypeDesc) && Objects.equals(uid, other.uid)
				&& Objects.equals(visitDate, other.visitDate) && Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryVisitCriteria [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", visitDate=" + visitDate
				+ ", beneficiaryId=" + beneficiaryId + ", mobileNumber=" + mobileNumber + ", age=" + age
				+ ", isPregnant=" + isPregnant + ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate="
				+ reportDeliveryDate + ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", infantBreastFed="
				+ infantBreastFed + ", dateOfBirth=" + dateOfBirth + ", barcode=" + barcode + ", resultStatus="
				+ resultStatus + ", visitId=" + visitId + ", infantMotherArtNo=" + infantMotherArtNo
				+ ", infantMotherArtId=" + infantMotherArtId + ", infantMotherFirstName=" + infantMotherFirstName
				+ ", infantMotherLastName=" + infantMotherLastName + ", infantCode=" + infantCode + ", occupationId="
				+ occupationId + ", maritalStatusId=" + maritalStatusId + ", testType=" + testType
				+ ", isConsentDocumented=" + isConsentDocumented + ", beneficiaryStatus=" + beneficiaryStatus
				+ ", batchId=" + batchId + ", consignmentId=" + consignmentId + ", labId=" + labId + ", labName="
				+ labName + ", labCode=" + labCode + ", facilityId=" + facilityId + ", categoryId=" + categoryId
				+ ", genderId=" + genderId + ", deletedReason=" + deletedReason + ", deletedReasonComment="
				+ deletedReasonComment + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", hivStatusDesc="
				+ hivStatusDesc + ", beneficiaryStatusDesc=" + beneficiaryStatusDesc + ", testTypeDesc=" + testTypeDesc
				+ "]";
	}

}
