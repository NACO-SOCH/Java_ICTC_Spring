package gov.naco.soch.service.dto;


import java.util.Objects;

public class ICTCBatchDetailsCriteria {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long labId;

    private String consignmentId;

//    private LocalDateFilter dispatchDate;

    private Integer sampleCount;

    private Integer acceptedSampleCount;

    private Integer rejectedSampleCount;

    private String batchStatus;

    private Long facilityId;
    
    private String eidLabName;
    
    private String batchStatusDesc;

    public ICTCBatchDetailsCriteria() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public String getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
    }

//    public LocalDateFilter getDispatchDate() {
//        return dispatchDate;
//    }
//
//    public void setDispatchDate(LocalDateFilter dispatchDate) {
//        this.dispatchDate = dispatchDate;
//    }

    public Integer getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Integer getAcceptedSampleCount() {
        return acceptedSampleCount;
    }

    public void setAcceptedSampleCount(Integer acceptedSampleCount) {
        this.acceptedSampleCount = acceptedSampleCount;
    }

    public Integer getRejectedSampleCount() {
        return rejectedSampleCount;
    }

    public void setRejectedSampleCount(Integer rejectedSampleCount) {
        this.rejectedSampleCount = rejectedSampleCount;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    public String getEidLabName() {
		return eidLabName;
	}

	public void setEidLabName(String eidLabName) {
		this.eidLabName = eidLabName;
	}
	
	public String getBatchStatusDesc() {
		return batchStatusDesc;
	}

	public void setBatchStatusDesc(String batchStatusDesc) {
		this.batchStatusDesc = batchStatusDesc;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCBatchDetailsCriteria other = (ICTCBatchDetailsCriteria) obj;
		return Objects.equals(acceptedSampleCount, other.acceptedSampleCount)
				&& Objects.equals(batchStatus, other.batchStatus)
				&& Objects.equals(batchStatusDesc, other.batchStatusDesc)
				&& Objects.equals(consignmentId, other.consignmentId) && Objects.equals(eidLabName, other.eidLabName)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(id, other.id)
				&& Objects.equals(labId, other.labId) && Objects.equals(rejectedSampleCount, other.rejectedSampleCount)
				&& Objects.equals(sampleCount, other.sampleCount);
	}

    @Override
	public int hashCode() {
		return Objects.hash(acceptedSampleCount, batchStatus, batchStatusDesc, consignmentId, eidLabName, facilityId,
				id, labId, rejectedSampleCount, sampleCount);
	}

    @Override
	public String toString() {
		return "ICTCBatchDetailsCriteria [id=" + id + ", labId=" + labId + ", consignmentId=" + consignmentId
				+ ", sampleCount=" + sampleCount + ", acceptedSampleCount=" + acceptedSampleCount
				+ ", rejectedSampleCount=" + rejectedSampleCount + ", batchStatus=" + batchStatus + ", facilityId="
				+ facilityId + ", eidLabName=" + eidLabName + ", batchStatusDesc=" + batchStatusDesc + "]";
	}

}
