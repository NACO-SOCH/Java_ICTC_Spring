package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import gov.naco.soch.domain.Auditable;

/**
 * A DTO for the FictcBeneficiary entity.
 */
public class FictcBeneficiaryDTO extends Auditable<Long> implements Serializable {

    private Long id;

    private Boolean isPregnant;

    private LocalDate hivScreeningDate;

    private Boolean isActive;

    private Boolean isDelete;

    private Long beneficiaryId;

    private Long pregnancyTypeId;

    private Long facilityId;
    private Boolean profileStatus;

    private Boolean pnc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public LocalDate getHivScreeningDate() {
        return hivScreeningDate;
    }

    public void setHivScreeningDate(LocalDate hivScreeningDate) {
        this.hivScreeningDate = hivScreeningDate;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
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

    public void setPregnancyTypeId(Long masterPregnancyTypeCaseId) {
        this.pregnancyTypeId = masterPregnancyTypeCaseId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FictcBeneficiaryDTO fictcBeneficiaryDTO = (FictcBeneficiaryDTO) o;
        if (fictcBeneficiaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), fictcBeneficiaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FictcBeneficiaryDTO{" +
            "id=" + getId() +
            ", isPregnant='" + isIsPregnant() + "'" +
            ", hivScreeningDate='" + getHivScreeningDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            ", beneficiary=" + getBeneficiaryId() +
            ", pregnancyType=" + getPregnancyTypeId() +
            ", facility=" + getFacilityId() +
            "}";
    }

	public Boolean getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(Boolean profileStatus) {
		this.profileStatus = profileStatus;
	}

	public Boolean getPnc() {
		return pnc;
	}

	public void setPnc(Boolean pnc) {
		this.pnc = pnc;
	}
}
