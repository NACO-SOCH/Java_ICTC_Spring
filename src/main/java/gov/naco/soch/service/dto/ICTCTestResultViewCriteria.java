package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * Criteria class for the ICTCTestResultView entity. This class is used in ICTCTestResultViewResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-test-result-views?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link } class are used, we need to use
 * fix type specific filters.
 */
public class ICTCTestResultViewCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String uid;

    private String firstName;

    private String middleName;

    private String lastName;

    private String age;

//    private String gender;

    private Date sampleCollectionDate;

    private Integer testType;

    private Integer resultStatus;

    private Integer hivStatus;

    private Integer hivType;

//    private Date testedDate;

    private Long sampleId;
    
    private Long batchId;

    private String consignmentId;

    private Long beneficiaryId;

    private Long ictcBeneficiaryId;

    private Long visitId;

    private Date dateOfBirth;

    private Integer sampleCollectionStatus;

    private Integer batchStatus;
    
//    private String category;
    
    private Long labId;
    
    private String labName;
    
    private String labCode;
    
    private Long facilityId;
    
    private Integer categoryId;

	private Integer genderId;
	
	private String infantCode;
	
	private String testTypeDesc;

	private String hivStatusDesc;

	private String resultStatusDesc;

	private String sampleCollectionStatusDesc;

	private String batchStatusDesc;

	private String hivTypeDesc;

    public ICTCTestResultViewCriteria() {
    }

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

    public Date getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(Date sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Integer getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(Integer hivStatus) {
        this.hivStatus = hivStatus;
    }

    public Integer getHivType() {
        return hivType;
    }

    public void setHivType(Integer hivType) {
        this.hivType = hivType;
    }

//    public Date getTestedDate() {
//        return testedDate;
//    }
//
//    public void setTestedDate(Date testedDate) {
//        this.testedDate = testedDate;
//    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public Integer getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
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
	
	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
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
	
	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}
	
	public String getTestTypeDesc() {
		return testTypeDesc;
	}

	public void setTestTypeDesc(String testTypeDesc) {
		this.testTypeDesc = testTypeDesc;
	}

	public String getHivStatusDesc() {
		return hivStatusDesc;
	}

	public void setHivStatusDesc(String hivStatusDesc) {
		this.hivStatusDesc = hivStatusDesc;
	}

	public String getResultStatusDesc() {
		return resultStatusDesc;
	}

	public void setResultStatusDesc(String resultStatusDesc) {
		this.resultStatusDesc = resultStatusDesc;
	}

	public String getSampleCollectionStatusDesc() {
		return sampleCollectionStatusDesc;
	}

	public void setSampleCollectionStatusDesc(String sampleCollectionStatusDesc) {
		this.sampleCollectionStatusDesc = sampleCollectionStatusDesc;
	}

	public String getBatchStatusDesc() {
		return batchStatusDesc;
	}

	public void setBatchStatusDesc(String batchStatusDesc) {
		this.batchStatusDesc = batchStatusDesc;
	}

	public String getHivTypeDesc() {
		return hivTypeDesc;
	}

	public void setHivTypeDesc(String hivTypeDesc) {
		this.hivTypeDesc = hivTypeDesc;
	}

	
	@Override
	public String toString() {
		return "ICTCTestResultViewCriteria [id=" + id + ", uid=" + uid + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", sampleCollectionDate="
				+ sampleCollectionDate + ", testType=" + testType + ", resultStatus=" + resultStatus + ", hivStatus="
				+ hivStatus + ", hivType=" + hivType + ", sampleId=" + sampleId + ", batchId=" + batchId
				+ ", consignmentId=" + consignmentId + ", beneficiaryId=" + beneficiaryId + ", ictcBeneficiaryId="
				+ ictcBeneficiaryId + ", visitId=" + visitId + ", dateOfBirth=" + dateOfBirth
				+ ", sampleCollectionStatus=" + sampleCollectionStatus + ", batchStatus=" + batchStatus + ", labId="
				+ labId + ", labName=" + labName + ", labCode=" + labCode + ", facilityId=" + facilityId
				+ ", categoryId=" + categoryId + ", genderId=" + genderId + ", infantCode=" + infantCode
				+ ", testTypeDesc=" + testTypeDesc + ", hivStatusDesc=" + hivStatusDesc + ", resultStatusDesc="
				+ resultStatusDesc + ", sampleCollectionStatusDesc=" + sampleCollectionStatusDesc + ", batchStatusDesc="
				+ batchStatusDesc + ", hivTypeDesc=" + hivTypeDesc + "]";
	}

}
