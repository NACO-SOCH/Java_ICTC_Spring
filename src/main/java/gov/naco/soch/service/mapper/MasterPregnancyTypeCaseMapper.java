package gov.naco.soch.service.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.domain.MasterPregnancyTypeCase;
import gov.naco.soch.service.dto.MasterPregnancyTypeCaseDTO;

@Mapper(componentModel = "spring", uses = {})
public interface MasterPregnancyTypeCaseMapper extends EntityMapper<MasterPregnancyTypeCaseDTO, MasterPregnancyTypeCase>{
	
	 default MasterPregnancyTypeCase fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        MasterPregnancyTypeCase masterPregnancyTypeCase = new MasterPregnancyTypeCase();
	        masterPregnancyTypeCase .setId(id);
	        return masterPregnancyTypeCase;
	    }

}
