package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.domain.BeneficiaryFamilyDetails;
import gov.naco.soch.service.BeneficiaryFamilyDetailsQueryService;
import gov.naco.soch.service.BeneficiaryFamilyDetailsService;
import gov.naco.soch.service.BeneficiaryReferralQueryService;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsCriteria;
import gov.naco.soch.service.dto.BeneficiaryFamilyDetailsDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link gov.naco.soch.domain.BeneficiaryFamilyDetails}.
 */
@RestController
@RequestMapping("/api")
public class BeneficiaryFamilyDetailsResource {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryFamilyDetailsResource.class);

    private static final String ENTITY_NAME = "sochiBeneficiaryFamilyDetails";

    @Autowired
    BeneficiaryFamilyDetailsService beneficiaryFamilyDetailsService;
    @Autowired
    BeneficiaryFamilyDetailsQueryService beneficiaryFamilyDetailsQueryService;
    @Autowired
    BeneficiaryReferralQueryService beneficiaryReferralService;
    @Autowired
    BeneficiaryService beneficiaryService;


    
    @PostMapping("/beneficiary-family-details")
    public ResponseEntity<BeneficiaryFamilyDetails> createBeneficiaryFamilyDetails(@Valid @RequestBody BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save BeneficiaryFamilyDetails: {}", beneficiaryFamilyDetailsDTO);
        if (beneficiaryFamilyDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new beneficiaryFamilyDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BeneficiaryFamilyDetailsDTO result = beneficiaryFamilyDetailsService.save(beneficiaryFamilyDetailsDTO);
        BeneficiaryFamilyDetails beneficiaryFamilyDetails = beneficiaryFamilyDetailsService.findById(result.getId()).get();
        return ResponseEntity.created(new URI("/api/beneficiary-family-details/" + result.getId()))
                .body(beneficiaryFamilyDetails);
    }

    @PutMapping("/beneficiary-family-details")
    public ResponseEntity<BeneficiaryFamilyDetailsDTO> updateBeneficiaryFamilyDetails(@Valid @RequestBody BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update BeneficiaryFamilyDetails: {}", beneficiaryFamilyDetailsDTO);
        if (beneficiaryFamilyDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BeneficiaryFamilyDetailsDTO result = beneficiaryFamilyDetailsService.save(beneficiaryFamilyDetailsDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/beneficiary-family-details")
    public ResponseEntity<List<BeneficiaryFamilyDetails>> getAllBeneficiaryFamilyDetails(BeneficiaryFamilyDetailsCriteria criteria) {
        log.debug("REST request to get BeneficiaryFamilyDetails by criteria: {}", criteria);
        List<BeneficiaryFamilyDetails> list = beneficiaryFamilyDetailsQueryService.findListByCriteria(criteria);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/beneficiary-family-details/count")
    public ResponseEntity<Long> countBeneficiaryFamilyDetails(BeneficiaryFamilyDetailsCriteria criteria) {
        log.debug("REST request to count BeneficiaryFamilyDetails by criteria: {}", criteria);
        long count = beneficiaryFamilyDetailsQueryService.countByCriteria(criteria);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/beneficiary-family-details/{id}")
    public ResponseEntity<BeneficiaryFamilyDetailsDTO> getBeneficiaryFamilyDetails(@PathVariable Long id) {
        log.debug("REST request to get BeneficiaryFamilyDetails: {}", id);
        Optional<BeneficiaryFamilyDetailsDTO> beneficiaryFamilyDetailsDTO = beneficiaryFamilyDetailsService.findOne(id);
        if (beneficiaryFamilyDetailsDTO.isPresent()) {
            return ResponseEntity.ok(beneficiaryFamilyDetailsDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/beneficiary-family-details/{id}")
    public ResponseEntity<Void> deleteBeneficiaryFamilyDetails(@PathVariable Long id) {
        log.debug("REST request to delete BeneficiaryFamilyDetails: {}", id);
        beneficiaryFamilyDetailsService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
    
    
//    /**
//     * {@code POST  /beneficiary-family-details} : Create a new beneficiaryFamilyDetails.
//     *
//     * @param beneficiaryFamilyDetailsDTO the beneficiaryFamilyDetailsDTO to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new beneficiaryFamilyDetailsDTO, or with status {@code 400 (Bad Request)} if the beneficiaryFamilyDetails has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    
//    @PostMapping("/beneficiary-family-details")
//    public ResponseEntity<BeneficiaryFamilyDetails> createBeneficiaryFamilyDetails(@RequestBody BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO) throws URISyntaxException {
//        log.debug("REST request to save BeneficiaryFamilyDetails : {}", beneficiaryFamilyDetailsDTO);
//        if (beneficiaryFamilyDetailsDTO.getId() != null) {
//            throw new BadRequestAlertException("A new beneficiaryFamilyDetails cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        BeneficiaryFamilyDetailsDTO result = beneficiaryFamilyDetailsService.save(beneficiaryFamilyDetailsDTO);
//        BeneficiaryFamilyDetails beneficiaryFamilyDetails = beneficiaryFamilyDetailsService.findById(result.getId()).get();
//        return ResponseEntity.created(new URI("/api/beneficiary-family-details/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(beneficiaryFamilyDetails);
//    }
//
//    /**
//     * {@code PUT  /beneficiary-family-details} : Updates an existing beneficiaryFamilyDetails.
//     *
//     * @param beneficiaryFamilyDetailsDTO the beneficiaryFamilyDetailsDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated beneficiaryFamilyDetailsDTO,
//     * or with status {@code 400 (Bad Request)} if the beneficiaryFamilyDetailsDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the beneficiaryFamilyDetailsDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/beneficiary-family-details")
//    public ResponseEntity<BeneficiaryFamilyDetailsDTO> updateBeneficiaryFamilyDetails(@RequestBody BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO) throws URISyntaxException {
//        log.debug("REST request to update BeneficiaryFamilyDetails : {}", beneficiaryFamilyDetailsDTO);
//        if (beneficiaryFamilyDetailsDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        BeneficiaryFamilyDetailsDTO result = beneficiaryFamilyDetailsService.save(beneficiaryFamilyDetailsDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, beneficiaryFamilyDetailsDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /beneficiary-family-details} : get all the beneficiaryFamilyDetails.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaryFamilyDetails in body.
//     */
//    
//    @GetMapping("/beneficiary-family-details")
//    public ResponseEntity<List<BeneficiaryFamilyDetails>> getAllBeneficiaryFamilyDetails(BeneficiaryFamilyDetailsCriteria criteria) {
//        log.debug("REST request to get BeneficiaryFamilyDetails by criteria: {}", criteria);
//        List<BeneficiaryFamilyDetails> list = beneficiaryFamilyDetailsQueryService.findListByCriteria(criteria);
//        //HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().body(list);
//    }
//
//    /**
//     * {@code GET  /beneficiary-family-details/count} : count all the beneficiaryFamilyDetails.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/beneficiary-family-details/count")
//    public ResponseEntity<Long> countBeneficiaryFamilyDetails(BeneficiaryFamilyDetailsCriteria criteria) {
//        log.debug("REST request to count BeneficiaryFamilyDetails by criteria: {}", criteria);
//        return ResponseEntity.ok().body(beneficiaryFamilyDetailsQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /beneficiary-family-details/:id} : get the "id" beneficiaryFamilyDetails.
//     *
//     * @param id the id of the beneficiaryFamilyDetailsDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the beneficiaryFamilyDetailsDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/beneficiary-family-details/{id}")
//    public ResponseEntity<BeneficiaryFamilyDetailsDTO> getBeneficiaryFamilyDetails(@PathVariable Long id) {
//        log.debug("REST request to get BeneficiaryFamilyDetails : {}", id);
//        Optional<BeneficiaryFamilyDetailsDTO> beneficiaryFamilyDetailsDTO = beneficiaryFamilyDetailsService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(beneficiaryFamilyDetailsDTO);
//    }
//
//    /**
//     * {@code DELETE  /beneficiary-family-details/:id} : delete the "id" beneficiaryFamilyDetails.
//     *
//     * @param id the id of the beneficiaryFamilyDetailsDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/beneficiary-family-details/{id}")
//    public ResponseEntity<Void> deleteBeneficiaryFamilyDetails(@PathVariable Long id) {
//        log.debug("REST request to delete BeneficiaryFamilyDetails : {}", id);
//        beneficiaryFamilyDetailsService.softDelete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
