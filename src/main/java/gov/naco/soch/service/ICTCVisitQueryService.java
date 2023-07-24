package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.repository.ICTCVisitRepository;
import gov.naco.soch.service.dto.ICTCVisitCriteria;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.mapper.ICTCVisitMapper;

/**
 * Service for executing complex queries for {@link ICTCVisit} entities in the database.
 * The main input is a {@link ICTCVisitCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCVisitDTO} or a {@link Page} of {@link ICTCVisitDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCVisitQueryService {

    private final Logger log = LoggerFactory.getLogger(ICTCVisitQueryService.class);

    private final ICTCVisitRepository iCTCVisitRepository;

    private final ICTCVisitMapper iCTCVisitMapper;

    public ICTCVisitQueryService(ICTCVisitRepository iCTCVisitRepository, ICTCVisitMapper iCTCVisitMapper) {
        this.iCTCVisitRepository = iCTCVisitRepository;
        this.iCTCVisitMapper = iCTCVisitMapper;
    }

    /**
     * Return a {@link List} of {@link ICTCVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCVisitDTO> findByCriteria(ICTCVisitCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCVisit> specification = createSpecification(criteria);
        return iCTCVisitMapper.toDto(iCTCVisitRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCVisitDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCVisitDTO> findByCriteria(ICTCVisitCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCVisit> specification = createSpecification(criteria);
        return iCTCVisitRepository.findAll(specification, page)
            .map(iCTCVisitMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ICTCVisitCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCVisit> specification = createSpecification(criteria);
        return iCTCVisitRepository.count(specification);
    }

    /**
     * Function to convert {@link ICTCVisitCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */

    protected Specification<ICTCVisit> createSpecification(ICTCVisitCriteria criteria) {
        Specification<ICTCVisit> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("visitDate"), criteria.getVisitDate()));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("beneficiaryStatus"), criteria.getBeneficiaryStatus()));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isPregnant"), criteria.getIsPregnant()));
            }
            if (criteria.getPregnancyType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("pregnancyType"), criteria.getPregnancyType()));
            }
            if (criteria.getHasTbSymptoms() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("hasTbSymptoms"), criteria.getHasTbSymptoms()));
            }
            if (criteria.getHasStiRtiSymptoms() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("hasStiRtiSymptoms"), criteria.getHasStiRtiSymptoms()));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantBreastFed"), criteria.getInfantBreastFed()));
            }
            if (criteria.getArvProphylaxis() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("arvProphylaxis"), criteria.getArvProphylaxis()));
            }
            if (criteria.getCptInitiationDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("cptInitiationDate"), criteria.getCptInitiationDate()));
            }
            if (criteria.getTransmissionRoute() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("transmissionRoute"), criteria.getTransmissionRoute()));
            }
            if (criteria.getPregnancyLmpDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("pregnancyLmpDate"), criteria.getPregnancyLmpDate()));
            }
            if (criteria.getMonthOfPregnancy() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("monthOfPregnancy"), criteria.getMonthOfPregnancy()));
            }
            if (criteria.getExpectedDeliveryDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("expectedDeliveryDate"), criteria.getExpectedDeliveryDate()));
            }
            if (criteria.getDeliveryOutcome() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("deliveryOutcome"), criteria.getDeliveryOutcome()));
            }
            if (criteria.getDeliveryDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("deliveryDate"), criteria.getDeliveryDate()));
            }
            if (criteria.getGravida() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("gravida"), criteria.getGravida()));
            }
            if (criteria.getIsRPQCaptured() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isRPQCaptured"), criteria.getIsRPQCaptured()));
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
            if (criteria.getFacilityId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("facility").get("id"), criteria.getFacilityId()));
            }
        }
        return specification;
    }

}
