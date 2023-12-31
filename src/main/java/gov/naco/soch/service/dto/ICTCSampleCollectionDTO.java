package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import gov.naco.soch.domain.UserMaster;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCSampleCollection} entity.
 */
public class ICTCSampleCollectionDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String barcode;

    private Integer testType;
    
    private LocalDateTime sampleCollectionDate;
    
    private Integer sampleCollectionStatus;
    
    private LocalDateTime sampleReceivedDate;
   
    private Boolean isDispatched;

//    private Integer dispatchedToLabId;
//
//    private LocalDate dispatchDate;

    private Boolean isActive;

    private Boolean isDeleted;

    private Long createdBy;

    private LocalDateTime createdTime;

    private Long modifiedBy;

    private LocalDateTime modifiedTime;
    
    private Boolean isEighteenPlus;

    private Long batchId;
   
	private Long ictcBeneficiaryId;
	
	private Long visitId;
	
	private Long facilityId;
	
	private UserMaster labTechnician;
	
	private UserMaster labIncharge;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public LocalDateTime getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public Integer getSampleCollectionStatus() {
		return sampleCollectionStatus;
	}

	public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
		this.sampleCollectionStatus = sampleCollectionStatus;
	}

	public Boolean getIsDispatched() {
		return isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
	}

//	public Integer getDispatchedToLabId() {
//		return dispatchedToLabId;
//	}
//
//	public void setDispatchedToLabId(Integer dispatchedToLabId) {
//		this.dispatchedToLabId = dispatchedToLabId;
//	}
//
//	public LocalDate getDispatchDate() {
//		return dispatchDate;
//	}
//
//	public void setDispatchDate(LocalDate dispatchDate) {
//		this.dispatchDate = dispatchDate;
//	}

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

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
	public UserMaster getLabTechnician() {
		return labTechnician;
	}

	public void setLabTechnician(UserMaster labTechnician) {
		this.labTechnician = labTechnician;
	}

	public UserMaster getLabIncharge() {
		return labIncharge;
	}

	public void setLabIncharge(UserMaster labIncharge) {
		this.labIncharge = labIncharge;
	}
	
	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}
	
	public Boolean getIsEighteenPlus() {
		return isEighteenPlus;
	}

	public void setIsEighteenPlus(Boolean isEighteenPlus) {
		this.isEighteenPlus = isEighteenPlus;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCSampleCollectionDTO iCTCSampleCollectionDTO = (ICTCSampleCollectionDTO) o;
        if (iCTCSampleCollectionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCSampleCollectionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCSampleCollectionDTO [id=" + id + ", barcode=" + barcode + ", testType=" + testType
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", sampleReceivedDate=" + sampleReceivedDate + ", isDispatched="
				+ isDispatched + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", isEighteenPlus=" + isEighteenPlus + ", batchId=" + batchId + ", ictcBeneficiaryId="
				+ ictcBeneficiaryId + ", visitId=" + visitId + ", facilityId=" + facilityId + ", labTechnician="
				+ labTechnician + ", labIncharge=" + labIncharge + "]";
	}
    
}
