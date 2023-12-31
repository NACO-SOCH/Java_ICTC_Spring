package gov.naco.soch.service.dto;

import java.util.List;

import gov.naco.soch.domain.BeneficiaryVisitRegister;
import gov.naco.soch.projection.BeneficiaryClinicalTreatmentSyphilisProjection;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCBeneficiary} entity.
 */
public class ICTCBeneficiaryDO {

	private BeneficiaryDTO beneficiary;

	private ICTCVisitDTO visit;

	private ICTCBeneficiaryDTO ictcBeneficiary;

	private ICTCSampleCollectionDTO sample;
	
	private ICTCTestResultDTO result;

	private AddressDTO address;

	private List<BeneficiaryReferralDTO> referrals;

	private List<ICTCFollowUpDTO> followups;
	
	private Long followUpId;
	
	private Long beneficiaryReferralId;
	
	private List<IctcPartnerDetailsDTO> partnerDetails;
	
	private InfantMotherDetailsDTO infantMotherDetails;
	
	private BeneficiaryVisitRegister beneficiaryVisitRegister;
	
	private Boolean isArtRegistered;

	private BeneficiaryClinicalTreatmentSyphilisProjection dsrcSyphilisDetails;

	public BeneficiaryDTO getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryDTO beneficiary) {
		this.beneficiary = beneficiary;
	}

	public ICTCVisitDTO getVisit() {
		return visit;
	}

	public void setVisit(ICTCVisitDTO visit) {
		this.visit = visit;
	}

	public ICTCBeneficiaryDTO getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiaryDTO ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public List<BeneficiaryReferralDTO> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<BeneficiaryReferralDTO> referrals) {
		this.referrals = referrals;
	}

	public List<ICTCFollowUpDTO> getFollowups() {
		return followups;
	}

	public void setFollowups(List<ICTCFollowUpDTO> followups) {
		this.followups = followups;
	}
	
	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}
	
	public Long getBeneficiaryReferralId() {
		return beneficiaryReferralId;
	}

	public void setBeneficiaryReferralId(Long beneficiaryReferralId) {
		this.beneficiaryReferralId = beneficiaryReferralId;
	}
	
	public List<IctcPartnerDetailsDTO> getPartnerDetails() {
		return partnerDetails;
	}

	public void setPartnerDetails(List<IctcPartnerDetailsDTO> partnerDetails) {
		this.partnerDetails = partnerDetails;
	}
	
	public InfantMotherDetailsDTO getInfantMotherDetails() {
		return infantMotherDetails;
	}

	public void setInfantMotherDetails(InfantMotherDetailsDTO infantMotherDetails) {
		this.infantMotherDetails = infantMotherDetails;
	}
	
	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}
	
	public Boolean getIsArtRegistered() {
		return isArtRegistered;
	}

	public void setIsArtRegistered(Boolean isArtRegistered) {
		this.isArtRegistered = isArtRegistered;
	}
	
	public ICTCSampleCollectionDTO getSample() {
		return sample;
	}

	public void setSample(ICTCSampleCollectionDTO sample) {
		this.sample = sample;
	}

	public ICTCTestResultDTO getResult() {
		return result;
	}

	public void setResult(ICTCTestResultDTO result) {
		this.result = result;
	}

	public BeneficiaryClinicalTreatmentSyphilisProjection getDsrcSyphilisDetails() {
		return dsrcSyphilisDetails;
	}

	public void setDsrcSyphilisDetails(BeneficiaryClinicalTreatmentSyphilisProjection dsrcSyphilisDetails) {
		this.dsrcSyphilisDetails = dsrcSyphilisDetails;
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryDO [beneficiary=" + beneficiary + ", visit=" + visit + ", ictcBeneficiary="
				+ ictcBeneficiary + ", sample=" + sample + ", address=" + address
				+ ", referrals=" + referrals + ", followups=" + followups + ", followUpId=" + followUpId
				+ ", beneficiaryReferralId=" + beneficiaryReferralId + ", partnerDetails=" + partnerDetails
				+ ", infantMotherDetails=" + infantMotherDetails + "]";
	}

}
