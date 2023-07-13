package gov.naco.soch.service.dto;

import java.time.LocalDate;

public class FictcBeneficiaryCreateDTO {
	private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private LocalDate dateOfBirth;
	
	private String age;
	
	private Integer genderId;
	
	private String mobileNumber;
	
	private String addressLineOne;
	
	private String addressLineTwo;
	
	private Long stateId;

	private Long subdistrictId;

	private Long townId;
	
	private Long districtId;
	
	private String pincode;
	
	private LocalDate hivScreeningDate;
	
	private Integer categoryId;
	
	private Long facilityId;
	
	private Long referredToIctcFacilityId;
	
	private Long beneficiaryId;
	
	private Long fictcBeneficiaryId;
	
	private Long referralId;
	private Long pregnancyTypeId;
	private Boolean pregnant;
	private Boolean profileStatus;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getGenderId() {
		return genderId;
	}
	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public Long getSubdistrictId() {
		return subdistrictId;
	}
	public void setSubdistrictId(Long subdistrictId) {
		this.subdistrictId = subdistrictId;
	}
	public Long getTownId() {
		return townId;
	}
	public void setTownId(Long townId) {
		this.townId = townId;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public LocalDate getHivScreeningDate() {
		return hivScreeningDate;
	}
	public void setHivScreeningDate(LocalDate hivScreeningDate) {
		this.hivScreeningDate = hivScreeningDate;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public Long getReferredToIctcFacilityId() {
		return referredToIctcFacilityId;
	}
	public void setReferredToIctcFacilityId(Long referredToIctcFacilityId) {
		this.referredToIctcFacilityId = referredToIctcFacilityId;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public Long getFictcBeneficiaryId() {
		return fictcBeneficiaryId;
	}
	public void setFictcBeneficiaryId(Long fictcBeneficiaryId) {
		this.fictcBeneficiaryId = fictcBeneficiaryId;
	}
	public Long getReferralId() {
		return referralId;
	}
	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}
	public Long getPregnancyTypeId() {
		return pregnancyTypeId;
	}
	public void setPregnancyTypeId(Long pregnancyTypeId) {
		this.pregnancyTypeId = pregnancyTypeId;
	}
	public Boolean isPregnant() {
		return pregnant;
	}
	public void setPregnant(Boolean pregnant) {
		this.pregnant = pregnant;
	}
	public Boolean getProfileStatus() {
		return profileStatus;
	}
	public void setProfileStatus(Boolean profileStatus) {
		this.profileStatus = profileStatus;
	}
	public Boolean getPregnant() {
		return pregnant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	
}
