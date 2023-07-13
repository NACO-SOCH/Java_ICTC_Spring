package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;


public class FictcBeneficiaryCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private Boolean isPregnant;

    private Date hivScreeningDate;

    private Boolean isActive;

    private Boolean isDelete;

    private Long beneficiaryId;

    private Long pregnancyTypeId;

    private Long facilityId;

    public FictcBeneficiaryCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public Date getHivScreeningDate() {
        return hivScreeningDate;
    }

    public void setHivScreeningDate(Date hivScreeningDate) {
        this.hivScreeningDate = hivScreeningDate;
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

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getPregnancyTypeId() {
        return pregnancyTypeId;
    }

    public void setPregnancyTypeId(Long pregnancyTypeId) {
        this.pregnancyTypeId = pregnancyTypeId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "FictcBeneficiaryCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (isPregnant != null ? "isPregnant=" + isPregnant + ", " : "") +
                (hivScreeningDate != null ? "hivScreeningDate=" + hivScreeningDate + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDelete != null ? "isDelete=" + isDelete + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (pregnancyTypeId != null ? "pregnancyTypeId=" + pregnancyTypeId + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
            "}";
    }

}
