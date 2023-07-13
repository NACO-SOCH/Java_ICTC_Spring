package gov.naco.soch.web.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.domain.ICTCTestResultView;
import gov.naco.soch.service.ICTCTestResultViewQueryService;
import gov.naco.soch.service.ICTCTestResultViewService;
import gov.naco.soch.service.dto.ICTCTestResultViewCriteria;

/**
 * REST controller for managing ICTCTestResultView.
 */
@RestController
@RequestMapping("/api")
public class ICTCTestResultViewResource {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultViewResource.class);

    @Autowired
    ICTCTestResultViewService iCTCTestResultViewService;
    @Autowired
    ICTCTestResultViewQueryService iCTCTestResultViewQueryService;
    
    
    
    @GetMapping("/ictc-test-result-views/advanced")
    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsAdvanced(ICTCTestResultViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-test-result-views/basic")
    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsBasic(ICTCTestResultViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByBasicCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-test-result-views-single-result/basic")
    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsSingleresultBasic(ICTCTestResultViewCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByBasicCriteria(criteria, pageable);
        Set<ICTCTestResultView> hSet = new HashSet<>();
        for (ICTCTestResultView x : page.getContent()) {
            hSet.add(x);
        }
        List<ICTCTestResultView> ictcTestResultViews = new ArrayList<>(hSet);
        return ResponseEntity.ok(ictcTestResultViews);
    }

    @GetMapping("/ictc-test-result-views/{id}")
    public ResponseEntity<ICTCTestResultView> getICTCTestResultView(@PathVariable Long id) {
        log.debug("REST request to get ICTCTestResultView : {}", id);
        Optional<ICTCTestResultView> iCTCTestResultView = iCTCTestResultViewService.findOne(id);
        return iCTCTestResultView.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    
    
    
//
//    /**
//     * GET  /ictc-test-result-views/advanced : get all the iCTCTestResultViews.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResultViews in body
//     */
//    @GetMapping("/ictc-test-result-views/advanced")
//    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsAdvanced(ICTCTestResultViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
//        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }
//    
//    /**
//     * GET  /ictc-test-result-views/basic : get all the iCTCTestResultViews.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResultViews in body
//     */
//    @GetMapping("/ictc-test-result-views/basic")
//    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsBasic(ICTCTestResultViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
//        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByBasicCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }
//    
//    /**
//     * GET  /ictc-test-result-views-single-result/basic : get the iCTCTestResultViews.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResultViews in body
//     */
//    @GetMapping("/ictc-test-result-views-single-result/basic")
//    public ResponseEntity<List<ICTCTestResultView>> getAllICTCTestResultViewsSingleresultBasic(ICTCTestResultViewCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCTestResultViews by criteria: {}", criteria);
//        Page<ICTCTestResultView> page = iCTCTestResultViewQueryService.findByBasicCriteria(criteria, pageable);
//        Set<ICTCTestResultView> hSet = new HashSet<ICTCTestResultView>(); 
//        for (ICTCTestResultView x : page.getContent()) {
//        	 hSet.add(x);
//        }
//        List<ICTCTestResultView> ictcTestResultViews=new ArrayList<>(hSet);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(ictcTestResultViews, headers, HttpStatus.OK);
//    }
//
//    /**
//     * GET  /ictc-test-result-views/:id : get the "id" iCTCTestResultView.
//     *
//     * @param id the id of the iCTCTestResultViewDTO to retrieve
//     * @return the ResponseEntity with status 200 (OK) and with body the iCTCTestResultViewDTO, or with status 404 (Not Found)
//     */
//    @GetMapping("/ictc-test-result-views/{id}")
//    public ResponseEntity<ICTCTestResultView> getICTCTestResultView(@PathVariable Long id) {
//        log.debug("REST request to get ICTCTestResultView : {}", id);
//        Optional<ICTCTestResultView> iCTCTestResultView = iCTCTestResultViewService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCTestResultView);
//    }

}
