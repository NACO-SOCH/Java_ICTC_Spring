package gov.naco.soch.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.domain.UserMaster;
import gov.naco.soch.service.dto.UserMasterDTO;

/**
 * Mapper for the entity {@link UserMaster} and its DTO {@link UserMasterDTO}.
 */
@Mapper(componentModel = "spring", uses = {FacilityMapper.class})
public interface UserMasterMapper extends EntityMapper<UserMasterDTO, UserMaster> {

    @Mapping(source = "facility.id", target = "facilityId")
    UserMasterDTO toDto(UserMaster userMaster);

    @Mapping(source = "facilityId", target = "facility")
    UserMaster toEntity(UserMasterDTO userMasterDTO);

    default UserMaster fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserMaster userMaster = new UserMaster();
        userMaster.setId(id);
        return userMaster;
    }
}
