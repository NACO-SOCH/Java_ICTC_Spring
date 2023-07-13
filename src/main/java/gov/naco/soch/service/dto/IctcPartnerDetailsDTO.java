package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the IctcPartnerDetails entity.
 */
public class IctcPartnerDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Integer partnerStatusKnown;

    private Integer partnerHivStatus;

    private Integer partnerNotTestedReason;

    private LocalDate partnerTestFollowUpDate;

    private Boolean isPartnerPrevTreatedForHiv;

    private LocalDate createdDate;

    private Long ictcBeneficiaryId;
    
    private Long partnerArtCenterId;
    
    private Integer followUpType;
    
    private Long visitId;
    
    private Long facilityId;
    
    private Long resultId;
    
    private Long followUpId;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPartnerStatusKnown() {
		return partnerStatusKnown;
	}

	public void setPartnerStatusKnown(Integer partnerStatusKnown) {
		this.partnerStatusKnown = partnerStatusKnown;
	}

	public Integer getPartnerHivStatus() {
		return partnerHivStatus;
	}

	public void setPartnerHivStatus(Integer partnerHivStatus) {
		this.partnerHivStatus = partnerHivStatus;
	}

	public Integer getPartnerNotTestedReason() {
		return partnerNotTestedReason;
	}

	public void setPartnerNotTestedReason(Integer partnerNotTestedReason) {
		this.partnerNotTestedReason = partnerNotTestedReason;
	}

	public LocalDate getPartnerTestFollowUpDate() {
		return partnerTestFollowUpDate;
	}

	public void setPartnerTestFollowUpDate(LocalDate partnerTestFollowUpDate) {
		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
	}

	public Boolean getIsPartnerPrevTreatedForHiv() {
		return isPartnerPrevTreatedForHiv;
	}

	public void setIsPartnerPrevTreatedForHiv(Boolean isPartnerPrevTreatedForHiv) {
		this.isPartnerPrevTreatedForHiv = isPartnerPrevTreatedForHiv;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long getPartnerArtCenterId() {
		return partnerArtCenterId;
	}

	public void setPartnerArtCenterId(Long partnerArtCenterId) {
		this.partnerArtCenterId = partnerArtCenterId;
	}

	public Integer getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IctcPartnerDetailsDTO ictcPartnerDetailsDTO = (IctcPartnerDetailsDTO) o;
        if (ictcPartnerDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ictcPartnerDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IctcPartnerDetailsDTO{" +
            "id=" + getId() +
            ", partnerStatusKnown=" + getPartnerStatusKnown() +
            ", partnerHivStatus=" + getPartnerHivStatus() +
            ", partnerNotTestedReason=" + getPartnerNotTestedReason() +
            ", partnerTestFollowUpDate='" + getPartnerTestFollowUpDate() + "'" +
            ", isPartnerPrevTreatedForHiv='" + isPartnerPrevTreatedForHiv + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", ictcBeneficiary=" + getIctcBeneficiaryId() +
            "}";
    }
}
