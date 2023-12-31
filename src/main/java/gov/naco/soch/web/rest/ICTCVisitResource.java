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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gov.naco.soch.service.ICTCVisitQueryService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.dto.ICTCVisitCriteria;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCVisit}.
 */
@RestController
@RequestMapping("/api")
public class ICTCVisitResource {

    private final Logger log = LoggerFactory.getLogger(ICTCVisitResource.class);

    private static final String ENTITY_NAME = "sochictcIctcVisit";
    

    @Autowired
    ICTCVisitService iCTCVisitService;
    @Autowired
    ICTCVisitQueryService iCTCVisitQueryService;
    
    @PostMapping("/ictc-visits")
    public ResponseEntity<ICTCVisitDTO> createICTCVisit(@Valid @RequestBody ICTCVisitDTO iCTCVisitDTO) throws URISyntaxException {
        log.debug("REST request to save ICTCVisit : {}", iCTCVisitDTO);
        if (iCTCVisitDTO.getId() != null) {
            throw new BadRequestAlertException("A new iCTCVisit cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ICTCVisitDTO result = iCTCVisitService.save(iCTCVisitDTO);
        return ResponseEntity.created(new URI("/api/ictc-visits/" + result.getId()))
            .body(result);
    }

    @PutMapping("/ictc-visits")
    public ResponseEntity<ICTCVisitDTO> updateICTCVisit(@Valid @RequestBody ICTCVisitDTO iCTCVisitDTO) throws URISyntaxException {
        log.debug("REST request to update ICTCVisit : {}", iCTCVisitDTO);
        if (iCTCVisitDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ICTCVisitDTO result = iCTCVisitService.save(iCTCVisitDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/ictc-visits")
    public ResponseEntity<List<ICTCVisitDTO>> getAllICTCVisits(ICTCVisitCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCVisits by criteria: {}", criteria);
        Page<ICTCVisitDTO> page = iCTCVisitQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-visits/{id}")
    public ResponseEntity<ICTCVisitDTO> getICTCVisit(@PathVariable Long id) {
        log.debug("REST request to get ICTCVisit : {}", id);
        Optional<ICTCVisitDTO> iCTCVisitDTO = iCTCVisitService.findOne(id);
        return iCTCVisitDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/ictc-visits/{id}")
    public ResponseEntity<Void> deleteICTCVisit(@PathVariable Long id) {
        log.debug("REST request to delete ICTCVisit : {}", id);
        iCTCVisitService.delete(id);
        return ResponseEntity.noContent().build();
    }


//    /**
//     * {@code POST  /ictc-visits} : Create a new iCTCVisit.
//     *
//     * @param iCTCVisitDTO the iCTCVisitDTO to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCVisitDTO, or with status {@code 400 (Bad Request)} if the iCTCVisit has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/ictc-visits")
//    public ResponseEntity<ICTCVisitDTO> createICTCVisit(@Valid @RequestBody ICTCVisitDTO iCTCVisitDTO) throws URISyntaxException {
//        log.debug("REST request to save ICTCVisit : {}", iCTCVisitDTO);
//        if (iCTCVisitDTO.getId() != null) {
//            throw new BadRequestAlertException("A new iCTCVisit cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        ICTCVisitDTO result = iCTCVisitService.save(iCTCVisitDTO);
//        return ResponseEntity.created(new URI("/api/ictc-visits/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /ictc-visits} : Updates an existing iCTCVisit.
//     *
//     * @param iCTCVisitDTO the iCTCVisitDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated iCTCVisitDTO,
//     * or with status {@code 400 (Bad Request)} if the iCTCVisitDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the iCTCVisitDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/ictc-visits")
//    public ResponseEntity<ICTCVisitDTO> updateICTCVisit(@Valid @RequestBody ICTCVisitDTO iCTCVisitDTO) throws URISyntaxException {
//        log.debug("REST request to update ICTCVisit : {}", iCTCVisitDTO);
//        if (iCTCVisitDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        ICTCVisitDTO result = iCTCVisitService.save(iCTCVisitDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, iCTCVisitDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /ictc-visits} : get all the iCTCVisits.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCVisits in body.
//     */
//    @GetMapping("/ictc-visits")
//    public ResponseEntity<List<ICTCVisitDTO>> getAllICTCVisits(ICTCVisitCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCVisits by criteria: {}", criteria);
//        Page<ICTCVisitDTO> page = iCTCVisitQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /ictc-visits/count} : count all the iCTCVisits.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/ictc-visits/count")
//    public ResponseEntity<Long> countICTCVisits(ICTCVisitCriteria criteria) {
//        log.debug("REST request to count ICTCVisits by criteria: {}", criteria);
//        return ResponseEntity.ok().body(iCTCVisitQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /ictc-visits/:id} : get the "id" iCTCVisit.
//     *
//     * @param id the id of the iCTCVisitDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCVisitDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/ictc-visits/{id}")
//    public ResponseEntity<ICTCVisitDTO> getICTCVisit(@PathVariable Long id) {
//        log.debug("REST request to get ICTCVisit : {}", id);
//        Optional<ICTCVisitDTO> iCTCVisitDTO = iCTCVisitService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCVisitDTO);
//    }
//
//    /**
//     * {@code DELETE  /ictc-visits/:id} : delete the "id" iCTCVisit.
//     *
//     * @param id the id of the iCTCVisitDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/ictc-visits/{id}")
//    public ResponseEntity<Void> deleteICTCVisit(@PathVariable Long id) {
//        log.debug("REST request to delete ICTCVisit : {}", id);
//        iCTCVisitService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
