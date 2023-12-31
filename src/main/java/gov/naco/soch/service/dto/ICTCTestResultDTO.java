package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the ICTCTestResult entity.
 */
public class ICTCTestResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;

    private LocalDateTime testedDate;

    private Integer resultStatus;

    private Integer hivStatus;

    private Integer hivType;

    private LocalDate reportReceivedDate;

    private LocalDate reportDeliveryDate;

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

    private LocalDateTime createdTime;

    private Long modifiedBy;

    private LocalDateTime modifiedTime;

    private Long ictcBeneficiaryId;

    private Long sampleId;

    private Long visitId;
    
//    private Integer testSequence;
    
//    public Integer getTestSequence() {
//		return testSequence;
//	}
//
//	public void setTestSequence(Integer testSequence) {
//		this.testSequence = testSequence;
//	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTestedDate() {
        return testedDate;
    }

    public void setTestedDate(LocalDateTime testedDate) {
        this.testedDate = testedDate;
    }

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

    public LocalDate getReportReceivedDate() {
        return reportReceivedDate;
    }

    public void setReportReceivedDate(LocalDate reportReceivedDate) {
        this.reportReceivedDate = reportReceivedDate;
    }

    public LocalDate getReportDeliveryDate() {
        return reportDeliveryDate;
    }

    public void setReportDeliveryDate(LocalDate reportDeliveryDate) {
        this.reportDeliveryDate = reportDeliveryDate;
    }

    public Boolean isIsTestedForTb() {
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

    public Boolean isIsTestedForSyphilis() {
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

//    public Boolean isFollowupRequired() {
//        return followupRequired;
//    }
//
//    public void setFollowupRequired(Boolean followupRequired) {
//        this.followupRequired = followupRequired;
//    }
//
//    public Boolean isIsReferedToART() {
//        return isReferedToART;
//    }
//
//    public void setIsReferedToART(Boolean isReferedToART) {
//        this.isReferedToART = isReferedToART;
//    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDeleted() {
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

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(Long iCTCBeneficiaryId) {
        this.ictcBeneficiaryId = iCTCBeneficiaryId;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCTestResultDTO iCTCTestResultDTO = (ICTCTestResultDTO) o;
        if (iCTCTestResultDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCTestResultDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCTestResultDTO [id=" + id + ", testedDate=" + testedDate + ", resultStatus=" + resultStatus
				+ ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", reportReceivedDate=" + reportReceivedDate
				+ ", reportDeliveryDate=" + reportDeliveryDate + ", isTestedForTb=" + isTestedForTb + ", tbTestResult="
				+ tbTestResult + ", isTestedForSyphilis=" + isTestedForSyphilis + ", syphilisTestResult="
				+ syphilisTestResult + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", sampleId=" + sampleId + ", visitId="
				+ visitId + "]";
	}

}
