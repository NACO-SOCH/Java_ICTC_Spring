package gov.naco.soch.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.domain.LabTestSample;
import gov.naco.soch.repository.BeneficiaryFamilyDetailsRepository;
import gov.naco.soch.repository.LabTestSampleRepository;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.LabTestSampleService;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.dto.LabTestSampleDTO;
import gov.naco.soch.service.mapper.ICTCBeneficiaryMapper;
import gov.naco.soch.service.mapper.ICTCVisitMapper;
import gov.naco.soch.service.mapper.LabTestSampleMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link LabTestSample}.
 */
@Service
@Transactional
public class LabTestSampleServiceImpl implements LabTestSampleService {

    private final Logger log = LoggerFactory.getLogger(LabTestSampleServiceImpl.class);

    private final LabTestSampleRepository labTestSampleRepository;

    private final LabTestSampleMapper labTestSampleMapper;
    
    private final ICTCVisitService visitService;
    
    private final ICTCVisitMapper ictcVisitMapper;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCBeneficiaryMapper ictcBeneficiaryMapper;
    
    private final BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository;
    
    public LabTestSampleServiceImpl(LabTestSampleRepository labTestSampleRepository, LabTestSampleMapper labTestSampleMapper,
    		ICTCVisitService visitService, BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService,
    		ICTCBeneficiaryService ictcBeneficiaryService, ICTCVisitMapper ictcVisitMapper, ICTCBeneficiaryMapper ictcBeneficiaryMapper,
    		BeneficiaryFamilyDetailsRepository beneficiaryFamilyDetailsRepository) {
        this.labTestSampleRepository = labTestSampleRepository;
        this.labTestSampleMapper = labTestSampleMapper;
        this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
        this.visitService = visitService;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
        this.ictcVisitMapper = ictcVisitMapper;
        this.ictcBeneficiaryMapper = ictcBeneficiaryMapper;
        this.beneficiaryFamilyDetailsRepository = beneficiaryFamilyDetailsRepository;
    }

    /**
     * Save a labTestSample.
     *
     * @param labTestSampleDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public LabTestSampleDTO save(LabTestSampleDTO labTestSampleDTO) {
        log.debug("Request to save LabTestSample : {}", labTestSampleDTO);
        LabTestSample labTestSample = labTestSampleMapper.toEntity(labTestSampleDTO);
        labTestSample = labTestSampleRepository.save(labTestSample);
        return labTestSampleMapper.toDto(labTestSample);
    }
    
    /**
     * Save a labTestSample.
     *
     * @param labTestSampleDTO the entity to save.
     * @return the persisted entity.
     */
    public LabTestSample save(LabTestSample labTestSample) {
        log.debug("Request to save LabTestSample : {}", labTestSample);
        return labTestSampleRepository.save(labTestSample);
    }

