package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCSampleBatch} entity.
 */
public class ICTCSampleBatchDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
    private Long id;

    private String consignmentId;

    private LocalDateTime dispatchDate;

    private Integer batchStatus;

    private Long createdBy;

    private LocalDateTime createdTime;

    private Long modifiedBy;

    private LocalDateTime modifiedTime;

    private Boolean isActive;

    private Boolean isDeleted;
    
    private Long facilityId;

    private Long labId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public String getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
    }

    public LocalDateTime getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Integer getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCSampleBatchDTO iCTCSampleBatchDTO = (ICTCSampleBatchDTO) o;
        if (iCTCSampleBatchDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCSampleBatchDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ICTCSampleBatchDTO{" +
            "id=" + getId() +
            ", labId=" + getLabId() +
            ", consignmentId='" + getConsignmentId() + "'" +
            ", dispatchDate='" + getDispatchDate() + "'" +
            ", batchStatus='" + getBatchStatus() + "'" +
            ", facilityId=" + getFacilityId() +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            "}";
    }
}
