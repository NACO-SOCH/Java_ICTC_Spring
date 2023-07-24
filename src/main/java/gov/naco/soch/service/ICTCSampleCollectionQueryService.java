package gov.naco.soch.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.repository.ICTCSampleCollectionRepository;
import gov.naco.soch.service.dto.ICTCSampleCollectionCriteria;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;

/**
 * Service for executing complex queries for {@link ICTCSampleCollection} entities in the database.
 * The main input is a {@link ICTCSampleCollectionCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCSampleCollectionDTO} or a {@link Page} of {@link ICTCSampleCollectionDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCSampleCollectionQueryService {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionQueryService.class);

    private final ICTCSampleCollectionRepository iCTCSampleCollectionRepository;

    private final ICTCSampleCollectionMapper iCTCSampleCollectionMapper;

    public ICTCSampleCollectionQueryService(ICTCSampleCollectionRepository iCTCSampleCollectionRepository, ICTCSampleCollectionMapper iCTCSampleCollectionMapper) {
        this.iCTCSampleCollectionRepository = iCTCSampleCollectionRepository;
        this.iCTCSampleCollectionMapper = iCTCSampleCollectionMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCSampleCollectionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCSampleCollectionDTO> findByCriteria(ICTCSampleCollectionCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCSampleCollection> specification = createSpecification(criteria);
        return iCTCSampleCollectionMapper.toDto(iCTCSampleCollectionRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCSampleCollectionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCSampleCollectionDTO> findByCriteria(ICTCSampleCollectionCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCSampleCollection> specification = createSpecification(criteria);
        return iCTCSampleCollectionRepository.findAll(specification, page)
            .map(iCTCSampleCollectionMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCSampleCollectionCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCSampleCollection> specification = createSpecification(criteria);
        return iCTCSampleCollectionRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCSampleCollectionCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCSampleCollection> createSpecification(ICTCSampleCollectionCriteria criteria) {
        Specification<ICTCSampleCollection> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("barcode"), criteria.getBarcode()));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("testType"), criteria.getTestType()));
            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("sampleCollectionStatus"), criteria.getSampleCollectionStatus()));
            }
            if (criteria.getIsDispatched() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDispatched"), criteria.getIsDispatched()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDeleted"), criteria.getIsDeleted()));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("ictcBeneficiary").get("id"), criteria.getIctcBeneficiaryId()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("visit").get("id"), criteria.getVisitId()));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("batch").get("id"), criteria.getBatchId()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("facility").get("id"), criteria.getFacilityId()));
            }
        }
        return specification;
    }
}
