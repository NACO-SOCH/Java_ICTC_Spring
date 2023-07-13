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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import gov.naco.soch.constant.AdminAccessCodes;
import gov.naco.soch.service.IctcLinkedFacilityQueryService;
import gov.naco.soch.service.IctcLinkedFacilityService;
import gov.naco.soch.service.dto.IctcLinkedFacilityCriteria;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link gov.naco.soch.domain.IctcLinkedFacility}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class IctcLinkedFacilityResource {

    private final Logger log = LoggerFactory.getLogger(IctcLinkedFacilityResource.class);

    private static final String ENTITY_NAME = "sochictcIctcLinkedFacility";


    @Autowired
    IctcLinkedFacilityService ictcLinkedFacilityService;
    @Autowired
    IctcLinkedFacilityQueryService ictcLinkedFacilityQueryService;
    
    

    @PostMapping("/ictc-linked-facilities")
    public ResponseEntity<IctcLinkedFacilityDTO> createIctcLinkedFacility(@Valid @RequestBody IctcLinkedFacilityDTO ictcLinkedFacilityDTO) throws URISyntaxException {
        log.debug("REST request to save IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
        if (ictcLinkedFacilityDTO.getId() != null) {
            throw new BadRequestAlertException("A new ictcLinkedFacility cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IctcLinkedFacilityDTO result = ictcLinkedFacilityService.save(ictcLinkedFacilityDTO);
        return ResponseEntity.created(new URI("/api/ictc-linked-facilities/" + result.getId()))
            .body(result);
    }

    @PostMapping("/ictc-linked-facilities/all")
    public ResponseEntity<List<IctcLinkedFacilityDTO>> saveAllLinkedFacility(@Valid @RequestBody List<IctcLinkedFacilityDTO> linkedFacilityDTOs,
                                                                              @RequestParam Long facilityId) throws URISyntaxException {
        log.debug("REST request to save linkedFacilityDTOs : {}", linkedFacilityDTOs);
        return ResponseEntity.ok(ictcLinkedFacilityService.saveAll(linkedFacilityDTOs, facilityId));
    }

    @PutMapping("/ictc-linked-facilities")
    public ResponseEntity<IctcLinkedFacilityDTO> updateIctcLinkedFacility(@Valid @RequestBody IctcLinkedFacilityDTO ictcLinkedFacilityDTO) throws URISyntaxException {
        log.debug("REST request to update IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
        if (ictcLinkedFacilityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IctcLinkedFacilityDTO result = ictcLinkedFacilityService.save(ictcLinkedFacilityDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/ictc-linked-facilities")
    public ResponseEntity<List<IctcLinkedFacilityDTO>> getAllIctcLinkedFacilities(IctcLinkedFacilityCriteria criteria, Pageable pageable) {
        log.debug("REST request to get IctcLinkedFacilities by criteria: {}", criteria);
        Page<IctcLinkedFacilityDTO> page = ictcLinkedFacilityQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/ictc-linked-facilities/count")
    public ResponseEntity<Long> countIctcLinkedFacilities(IctcLinkedFacilityCriteria criteria) {
        log.debug("REST request to count IctcLinkedFacilities by criteria: {}", criteria);
        return ResponseEntity.ok().body(ictcLinkedFacilityQueryService.countByCriteria(criteria));
    }

    @GetMapping("/ictc-linked-facilities/{id}")
    public ResponseEntity<IctcLinkedFacilityDTO> getIctcLinkedFacility(@PathVariable Long id) {
        log.debug("REST request to get IctcLinkedFacility : {}", id);
        Optional<IctcLinkedFacilityDTO> ictcLinkedFacilityDTO = ictcLinkedFacilityService.findOne(id);
        return ResponseEntity.of(ictcLinkedFacilityDTO);
    }

    @DeleteMapping("/ictc-linked-facilities/{id}")
    public ResponseEntity<Void> deleteIctcLinkedFacility(@PathVariable Long id) {
        log.debug("REST request to delete IctcLinkedFacility : {}", id);
        ictcLinkedFacilityService.delete(id);
        return ResponseEntity.noContent().build();
    }
 

    /**
     * {@code POST  /ictc-linked-facilities} : Create a new ictcLinkedFacility.
     *
     * @param ictcLinkedFacilityDTO the ictcLinkedFacilityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ictcLinkedFacilityDTO, or with status {@code 400 (Bad Request)} if the ictcLinkedFacility has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/ictc-linked-facilities")
//    public ResponseEntity<IctcLinkedFacilityDTO> createIctcLinkedFacility(@Valid @RequestBody IctcLinkedFacilityDTO ictcLinkedFacilityDTO) throws URISyntaxException {
//        log.debug("REST request to save IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
//        if (ictcLinkedFacilityDTO.getId() != null) {
//            throw new BadRequestAlertException("A new ictcLinkedFacility cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        IctcLinkedFacilityDTO result = ictcLinkedFacilityService.save(ictcLinkedFacilityDTO);
//        return ResponseEntity.created(new URI("/api/ictc-linked-facilities/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//    
//    @PostMapping("/ictc-linked-facilities/all")
//    public ResponseEntity<List<IctcLinkedFacilityDTO>> saveAllLinkedFacility(@Valid @RequestBody List<IctcLinkedFacilityDTO> linkedFacilityDTOs, @RequestParam Long facilityId) throws URISyntaxException {
//        log.debug("REST request to save linkedFacilityDTOs : {}", linkedFacilityDTOs);
//        return ResponseEntity.ok(ictcLinkedFacilityService.saveAll(linkedFacilityDTOs, facilityId));
//    }
//
//    /**
//     * {@code PUT  /ictc-linked-facilities} : Updates an existing ictcLinkedFacility.
//     *
//     * @param ictcLinkedFacilityDTO the ictcLinkedFacilityDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ictcLinkedFacilityDTO,
//     * or with status {@code 400 (Bad Request)} if the ictcLinkedFacilityDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the ictcLinkedFacilityDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/ictc-linked-facilities")
//    public ResponseEntity<IctcLinkedFacilityDTO> updateIctcLinkedFacility(@Valid @RequestBody IctcLinkedFacilityDTO ictcLinkedFacilityDTO) throws URISyntaxException {
//        log.debug("REST request to update IctcLinkedFacility : {}", ictcLinkedFacilityDTO);
//        if (ictcLinkedFacilityDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        IctcLinkedFacilityDTO result = ictcLinkedFacilityService.save(ictcLinkedFacilityDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ictcLinkedFacilityDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /ictc-linked-facilities} : get all the ictcLinkedFacilities.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ictcLinkedFacilities in body.
//     */
//    @GetMapping("/ictc-linked-facilities")
//    @Measured(message = "Get LFAC getAllIctcLinkedFacilities")
//    public ResponseEntity<List<IctcLinkedFacilityDTO>> getAllIctcLinkedFacilities(IctcLinkedFacilityCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get IctcLinkedFacilities by criteria: {}", criteria);
//        Page<IctcLinkedFacilityDTO> page = ictcLinkedFacilityQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /ictc-linked-facilities/count} : count all the ictcLinkedFacilities.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/ictc-linked-facilities/count")
//    public ResponseEntity<Long> countIctcLinkedFacilities(IctcLinkedFacilityCriteria criteria) {
//        log.debug("REST request to count IctcLinkedFacilities by criteria: {}", criteria);
//        return ResponseEntity.ok().body(ictcLinkedFacilityQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /ictc-linked-facilities/:id} : get the "id" ictcLinkedFacility.
//     *
//     * @param id the id of the ictcLinkedFacilityDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ictcLinkedFacilityDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/ictc-linked-facilities/{id}")
//    public ResponseEntity<IctcLinkedFacilityDTO> getIctcLinkedFacility(@PathVariable Long id) {
//        log.debug("REST request to get IctcLinkedFacility : {}", id);
//        Optional<IctcLinkedFacilityDTO> ictcLinkedFacilityDTO = ictcLinkedFacilityService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(ictcLinkedFacilityDTO);
//    }
//
//    /**
//     * {@code DELETE  /ictc-linked-facilities/:id} : delete the "id" ictcLinkedFacility.
//     *
//     * @param id the id of the ictcLinkedFacilityDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/ictc-linked-facilities/{id}")
//    public ResponseEntity<Void> deleteIctcLinkedFacility(@PathVariable Long id) {
//        log.debug("REST request to delete IctcLinkedFacility : {}", id);
//        ictcLinkedFacilityService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
