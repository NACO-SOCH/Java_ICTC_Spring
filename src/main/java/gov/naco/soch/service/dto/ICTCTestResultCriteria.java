package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * Criteria class for the ICTCTestResult entity. This class is used in ICTCTestResultResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-test-results?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link } class are used, we need to use
 * fix type specific filters.
 */
public class ICTCTestResultCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

//    private Date testedDate;

    private Integer resultStatus;

    private Integer hivStatus;

    private Integer hivType;

    private Date reportReceivedDate;

    private Date reportDeliveryDate;

    private Boolean isTestedForTb;

    private Integer tbTestResult;

    private Boolean isTestedForSyphilis;

    private Integer syphilisTestResult;

//    private Boolean followupRequired;
//
//    private Boolean isReferedToART;

    private Boolean isActive;

    private Boolean isDeleted;

    private Long createdBy;

    private Date createdTime;

    private Long modifiedBy;

    private Date modifiedTime;

    private Long ictcBeneficiaryId;

    private Long sampleId;

    private Long visitId;

    public ICTCTestResultCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Date getTestedDate() {
//        return testedDate;
//    }
//
//    public void setTestedDate(Date testedDate) {
//        this.testedDate = testedDate;
//    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
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

    public Date getReportReceivedDate() {
        return reportReceivedDate;
    }

    public void setReportReceivedDate(Date reportReceivedDate) {
        this.reportReceivedDate = reportReceivedDate;
    }

    public Date getReportDeliveryDate() {
        return reportDeliveryDate;
    }

    public void setReportDeliveryDate(Date reportDeliveryDate) {
        this.reportDeliveryDate = reportDeliveryDate;
    }

    public Boolean getIsTestedForTb() {
        return isTestedForTb;
    }

    public void setIsTestedForTb(Boolean isTestedForTb) {
        this.isTestedForTb = isTestedForTb;
    }

    public Integer getTbTestResult() {
        return tbTestResult;
    }

    public void setTbTestResult(Integer tbTestResult) {
        this.tbTestResult = tbTestResult;
    }

    public Boolean getIsTestedForSyphilis() {
        return isTestedForSyphilis;
    }

    public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
        this.isTestedForSyphilis = isTestedForSyphilis;
    }

    public Integer getSyphilisTestResult() {
        return syphilisTestResult;
    }

    public void setSyphilisTestResult(Integer syphilisTestResult) {
        this.syphilisTestResult = syphilisTestResult;
    }

//    public Boolean getFollowupRequired() {
//        return followupRequired;
//    }
//
//    public void setFollowupRequired(Boolean followupRequired) {
//        this.followupRequired = followupRequired;
//    }
//
//    public Boolean getIsReferedToART() {
//        return isReferedToART;
//    }
//
//    public void setIsReferedToART(Boolean isReferedToART) {
//        this.isReferedToART = isReferedToART;
//    }

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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }
    
    public Long getSampleId() {
		return sampleId;
	}

	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	@Override
	public String toString() {
		return "ICTCTestResultCriteria [id=" + id + ", resultStatus=" + resultStatus + ", hivStatus=" + hivStatus
				+ ", hivType=" + hivType + ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate="
				+ reportDeliveryDate + ", isTestedForTb=" + isTestedForTb + ", tbTestResult=" + tbTestResult
				+ ", isTestedForSyphilis=" + isTestedForSyphilis + ", syphilisTestResult=" + syphilisTestResult
				+ ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", ictcBeneficiaryId="
				+ ictcBeneficiaryId + ", sampleId=" + sampleId + ", visitId=" + visitId + "]";
	}

}
