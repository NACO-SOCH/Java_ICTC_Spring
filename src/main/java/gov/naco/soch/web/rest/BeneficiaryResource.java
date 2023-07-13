package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.constant.AdminAccessCodes;
import gov.naco.soch.service.BeneficiaryQueryService;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.dto.BeneficiaryCriteria;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
/**
 * REST controller for managing {@link gov.naco.soch.domain.Beneficiary}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class BeneficiaryResource {

    private final Logger log = LoggerFactory.getLogger(BeneficiaryResource.class);

    private static final String ENTITY_NAME = "sochictcBeneficiary";


    @Autowired
    BeneficiaryService beneficiaryService;
    @Autowired
    BeneficiaryQueryService beneficiaryQueryService;


    
    @PostMapping("/beneficiaries")
    public ResponseEntity<BeneficiaryDTO> createBeneficiary(@Valid @RequestBody BeneficiaryDTO beneficiaryDTO) throws URISyntaxException {
        log.debug("REST request to save Beneficiary : {}", beneficiaryDTO);
        if (beneficiaryDTO.getId() != null) {
            throw new BadRequestAlertException("A new beneficiary cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BeneficiaryDTO result = beneficiaryService.save(beneficiaryDTO);
        return ResponseEntity.created(new URI("/api/beneficiaries/" + result.getId())).body(result);
    }

    @PutMapping("/beneficiaries")
    public ResponseEntity<BeneficiaryDTO> updateBeneficiary(@Valid @RequestBody BeneficiaryDTO beneficiaryDTO) throws URISyntaxException {
        log.debug("REST request to update Beneficiary : {}", beneficiaryDTO);
        if (beneficiaryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BeneficiaryDTO result = beneficiaryService.save(beneficiaryDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/beneficiaries")
    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiaries(BeneficiaryCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Beneficiaries by criteria: {}", criteria);
        Page<BeneficiaryDTO> page = beneficiaryQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }
    
    @GetMapping("/beneficiaries/list/basic")
    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiariesBasic(BeneficiaryCriteria criteria) {
        log.debug("REST request to get Beneficiaries by criteria: {}", criteria);
        List<BeneficiaryDTO> list = beneficiaryQueryService.findByCriteriaBasic(criteria);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/beneficiaries/count")
    public ResponseEntity<Long> countBeneficiaries(BeneficiaryCriteria criteria) {
        log.debug("REST request to count Beneficiaries by criteria: {}", criteria);
        long count = beneficiaryQueryService.countByCriteria(criteria);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/beneficiaries/{id}")
    public ResponseEntity<BeneficiaryDTO> getBeneficiary(@PathVariable Long id) {
        log.debug("REST request to get Beneficiary : {}", id);
        Optional<BeneficiaryDTO> beneficiaryDTO = beneficiaryService.findOne(id);
        return ResponseEntity.of(beneficiaryDTO);
    }

    @DeleteMapping("/beneficiaries/{id}")
    public ResponseEntity<Void> deleteBeneficiary(@PathVariable Long id) {
        log.debug("REST request to delete Beneficiary : {}", id);
        beneficiaryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
//
//    /**
//     * {@code POST  /beneficiaries} : Create a new beneficiary.
//     *
//     * @param beneficiaryDTO the beneficiaryDTO to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new beneficiaryDTO, or with status {@code 400 (Bad Request)} if the beneficiary has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/beneficiaries")
//    public ResponseEntity<BeneficiaryDTO> createBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) throws URISyntaxException {
//        log.debug("REST request to save Beneficiary : {}", beneficiaryDTO);
//        if (beneficiaryDTO.getId() != null) {
//            throw new BadRequestAlertException("A new beneficiary cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        BeneficiaryDTO result = beneficiaryService.save(beneficiaryDTO);
//        return ResponseEntity.created(new URI("/api/beneficiaries/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /beneficiaries} : Updates an existing beneficiary.
//     *
//     * @param beneficiaryDTO the beneficiaryDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated beneficiaryDTO,
//     * or with status {@code 400 (Bad Request)} if the beneficiaryDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the beneficiaryDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/beneficiaries")
//    public ResponseEntity<BeneficiaryDTO> updateBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) throws URISyntaxException {
//        log.debug("REST request to update Beneficiary : {}", beneficiaryDTO);
//        if (beneficiaryDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        BeneficiaryDTO result = beneficiaryService.save(beneficiaryDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, beneficiaryDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /beneficiaries} : get all the beneficiaries.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of beneficiaries in body.
//     */
//    @GetMapping("/beneficiaries")
//    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiaries(BeneficiaryCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get Beneficiaries by criteria: {}", criteria);
//        Page<BeneficiaryDTO> page = beneficiaryQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//    
//    @GetMapping("/beneficiaries/list/basic")
//    public ResponseEntity<List<BeneficiaryDTO>> getAllBeneficiariesBasic(BeneficiaryCriteria criteria) {
//        log.debug("REST request to get Beneficiaries by criteria: {}", criteria);
//        List<BeneficiaryDTO> list = beneficiaryQueryService.findByCriteriaBasic(criteria);
//        return ResponseEntity.ok().body(list);
//    }
//
//    /**
//     * {@code GET  /beneficiaries/count} : count all the beneficiaries.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/beneficiaries/count")
//    public ResponseEntity<Long> countBeneficiaries(BeneficiaryCriteria criteria) {
//        log.debug("REST request to count Beneficiaries by criteria: {}", criteria);
//        return ResponseEntity.ok().body(beneficiaryQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /beneficiaries/:id} : get the "id" beneficiary.
//     *
//     * @param id the id of the beneficiaryDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the beneficiaryDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/beneficiaries/{id}")
//    public ResponseEntity<BeneficiaryDTO> getBeneficiary(@PathVariable Long id) {
//        log.debug("REST request to get Beneficiary : {}", id);
//        Optional<BeneficiaryDTO> beneficiaryDTO = beneficiaryService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(beneficiaryDTO);
//    }
//
//    /**
//     * {@code DELETE  /beneficiaries/:id} : delete the "id" beneficiary.
//     *
//     * @param id the id of the beneficiaryDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/beneficiaries/{id}")
//    public ResponseEntity<Void> deleteBeneficiary(@PathVariable Long id) {
//        log.debug("REST request to delete Beneficiary : {}", id);
//        beneficiaryService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
