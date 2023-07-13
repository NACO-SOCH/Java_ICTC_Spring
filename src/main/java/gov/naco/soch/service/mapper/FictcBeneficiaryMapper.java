package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.FictcBeneficiaryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity FictcBeneficiary and its DTO FictcBeneficiaryDTO.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class, MasterPregnancyTypeCaseMapper.class, FacilityMapper.class})
public interface FictcBeneficiaryMapper extends EntityMapper<FictcBeneficiaryDTO, FictcBeneficiary> {

	 @Mappings({
    @Mapping(source = "beneficiary.id", target = "beneficiaryId"),
    @Mapping(source = "pregnancyType.id", target = "pregnancyTypeId"),
    @Mapping(source = "facility.id", target = "facilityId")
    })
    FictcBeneficiaryDTO toDto(FictcBeneficiary fictcBeneficiary);
    
    @Mappings({
    @Mapping(source = "beneficiaryId", target = "beneficiary"),
    @Mapping(source = "pregnancyTypeId", target = "pregnancyType"),
    @Mapping(source = "facilityId", target = "facility"),
    @Mapping(source = "isPregnant", target = "isPregnant")
    })
    FictcBeneficiary toEntity(FictcBeneficiaryDTO fictcBeneficiaryDTO);

    default FictcBeneficiary fromId(Long id) {
        if (id == null) {
            return null;
        }
        FictcBeneficiary fictcBeneficiary = new FictcBeneficiary();
        fictcBeneficiary.setId(id);
        return fictcBeneficiary;
    }
}
