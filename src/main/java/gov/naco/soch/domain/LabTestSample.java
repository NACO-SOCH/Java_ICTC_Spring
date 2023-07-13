package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A LabTestSample.
 */
@Entity
@Table(name = "lab_test_sample")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LabTestSample extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "authorizer_signature")
	private String authorizerSignature;

	@Column(name = "barcode_number")
	private String barcodeNumber;

	@Column(name = "error_code")
	private String errorCode;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_error")
	private Boolean isError;

	@Column(name = "lab_incharge_signature")
	private String labInchargeSignature;

	@Column(name = "lab_technician_signature")
	private String labTechnicianSignature;

	@Column(name = "log_value")
	private String logValue;

	@Column(name = "result_approved_date")
	private LocalDateTime resultApprovedDate;

	@Column(name = "result_dispatch_date")
	private LocalDateTime resultDispatchDate;

	@Column(name = "result_received_date")
	private LocalDateTime resultReceivedDate;

	@Column(name = "result_value")
	private String resultValue;

	@Column(name = "sample_collected_date")
	private LocalDateTime sampleCollectedDate;

	@Column(name = "sample_dispatch_date")
	private LocalDateTime sampleDispatchDate;

	@Column(name = "sample_received_date")
	private LocalDateTime sampleReceivedDate;

	@Column(name = "test_machine_type_id")
	private Integer testMachineTypeId;

	@Column(name = "test_request_form_link")
	private String testRequestFormLink;

	@Column(name = "type_of_specimen")
	private String typeOfSpecimen;

	@Column(name = "test_id")
	private Integer testId;

	@Column(name = "test_type_id")
	private Integer testTypeId;

	@ManyToOne
	@JoinColumn(name = "test_batch_id")
	private LabTestSampleBatch batch;

	@Column(name = "test_machine_id")
	private Integer testMachineId;

	@Column(name = "remarks_id")
	private Integer remarksId;

	@Column(name = "result_type_id")
	private Integer resultTypeId;

	@Column(name = "result_status_id")
	private Integer masterResultStatus;

	@Column(name = "sample_status_id")
	private Integer sampleStatusId;

	@Column(name = "authorizer_id")
	private Integer authorizerId;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("labTestSamples")
    @JsonIgnore
    private Beneficiary beneficiary;
    
    @ManyToOne
	@JoinColumn(name = "lab_incharge_id")
	private UserMaster labInCharge;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name = "lab_technician_id")
	private UserMaster labTechnician;

	@ManyToOne
	@JoinColumn(name = "dispatched_to_lab_id")
	private Facility lab;

	@ManyToOne
	@JoinColumn(name = "sample_collected_facility_id")
	private Facility facility;
	
	@Column(name = "is_undone")
	private Boolean isUndone;

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

	public LabTestSampleBatch getBatch() {
		return batch;
	}

	public void setBatch(LabTestSampleBatch batch) {
		this.batch = batch;
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

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public UserMaster getLabInCharge() {
		return labInCharge;
	}

	public void setLabInCharge(UserMaster labInCharge) {
		this.labInCharge = labInCharge;
	}

	public UserMaster getLabTechnician() {
		return labTechnician;
	}

	public void setLabTechnician(UserMaster labTechnician) {
		this.labTechnician = labTechnician;
	}

	public Facility getLab() {
		return lab;
	}

	public void setLab(Facility lab) {
		this.lab = lab;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getIsUndone() {
		return isUndone;
	}

	public void setIsUndone(Boolean isUndone) {
		this.isUndone = isUndone;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "LabTestSample [id=" + id + ", authorizerSignature=" + authorizerSignature + ", barcodeNumber="
				+ barcodeNumber + ", errorCode=" + errorCode + ", isDelete=" + isDelete + ", isError=" + isError
				+ ", labInchargeSignature=" + labInchargeSignature + ", labTechnicianSignature="
				+ labTechnicianSignature + ", logValue=" + logValue + ", resultApprovedDate=" + resultApprovedDate
				+ ", resultDispatchDate=" + resultDispatchDate + ", resultReceivedDate=" + resultReceivedDate
				+ ", resultValue=" + resultValue + ", sampleCollectedDate=" + sampleCollectedDate
				+ ", sampleDispatchDate=" + sampleDispatchDate + ", sampleReceivedDate=" + sampleReceivedDate
				+ ", testMachineTypeId=" + testMachineTypeId + ", testRequestFormLink=" + testRequestFormLink
				+ ", typeOfSpecimen=" + typeOfSpecimen + ", testId=" + testId + ", testTypeId=" + testTypeId
				+ ", batch=" + batch + ", testMachineId=" + testMachineId + ", remarksId=" + remarksId
				+ ", resultTypeId=" + resultTypeId + ", masterResultStatus=" + masterResultStatus + ", sampleStatusId="
				+ sampleStatusId + ", authorizerId=" + authorizerId + ", beneficiary=" + beneficiary + ", labInCharge="
				+ labInCharge + ", labTechnician=" + labTechnician + ", lab=" + lab + ", facility=" + facility
				+ ", isUndone=" + isUndone + "]";
	}

// new added part of unification
//	@Column(name = "hiv_status")
//	private Integer hivStatus;
//
//	@Column(name = "hiv_type")
//	private Integer hivType;
//
//	@Column(name = "sample_collection_status")
//	private Integer sampleCollectionStatus;
//
//	@Column(name = "is_tested_for_tb")
//	private Boolean isTestedForTb;
//
//	@Column(name = "tb_test_result")
//	private Integer tbTestResult;
//
//	@Column(name = "is_tested_for_syphilis")
//	private Boolean isTestedForSyphilis;
//
//	@Column(name = "syphilis_test_result")
//	private Integer syphilisTestResult;
//
//	@Column(name = "tested_date")
//	private LocalDateTime testedDate;
//	
//	@Column(name = "is_eighteen_plus")
//	private Boolean isEighteenPlus;

//	@ManyToOne
//	@JoinColumn(name = "visit_id")
//	private ICTCVisit visit;
//
//	@ManyToOne(optional = false)
//	@NotNull
//	@JoinColumn(name = "ictc_beneficiary_id")
//	private ICTCBeneficiary ictcBeneficiary;
	
	

	

}