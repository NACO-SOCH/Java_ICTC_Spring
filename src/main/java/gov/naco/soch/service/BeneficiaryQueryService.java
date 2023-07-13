package gov.naco.soch.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.*;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.service.dto.BeneficiaryCriteria;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.mapper.BeneficiaryMapper;

/**
 * Service for executing complex queries for {@link Beneficiary} entities in the database.
 * The main input is a {@link BeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BeneficiaryDTO} or a {@link Page} of {@link BeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BeneficiaryQueryService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryQueryService.class);

    private final BeneficiaryRepository beneficiaryRepository;

    private final BeneficiaryMapper beneficiaryMapper;

    public BeneficiaryQueryService(BeneficiaryRepository beneficiaryRepository, BeneficiaryMapper beneficiaryMapper) {
        this.beneficiaryRepository = beneficiaryRepository;
        this.beneficiaryMapper = beneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link BeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BeneficiaryDTO> findByCriteria(BeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryMapper.toDto(beneficiaryRepository.findAll(specification));
    }
    
    @Transactional(readOnly = true)
    public List<BeneficiaryDTO> findByCriteriaBasic(BeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecificationBasic(criteria);
        return beneficiaryMapper.toDto(beneficiaryRepository.findAll(specification));
    }
    
    
    /**
     * Return a {@link List} of {@link BeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Beneficiary> findList(BeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link BeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BeneficiaryDTO> findByCriteria(BeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryRepository.findAll(specification, page)
            .map(beneficiaryMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BeneficiaryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Beneficiary> specification = createSpecification(criteria);
        return beneficiaryRepository.count(specification);
    }

    /**
     * Function to convert {@link BeneficiaryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Beneficiary> createSpecification(BeneficiaryCriteria criteria) {
        Specification<Beneficiary> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.id), criteria.getId()));
            }
            if (criteria.getUid() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.uid), criteria.getUid()));
            }
            if (criteria.getAadharNumber() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.aadharNumber), criteria.getAadharNumber()));
            }
            if (criteria.getAge() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.age), criteria.getAge()));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.dateOfBirth), criteria.getDateOfBirth()));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.firstName), criteria.getFirstName()));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.lastName), criteria.getLastName()));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.middleName), criteria.getMiddleName()));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.mobileNumber), criteria.getMobileNumber()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.isActive), criteria.getIsActive()));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.isDelete), criteria.getIsDelete()));
            }
            if (criteria.getAddressId() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.join(Beneficiary_.address, JoinType.LEFT).get(Address_.id), criteria.getAddressId()));
            }
        }
        return specification;
    }

    protected Specification<Beneficiary> createSpecificationBasic(BeneficiaryCriteria criteria) {
        Specification<Beneficiary> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getUid() != null) {
                specification = specification.or((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.uid), criteria.getUid()));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.firstName), criteria.getFirstName()));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.lastName), criteria.getLastName()));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.middleName), criteria.getMiddleName()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.isActive), criteria.getIsActive()));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get(Beneficiary_.isDelete), criteria.getIsDelete()));
            }
        }
        return specification;
    }

}
