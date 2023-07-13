package gov.naco.soch.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import gov.naco.soch.domain.LabTestSampleBatch;
import gov.naco.soch.service.dto.LabTestSampleBatchDTO;

/**
 * Mapper for the entity {@link LabTestSampleBatch} and its DTO
 * {@link LabTestSampleBatchDTO}.
 */
@Mapper(componentModel = "spring", uses = {FacilityMapper.class, UserMasterMapper.class})
public interface LabTestSampleBatchMapper extends EntityMapper<LabTestSampleBatchDTO, LabTestSampleBatch> {

	@Mappings({
	@Mapping(source = "facility.id", target = "facilityId"),
	@Mapping(source = "lab.id", target = "labId"),
	@Mapping(source = "ictcLabTechnician.id", target = "ictcLabTechnicianId"),
	@Mapping(source = "eidLabTechnician.id", target = "eidLabTechnicianId")
	})
	LabTestSampleBatchDTO toDto(LabTestSampleBatch userMaster);

	@Mappings({
	@Mapping(source = "facilityId", target = "facility"),
	@Mapping(source = "labId", target = "lab"),
	@Mapping(source = "ictcLabTechnicianId", target = "ictcLabTechnician"),
	@Mapping(source = "eidLabTechnicianId", target = "eidLabTechnician")
	})
	LabTestSampleBatch toEntity(LabTestSampleBatchDTO userMasterDTO);

	default LabTestSampleBatch fromId(Long id) {
		if (id == null) {
			return null;
		}
		LabTestSampleBatch labTestSampleBatch = new LabTestSampleBatch();
		labTestSampleBatch.setId(id);
		return labTestSampleBatch;
	}
}
