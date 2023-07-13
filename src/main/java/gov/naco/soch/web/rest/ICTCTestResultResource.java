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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.constant.AdminAccessCodes;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.service.ICTCTestResultQueryService;
import gov.naco.soch.service.ICTCTestResultService;
import gov.naco.soch.service.dto.ICTCTestDetails;
import gov.naco.soch.service.dto.ICTCTestResultCriteria;
import gov.naco.soch.service.dto.ICTCTestResultDTO;
import gov.naco.soch.service.dto.IctcTestResultHistoryDTO;
/**
 * REST controller for managing ICTCTestResult.
 */
@RestController
@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
@RequestMapping("/api")
public class ICTCTestResultResource {

    private final Logger log = LoggerFactory.getLogger(ICTCTestResultResource.class);

    @Autowired
    ICTCTestResultService iCTCTestResultService;
    @Autowired
    ICTCTestResultQueryService iCTCTestResultQueryService;


    @GetMapping("/ictc-test-results")
    public ResponseEntity<List<ICTCTestResultDTO>> getAllICTCTestResults(ICTCTestResultCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
        Page<ICTCTestResultDTO> page = iCTCTestResultQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-test-results-details")
    public ResponseEntity<List<ICTCTestResult>> getAllICTCTestResultsDetails(ICTCTestResultCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
        Page<ICTCTestResult> page = iCTCTestResultQueryService.findEntitiesByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/ictc-test-results-details/trf/{resultId}")
    public ResponseEntity<IctcTestResultHistoryDTO> getAllICTCTestResultsDetailsForTRF(ICTCTestResultCriteria criteria, @PathVariable("resultId") Long resultId, Pageable pageable, @RequestParam(required = false) Boolean isSampleId) {
        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
        IctcTestResultHistoryDTO history = iCTCTestResultQueryService.findEntitiesByCriteriaForTRF(criteria, pageable, resultId, isSampleId);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/ictc-test-results/{id}")
    public ResponseEntity<ICTCTestResultDTO> getICTCTestResult(@PathVariable Long id) {
        log.debug("REST request to get ICTCTestResult : {}", id);
        Optional<ICTCTestResultDTO> iCTCTestResultDTO = iCTCTestResultService.findOne(id);
        return iCTCTestResultDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ictc-test-result/test-details/{id}")
    public ResponseEntity<ICTCTestDetails> getTestDetails(@PathVariable Long id) {
        log.debug("REST request to get ICTCTestResult : {}", id);
        return ResponseEntity.ok(iCTCTestResultService.getTestDetails(id));
    }


//
//    /**
//     * GET  /ictc-test-results : get all the iCTCTestResults.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
//     */
//    @GetMapping("/ictc-test-results")
//    public ResponseEntity<List<ICTCTestResultDTO>> getAllICTCTestResults(ICTCTestResultCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
//        Page<ICTCTestResultDTO> page = iCTCTestResultQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }
//    
//    /**
//     * GET  /ictc-test-results-details : get all the iCTCTestResults.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
//     */
//    @GetMapping("/ictc-test-results-details")
//    public ResponseEntity<List<ICTCTestResult>> getAllICTCTestResultsDetails(ICTCTestResultCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
//        Page<ICTCTestResult> page = iCTCTestResultQueryService.findEntitiesByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }
//    
//    /**
//     * GET  /ictc-test-results-details/trf : get all the iCTCTestResults.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
//     */
//    @GetMapping("/ictc-test-results-details/trf/{resultId}")
//    public ResponseEntity<IctcTestResultHistoryDTO> getAllICTCTestResultsDetailsForTRF(ICTCTestResultCriteria criteria, @PathVariable("resultId") Long resultId, Pageable pageable, @RequestParam(required = false) Boolean isSampleId) {
//        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
//        IctcTestResultHistoryDTO history = iCTCTestResultQueryService.findEntitiesByCriteriaForTRF(criteria, pageable, resultId, isSampleId);
//        return ResponseEntity.ok().body(history);
//    }
//    
//   
//    /**
//     * GET  /ictc-test-results/:id : get the "id" iCTCTestResult.
//     *
//     * @param id the id of the iCTCTestResultDTO to retrieve
//     * @return the ResponseEntity with status 200 (OK) and with body the iCTCTestResultDTO, or with status 404 (Not Found)
//     */
//    @GetMapping("/ictc-test-results/{id}")
//    public ResponseEntity<ICTCTestResultDTO> getICTCTestResult(@PathVariable Long id) {
//        log.debug("REST request to get ICTCTestResult : {}", id);
//        Optional<ICTCTestResultDTO> iCTCTestResultDTO = iCTCTestResultService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCTestResultDTO);
//    }
//    
//    /**
//     * GET  /ictc-test-result/test-details/:id : get the "id" iCTCTestResult.
//     *
//     * @param id the id of the ICTCTestDetails to retrieve
//     * @return the ResponseEntity with status 200 (OK) and with body the ICTCTestDetails
//     */
//    @GetMapping("/ictc-test-result/test-details/{id}")
//    public ResponseEntity<ICTCTestDetails> getTestDetails(@PathVariable Long id) {
//        log.debug("REST request to get ICTCTestResult : {}", id);
//        return ResponseEntity.ok().body(iCTCTestResultService.getTestDetails(id));
//    }
//    

}
