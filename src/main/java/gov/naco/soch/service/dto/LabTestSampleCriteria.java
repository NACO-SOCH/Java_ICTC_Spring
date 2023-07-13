package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;

public class LabTestSampleCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String authorizerSignature;

	private String barcodeNumber;

	private String errorCode;

	private Boolean isDelete;

	private Boolean isError;

	private String labInchargeSignature;

	private String labTechnicianSignature;

	private String logValue;

	private String resultValue;

	private Integer testMachineTypeId;

	private String testRequestFormLink;

	private String typeOfSpecimen;

	private Integer testTypeId;

	private Long beneficiaryId;

	private Long batchId;

	private Integer testMachineId;

	private Integer remarksId;

	private Integer resultTypeId;

	private Integer masterResultStatus;

	private Integer sampleStatusId;

	private Integer authorizerId;

	private Long labInChargeId;

	private Long labTechnicianId;

	private Long labId;

	private Long facilityId;

	private Integer createdBy;

	private Date createdTime;

	private Integer modifiedBy;

	private Date modifiedTime;

	// new added part of unification
//	private Integer hivStatus;
//
//	private Integer hivType;
//
//	private Integer sampleCollectionStatus;
//
//	private Boolean isTestedForTb;
//
//	private Integer tbTestResult;
//
//	private Boolean isTestedForSyphilis;
//
//	private Integer syphilisTestResult;
//
//	private Long visitId;
//
//	private Long ictcBeneficiaryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorizerSignature() {
		return authorizerSignature;
	}

	public void setAuthorizerSignature(String authorizerSignature) {
		this.authorizerSignature = authorizerSignature;
	}

	public String getBarcodeNumber() {
		return barcodeNumber;
	}

	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public String getLabInchargeSignature() {
		return labInchargeSignature;
	}

	public void setLabInchargeSignature(String labInchargeSignature) {
		this.labInchargeSignature = labInchargeSignature;
	}

	public String getLabTechnicianSignature() {
		return labTechnicianSignature;
	}

	public void setLabTechnicianSignature(String labTechnicianSignature) {
		this.labTechnicianSignature = labTechnicianSignature;
	}

	public String getLogValue() {
		return logValue;
	}

	public void setLogValue(String logValue) {
		this.logValue = logValue;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public Integer getTestMachineTypeId() {
		return testMachineTypeId;
	}

	public void setTestMachineTypeId(Integer testMachineTypeId) {
		this.testMachineTypeId = testMachineTypeId;
	}

	public String getTestRequestFormLink() {
		return testRequestFormLink;
	}

	public void setTestRequestFormLink(String testRequestFormLink) {
		this.testRequestFormLink = testRequestFormLink;
	}

	public String getTypeOfSpecimen() {
		return typeOfSpecimen;
	}

	public void setTypeOfSpecimen(String typeOfSpecimen) {
		this.typeOfSpecimen = typeOfSpecimen;
	}

	public Integer getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Integer getTestMachineId() {
		return testMachineId;
	}

	public void setTestMachineId(Integer testMachineId) {
		this.testMachineId = testMachineId;
	}

	public Integer getRemarksId() {
		return remarksId;
	}

	public void setRemarksId(Integer remarksId) {
		this.remarksId = remarksId;
	}

	public Integer getResultTypeId() {
		return resultTypeId;
	}

	public void setResultTypeId(Integer resultTypeId) {
		this.resultTypeId = resultTypeId;
	}

	public Integer getMasterResultStatus() {
		return masterResultStatus;
	}

	public void setMasterResultStatus(Integer masterResultStatus) {
		this.masterResultStatus = masterResultStatus;
	}

	public Integer getSampleStatusId() {
		return sampleStatusId;
	}

	public void setSampleStatusId(Integer sampleStatusId) {
		this.sampleStatusId = sampleStatusId;
	}

	public Integer getAuthorizerId() {
		return authorizerId;
	}

	public void setAuthorizerId(Integer authorizerId) {
		this.authorizerId = authorizerId;
	}

	public Long getLabInChargeId() {
		return labInChargeId;
	}

	public void setLabInChargeId(Long labInChargeId) {
		this.labInChargeId = labInChargeId;
	}

	public Long getLabTechnicianId() {
		return labTechnicianId;
	}

	public void setLabTechnicianId(Long labTechnicianId) {
		this.labTechnicianId = labTechnicianId;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	
//	@Override
//	public int hashCode() {
//		return Objects.hash(authorizerId, authorizerSignature, barcodeNumber, batchId, beneficiaryId, createdBy,
//				createdTime, errorCode, facilityId, id, isDelete, isError, labId, labInChargeId, labInchargeSignature,
//				labTechnicianId, labTechnicianSignature, logValue, masterResultStatus, modifiedBy, modifiedTime,
//				remarksId, resultTypeId, resultValue, sampleStatusId, testMachineId, testMachineTypeId,
//				testRequestFormLink, testTypeId, typeOfSpecimen);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		LabTestSampleCriteria other = (LabTestSampleCriteria) obj;
//		return Objects.equals(authorizerId, other.authorizerId)
//				&& Objects.equals(authorizerSignature, other.authorizerSignature)
//				&& Objects.equals(barcodeNumber, other.barcodeNumber) && Objects.equals(batchId, other.batchId)
//				&& Objects.equals(beneficiaryId, other.beneficiaryId) && Objects.equals(createdBy, other.createdBy)
//				&& Objects.equals(createdTime, other.createdTime) && Objects.equals(errorCode, other.errorCode)
//				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(id, other.id)
//				&& Objects.equals(isDelete, other.isDelete) && Objects.equals(isError, other.isError)
//				&& Objects.equals(labId, other.labId) && Objects.equals(labInChargeId, other.labInChargeId)
//				&& Objects.equals(labInchargeSignature, other.labInchargeSignature)
//				&& Objects.equals(labTechnicianId, other.labTechnicianId)
//				&& Objects.equals(labTechnicianSignature, other.labTechnicianSignature)
//				&& Objects.equals(logValue, other.logValue)
//				&& Objects.equals(masterResultStatus, other.masterResultStatus)
//				&& Objects.equals(modifiedBy, other.modifiedBy) && Objects.equals(modifiedTime, other.modifiedTime)
//				&& Objects.equals(remarksId, other.remarksId) && Objects.equals(resultTypeId, other.resultTypeId)
//				&& Objects.equals(resultValue, other.resultValue)
//				&& Objects.equals(sampleStatusId, other.sampleStatusId)
//				&& Objects.equals(testMachineId, other.testMachineId)
//				&& Objects.equals(testMachineTypeId, other.testMachineTypeId)
//				&& Objects.equals(testRequestFormLink, other.testRequestFormLink)
//				&& Objects.equals(testTypeId, other.testTypeId) && Objects.equals(typeOfSpecimen, other.typeOfSpecimen);
//	}

	@Override
	public String toString() {
		return "LabTestSampleCriteria [id=" + id + ", authorizerSignature=" + authorizerSignature + ", barcodeNumber="
				+ barcodeNumber + ", errorCode=" + errorCode + ", isDelete=" + isDelete + ", isError=" + isError
				+ ", labInchargeSignature=" + labInchargeSignature + ", labTechnicianSignature="
				+ labTechnicianSignature + ", logValue=" + logValue + ", resultValue=" + resultValue
				+ ", testMachineTypeId=" + testMachineTypeId + ", testRequestFormLink=" + testRequestFormLink
				+ ", typeOfSpecimen=" + typeOfSpecimen + ", testTypeId=" + testTypeId + ", beneficiaryId="
				+ beneficiaryId + ", batchId=" + batchId + ", testMachineId=" + testMachineId + ", remarksId="
				+ remarksId + ", resultTypeId=" + resultTypeId + ", masterResultStatus=" + masterResultStatus
				+ ", sampleStatusId=" + sampleStatusId + ", authorizerId=" + authorizerId + ", labInChargeId="
				+ labInChargeId + ", labTechnicianId=" + labTechnicianId + ", labId=" + labId + ", facilityId="
				+ facilityId + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy="
				+ modifiedBy + ", modifiedTime=" + modifiedTime + "]";
	}
	
}
