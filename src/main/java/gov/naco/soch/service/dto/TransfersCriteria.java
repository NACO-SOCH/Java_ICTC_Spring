package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * Criteria class for the {@link gov.naco.soch.domain.Transfers} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TransfersResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /transfers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TransfersCriteria {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String sourceFacilityType;

    private String transferStatus;

    private String hivStatus;

    private String category;

    private String remarks;

    private Date initiationDate;

    private String destinationFacilityType;

    private String dsrcCode;

    private String tiCode;

    private String artCode;

    private String ostCode;

    private String pidCode;

    private Date reportingDate;

    private Integer createdBy;

    private Date createdTime;

    private Integer modifiedBy;

    private Date modifiedTime;

    private Boolean isActive;

    private Boolean isDeleted;

    private Long beneficiaryId;

    private Long sourceFacilityId;

    private Long destinationFacilityId;

    public TransfersCriteria() {
    }

//    public TransfersCriteria(TransfersCriteria other) {
//        this.id = other.id == null ? null : other.id.copy();
//        this.sourceFacilityType = other.sourceFacilityType == null ? null : other.sourceFacilityType.copy();
//        this.transferStatus = other.transferStatus == null ? null : other.transferStatus.copy();
//        this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
//        this.category = other.category == null ? null : other.category.copy();
//        this.remarks = other.remarks == null ? null : other.remarks.copy();
//        this.initiationDate = other.initiationDate == null ? null : other.initiationDate.copy();
//        this.destinationFacilityType = other.destinationFacilityType == null ? null : other.destinationFacilityType.copy();
//        this.dsrcCode = other.dsrcCode == null ? null : other.dsrcCode.copy();
//        this.tiCode = other.tiCode == null ? null : other.tiCode.copy();
//        this.artCode = other.artCode == null ? null : other.artCode.copy();
//        this.ostCode = other.ostCode == null ? null : other.ostCode.copy();
//        this.pidCode = other.pidCode == null ? null : other.pidCode.copy();
//        this.reportingDate = other.reportingDate == null ? null : other.reportingDate.copy();
//        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
//        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
//        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
//        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
//        this.isActive = other.isActive == null ? null : other.isActive.copy();
//        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
//        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
//        this.sourceFacilityId = other.sourceFacilityId == null ? null : other.sourceFacilityId.copy();
//        this.destinationFacilityId = other.destinationFacilityId == null ? null : other.destinationFacilityId.copy();
//    }
//
//    @Override
//    public TransfersCriteria copy() {
//        return new TransfersCriteria(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceFacilityType() {
        return sourceFacilityType;
    }

    public void setSourceFacilityType(String sourceFacilityType) {
        this.sourceFacilityType = sourceFacilityType;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(Date initiationDate) {
        this.initiationDate = initiationDate;
    }

    public String getDestinationFacilityType() {
        return destinationFacilityType;
    }

    public void setDestinationFacilityType(String destinationFacilityType) {
        this.destinationFacilityType = destinationFacilityType;
    }

    public String getDsrcCode() {
        return dsrcCode;
    }

    public void setDsrcCode(String dsrcCode) {
        this.dsrcCode = dsrcCode;
    }

    public String getTiCode() {
        return tiCode;
    }

    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
    }

    public String getArtCode() {
        return artCode;
    }

    public void setArtCode(String artCode) {
        this.artCode = artCode;
    }

    public String getOstCode() {
        return ostCode;
    }

    public void setOstCode(String ostCode) {
        this.ostCode = ostCode;
    }

    public String getPidCode() {
        return pidCode;
    }

    public void setPidCode(String pidCode) {
        this.pidCode = pidCode;
    }

    public Date getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
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

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getSourceFacilityId() {
        return sourceFacilityId;
    }

    public void setSourceFacilityId(Long sourceFacilityId) {
        this.sourceFacilityId = sourceFacilityId;
    }

    public Long getDestinationFacilityId() {
        return destinationFacilityId;
    }

    public void setDestinationFacilityId(Long destinationFacilityId) {
        this.destinationFacilityId = destinationFacilityId;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final TransfersCriteria that = (TransfersCriteria) o;
//        return
//            Objects.equals(id, that.id) &&
//            Objects.equals(sourceFacilityType, that.sourceFacilityType) &&
//            Objects.equals(transferStatus, that.transferStatus) &&
//            Objects.equals(hivStatus, that.hivStatus) &&
//            Objects.equals(category, that.category) &&
//            Objects.equals(remarks, that.remarks) &&
//            Objects.equals(initiationDate, that.initiationDate) &&
//            Objects.equals(destinationFacilityType, that.destinationFacilityType) &&
//            Objects.equals(dsrcCode, that.dsrcCode) &&
//            Objects.equals(tiCode, that.tiCode) &&
//            Objects.equals(artCode, that.artCode) &&
//            Objects.equals(ostCode, that.ostCode) &&
//            Objects.equals(pidCode, that.pidCode) &&
//            Objects.equals(reportingDate, that.reportingDate) &&
//            Objects.equals(createdBy, that.createdBy) &&
//            Objects.equals(createdTime, that.createdTime) &&
//            Objects.equals(modifiedBy, that.modifiedBy) &&
//            Objects.equals(modifiedTime, that.modifiedTime) &&
//            Objects.equals(isActive, that.isActive) &&
//            Objects.equals(isDeleted, that.isDeleted) &&
//            Objects.equals(beneficiaryId, that.beneficiaryId) &&
//            Objects.equals(sourceFacilityId, that.sourceFacilityId) &&
//            Objects.equals(destinationFacilityId, that.destinationFacilityId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(
//        id,
//        sourceFacilityType,
//        transferStatus,
//        hivStatus,
//        category,
//        remarks,
//        initiationDate,
//        destinationFacilityType,
//        dsrcCode,
//        tiCode,
//        artCode,
//        ostCode,
//        pidCode,
//        reportingDate,
//        createdBy,
//        createdTime,
//        modifiedBy,
//        modifiedTime,
//        isActive,
//        isDeleted,
//        beneficiaryId,
//        sourceFacilityId,
//        destinationFacilityId
//        );
//    }

    @Override
    public String toString() {
        return "TransfersCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (sourceFacilityType != null ? "sourceFacilityType=" + sourceFacilityType + ", " : "") +
                (transferStatus != null ? "transferStatus=" + transferStatus + ", " : "") +
                (hivStatus != null ? "hivStatus=" + hivStatus + ", " : "") +
                (category != null ? "category=" + category + ", " : "") +
                (remarks != null ? "remarks=" + remarks + ", " : "") +
                (initiationDate != null ? "initiationDate=" + initiationDate + ", " : "") +
                (destinationFacilityType != null ? "destinationFacilityType=" + destinationFacilityType + ", " : "") +
                (dsrcCode != null ? "dsrcCode=" + dsrcCode + ", " : "") +
                (tiCode != null ? "tiCode=" + tiCode + ", " : "") +
                (artCode != null ? "artCode=" + artCode + ", " : "") +
                (ostCode != null ? "ostCode=" + ostCode + ", " : "") +
                (pidCode != null ? "pidCode=" + pidCode + ", " : "") +
                (reportingDate != null ? "reportingDate=" + reportingDate + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (sourceFacilityId != null ? "sourceFacilityId=" + sourceFacilityId + ", " : "") +
                (destinationFacilityId != null ? "destinationFacilityId=" + destinationFacilityId + ", " : "") +
            "}";
    }

}
