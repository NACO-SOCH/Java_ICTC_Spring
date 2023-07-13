package gov.naco.soch.service.impl;

import gov.naco.soch.service.FictcBeneficiaryService;
import gov.naco.soch.domain.FictcBeneficiary;
import gov.naco.soch.repository.FictcBeneficiaryRepository;
import gov.naco.soch.service.dto.FictcBeneficiaryDTO;
import gov.naco.soch.service.mapper.FictcBeneficiaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing FictcBeneficiary.
 */
@Service
@Transactional
public class FictcBeneficiaryServiceImpl implements FictcBeneficiaryService {

    private final Logger log = LoggerFactory.getLogger(FictcBeneficiaryServiceImpl.class);

    private final FictcBeneficiaryRepository fictcBeneficiaryRepository;

    private final FictcBeneficiaryMapper fictcBeneficiaryMapper;

    public FictcBeneficiaryServiceImpl(FictcBeneficiaryRepository fictcBeneficiaryRepository, FictcBeneficiaryMapper fictcBeneficiaryMapper) {
        this.fictcBeneficiaryRepository = fictcBeneficiaryRepository;
        this.fictcBeneficiaryMapper = fictcBeneficiaryMapper;
    }

    /**
     * Save a fictcBeneficiary.
     *
     * @param fictcBeneficiaryDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FictcBeneficiaryDTO save(FictcBeneficiaryDTO fictcBeneficiaryDTO) {
        log.debug("Request to save FictcBeneficiary : {}", fictcBeneficiaryDTO);
        FictcBeneficiary fictcBeneficiary = fictcBeneficiaryMapper.toEntity(fictcBeneficiaryDTO);
        fictcBeneficiary = fictcBeneficiaryRepository.save(fictcBeneficiary);
        return fictcBeneficiaryMapper.toDto(fictcBeneficiary);
    }

    /**
     * Get all the fictcBeneficiaries.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FictcBeneficiaryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FictcBeneficiaries");
        return fictcBeneficiaryRepository.findAll(pageable)
            .map(fictcBeneficiaryMapper::toDto);
    }


    /**
     * Get one fictcBeneficiary by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FictcBeneficiaryDTO> findOne(Long id) {
        log.debug("Request to get FictcBeneficiary : {}", id);
        return fictcBeneficiaryRepository.findById(id)
            .map(fictcBeneficiaryMapper::toDto);
    }

    /**
     * Delete the fictcBeneficiary by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete FictcBeneficiary : {}", id);
        fictcBeneficiaryRepository.deleteById(id);
    }
}
