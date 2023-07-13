package gov.naco.soch.service;

import gov.naco.soch.service.dto.FictcBeneficiaryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing FictcBeneficiary.
 */
public interface FictcBeneficiaryService {

    /**
     * Save a fictcBeneficiary.
     *
     * @param fictcBeneficiaryDTO the entity to save
     * @return the persisted entity
     */
    FictcBeneficiaryDTO save(FictcBeneficiaryDTO fictcBeneficiaryDTO);

    /**
     * Get all the fictcBeneficiaries.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<FictcBeneficiaryDTO> findAll(Pageable pageable);


    /**
     * Get the "id" fictcBeneficiary.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<FictcBeneficiaryDTO> findOne(Long id);

    /**
     * Delete the "id" fictcBeneficiary.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
