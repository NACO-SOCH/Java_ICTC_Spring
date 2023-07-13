package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The persistent class for the user_master database table.
 * 
 */
public class UserMasterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Boolean activeRole;

	private Long designationId;

	private String email;

	private String firstname;

	private String orwCode;

	private String peCode;

	private Boolean isActive;

	private String isBeneficiary;

	private Boolean isDelete;

	private String landlineNumber;

	private String lastname;

	private String mobileNumber;

	private LocalDate lastDateOfTraining;

	private Long facilityId;

	public UserMasterDTO(Long id) {
		super();
		this.id = id;
	}

	public UserMasterDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActiveRole() {
		return activeRole;
	}

	public void setActiveRole(Boolean activeRole) {
		this.activeRole = activeRole;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getOrwCode() {
		return orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

	public String getPeCode() {
		return peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(String isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getLastDateOfTraining() {
		return lastDateOfTraining;
	}

	public void setLastDateOfTraining(LocalDate lastDateOfTraining) {
		this.lastDateOfTraining = lastDateOfTraining;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserMaster [id=" + id + ", activeRole=" + activeRole + ", designationId=" + designationId + ", email="
				+ email + ", firstname=" + firstname + ", orwCode=" + orwCode + ", peCode=" + peCode + ", isActive="
				+ isActive + ", isBeneficiary=" + isBeneficiary + ", isDelete=" + isDelete + ", landlineNumber="
				+ landlineNumber + ", lastname=" + lastname + ", mobileNumber=" + mobileNumber + ", lastDateOfTraining="
				+ lastDateOfTraining + ", facilityId=" + facilityId + "]";
	}
	
}
