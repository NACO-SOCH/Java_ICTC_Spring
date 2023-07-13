package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;




/**
 * Criteria class for the ICTCSampleCollectionView entity. This class is used in ICTCSampleCollectionViewResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-sample-collection-views?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link } class are used, we need to use
 * fix type specific filters.
 */
public class ICTCSampleCollectionViewCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String infantCode;

    private String firstName;

    private String middleName;

    private String lastName;

    private String age;

//    private String gender;

    private Date visitDate;

    private Integer testType;

    private Long ictcBeneficiaryId;

    private Long visitId;

    private String pid;

    private String uid;

    private Integer sampleCollectionStatus;

    private String barcode;

    private Date sampleCollectionDate;
    
//    private String category;
    
    private Long batchId;
    
    private Integer resultStatus;
    
    private Long facilityId;
    
    private Integer infantBreastFed;
    
    private Integer categoryId;

	private Integer genderId;
	
	private String testTypeDesc;

	private String sampleCollectionStatusDesc;

	private String resultStatusDesc;

    public ICTCSampleCollectionViewCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfantCode() {
        return infantCode;
    }

    public void setInfantCode(String infantCode) {
        this.infantCode = infantCode;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
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

    public Integer getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Date getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(Date sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }
    
//    public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
	
	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	
	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
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

	public String getTestTypeDesc() {
		return testTypeDesc;
	}

	public void setTestTypeDesc(String testTypeDesc) {
		this.testTypeDesc = testTypeDesc;
	}

	public String getSampleCollectionStatusDesc() {
		return sampleCollectionStatusDesc;
	}

	public void setSampleCollectionStatusDesc(String sampleCollectionStatusDesc) {
		this.sampleCollectionStatusDesc = sampleCollectionStatusDesc;
	}

	public String getResultStatusDesc() {
		return resultStatusDesc;
	}

	public void setResultStatusDesc(String resultStatusDesc) {
		this.resultStatusDesc = resultStatusDesc;
	}

	
	@Override
	public String toString() {
		return "ICTCSampleCollectionViewCriteria [id=" + id + ", infantCode=" + infantCode + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + ", visitDate=" + visitDate
				+ ", testType=" + testType + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", visitId=" + visitId
				+ ", pid=" + pid + ", uid=" + uid + ", sampleCollectionStatus=" + sampleCollectionStatus + ", barcode="
				+ barcode + ", sampleCollectionDate=" + sampleCollectionDate + ", batchId=" + batchId
				+ ", resultStatus=" + resultStatus + ", facilityId=" + facilityId + ", infantBreastFed="
				+ infantBreastFed + ", categoryId=" + categoryId + ", genderId=" + genderId + ", testTypeDesc="
				+ testTypeDesc + ", sampleCollectionStatusDesc=" + sampleCollectionStatusDesc + ", resultStatusDesc="
				+ resultStatusDesc + "]";
	}

}
