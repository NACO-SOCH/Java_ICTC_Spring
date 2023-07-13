package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Criteria class for the {@link gov.naco.soch.domain.BeneficiaryReferral} entity. This class is used
 * in {@link gov.naco.soch.web.rest.BeneficiaryReferralResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /beneficiary-referrals?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryReferralCriteria  {

    private static final long serialVersionUID = 1L;

    private Long id;

	private Date dateOfHivTest;

	private Date dateOfVisit;

	private String hivStatus;

	private Boolean isActive;

	private Boolean isDelete;

	private Date referDate;

	private String referralType;

	private String typeOfHiv;

	private Date acceptedDate;

	private Date declinedDate;

	private String referralReason;

	private Integer referredBy;

	private Long beneficiaryId;

	private Long referedFrom;

	private Long referedTo;

	private Integer referralStatusId;

	private Long tiBeneficiaryId;

	private Long tiBenScrId;

	private Integer createdBy;

	private Integer modifiedBy;

	private Integer referralTypeId;
	
	private String beneficiaryName;
	
	private String referralFacilityName;
	
	private String mobileNumber;
	
	private String gender;
	
	private Integer genderId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String uid;
	
	private Long facilityTypeId;
	
	private Long acceptedFacility;

	private Long currentFacId;
	
	private Integer ictcBenStatus;
	
	private Long referredFromFacilityTypeId;

	public BeneficiaryReferralCriteria() {
    }

  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfHivTest() {
		return dateOfHivTest;
	}

	public void setDateOfHivTest(Date dateOfHivTest) {
		this.dateOfHivTest = dateOfHivTest;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getReferDate() {
		return referDate;
	}

	public void setReferDate(Date referDate) {
		this.referDate = referDate;
	}

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public String getTypeOfHiv() {
		return typeOfHiv;
	}

	public void setTypeOfHiv(String typeOfHiv) {
		this.typeOfHiv = typeOfHiv;
	}

	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Date getDeclinedDate() {
		return declinedDate;
	}

	public void setDeclinedDate(Date declinedDate) {
		this.declinedDate = declinedDate;
	}

	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}

	public Integer getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getReferedFrom() {
		return referedFrom;
	}

	public void setReferedFrom(Long referedFrom) {
		this.referedFrom = referedFrom;
	}

	public Long getReferedTo() {
		return referedTo;
	}

	public void setReferedTo(Long referedTo) {
		this.referedTo = referedTo;
	}

	public Integer getReferralStatusId() {
		return referralStatusId;
	}

	public void setReferralStatusId(Integer referralStatusId) {
		this.referralStatusId = referralStatusId;
	}

	public Long getTiBeneficiaryId() {
		return tiBeneficiaryId;
	}

	public void setTiBeneficiaryId(Long tiBeneficiaryId) {
		this.tiBeneficiaryId = tiBeneficiaryId;
	}

	public Long getTiBenScrId() {
		return tiBenScrId;
	}

	public void setTiBenScrId(Long tiBenScrId) {
		this.tiBenScrId = tiBenScrId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer getReferralTypeId() {
		return referralTypeId;
	}

	public void setReferralTypeId(Integer referralTypeId) {
		this.referralTypeId = referralTypeId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getReferralFacilityName() {
		return referralFacilityName;
	}

	public void setReferralFacilityName(String referralFacilityName) {
		this.referralFacilityName = referralFacilityName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	
	public Long getAcceptedFacility() {
		return acceptedFacility;
	}

	public void setAcceptedFacility(Long acceptedFacility) {
		this.acceptedFacility = acceptedFacility;
	}

	public Long getCurrentFacId() {
		return currentFacId;
	}

	public void setCurrentFacId(Long currentFacId) {
		this.currentFacId = currentFacId;
	}
	
	public Integer getIctcBenStatus() {
		return ictcBenStatus;
	}

	public void setIctcBenStatus(Integer ictcBenStatus) {
		this.ictcBenStatus = ictcBenStatus;
	}
	
	public Long getReferredFromFacilityTypeId() {
		return referredFromFacilityTypeId;
	}

	public void setReferredFromFacilityTypeId(Long referredFromFacilityTypeId) {
		this.referredFromFacilityTypeId = referredFromFacilityTypeId;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(acceptedDate, acceptedFacility, beneficiaryId, beneficiaryName, createdBy, currentFacId,
//				dateOfHivTest, dateOfVisit, declinedDate, facilityTypeId, firstName, gender, genderId, hivStatus,
//				ictcBenStatus, id, isActive, isDelete, lastName, middleName, mobileNumber, modifiedBy, referDate,
//				referedFrom, referedTo, referralFacilityName, referralReason, referralStatusId, referralType,
//				referralTypeId, referredBy, tiBenScrId, tiBeneficiaryId, typeOfHiv, uid);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BeneficiaryReferralCriteria other = (BeneficiaryReferralCriteria) obj;
//		return Objects.equals(acceptedDate, other.acceptedDate)
//				&& Objects.equals(acceptedFacility, other.acceptedFacility)
//				&& Objects.equals(beneficiaryId, other.beneficiaryId)
//				&& Objects.equals(beneficiaryName, other.beneficiaryName) && Objects.equals(createdBy, other.createdBy)
//				&& Objects.equals(currentFacId, other.currentFacId)
//				&& Objects.equals(dateOfHivTest, other.dateOfHivTest) && Objects.equals(dateOfVisit, other.dateOfVisit)
//				&& Objects.equals(declinedDate, other.declinedDate)
//				&& Objects.equals(facilityTypeId, other.facilityTypeId) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(gender, other.gender) && Objects.equals(genderId, other.genderId)
//				&& Objects.equals(hivStatus, other.hivStatus) && Objects.equals(ictcBenStatus, other.ictcBenStatus)
//				&& Objects.equals(id, other.id) && Objects.equals(isActive, other.isActive)
//				&& Objects.equals(isDelete, other.isDelete) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNumber, other.mobileNumber)
//				&& Objects.equals(modifiedBy, other.modifiedBy) && Objects.equals(referDate, other.referDate)
//				&& Objects.equals(referedFrom, other.referedFrom) && Objects.equals(referedTo, other.referedTo)
//				&& Objects.equals(referralFacilityName, other.referralFacilityName)
//				&& Objects.equals(referralReason, other.referralReason)
//				&& Objects.equals(referralStatusId, other.referralStatusId)
//				&& Objects.equals(referralType, other.referralType)
//				&& Objects.equals(referralTypeId, other.referralTypeId) && Objects.equals(referredBy, other.referredBy)
//				&& Objects.equals(referredFromFacilityTypeId, other.referredFromFacilityTypeId)
//				&& Objects.equals(tiBenScrId, other.tiBenScrId)
//				&& Objects.equals(tiBeneficiaryId, other.tiBeneficiaryId) && Objects.equals(typeOfHiv, other.typeOfHiv)
//				&& Objects.equals(uid, other.uid);
//	}

	@Override
	public String toString() {
		return "BeneficiaryReferralCriteria [id=" + id + ", dateOfHivTest=" + dateOfHivTest + ", dateOfVisit="
				+ dateOfVisit + ", hivStatus=" + hivStatus + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", referDate=" + referDate + ", referralType=" + referralType + ", typeOfHiv=" + typeOfHiv
				+ ", acceptedDate=" + acceptedDate + ", declinedDate=" + declinedDate + ", referralReason="
				+ referralReason + ", referredBy=" + referredBy + ", beneficiaryId=" + beneficiaryId + ", referedFrom="
				+ referedFrom + ", referedTo=" + referedTo + ", referralStatusId=" + referralStatusId
				+ ", tiBeneficiaryId=" + tiBeneficiaryId + ", tiBenScrId=" + tiBenScrId + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", referralTypeId=" + referralTypeId + ", beneficiaryName="
				+ beneficiaryName + ", referralFacilityName=" + referralFacilityName + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ", genderId=" + genderId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", uid=" + uid + ", facilityTypeId=" + facilityTypeId
				+ ", acceptedFacility=" + acceptedFacility + ", currentFacId=" + currentFacId + ", ictcBenStatus="
				+ ictcBenStatus + ", referredFromFacilityTypeId=" + referredFromFacilityTypeId + "]";
	}
	
}
