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
import gov.naco.soch.repository.ICTCSampleCollectionViewRepository;
import gov.naco.soch.service.dto.ICTCSampleCollectionViewCriteria;

import gov.naco.soch.service.dto.ICTCSampleCollectionViewDTO;
import gov.naco.soch.service.mapper.ICTCSampleCollectionViewMapper;

/**
 * Service for executing complex queries for ICTCSampleCollectionView entities in the database.
 * The main input is a {@link ICTCSampleCollectionViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCSampleCollectionViewDTO} or a {@link Page} of {@link ICTCSampleCollectionViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCSampleCollectionViewQueryService  {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionViewQueryService.class);

    private final ICTCSampleCollectionViewRepository iCTCSampleCollectionViewRepository;

    private final ICTCSampleCollectionViewMapper iCTCSampleCollectionViewMapper;

    public ICTCSampleCollectionViewQueryService(ICTCSampleCollectionViewRepository iCTCSampleCollectionViewRepository, ICTCSampleCollectionViewMapper iCTCSampleCollectionViewMapper) {
        this.iCTCSampleCollectionViewRepository = iCTCSampleCollectionViewRepository;
        this.iCTCSampleCollectionViewMapper = iCTCSampleCollectionViewMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCSampleCollectionViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCSampleCollectionViewDTO> findByCriteria(ICTCSampleCollectionViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCSampleCollectionView> specification = createSpecification(criteria);
        return iCTCSampleCollectionViewMapper.toDto(iCTCSampleCollectionViewRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCSampleCollectionViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCSampleCollectionViewDTO> findByCriteria(ICTCSampleCollectionViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCSampleCollectionView> specification = createSpecification(criteria);
        return iCTCSampleCollectionViewRepository.findAll(specification, page)
            .map(iCTCSampleCollectionViewMapper::toDto);
    }

    /**
     * Function to convert ICTCSampleCollectionViewCriteria to a {@link Specification}
     */
    protected Specification<ICTCSampleCollectionView> createSpecification(ICTCSampleCollectionViewCriteria criteria) {
        Specification<ICTCSampleCollectionView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("firstName"), criteria.getFirstName()));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("middleName"), criteria.getMiddleName()));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("lastName"), criteria.getLastName()));
            }
            if (criteria.getAge() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("age"), criteria.getAge()));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("visitDate"), criteria.getVisitDate()));
            }
            if (criteria.getTestType() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("testType"), criteria.getTestType()));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("ictcBeneficiaryId"), criteria.getIctcBeneficiaryId()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("visitId"), criteria.getVisitId()));
            }
            if (criteria.getPid() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("pid"), criteria.getPid()));
            }
            if (criteria.getUid() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("uid"), criteria.getUid()));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("barcode"), criteria.getBarcode()));
            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("sampleCollectionStatus"), criteria.getSampleCollectionStatus()));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("batchId"), criteria.getBatchId()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("facilityId"), criteria.getFacilityId()));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("categoryId"), criteria.getCategoryId()));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("genderId"), criteria.getGenderId()));
            }
        }
        return specification;
    }

}
