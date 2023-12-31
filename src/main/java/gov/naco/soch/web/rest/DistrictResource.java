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

import gov.naco.soch.service.DistrictQueryService;
import gov.naco.soch.service.DistrictService;
import gov.naco.soch.service.dto.DistrictCriteria;
import gov.naco.soch.service.dto.DistrictDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link gov.naco.soch.domain.District}.
 */
@RestController
@RequestMapping("/api")
public class DistrictResource {

    private final Logger log = LoggerFactory.getLogger(DistrictResource.class);

    private static final String ENTITY_NAME = "sochictcDistrict";

    
    @Autowired
    DistrictService districtService;
    @Autowired
    DistrictQueryService districtQueryService;
    
    
    @PostMapping("/districts")
    public ResponseEntity<DistrictDTO> createDistrict(@Valid @RequestBody DistrictDTO districtDTO) throws URISyntaxException {
        log.debug("REST request to save District: {}", districtDTO);
        if (districtDTO.getId() != null) {
            throw new BadRequestAlertException("A new district cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DistrictDTO result = districtService.save(districtDTO);
        return ResponseEntity.created(new URI("/api/districts/" + result.getId())).body(result);
    }

    @PutMapping("/districts")
    public ResponseEntity<DistrictDTO> updateDistrict(@Valid @RequestBody DistrictDTO districtDTO) throws URISyntaxException {
        log.debug("REST request to update District: {}", districtDTO);
        if (districtDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DistrictDTO result = districtService.save(districtDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/districts")
    public ResponseEntity<List<DistrictDTO>> getAllDistricts(DistrictCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Districts by criteria: {}", criteria);
        Page<DistrictDTO> page = districtQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/districts/count")
    public ResponseEntity<Long> countDistricts(DistrictCriteria criteria) {
        log.debug("REST request to count Districts by criteria: {}", criteria);
        long count = districtQueryService.countByCriteria(criteria);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<DistrictDTO> getDistrict(@PathVariable Long id) {
        log.debug("REST request to get District: {}", id);
        Optional<DistrictDTO> districtDTO = districtService.findOne(id);
        return ResponseEntity.of(districtDTO);
    }

    @DeleteMapping("/districts/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        log.debug("REST request to delete District: {}", id);
        districtService.delete(id);
        return ResponseEntity.noContent().build();
    }


    /**
     * {@code POST  /districts} : Create a new district.
     *
     * @param districtDTO the districtDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new districtDTO, or with status {@code 400 (Bad Request)} if the district has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/districts")
//    public ResponseEntity<DistrictDTO> createDistrict(@RequestBody DistrictDTO districtDTO) throws URISyntaxException {
//        log.debug("REST request to save District : {}", districtDTO);
//        if (districtDTO.getId() != null) {
//            throw new BadRequestAlertException("A new district cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        DistrictDTO result = districtService.save(districtDTO);
//        return ResponseEntity.created(new URI("/api/districts/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /districts} : Updates an existing district.
//     *
//     * @param districtDTO the districtDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated districtDTO,
//     * or with status {@code 400 (Bad Request)} if the districtDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the districtDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/districts")
//    public ResponseEntity<DistrictDTO> updateDistrict(@RequestBody DistrictDTO districtDTO) throws URISyntaxException {
//        log.debug("REST request to update District : {}", districtDTO);
//        if (districtDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        DistrictDTO result = districtService.save(districtDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, districtDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /districts} : get all the districts.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of districts in body.
//     */
//    @GetMapping("/districts")
//    public ResponseEntity<List<DistrictDTO>> getAllDistricts(DistrictCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get Districts by criteria: {}", criteria);
//        Page<DistrictDTO> page = districtQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /districts/count} : count all the districts.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/districts/count")
//    public ResponseEntity<Long> countDistricts(DistrictCriteria criteria) {
//        log.debug("REST request to count Districts by criteria: {}", criteria);
//        return ResponseEntity.ok().body(districtQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /districts/:id} : get the "id" district.
//     *
//     * @param id the id of the districtDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the districtDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/districts/{id}")
//    public ResponseEntity<DistrictDTO> getDistrict(@PathVariable Long id) {
//        log.debug("REST request to get District : {}", id);
//        Optional<DistrictDTO> districtDTO = districtService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(districtDTO);
//    }
//
//    /**
//     * {@code DELETE  /districts/:id} : delete the "id" district.
//     *
//     * @param id the id of the districtDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/districts/{id}")
//    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
//        log.debug("REST request to delete District : {}", id);
//        districtService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
