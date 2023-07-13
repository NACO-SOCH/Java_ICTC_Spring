package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;


public class ICTCBeneficiaryFollowUpViewCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String pid;

    private String uid;

    private String firstName;

    private String lastName;

    private String middleName;

    private String mobileNumber;

    private String age;

    private Date followUpDate;

    private Integer followUpType;

    private Date expectedDeliveryDate;

    private Date pregnancyLmpDate;

    private Date deliveryDate;

    private Boolean isCompleted;

    private Integer beneficiaryStatus;

    private Long beneficiaryId;

    private Long visitId;

    private Long testResultId;

    private Long ictcBeneficiaryId;

    private Long facilityId;
    
    private Date visitDate;
    
    private Date dateOfBirth;
    
    private Integer categoryId;

	private Integer genderId;
	
	private String beneficiaryStatusDesc;

    public ICTCBeneficiaryFollowUpViewCriteria() {
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public Integer getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(Integer followUpType) {
        this.followUpType = followUpType;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getPregnancyLmpDate() {
        return pregnancyLmpDate;
    }

    public void setPregnancyLmpDate(Date pregnancyImpDate) {
        this.pregnancyLmpDate = pregnancyImpDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }


    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getBeneficiaryStatus() {
        return beneficiaryStatus;
    }

    public void setBeneficiaryStatus(Integer beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Long testResultId) {
        this.testResultId = testResultId;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    

    public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}
	
	public String getBeneficiaryStatusDesc() {
		return beneficiaryStatusDesc;
	}

	public void setBeneficiaryStatusDesc(String beneficiaryStatusDesc) {
		this.beneficiaryStatusDesc = beneficiaryStatusDesc;
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryFollowUpViewCriteria [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber
				+ ", age=" + age + ", followUpDate=" + followUpDate + ", followUpType=" + followUpType
				+ ", expectedDeliveryDate=" + expectedDeliveryDate + ", pregnancyLmpDate=" + pregnancyLmpDate
				+ ", deliveryDate=" + deliveryDate + ", isCompleted=" + isCompleted + ", beneficiaryStatus="
				+ beneficiaryStatus + ", beneficiaryId=" + beneficiaryId + ", visitId=" + visitId + ", testResultId="
				+ testResultId + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", facilityId=" + facilityId
				+ ", visitDate=" + visitDate + ", dateOfBirth=" + dateOfBirth + ", categoryId=" + categoryId
				+ ", genderId=" + genderId + ", beneficiaryStatusDesc=" + beneficiaryStatusDesc + "]";
	}

}
