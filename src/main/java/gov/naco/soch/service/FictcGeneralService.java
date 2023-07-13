package gov.naco.soch.service;

import gov.naco.soch.service.dto.FictcBeneficiaryCreateDTO;

public interface FictcGeneralService {
	
	FictcBeneficiaryCreateDTO createBeneficiaryAndInitiateReferral(FictcBeneficiaryCreateDTO details);

}
