package gov.naco.soch.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.ICTCSampleCollection;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.domain.ICTCVisit;
import gov.naco.soch.repository.ICTCFollowUpRepository;
import gov.naco.soch.service.BeneficiaryIctcStatusTrackingService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCFollowUpService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.dto.ICTCFollowUpDTO;
import gov.naco.soch.service.mapper.ICTCFollowUpMapper;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * Service Implementation for managing {@link ICTCFollowUp}.
 */
@Service
@Transactional
public class ICTCFollowUpServiceImpl implements ICTCFollowUpService {

    private final Logger log = LoggerFactory.getLogger(ICTCFollowUpServiceImpl.class);

    private final ICTCFollowUpRepository iCTCFollowUpRepository;

    private final ICTCFollowUpMapper iCTCFollowUpMapper;
    
    private final ICTCVisitService visitService;
    
    private final BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService;
    
    private final ICTCBeneficiaryService ictcBeneficiaryService;
    
    private final ICTCTestResultService ictcTestResultService;

    public ICTCFollowUpServiceImpl(ICTCFollowUpRepository iCTCFollowUpRepository, ICTCFollowUpMapper iCTCFollowUpMapper, 
    		ICTCVisitService visitService, BeneficiaryIctcStatusTrackingService beneficiaryIctcStatusTrackingService,
    		ICTCBeneficiaryService ictcBeneficiaryService, ICTCTestResultService ictcTestResultService) {
        this.iCTCFollowUpRepository = iCTCFollowUpRepository;
        this.iCTCFollowUpMapper = iCTCFollowUpMapper;
        this.visitService = visitService;
        this.beneficiaryIctcStatusTrackingService = beneficiaryIctcStatusTrackingService;
        this.ictcBeneficiaryService = ictcBeneficiaryService;
        this.ictcTestResultService = ictcTestResultService;
    }

    /**
     * Save a iCTCFollowUp.
     *
     * @param iCTCFollowUpDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ICTCFollowUpDTO save(ICTCFollowUpDTO iCTCFollowUpDTO) {
        log.debug("Request to save ICTCFollowUp : {}", iCTCFollowUpDTO);
        ICTCFollowUp iCTCFollowUp = iCTCFollowUpMapper.toEntity(iCTCFollowUpDTO);
        iCTCFollowUp.setIsActive(true);
        iCTCFollowUp.setIsDeleted(false);
        iCTCFollowUp.setCreatedTime(LocalDateTime.now());
        iCTCFollowUp = iCTCFollowUpRepository.save(iCTCFollowUp);
        return iCTCFollowUpMapper.toDto(iCTCFollowUp);
    }
    
    /**
     * Save a iCTCFollowUp for infant.
     *
     * @param ictcFollowUpDTO the entity to save.
     * @return the persisted entity.
     */
    @Transactional
    public ICTCFollowUpDTO saveFollowUpForInfant(ICTCFollowUpDTO ictcFollowUpDTO) {
        log.debug("Request to save ICTCFollowUp : {}", ictcFollowUpDTO);
        Optional<ICTCFollowUp> followUpOptional = iCTCFollowUpRepository.findByFollowUpTypeAndVisitId(ictcFollowUpDTO.getFollowUpType(), ictcFollowUpDTO.getVisitId());
        if(followUpOptional.isPresent()) {
        	ictcFollowUpDTO.setId(followUpOptional.get().getId());
        }
        Optional<ICTCTestResult> testResultOptional = ictcTestResultService.find(ictcFollowUpDTO.getTestResultId());
        if(!testResultOptional.isPresent()) {
        	throw new BadRequestAlertException("Invalid Result ID", "ICTC","Invalid result Id");
        }
        
        ICTCSampleCollection sample = testResultOptional.get().getSample();
        Integer newBeneficiaryStatus = null;
        switch(sample.getTestType()) {
		case 5 : newBeneficiaryStatus = 14; //S-DBS-I-FOLLOW UP
			break;
		case 6 : newBeneficiaryStatus = 20; //S-DBS-II-FOLLOW UP
			break;
		case 7 : newBeneficiaryStatus = 26; //S-DBS-III-FOLLOW UP
			break;
		case 8 : newBeneficiaryStatus = 32; //C-DBS-I-FOLLOW UP
			break;
		case 9 : newBeneficiaryStatus = 38; //C-DBS-II-FOLLOW UP
			break;
		case 10 : newBeneficiaryStatus = 44; //C-DBS-III-FOLLOW UP
			break;
		case 11 : newBeneficiaryStatus = 52; // Antibody-I-FOLLOW UP
			break;
		case 12 : newBeneficiaryStatus = 53; // Antibody-II-FOLLOW UP
			break;
		case 13 : newBeneficiaryStatus = 54; // Antibody-III-FOLLOW UP
			break;
		case 14 : newBeneficiaryStatus = 57; // Antibody-IV-FOLLOW UP
			break;
		default: break;
		}
        
        ICTCVisit visit = sample.getVisit();
    	beneficiaryIctcStatusTrackingService.saveBeneficiaryIctcStatusChange(visit.getIctcBeneficiary().getBeneficiary().getId(), newBeneficiaryStatus, visit.getBeneficiaryStatus(), ictcFollowUpDTO.getFacilityId(), null);
    	visit.setBeneficiaryStatus(newBeneficiaryStatus);
    	visitService.save(visit);
    	ICTCBeneficiary ictcBeneficiary = visit.getIctcBeneficiary();
    	ictcBeneficiary.setBeneficiaryStatus(newBeneficiaryStatus);
    	ictcBeneficiaryService.save(ictcBeneficiary);
    	
        ICTCFollowUp iCTCFollowUp = iCTCFollowUpMapper.toEntity(ictcFollowUpDTO);
        iCTCFollowUp.setIsActive(true);
        iCTCFollowUp.setIsDeleted(false);
        iCTCFollowUp.setIsCompleted(false);
        iCTCFollowUp.setCreatedTime(LocalDateTime.now());
        iCTCFollowUp = iCTCFollowUpRepository.save(iCTCFollowUp);
        return iCTCFollowUpMapper.toDto(iCTCFollowUp);
    }

    /**
     * Get all the iCTCFollowUps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ICTCFollowUpDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ICTCFollowUps");
        return iCTCFollowUpRepository.findAll(pageable)
            .map(iCTCFollowUpMapper::toDto);
    }

    /**
     * Get one iCTCFollowUp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ICTCFollowUpDTO> findOne(Long id) {
        log.debug("Request to get ICTCFollowUp : {}", id);
        return iCTCFollowUpRepository.findById(id)
            .map(iCTCFollowUpMapper::toDto);
    }
    
    /**
     * Get one iCTCFollowUp by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<ICTCFollowUp> find(Long id) {
        log.debug("Request to get ICTCFollowUp : {}", id);
        return iCTCFollowUpRepository.findById(id);
    }

    /**
     * Delete the iCTCFollowUp by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ICTCFollowUp : {}", id);
        iCTCFollowUpRepository.deleteById(id);
    }
}
