package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Beneficiary.
 */
@Entity
@Table(name = "beneficiary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Beneficiary extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uid")
	private String uid;

	@Column(name = "aadhar_number")
	private String aadharNumber;

	@Column(name = "age")
	private String age;

//	@Column(name = "beneficiary_type")
//	private String beneficiaryType;

//	@Column(name = "category")
//	private String category;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

//	@Column(name = "education_level")
//	private String educationLevel;

//	@Column(name = "employment_status")
//	private String employmentStatus;

	@Column(name = "first_name")
	private String firstName;

//	@Column(name = "gender")
//	private String gender;

	@Column(name = "last_name")
	private String lastName;

//	@Column(name = "marital_status")
//	private String maritalStatus;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mobile_number")
	private String mobileNumber;

//	@Column(name = "occupation")
//	private String occupation;

//	@Column(name = "status")
//	private String status;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "pre_art_number")
	private String preArtNumber;

	@Column(name = "art_number")
	private String artNumber;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(unique = true, name = "address_id")
	private Address address;

	@Column(name = "hiv_type_id")
	private Integer hivTypeId;

	@Column(name = "hiv_status_id")
	private Integer hivStatusId;

	@Column(name = "marital_status_id")
	private Integer maritalStatusId;

	@Column(name = "occupation_id")
	private Integer occupationId;

	@Column(name = "monthly_income")
	private Integer monthlyIncomeId;

//	@Column(name = "employment_status_id")
//	private Integer masterEmploymentStatus;

	@Column(name = "education_level_id")
	private Integer educationLevelId;

	@Column(name = "gender_id")
	private Integer genderId;

	@Column(name = "alternate_phonenumber")
	private String alternatePhonenumber;

	@Column(name = "caregiver_name")
	private String caregiverName;

	@Column(name = "caregiver_phone_number")
	private String caregiverPhoneNumber;

	@Column(name = "caregiver_address_id")
	private Integer caregiverAddressId;

	@Column(name = "death_date")
	private LocalDate deathDate;

	@Column(name = "death_reason")
	private String deathReason;

	@Column(name = "bank_account_name")
	private String bankAccountName;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "bank_ifsc")
	private String bankIfsc;

	@Column(name = "staying_with_id")
	private Integer stayingWithId;

//	@Column(name = "guardian_caregiver_name")
//	private String guardianCaregiverName;

	@Column(name = "guardian_caregiver_highest_education_id")
	private Integer guardianCaregiverHighestEducationId;

	@Column(name = "birth_history_id")
	private Integer birthHistoryId;

	@Column(name = "birth_weight")
	private Integer birthWeight;

	@Column(name = "neo_natal_complications")
	private String neoNatalComplications;

	@Column(name = "category_id")
	private Integer categoryId;

//	@Column(name = "client_status")
//	private String clientStatus;

	@Column(name = "client_status_id")
	private Integer masterClientStatus;

	@Column(name = "other_employment_status")
	private String otherEmploymentStatus;
	
//	@Column(name = "beneficiary_activity_status")
//	private String beneficiaryActivityStatus;
	
	@JsonIgnoreProperties({"beneficiary", "facility"})
	@OneToOne(mappedBy = "beneficiary")
	private ICTCBeneficiary ictcBeneficiary;
	
	@JsonIgnoreProperties({"beneficiary", "facility"})
	@OneToOne(mappedBy = "beneficiary")
	private FictcBeneficiary fictcBeneficiary;
	
	@Column(name = "ti_code")
	private String tiCode;
	
	@Column(name = "ost_code")
	private String ostCode;
	
	@Column(name = "pid")
	private String pid;
	
	@Column(name = "reg_date")
    private LocalDate regDate;
	
	@Column(name="is_living_in_rel")
    private Boolean isLivingInRelationship;
 
    @OneToOne(mappedBy = "beneficiary", fetch = FetchType.EAGER)
    private TIBeneficiary tiBeneficiary;
    
    @Column(name="is_serodiscordant")
    private Boolean isSerodiscordant;
	public Beneficiary() {
		super();
	}
	
	public Beneficiary(Long id) {
		super();
		this.id = id;
	}

    @Column(name="ost_number")
    private String ostNumber;
    
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
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

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(Integer masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public String getOtherEmploymentStatus() {
		return otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
	}

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Boolean getIsLivingInRelationship() {
		return isLivingInRelationship;
	}

	public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
		this.isLivingInRelationship = isLivingInRelationship;
	}

	public TIBeneficiary getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(TIBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}
	
	public Boolean getIsSerodiscordant() {
		return isSerodiscordant;
	}

	public void setIsSerodiscordant(Boolean isSerodiscordant) {
		this.isSerodiscordant = isSerodiscordant;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

	public FictcBeneficiary getFictcBeneficiary() {
		return fictcBeneficiary;
	}

	public void setFictcBeneficiary(FictcBeneficiary fictcBeneficiary) {
		this.fictcBeneficiary = fictcBeneficiary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Beneficiary)) {
			return false;
		}
		return id != null && id.equals(((Beneficiary) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "Beneficiary [id=" + id + ", uid=" + uid + ", aadharNumber=" + aadharNumber + ", age=" + age
				+ ", dateOfBirth=" + dateOfBirth + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", preArtNumber=" + preArtNumber + ", artNumber=" + artNumber
				+ ", address=" + address + ", hivTypeId=" + hivTypeId + ", hivStatusId=" + hivStatusId
				+ ", maritalStatusId=" + maritalStatusId + ", occupationId=" + occupationId + ", monthlyIncomeId="
				+ monthlyIncomeId  + ", educationLevelId="
				+ educationLevelId + ", genderId=" + genderId + ", alternatePhonenumber=" + alternatePhonenumber
				+ ", caregiverName=" + caregiverName + ", caregiverPhoneNumber=" + caregiverPhoneNumber
				+ ", caregiverAddressId=" + caregiverAddressId + ", deathDate=" + deathDate + ", deathReason="
				+ deathReason + ", bankAccountName=" + bankAccountName + ", bankAccountNumber=" + bankAccountNumber
				+ ", bankIfsc=" + bankIfsc + ", stayingWithId=" + stayingWithId
				+ ", guardianCaregiverHighestEducationId=" + guardianCaregiverHighestEducationId + ", birthHistoryId="
				+ birthHistoryId + ", birthWeight=" + birthWeight + ", neoNatalComplications=" + neoNatalComplications
				+ ", categoryId=" + categoryId + ", masterClientStatus=" + masterClientStatus
				+ ", otherEmploymentStatus=" + otherEmploymentStatus 
				+ ", tiCode=" + tiCode + ", ostCode=" + ostCode + ", pid=" + pid + ", isLivingInRelationship="
				+ isLivingInRelationship + "]";
	}

}