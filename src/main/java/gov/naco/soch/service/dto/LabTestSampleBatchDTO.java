package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link gov.naco.soch.domain.LabTestSampleBatch} entity.
 */
public class LabTestSampleBatchDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Integer acceptedSamples;

	private String bdnSerialNumber;

	private LocalDateTime dispatchDate;

	private Boolean isDelete;

	private Integer numOfSamples;

	private LocalDateTime receivedDate;

	private Integer rejectedSamples;

	private Long facilityId;

	private Long labId;

	private Integer batchStatusId;

	private Long ictcLabTechnicianId;

	private Long eidLabTechnicianId;

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

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public Integer getBatchStatusId() {
		return batchStatusId;
	}

	public void setBatchStatusId(Integer batchStatusId) {
		this.batchStatusId = batchStatusId;
	}

	public Long getIctcLabTechnicianId() {
		return ictcLabTechnicianId;
	}

	public void setIctcLabTechnicianId(Long ictcLabTechnicianId) {
		this.ictcLabTechnicianId = ictcLabTechnicianId;
	}

	public Long getEidLabTechnicianId() {
		return eidLabTechnicianId;
	}

	public void setEidLabTechnicianId(Long eidLabTechnicianId) {
		this.eidLabTechnicianId = eidLabTechnicianId;
	}

	@Override
	public String toString() {
		return "LabTestSampleBatchDTO [id=" + id + ", acceptedSamples=" + acceptedSamples + ", bdnSerialNumber="
				+ bdnSerialNumber + ", dispatchDate=" + dispatchDate + ", isDelete=" + isDelete + ", numOfSamples="
				+ numOfSamples + ", receivedDate=" + receivedDate + ", rejectedSamples=" + rejectedSamples
				+ ", facilityId=" + facilityId + ", labId=" + labId + ", batchStatusId=" + batchStatusId
				+ ", ictcLabTechnicianId=" + ictcLabTechnicianId + ", eidLabTechnicianId=" + eidLabTechnicianId + "]";
	}

}
