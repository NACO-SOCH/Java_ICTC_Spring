package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A FictcBeneficiary.
 */
@Entity
@Table(name = "fictc_beneficiary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FictcBeneficiary extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_pregnant")
    private Boolean isPregnant;

    @Column(name = "hiv_screening_date")
    private LocalDate hivScreeningDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;
    
    @Column(name = "profile_status")
    private Boolean profileStatus;

    @ManyToOne
    private Beneficiary beneficiary;

    @ManyToOne
    private MasterPregnancyTypeCase pregnancyType;

    @ManyToOne
    private Facility facility;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsPregnant() {
        return isPregnant;
    }

    public FictcBeneficiary isPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
        return this;
    }

    public void setIsPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public LocalDate getHivScreeningDate() {
        return hivScreeningDate;
    }

    public FictcBeneficiary hivScreeningDate(LocalDate hivScreeningDate) {
        this.hivScreeningDate = hivScreeningDate;
        return this;
    }

    public void setHivScreeningDate(LocalDate hivScreeningDate) {
        this.hivScreeningDate = hivScreeningDate;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public FictcBeneficiary isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public FictcBeneficiary isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public FictcBeneficiary beneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public MasterPregnancyTypeCase getPregnancyType() {
        return pregnancyType;
    }

    public FictcBeneficiary pregnancyType(MasterPregnancyTypeCase masterPregnancyTypeCase) {
        this.pregnancyType = masterPregnancyTypeCase;
        return this;
    }

    public void setPregnancyType(MasterPregnancyTypeCase masterPregnancyTypeCase) {
        this.pregnancyType = masterPregnancyTypeCase;
    }

    public Facility getFacility() {
        return facility;
    }

    public FictcBeneficiary facility(Facility facility) {
        this.facility = facility;
        return this;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FictcBeneficiary fictcBeneficiary = (FictcBeneficiary) o;
        if (fictcBeneficiary.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), fictcBeneficiary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FictcBeneficiary{" +
            "id=" + getId() +
            ", isPregnant='" + isIsPregnant() + "'" +
            ", hivScreeningDate='" + getHivScreeningDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            "}";
    }

	public Boolean getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(Boolean profileStatus) {
		this.profileStatus = profileStatus;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}
}
