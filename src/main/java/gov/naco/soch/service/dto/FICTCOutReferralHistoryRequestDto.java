
package gov.naco.soch.service.dto;

import java.time.LocalDateTime;

public class FICTCOutReferralHistoryRequestDto {

	private Long referredFromFacilityId;
	private LocalDateTime hivScreeningDate;
	
	//private Long referredToFacilityId;
	public Long getReferredFromFacilityId() {
		return referredFromFacilityId;
	}
	public void setReferredFromFacilityId(Long referredFromFacilityId) {
		this.referredFromFacilityId = referredFromFacilityId;
	}

	public LocalDateTime getHivScreeningDate() {
		return hivScreeningDate;
	}
	public void setHivScreeningDate(LocalDateTime hivScreeningDate) {
		this.hivScreeningDate = hivScreeningDate;
	}
	
//	public Long getReferredToFacilityId() {
//	return referredToFacilityId;
//}
//public void setReferredToFacilityId(Long referredToFacilityId) {
//	this.referredToFacilityId = referredToFacilityId;
//}
}
