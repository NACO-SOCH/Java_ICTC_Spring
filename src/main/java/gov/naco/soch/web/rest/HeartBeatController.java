package gov.naco.soch.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.repository.MasterDataRepository;
import gov.naco.soch.scheduler.BeneficiaryReferralStatusUpdateScheduler;
import gov.naco.soch.service.FacilityService;
import gov.naco.soch.service.dto.FacilityBasicListDto;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;

@RestController
@RequestMapping("/api")
public class HeartBeatController {
	
	@Value("${accessKey}")
	private String access;
	
	@Autowired
	MasterDataRepository repo;
	
	@Autowired
	FacilityService facilityService;
	
	@Autowired
	BeneficiaryReferralStatusUpdateScheduler referralStatusUpdateScheduler;
	
	private final Logger log = LoggerFactory.getLogger(HeartBeatController.class);
	
	@GetMapping("/test")
	public List<FacilityBasicListDto> checkStatus(@RequestParam Long facilityId, @RequestParam(required = false) Long labTypeId) {
		return facilityService.findAllLabsMappedToICTC(facilityId, labTypeId);
	}
	
	@GetMapping("/run/batch")
	public ResponseEntity<String> runBatch(@RequestParam(required = false) String accessKey) {
		if(access.equals(accessKey)) {
			log.warn("JOB-->referralStatusChange from API job started");
			referralStatusUpdateScheduler.updateStatus();
			log.warn("JOB-->referralStatusChange from API job ended");
		} else {
			throw new BadRequestAlertException("Invalid Key", "BATCH-SCHEDULER", "INVALID_KEY");
		}
		return ResponseEntity.ok().body("SUCCESS");
	}

}
