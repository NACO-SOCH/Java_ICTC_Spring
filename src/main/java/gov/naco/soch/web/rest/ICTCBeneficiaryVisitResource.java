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
import gov.naco.soch.service.ICTCBeneficiaryVisitQueryService;
import gov.naco.soch.service.ICTCBeneficiaryVisitService;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCBeneficiaryVisit}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class ICTCBeneficiaryVisitResource {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryVisitResource.class);

    private static final String ENTITY_NAME = "sochictcIctcBeneficiaryVisit";

    @Autowired
    ICTCBeneficiaryVisitService iCTCBeneficiaryVisitService;
    @Autowired
    ICTCBeneficiaryVisitQueryService iCTCBeneficiaryVisitQueryService;

 
    @PostMapping("/ictc-beneficiary-visits")
    public ResponseEntity<ICTCBeneficiaryVisitDTO> createICTCBeneficiaryVisit(@Valid @RequestBody ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO) throws URISyntaxException {
        log.debug("REST request to save ICTCBeneficiaryVisit : {}", iCTCBeneficiaryVisitDTO);
        if (iCTCBeneficiaryVisitDTO.getId() != null) {
            throw new BadRequestAlertException("A new iCTCBeneficiaryVisit cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ICTCBeneficiaryVisitDTO result = iCTCBeneficiaryVisitService.save(iCTCBeneficiaryVisitDTO);
        return ResponseEntity.created(new URI("/api/ictc-beneficiary-visits/" + result.getId()))
            .body(result);
    }

    @PutMapping("/ictc-beneficiary-visits")
    public ResponseEntity<ICTCBeneficiaryVisitDTO> updateICTCBeneficiaryVisit(@Valid @RequestBody ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO) throws URISyntaxException {
        log.debug("REST request to update ICTCBeneficiaryVisit : {}", iCTCBeneficiaryVisitDTO);
        if (iCTCBeneficiaryVisitDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ICTCBeneficiaryVisitDTO result = iCTCBeneficiaryVisitService.save(iCTCBeneficiaryVisitDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/ictc-beneficiary-visits")
    public ResponseEntity<List<ICTCBeneficiaryVisitDTO>> getAllICTCBeneficiaryVisits(ICTCBeneficiaryVisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
        Page<ICTCBeneficiaryVisitDTO> page = iCTCBeneficiaryVisitQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-beneficiary-visits/count")
    public ResponseEntity<Long> countICTCBeneficiaryVisits(ICTCBeneficiaryVisitCriteria criteria) {
        log.debug("REST request to count ICTCBeneficiaryVisits by criteria: {}", criteria);
        return ResponseEntity.ok().body(iCTCBeneficiaryVisitQueryService.countByCriteria(criteria));
    }

    @GetMapping("/ictc-beneficiary-visits/{id}")
    public ResponseEntity<ICTCBeneficiaryVisitDTO> getICTCBeneficiaryVisit(@PathVariable Long id) {
        log.debug("REST request to get ICTCBeneficiaryVisit : {}", id);
        Optional<ICTCBeneficiaryVisitDTO> iCTCBeneficiaryVisitDTO = iCTCBeneficiaryVisitService.findOne(id);
        return iCTCBeneficiaryVisitDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/ictc-beneficiary-visits/{id}")
    public ResponseEntity<Void> deleteICTCBeneficiaryVisit(@PathVariable Long id) {
        log.debug("REST request to delete ICTCBeneficiaryVisit : {}", id);
        iCTCBeneficiaryVisitService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    
    
//    /**
//     * {@code POST  /ictc-beneficiary-visits} : Create a new iCTCBeneficiaryVisit.
//     *
//     * @param iCTCBeneficiaryVisitDTO the iCTCBeneficiaryVisitDTO to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCBeneficiaryVisitDTO, or with status {@code 400 (Bad Request)} if the iCTCBeneficiaryVisit has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/ictc-beneficiary-visits")
//    public ResponseEntity<ICTCBeneficiaryVisitDTO> createICTCBeneficiaryVisit(@RequestBody ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO) throws URISyntaxException {
//        log.debug("REST request to save ICTCBeneficiaryVisit : {}", iCTCBeneficiaryVisitDTO);
//        if (iCTCBeneficiaryVisitDTO.getId() != null) {
//            throw new BadRequestAlertException("A new iCTCBeneficiaryVisit cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        ICTCBeneficiaryVisitDTO result = iCTCBeneficiaryVisitService.save(iCTCBeneficiaryVisitDTO);
//        return ResponseEntity.created(new URI("/api/ictc-beneficiary-visits/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /ictc-beneficiary-visits} : Updates an existing iCTCBeneficiaryVisit.
//     *
//     * @param iCTCBeneficiaryVisitDTO the iCTCBeneficiaryVisitDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iCTCBeneficiaryVisitDTO,
//     * or with status {@code 400 (Bad Request)} if the iCTCBeneficiaryVisitDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the iCTCBeneficiaryVisitDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/ictc-beneficiary-visits")
//    public ResponseEntity<ICTCBeneficiaryVisitDTO> updateICTCBeneficiaryVisit(@RequestBody ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO) throws URISyntaxException {
//        log.debug("REST request to update ICTCBeneficiaryVisit : {}", iCTCBeneficiaryVisitDTO);
//        if (iCTCBeneficiaryVisitDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        ICTCBeneficiaryVisitDTO result = iCTCBeneficiaryVisitService.save(iCTCBeneficiaryVisitDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iCTCBeneficiaryVisitDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /ictc-beneficiary-visits} : get all the iCTCBeneficiaryVisits.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaryVisits in body.
//     */
//    @GetMapping("/ictc-beneficiary-visits")
//    public ResponseEntity<List<ICTCBeneficiaryVisitDTO>> getAllICTCBeneficiaryVisits(ICTCBeneficiaryVisitCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
//        Page<ICTCBeneficiaryVisitDTO> page = iCTCBeneficiaryVisitQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /ictc-beneficiary-visits/count} : count all the iCTCBeneficiaryVisits.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/ictc-beneficiary-visits/count")
//    public ResponseEntity<Long> countICTCBeneficiaryVisits(ICTCBeneficiaryVisitCriteria criteria) {
//        log.debug("REST request to count ICTCBeneficiaryVisits by criteria: {}", criteria);
//        return ResponseEntity.ok().body(iCTCBeneficiaryVisitQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /ictc-beneficiary-visits/:id} : get the "id" iCTCBeneficiaryVisit.
//     *
//     * @param id the id of the iCTCBeneficiaryVisitDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCBeneficiaryVisitDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/ictc-beneficiary-visits/{id}")
//    public ResponseEntity<ICTCBeneficiaryVisitDTO> getICTCBeneficiaryVisit(@PathVariable Long id) {
//        log.debug("REST request to get ICTCBeneficiaryVisit : {}", id);
//        Optional<ICTCBeneficiaryVisitDTO> iCTCBeneficiaryVisitDTO = iCTCBeneficiaryVisitService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCBeneficiaryVisitDTO);
//    }
//
//    /**
//     * {@code DELETE  /ictc-beneficiary-visits/:id} : delete the "id" iCTCBeneficiaryVisit.
//     *
//     * @param id the id of the iCTCBeneficiaryVisitDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/ictc-beneficiary-visits/{id}")
//    public ResponseEntity<Void> deleteICTCBeneficiaryVisit(@PathVariable Long id) {
//        log.debug("REST request to delete ICTCBeneficiaryVisit : {}", id);
//        iCTCBeneficiaryVisitService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
