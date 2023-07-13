package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Criteria class for the BeneficiaryFacilityMapping entity. This class is used in BeneficiaryFacilityMappingResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /beneficiary-facility-mappings?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryFacilityMappingCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private Boolean isActive;

    private Boolean isDelete;

    private String pid;

    private Date mappingDate;

    private Date registrationDate;

    private Date createdTime;

    private Date modifiedTime;

    private Long beneficiaryId;

    private Long facilityId;
    
    private String firstName;
    
    private String lastName;
    
    private String middleName;
    
    private String uid;
    
	private String preArtNumber;

  	private String artNumber;
    
    private Long facilityTypeId;
    
    private String artCode;
    
    private Integer genderId;
    
    private String mobileNumber;
    
    private String tiCode;
    
    private String ostCode;
    
    private String ostNumber;
    
    private Boolean benIsActive;

    private Boolean benIsDelete;

    public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public BeneficiaryFacilityMappingCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Date getMappingDate() {
        return mappingDate;
    }

    public void setMappingDate(Date mappingDate) {
        this.mappingDate = mappingDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	
	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}
	
	public String getArtCode() {
		return artCode;
	}

	public void setArtCode(String artCode) {
		this.artCode = artCode;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}
	
	public Boolean getBenIsActive() {
		return benIsActive;
	}

	public void setBenIsActive(Boolean benIsActive) {
		this.benIsActive = benIsActive;
	}

	public Boolean getBenIsDelete() {
		return benIsDelete;
	}

	public void setBenIsDelete(Boolean benIsDelete) {
		this.benIsDelete = benIsDelete;
	}

	@Override
	public String toString() {
		return "BeneficiaryFacilityMappingCriteria [id=" + id + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", pid=" + pid + ", mappingDate=" + mappingDate + ", registrationDate=" + registrationDate
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", beneficiaryId=" + beneficiaryId
				+ ", facilityId=" + facilityId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", uid=" + uid + ", preArtNumber=" + preArtNumber + ", artNumber=" + artNumber
				+ ", facilityTypeId=" + facilityTypeId + ", artCode=" + artCode + ", genderId=" + genderId
				+ ", mobileNumber=" + mobileNumber + ", tiCode=" + tiCode + ", ostCode=" + ostCode + ", ostNumber="
				+ ostNumber + ", benIsActive=" + benIsActive + ", benIsDelete=" + benIsDelete + "]";
	}

}
