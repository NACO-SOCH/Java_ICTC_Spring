package gov.naco.soch.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsCriteria;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;
import gov.naco.soch.service.mapper.BeneficiaryFamilyDetailsMapper;

/**
 * Service for executing complex queries for {@link BeneficiaryFamilyDetails} entities in the database.
 * The main input is a {@link BeneficiaryFamilyDetailsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BeneficiaryFamilyDetailsDTO} or a {@link Page} of {@link BeneficiaryFamilyDetailsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BeneficiaryFamilyDetailsQueryService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryFamilyDetailsQueryService.class);

    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;

    private final BeneficiaryFamilyDetailsMapper beneficiaryFamilyDetailsMapper;

    public BeneficiaryFamilyDetailsQueryService(BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository, BeneficiaryFamilyDetailsMapper beneficiaryFamilyDetailsMapper) {
        this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
        this.beneficiaryFamilyDetailsMapper = beneficiaryFamilyDetailsMapper;
    }

    /**
     * Return a {@link List} of {@link BeneficiaryFamilyDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BeneficiaryFamilyDetailsDTO> findByCriteria(BeneficiaryFamilyDetailsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<BeneficiaryFamilyDetails> specification = createSpecification(criteria);
        return beneficiaryFamilyDetailsMapper.toDto(beneficiaryFamilyDetailsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BeneficiaryFamilyDetailsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BeneficiaryFamilyDetailsDTO> findByCriteria(BeneficiaryFamilyDetailsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BeneficiaryFamilyDetails> specification = createSpecification(criteria);
        return beneficiaryFamilyDetailsRepository.findAll(specification, page)
            .map(beneficiaryFamilyDetailsMapper::toDto);
    }
    
    @Transactional(readOnly = true)
    public List<BeneficiaryFamilyDetails> findListByCriteria(BeneficiaryFamilyDetailsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<BeneficiaryFamilyDetails> specification = createSpecification(criteria);
        List<BeneficiaryFamilyDetails> familyDetails = beneficiaryFamilyDetailsRepository.findAll(specification);
        return familyDetails;
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BeneficiaryFamilyDetailsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<BeneficiaryFamilyDetails> specification = createSpecification(criteria);
        return beneficiaryFamilyDetailsRepository.count(specification);
    }

    /**
     * Function to convert {@link BeneficiaryFamilyDetailsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    private Specification<BeneficiaryFamilyDetails> createSpecification(BeneficiaryFamilyDetailsCriteria criteria) {
        Specification<BeneficiaryFamilyDetails> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getFamilyUid() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("familyUid"), criteria.getFamilyUid()));
            }
            if (criteria.getRelationshipId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("relationshipId"), criteria.getRelationshipId()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("beneficiaryId"), criteria.getBeneficiaryId()));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("firstName"), criteria.getFirstName()));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("middleName"), criteria.getMiddleName()));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("lastName"), criteria.getLastName()));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("genderId"), criteria.getGenderId()));
            }
            if (criteria.getAgeYears() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("ageYears"), criteria.getAgeYears()));
            }
            if (criteria.getAgeMonths() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("ageMonths"), criteria.getAgeMonths()));
            }
            if (criteria.getIsAlive() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("isAlive"), criteria.getIsAlive()));
            }
            if (criteria.getHivStatusId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("hivStatusId"), criteria.getHivStatusId()));
            }
            if (criteria.getOnArt() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("onArt"), criteria.getOnArt()));
            }
            if (criteria.getIsBeneficiary() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("isBeneficiary"), criteria.getIsBeneficiary()));
            }
            if (criteria.getMemberBeneficiaryId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("memberBeneficiaryId"), criteria.getMemberBeneficiaryId()));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("createdBy"), criteria.getCreatedBy()));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("createdTime"), criteria.getCreatedTime()));
            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("modifiedBy"), criteria.getModifiedBy()));
            }
            if (criteria.getModifiedTime() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("modifiedTime"), criteria.getModifiedTime()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("isDelete"), criteria.getIsDelete()));
            }
        }
        return specification;
    }

}
