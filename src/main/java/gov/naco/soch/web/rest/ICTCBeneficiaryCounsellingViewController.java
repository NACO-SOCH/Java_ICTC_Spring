package gov.naco.soch.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.constant.AdminAccessCodes;
import gov.naco.soch.domain.ICTCBeneficiaryCounsellingView;
import gov.naco.soch.service.ICTCBeneficiaryCounsellingViewQueryService;
import gov.naco.soch.service.ICTCBeneficiaryCounsellingViewService;
import gov.naco.soch.service.dto.ICTCBeneficiaryCounsellingViewCriteria;


/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCBeneficiaryVisit}.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class ICTCBeneficiaryCounsellingViewController {

    private final Logger log = LoggerFactory.getLogger(ICTCBeneficiaryCounsellingViewController.class);

     @Autowired
     ICTCBeneficiaryCounsellingViewService ictcBeneficiaryCounsellingViewService;
     @Autowired
     ICTCBeneficiaryCounsellingViewQueryService ictcBeneficiaryCounsellingViewQueryService;

     @GetMapping("/ictc-counselling-list")
     public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> getAllICTCBeneficiaryVisits(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
         log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
         Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.findByCriteria(criteria, pageable);
         return ResponseEntity.ok(page.getContent());
     }
     
     @GetMapping("/ictc-counselling-list/basic")
     public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> getAllICTCBeneficiaryVisitsBasic(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
         log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
         Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.findByCriteriaBasic(criteria, pageable);
         return ResponseEntity.ok(page.getContent());
     }
     
     @GetMapping("/ictc-counselling-list/advanced")
     public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> getAllICTCBeneficiaryVisitsAdvanced(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
         log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
         Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.findByCriteria(criteria, pageable);
         return ResponseEntity.ok(page.getContent());
     }
     
     @GetMapping("/ictc-counselling-list-search")
     public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> searchAllICTCBeneficiaryVisits(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
         log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
         Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.searchByCriteria(criteria, pageable);
         return ResponseEntity.ok(page.getContent());
     }

     @GetMapping("/ictc-counselling-list/{id}")
     public ResponseEntity<ICTCBeneficiaryCounsellingView> getICTCBeneficiaryVisit(@PathVariable Long id) {
         log.debug("REST request to get ICTCBeneficiaryVisit : {}", id);
         Optional<ICTCBeneficiaryCounsellingView> ictcBeneficiaryCounsellingView = ictcBeneficiaryCounsellingViewService.findOne(id);
         return ictcBeneficiaryCounsellingView.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
     }

//    /**
//     * {@code GET  /ictc-visit-list} : get all the iCTCBeneficiaryVisits.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaryVisits in body.
//     */
//    @GetMapping("/ictc-counselling-list")
//    public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> getAllICTCBeneficiaryVisits(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
//        Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//    
//    @GetMapping("/ictc-counselling-list/basic")
//    public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> getAllICTCBeneficiaryVisitsBasic(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
//        Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.findByCriteriaBasic(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//    
//    @GetMapping("/ictc-counselling-list/advanced")
//    public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> getAllICTCBeneficiaryVisitsAdvanced(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
//        Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//    
//    /**
//     * {@code GET  /ictc-visit-list-search} : get all the iCTCBeneficiaryVisits.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of iCTCBeneficiaryVisits in body.
//     */
//    @GetMapping("/ictc-counselling-list-search")
//    public ResponseEntity<List<ICTCBeneficiaryCounsellingView>> searchAllICTCBeneficiaryVisits(ICTCBeneficiaryCounsellingViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCBeneficiaryVisits by criteria: {}", criteria);
//        Page<ICTCBeneficiaryCounsellingView> page = ictcBeneficiaryCounsellingViewQueryService.searchByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /ictc-visit-lists/:id} : get the "id" iCTCBeneficiaryVisit.
//     *
//     * @param id the id of the iCTCBeneficiaryVisitDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the iCTCBeneficiaryVisitDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/ictc-counselling-list/{id}")
//    public ResponseEntity<ICTCBeneficiaryCounsellingView> getICTCBeneficiaryVisit(@PathVariable Long id) {
//        log.debug("REST request to get ICTCBeneficiaryVisit : {}", id);
//        Optional<ICTCBeneficiaryCounsellingView> ictcBeneficiaryCounsellingView = ictcBeneficiaryCounsellingViewService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(ictcBeneficiaryCounsellingView);
//    }

}
