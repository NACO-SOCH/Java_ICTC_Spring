package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;



/**
 * Criteria class for the ArtBeneficiary entity. This class is used in ArtBeneficiaryResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /art-beneficiaries?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ArtBeneficiaryCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private Date artEligibilityDate;

    private Date artRegistrationDate;

    private Date artStartDate;

    private Boolean isActive;

    private Boolean isDelete;

    private Boolean lacLinked;

    private String linkageInstituteName;

    private String previousClinic;

    private Date registrationDate;

    private Long visitRegisterId;

    private Long artBeneficiaryStatusId;

    private Long hivRiskFactorId;

    private Long facilityId;
    
    private Long beneficiaryId;
    
    private String firstName;
    
    private String lastName;
    
    private String middleName;
    
    private String mobileNumber;
    
    private String artCentreCode;
    
    private String artNumber;
    
    private String preArtNumber;

    public ArtBeneficiaryCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getArtEligibilityDate() {
        return artEligibilityDate;
    }

    public void setArtEligibilityDate(Date artEligibilityDate) {
        this.artEligibilityDate = artEligibilityDate;
    }

    public Date getArtRegistrationDate() {
        return artRegistrationDate;
    }

    public void setArtRegistrationDate(Date artRegistrationDate) {
        this.artRegistrationDate = artRegistrationDate;
    }

    public Date getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(Date artStartDate) {
        this.artStartDate = artStartDate;
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

    public Boolean getLacLinked() {
        return lacLinked;
    }

    public void setLacLinked(Boolean lacLinked) {
        this.lacLinked = lacLinked;
    }

    public String getLinkageInstituteName() {
        return linkageInstituteName;
    }

    public void setLinkageInstituteName(String linkageInstituteName) {
        this.linkageInstituteName = linkageInstituteName;
    }

    public String getPreviousClinic() {
        return previousClinic;
    }

    public void setPreviousClinic(String previousClinic) {
        this.previousClinic = previousClinic;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getVisitRegisterId() {
        return visitRegisterId;
    }

    public void setVisitRegisterId(Long visitRegisterId) {
        this.visitRegisterId = visitRegisterId;
    }

    public Long getArtBeneficiaryStatusId() {
        return artBeneficiaryStatusId;
    }

    public void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId) {
        this.artBeneficiaryStatusId = artBeneficiaryStatusId;
    }

    public Long getHivRiskFactorId() {
        return hivRiskFactorId;
    }

    public void setHivRiskFactorId(Long hivRiskFactorId) {
        this.hivRiskFactorId = hivRiskFactorId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getArtCentreCode() {
		return artCentreCode;
	}

	public void setArtCentreCode(String artCentreCode) {
		this.artCentreCode = artCentreCode;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	@Override
	public String toString() {
		return "ArtBeneficiaryCriteria [id=" + id + ", artEligibilityDate=" + artEligibilityDate
				+ ", artRegistrationDate=" + artRegistrationDate + ", artStartDate=" + artStartDate
				+ ", isDelete=" + isDelete + ", lacLinked=" + lacLinked + ", linkageInstituteName="
				+ linkageInstituteName + ", previousClinic=" + previousClinic + ", registrationDate=" + registrationDate
				+ ", visitRegisterId=" + visitRegisterId + ", artBeneficiaryStatusId=" + artBeneficiaryStatusId
				+ ", hivRiskFactorId=" + hivRiskFactorId + ", facilityId=" + facilityId + ", beneficiaryId="
				+ beneficiaryId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", mobileNumber=" + mobileNumber + ", artCentreCode=" + artCentreCode + ", artNumber=" + artNumber
				+ ", preArtNumber=" + preArtNumber + "]";
	}

}
