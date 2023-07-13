package gov.naco.soch.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.service.LabTestSampleQueryService;
import gov.naco.soch.service.LabTestSampleService;
import gov.naco.soch.service.dto.CreateSampleDTO;
import gov.naco.soch.service.dto.LabTestSampleCriteria;
import gov.naco.soch.service.dto.LabTestSampleDTO;
/**
 * REST controller for managing {@link gov.naco.soch.domain.LabTestSample}.
 */
@RestController
@RequestMapping("/api")
public class LabTestSampleResource {

    private final Logger log = LoggerFactory.getLogger(LabTestSampleResource.class);

//    private static final String ENTITY_NAME = "sochLabTestSample";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LabTestSampleService labTestSampleService;

    private final LabTestSampleQueryService labTestSampleQueryService;

    public LabTestSampleResource(LabTestSampleService labTestSampleService, LabTestSampleQueryService labTestSampleQueryService) {
        this.labTestSampleService = labTestSampleService;
        this.labTestSampleQueryService = labTestSampleQueryService;
    }
    
    @PostMapping("/lab-test-samples")
    public ResponseEntity<List<LabTestSampleDTO>> createLabTestSamples(@Valid @RequestBody List<CreateSampleDTO> samples) throws URISyntaxException {
        log.debug("REST request to save samples : {}", samples);
        List<LabTestSampleDTO> savedSamples = labTestSampleService.saveListOfSamples(samples);
        return ResponseEntity.ok(savedSamples);
    }

    @GetMapping("/lab-test-samples")
    public ResponseEntity<List<LabTestSampleDTO>> getAllLabTestSamples(LabTestSampleCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCSampleCollections by criteria: {}", criteria);
        Page<LabTestSampleDTO> page = labTestSampleQueryService.findByCriteria(criteria, pageable);
        return ResponseEntity.ok(page.getContent());
    }

    @GetMapping("/lab-test-samples/{id}")
    public ResponseEntity<LabTestSampleDTO> getLabTestSample(@PathVariable Long id) {
        log.debug("REST request to get ICTCSampleCollection : {}", id);
        Optional<LabTestSampleDTO> labTestSampleDTO = labTestSampleService.findOne(id);
        return labTestSampleDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/lab-test-samples/{id}")
    public ResponseEntity<Void> deleteLabTestSample(@PathVariable Long id) {
        log.debug("REST request to delete labTestSample : {}", id);
        labTestSampleService.deactivate(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * {@code POST  /lab-test-samples} : Collect Samples.
     *
     * @param samples list of samples
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new LabTestSampleDTO, or with status {@code 400 (Bad Request)} if the LabTestSampleDTO has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/lab-test-samples")
//    public ResponseEntity<List<LabTestSampleDTO>> createICTCSampleCollection(@RequestBody List<CreateSampleDTO> samples) throws URISyntaxException {
//        log.debug("REST request to save samples : {}", samples);
//        return ResponseEntity.ok().body(labTestSampleService.saveListOfSamples(samples));
//    }
//
//    /**
//     * {@code GET  /lab-test-samples} : get all the labTestSamples.
//     *
//     * @param pageable the pagination information.
//     * @param criteria the criteria which the requested entities should match.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of labTestSamples in body.
//     */
//    @GetMapping("/lab-test-samples")
//    public ResponseEntity<List<LabTestSampleDTO>> getAllLabTestSamples(LabTestSampleCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCSampleCollections by criteria: {}", criteria);
//        Page<LabTestSampleDTO> page = labTestSampleQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//    /**
//     * {@code GET  /lab-test-samples/:id} : get the "id" labTestSample.
//     *
//     * @param id the id of the labTestSampleDTO to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the labTestSampleDTO, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/lab-test-samples/{id}")
//    public ResponseEntity<LabTestSampleDTO> getLabTestSample(@PathVariable Long id) {
//        log.debug("REST request to get ICTCSampleCollection : {}", id);
//        Optional<LabTestSampleDTO> iCTCSampleCollectionDTO = labTestSampleService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(iCTCSampleCollectionDTO);
//    }
//
//    /**
//     * {@code DELETE  /lab-test-samples/:id} : delete the "id" labTestSample.
//     *
//     * @param id the id of the iCTCSampleCollectionDTO to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/lab-test-samples/{id}")
//    public ResponseEntity<Void> deleteICTCSampleCollection(@PathVariable Long id) {
//        log.debug("REST request to delete labTestSample : {}", id);
//        labTestSampleService.deactivate(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
//    
//    @GetMapping("/lab-test-samples/test-details/{id}")
//    public ResponseEntity<ICTCTestDetails> getTestDetails(@PathVariable Long id) {
//        log.debug("REST request to get ICTCTestResult : {}", id);
//        return ResponseEntity.ok().body(labTestSampleService.getTestDetails(id));
//    }
//    
//    /**
//     * GET  /ictc-test-results-details/trf : get all the iCTCTestResults.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
//     */
//    @GetMapping("/lab-test-sample-details/trf/{sampleId}")
//    public ResponseEntity<IctcTestResultHistoryDTO> getLabTestSampleDetailsForTRF(LabTestSampleCriteria criteria, @PathVariable("sampleId") Long sampleId, Pageable pageable, @RequestParam(required = false) Boolean isSampleId) {
//        log.debug("REST request to get samples by criteria: {}", criteria);
//        IctcTestResultHistoryDTO history = labTestSampleQueryService.findEntitiesByCriteriaForTRF(criteria, pageable, sampleId, isSampleId);
//        return ResponseEntity.ok().body(history);
//    }
    
//    /**
//     * GET  /ictc-test-results-details : get all the iCTCTestResults.
//     *
//     * @param pageable the pagination information
//     * @param criteria the criterias which the requested entities should match
//     * @return the ResponseEntity with status 200 (OK) and the list of iCTCTestResults in body
//     */
//    @GetMapping("/lab-test-samples-details")
//    public ResponseEntity<List<LabTestSample>> getAllLabTestSampleDetails(LabTestSampleCriteria criteria, Pageable pageable) {
//        log.debug("REST request to get ICTCTestResults by criteria: {}", criteria);
//        Page<LabTestSample> page = labTestSampleQueryService.findEntitiesByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }
    
}
