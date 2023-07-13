package gov.naco.soch.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.service.LabTestSampleBatchService;
/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCSampleBatch}.
 */
@RestController
@RequestMapping("/api")
public class LabTestSampleBatchResource {

    private final Logger log = LoggerFactory.getLogger(LabTestSampleBatchResource.class);

//    @Value("${jhipster.clientApp.name}")
//    private String applicationName;

    @Autowired
    LabTestSampleBatchService labTestSampleBatchService;

    public LabTestSampleBatchResource(LabTestSampleBatchService labTestSampleBatchService) {
        this.labTestSampleBatchService = labTestSampleBatchService;
    }

//    @PostMapping("/lab-test-sample-batches")
//    public ResponseEntity<LabTestSampleBatchDTO> createICTCSampleBatch(@RequestBody CreateSampleBatchDTO batchDetails) throws URISyntaxException {
//        log.debug("REST request to save ICTCSampleBatch : {}", batchDetails);
//        return ResponseEntity.ok()
//            .body(labTestSampleBatchService.createBatch(batchDetails));
//    }

//    @GetMapping("/lab-test-sample-batches/{id}")
//    public ResponseEntity<LabTestSampleBatchDTO> getICTCSampleBatch(@PathVariable Long id) {
//        log.debug("REST request to get ICTCSampleBatch : {}", id);
//        Optional<LabTestSampleBatchDTO> batchOptional = labTestSampleBatchService.findOne(id);
//        return ResponseUtil.wrapOrNotFound(batchOptional);
//    }

}
