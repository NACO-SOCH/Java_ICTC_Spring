package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ICTCVisitCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

	private Date visitDate;

	private Integer beneficiaryStatus;

	private Boolean isPregnant;

	private Integer pregnancyType;

	private Boolean hasTbSymptoms;

	private Boolean hasStiRtiSymptoms;

	private Integer infantBreastFed;

	private Integer arvProphylaxis;

	private Date cptInitiationDate;
//
//	private Integer partnerStatusKnown;
//
//	private Integer partnerHivStatus;
//
//	private String partnerNotTestedReason;
//
//	private Date partnerTestFollowUpDate;
//
//	private Boolean isPartnerPrivTreatForHiv;

	private Integer transmissionRoute;

	private Date pregnancyLmpDate;

	private Integer monthOfPregnancy;

	private Date expectedDeliveryDate;

	private Integer deliveryOutcome;

	private Date deliveryDate;

	private Integer gravida;

	private Boolean isRPQCaptured;

	private Long createdBy;

	private Date createdTime;

	private Long modifiedBy;

	private Date modifiedTime;

	private Boolean isActive;

	private Boolean isDeleted;

//	private Long partnerArtCenterId;

	private Long facilityId;

	private Long ictcBeneficiaryId;

    public ICTCVisitCriteria() {
    }


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Integer getPregnancyType() {
		return pregnancyType;
	}

	public void setPregnancyType(Integer pregnancyType) {
		this.pregnancyType = pregnancyType;
	}

	public Boolean getHasTbSymptoms() {
		return hasTbSymptoms;
	}

	public void setHasTbSymptoms(Boolean hasTbSymptoms) {
		this.hasTbSymptoms = hasTbSymptoms;
	}

	public Boolean getHasStiRtiSymptoms() {
		return hasStiRtiSymptoms;
	}

	public void setHasStiRtiSymptoms(Boolean hasStiRtiSymptoms) {
		this.hasStiRtiSymptoms = hasStiRtiSymptoms;
	}

	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Integer getArvProphylaxis() {
		return arvProphylaxis;
	}

	public void setArvProphylaxis(Integer arvProphylaxis) {
		this.arvProphylaxis = arvProphylaxis;
	}

	public Date getCptInitiationDate() {
		return cptInitiationDate;
	}

	public void setCptInitiationDate(Date cptInitiationDate) {
		this.cptInitiationDate = cptInitiationDate;
	}

//	public Integer getPartnerStatusKnown() {
//		return partnerStatusKnown;
//	}
//
//	public void setPartnerStatusKnown(Integer partnerStatusKnown) {
//		this.partnerStatusKnown = partnerStatusKnown;
//	}
//
//	public Integer getPartnerHivStatus() {
//		return partnerHivStatus;
//	}
//
//	public void setPartnerHivStatus(Integer partnerHivStatus) {
//		this.partnerHivStatus = partnerHivStatus;
//	}
//
//	public String getPartnerNotTestedReason() {
//		return partnerNotTestedReason;
//	}
//
//	public void setPartnerNotTestedReason(String partnerNotTestedReason) {
//		this.partnerNotTestedReason = partnerNotTestedReason;
//	}
//
//	public Date getPartnerTestFollowUpDate() {
//		return partnerTestFollowUpDate;
//	}
//
//	public void setPartnerTestFollowUpDate(Date partnerTestFollowUpDate) {
//		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
//	}
//
//	public Boolean getIsPartnerPrivTreatForHiv() {
//		return isPartnerPrivTreatForHiv;
//	}
//
//	public void setIsPartnerPrivTreatForHiv(Boolean isPartnerPrivTreatForHiv) {
//		this.isPartnerPrivTreatForHiv = isPartnerPrivTreatForHiv;
//	}

	public Integer getTransmissionRoute() {
		return transmissionRoute;
	}

	public void setTransmissionRoute(Integer transmissionRoute) {
		this.transmissionRoute = transmissionRoute;
	}

	public Date getPregnancyLmpDate() {
		return pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(Date pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

	public Integer getMonthOfPregnancy() {
		return monthOfPregnancy;
	}

	public void setMonthOfPregnancy(Integer monthOfPregnancy) {
		this.monthOfPregnancy = monthOfPregnancy;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Integer getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(Integer deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getGravida() {
		return gravida;
	}

	public void setGravida(Integer gravida) {
		this.gravida = gravida;
	}

	public Boolean getIsRPQCaptured() {
		return isRPQCaptured;
	}

	public void setIsRPQCaptured(Boolean isRPQCaptured) {
		this.isRPQCaptured = isRPQCaptured;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
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

//	public Long getPartnerArtCenterId() {
//		return partnerArtCenterId;
//	}
//
//	public void setPartnerArtCenterId(Long partnerArtCenterId) {
//		this.partnerArtCenterId = partnerArtCenterId;
//	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	

	
	@Override
	public String toString() {
		return "ICTCVisitCriteria [id=" + id + ", visitDate=" + visitDate + ", beneficiaryStatus=" + beneficiaryStatus
				+ ", isPregnant=" + isPregnant + ", pregnancyType=" + pregnancyType + ", hasTbSymptoms=" + hasTbSymptoms
				+ ", hasStiRtiSymptoms=" + hasStiRtiSymptoms + ", infantBreastFed=" + infantBreastFed
				+ ", arvProphylaxis=" + arvProphylaxis + ", cptInitiationDate=" + cptInitiationDate
				+ ", transmissionRoute=" + transmissionRoute + ", pregnancyLmpDate=" + pregnancyLmpDate
				+ ", monthOfPregnancy=" + monthOfPregnancy + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", deliveryOutcome=" + deliveryOutcome + ", deliveryDate=" + deliveryDate + ", gravida=" + gravida
				+ ", isRPQCaptured=" + isRPQCaptured + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", facilityId=" + facilityId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ "]";
	}

}
