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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A LabTestSampleBatch.
 */
@Entity
@Table(name = "lab_test_sample_batch")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LabTestSampleBatch extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "accepted_samples")
	private Integer acceptedSamples;

	@Column(name = "bdn_serial_number")
	private String bdnSerialNumber;

	@Column(name = "dispatch_date")
	private LocalDateTime dispatchDate;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "num_of_samples")
	private Integer numOfSamples;

	@Column(name = "received_date")
	private LocalDateTime receivedDate;

	@Column(name = "rejected_samples")
	private Integer rejectedSamples;

	@ManyToOne
	@JoinColumn(name = "artc_id")
	private Facility facility;

	@ManyToOne
	@JoinColumn(name = "lab_id")
	private Facility lab;

	@Column(name = "batch_status_id")
	private Integer batchStatusId;

	@ManyToOne
	@JoinColumn(name = "artc_lab_tech_id")
	private UserMaster ictcLabTechnician;

	@ManyToOne
	@JoinColumn(name = "lab_tech_id")
	private UserMaster eidLabTechnician;

	public LabTestSampleBatch() {
		super();
	}

	public LabTestSampleBatch(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAcceptedSamples() {
		return acceptedSamples;
	}

	public void setAcceptedSamples(Integer acceptedSamples) {
		this.acceptedSamples = acceptedSamples;
	}

	public String getBdnSerialNumber() {
		return bdnSerialNumber;
	}

	public void setBdnSerialNumber(String bdnSerialNumber) {
		this.bdnSerialNumber = bdnSerialNumber;
	}

	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getNumOfSamples() {
		return numOfSamples;
	}

	public void setNumOfSamples(Integer numOfSamples) {
		this.numOfSamples = numOfSamples;
	}

	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Integer getRejectedSamples() {
		return rejectedSamples;
	}

	public void setRejectedSamples(Integer rejectedSamples) {
		this.rejectedSamples = rejectedSamples;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Facility getLab() {
		return lab;
	}

	public void setLab(Facility lab) {
		this.lab = lab;
	}

	public Integer getBatchStatusId() {
		return batchStatusId;
	}

	public void setBatchStatusId(Integer batchStatusId) {
		this.batchStatusId = batchStatusId;
	}

	public UserMaster getIctcLabTechnician() {
		return ictcLabTechnician;
	}

	public void setIctcLabTechnician(UserMaster ictcLabTechnician) {
		this.ictcLabTechnician = ictcLabTechnician;
	}

	public UserMaster getEidLabTechnician() {
		return eidLabTechnician;
	}

	public void setEidLabTechnician(UserMaster eidLabTechnician) {
		this.eidLabTechnician = eidLabTechnician;
	}

	@Override
	public String toString() {
		return "LabTestSampleBatch [id=" + id + ", acceptedSamples=" + acceptedSamples + ", bdnSerialNumber="
				+ bdnSerialNumber + ", dispatchDate=" + dispatchDate + ", isDelete=" + isDelete + ", numOfSamples="
				+ numOfSamples + ", receivedDate=" + receivedDate + ", rejectedSamples=" + rejectedSamples
				+ ", facility=" + facility + ", lab=" + lab + ", batchStatusId=" + batchStatusId
				+ ", ictcLabTechnician=" + ictcLabTechnician + ", eidLabTechnician=" + eidLabTechnician + "]";
	}

}
