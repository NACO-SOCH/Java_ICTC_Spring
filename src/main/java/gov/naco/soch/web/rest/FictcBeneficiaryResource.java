package gov.naco.soch.web.rest;

import gov.naco.soch.service.FictcBeneficiaryService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import gov.naco.soch.service.dto.FictcBeneficiaryDTO;
import gov.naco.soch.service.dto.FictcBeneficiaryCriteria;
import gov.naco.soch.service.FictcBeneficiaryQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * REST controller for managing FictcBeneficiary.
 */
@RestController
@RequestMapping("/api")
public class FictcBeneficiaryResource {

    private final Logger log = LoggerFactory.getLogger(FictcBeneficiaryResource.class);

    private static final String ENTITY_NAME = "fictcBeneficiary";

    @Autowired
    FictcBeneficiaryService fictcBeneficiaryService;
    @Autowired
    FictcBeneficiaryQueryService fictcBeneficiaryQueryService;
    
    @PostMapping("/fictc-beneficiaries")
    public ResponseEntity<FictcBeneficiaryDTO> createFictcBeneficiary(@Valid @RequestBody FictcBeneficiaryDTO fictcBeneficiaryDTO) throws URISyntaxException {
        log.debug("REST request to save FictcBeneficiary : {}", fictcBeneficiaryDTO);
        if (fictcBeneficiaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new fictcBeneficiary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FictcBeneficiaryDTO result = fictcBeneficiaryService.save(fictcBeneficiaryDTO);
        return ResponseEntity.created(new URI("/api/fictc-beneficiaries/" + result.getId()))
            .body(result);
    }

    @PutMapping("/fictc-beneficiaries")
    public ResponseEntity<FictcBeneficiaryDTO> updateFictcBeneficiary(@Valid @RequestBody FictcBeneficiaryDTO fictcBeneficiaryDTO) throws URISyntaxException {
        log.debug("REST request to update FictcBeneficiary : {}", fictcBeneficiaryDTO);
        if (fictcBeneficiaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FictcBeneficiaryDTO result = fictcBeneficiaryService.save(fictcBeneficiaryDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/fictc-beneficiaries")
    public ResponseEntity<List<FictcBeneficiaryDTO>> getAllFictcBeneficiaries(FictcBeneficiaryCriteria criteria, Pageable pageable) {
        log.debug("REST request to get FictcBeneficiaries by criteria: {}", criteria);
        Page<FictcBeneficiaryDTO> page = fictcBeneficiaryQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/fictc-beneficiaries/{id}")
    public ResponseEntity<FictcBeneficiaryDTO> getFictcBeneficiary(@PathVariable Long id) {
        log.debug("REST request to get FictcBeneficiary : {}", id);
        Optional<FictcBeneficiaryDTO> fictcBeneficiaryDTO = fictcBeneficiaryService.findOne(id);
        return fictcBeneficiaryDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/fictc-beneficiaries/{id}")
    public ResponseEntity<Void> deleteFictcBeneficiary(@PathVariable Long id) {
        log.debug("REST request to delete FictcBeneficiary : {}", id);
        fictcBeneficiaryService.delete(id);
        return ResponseEntity.ok().build();
    }

//    /**
//     * POST  /fictc-beneficiaries : Create a new fictcBeneficiary.
//     *
//     * @param fictcBeneficiaryDTO the fictcBeneficiaryDTO to create
//     * @return the ResponseEntity with status 201 (Created) and with body the new fictcBeneficiaryDTO, or with status 400 (Bad Request) if the fictcBeneficiary has already an ID
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PostMapping("/fictc-beneficiaries")
//    public ResponseEntity<FictcBeneficiaryDTO> createFictcBeneficiary(@RequestBody FictcBeneficiaryDTO fictcBeneficiaryDTO) throws URISyntaxException {
//        log.debug("REST request to save FictcBeneficiary : {}", fictcBeneficiaryDTO);
//        if (fictcBeneficiaryDTO.getId() != null) {
//            throw new BadRequestAlertException("A new fictcBeneficiary cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        FictcBeneficiaryDTO result = fictcBeneficiaryService.save(fictcBeneficiaryDTO);
//        return ResponseEntity.created(new URI("/api/fictc-beneficiaries/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * PUT  /fictc-beneficiaries : Updates an existing fictcBeneficiary.
//     *
//     * @param fictcBeneficiaryDTO the fictcBeneficiaryDTO to update
//     * @return the ResponseEntity with status 200 (OK) and with body the updated fictcBeneficiaryDTO,
//     * or with status 400 (Bad Request) if the fictcBeneficiaryDTO is not valid,
//     * or with status 500 (Internal Server Error) if the fictcBeneficiaryDTO couldn't be updated
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PutMapping("/fictc-beneficiaries")
//    public ResponseEntity<FictcBeneficiaryDTO> updateFictcBeneficiary(@RequestBody FictcBeneficiaryDTO fictcBeneficiaryDTO) throws URISyntaxException {
//        log.debug("REST request to update FictcBeneficiary : {}", fictcBeneficiaryDTO);
//        if (fictcBeneficiaryDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        FictcBeneficiaryDTO result = fictcBeneficiaryService.save(fictcBeneficiaryDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * GET  /fictc-beneficiaries : get all the fictcBeneficiaries.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of fictcBeneficiaries in body
//     */
//    @GetMapping("/fictc-beneficiaries")
//    public ResponseEntity<List<FictcBeneficiaryDTO>> getAllFictcBeneficiaries(FictcBeneficiaryCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get FictcBeneficiaries by criteria: {}", criteria);
//        Page<FictcBeneficiaryDTO> page = fictcBeneficiaryQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }
//
//    /**
//     * GET  /fictc-beneficiaries/:id : get the "id" fictcBeneficiary.
//     *
//     * @param id the id of the fictcBeneficiaryDTO to retrieve
//     * @return the ResponseEntity with status 200 (OK) and with body the fictcBeneficiaryDTO, or with status 404 (Not Found)
//     */
//    @GetMapping("/fictc-beneficiaries/{id}")
//    public ResponseEntity<FictcBeneficiaryDTO> getFictcBeneficiary(@PathVariable Long id) {
//        log.debug("REST request to get FictcBeneficiary : {}", id);
//        Optional<FictcBeneficiaryDTO> fictcBeneficiaryDTO = fictcBeneficiaryService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(fictcBeneficiaryDTO);
//    }
//
//    /**
//     * DELETE  /fictc-beneficiaries/:id : delete the "id" fictcBeneficiary.
//     *
//     * @param id the id of the fictcBeneficiaryDTO to delete
//     * @return the ResponseEntity with status 200 (OK)
//     */
//    @DeleteMapping("/fictc-beneficiaries/{id}")
//    public ResponseEntity<Void> deleteFictcBeneficiary(@PathVariable Long id) {
//        log.debug("REST request to delete FictcBeneficiary : {}", id);
//        fictcBeneficiaryService.delete(id);
//        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
