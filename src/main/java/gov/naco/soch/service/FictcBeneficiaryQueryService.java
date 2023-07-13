package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.FictcBeneficiary;
import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.FictcBeneficiaryRepository;
import gov.naco.soch.service.dto.FictcBeneficiaryCriteria;

import gov.naco.soch.service.dto.FictcBeneficiaryDTO;
import gov.naco.soch.service.mapper.FictcBeneficiaryMapper;

/**
 * Service for executing complex queries for FictcBeneficiary entities in the database.
 * The main input is a {@link FictcBeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FictcBeneficiaryDTO} or a {@link Page} of {@link FictcBeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FictcBeneficiaryQueryService {

    private final Logger log = LoggerFactory.getLogger(FictcBeneficiaryQueryService.class);

    private final FictcBeneficiaryRepository fictcBeneficiaryRepository;

    private final FictcBeneficiaryMapper fictcBeneficiaryMapper;

    public FictcBeneficiaryQueryService(FictcBeneficiaryRepository fictcBeneficiaryRepository, FictcBeneficiaryMapper fictcBeneficiaryMapper) {
        this.fictcBeneficiaryRepository = fictcBeneficiaryRepository;
        this.fictcBeneficiaryMapper = fictcBeneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link FictcBeneficiaryDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FictcBeneficiaryDTO> findByCriteria(FictcBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<FictcBeneficiary> specification = createSpecification(criteria);
        return fictcBeneficiaryMapper.toDto(fictcBeneficiaryRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link FictcBeneficiaryDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<FictcBeneficiaryDTO> findByCriteria(FictcBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<FictcBeneficiary> specification = createSpecification(criteria);
        return fictcBeneficiaryRepository.findAll(specification, page)
            .map(fictcBeneficiaryMapper::toDto);
    }

    /**
     * Function to convert FictcBeneficiaryCriteria to a {@link Specification}
     */
    private Specification<FictcBeneficiary> createSpecification(FictcBeneficiaryCriteria criteria) {
        Specification<FictcBeneficiary> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(FictcBeneficiary_.id), criteria.getId()));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(FictcBeneficiary_.isPregnant), criteria.getIsPregnant()));
            }
            if (criteria.getHivScreeningDate() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(FictcBeneficiary_.hivScreeningDate), criteria.getHivScreeningDate()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(FictcBeneficiary_.isActive), criteria.getIsActive()));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(FictcBeneficiary_.isDelete), criteria.getIsDelete()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.join(FictcBeneficiary_.beneficiary).get(Beneficiary_.id), criteria.getBeneficiaryId()));
            }
            if (criteria.getPregnancyTypeId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.join(FictcBeneficiary_.pregnancyType).get(MasterPregnancyTypeCase_.id), criteria.getPregnancyTypeId()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.join(FictcBeneficiary_.facility).get(Facility_.id), criteria.getFacilityId()));
            }
        }
        return specification;
    }


}
