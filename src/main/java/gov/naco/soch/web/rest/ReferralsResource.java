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
import gov.naco.soch.domain.Referrals;
import gov.naco.soch.service.ReferralsQueryService;
import gov.naco.soch.service.ReferralsService;
import gov.naco.soch.service.dto.ReferralsCriteria;
import gov.naco.soch.service.dto.ReferralsDTO;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link gov.naco.soch.domain.Referrals}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class ReferralsResource {

    private final Logger log = LoggerFactory.getLogger(ReferralsResource.class);

    private static final String ENTITY_NAME = "sochictcReferrals";

    @Autowired
   ReferralsService referralsService;
    @Autowired
   ReferralsQueryService referralsQueryService;
    
    @PostMapping("/referrals")
    public ResponseEntity<ReferralsDTO> createReferrals(@Valid @RequestBody ReferralsDTO referralsDTO) throws URISyntaxException {
        log.debug("REST request to save Referrals : {}", referralsDTO);
        if (referralsDTO.getId() != null) {
            throw new BadRequestAlertException("A new referrals cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReferralsDTO result = referralsService.save(referralsDTO);
        return ResponseEntity.created(new URI("/api/referrals/" + result.getId()))
            .body(result);
    }

    @PutMapping("/referrals")
    public ResponseEntity<ReferralsDTO> updateReferrals(@Valid @RequestBody ReferralsDTO referralsDTO) throws URISyntaxException {
        log.debug("REST request to update Referrals : {}", referralsDTO);
        if (referralsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReferralsDTO result = referralsService.save(referralsDTO);
        return ResponseEntity.ok().body(result);
    }


    @GetMapping("/referrals")
    public ResponseEntity<List<Referrals>> getAllReferrals(ReferralsCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Referrals by criteria: {}", criteria);
        Page<Referrals> page = referralsQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/referrals/count")
    public ResponseEntity<Long> countReferrals(ReferralsCriteria criteria) {
        log.debug("REST request to count Referrals by criteria: {}", criteria);
        return ResponseEntity.ok().body(referralsQueryService.countByCriteria(criteria));
    }

    @GetMapping("/referrals/{id}")
    public ResponseEntity<ReferralsDTO> getReferrals(@PathVariable Long id) {
        log.debug("REST request to get Referrals : {}", id);
        Optional<ReferralsDTO> referralsDTO = referralsService.findOne(id);
        return referralsDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/referrals/{id}")
    public ResponseEntity<Void> deleteReferrals(@PathVariable Long id) {
        log.debug("REST request to delete Referrals : {}", id);
        referralsService.delete(id);
        return ResponseEntity.noContent().build();
    }


    /**
     * {@code POST  /referrals} : Create a new referrals.
     *
     * @param referralsDTO the referralsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new referralsDTO, or with status {@code 400 (Bad Request)} if the referrals has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/referrals")
//    public ResponseEntity<ReferralsDTO> createReferrals(@Valid @RequestBody ReferralsDTO referralsDTO) throws URISyntaxException {
//        log.debug("REST request to save Referrals : {}", referralsDTO);
//        if (referralsDTO.getId() != null) {
//            throw new BadRequestAlertException("A new referrals cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        ReferralsDTO result = referralsService.save(referralsDTO);
//        return ResponseEntity.created(new URI("/api/referrals/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /referrals} : Updates an existing referrals.
//     *
//     * @param referralsDTO the referralsDTO to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated referralsDTO,
//     * or with status {@code 400 (Bad Request)} if the referralsDTO is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the referralsDTO couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/referrals")
//    public ResponseEntity<ReferralsDTO> updateReferrals(@Valid @RequestBody ReferralsDTO referralsDTO) throws URISyntaxException {
//        log.debug("REST request to update Referrals : {}", referralsDTO);
//        if (referralsDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        ReferralsDTO result = referralsService.save(referralsDTO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, referralsDTO.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /referrals} : get all the referrals.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of referrals in body.
//     */
//    @GetMapping("/referrals")
//    public ResponseEntity<List<Referrals>> getAllReferrals(ReferralsCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get Referrals by criteria: {}", criteria);
//        Page<Referrals> page = referralsQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /referrals/count} : count all the referrals.
//     *
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
//     */
//    @GetMapping("/referrals/count")
//    public ResponseEntity<Long> countReferrals(ReferralsCriteria criteria) {
//        log.debug("REST request to count Referrals by criteria: {}", criteria);
//        return ResponseEntity.ok().body(referralsQueryService.countByCriteria(criteria));
//    }
//
//    /**
//     * {@code GET  /referrals/:id} : get the "id" referrals.
//     *
//     * @param id the id of the referralsDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the referralsDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/referrals/{id}")
//    public ResponseEntity<ReferralsDTO> getReferrals(@PathVariable Long id) {
//        log.debug("REST request to get Referrals : {}", id);
//        Optional<ReferralsDTO> referralsDTO = referralsService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(referralsDTO);
//    }
//
//    /**
//     * {@code DELETE  /referrals/:id} : delete the "id" referrals.
//     *
//     * @param id the id of the referralsDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/referrals/{id}")
//    public ResponseEntity<Void> deleteReferrals(@PathVariable Long id) {
//        log.debug("REST request to delete Referrals : {}", id);
//        referralsService.delete(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
