package gov.naco.soch.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCBeneficiaryCounsellingView;
// for static metamodels
import gov.naco.soch.repository.ICTCBeneficiaryCounsellingViewRepository;
import gov.naco.soch.service.dto.ICTCBeneficiaryCounsellingViewCriteria;
/**
 * Service for executing complex queries for {@link ICTCBeneficiaryCounsellingView} entities in the database.
 * The main input is a {@link ICTCBeneficiaryCounsellingViewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCBeneficiaryCounsellingViewDTO} or a {@link Page} of {@link ICTCBeneficiaryCounsellingViewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCBeneficiaryCounsellingViewQueryService {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryCounsellingViewQueryService.class);

    private final ICTCBeneficiaryCounsellingViewRepository ictcBeneficiaryCounsellingViewRepository;

    public ICTCBeneficiaryCounsellingViewQueryService(ICTCBeneficiaryCounsellingViewRepository ictcBeneficiaryCounsellingViewRepository) {
        this.ictcBeneficiaryCounsellingViewRepository = ictcBeneficiaryCounsellingViewRepository;
    }

    @Transactional(readOnly = true)
    public List<ICTCBeneficiaryCounsellingView> findByCriteria(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCBeneficiaryCounsellingView> specification = createSpecification(criteria);
        return ictcBeneficiaryCounsellingViewRepository.findAll(specification);
    }


    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryCounsellingView> findByCriteria(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryCounsellingView> specification = createSpecification(criteria);
        return ictcBeneficiaryCounsellingViewRepository.findAll(specification, page);
    }
    
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryCounsellingView> findByCriteriaBasic(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryCounsellingView> specification = createBasicSearchSpecification(criteria);
        return ictcBeneficiaryCounsellingViewRepository.findAll(specification, page);
    }
    
 
    @Transactional(readOnly = true)
    public Page<ICTCBeneficiaryCounsellingView> searchByCriteria(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCBeneficiaryCounsellingView> specification = createSearchSpecification(criteria);
        return ictcBeneficiaryCounsellingViewRepository.findAll(specification, page);
    }


    @Transactional(readOnly = true)
    public long countByCriteria(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<ICTCBeneficiaryCounsellingView> specification = createSpecification(criteria);
        return ictcBeneficiaryCounsellingViewRepository.count(specification);
    }

    protected Specification<ICTCBeneficiaryCounsellingView> createSpecification(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        Specification<ICTCBeneficiaryCounsellingView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getUid() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("uid"), criteria.getUid()));
            }
            if (criteria.getPid() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("pid"), criteria.getPid()));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and((root, query, builder) ->
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
            if (criteria.getOccupationId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("occupationId"), criteria.getOccupationId()));
            }
            if (criteria.getMaritalStatusId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("maritalStatusId"), criteria.getMaritalStatusId()));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("dateOfBirth"), criteria.getDateOfBirth()));
            }
            if (criteria.getAge() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("age"), criteria.getAge()));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("mobileNumber"), criteria.getMobileNumber()));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantBreastFed"), criteria.getInfantBreastFed()));
            }
            if (criteria.getInfantMotherArtNo() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantMotherArtNo"), criteria.getInfantMotherArtNo()));
            }
            if (criteria.getInfantMotherArtId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantMotherArtId"), criteria.getInfantMotherArtId()));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("visitDate"), criteria.getVisitDate()));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isPregnant"), criteria.getIsPregnant()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("visitId"), criteria.getVisitId()));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("testType"), criteria.getTestType()));
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
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("reportReceivedDate"), criteria.getReportReceivedDate()));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("reportDeliveryDate"), criteria.getReportDeliveryDate()));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("barcode"), criteria.getBarcode()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("beneficiaryId"), criteria.getBeneficiaryId()));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantMotherFirstName"), criteria.getInfantMotherFirstName()));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("infantMotherLastName"), criteria.getInfantMotherLastName()));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("beneficiaryStatus"), criteria.getBeneficiaryStatus()));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isConsentDocumented"), criteria.getIsConsentDocumented()));
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
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDeleted"), criteria.getIsDeleted()));
            }
            if (criteria.getIsPostTestCounsellingCompleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isPostTestCounsellingCompleted"), criteria.getIsPostTestCounsellingCompleted()));
            }
        }
        return specification;
    }

    protected Specification<ICTCBeneficiaryCounsellingView> createSearchSpecification(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        Specification<ICTCBeneficiaryCounsellingView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
            }
            if (criteria.getPid() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("pid"), criteria.getPid()));
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
            if (criteria.getOccupationId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("occupationId"), criteria.getOccupationId()));
            }
            if (criteria.getMaritalStatusId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("maritalStatusId"), criteria.getMaritalStatusId()));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("dateOfBirth"), criteria.getDateOfBirth()));
            }
            if (criteria.getAge() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("age"), criteria.getAge()));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("mobileNumber"), criteria.getMobileNumber()));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantBreastFed"), criteria.getInfantBreastFed()));
            }
            if (criteria.getInfantMotherArtNo() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantMotherArtNo"), criteria.getInfantMotherArtNo()));
            }
            if (criteria.getInfantMotherArtId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantMotherArtId"), criteria.getInfantMotherArtId()));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("visitDate"), criteria.getVisitDate()));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("isPregnant"), criteria.getIsPregnant()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("visitId"), criteria.getVisitId()));
            }
            if (criteria.getTestType() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("testType"), criteria.getTestType()));
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
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("reportReceivedDate"), criteria.getReportReceivedDate()));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("reportDeliveryDate"), criteria.getReportDeliveryDate()));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("barcode"), criteria.getBarcode()));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("beneficiaryId"), criteria.getBeneficiaryId()));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantMotherFirstName"), criteria.getInfantMotherFirstName()));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantMotherLastName"), criteria.getInfantMotherLastName()));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("batchId"), criteria.getBatchId()));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("consignmentId"), criteria.getConsignmentId()));
            }
            if (criteria.getLabId() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("labId"), criteria.getLabId()));
            }
            if (criteria.getLabName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("labName"), criteria.getLabName()));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("labCode"), criteria.getLabCode()));
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
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDeleted"), criteria.getIsDeleted()));
            }
            if (criteria.getIsPostTestCounsellingCompleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isPostTestCounsellingCompleted"), criteria.getIsPostTestCounsellingCompleted()));
            }
        }
        return specification;
    }

    protected Specification<ICTCBeneficiaryCounsellingView> createBasicSearchSpecification(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        Specification<ICTCBeneficiaryCounsellingView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getPid() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("pid"), criteria.getPid()));
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
            if (criteria.getMobileNumber() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("mobileNumber"), criteria.getMobileNumber()));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantCode"), criteria.getInfantCode()));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantMotherFirstName"), criteria.getInfantMotherFirstName()));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("infantMotherLastName"), criteria.getInfantMotherLastName()));
            }
            if (criteria.getUid() != null) {
                specification = specification.or((root, query, builder) ->
                        builder.equal(root.get("uid"), criteria.getUid()));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("beneficiaryStatus"), criteria.getBeneficiaryStatus()));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isConsentDocumented"), criteria.getIsConsentDocumented()));
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
            if (criteria.getIsActive() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isActive"), criteria.getIsActive()));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isDeleted"), criteria.getIsDeleted()));
            }
            if (criteria.getIsPostTestCounsellingCompleted() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isPostTestCounsellingCompleted"), criteria.getIsPostTestCounsellingCompleted()));
            }
        }
        return specification;
    }


    
}
