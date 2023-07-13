package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link gov.naco.soch.domain.LabTestSample} entity.
 */
public class LabTestSampleDTO implements Serializable {

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

	private LocalDateTime resultApprovedDate;

	private LocalDateTime resultDispatchDate;

	private LocalDateTime resultReceivedDate;

	private String resultValue;

	private LocalDateTime sampleCollectedDate;

	private LocalDateTime sampleDispatchDate;

	private LocalDateTime sampleReceivedDate;

	private Integer testMachineTypeId;

	private String testRequestFormLink;

	private String typeOfSpecimen;

	private Integer testTypeId;

	private Integer testId;

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

	// new added part of unification
	private Integer hivStatus;

	private Integer hivType;

	private Integer sampleCollectionStatus;

	private Boolean isTestedForTb;

	private Integer tbTestResult;

	private Boolean isTestedForSyphilis;

	private Integer syphilisTestResult;

	private LocalDateTime testedDate;

	private Long visitId;

	private Long ictcBeneficiaryId;
	
	private Boolean isUndone;
	
	private Boolean isEighteenPlus;

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

	public LocalDateTime getResultApprovedDate() {
		return resultApprovedDate;
	}

	public void setResultApprovedDate(LocalDateTime resultApprovedDate) {
		this.resultApprovedDate = resultApprovedDate;
	}

	public LocalDateTime getResultDispatchDate() {
		return resultDispatchDate;
	}

	public void setResultDispatchDate(LocalDateTime resultDispatchDate) {
		this.resultDispatchDate = resultDispatchDate;
	}

	public LocalDateTime getResultReceivedDate() {
		return resultReceivedDate;
	}

	public void setResultReceivedDate(LocalDateTime resultReceivedDate) {
		this.resultReceivedDate = resultReceivedDate;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public LocalDateTime getSampleCollectedDate() {
		return sampleCollectedDate;
	}

	public void setSampleCollectedDate(LocalDateTime sampleCollectedDate) {
		this.sampleCollectedDate = sampleCollectedDate;
	}

	public LocalDateTime getSampleDispatchDate() {
		return sampleDispatchDate;
	}

	public void setSampleDispatchDate(LocalDateTime sampleDispatchDate) {
		this.sampleDispatchDate = sampleDispatchDate;
	}

	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
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

	public Integer getSampleCollectionStatus() {
		return sampleCollectionStatus;
	}

	public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
		this.sampleCollectionStatus = sampleCollectionStatus;
	}

	public Boolean getIsTestedForTb() {
		return isTestedForTb;
	}

	public void setIsTestedForTb(Boolean isTestedForTb) {
		this.isTestedForTb = isTestedForTb;
	}

	public Integer getTbTestResult() {
		return tbTestResult;
	}

	public void setTbTestResult(Integer tbTestResult) {
		this.tbTestResult = tbTestResult;
	}

	public Boolean getIsTestedForSyphilis() {
		return isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public Integer getSyphilisTestResult() {
		return syphilisTestResult;
	}

	public void setSyphilisTestResult(Integer syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	
	public LocalDateTime getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDateTime testedDate) {
		this.testedDate = testedDate;
	}
	
	public Boolean getIsUndone() {
		return isUndone;
	}

	public void setIsUndone(Boolean isUndone) {
		this.isUndone = isUndone;
	}
	
	public Boolean getIsEighteenPlus() {
		return isEighteenPlus;
	}

	public void setIsEighteenPlus(Boolean isEighteenPlus) {
		this.isEighteenPlus = isEighteenPlus;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "LabTestSampleDTO [id=" + id + ", authorizerSignature=" + authorizerSignature + ", barcodeNumber="
				+ barcodeNumber + ", errorCode=" + errorCode + ", isDelete=" + isDelete + ", isError=" + isError
				+ ", labInchargeSignature=" + labInchargeSignature + ", labTechnicianSignature="
				+ labTechnicianSignature + ", logValue=" + logValue + ", resultApprovedDate=" + resultApprovedDate
				+ ", resultDispatchDate=" + resultDispatchDate + ", resultReceivedDate=" + resultReceivedDate
				+ ", resultValue=" + resultValue + ", sampleCollectedDate=" + sampleCollectedDate
				+ ", sampleDispatchDate=" + sampleDispatchDate + ", sampleReceivedDate=" + sampleReceivedDate
				+ ", testMachineTypeId=" + testMachineTypeId + ", testRequestFormLink=" + testRequestFormLink
				+ ", typeOfSpecimen=" + typeOfSpecimen + ", testTypeId=" + testTypeId + ", testId=" + testId
				+ ", beneficiaryId=" + beneficiaryId + ", batchId=" + batchId + ", testMachineId=" + testMachineId
				+ ", remarksId=" + remarksId + ", resultTypeId=" + resultTypeId + ", masterResultStatus="
				+ masterResultStatus + ", sampleStatusId=" + sampleStatusId + ", authorizerId=" + authorizerId
				+ ", labInChargeId=" + labInChargeId + ", labTechnicianId=" + labTechnicianId + ", labId=" + labId
				+ ", facilityId=" + facilityId + ", hivStatus=" + hivStatus + ", hivType=" + hivType
				+ ", sampleCollectionStatus=" + sampleCollectionStatus + ", isTestedForTb=" + isTestedForTb
				+ ", tbTestResult=" + tbTestResult + ", isTestedForSyphilis=" + isTestedForSyphilis
				+ ", syphilisTestResult=" + syphilisTestResult + ", testedDate=" + testedDate + ", visitId=" + visitId
				+ ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", isUndone=" + isUndone + ", isEighteenPlus="
				+ isEighteenPlus + "]";
	}

}
