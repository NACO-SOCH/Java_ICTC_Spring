package gov.naco.soch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.Facility;
import gov.naco.soch.domain.MappingLabFacility;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.MappingLabFacilityRepository;
import gov.naco.soch.service.FacilityService;
import gov.naco.soch.service.dto.FacilityBasicListDto;
import gov.naco.soch.service.dto.FacilityDTO;
import gov.naco.soch.service.mapper.FacilityMapper;

/**
 * Service Implementation for managing {@link Facility}.
 */
@Service
@Transactional
public class FacilityServiceImpl implements FacilityService {

    private final Logger log = LoggerFactory.getLogger(FacilityServiceImpl.class);

    private final FacilityRepository facilityRepository;

    private final FacilityMapper facilityMapper;
    
    private final MappingLabFacilityRepository mappingLabFacilityRepository;

    public FacilityServiceImpl(FacilityRepository facilityRepository, FacilityMapper facilityMapper, MappingLabFacilityRepository mappingLabFacilityRepository) {
        this.facilityRepository = facilityRepository;
        this.facilityMapper = facilityMapper;
        this.mappingLabFacilityRepository = mappingLabFacilityRepository;
    }

    /**
     * Save a facility.
     *
     * @param facilityDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public FacilityDTO save(FacilityDTO facilityDTO) {
        log.debug("Request to save Facility : {}", facilityDTO);
        Facility facility = facilityMapper.toEntity(facilityDTO);
        facility = facilityRepository.save(facility);
        return facilityMapper.toDto(facility);
    }

    /**
     * Get all the facilities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FacilityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Facilities");
        return facilityRepository.findAll(pageable)
            .map(facilityMapper::toDto);
    }

    /**
     * Get one facility by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FacilityDTO> findOne(Long id) {
        log.debug("Request to get Facility : {}", id);
        return facilityRepository.findById(id)
            .map(facilityMapper::toDto);
    }

    /**
     * Delete the facility by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Facility : {}", id);
        facilityRepository.deleteById(id);
    }
    
    /**
     * Get facility name from facility id
     * 
     * @param id id
     * @return
     */
    public String getFacilityFromFacilityId(Long id) {
    	Optional<FacilityDTO> optional = findOne(id);
    	if(optional.isPresent()) {
    		return optional.get().getName();
    	}
    	return null;
    }
    
    public List<FacilityBasicListDto> findAllLabsMappedToICTC(Long facilityId, Long labTypeId) {
    	List<MappingLabFacility> mappings;
    	if(labTypeId == null) {
    		 mappings = mappingLabFacilityRepository.findAllLabsMappingToICTC(facilityId);
    	} else {
    		 mappings = mappingLabFacilityRepository.findAllLabsMappingToICTC(facilityId, labTypeId);
    	}
    	List<FacilityBasicListDto> facilities = new ArrayList<>();
    	mappings.forEach(mapping -> {
    		FacilityBasicListDto facility = new FacilityBasicListDto(mapping.getLab().getId(), mapping.getLab().getName(), mapping.getLab().getCode(), mapping.getLab().getFacilityTypeId(), null);
    		facilities.add(facility);
    	});
    	return facilities;
    }
}
 