package gov.naco.soch.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import gov.naco.soch.domain.ICTCBeneficiary;
import gov.naco.soch.service.BeneficiaryService;
import gov.naco.soch.service.ICTCBeneficiaryQueryService;
import gov.naco.soch.service.ICTCBeneficiaryService;
import gov.naco.soch.service.ICTCBeneficiaryVisitService;
import gov.naco.soch.service.ICTCGeneralService;
import gov.naco.soch.service.ICTCVisitService;
import gov.naco.soch.service.IctcLinkedFacilityService;
import gov.naco.soch.service.dto.BeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryCriteria;
import gov.naco.soch.service.dto.ICTCBeneficiaryDO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCBeneficiaryVisitDTO;
import gov.naco.soch.service.dto.ICTCPregancyFollowUpDTO;
import gov.naco.soch.service.dto.ICTCVisitDTO;
import gov.naco.soch.service.dto.IctcBeneficiaryDeleteDTO;
import gov.naco.soch.service.dto.IctcLinkedFacilityDTO;
import gov.naco.soch.service.dto.UpdateRelationshipDTO;
import gov.naco.soch.service.dto.UpdateTestResultDTO;

/**
 * REST controller for managing {@link gov.naco.soch.domain.ICTCVisit}.
 */
@RestController
@RequestMapping("/api")
public class ICTCGeneralController {

    private final Logger log = LoggerFactory.getLogger(ICTCGeneralController.class);

//    private static final String ENTITY_NAME = "sochictcIctcVisit";

    @Autowired
    ICTCVisitService ictcVisitService;
    @Autowired
    ICTCBeneficiaryService iCTCBeneficiaryService;
    @Autowired
    ICTCBeneficiaryVisitService ictcBeneficiaryVisitService;
    @Autowired
    IctcLinkedFacilityService ictcLinkedFacilityService;
    @Autowired
    BeneficiaryService beneficiaryService;
    @Autowired
    ICTCBeneficiaryQueryService ictcBeneficiaryQueryService;
    @Autowired
    ICTCGeneralService ictcGeneralService;
    
    
    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PostMapping("/ictc-beneficiary")
    public ResponseEntity<ICTCBeneficiaryDTO> createICTCBeneficiary(@Valid @RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
        ICTCBeneficiaryDTO result = ictcGeneralService.createICTCBeneficiary(beneficiaryDO);
        return ResponseEntity.created(new URI("/api/ictc-beneficiary/" + result.getId()))
            .body(result);
    }

