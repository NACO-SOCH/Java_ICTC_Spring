package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Criteria class for the {@link gov.naco.soch.domain.Beneficiary} entity. This class is used
 * in {@link gov.naco.soch.web.rest.BeneficiaryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /beneficiaries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryCriteria  {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String uid;

    private String aadharNumber;

    private String age;

    private String barcode;

//    private String beneficiaryType;

//    private String category;

    private Date dateOfBirth;

//    private String educationLevel;

//    private String employmentStatus;

    private String otherEmploymentStatus;

    private String firstName;

//    private String gender;

    private Boolean isPlhiv;

    private String lastName;

//    private String maritalStatus;

    private String middleName;

    private String mobileNumber;

//    private String occupation;

//    private String status;

    private Long createdBy;

    private Date createdTime;

    private Long modifiedBy;

    private Date modifiedTime;

    private Boolean isActive;

    private Boolean isDelete;

    private Long addressId;
    
    private Integer maritalStatusId;
    
    private Integer occupationId;
    
    private Integer monthlyIncomeId;
    
    private Integer educationLevelId;
    
    private Integer genderId;
    
    private String alternatePhonenumber;
    
    private Integer address;
    
    private String caregiverName;
    
    private String caregiverPhoneNumber;
    
    private Integer caregiverAddressId;
    
    private Integer hivTypeId;
    
	private Integer hivStatusId;
	
	private Date deathDate;
	
	private String deathReason;
	
	private String bankAccountName;
	
	private String bankAccountNumber;
	
	private String bankIfsc;
	
	private Integer stayingWithId;

//	private String guardianCaregiverName;
	
	private Integer guardianCaregiverHighestEducationId;
	
	private Integer birthHistoryId;
	
	private Integer birthWeight;
	
	private String neoNatalComplications;
	
	private String artNumber;
	
	private String preArtNumber;
	
	private Integer categoryId;
	
//	private String clientStatus;
	
	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getMonthlyIncomeId() {
		return monthlyIncomeId;
	}

	public void setMonthlyIncomeId(Integer monthlyIncomeId) {
		this.monthlyIncomeId = monthlyIncomeId;
	}

	public Integer getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Integer educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getAlternatePhonenumber() {
		return alternatePhonenumber;
	}

	public void setAlternatePhonenumber(String alternatePhonenumber) {
		this.alternatePhonenumber = alternatePhonenumber;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getCaregiverPhoneNumber() {
		return caregiverPhoneNumber;
	}

	public void setCaregiverPhoneNumber(String caregiverPhoneNumber) {
		this.caregiverPhoneNumber = caregiverPhoneNumber;
	}

	public Integer getCaregiverAddressId() {
		return caregiverAddressId;
	}

	public void setCaregiverAddressId(Integer caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
	}

	public Integer getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(Integer hivTypeId) {
		this.hivTypeId = hivTypeId;
	}

	public Integer getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(Integer hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public Integer getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(Integer stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

//	public String getGuardianCaregiverName() {
//		return guardianCaregiverName;
//	}
//
//	public void setGuardianCaregiverName(String guardianCaregiverName) {
//		this.guardianCaregiverName = guardianCaregiverName;
//	}

	public Integer getGuardianCaregiverHighestEducationId() {
		return guardianCaregiverHighestEducationId;
	}

	public void setGuardianCaregiverHighestEducationId(Integer guardianCaregiverHighestEducationId) {
		this.guardianCaregiverHighestEducationId = guardianCaregiverHighestEducationId;
	}

	public Integer getBirthHistoryId() {
		return birthHistoryId;
	}

	public void setBirthHistoryId(Integer birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public Integer getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Integer birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getNeoNatalComplications() {
		return neoNatalComplications;
	}

	public void setNeoNatalComplications(String neoNatalComplications) {
		this.neoNatalComplications = neoNatalComplications;
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

//	public String getClientStatus() {
//		return clientStatus;
//	}
//
//	public void setClientStatus(String clientStatus) {
//		this.clientStatus = clientStatus;
//	}

	public Integer getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(Integer masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	private Integer masterClientStatus;
	
    public BeneficiaryCriteria() {
    }

//    public BeneficiaryCriteria(BeneficiaryCriteria other) {
//        this.id = other.id == null ? null : other.id.copy();
//        this.uid = other.uid == null ? null : other.uid.copy();
//        this.aadharNumber = other.aadharNumber == null ? null : other.aadharNumber.copy();
//        this.age = other.age == null ? null : other.age.copy();
//        this.barcode = other.barcode == null ? null : other.barcode.copy();
//        this.dateOfBirth = other.dateOfBirth == null ? null : other.dateOfBirth.copy();
//        this.otherEmploymentStatus = other.otherEmploymentStatus == null ? null : other.otherEmploymentStatus.copy();
//        this.firstName = other.firstName == null ? null : other.firstName.copy();
//        this.isPlhiv = other.isPlhiv == null ? null : other.isPlhiv.copy();
//        this.lastName = other.lastName == null ? null : other.lastName.copy();
//        this.middleName = other.middleName == null ? null : other.middleName.copy();
//        this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
////        this.status = other.status == null ? null : other.status.copy();
//        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
//        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
//        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
//        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
//        this.isActive = other.isActive == null ? null : other.isActive.copy();
//        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
//        this.addressId = other.addressId == null ? null : other.addressId.copy();
//        
//        this.maritalStatusId = other.maritalStatusId == null ? null : other.maritalStatusId.copy();
//        this.occupationId = other.occupationId == null ? null : other.occupationId.copy();
//        this.monthlyIncomeId = other.monthlyIncomeId == null ? null : other.monthlyIncomeId.copy();
//        this.educationLevelId = other.educationLevelId == null ? null : other.educationLevelId.copy();
//        this.genderId = other.genderId == null ? null : other.genderId.copy();
//        this.alternatePhonenumber = other.alternatePhonenumber == null ? null : other.alternatePhonenumber.copy();
//        this.address = other.address == null ? null : other.address.copy();
//        this.caregiverName = other.caregiverName == null ? null : other.caregiverName.copy();
//        this.caregiverPhoneNumber = other.caregiverPhoneNumber == null ? null : other.caregiverPhoneNumber.copy();
//        this.caregiverAddressId = other.caregiverAddressId == null ? null : other.caregiverAddressId.copy();
//        this.hivTypeId = other.hivTypeId == null ? null : other.hivTypeId.copy();
//        this.hivStatusId = other.hivStatusId == null ? null : other.hivStatusId.copy();
//        this.deathDate = other.deathDate == null ? null : other.deathDate.copy();
//        this.deathReason = other.deathReason == null ? null : other.deathReason.copy();
//        this.bankAccountName = other.bankAccountName == null ? null : other.bankAccountName.copy();
//        this.bankAccountNumber = other.bankAccountNumber == null ? null : other.bankAccountNumber.copy();
//        this.bankIfsc = other.bankIfsc == null ? null : other.bankIfsc.copy();
//        this.stayingWithId = other.stayingWithId == null ? null : other.stayingWithId.copy();
////        this.guardianCaregiverName = other.guardianCaregiverName == null ? null : other.guardianCaregiverName.copy();
//        this.guardianCaregiverHighestEducationId = other.guardianCaregiverHighestEducationId == null ? null : other.guardianCaregiverHighestEducationId.copy();
//        this.birthHistoryId = other.birthHistoryId == null ? null : other.birthHistoryId.copy();
//        this.birthWeight = other.birthWeight == null ? null : other.birthWeight.copy();
//        this.neoNatalComplications = other.neoNatalComplications == null ? null : other.neoNatalComplications.copy();
//        this.artNumber = other.artNumber == null ? null : other.artNumber.copy();
//        this.preArtNumber = other.preArtNumber == null ? null : other.preArtNumber.copy();
//        this.categoryId = other.categoryId == null ? null : other.categoryId.copy();
//        this.masterClientStatus = other.masterClientStatus == null ? null : other.masterClientStatus.copy();
//    }
//
//    @Override
//    public BeneficiaryCriteria copy() {
//        return new BeneficiaryCriteria(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

//    public String getBeneficiaryType() {
//        return beneficiaryType;
//    }
//
//    public void setBeneficiaryType(String beneficiaryType) {
//        this.beneficiaryType = beneficiaryType;
//    }

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public String getEducationLevel() {
//        return educationLevel;
//    }
//
//    public void setEducationLevel(String educationLevel) {
//        this.educationLevel = educationLevel;
//    }
//
//    public String getEmploymentStatus() {
//        return employmentStatus;
//    }
//
//    public void setEmploymentStatus(String employmentStatus) {
//        this.employmentStatus = employmentStatus;
//    }

    public String getOtherEmploymentStatus() {
        return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(String otherEmploymentStatus) {
        this.otherEmploymentStatus = otherEmploymentStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public Boolean getIsPlhiv() {
        return isPlhiv;
    }

    public void setIsPlhiv(Boolean isPlhiv) {
        this.isPlhiv = isPlhiv;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getMaritalStatus() {
//        return maritalStatus;
//    }
//
//    public void setMaritalStatus(String maritalStatus) {
//        this.maritalStatus = maritalStatus;
//    }

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

//    public String getOccupation() {
//        return occupation;
//    }
//
//    public void setOccupation(String occupation) {
//        this.occupation = occupation;
//    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryCriteria other = (BeneficiaryCriteria) obj;
		return Objects.equals(aadharNumber, other.aadharNumber) && Objects.equals(address, other.address)
				&& Objects.equals(addressId, other.addressId) && Objects.equals(age, other.age)
				&& Objects.equals(alternatePhonenumber, other.alternatePhonenumber)
				&& Objects.equals(artNumber, other.artNumber) && Objects.equals(bankAccountName, other.bankAccountName)
				&& Objects.equals(bankAccountNumber, other.bankAccountNumber)
				&& Objects.equals(bankIfsc, other.bankIfsc) && Objects.equals(barcode, other.barcode)
				&& Objects.equals(birthHistoryId, other.birthHistoryId)
				&& Objects.equals(birthWeight, other.birthWeight)
				&& Objects.equals(caregiverAddressId, other.caregiverAddressId)
				&& Objects.equals(caregiverName, other.caregiverName)
				&& Objects.equals(caregiverPhoneNumber, other.caregiverPhoneNumber)
				&& Objects.equals(categoryId, other.categoryId) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createdTime, other.createdTime) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(deathDate, other.deathDate) && Objects.equals(deathReason, other.deathReason)
				&& Objects.equals(educationLevelId, other.educationLevelId)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(genderId, other.genderId)
				&& Objects.equals(guardianCaregiverHighestEducationId, other.guardianCaregiverHighestEducationId)
				&& Objects.equals(hivStatusId, other.hivStatusId) && Objects.equals(hivTypeId, other.hivTypeId)
				&& Objects.equals(id, other.id) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDelete, other.isDelete) && Objects.equals(isPlhiv, other.isPlhiv)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(maritalStatusId, other.maritalStatusId)
				&& Objects.equals(masterClientStatus, other.masterClientStatus)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(modifiedBy, other.modifiedBy) && Objects.equals(modifiedTime, other.modifiedTime)
				&& Objects.equals(monthlyIncomeId, other.monthlyIncomeId)
				&& Objects.equals(neoNatalComplications, other.neoNatalComplications)
				&& Objects.equals(occupationId, other.occupationId)
				&& Objects.equals(otherEmploymentStatus, other.otherEmploymentStatus)
				&& Objects.equals(preArtNumber, other.preArtNumber)
				&& Objects.equals(stayingWithId, other.stayingWithId) && Objects.equals(uid, other.uid);
	}

    @Override
	public int hashCode() {
		return Objects.hash(aadharNumber, address, addressId, age, alternatePhonenumber, artNumber, bankAccountName,
				bankAccountNumber, bankIfsc, barcode, birthHistoryId, birthWeight, caregiverAddressId, caregiverName,
				caregiverPhoneNumber, categoryId, createdBy, createdTime, dateOfBirth, deathDate, deathReason,
				educationLevelId, firstName, genderId, guardianCaregiverHighestEducationId, hivStatusId, hivTypeId, id,
				isActive, isDelete, isPlhiv, lastName, maritalStatusId, masterClientStatus,
				middleName, mobileNumber, modifiedBy, modifiedTime, monthlyIncomeId, neoNatalComplications,
				occupationId, otherEmploymentStatus, preArtNumber, stayingWithId, uid);
	}

    @Override
	public String toString() {
		return "BeneficiaryCriteria [id=" + id + ", uid=" + uid + ", aadharNumber=" + aadharNumber + ", age=" + age
				+ ", barcode=" + barcode + ", dateOfBirth=" + dateOfBirth + ", otherEmploymentStatus="
				+ otherEmploymentStatus + ", firstName=" + firstName + ", isPlhiv=" + isPlhiv + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", addressId=" + addressId
				+ ", maritalStatusId=" + maritalStatusId + ", occupationId=" + occupationId + ", monthlyIncomeId="
				+ monthlyIncomeId  + ", educationLevelId="
				+ educationLevelId + ", genderId=" + genderId + ", alternatePhonenumber=" + alternatePhonenumber
				+ ", address=" + address + ", caregiverName=" + caregiverName + ", caregiverPhoneNumber="
				+ caregiverPhoneNumber + ", caregiverAddressId=" + caregiverAddressId + ", hivTypeId=" + hivTypeId
				+ ", hivStatusId=" + hivStatusId + ", deathDate=" + deathDate + ", deathReason=" + deathReason
				+ ", bankAccountName=" + bankAccountName + ", bankAccountNumber=" + bankAccountNumber + ", bankIfsc="
				+ bankIfsc + ", stayingWithId=" + stayingWithId + ", guardianCaregiverHighestEducationId="
				+ guardianCaregiverHighestEducationId + ", birthHistoryId=" + birthHistoryId + ", birthWeight="
				+ birthWeight + ", neoNatalComplications=" + neoNatalComplications + ", artNumber=" + artNumber
				+ ", preArtNumber=" + preArtNumber + ", categoryId=" + categoryId + ", masterClientStatus="
				+ masterClientStatus + "]";
	}

}
