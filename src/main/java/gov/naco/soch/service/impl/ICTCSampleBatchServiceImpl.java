package gov.naco.soch.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCSampleBatch;
import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.repository.ICTCSampleBatchRepository;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCSampleBatchService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.LabTestSampleBatchService;
import gov.naco.soch.service.LabTestSampleService;
import gov.naco.soch.service.dto.CreateSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCSampleBatchDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;
import gov.naco.soch.service.dto.LabTestSampleBatchDTO;
import gov.naco.soch.service.dto.LabTestSampleDTO;
import gov.naco.soch.service.mapper.ICTCSampleBatchMapper;
import gov.naco.soch.service.mapper.ICTCSampleCollectionMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link ICTCSampleBatch}.
 */
@Service
@Transactional
public class ICTCSampleBatchServiceImpl implements ICTCSampleBatchService {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleBatchServiceImpl.class);

    private final ICTCSampleBatchRepository iCTCSampleBatchRepository;

    private final ICTCSampleBatchMapper iCTCSampleBatchMapper;
    
    private final ICTCSampleCollectionService sampleService;
    
    private final LabTestSampleBatchService labTestSampleBatchService;
    
    private final LabTestSampleService labTestSampleService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCSampleCollectionMapper ictcSampleCollectionMapper;
    
    public ICTCSampleBatchServiceImpl(ICTCSampleBatchRepository iCTCSampleBatchRepository, ICTCSampleBatchMapper iCTCSampleBatchMapper,
    		ICTCSampleCollectionService sampleService, LabTestSampleBatchService labTestSampleBatchService, LabTestSampleService labTestSampleService,
    		ICTCBeneficiaryService ictcBeneficiaryService, ICTCSampleCollectionMapper ictcSampleCollectionMapper) {
        this.iCTCSampleBatchRepository = iCTCSampleBatchRepository;
        this.iCTCSampleBatchMapper = iCTCSampleBatchMapper;
        this.sampleService = sampleService;
        this.labTestSampleBatchService = labTestSampleBatchService;
        this.labTestSampleService = labTestSampleService;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
        this.ictcSampleCollectionMapper = ictcSampleCollectionMapper;
    }

    /**
     * Save a iCTCSampleBatch.
     *
     * @param iCTCSampleBatchDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCSampleBatchDTO save(ICTCSampleBatchDTO iCTCSampleBatchDTO) {
        log.debug("Request to save ICTCSampleBatch : {}", iCTCSampleBatchDTO);
        ICTCSampleBatch iCTCSampleBatch = iCTCSampleBatchMapper.toEntity(iCTCSampleBatchDTO);
        iCTCSampleBatch = iCTCSampleBatchRepository.save(iCTCSampleBatch);
        return iCTCSampleBatchMapper.toDto(iCTCSampleBatch);
    }

    /**
     * Get all the iCTCSampleBatches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCSampleBatchDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCSampleBatches");
        return iCTCSampleBatchRepository.findAll(pageable)
            .map(iCTCSampleBatchMapper::toDto);
    }

    /**
     * Get one iCTCSampleBatch by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCSampleBatchDTO> findOne(Long id) {
        log.debug("Request to get ICTCSampleBatch : {}", id);
        return iCTCSampleBatchRepository.findById(id)
            .map(iCTCSampleBatchMapper::toDto);
    }

    /**
     * Delete the iCTCSampleBatch by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCSampleBatch : {}", id);
        iCTCSampleBatchRepository.deleteById(id);
    }
    
    /**
     * TO create a batch of samples
     * 
     */
    @Transactional
    public ICTCSampleBatchDTO createBatch(CreateSampleBatchDTO batchDetails) {
    	log.debug("Request to save ICTCSampleBatch : {}", batchDetails);
    	if(batchDetails.getSampleIds() == null) {
    		 throw new BadRequestAlertException("Empty List", "ICTC","Empty List");
    	}
    	Long countOfDuplicateConsignmentIds = iCTCSampleBatchRepository.countByConsignmentId(batchDetails.getConsignmentId());
    	if(countOfDuplicateConsignmentIds > 0) {
			throw new BadRequestAlertException("Consignment Id Already Exists: " + batchDetails.getConsignmentId(), "ICTC","DUPLICATE_CONSIGNMENT_ID");
		}
    	ICTCSampleBatchDTO batch = new ICTCSampleBatchDTO();
    	LabTestSampleBatchDTO labTestBatch = new LabTestSampleBatchDTO();
    	labTestBatch.setLabId(batchDetails.getLabId());
    	labTestBatch.setNumOfSamples(batchDetails.getSampleIds().size());
    	labTestBatch.setBdnSerialNumber(batchDetails.getConsignmentId());
    	
    	labTestBatch.setDispatchDate(batchDetails.getDispatchDate());
    	labTestBatch.setBatchStatusId(1);
    	labTestBatch.setIsDelete(false);
    	labTestBatch.setFacilityId(batchDetails.getFacilityId());
    	labTestBatch = labTestSampleBatchService.save(labTestBatch);
    	
    	batch.setConsignmentId(batchDetails.getConsignmentId());
    	batch.setLabId(batchDetails.getLabId());
    	batch.setBatchStatus(1);
    	batch.setCreatedTime(LocalDateTime.now());
    	batch.setIsDeleted(false);
    	batch.setIsActive(true);
    	batch.setDispatchDate(batchDetails.getDispatchDate());
    	batch.setFacilityId(batchDetails.getFacilityId());
    	batch = save(batch);
    	for(Long sampleId : batchDetails.getSampleIds()) {
    		Optional<ICTCSampleCollection> sampleOptional = sampleService.find(sampleId);
    		if(!sampleOptional.isPresent()) {
    			throw new BadRequestAlertException("Invalid Sample Id", "ICTC","Invalid Sample Id");
    		}
    		ICTCSampleCollection sample = sampleOptional.get();
    		
    		ICTCSampleCollectionDTO sampleDTO = ictcSampleCollectionMapper.toDto(sample);
    		sampleDTO.setBatchId(batch.getId());
    		sampleDTO.setSampleCollectionStatus(2);
    		sampleService.save(sampleDTO);
    		
    		LabTestSampleDTO labTestSampleDTO = new LabTestSampleDTO();
    		labTestSampleDTO.setBarcodeNumber(sample.getBarcode());
    		labTestSampleDTO.setSampleCollectedDate(sample.getSampleCollectionDate());
			labTestSampleDTO.setSampleDispatchDate(batchDetails.getDispatchDate());
			labTestSampleDTO.setBatchId(labTestBatch.getId());
			labTestSampleDTO.setTestTypeId(sample.getTestType());
			labTestSampleDTO.setIsDelete(false);
			labTestSampleDTO.setFacilityId(batchDetails.getFacilityId());
			labTestSampleDTO.setLabId(batchDetails.getLabId());
			Optional<ICTCBeneficiaryDTO> ictcBeneficiaryOptional = ictcBeneficiaryService.findOne(sampleDTO.getIctcBeneficiaryId());
    		if(ictcBeneficiaryOptional.isPresent()) {
    			labTestSampleDTO.setBeneficiaryId(ictcBeneficiaryOptional.get().getBeneficiaryId());
    		}
			labTestSampleService.save(labTestSampleDTO);
    	}
    	return batch;
    }
    
}
