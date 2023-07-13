package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



/**
 * Criteria class for the {@link gov.naco.soch.domain.IctcLinkedFacility} entity. This class is used
 * in {@link gov.naco.soch.web.rest.IctcLinkedFacilityResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-linked-facilities?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link } class are used, we need to use
 * fix type specific filters.
 */
public class IctcLinkedFacilityCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String facilityName;

    private Long linkedFacilityId;

    private Long facilityId;

    private String facilityType;

    private Boolean isActive;

    private Boolean isDeleted;

    private String status;

    private Long createdBy;

    private Date createdTime;

    private Long modifiedBy;

    private Date modifiedTime;

    public IctcLinkedFacilityCriteria() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Long getLinkedFacilityId() {
        return linkedFacilityId;
    }

    public void setLinkedFacilityId(Long linkedFacilityId) {
        this.linkedFacilityId = linkedFacilityId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IctcLinkedFacilityCriteria that = (IctcLinkedFacilityCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(facilityName, that.facilityName) &&
            Objects.equals(linkedFacilityId, that.linkedFacilityId) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(facilityType, that.facilityType) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(status, that.status) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        facilityName,
        linkedFacilityId,
        facilityId,
        facilityType,
        isActive,
        isDeleted,
        status,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime
        );
    }

    @Override
    public String toString() {
        return "IctcLinkedFacilityCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (facilityName != null ? "facilityName=" + facilityName + ", " : "") +
                (linkedFacilityId != null ? "linkedFacilityId=" + linkedFacilityId + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (facilityType != null ? "facilityType=" + facilityType + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
            "}";
    }

}
