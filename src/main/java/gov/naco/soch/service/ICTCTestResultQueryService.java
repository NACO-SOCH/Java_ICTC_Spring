package gov.naco.soch.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.*; // for static metamodels
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.repository.ICTCTestResultRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.service.dto.ICTCTestResultCriteria;

import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.IctcTestResultHistoryDTO;
import gov.naco.soch.service.mapper.ICTCTestResultMapper;

/**
 * Service for executing complex queries for ICTCTestResult entities in the database.
 * The main input is a {@link ICTCTestResultCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ICTCTestResultDTO} or a {@link Page} of {@link ICTCTestResultDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ICTCTestResultQueryService {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultQueryService.class);

    private final ICTCTestResultRepository iCTCTestResultRepository;

    private final ICTCTestResultMapper iCTCTestResultMapper;
    
    private final LabTestSampleRepository labTestSampleRepository;
    
    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;

    public ICTCTestResultQueryService(ICTCTestResultRepository iCTCTestResultRepository, ICTCTestResultMapper iCTCTestResultMapper, 
    		LabTestSampleRepository labTestSampleRepository, BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository) {
        this.iCTCTestResultRepository = iCTCTestResultRepository;
        this.iCTCTestResultMapper = iCTCTestResultMapper;
        this.labTestSampleRepository = labTestSampleRepository;
        this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
    }

    /**
     * Return a {@link List} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ICTCTestResultDTO> findByCriteria(ICTCTestResultCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        return iCTCTestResultMapper.toDto(iCTCTestResultRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResultDTO> findByCriteria(ICTCTestResultCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        return iCTCTestResultRepository.findAll(specification, page)
            .map(iCTCTestResultMapper::toDto);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ICTCTestResult> findEntitiesByCriteria(ICTCTestResultCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        return iCTCTestResultRepository.findAll(specification, page);
    }
    
    /**
     * Return a {@link Page} of {@link ICTCTestResultDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public IctcTestResultHistoryDTO findEntitiesByCriteriaForTRF(ICTCTestResultCriteria criteria, Pageable page, Long resultId, Boolean isSampleId) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<ICTCTestResult> specification = createSpecification(criteria);
        IctcTestResultHistoryDTO history = new IctcTestResultHistoryDTO();
        Page<ICTCTestResult> pageOfHistory = iCTCTestResultRepository.findAll(specification, page);
        history.setTestResults(pageOfHistory.getContent());
        if(!history.getTestResults().isEmpty()) {
        	if(isSampleId != null && isSampleId) {
        		for(ICTCTestResult result : history.getTestResults()) {
            		if(result.getSample() != null && result.getSample().getId().equals(resultId)) {
            			List<LabTestSample> samples = labTestSampleRepository.findByBarcodeNumberOrderByIdDesc(result.getSample().getBarcode());
                    	if(!samples.isEmpty()) {
                    		history.setLabTestSample(samples.get(0));
                    	}
                    	history.setCurrentResultId(result.getId());
                    	break;
            		}
            	}
        	} else {
        		for(ICTCTestResult result : history.getTestResults()) {
            		if(result.getId().equals(resultId)) {
            			List<LabTestSample> samples = labTestSampleRepository.findByBarcodeNumberOrderByIdDesc(result.getSample().getBarcode());
                    	if(!samples.isEmpty()) {
                    		history.setLabTestSample(samples.get(0));
                    	}
                    	history.setCurrentResultId(result.getId());
                    	break;
            		}
            	}
        	}
        	
        	List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(history.getTestResults().get(0).getIctcBeneficiary().getBeneficiary().getId(), 4);
        	if(!motherDetails.isEmpty()) {
        		history.setMotherDetails(motherDetails.get(0).getMemberBeneficiary());
        	}
        }
        return history;
    }


    /**
     * Function to convert ICTCTestResultCriteria to a {@link Specification}
     */
    protected Specification<ICTCTestResult> createSpecification(ICTCTestResultCriteria criteria) {
        Specification<ICTCTestResult> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("id"), criteria.getId()));
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
            if (criteria.getIsTestedForTb() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isTestedForTb"), criteria.getIsTestedForTb()));
            }
            if (criteria.getTbTestResult() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("tbTestResult"), criteria.getTbTestResult()));
            }
            if (criteria.getIsTestedForSyphilis() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("isTestedForSyphilis"), criteria.getIsTestedForSyphilis()));
            }
            if (criteria.getSyphilisTestResult() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.get("syphilisTestResult"), criteria.getSyphilisTestResult()));
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
            if (criteria.getSampleId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("sample").get("id"), criteria.getSampleId()));
            }
            if (criteria.getVisitId() != null) {
                specification = specification.and((root, query, builder) ->
                        builder.equal(root.join("visit").get("id"), criteria.getVisitId()));
            }
        }
        return specification;
    }


}
