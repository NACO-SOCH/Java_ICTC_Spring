package gov.naco.soch.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.BeneficiaryReferral;
import gov.naco.soch.domain.BeneficiaryReferral_;
import gov.naco.soch.domain.Beneficiary_;
import gov.naco.soch.domain.Facility_;
import gov.naco.soch.domain.ICTCBeneficiary_;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.service.dto.BeneficiaryReferralCriteria;
import gov.naco.soch.service.dto.BeneficiaryReferralDTO;
import gov.naco.soch.service.mapper.BeneficiaryReferralMapper;

/**
 * Service for executing complex queries for {@link BeneficiaryReferral} entities in the database.
 * The main input is a {@link BeneficiaryReferralCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BeneficiaryReferralDTO} or a {@link Page} of {@link BeneficiaryReferralDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BeneficiaryReferralQueryService {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryReferralQueryService.class);

    private final BeneficiaryReferralRepository beneficiaryReferralRepository;

    private final BeneficiaryReferralMapper beneficiaryReferralMapper;

    public BeneficiaryReferralQueryService(BeneficiaryReferralRepository beneficiaryReferralRepository, BeneficiaryReferralMapper beneficiaryReferralMapper) {
        this.beneficiaryReferralRepository = beneficiaryReferralRepository;
        this.beneficiaryReferralMapper = beneficiaryReferralMapper;
    }

    /**
     * Return a {@link List} of {@link BeneficiaryReferralDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BeneficiaryReferralDTO> findByCriteria(BeneficiaryReferralCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<BeneficiaryReferral> specification = createSpecification(criteria);
        return beneficiaryReferralMapper.toDto(beneficiaryReferralRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BeneficiaryReferralDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BeneficiaryReferral> findByCriteria(BeneficiaryReferralCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BeneficiaryReferral> specification = createSpecification(criteria);
        return beneficiaryReferralRepository.findAll(specification, page);
    }
    
	@Transactional(readOnly = true)
	public Page<BeneficiaryReferral> findByCriteriaInward(BeneficiaryReferralCriteria criteria, Pageable page) {
		log.debug("find by criteria : {}, page: {}", criteria, page);
		Specification<BeneficiaryReferral> specification = null;
		if(criteria.getCurrentFacId() != null) {
			specification = generateSpecificationForInwardReferralForSearch(criteria.getCurrentFacId().getEquals()).and(createAdvancedSpecificationForInward(criteria));
		} else {
			specification = createAdvancedSpecification(criteria);
		}
		return beneficiaryReferralRepository.findAll(specification, page);
	}
    
    @Transactional(readOnly = true)
    public Page<BeneficiaryReferral> find(BeneficiaryReferralCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BeneficiaryReferral> specification = createBasicSpecification(criteria);
        return beneficiaryReferralRepository.findAll(specification, page);
    }

    @Transactional(readOnly = true)
    public Page<BeneficiaryReferral> findOtherPendingResultsAdvanced(BeneficiaryReferralCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BeneficiaryReferral> specification = createOtherPendingSpecification().and(createAdvancedSpecificationOtherPending(criteria));
        return beneficiaryReferralRepository.findAll(specification, page);
    }
    
    @Transactional(readOnly = true)
    public Page<BeneficiaryReferral> findOtherPendingResultsBasic(BeneficiaryReferralCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<BeneficiaryReferral> specification = createOtherPendingSpecification().and(createBasicSpecificationOtherPending(criteria));
        return beneficiaryReferralRepository.findAll(specification, page);
    }

    
    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BeneficiaryReferralCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<BeneficiaryReferral> specification = createSpecification(criteria);
        return beneficiaryReferralRepository.count(specification);
    }

    /**
     * Function to convert {@link BeneficiaryReferralCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<BeneficiaryReferral> createSpecification(BeneficiaryReferralCriteria criteria) {
        Specification<BeneficiaryReferral> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), BeneficiaryReferral_.id));
            }
            if (criteria.getTiBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTiBeneficiaryId(), BeneficiaryReferral_.tiBeneficiaryId));
            }
            if (criteria.getTiBenScrId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTiBenScrId(), BeneficiaryReferral_.tiBenScrId));
            }
            if (criteria.getDateOfVisit() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfVisit(), BeneficiaryReferral_.dateOfVisit));
            }
//            if (criteria.getHivStatus() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getHivStatus(), BeneficiaryReferral_.hivStatus));
//            }
            if (criteria.getReferDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferDate(), BeneficiaryReferral_.referDate));
            }
            if (criteria.getReferralReason() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralReason(), BeneficiaryReferral_.referralReason));
            }
            if (criteria.getReferredBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferredBy(), BeneficiaryReferral_.referredBy));
            }
//            if (criteria.getDateOfHivTest() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getDateOfHivTest(), BeneficiaryReferral_.dateOfHivTest));
//            }
//            if (criteria.getTypeOfHiv() != null) {
//                specification = specification.and(buildStringSpecification(criteria.getTypeOfHiv(), BeneficiaryReferral_.typeOfHiv));
//            }
            if (criteria.getReferralType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralType(), BeneficiaryReferral_.referralType));
            }
            if (criteria.getReferralStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), BeneficiaryReferral_.isActive));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), BeneficiaryReferral_.createdBy));
            }
//            if (criteria.getCreatedTime() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), BeneficiaryReferral_.createdTime));
//            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), BeneficiaryReferral_.modifiedBy));
            }
//            if (criteria.getModifiedTime() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), BeneficiaryReferral_.modifiedTime));
//            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
            } 
//            if (criteria.getGender() != null) {
//                specification = specification.and(buildSpecification(criteria.getGender(),
//                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.gender)));
//            }
            
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildSpecification(criteria.getGenderId(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.genderId)));
            }
            
            if (criteria.getReferralFacilityName() != null) {
                specification = specification.and(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.and(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getIctcBenStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getIctcBenStatus(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.ictcBeneficiary).get(ICTCBeneficiary_.beneficiaryStatus)));
            }
            if (criteria.getReferedTo() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedTo(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.id)));
            }
            
            if (criteria.getReferralTypeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralTypeId(), BeneficiaryReferral_.referralTypeId));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
            	 specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                         root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }
    
    protected Specification<BeneficiaryReferral> createAdvancedSpecification(BeneficiaryReferralCriteria criteria) {
        Specification<BeneficiaryReferral> specification = Specification.where(null);
        if (criteria != null) {
        	if (criteria.getUid() != null) {
                specification = specification.and(buildSpecification(criteria.getUid(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), BeneficiaryReferral_.id));
            }
            if (criteria.getTiBeneficiaryId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTiBeneficiaryId(), BeneficiaryReferral_.tiBeneficiaryId));
            }
            if (criteria.getTiBenScrId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTiBenScrId(), BeneficiaryReferral_.tiBenScrId));
            }
            if (criteria.getDateOfVisit() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateOfVisit(), BeneficiaryReferral_.dateOfVisit));
            }
            if (criteria.getReferDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferDate(), BeneficiaryReferral_.referDate));
            }
            if (criteria.getReferralReason() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralReason(), BeneficiaryReferral_.referralReason));
            }
            if (criteria.getReferredBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferredBy(), BeneficiaryReferral_.referredBy));
            }
            if (criteria.getReferralType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReferralType(), BeneficiaryReferral_.referralType));
            }
            if (criteria.getReferralStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
            }
            if (criteria.getIsActive() != null) {
                specification = specification.and(buildSpecification(criteria.getIsActive(), BeneficiaryReferral_.isActive));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
            }
            if (criteria.getCreatedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), BeneficiaryReferral_.createdBy));
            }
//            if (criteria.getCreatedTime() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), BeneficiaryReferral_.createdTime));
//            }
            if (criteria.getModifiedBy() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), BeneficiaryReferral_.modifiedBy));
            }
//            if (criteria.getModifiedTime() != null) {
//                specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), BeneficiaryReferral_.modifiedTime));
//            }
            if (criteria.getBeneficiaryId() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
            } 
//            if (criteria.getGender() != null) {
//                specification = specification.and(buildSpecification(criteria.getGender(),
//                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.gender)));
//            }
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildSpecification(criteria.getGenderId(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.genderId)));
            }
            
            if (criteria.getReferralFacilityName() != null) {
                specification = specification.and(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.or(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferedTo() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedTo(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferralTypeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralTypeId(), BeneficiaryReferral_.referralTypeId));
            }
            if (criteria.getFacilityTypeId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityTypeId(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
           	 	specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                        root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }
    
    protected Specification<BeneficiaryReferral> createBasicSpecification(BeneficiaryReferralCriteria criteria) {
        Specification<BeneficiaryReferral> specification = Specification.where(null);
        if (criteria != null) {
        	if (criteria.getUid() != null) {
                specification = specification.or(buildSpecification(criteria.getUid(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
            }
            if (criteria.getReferralFacilityName() != null) {
                specification = specification.or(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.or(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.or(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.or(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getReferedTo() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedTo(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getFacilityTypeId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityTypeId(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
            if (criteria.getReferralTypeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralTypeId(), BeneficiaryReferral_.referralTypeId));
            }
            if (criteria.getReferDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferDate(), BeneficiaryReferral_.referDate));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getIctcBenStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getIctcBenStatus(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.ictcBeneficiary).get(ICTCBeneficiary_.beneficiaryStatus)));
            }
            if (criteria.getReferralStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
            }
            if (criteria.getAcceptedFacility() != null) {
                specification = specification.or(buildSpecification(criteria.getAcceptedFacility(),
                    root -> root.join(BeneficiaryReferral_.acceptedFacility, JoinType.LEFT).get(Facility_.id)));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
           	 	specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                        root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }

    protected Specification<BeneficiaryReferral> createBasicSpecificationOtherPending(BeneficiaryReferralCriteria criteria) {
        Specification<BeneficiaryReferral> specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getReferralFacilityName() != null) {
                specification = specification.or(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.or(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.or(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.or(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getReferedTo() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedTo(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferralStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
           	 	specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                        root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }
    protected Specification<BeneficiaryReferral> createAdvancedSpecificationOtherPending(BeneficiaryReferralCriteria criteria) {
        Specification<BeneficiaryReferral> specification = Specification.where(null);
        if (criteria != null) {

            if (criteria.getReferralFacilityName() != null) {
                specification = specification.and(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.and(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.and(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getReferedTo() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedTo(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferralStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
           	 	specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                        root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }
    
    protected Specification<BeneficiaryReferral> createOtherPendingSpecification(){
    	IntegerFilter typeFilter = new IntegerFilter();
    	LocalDateFilter dateFilter = new LocalDateFilter();
    	typeFilter.setEquals(4);
    	dateFilter.setLessThan(LocalDate.now().minusDays(60));
    	Specification<BeneficiaryReferral> rntcp = buildRangeSpecification(typeFilter, BeneficiaryReferral_.referralTypeId).and(buildRangeSpecification(dateFilter, BeneficiaryReferral_.referDate));
    	typeFilter.setEquals(3);
    	dateFilter.setLessThan(LocalDate.now().minusDays(7));
    	Specification<BeneficiaryReferral> dsrc = buildRangeSpecification(typeFilter, BeneficiaryReferral_.referralTypeId).and(buildRangeSpecification(dateFilter, BeneficiaryReferral_.referDate));
    	typeFilter.setEquals(2);
    	dateFilter.setLessThan(LocalDate.now().minusDays(7));
    	Specification<BeneficiaryReferral> ti = buildRangeSpecification(typeFilter, BeneficiaryReferral_.referralTypeId).and(buildRangeSpecification(dateFilter, BeneficiaryReferral_.referDate));
    	return rntcp.or(dsrc).or(ti);
    }
    protected Specification<BeneficiaryReferral> createOtherRefferedSpecification(){
    	IntegerFilter typeFilter = new IntegerFilter();
    	LocalDateFilter dateFilter = new LocalDateFilter();
    	typeFilter.setEquals(4);
    	dateFilter.setGreaterThanOrEqual(LocalDate.now().minusDays(60));
    	Specification<BeneficiaryReferral> rntcp = buildRangeSpecification(typeFilter, BeneficiaryReferral_.referralTypeId).and(buildRangeSpecification(dateFilter, BeneficiaryReferral_.referDate));
    	typeFilter.setEquals(3);
    	dateFilter.setGreaterThanOrEqual(LocalDate.now().minusDays(7));
    	Specification<BeneficiaryReferral> dsrc = buildRangeSpecification(typeFilter, BeneficiaryReferral_.referralTypeId).and(buildRangeSpecification(dateFilter, BeneficiaryReferral_.referDate));
    	typeFilter.setEquals(2);
    	dateFilter.setGreaterThanOrEqual(LocalDate.now().minusDays(7));
    	Specification<BeneficiaryReferral> ti = buildRangeSpecification(typeFilter, BeneficiaryReferral_.referralTypeId).and(buildRangeSpecification(dateFilter, BeneficiaryReferral_.referDate));
    	return rntcp.or(dsrc).or(ti);
    }

	@Transactional(readOnly = true)
	public Page<BeneficiaryReferral> findReferredBasic(BeneficiaryReferralCriteria criteria, Pageable page) {
		log.debug("find by criteria referred basic: {}, page: {}", criteria, page);
		final Specification<BeneficiaryReferral> specification = createOtherRefferedSpecification()
				.and(createBasicSpecification(criteria));
		return beneficiaryReferralRepository.findAll(specification, page);
	}

	@Transactional(readOnly = true)
	public Page<BeneficiaryReferral> findReferredAdvanced(BeneficiaryReferralCriteria criteria, Pageable page) {
		log.debug("find by criteria referred advanced: {}, page: {}", criteria, page);
		final Specification<BeneficiaryReferral> specification = createOtherRefferedSpecification()
				.and(createSpecification(criteria));
		return beneficiaryReferralRepository.findAll(specification, page);
	}

	@Transactional(readOnly = true)
	public Page<BeneficiaryReferral> findByCriteriaInwardBasic(BeneficiaryReferralCriteria criteria, Pageable page) {
		log.debug("find by criteria ref : {}, page: {}", criteria, page);
		Specification<BeneficiaryReferral> specification = null;
		if(criteria.getCurrentFacId() != null && criteria.getReferedTo() != null) {
			specification = generateSpecificationForInwardReferralForList(criteria.getCurrentFacId().getEquals()).and(createBasicSpecificationForInward(criteria));
		} else if(criteria.getCurrentFacId() != null) {
			specification = generateSpecificationForInwardReferralForSearch(criteria.getCurrentFacId().getEquals()).and(createBasicSpecificationForInward(criteria));
		} else {
			specification = createBasicSpecification(criteria);
		}
		return beneficiaryReferralRepository.findAll(specification, page);
	}
	
	public static Specification<BeneficiaryReferral> getSpecificationForNotAcceptedFacilities () {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.isNull(root.get("acceptedFacility"));            
	    };
	}
	
	public static Specification<BeneficiaryReferral> getSpecificationForAcceptedFacilitiesByFacility (Long facilityId) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("acceptedFacility"), facilityId);            
	    };
	}
	
	public static Specification<BeneficiaryReferral> getSpecificationForReferredToByFacility (Long facilityId) {
	    return (root, query, criteriaBuilder) -> {
	        return criteriaBuilder.equal(root.get("referedTo"), facilityId);            
	    };
	}
	
	public static Specification<BeneficiaryReferral> generateSpecificationForInwardReferralForList(Long facilityId) {
		Specification<BeneficiaryReferral> refferedToSpec = getSpecificationForNotAcceptedFacilities().and(getSpecificationForReferredToByFacility(facilityId));
		Specification<BeneficiaryReferral> acceptedSpec = getSpecificationForAcceptedFacilitiesByFacility(facilityId);
		return refferedToSpec.or(acceptedSpec);
	}
	
	public static Specification<BeneficiaryReferral> generateSpecificationForInwardReferralForSearch(Long facilityId) {
		return getSpecificationForNotAcceptedFacilities().or(getSpecificationForAcceptedFacilitiesByFacility(facilityId));
	}
	
	protected Specification<BeneficiaryReferral> createBasicSpecificationForInward(BeneficiaryReferralCriteria criteria) {
        Specification<BeneficiaryReferral> specification = Specification.where(null);
        if (criteria != null) {
        	if (criteria.getUid() != null) {
                specification = specification.or(buildSpecification(criteria.getUid(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
            }
            if (criteria.getReferralFacilityName() != null) {
                specification = specification.or(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.or(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getBeneficiaryName() != null) {
                specification = specification.or(buildSpecification(criteria.getBeneficiaryName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.or(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.or(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.or(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getFacilityTypeId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityTypeId(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
            if (criteria.getReferralTypeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralTypeId(), BeneficiaryReferral_.referralTypeId));
            }
            if (criteria.getReferDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferDate(), BeneficiaryReferral_.referDate));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferralStatusId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
            }
            if (criteria.getIsDelete() != null) {
                specification = specification.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
           	 	specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }
	
	protected Specification<BeneficiaryReferral> createAdvancedSpecificationForInward(BeneficiaryReferralCriteria criteria) {
		Specification<BeneficiaryReferral> specification = Specification.where(null);
	    if (criteria != null) {
	    	if (criteria.getUid() != null) {
	            specification = specification.and(buildSpecification(criteria.getUid(),
	                root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
	        }
	        if (criteria.getId() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getId(), BeneficiaryReferral_.id));
	        }
	        if (criteria.getTiBeneficiaryId() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getTiBeneficiaryId(), BeneficiaryReferral_.tiBeneficiaryId));
	        }
	        if (criteria.getTiBenScrId() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getTiBenScrId(), BeneficiaryReferral_.tiBenScrId));
	        }
	        if (criteria.getDateOfVisit() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getDateOfVisit(), BeneficiaryReferral_.dateOfVisit));
	        }
	        if (criteria.getReferDate() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getReferDate(), BeneficiaryReferral_.referDate));
	        }
	        if (criteria.getReferralReason() != null) {
	            specification = specification.and(buildStringSpecification(criteria.getReferralReason(), BeneficiaryReferral_.referralReason));
	        }
	        if (criteria.getReferredBy() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getReferredBy(), BeneficiaryReferral_.referredBy));
	        }
	        if (criteria.getReferralType() != null) {
	            specification = specification.and(buildStringSpecification(criteria.getReferralType(), BeneficiaryReferral_.referralType));
	        }
	        if (criteria.getReferralStatusId() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getReferralStatusId(), BeneficiaryReferral_.referralStatusId));
	        }
	        if (criteria.getIsActive() != null) {
	            specification = specification.and(buildSpecification(criteria.getIsActive(), BeneficiaryReferral_.isActive));
	        }
	        if (criteria.getIsDelete() != null) {
	            specification = specification.and(buildSpecification(criteria.getIsDelete(), BeneficiaryReferral_.isDelete));
	        }
	        if (criteria.getCreatedBy() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getCreatedBy(), BeneficiaryReferral_.createdBy));
	        }
//	        if (criteria.getCreatedTime() != null) {
//	            specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), BeneficiaryReferral_.createdTime));
//	        }
	        if (criteria.getModifiedBy() != null) {
	            specification = specification.and(buildRangeSpecification(criteria.getModifiedBy(), BeneficiaryReferral_.modifiedBy));
	        }
//	        if (criteria.getModifiedTime() != null) {
//	            specification = specification.and(buildRangeSpecification(criteria.getModifiedTime(), BeneficiaryReferral_.modifiedTime));
//	        }
	        if (criteria.getBeneficiaryId() != null) {
	            specification = specification.and(buildSpecification(criteria.getBeneficiaryId(),
	                root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.id)));
	        } 
            if (criteria.getGenderId() != null) {
                specification = specification.and(buildSpecification(criteria.getGenderId(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.genderId)));
            }
            
            if (criteria.getReferralFacilityName() != null) {
                specification = specification.and(buildSpecification(criteria.getReferralFacilityName(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.name)));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildSpecification(criteria.getFirstName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.or(buildSpecification(criteria.getMiddleName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
            }    
            if (criteria.getLastName() != null) {
                specification = specification.or(buildSpecification(criteria.getLastName(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
            }
            if (criteria.getMobileNumber() != null) {
                specification = specification.and(buildSpecification(criteria.getMobileNumber(),
                    root -> root.join(BeneficiaryReferral_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
            }
            if (criteria.getReferedFrom() != null) {
                specification = specification.and(buildSpecification(criteria.getReferedFrom(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.id)));
            }
            if (criteria.getReferralTypeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReferralTypeId(), BeneficiaryReferral_.referralTypeId));
            }
            if (criteria.getFacilityTypeId() != null) {
                specification = specification.and(buildSpecification(criteria.getFacilityTypeId(),
                    root -> root.join(BeneficiaryReferral_.referedTo, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
            if(criteria.getReferredFromFacilityTypeId() != null) {
           	 	specification = specification.and(buildSpecification(criteria.getReferredFromFacilityTypeId(),
                    root -> root.join(BeneficiaryReferral_.referedFrom, JoinType.LEFT).get(Facility_.facilityTypeId)));
            }
        }
        return specification;
    }
}
