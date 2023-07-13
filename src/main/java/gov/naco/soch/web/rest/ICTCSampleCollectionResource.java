package gov.naco.soch.web.rest;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.constant.AdminAccessCodes;
import gov.naco.soch.service.ICTCSampleCollectionQueryService;
import gov.naco.soch.service.ICTCSampleCollectionService;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.ICTCSampleCollectionCriteria;
import gov.naco.soch.service.dto.ICTCSampleCollectionDTO;

/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCSampleCollection}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class ICTCSampleCollectionResource {

    private final Logger log = LoggerFactory.getLogger(ICTCSampleCollectionResource.class);

//    private static final String ENTITY_NAME = "sochictcIctcSampleCollection";
    
    @Autowired
    ICTCSampleCollectionService iCTCSampleCollectionService;
    @Autowired
    ICTCSampleCollectionQueryService iCTCSampleCollectionQueryService;
    
    @PostMapping("/ictc-sample-collections")
    public ResponseEntity<List<ICTCSampleCollectionDTO>> createICTCSampleCollection(@RequestBody List<CreateSampleDTO> samples) throws URISyntaxException {
        log.debug("REST request to save samples : {}", samples);
        return ResponseEntity.ok().body(iCTCSampleCollectionService.saveListOfSamples(samples));
    }

    @GetMapping("/ictc-sample-collections")
    public ResponseEntity<List<ICTCSampleCollectionDTO>> getAllICTCSampleCollections(ICTCSampleCollectionCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCSampleCollections by criteria: {}", criteria);
        Page<ICTCSampleCollectionDTO> page = iCTCSampleCollectionQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/ictc-sample-collections/{id}")
    public ResponseEntity<ICTCSampleCollectionDTO> getICTCSampleCollection(@PathVariable Long id) {
        log.debug("REST request to get ICTCSampleCollection : {}", id);
        Optional<ICTCSampleCollectionDTO> iCTCSampleCollectionDTO = iCTCSampleCollectionService.findOne(id);
        return ResponseEntity.of(iCTCSampleCollectionDTO);
    }

    @DeleteMapping("/ictc-sample-collections/{id}")
    public ResponseEntity<Void> deleteICTCSampleCollection(@PathVariable Long id) {
        log.debug("REST request to delete ICTCSampleCollection : {}", id);
        iCTCSampleCollectionService.deactivate(id);
        return ResponseEntity.noContent().build();
    }


//    /**
//     * {@code POST  /ictc-sample-collections} : Create a new iCTCSampleCollection.
//     *
//     * @param iCTCSampleCollectionDTO the iCTCSampleCollectionDTO to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new iCTCSampleCollectionDTO, or with status {@code 400 (Bad Request)} if the iCTCSampleCollection has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/ictc-sample-collections")
//    public ResponseEntity<List<ICTCSampleCollectionDTO>> createICTCSampleCollection(@RequestBody List<CreateSampleDTO> samples) throws URISyntaxException {
//        log.debug("REST request to save samples : {}", samples);
//        return ResponseEntity.ok().body(iCTCSampleCollectionService.saveListOfSamples(samples));
//    }
//
//    /**
//     * {@code GET  /ictc-sample-collections} : get all the iCTCSampleCollections.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCSampleCollections in body.
//     */
//    @GetMapping("/ictc-sample-collections")
//    public ResponseEntity<List<ICTCSampleCollectionDTO>> getAllICTCSampleCollections(ICTCSampleCollectionCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCSampleCollections by criteria: {}", criteria);
//        Page<ICTCSampleCollectionDTO> page = iCTCSampleCollectionQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /ictc-sample-collections/:id} : get the "id" iCTCSampleCollection.
//     *
//     * @param id the id of the iCTCSampleCollectionDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCSampleCollectionDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/ictc-sample-collections/{id}")
//    public ResponseEntity<ICTCSampleCollectionDTO> getICTCSampleCollection(@PathVariable Long id) {
//        log.debug("REST request to get ICTCSampleCollection : {}", id);
//        Optional<ICTCSampleCollectionDTO> iCTCSampleCollectionDTO = iCTCSampleCollectionService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCSampleCollectionDTO);
//    }
//
//    /**
//     * {@code DELETE  /ictc-sample-collections/:id} : delete the "id" iCTCSampleCollection.
//     *
//     * @param id the id of the iCTCSampleCollectionDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/ictc-sample-collections/{id}")
//    public ResponseEntity<Void> deleteICTCSampleCollection(@PathVariable Long id) {
//        log.debug("REST request to delete ICTCSampleCollection : {}", id);
//        iCTCSampleCollectionService.deactivate(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
