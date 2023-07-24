package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// for static metamodels
import gov.naco.soch.domain.ICTCTestResultView;
import gov.naco.soch.repository.ICTCTestResultViewRepository;
import gov.naco.soch.service.dto.ICTCTestResultViewCriteria;
import gov.naco.soch.service.dto.ICTCTestResultViewDTO;
/**
 * Service for executing complex queries for ICTCTestResultView entities in the database.
 * The main input is a {@link ICTCTestResultViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCTestResultViewDTO} or a {@link Page} of {@link ICTCTestResultViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCTestResultViewQueryService {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultViewQueryService.class);

    private final ICTCTestResultViewRepository iCTCTestResultViewRepository;

    public ICTCTestResultViewQueryService(ICTCTestResultViewRepository iCTCTestResultViewRepository) {
        this.iCTCTestResultViewRepository = iCTCTestResultViewRepository;
    }

    /**
     * Return a {@link List} of {@link ICTCTestResultViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCTestResultView> findByCriteria(ICTCTestResultViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCTestResultView> specification = createSpecification(criteria);
        return iCTCTestResultViewRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link ICTCTestResultViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResultView> findByCriteria(ICTCTestResultViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResultView> specification = createSpecification(criteria);
        return iCTCTestResultViewRepository.findAll(specification, page);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCTestResultViewDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResultView> findByBasicCriteria(ICTCTestResultViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResultView> specification = createBasicSpecification(criteria);
        return iCTCTestResultViewRepository.findAll(specification, page);
    }

    /**
     * Function to convert ICTCTestResultViewCriteria to a {@link Specification}
     */

    private Specification<ICTCTestResultView> createSpecification(ICTCTestResultViewCriteria criteria) {
        Specification<ICTCTestResultView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getUid() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("uid"), criteria.getUid()));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("firstName"), criteria.getFirstName()));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("middleName"), criteria.getMiddleName()));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("lastName"), criteria.getLastName()));
            }
            if (criteria.getAge() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("age"), criteria.getAge()));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getResultStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("resultStatus"), criteria.getResultStatus()));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("hivStatus"), criteria.getHivStatus()));
            }
            if (criteria.getHivType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("hivType"), criteria.getHivType()));
            }
            if (criteria.getSampleId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("sampleId"), criteria.getSampleId()));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("consignmentId"), criteria.getConsignmentId()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("beneficiaryId"), criteria.getBeneficiaryId()));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("ictcBeneficiaryId"), criteria.getIctcBeneficiaryId()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("visitId"), criteria.getVisitId()));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("dateOfBirth"), criteria.getDateOfBirth()));
            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("sampleCollectionStatus"), criteria.getSampleCollectionStatus()));
            }
            if (criteria.getBatchStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("batchStatus"), criteria.getBatchStatus()));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("batchId"), criteria.getBatchId()));
            }
            if (criteria.getLabId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("labId"), criteria.getLabId()));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("labCode"), criteria.getLabCode()));
            }
            if (criteria.getLabName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("labName"), criteria.getLabName()));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("testType"), criteria.getTestType()));
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

    private Specification<ICTCTestResultView> createBasicSpecification(ICTCTestResultViewCriteria criteria) {
        Specification<ICTCTestResultView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getUid() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("uid"), criteria.getUid()));
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
            if (criteria.getInfantCode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getResultStatus() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("resultStatus"), criteria.getResultStatus()));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("hivStatus"), criteria.getHivStatus()));
            }
            if (criteria.getHivType() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("hivType"), criteria.getHivType()));
            }
            if (criteria.getSampleId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("sampleId"), criteria.getSampleId()));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("consignmentId"), criteria.getConsignmentId()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("beneficiaryId"), criteria.getBeneficiaryId()));
            }
            if (criteria.getIctcBeneficiaryId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("ictcBeneficiaryId"), criteria.getIctcBeneficiaryId()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("visitId"), criteria.getVisitId()));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("dateOfBirth"), criteria.getDateOfBirth()));
            }
            if (criteria.getSampleCollectionStatus() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("sampleCollectionStatus"), criteria.getSampleCollectionStatus()));
            }
            if (criteria.getBatchStatus() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("batchStatus"), criteria.getBatchStatus()));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("batchId"), criteria.getBatchId()));
            }
            if (criteria.getLabId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("labId"), criteria.getLabId()));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("labCode"), criteria.getLabCode()));
            }
            if (criteria.getLabName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("labName"), criteria.getLabName()));
            }
            if (criteria.getTestType() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("testType"), criteria.getTestType()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("facilityId"), criteria.getFacilityId()));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("categoryId"), criteria.getCategoryId()));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("genderId"), criteria.getGenderId()));
            }
        }
        return specification;
    }


}
