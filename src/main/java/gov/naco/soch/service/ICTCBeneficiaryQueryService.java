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

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.repository.ICTCBeneficiaryRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;

/**
 * Service for executing complex queries for {@link ICTCBeneficiary} entities in the database.
 * The main input is a {@link ICTCBeneficiaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCBeneficiaryDTO} or a {@link Page} of {@link ICTCBeneficiaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCBeneficiaryQueryService  {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryQueryService.class);

    private final ICTCBeneficiaryRepository iCTCBeneficiaryRepository;

    private final ICTCBeneficiaryMapper iCTCBeneficiaryMapper;

    public ICTCBeneficiaryQueryService(ICTCBeneficiaryRepository iCTCBeneficiaryRepository, ICTCBeneficiaryMapper iCTCBeneficiaryMapper) {
        this.iCTCBeneficiaryRepository = iCTCBeneficiaryRepository;
        this.iCTCBeneficiaryMapper = iCTCBeneficiaryMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBeneficiaryDTO> findByCriteria(ICTCBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryMapper.toDto(iCTCBeneficiaryRepository.findAll(specification));
    }
    
    
    /**
     * Return a {@link List} of {@link ICTCBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCBeneficiary> findList(ICTCBeneficiaryCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.findAll(specification);
    }
    

    /**
     * Return a {@link Page} of {@link ICTCBeneficiaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryDTO> findByCriteria(ICTCBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.findAll(specification, page)
            .map(iCTCBeneficiaryMapper::toDto);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCBeneficiary} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiary> getPageByCriteria(ICTCBeneficiaryCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCBeneficiaryCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCBeneficiary> specification = createSpecification(criteria);
        return iCTCBeneficiaryRepository.count(specification);
    }

    protected Specification<ICTCBeneficiary> createSpecification(ICTCBeneficiaryCriteria criteria) {
        Specification<ICTCBeneficiary> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getPid() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("pid"), criteria.getPid()));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isConsentDocumented"), criteria.getIsConsentDocumented()));
            }
            if (criteria.getReferredBy() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("referredBy"), criteria.getReferredBy()));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getRegistrationDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("registrationDate"), criteria.getRegistrationDate()));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDeleted"), criteria.getIsDeleted()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("beneficiary", JoinType.LEFT).get("id"), criteria.getBeneficiaryId()));
            }
            if (criteria.getBeneficiaryCategoryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("beneficiary", JoinType.LEFT).get("categoryId"), criteria.getBeneficiaryCategoryId()));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("facility", JoinType.LEFT).get("id"), criteria.getFacilityId()));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("beneficiaryStatus"), criteria.getBeneficiaryStatus()));
            }
        }
        return specification;
    }
}