    /**
     * Get all the labTestSamples.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<LabTestSampleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all LabTestSamples");
        return labTestSampleRepository.findAll(pageable)
            .map(labTestSampleMapper::toDto);
    }

    /**
     * Get one labTestSample by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<LabTestSampleDTO> findOne(Long id) {
        log.debug("Request to get LabTestSample : {}", id);
        return labTestSampleRepository.findById(id)
            .map(labTestSampleMapper::toDto);
    }
    
    /**
     * Get one labTestSample by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<LabTestSample> find(Long id) {
        log.debug("Request to get LabTestSample : {}", id);
        return labTestSampleRepository.findById(id);
    }

    /**
     * Delete the labTestSample by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete LabTestSample : {}", id);
        labTestSampleRepository.deleteById(id);
    }
    
    /**
     * Save list of samples.
     *
     * @param samples the list of samples to save
     * @return the persisted entity.
     */
    @Transactional
    public List<LabTestSampleDTO> saveListOfSamples(List<CreateSampleDTO> samples) {
    	if (samples == null) {
            throw new BadRequestAlertException("Empty List", "ICTC","Empty List");
        }
    	List<LabTestSampleDTO> list = new ArrayList<>();
    	for(CreateSampleDTO sample : samples) {
    		Long countOfDuplicates = labTestSampleRepository.countByBarcodeNumber(sample.getBarcode());
    		if(countOfDuplicates > 0 && sample.getBarcode() != null) {
    			throw new BadRequestAlertException("Barcode Already Exists: " + sample.getBarcode(), "ICTC","DUPLICATE_BARCODE");
    		}
    		Optional<ICTCVisit> visitOptional = visitService.find(sample.getVisitId());
    		if(!visitOptional.isPresent()) {
    			throw new BadRequestAlertException("Invalid visit id", "ICTC","Invalid visit Id");
    		}
    		ICTCVisit prevVisit = visitOptional.get();
    		ICTCVisitDTO visit = ictcVisitMapper.toDto(prevVisit);
    		visit.setId(null);
    		visit.setIsMultiFacilityService(false);
    		
    		Integer newBeneficiaryStatus = null;
    		switch(sample.getTestType()) {
    		case 5 : newBeneficiaryStatus = 9; //S-DBS-I-PENDING
    			break;
    		case 6 : newBeneficiaryStatus = 15; //S-DBS-II-PENDING
				break;
    		case 7 : newBeneficiaryStatus = 21; //S-DBS-III-PENDING
				break;
    		case 8 : newBeneficiaryStatus = 27; //C-DBS-I-PENDING
				break;
    		case 9 : newBeneficiaryStatus = 33; //C-DBS-II-PENDING
				break;
    		case 10 : newBeneficiaryStatus = 39; //C-DBS-III-PENDING
				break;
    		case 11 : newBeneficiaryStatus = 45; //Antibody-I-PENDING
				break;
    		case 12 : newBeneficiaryStatus = 47; //Antibody-II-PENDING
				break;
    		case 13 : newBeneficiaryStatus = 49; //Antibody-III-PENDING
				break;
    		case 14 : newBeneficiaryStatus = 55; //Antibody-IV-PENDING
				break;
			default: break;
    		}
    		
    		beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(prevVisit.getIctcBeneficiary().getBeneficiary().getId(), newBeneficiaryStatus, visit.getBeneficiaryStatus(), sample.getFacilityId(), null);
    		visit.setBeneficiaryStatus(newBeneficiaryStatus);
    		visit.setInfantBreastFed(sample.getInfantBreastFed());
    		visit.setVisitDate(sample.getVisitDate());
    		visit = visitService.save(visit);
    		
    		LabTestSampleDTO ictcSample = new LabTestSampleDTO();
    		ictcSample.setSampleCollectedDate(sample.getSampleCollectionDate());
    		ictcSample.setSampleCollectionStatus(1);
    		ictcSample.setIsDelete(false);
    		ictcSample.setBarcodeNumber(sample.getBarcode());
    		ictcSample.setIctcBeneficiaryId(sample.getIctcBeneficiaryId());
    		ictcSample.setVisitId(visit.getId());
    		ictcSample.setTestTypeId(sample.getTestType());
    		ictcSample.setIsEighteenPlus(sample.getIsEighteenPlus());
    		ictcSample.setFacilityId(sample.getFacilityId());
    		ictcSample.setLabTechnicianId(sample.getLabTechnicianId());
    		ictcSample.setMasterResultStatus(1);
    		ictcSample.setBeneficiaryId(prevVisit.getIctcBeneficiary().getBeneficiary().getId());
    		ictcSample = save(ictcSample);
    		list.add(ictcSample);
    		
    		ICTCBeneficiary ictcBeneficiary = prevVisit.getIctcBeneficiary();
    		ictcBeneficiary.setCurrentTestResultId(ictcSample.getId());
    		ictcBeneficiary.setRecentVisitId(visit.getId());
    		ictcBeneficiary.setBeneficiaryStatus(newBeneficiaryStatus);
    		ictcBeneficiaryService.save(ictcBeneficiary);
    	}
        log.debug("Request to save list of samples : {}", samples);
        return list;
    }
    
    /**
     * Delete the iCTCSampleCollection by id.
     *
     * @param id the id of the entity.
     */
    @Transactional
    public void deactivate(Long id) {
        log.debug("Request to delete ICTCSampleCollection : {}", id);
        labTestSampleRepository.markEntryAsDeletedAndInActive(id);
    }
    
    /**
     * Get Test result details
     *
     * @param id the id of the entity
     */
//    public ICTCTestDetails getTestDetails(Long id) {
//        log.debug("Request to get TestResult details : {}", id);
//        Optional<LabTestSample> optional = labTestSampleRepository.findById(id);
//        if(!optional.isPresent()) {
//        	throw new BadRequestAlertException("Invalid sample Id", "ICTC","Invalid sample Id");
//        }
//        LabTestSample sample = optional.get();
//        ICTCTestDetails details = new ICTCTestDetails();
//        details.setVisitDetails(ictcVisitMapper.toDto(sample.getVisit()));
//        details.setEidLabDetails(sample.getBatch() == null ? null : sample.getBatch().getLab());
//        details.setIctcDetails(sample.getFacility());
//        details.setBeneficiaryDetails(sample.getIctcBeneficiary().getBeneficiary());
//        details.setIctcBeneficiaryDetails(ictcBeneficiaryMapper.toDto(sample.getIctcBeneficiary()));
//        details.setEidLabSampleDetails(sample);
//        List<BeneficiaryFamilyDetails> motherDetails = beneficiaryFamilyDetailsRepository.findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(sample.getIctcBeneficiary().getBeneficiary().getId(), 4);
//    	if(!motherDetails.isEmpty()) {
//    		details.setMotherDetails(motherDetails.get(0).getMemberBeneficiary());
//    	}
//        return details;
//    }
}
