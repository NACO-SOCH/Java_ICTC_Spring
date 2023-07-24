package gov.naco.soch.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.Referrals;
import gov.naco.soch.repository.ReferralsRepository;
import gov.naco.soch.service.dto.ReferralsCriteria;
import gov.naco.soch.service.dto.ReferralsDTO;
import gov.naco.soch.service.mapper.ReferralsMapper;

/**
 * Service for executing complex queries for {@link Referrals} entities in the database.
 * The main input is a {@link ReferralsCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ReferralsDTO} or a {@link Page} of {@link ReferralsDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ReferralsQueryService {

    private final Logger log = LoggerFactory.getLogger(ReferralsQueryService.class);

    private final ReferralsRepository referralsRepository;

    private final ReferralsMapper referralsMapper;

    public ReferralsQueryService(ReferralsRepository referralsRepository, ReferralsMapper referralsMapper) {
        this.referralsRepository = referralsRepository;
        this.referralsMapper = referralsMapper;
    }

    /**
     * Return a {@link List} of {@link ReferralsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ReferralsDTO> findByCriteria(ReferralsCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Referrals> specification = createSpecification(criteria);
        return referralsMapper.toDto(referralsRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ReferralsDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Referrals> findByCriteria(ReferralsCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Referrals> specification = createSpecification(criteria);
        return referralsRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ReferralsCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Referrals> specification = createSpecification(criteria);
        return referralsRepository.count(specification);
    }

    /**
     * Function to convert {@link ReferralsCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */

    protected Specification<Referrals> createSpecification(ReferralsCriteria criteria) {
        Specification<Referrals> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getSourceFacilityType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("sourceFacilityType"), criteria.getSourceFacilityType()));
            }
            if (criteria.getReferralStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("referralStatus"), criteria.getReferralStatus()));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("hivStatus"), criteria.getHivStatus()));
            }
            if (criteria.getCategory() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("category"), criteria.getCategory()));
            }
            if (criteria.getRemarks() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("remarks"), criteria.getRemarks()));
            }
            if (criteria.getInitiationDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("initiationDate"), criteria.getInitiationDate()));
            }
            if (criteria.getDestinationFacilityType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("destinationFacilityType"), criteria.getDestinationFacilityType()));
            }
            if (criteria.getDsrcCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("dsrcCode"), criteria.getDsrcCode()));
            }
            if (criteria.getTiCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("tiCode"), criteria.getTiCode()));
            }
            if (criteria.getArtCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("artCode"), criteria.getArtCode()));
            }
            if (criteria.getOstCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("ostCode"), criteria.getOstCode()));
            }
            if (criteria.getPidCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("pidCode"), criteria.getPidCode()));
            }
            if (criteria.getReportingDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("reportingDate"), criteria.getReportingDate()));
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
                        builder.equal(root.join("beneficiary").get("id"), criteria.getBeneficiaryId()));
            }
            if (criteria.getSourceFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("sourceFacility").get("id"), criteria.getSourceFacilityId()));
            }
            if (criteria.getDestinationFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("destinationFacility").get("id"), criteria.getDestinationFacilityId()));
            }
        }
        return specification;
    }

}
