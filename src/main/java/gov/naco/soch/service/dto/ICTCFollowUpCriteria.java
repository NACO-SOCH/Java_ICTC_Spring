package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCFollowUp} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCFollowUpResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-follow-ups?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link  } class are used, we need to use
 * fix type specific filters.
 */
public class ICTCFollowUpCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long  id;

    private Integer  followUpType;

    private Date  followUpDate;

//    private String  remarks;

    private Boolean  isCompleted;
    
    private Boolean  isActive;

    private Boolean  isDeleted;

    private Long  createdBy;

    private Date  createdTime;

    private Long  modifiedBy;

    private Date  modifiedTime;

    private Long  ictcBeneficiaryId;

    private Long  visitId;
    
    private Long  facilityId;
    
    private Long  testResultId;

    public ICTCFollowUpCriteria() {
    }


   

    public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public Integer  getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(Integer  followUpType) {
		this.followUpType = followUpType;
	}

	public Date  getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date  followUpDate) {
		this.followUpDate = followUpDate;
	}

//	public String  getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String  remarks) {
//		this.remarks = remarks;
//	}

	public Boolean  getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean  isCompleted) {
		this.isCompleted = isCompleted;
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

	public Long  getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long  createdBy) {
		this.createdBy = createdBy;
	}

	public Date  getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date  createdTime) {
		this.createdTime = createdTime;
	}

	public Long  getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long  modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date  getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date  modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Long  getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long  ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long  getVisitId() {
		return visitId;
	}

	public void setVisitId(Long  visitId) {
		this.visitId = visitId;
	}

	public Long  getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long  facilityId) {
		this.facilityId = facilityId;
	}

	public Long  getTestResultId() {
		return testResultId;
	}

	public void setTestResultId(Long  testResultId) {
		this.testResultId = testResultId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdTime, facilityId, followUpDate, followUpType, ictcBeneficiaryId, id,
				isActive, isCompleted, isDeleted, modifiedBy, modifiedTime, testResultId, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCFollowUpCriteria other = (ICTCFollowUpCriteria) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(followUpDate, other.followUpDate)
				&& Objects.equals(followUpType, other.followUpType)
				&& Objects.equals(ictcBeneficiaryId, other.ictcBeneficiaryId) && Objects.equals(id, other.id)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(isCompleted, other.isCompleted)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime) && Objects.equals(testResultId, other.testResultId)
				&& Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCFollowUpCriteria [id=" + id + ", followUpType=" + followUpType + ", followUpDate=" + followUpDate
				+ ", isCompleted=" + isCompleted + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", visitId=" + visitId
				+ ", facilityId=" + facilityId + ", testResultId=" + testResultId + "]";
	}

}
