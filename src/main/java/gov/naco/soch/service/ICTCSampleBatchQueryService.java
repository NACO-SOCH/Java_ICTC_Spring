package gov.naco.soch.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.ICTCSampleBatchRepository;
import gov.naco.soch.service.dto.ICTCSampleBatchCriteria;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;
import gov.naco.soch.service.mapper.ICTCSampleBatchMapper;

/**
 * Service for executing complex queries for {@link ICTCSampleBatch} entities in the database.
 * The main input is a {@link ICTCSampleBatchCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCSampleBatchDTO} or a {@link Page} of {@link ICTCSampleBatchDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCSampleBatchQueryService {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleBatchQueryService.class);

    private final ICTCSampleBatchRepository iCTCSampleBatchRepository;

    private final ICTCSampleBatchMapper iCTCSampleBatchMapper;

    public ICTCSampleBatchQueryService(ICTCSampleBatchRepository iCTCSampleBatchRepository, ICTCSampleBatchMapper iCTCSampleBatchMapper) {
        this.iCTCSampleBatchRepository = iCTCSampleBatchRepository;
        this.iCTCSampleBatchMapper = iCTCSampleBatchMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCSampleBatchDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCSampleBatchDTO> findByCriteria(ICTCSampleBatchCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCSampleBatch> specification = createSpecification(criteria);
        return iCTCSampleBatchMapper.toDto(iCTCSampleBatchRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCSampleBatchDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCSampleBatchDTO> findByCriteria(ICTCSampleBatchCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCSampleBatch> specification = createSpecification(criteria);
        return iCTCSampleBatchRepository.findAll(specification, page)
            .map(iCTCSampleBatchMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCSampleBatchCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCSampleBatch> specification = createSpecification(criteria);
        return iCTCSampleBatchRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCSampleBatchCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ICTCSampleBatch> createSpecification(ICTCSampleBatchCriteria criteria) {
        Specification<ICTCSampleBatch> specification = Specification.where(null);
        return Specification.<ICTCSampleBatch>where((root, query, builder) -> {
            if (criteria != null) {
                if (criteria.getId() != null) {
                    return builder.equal(root.get("id"), criteria.getId());
                }

                if (criteria.getConsignmentId() != null) {
                    return builder.equal(root.get("consignmentId"), criteria.getConsignmentId());
                }

                if (criteria.getBatchStatus() != null) {
                    return builder.equal(root.get("batchStatus"), criteria.getBatchStatus());
                }

                if (criteria.getIsActive() != null) {
                    return builder.equal(root.get("isActive"), criteria.getIsActive());
                }

                if (criteria.getIsDeleted() != null) {
                    return builder.equal(root.get("isDeleted"), criteria.getIsDeleted());
                }

                if (criteria.getLabId() != null) {
                    return builder.equal(root.join("facility").get("id"), criteria.getLabId());
                }

                if (criteria.getFacilityId() != null) {
                    return builder.equal(root.join("lab").get("id"), criteria.getFacilityId());
                }
            }

            return null;
        });
    }
}
