package gov.naco.soch.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;

/**
 * Mapper for the entity {@link BeneficiaryReferral} and its DTO {@link BeneficiaryReferralDTO}.
 */
@Mapper(componentModel = "spring", uses = {FacilityMapper.class, BeneficiaryMapper.class})
public interface BeneficiaryReferralMapper extends EntityMapper<BeneficiaryReferralDTO, BeneficiaryReferral> {

	@Mappings({
	@Mapping(source = "beneficiary.id", target = "beneficiaryId"),
	@Mapping(source = "referedFrom.id", target = "referedFrom"),
	@Mapping(source = "referedTo.id", target = "referedTo"),
	@Mapping(source = "acceptedFacility.id", target = "acceptedFacility")
	})
	BeneficiaryReferralDTO toDto(BeneficiaryReferral beneficiaryReferral);
	
	@Mappings({
	@Mapping(source = "beneficiaryId", target = "beneficiary"),
	@Mapping(source = "referedFrom", target = "referedFrom"),
	@Mapping(source = "referedTo", target = "referedTo"),
	@Mapping(source = "acceptedFacility", target = "acceptedFacility") 
	})
	BeneficiaryReferral toEntity(BeneficiaryReferralDTO beneficiaryReferralDTO);
	
    default BeneficiaryReferral fromId(Long id) {
        if (id == null) {
            return null;
        }
        BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
        beneficiaryReferral.setId(id);
        return beneficiaryReferral;
    }
}
