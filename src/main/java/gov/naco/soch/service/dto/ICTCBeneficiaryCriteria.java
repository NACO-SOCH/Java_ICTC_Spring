package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ICTCBeneficiaryCriteria{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String pid;

    private Boolean isConsentDocumented;
    
    private String infantCode;
    
    private Integer referredBy;
    
    private Date registrationDate;
    
    private Long createdBy;

    private Date createdTime;

    private Long modifiedBy;

    private Date modifiedTime;
    
    private Boolean isActive;

    private Boolean isDeleted;

    private String infantMotherArtId;

    private Long facilityId;

    private Long beneficiaryId;
    
    private Integer beneficiaryCategoryId;
    
    private Integer beneficiaryStatus;
    
    public ICTCBeneficiaryCriteria() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public Boolean getIsConsentDocumented() {
        return isConsentDocumented;
    }

    public void setIsConsentDocumented(Boolean isConsentDocumented) {
        this.isConsentDocumented = isConsentDocumented;
    }

    public String getInfantMotherArtId() {
        return infantMotherArtId;
    }

    public void setInfantMotherArtId(String infantMotherArtId) {
        this.infantMotherArtId = infantMotherArtId;
    }

    public String getInfantCode() {
        return infantCode;
    }

    public void setInfantCode(String infantCode) {
        this.infantCode = infantCode;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Integer getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
	}

	public Integer getBeneficiaryCategoryId() {
		return beneficiaryCategoryId;
	}

	public void setBeneficiaryCategoryId(Integer beneficiaryCategoryId) {
		this.beneficiaryCategoryId = beneficiaryCategoryId;
	}

	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCBeneficiaryCriteria other = (ICTCBeneficiaryCriteria) obj;
		return Objects.equals(beneficiaryCategoryId, other.beneficiaryCategoryId)
				&& Objects.equals(beneficiaryId, other.beneficiaryId)
				&& Objects.equals(beneficiaryStatus, other.beneficiaryStatus)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(id, other.id)
				&& Objects.equals(infantCode, other.infantCode)
				&& Objects.equals(infantMotherArtId, other.infantMotherArtId)
				&& Objects.equals(isActive, other.isActive)
				&& Objects.equals(isConsentDocumented, other.isConsentDocumented)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime) && Objects.equals(pid, other.pid)
				&& Objects.equals(referredBy, other.referredBy)
				&& Objects.equals(registrationDate, other.registrationDate);
	}

    @Override
	public int hashCode() {
		return Objects.hash(beneficiaryCategoryId, beneficiaryId, beneficiaryStatus, createdBy, createdTime, facilityId,
				id, infantCode, infantMotherArtId, isActive, isConsentDocumented, isDeleted, modifiedBy, modifiedTime,
				pid, referredBy, registrationDate);
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryCriteria [id=" + id + ", pid=" + pid + ", isConsentDocumented=" + isConsentDocumented
				+ ", infantCode=" + infantCode + ", referredBy=" + referredBy + ", registrationDate=" + registrationDate
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", infantMotherArtId=" + infantMotherArtId + ", facilityId=" + facilityId + ", beneficiaryId="
				+ beneficiaryId + ", beneficiaryCategoryId=" + beneficiaryCategoryId + ", beneficiaryStatus="
				+ beneficiaryStatus + "]";
	}

}
