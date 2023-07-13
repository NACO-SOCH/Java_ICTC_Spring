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
import gov.naco.soch.domain.ICTCBeneficiaryCounsellingView_;
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
                specification = specification.and(buildRangeSpecification(criteria.getId(), ICTCBeneficiaryCounsellingView_.id));
            }
            if (criteria.getUid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryCounsellingView_.uid));
            }
            if (criteria.getPid() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryCounsellingView_.pid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryCounsellingView_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryCounsellingView_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryCounsellingView_.lastName));
            }
            if (criteria.getOccupationId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getOccupationId(), ICTCBeneficiaryCounsellingView_.occupationId));
            }
            if (criteria.getMaritalStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getMaritalStatusId(), ICTCBeneficiaryCounsellingView_.maritalStatusId));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfBirth(), ICTCBeneficiaryCounsellingView_.dateOfBirth));
            }
            if (criteria.getAge() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAge(), ICTCBeneficiaryCounsellingView_.age));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryCounsellingView_.mobileNumber));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInfantBreastFed(), ICTCBeneficiaryCounsellingView_.infantBreastFed));
            }
            if (criteria.getInfantMotherArtNo() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantMotherArtNo(), ICTCBeneficiaryCounsellingView_.infantMotherArtNo));
            }
            if (criteria.getInfantMotherArtId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getInfantMotherArtId(), ICTCBeneficiaryCounsellingView_.infantMotherArtId));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiaryCounsellingView_.infantCode));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitDate(), ICTCBeneficiaryCounsellingView_.visitDate));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.and(buildSpecification(criteria.getIsPregnant(), ICTCBeneficiaryCounsellingView_.isPregnant));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getVisitId(), ICTCBeneficiaryCounsellingView_.visitId));
            }
            if (criteria.getTestType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTestType(), ICTCBeneficiaryCounsellingView_.testType));
            }
            if (criteria.getResultStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getResultStatus(), ICTCBeneficiaryCounsellingView_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivStatus(), ICTCBeneficiaryCounsellingView_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getHivType(), ICTCBeneficiaryCounsellingView_.hivType));
            }
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportReceivedDate(), ICTCBeneficiaryCounsellingView_.reportReceivedDate));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportDeliveryDate(), ICTCBeneficiaryCounsellingView_.reportDeliveryDate));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBarcode(), ICTCBeneficiaryCounsellingView_.barcode));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCBeneficiaryCounsellingView_.beneficiaryId));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantMotherFirstName(), ICTCBeneficiaryCounsellingView_.infantMotherFirstName));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getInfantMotherLastName(), ICTCBeneficiaryCounsellingView_.infantMotherLastName));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryCounsellingView_.beneficiaryStatus));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiaryCounsellingView_.isConsentDocumented));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryCounsellingView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryCounsellingView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryCounsellingView_.genderId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiaryCounsellingView_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiaryCounsellingView_.isDeleted));
            }
            if (criteria.getIsPostTestCounsellingCompleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsPostTestCounsellingCompleted(), ICTCBeneficiaryCounsellingView_.isPostTestCounsellingCompleted));
            }
        }
        return specification;
    }

    protected Specification<ICTCBeneficiaryCounsellingView> createSearchSpecification(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        Specification<ICTCBeneficiaryCounsellingView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getId(), ICTCBeneficiaryCounsellingView_.id));
            }
            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryCounsellingView_.pid));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryCounsellingView_.uid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryCounsellingView_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryCounsellingView_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryCounsellingView_.lastName));
            }
            if (criteria.getOccupationId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getOccupationId(), ICTCBeneficiaryCounsellingView_.occupationId));
            }
            if (criteria.getMaritalStatusId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getMaritalStatusId(), ICTCBeneficiaryCounsellingView_.maritalStatusId));
            }
            if (criteria.getDateOfBirth() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getDateOfBirth(), ICTCBeneficiaryCounsellingView_.dateOfBirth));
            }
            if (criteria.getAge() != null) {
                specification = specification.or(buildStringSpecification(criteria.getAge(), ICTCBeneficiaryCounsellingView_.age));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryCounsellingView_.mobileNumber));
            }
            if (criteria.getInfantBreastFed() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getInfantBreastFed(), ICTCBeneficiaryCounsellingView_.infantBreastFed));
            }
            if (criteria.getInfantMotherArtNo() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherArtNo(), ICTCBeneficiaryCounsellingView_.infantMotherArtNo));
            }
            if (criteria.getInfantMotherArtId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getInfantMotherArtId(), ICTCBeneficiaryCounsellingView_.infantMotherArtId));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiaryCounsellingView_.infantCode));
            }
            if (criteria.getVisitDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitDate(), ICTCBeneficiaryCounsellingView_.visitDate));
            }
            if (criteria.getIsPregnant() != null) {
                specification = specification.or(buildSpecification(criteria.getIsPregnant(), ICTCBeneficiaryCounsellingView_.isPregnant));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getVisitId(), ICTCBeneficiaryCounsellingView_.visitId));
            }
            if (criteria.getTestType() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getTestType(), ICTCBeneficiaryCounsellingView_.testType));
            }
            if (criteria.getResultStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getResultStatus(), ICTCBeneficiaryCounsellingView_.resultStatus));
            }
            if (criteria.getHivStatus() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getHivStatus(), ICTCBeneficiaryCounsellingView_.hivStatus));
            }
            if (criteria.getHivType() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getHivType(), ICTCBeneficiaryCounsellingView_.hivType));
            }
            if (criteria.getReportReceivedDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getReportReceivedDate(), ICTCBeneficiaryCounsellingView_.reportReceivedDate));
            }
            if (criteria.getReportDeliveryDate() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getReportDeliveryDate(), ICTCBeneficiaryCounsellingView_.reportDeliveryDate));
            }
            if (criteria.getBarcode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getBarcode(), ICTCBeneficiaryCounsellingView_.barcode));
            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBeneficiaryId(), ICTCBeneficiaryCounsellingView_.beneficiaryId));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherFirstName(), ICTCBeneficiaryCounsellingView_.infantMotherFirstName));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherLastName(), ICTCBeneficiaryCounsellingView_.infantMotherLastName));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryCounsellingView_.beneficiaryStatus));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiaryCounsellingView_.isConsentDocumented));
            }
            if (criteria.getBatchId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getBatchId(), ICTCBeneficiaryCounsellingView_.batchId));
            }
            if (criteria.getConsignmentId() != null) {
                specification = specification.or(buildStringSpecification(criteria.getConsignmentId(), ICTCBeneficiaryCounsellingView_.consignmentId));
            }
            if (criteria.getLabId() != null) {
                specification = specification.or(buildRangeSpecification(criteria.getLabId(), ICTCBeneficiaryCounsellingView_.labId));
            }
            if (criteria.getLabName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLabName(), ICTCBeneficiaryCounsellingView_.labName));
            }
            if (criteria.getLabCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLabCode(), ICTCBeneficiaryCounsellingView_.labCode));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryCounsellingView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryCounsellingView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryCounsellingView_.genderId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiaryCounsellingView_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiaryCounsellingView_.isDeleted));
            }
            if (criteria.getIsPostTestCounsellingCompleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsPostTestCounsellingCompleted(), ICTCBeneficiaryCounsellingView_.isPostTestCounsellingCompleted));
            }
        }
        return specification;
    }

    protected Specification<ICTCBeneficiaryCounsellingView> createBasicSearchSpecification(ICTCBeneficiaryCounsellingViewCriteria criteria) {
        Specification<ICTCBeneficiaryCounsellingView> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getPid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getPid(), ICTCBeneficiaryCounsellingView_.pid));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getFirstName(), ICTCBeneficiaryCounsellingView_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMiddleName(), ICTCBeneficiaryCounsellingView_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getLastName(), ICTCBeneficiaryCounsellingView_.lastName));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildStringSpecification(criteria.getMobileNumber(), ICTCBeneficiaryCounsellingView_.mobileNumber));
            }
            if (criteria.getInfantCode() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantCode(), ICTCBeneficiaryCounsellingView_.infantCode));
            }
            if (criteria.getInfantMotherFirstName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherFirstName(), ICTCBeneficiaryCounsellingView_.infantMotherFirstName));
            }
            if (criteria.getInfantMotherLastName() != null) {
                specification = specification.or(buildStringSpecification(criteria.getInfantMotherLastName(), ICTCBeneficiaryCounsellingView_.infantMotherLastName));
            }
            if (criteria.getUid() != null) {
                specification = specification.or(buildStringSpecification(criteria.getUid(), ICTCBeneficiaryCounsellingView_.uid));
            }
            if (criteria.getBeneficiaryStatus() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBeneficiaryStatus(), ICTCBeneficiaryCounsellingView_.beneficiaryStatus));
            }
            if (criteria.getIsConsentDocumented() != null) {
                specification = specification.and(buildSpecification(criteria.getIsConsentDocumented(), ICTCBeneficiaryCounsellingView_.isConsentDocumented));
            }
            if (criteria.getFacilityId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFacilityId(), ICTCBeneficiaryCounsellingView_.facilityId));
            }
            if (criteria.getCategoryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCategoryId(), ICTCBeneficiaryCounsellingView_.categoryId));
            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getGenderId(), ICTCBeneficiaryCounsellingView_.genderId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), ICTCBeneficiaryCounsellingView_.isActive));
            }
            if (criteria.getIsDeleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDeleted(), ICTCBeneficiaryCounsellingView_.isDeleted));
            }
            if (criteria.getIsPostTestCounsellingCompleted() != null) {
                specification = specification.and(buildSpecification(criteria.getIsPostTestCounsellingCompleted(), ICTCBeneficiaryCounsellingView_.isPostTestCounsellingCompleted));
            }
        }
        return specification;
    }

    
}
