package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.aop.logging.Measured;
// for static metamodels
import gov.naco.soch.domain.IctcLinkedFacility;
import gov.naco.soch.domain.IctcLinkedFacility_;
import gov.naco.soch.repository.IctcLinkedFacilityRepository;
import gov.naco.soch.service.dto.IctcLinkedFacilityCriteria;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;
import gov.naco.soch.service.mapper.IctcLinkedFacilityMapper;
/**
 * Service for executing complex queries for {@link IctcLinkedFacility} entities in the database.
 * The main input is a {@link IctcLinkedFacilityCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link IctcLinkedFacilityDTO} or a {@link Page} of {@link IctcLinkedFacilityDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class IctcLinkedFacilityQueryService {

    private final Logger log = LoggerFactory.getLogger(IctcLinkedFacilityQueryService.class);

    private final IctcLinkedFacilityRepository ictcLinkedFacilityRepository;

    private final IctcLinkedFacilityMapper ictcLinkedFacilityMapper;

    public IctcLinkedFacilityQueryService(IctcLinkedFacilityRepository ictcLinkedFacilityRepository, IctcLinkedFacilityMapper ictcLinkedFacilityMapper) {
        this.ictcLinkedFacilityRepository = ictcLinkedFacilityRepository;
        this.ictcLinkedFacilityMapper = ictcLinkedFacilityMapper;
    }

    /**
     * Return a {@link List} of {@link IctcLinkedFacilityDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<IctcLinkedFacilityDTO> findByCriteria(IctcLinkedFacilityCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<IctcLinkedFacility> specification = createSpecification(criteria);
        return ictcLinkedFacilityMapper.toDto(ictcLinkedFacilityRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link IctcLinkedFacilityDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    @Measured(message = "Get LFAC findByCriteria")
    public Page<IctcLinkedFacilityDTO> findByCriteria(IctcLinkedFacilityCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<IctcLinkedFacility> specification = createSpecification(criteria);
        return ictcLinkedFacilityRepository.findAll(specification, page)
            .map(ictcLinkedFacilityMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(IctcLinkedFacilityCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<IctcLinkedFacility> specification = createSpecification(criteria);
        return ictcLinkedFacilityRepository.count(specification);
    }

    /**
     * Function to convert {@link IctcLinkedFacilityCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    @Measured(message = "Get LFAC createSpecification")
    protected Specification<IctcLinkedFacility> createSpecification(IctcLinkedFacilityCriteria criteria) {
    	Specification<IctcLinkedFacility> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getFacilityName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("facilityName"), criteria.getFacilityName()));
            }
            if (criteria.getLinkedFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("linkedFacilityId"), criteria.getLinkedFacilityId()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("facilityId"), criteria.getFacilityId()));
            }
            if (criteria.getFacilityType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("facilityType"), criteria.getFacilityType()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDeleted"), criteria.getIsDeleted()));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("status"), criteria.getStatus()));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("createdBy"), criteria.getCreatedBy()));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("createdTime"), criteria.getCreatedTime()));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("modifiedBy"), criteria.getModifiedBy()));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("modifiedTime"), criteria.getModifiedTime()));
            }
        }
        return specification;
    }
}
