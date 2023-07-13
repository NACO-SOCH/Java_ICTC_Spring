package gov.naco.soch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import gov.naco.soch.domain.LabTestSample;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.LabTestSampleDTO;

/**
 * Service Interface for managing {@link gov.naco.soch.domain.LabTestSample}.
 */
public interface LabTestSampleService {

    /**
     * Save a labTestSample.
     *
     * @param labTestSampleDTO the entity to save.
     * @return the persisted entity.
     */
    LabTestSampleDTO save(LabTestSampleDTO labTestSampleDTO);
    
    LabTestSample save(LabTestSample labTestSample);

    /**
     * Get all the labTestSamples.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LabTestSampleDTO> findAll(Pageable pageable);

    /**
     * Get the "id" labTestSample.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LabTestSampleDTO> findOne(Long id);
    
    Optional<LabTestSample> find(Long id);

    /**
     * Delete the "id" labTestSample.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    List<LabTestSampleDTO> saveListOfSamples(List<CreateSampleDTO> samples);
    
    void deactivate(Long id);
    
//    ICTCTestDetails getTestDetails(Long id);
}
