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
import gov.naco.soch.service.FacilityQueryService;
import gov.naco.soch.service.FacilityService;
import gov.naco.soch.service.dto.FacilityBasicListDto;
import gov.naco.soch.service.dto.FacilityCriteria;
import gov.naco.soch.service.dto.FacilityDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
/**
 * REST controller for managing {@link gov.naco.soch.domain.Facility}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class FacilityResource {

    private final Logger log = LoggerFactory.getLogger(FacilityResource.class);

    private static final String ENTITY_NAME = "sochictcFacility";


    @Autowired
    FacilityService facilityService;
    @Autowired
    FacilityQueryService facilityQueryService;

    
    @PostMapping("/facilities")
    public ResponseEntity<FacilityDTO> createFacility(@Valid @RequestBody FacilityDTO facilityDTO) throws URISyntaxException {
        log.debug("REST request to save Facility : {}", facilityDTO);
        if (facilityDTO.getId() != null) {
            throw new BadRequestAlertException("A new facility cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FacilityDTO result = facilityService.save(facilityDTO);
        return ResponseEntity.created(new URI("/api/facilities/" + result.getId())).body(result);
    }

    @PutMapping("/facilities")
    public ResponseEntity<FacilityDTO> updateFacility(@Valid @RequestBody FacilityDTO facilityDTO) throws URISyntaxException {
        log.debug("REST request to update Facility : {}", facilityDTO);
        if (facilityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FacilityDTO result = facilityService.save(facilityDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/facilities")
    public ResponseEntity<List<FacilityDTO>> getAllFacilities(FacilityCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Facilities by criteria: {}", criteria);
        Page<FacilityDTO> page = facilityQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/facilities/count")
    public ResponseEntity<Long> countFacilities(FacilityCriteria criteria) {
        log.debug("REST request to count Facilities by criteria: {}", criteria);
        long count = facilityQueryService.countByCriteria(criteria);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/facilities/{id}")
    public ResponseEntity<FacilityDTO> getFacility(@PathVariable Long id) {
        log.debug("REST request to get Facility : {}", id);
        Optional<FacilityDTO> facilityDTO = facilityService.findOne(id);
        return ResponseEntity.of(facilityDTO);
    }

    @DeleteMapping("/facilities/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Long id) {
        log.debug("REST request to delete Facility : {}", id);
        facilityService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/facilities/labs")
    public ResponseEntity<List<FacilityBasicListDto>> getLabsLinkedToAnICTC(@RequestParam Long facilityId, @RequestParam(required = false) Long labTypeId) {
        List<FacilityBasicListDto> labs = facilityService.findAllLabsMappedToICTC(facilityId, labTypeId);
        return ResponseEntity.ok(labs);
    }


    /**
     * {@code POST  /facilities} : Create a new facility.
     *
     * @param facilityDTO the facilityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new facilityDTO, or with status {@code 400 (Bad Request)} if the facility has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/facilities")
//    public ResponseEntity<FacilityDTO> createFacility(@RequestBody FacilityDTO facilityDTO) throws URISyntaxException {
//        log.debug("REST request to save Facility : {}", facilityDTO);
//        if (facilityDTO.getId() != null) {
//            throw new BadRequestAlertException("A new facility cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        FacilityDTO result = facilityService.save(facilityDTO);
//        return ResponseEntity.created(new URI("/api/facilities/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /facilities} : Updates an existing facility.
//     *
//     * @param facilityDTO the facilityDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated facilityDTO,
//     * or with status {@code 400 (Bad Request)} if the facilityDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the facilityDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/facilities")
//    public ResponseEntity<FacilityDTO> updateFacility(@RequestBody FacilityDTO facilityDTO) throws URISyntaxException {
//        log.debug("REST request to update Facility : {}", facilityDTO);
//        if (facilityDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        FacilityDTO result = facilityService.save(facilityDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, facilityDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /facilities} : get all the facilities.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of facilities in body.
//     */
//    @GetMapping("/facilities")
//    public ResponseEntity<List<FacilityDTO>> getAllFacilities(FacilityCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get Facilities by criteria: {}", criteria);
//        Page<FacilityDTO> page = facilityQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /facilities/count} : count all the facilities.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/facilities/count")
//    public ResponseEntity<Long> countFacilities(FacilityCriteria criteria) {
//        log.debug("REST request to count Facilities by criteria: {}", criteria);
//        return ResponseEntity.ok().body(facilityQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /facilities/:id} : get the "id" facility.
//     *
//     * @param id the id of the facilityDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the facilityDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/facilities/{id}")
//    public ResponseEntity<FacilityDTO> getFacility(@PathVariable Long id) {
//        log.debug("REST request to get Facility : {}", id);
//        Optional<FacilityDTO> facilityDTO = facilityService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(facilityDTO);
//    }
//
//    /**
//     * {@code DELETE  /facilities/:id} : delete the "id" facility.
//     *
//     * @param id the id of the facilityDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/facilities/{id}")
//    public ResponseEntity<Void> deleteFacility(@PathVariable Long id) {
//        log.debug("REST request to delete Facility : {}", id);
//        facilityService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
//    
//    @GetMapping("/facilities/labs")
//    public ResponseEntity<List<FacilityBasicListDto>> getLabsLinkedToAnICTC(@RequestParam Long facilityId, @RequestParam(required = false) Long labTypeId){
//    	return ResponseEntity.ok(facilityService.findAllLabsMappedToICTC(facilityId, labTypeId));
//    }
}
