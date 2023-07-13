package gov.naco.soch.service.dto;

import java.util.Date;


public class ReferralsCriteria  {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String sourceFacilityType;

    private String referralStatus;

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

    public ReferralsCriteria() {
    }

  

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

    public String getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
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


   
    @Override
    public String toString() {
        return "ReferralsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (sourceFacilityType != null ? "sourceFacilityType=" + sourceFacilityType + ", " : "") +
                (referralStatus != null ? "referralStatus=" + referralStatus + ", " : "") +
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
