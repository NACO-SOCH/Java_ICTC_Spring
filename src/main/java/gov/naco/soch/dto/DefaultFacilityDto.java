package gov.naco.soch.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class DefaultFacilityDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long defaultFacilityId;
    @Size(max = 99)
    private String defaultFacilityName;
    private Long defaultFacilityTypeId;

    public Long getDefaultFacilityId() {
        return defaultFacilityId;
    }

    public void setDefaultFacilityId(Long defaultFacilityId) {
        this.defaultFacilityId = defaultFacilityId;
    }

    public String getDefaultFacilityName() {
        return defaultFacilityName;
    }

    public void setDefaultFacilityName(String defaultFacilityName) {
        this.defaultFacilityName = defaultFacilityName;
    }

    public Long getDefaultFacilityTypeId() {
        return defaultFacilityTypeId;
    }

    public void setDefaultFacilityTypeId(Long defaultFacilityTypeId) {
        this.defaultFacilityTypeId = defaultFacilityTypeId;
    }

    @Override
    public String toString() {
        return "DefaultFacilityDto{" +
                "defaultFacilityId=" + defaultFacilityId +
                ", defaultFacilityName='" + defaultFacilityName + '\'' +
                ", defaultFacilityTypeId=" + defaultFacilityTypeId +
                '}';
    }
    
    
    //007
    
    private Integer id;

	private String pid;

	private String uid;

	private String firstName;

	private String middleName;

	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date visitDate;

	private Integer beneficiaryId;

	private String mobileNumber;

	private String age;

	private Boolean isPregnant;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date testedDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date reportReceivedDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date reportDeliveryDate;

	private Integer hivStatus;

	private Integer hivType;

	private Integer infantBreastFed;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private String barcode;

	private Integer resultStatus;

	private Integer currentResultId;
	
	private Integer visitId;

	private String infantMotherArtNo;

	private Integer infantMotherArtId;

	private String infantMotherFirstName;
	
	private String infantMotherLastName;

	private String infantCode;

	private Integer occupationId;

	private Integer maritalStatusId;

	private Integer testType;
	
	private Boolean isConsentDocumented;
	
	private Integer beneficiaryStatus;
	
	private Integer batchId;

	private String consignmentId;

	private Integer labId;

	private String labName;

	private String labCode;
	
	private Integer facilityId;
	
	private Integer categoryId;

	private Integer genderId;
	
	private Integer deletedReason;
	
	private String deletedReasonComment;
	
	private Boolean isActive;

	private Boolean isDeleted;
	
	private Boolean isPostTestCounsellingCompleted;
	
	private String hivStatusDesc;

	private String beneficiaryStatusDesc;

	private String testTypeDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Date getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(Date reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public Date getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(Date reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
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

	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public String getInfantMotherArtNo() {
		return infantMotherArtNo;
	}

	public void setInfantMotherArtNo(String infantMotherArtNo) {
		this.infantMotherArtNo = infantMotherArtNo;
	}

	public Integer getInfantMotherArtId() {
		return infantMotherArtId;
	}

	public void setInfantMotherArtId(Integer infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public String getInfantMotherFirstName() {
		return infantMotherFirstName;
	}

	public void setInfantMotherFirstName(String infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
	}

	public String getInfantMotherLastName() {
		return infantMotherLastName;
	}

	public void setInfantMotherLastName(String infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}
	
	public Date getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(Date testedDate) {
		this.testedDate = testedDate;
	}


	public Integer getTestType() {
		return testType;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}
	

	public Boolean getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}
	
	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
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
	
	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
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
	
	public Integer getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(Integer deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String getDeletedReasonComment() {
		return deletedReasonComment;
	}

	public void setDeletedReasonComment(String deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
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
	
	public Boolean getIsPostTestCounsellingCompleted() {
		return isPostTestCounsellingCompleted;
	}

	public void setIsPostTestCounsellingCompleted(Boolean isPostTestCounsellingCompleted) {
		this.isPostTestCounsellingCompleted = isPostTestCounsellingCompleted;
	}
	
	public String getHivStatusDesc() {
		return hivStatusDesc;
	}

	public void setHivStatusDesc(String hivStatusDesc) {
		this.hivStatusDesc = hivStatusDesc;
	}

	public String getBeneficiaryStatusDesc() {
		return beneficiaryStatusDesc;
	}

	public void setBeneficiaryStatusDesc(String beneficiaryStatusDesc) {
		this.beneficiaryStatusDesc = beneficiaryStatusDesc;
	}

	public String getTestTypeDesc() {
		return testTypeDesc;
	}

	public void setTestTypeDesc(String testTypeDesc) {
		this.testTypeDesc = testTypeDesc;
	}

	public Integer getCurrentResultId() {
		return currentResultId;
	}

	public void setCurrentResultId(Integer currentResultId) {
		this.currentResultId = currentResultId;
	}
}
