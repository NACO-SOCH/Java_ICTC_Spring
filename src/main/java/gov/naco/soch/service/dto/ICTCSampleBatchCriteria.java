package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCSampleBatch} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCSampleBatchResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-sample-batches?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link } class are used, we need to use
 * fix type specific filters.
 */
public class ICTCSampleBatchCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String consignmentId;

//    private Date dispatchDate;

    private Integer batchStatus;

    private Long createdBy;

    private Date createdTime;

    private Long modifiedBy;

    private Date modifiedTime;

    private Boolean isActive;

    private Boolean isDeleted;
    
    private Long facilityId;
    
    private Long labId;

    public ICTCSampleBatchCriteria() {
    }

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

//    public Date getDispatchDate() {
//        return dispatchDate;
//    }
//
//    public void setDispatchDate(Date dispatchDate) {
//        this.dispatchDate = dispatchDate;
//    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ICTCSampleBatchCriteria that = (ICTCSampleBatchCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(labId, that.labId) &&
            Objects.equals(consignmentId, that.consignmentId) &&
//            Objects.equals(dispatchDate, that.dispatchDate) &&
            Objects.equals(batchStatus, that.batchStatus) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        labId,
        consignmentId,
//        dispatchDate,
        batchStatus,
        facilityId,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        isActive,
        isDeleted
        );
    }

    @Override
    public String toString() {
        return "ICTCSampleBatchCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (labId != null ? "labId=" + labId + ", " : "") +
                (consignmentId != null ? "consignmentId=" + consignmentId + ", " : "") +
//                (dispatchDate != null ? "dispatchDate=" + dispatchDate + ", " : "") +
                (batchStatus != null ? "batchStatus=" + batchStatus + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
            "}";
    }

}
