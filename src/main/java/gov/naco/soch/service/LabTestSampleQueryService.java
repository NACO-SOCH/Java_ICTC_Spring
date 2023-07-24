package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.LabTestSample;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.service.dto.ICTCSampleCollectionCriteria;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.IctcTestResultHistoryDTO;
import gov.naco.soch.service.dto.LabTestSampleCriteria;
import gov.naco.soch.service.dto.LabTestSampleDTO;
import gov.naco.soch.service.mapper.LabTestSampleMapper;

/**
 * Service for executing complex queries for {@link LabTestSample} entities in
 * the database. The main input is a {@link LabTestSampleCriteria} which gets
 * converted to {@link Specification}, in a way that all the filters must apply.
 * It returns a {@link List} of {@link LabTestSampleDTO} or a {@link Page} of
 * {@link LabTestSampleDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class LabTestSampleQueryService {

	private final Logger log = LoggerFactory.getLogger(LabTestSampleQueryService.class);

	private final LabTestSampleRepository labTestSampleRepository;

	private final LabTestSampleMapper labTestSampleMapper;
	
	public LabTestSampleQueryService(LabTestSampleRepository labTestSampleRepository,
			LabTestSampleMapper labTestSampleMapper) {
		this.labTestSampleRepository = labTestSampleRepository;
		this.labTestSampleMapper = labTestSampleMapper;
	}

	/**
	 * Return a {@link List} of {@link LabTestSampleDTO} which matches the criteria
	 * from the database.
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public List<LabTestSampleDTO> findByCriteria(LabTestSampleCriteria criteria) {
		log.debug("find by criteria : {}", criteria);
		final Specification<LabTestSample> specification = createSpecification(criteria);
		return labTestSampleMapper.toDto(labTestSampleRepository.findAll(specification));
	}

	/**
	 * Return a {@link Page} of {@link LabTestSampleDTO} which matches the criteria
	 * from the database.
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @param page     The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<LabTestSampleDTO> findByCriteria(LabTestSampleCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<LabTestSample> specification = createSpecification(criteria);
		return labTestSampleRepository.findAll(specification, page).map(labTestSampleMapper::toDto);
	}
	
	/**
	 * Return a {@link Page} of {@link LabTestSampleDTO} which matches the criteria
	 * from the database.
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @param page     The page, which should be returned.
	 * @return the matching entities.
	 */
	@Transactional(readOnly = true)
	public Page<LabTestSample> findEntitiesByCriteria(LabTestSampleCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		final Specification<LabTestSample> specification = createSpecification(criteria);
		return labTestSampleRepository.findAll(specification, page);
	}

	/**
	 * Return the number of matching entities in the database.
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @return the number of matching entities.
	 */
	@Transactional(readOnly = true)
	public long countByCriteria(LabTestSampleCriteria criteria) {
		log.debug("count by criteria : {}", criteria);
		final Specification<LabTestSample> specification = createSpecification(criteria);
		return labTestSampleRepository.count(specification);
	}
	
	/**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public IctcTestResultHistoryDTO findEntitiesByCriteriaForTRF(LabTestSampleCriteria criteria, Pageable page, Long sampleId, Boolean isSampleId) {
//        log.debug("find by criteria : {}, page: {}", criteria, page);
//        final Specification<LabTestSample> specification = createSpecification(criteria);
        IctcTestResultHistoryDTO history = new IctcTestResultHistoryDTO();
//        Page<LabTestSample> pageOfHistory = labTestSampleRepository.findAll(specification, page);
//        history.setLabTestSamples(pageOfHistory.getContent());
//        if(!history.getLabTestSamples().isEmpty()) {
//        	for(LabTestSample sample : history.getLabTestSamples()) {
//        		if(sample.getId().equals(sampleId)) {
//        			history.setCurrentLabTestSample(sample);
//        			history.setCurrentResultId(sample.getId());
//        			break;
//        		}
//        	}
//        	List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(history.getLabTestSamples().get(0).getIctcBeneficiary().getBeneficiary().getId(), 4);
//        	if(!motherDetails.isEmpty()) {
//        		history.setMotherDetails(motherDetails.get(0).getMemberBeneficiary());
//        	}
//        }
        return history;
    }

	/**
	 * Function to convert {@link ICTCSampleCollectionCriteria} to a
	 * {@link Specification}
	 * 
	 * @param criteria The object which holds all the filters, which the entities
	 *                 should match.
	 * @return the matching {@link Specification} of the entity.
	 */

    protected Specification<LabTestSample> createSpecification(LabTestSampleCriteria criteria) {
        Specification<LabTestSample> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getBarcodeNumber() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("barcodeNumber"), criteria.getBarcodeNumber()));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDelete"), criteria.getIsDelete()));
            }
            if (criteria.getTestMachineTypeId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("testMachineTypeId"), criteria.getTestMachineTypeId()));
            }
            if (criteria.getTestTypeId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("testTypeId"), criteria.getTestTypeId()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("beneficiary").get("id"), criteria.getBeneficiaryId()));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("batch").get("id"), criteria.getBatchId()));
            }
            if (criteria.getTestMachineId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("testMachineId"), criteria.getTestMachineId()));
            }
            if (criteria.getResultTypeId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("resultTypeId"), criteria.getResultTypeId()));
            }
            if (criteria.getMasterResultStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("masterResultStatus"), criteria.getMasterResultStatus()));
            }
            if (criteria.getLabId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("lab").get("id"), criteria.getLabId()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("facility").get("id"), criteria.getFacilityId()));
            }
        }
        return specification;
    }

}
