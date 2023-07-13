package gov.naco.soch.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import gov.naco.soch.domain.LabTestSample;
import gov.naco.soch.service.dto.LabTestSampleDTO;

/**
 * Mapper for the entity {@link LabTestSample} and its DTO {@link LabTestSampleDTO}.
 */
@Mapper(componentModel = "spring", uses = {BeneficiaryMapper.class, LabTestSampleBatchMapper.class, UserMasterMapper.class, FacilityMapper.class, ICTCVisitMapper.class, ICTCBeneficiaryMapper.class})
public interface LabTestSampleMapper extends EntityMapper<LabTestSampleDTO, LabTestSample> {

	@Mappings({
    @Mapping(source = "beneficiary.id", target = "beneficiaryId"),
    @Mapping(source = "batch.id", target = "batchId"),
    @Mapping(source = "labInCharge.id", target = "labInChargeId"),
    @Mapping(source = "labTechnician.id", target = "labTechnicianId"),
    @Mapping(source = "lab.id", target = "labId"),
    @Mapping(source = "facility.id", target = "facilityId")
	})LabTestSampleDTO toDto(LabTestSample labTestSample);

	@Mappings({
    @Mapping(source = "beneficiaryId", target = "beneficiary"),
    @Mapping(source = "batchId", target = "batch"),
    @Mapping(source = "labInChargeId", target = "labInCharge"),
    @Mapping(source = "labTechnicianId", target = "labTechnician"),
    @Mapping(source = "labId", target = "lab"),
    @Mapping(source = "facilityId", target = "facility")
	})LabTestSample toEntity(LabTestSampleDTO labTestSampleDTO);

    default LabTestSample fromId(Long id) {
        if (id == null) {
            return null;
        }
        LabTestSample labTestSample = new LabTestSample();
        labTestSample.setId(id);
        return labTestSample;
    }
}
