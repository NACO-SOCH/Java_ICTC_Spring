package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
import gov.naco.soch.service.ICTCBatchDetailsQueryService;
import gov.naco.soch.service.ICTCBatchDetailsService;
import gov.naco.soch.service.dto.ICTCBatchDetailsCriteria;
import gov.naco.soch.service.dto.ICTCBatchDetailsDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;


/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCBatchDetails}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class ICTCBatchDetailsController {

    private final Logger log = LoggerFactory.getLogger(ICTCBatchDetailsController.class);

    private static final String ENTITY_NAME = "sochictcIctcBatchDetails";

    @Autowired
   ICTCBatchDetailsService iCTCBatchDetailsService;
    @Autowired
    ICTCBatchDetailsQueryService iCTCBatchDetailsQueryService;
    
    @PostMapping("/ictc-batch-list")
    public ResponseEntity<ICTCBatchDetailsDTO> createICTCBatchDetails(@RequestBody ICTCBatchDetailsDTO iCTCBatchDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save ICTCBatchDetails : {}", iCTCBatchDetailsDTO);
        if (iCTCBatchDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new iCTCBatchDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ICTCBatchDetailsDTO result = iCTCBatchDetailsService.save(iCTCBatchDetailsDTO);
        return ResponseEntity.created(new URI("/api/ictc-batch-list/" + result.getId()))
            .body(result);
    }

    @PutMapping("/ictc-batch-list")
    public ResponseEntity<ICTCBatchDetailsDTO> updateICTCBatchDetails(@RequestBody ICTCBatchDetailsDTO iCTCBatchDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update ICTCBatchDetails : {}", iCTCBatchDetailsDTO);
        if (iCTCBatchDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ICTCBatchDetailsDTO result = iCTCBatchDetailsService.save(iCTCBatchDetailsDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/ictc-batch-list")
    public ResponseEntity<List<ICTCBatchDetailsDTO>> getAllICTCBatchDetails(ICTCBatchDetailsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBatchDetails by criteria: {}", criteria);
        Page<ICTCBatchDetailsDTO> page = iCTCBatchDetailsQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-batch-list/count")
    public ResponseEntity<Long> countICTCBatchDetails(ICTCBatchDetailsCriteria criteria) {
        log.debug("REST request to count ICTCBatchDetails by criteria: {}", criteria);
        return ResponseEntity.ok(iCTCBatchDetailsQueryService.countByCriteria(criteria));
    }

    @GetMapping("/ictc-batch-list/{id}")
    public ResponseEntity<ICTCBatchDetailsDTO> getICTCBatchDetails(@PathVariable Long id) {
        log.debug("REST request to get ICTCBatchDetails : {}", id);
        Optional<ICTCBatchDetailsDTO> iCTCBatchDetailsDTO = iCTCBatchDetailsService.findOne(id);
        return iCTCBatchDetailsDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/ictc-batch-list/{id}")
    public ResponseEntity<Void> deleteICTCBatchDetails(@PathVariable Long id) {
        log.debug("REST request to delete ICTCBatchDetails : {}", id);
        iCTCBatchDetailsService.delete(id);
        return ResponseEntity.noContent().build();
    }


    /**
     * {@code POST  /ictc-batch-list} : Create a new iCTCBatchDetails.
     *
     * @param iCTCBatchDetailsDTO the iCTCBatchDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCBatchDetailsDTO, or with status {@code 400 (Bad Request)} if the iCTCBatchDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/ictc-batch-list")
//    public ResponseEntity<ICTCBatchDetailsDTO> createICTCBatchDetails(@RequestBody ICTCBatchDetailsDTO iCTCBatchDetailsDTO) throws URISyntaxException {
//        log.debug("REST request to save ICTCBatchDetails : {}", iCTCBatchDetailsDTO);
//        if (iCTCBatchDetailsDTO.getId() != null) {
//            throw new BadRequestAlertException("A new iCTCBatchDetails cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        ICTCBatchDetailsDTO result = iCTCBatchDetailsService.save(iCTCBatchDetailsDTO);
//        return ResponseEntity.created(new URI("/api/ictc-batch-list/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }

//    /**
//     * {@code PUT  /ictc-batch-list} : Updates an existing iCTCBatchDetails.
//     *
//     * @param iCTCBatchDetailsDTO the iCTCBatchDetailsDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iCTCBatchDetailsDTO,
//     * or with status {@code 400 (Bad Request)} if the iCTCBatchDetailsDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the iCTCBatchDetailsDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/ictc-batch-list")
//    public ResponseEntity<ICTCBatchDetailsDTO> updateICTCBatchDetails(@RequestBody ICTCBatchDetailsDTO iCTCBatchDetailsDTO) throws URISyntaxException {
//        log.debug("REST request to update ICTCBatchDetails : {}", iCTCBatchDetailsDTO);
//        if (iCTCBatchDetailsDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        ICTCBatchDetailsDTO result = iCTCBatchDetailsService.save(iCTCBatchDetailsDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iCTCBatchDetailsDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /ictc-batch-list} : get all the iCTCBatchDetails.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBatchDetails in body.
//     */
//    @GetMapping("/ictc-batch-list")
//    public ResponseEntity<List<ICTCBatchDetailsDTO>> getAllICTCBatchDetails(ICTCBatchDetailsCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCBatchDetails by criteria: {}", criteria);
//        Page<ICTCBatchDetailsDTO> page = iCTCBatchDetailsQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /ictc-batch-list/count} : count all the iCTCBatchDetails.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/ictc-batch-list/count")
//    public ResponseEntity<Long> countICTCBatchDetails(ICTCBatchDetailsCriteria criteria) {
//        log.debug("REST request to count ICTCBatchDetails by criteria: {}", criteria);
//        return ResponseEntity.ok().body(iCTCBatchDetailsQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /ictc-batch-list/:id} : get the "id" iCTCBatchDetails.
//     *
//     * @param id the id of the iCTCBatchDetailsDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCBatchDetailsDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/ictc-batch-list/{id}")
//    public ResponseEntity<ICTCBatchDetailsDTO> getICTCBatchDetails(@PathVariable Long id) {
//        log.debug("REST request to get ICTCBatchDetails : {}", id);
//        Optional<ICTCBatchDetailsDTO> iCTCBatchDetailsDTO = iCTCBatchDetailsService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCBatchDetailsDTO);
//    }
//
//    /**
//     * {@code DELETE  /ictc-batch-list/:id} : delete the "id" iCTCBatchDetails.
//     *
//     * @param id the id of the iCTCBatchDetailsDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/ictc-batch-list/{id}")
//    public ResponseEntity<Void> deleteICTCBatchDetails(@PathVariable Long id) {
//        log.debug("REST request to delete ICTCBatchDetails : {}", id);
//        iCTCBatchDetailsService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }

}