    @GetMapping("/ictc-beneficiary-details/{id}")
    public ResponseEntity<ICTCBeneficiaryDO> getBeneficiaryDetails(@PathVariable("id") Long id,
                                                                   @RequestParam(value = "isPregnant", required = false) Boolean isPregnant) {
        return ResponseEntity.ok().body(ictcGeneralService.getICTCBeneficiaryDetails(id, isPregnant));
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PutMapping("/ictc-beneficiary-details")
    public ResponseEntity<ICTCBeneficiaryDO> updateBeneficiaryDetails(@RequestBody ICTCBeneficiaryDO details) {
        return ResponseEntity.ok().body(ictcGeneralService.updateICTCBeneficiaryDetails(details));
    }

    @DeleteMapping("/ictc-beneficiary-details/{id}")
    public ResponseEntity<Void> deleteICTCBeneficiaryDetails(@PathVariable Long id) {
        ictcGeneralService.deleteICTCBeneficiary(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PutMapping("/ictc-sample/result")
    public ResponseEntity<UpdateTestResultDTO> updateICTCSampleCollection(@Valid @RequestBody UpdateTestResultDTO updateTestResultDTO) {
        return ResponseEntity.ok().body(ictcGeneralService.updateTestResult(updateTestResultDTO));
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PutMapping("/ictc-sample/result/revoke/{resultId}")
    public ResponseEntity<Void> updateICTCSampleCollection(@PathVariable Long resultId) {
        ictcGeneralService.revokeTestResult(resultId);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PutMapping("/ictc-post-counselling")
    public ResponseEntity<ICTCBeneficiaryDO> updatePostCounselling(@RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
        log.debug("REST request to update updatePostCounselling : {}", beneficiaryDO);
        return ResponseEntity.ok().body(ictcGeneralService.updatePostCounselling(beneficiaryDO));
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('"+AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PutMapping("/ictc-beneficiary-update-relation")
    public ResponseEntity<ICTCBeneficiaryDTO> updateRelationship(@RequestBody UpdateRelationshipDTO relationship) {
        log.debug("REST request to update updatePostCounselling : {}", relationship);
        return ResponseEntity.ok().body(ictcGeneralService.updateInfantRelationship(relationship));
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PostMapping("/ictc-initiate-follow-up-visit")
    public ResponseEntity<ICTCBeneficiaryDTO> initiateFollowUp(@RequestParam Long followUpId,
                                                               @RequestParam(required = false) Long facilityId) {
        log.debug("REST request to initiate follow up : {}", followUpId);
        return ResponseEntity.ok().body(ictcGeneralService.initiateIctcFollowUpVisit(followUpId, facilityId));
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PostMapping("/ictc-attend-appointment")
    public ResponseEntity<Void> attendAppointment(@RequestParam(required = false) Long ictcBeneficiaryId,
                                                  @RequestParam(required = false) Long facilityId,
                                                  @RequestParam(required = false) Long appointmentId) {
        log.debug("REST request to attend an appointment : {}, {}", ictcBeneficiaryId, facilityId);
        ictcGeneralService.attendAppointment(ictcBeneficiaryId, facilityId, appointmentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ictc-pregnancy-follow-up")
    public ResponseEntity<ICTCPregancyFollowUpDTO> ictcPregnancyFollowUp(@RequestBody ICTCPregancyFollowUpDTO details) {
        log.debug("REST request to update ictcVisitDTO : {}", details);
        return ResponseEntity.ok().body(ictcGeneralService.updatePregrancyFollowUpDetails(details));
    }

    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
            + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
    @PutMapping("/ictc-beneficiary-details/reason")
    public ResponseEntity<Void> deleteICTCBeneficiaryDetailsWithReason(@RequestBody IctcBeneficiaryDeleteDTO ictcBeneficiaryDeleteDTO) {
        ictcGeneralService.deleteIctcBeneficiaryWithReason(ictcBeneficiaryDeleteDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ictc-visit/{id}")
    public ResponseEntity<ICTCBeneficiaryDO> getICTCVisit(@PathVariable Long id) {
        log.debug("REST request to get getICTCVisit beneficiaryId visit : {}", id);
        ICTCBeneficiaryVisitDTO benVisit = ictcBeneficiaryVisitService.findOne(id).get();
        ICTCVisitDTO visit = ictcVisitService.findOne(benVisit.getVisitId()).get();
        ICTCBeneficiaryDTO ictcBeneficiary = iCTCBeneficiaryService.findOne(benVisit.getId()).get();
        BeneficiaryDTO beneficiary = beneficiaryService.findOne(benVisit.getBeneficiaryId()).get();
        ICTCBeneficiaryDO beneficiaryDO = new ICTCBeneficiaryDO();
        beneficiaryDO.setIctcBeneficiary(ictcBeneficiary);
        beneficiaryDO.setVisit(visit);
        beneficiaryDO.setBeneficiary(beneficiary);
        return ResponseEntity.ok().body(beneficiaryDO);
    }

    @PostMapping("/ictc-linked-facility")
    public ResponseEntity<String> saveLinkedFacility(@Valid @RequestBody List<IctcLinkedFacilityDTO> linkedFacilityDTOs) throws URISyntaxException {
        log.debug("REST request to save linkedFacilityDTOs : {}", linkedFacilityDTOs);

        for (IctcLinkedFacilityDTO facilityDTO : linkedFacilityDTOs) {
            ictcLinkedFacilityService.save(facilityDTO);
        }

        return ResponseEntity.created(new URI("/api/ictc-batch/" + linkedFacilityDTOs.size()))
            .body(linkedFacilityDTOs.size() + " SAVED");
    }

    @DeleteMapping("/ictc-beneficiary/{id}")
    public ResponseEntity<Void> deleteICTCBeneficiary(@PathVariable Long id) {
        log.debug("REST request to delete ICTCBeneficiary : {}", id);
        ICTCBeneficiaryDTO beneficiary = iCTCBeneficiaryService.findOne(id).get();
        beneficiary.setIsActive(false);
        beneficiary.setIsDeleted(true);
        iCTCBeneficiaryService.save(beneficiary);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ictc-beneficiaries-list")
    public ResponseEntity<List<ICTCBeneficiary>> getAllICTCBeneficiaries(ICTCBeneficiaryCriteria criteria, Pageable pageable) {
        log.debug("REST request to get ICTCBeneficiaries by criteria: {}", criteria);
        List<ICTCBeneficiary> page = ictcBeneficiaryQueryService.findList(criteria);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/backdateregstatus")
    public Boolean getRegistrationBackDateStatus() {
        log.debug("Inside getRegistrationBackDateStatus");
        return ictcGeneralService.getRegistrationBackDateStatus();
    }

    /**
     *	POST /ictc-beneficiary-details : to create beneficiary
     * 
     * @param beneficiaryDO beneficiaryDO
     * @return
     * @throws URISyntaxException
     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PostMapping("/ictc-beneficiary")
//    public ResponseEntity<ICTCBeneficiaryDTO> createICTCBeneficiary(@Valid @RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
//    	ICTCBeneficiaryDTO result = ictcGeneralService.createICTCBeneficiary(beneficiaryDO);
//        return ResponseEntity.created(new URI("/api/ictc-beneficiary" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//    
//    /**
//     * GET /ictc-beneficiary-details : to get beneficiary details using id
//     * 
//     * @param id id
//     * @return
//     */
//    @GetMapping("/ictc-beneficiary-details/{id}")
//    public ResponseEntity<ICTCBeneficiaryDO> getBeneficiaryDetails(@PathVariable("id") Long id, @RequestParam(value = "isPregnant", required=false) Boolean isPregnant){
//    	return ResponseEntity.ok().body(ictcGeneralService.getICTCBeneficiaryDetails(id, isPregnant));
//    }
//    
//    /**
//     * PUT /ictc-beneficiary-results update beneficiary details
//     * 
//     * @param details details
//     * @return
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PutMapping("/ictc-beneficiary-details")
//    public ResponseEntity<ICTCBeneficiaryDO> updateBeneficiaryDetails(@RequestBody ICTCBeneficiaryDO details){
//    	return ResponseEntity.ok().body(ictcGeneralService.updateICTCBeneficiaryDetails(details));
//    }
//    
//    /**
//     * DELETE /ictc-beneficiary-details : To delete an entity
//     * 
//     * @param id id
//     * @return
//     */
//    @DeleteMapping("/ictc-beneficiary-details/{id}")
//    public ResponseEntity<Void> deleteICTCBeneficiaryDetails(@PathVariable Long id){
//    	ictcGeneralService.deleteICTCBeneficiary(id);
//    	return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
//    
//    /**
//     * PUT /ictc-sample/result : Update beneficiary test result status
//     * 
//     * @param updateTestResultDTO updateTestResultDTO
//     * @return
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PutMapping("/ictc-sample/result")
//    public ResponseEntity<UpdateTestResultDTO> updateICTCSampleCollection(@Valid @RequestBody UpdateTestResultDTO updateTestResultDTO) {
//    	return ResponseEntity.ok().body(ictcGeneralService.updateTestResult(updateTestResultDTO));
//    }
//    
//    /**
//     * PUT /ictc-sample/result/revoke : Revoke beneficiary test result status
//     * 
//     * @param resultId resultId
//     * @return
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PutMapping("/ictc-sample/result/revoke/{resultId}")
//    public ResponseEntity<Void> updateICTCSampleCollection(@PathVariable Long resultId) {
//    	ictcGeneralService.revokeTestResult(resultId);
//    	return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, resultId.toString())).build();
//    }
//    
//    
//    /**
//     * PUT /ictc-post-counselling : Update post test counselling
//     * 
//     * @param beneficiaryDO beneficiaryDO
//     * @return
//     * @throws URISyntaxException
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PutMapping("/ictc-post-counselling")
//    public ResponseEntity<ICTCBeneficiaryDO> updatePostCounselling(@RequestBody ICTCBeneficiaryDO beneficiaryDO) throws URISyntaxException {
//        log.debug("REST request to update updatePostCounselling : {}", beneficiaryDO);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
//            .body(ictcGeneralService.updatePostCounselling(beneficiaryDO));
//    }
//    
//    /**
//     * PUT /ictc-beneficiary-update-relation: Update relation ship
//     * 
//     * @param relationship relationship
//     * @return
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PutMapping("/ictc-beneficiary-update-relation")
//    public ResponseEntity<ICTCBeneficiaryDTO> updateRelationship(@RequestBody UpdateRelationshipDTO relationship) {
//        log.debug("REST request to update updatePostCounselling : {}", relationship);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
//            .body(ictcGeneralService.updateInfantRelationship(relationship));
//    }
//    
//    
//    /**
//     * POST /ictc-initiate-follow-up-visit : To initiate visit after on follow up
//     * 
//     * @param followUpId followUpId
//     * @return
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PostMapping("/ictc-initiate-follow-up-visit")
//    public ResponseEntity<ICTCBeneficiaryDTO> intiateFollowUp(@RequestParam Long followUpId, @RequestParam(required = false) Long facilityId) {
//        log.debug("REST request to initiate follow up : {}", followUpId);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ""))
//            .body(ictcGeneralService.initiateIctcFollowUpVisit(followUpId, facilityId));
//    }
//    
//    /**
//     * POST /ictc-attend-appointment : To attend and appointment
//     * 
//     * @param ictcBeneficiaryId ictcBeneficiaryId
//     * @param facilityId facilityId
//     * @return
//     */
//	@PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('"
//			+ AdminAccessCodes.ICTC_FACILITIES + "') " + "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC
//			+ "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//	@PostMapping("/ictc-attend-appointment")
//	public ResponseEntity<Void> attendAppointment(@RequestParam(required = false) Long ictcBeneficiaryId,
//			@RequestParam(required = false) Long facilityId, @RequestParam(required = false) Long appointmentId) {
//		log.debug("REST request to attend an appointment : {}, {}", ictcBeneficiaryId, facilityId);
//		ictcGeneralService.attendAppointment(ictcBeneficiaryId, facilityId, appointmentId);
//		return ResponseEntity.noContent()
//				.headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, "")).build();
//	}
//    
//    /**
//     * PUT /ictc-pregnancy-follow-up : To update pregnancy details at the time of pregnancy followup
//     * 
//     * @param details details
//     * @return
//     * @throws URISyntaxException
//     */
//    @PutMapping("/ictc-pregnancy-follow-up")
//    public ResponseEntity<ICTCPregancyFollowUpDTO> ictcPregnancyFollowUp(@RequestBody ICTCPregancyFollowUpDTO details) {
//        log.debug("REST request to update ictcVisitDTO : {}", details);
//        return ResponseEntity.ok().body(ictcGeneralService.updatePregrancyFollowUpDetails(details));
//    }
//    
//    
//    /**
//     * PUT /ictc-beneficiary-details/reason : To delete an entity with reason
//     * 
//     * @param ictcBeneficiaryDeleteDTO ictcBeneficiaryDeleteDTO
//     * @return
//     */
//    @PreAuthorize("hasAuthority('" + AdminAccessCodes.ICTC_USERS + "') or hasAuthority('" + AdminAccessCodes.ICTC_FACILITIES + "') "
//    		+ "or hasAuthority('" + AdminAccessCodes.EIDLAB_ICTC + "') or hasAuthority('" + AdminAccessCodes.EIDLAB_USERS + "')")
//    @PutMapping("/ictc-beneficiary-details/reason")
//    public ResponseEntity<Void> deleteICTCBeneficiaryDetailsWithReason(@RequestBody IctcBeneficiaryDeleteDTO ictcBeneficiaryDeleteDTO){
//    	ictcGeneralService.deleteIctcBeneficiaryWithReason(ictcBeneficiaryDeleteDTO);
//    	return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, ictcBeneficiaryDeleteDTO.getIctcBeneficiaryId().toString())).build();
//    }
//    
//
//
//	@GetMapping("/ictc-visit/{id}")
//	public @ResponseBody ResponseEntity<ICTCBeneficiaryDO> getICTCVisit(@PathVariable Long id) {
//		log.debug("REST request to get getICTCVisit beneficiaryId visit : {}", id);
//		ICTCBeneficiaryVisitDTO benVisit = ictcBeneficiaryVisitService.findOne(id).get();
//		ICTCVisitDTO visit = ictcVisitService.findOne(benVisit.getVisitId()).get();
////	        ICTCSampleCollectionDTO sample = iCTCSampleCollectionService.findOne(benVisit.getSampleCollectionId()).get();
//		ICTCBeneficiaryDTO ictcBeneficiary = iCTCBeneficiaryService.findOne(benVisit.getId()).get();
//		BeneficiaryDTO beneficiary = beneficiaryService.findOne(benVisit.getBeneficiaryId()).get();
//		ICTCBeneficiaryDO beneficiaryDO = new ICTCBeneficiaryDO();
//		beneficiaryDO.setIctcBeneficiary(ictcBeneficiary);
////	        beneficiaryDO.setSample(sample);
//		beneficiaryDO.setVisit(visit);
//		beneficiaryDO.setBeneficiary(beneficiary);
//		return ResponseEntity.ok().body(beneficiaryDO);
//	}
//    
//
//	 
//	 @PostMapping("/ictc-linked-facility")
//	    public ResponseEntity<String> saveLinkedFacility(@Valid @RequestBody List<IctcLinkedFacilityDTO> linkedFacilityDTOs) throws URISyntaxException {
//	        log.debug("REST request to save linkedFacilityDTOs : {}", linkedFacilityDTOs);
//	
//	        
//	        for (IctcLinkedFacilityDTO facilityDTO : linkedFacilityDTOs) {
//	        	ictcLinkedFacilityService.save(facilityDTO);
//			}
//
//	        return ResponseEntity.created(new URI("/api/ictc-batch" + linkedFacilityDTOs.size()))
//	            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, linkedFacilityDTOs.size() + "SAVED"))
//	            .body(linkedFacilityDTOs.size() + "SAVED");
//	}
//	 
//	 @DeleteMapping("/ictc-beneficiary/{id}")
//	 public ResponseEntity<Void> deleteICTCBeneficiary(@PathVariable Long id) {
//		 log.debug("REST request to delete ICTCBeneficiary : {}", id);
//		 ICTCBeneficiaryDTO beneficiary = iCTCBeneficiaryService.findOne(id).get();
//		 beneficiary.setIsActive(false);
//		 beneficiary.setIsDeleted(true);
//		 iCTCBeneficiaryService.save(beneficiary);
//		 return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//	 }
//	 
//   @GetMapping("/ictc-beneficiaries-list")
//   public ResponseEntity<List<ICTCBeneficiary>> getAllICTCBeneficiaries(ICTCBeneficiaryCriteria criteria, Pageable pageable) {
//       log.debug("REST request to get ICTCBeneficiaries by criteria: {}", criteria);
//       List<ICTCBeneficiary> page = ictcBeneficiaryQueryService.findList(criteria);
//      // HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//       return ResponseEntity.ok().body(page);
//	}
//
//	@GetMapping("/backdateregstatus")
//	public Boolean getRegistrationBackDateStatus() {
//		log.debug("Inside getRegistrationBackDateStatus ");
//		return ictcGeneralService.getRegistrationBackDateStatus();
//	}

}
