package gov.naco.soch.service.mapper;

import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.IctcPartnerDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity IctcPartnerDetails and its DTO IctcPartnerDetailsDTO.
 */
@Mapper(componentModel = "spring", uses = {ICTCBeneficiaryMapper.class, FacilityMapper.class, ICTCFollowUpMapper.class})
public interface IctcPartnerDetailsMapper extends EntityMapper<IctcPartnerDetailsDTO, IctcPartnerDetails> {
	@Mappings({
	@Mapping(source = "ictcBeneficiary.id", target = "ictcBeneficiaryId"),
	@Mapping(source = "followUp.id", target = "followUpId"),
    @Mapping(source = "partnerArtCenter.id", target = "partnerArtCenterId")
	})
    IctcPartnerDetailsDTO toDto(IctcPartnerDetails ictcPartnerDetails);

	@Mappings({
    @Mapping(source = "ictcBeneficiaryId", target = "ictcBeneficiary"),
    @Mapping(source = "followUpId", target = "followUp"),
    @Mapping(source = "partnerArtCenterId", target = "partnerArtCenter")
	})
    IctcPartnerDetails toEntity(IctcPartnerDetailsDTO ictcPartnerDetailsDTO);

    default IctcPartnerDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        IctcPartnerDetails ictcPartnerDetails = new IctcPartnerDetails();
        ictcPartnerDetails.setId(id);
        return ictcPartnerDetails;
    }
}
