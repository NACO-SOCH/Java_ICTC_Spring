package gov.naco.soch.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.DefaultFacilityDto;
import gov.naco.soch.dto.IctcSearchResultDTO;
import gov.naco.soch.dto.NewICTCDto;
import gov.naco.soch.service.NewICTCService;

@RestController
@RequestMapping("/ictc")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewICTCController {
	
	private static final String HEADER_X_TOTAL_COUNT = "X-Total-Count";
	@Autowired
	private NewICTCService service;
	
    @GetMapping("/ictc-visit-list/basic")
    public ResponseEntity<List<NewICTCDto>> getAllICTCBeneficiaryVisitsBasic(@RequestParam("page") Integer page1, @RequestParam("size") Integer size, @RequestParam(name = "categoryId.notEquals", required = false) Integer notEqualsCategoryId,
            @RequestParam(name = "categoryId.equals", required = false) Integer equalsCategoryId,
            @RequestParam("facilityId.equals") int equalsFacilityId,@RequestParam ("sort") String sortBy,
            @RequestParam(value = "pid.contains", defaultValue = "") String pid, @RequestParam(value = "mobileNumber.contains", defaultValue = "") String mobile, @RequestParam(value = "firstName.contains", defaultValue = "") String firstName ) {
    	
    	if (page1 == null || size == null) {
    		page1 = 0;
    	}
    	Pageable pageable = PageRequest.of(page1, size, Sort.by("id").descending());
    	
    	int totalListCount=service.findCount(equalsFacilityId, notEqualsCategoryId,equalsCategoryId);
        List<NewICTCDto> page= service.findByCriteriaBasic(equalsFacilityId,notEqualsCategoryId,equalsCategoryId,  pid, mobile, firstName, pageable);
         
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", HEADER_X_TOTAL_COUNT);
        headers.add(HEADER_X_TOTAL_COUNT, ""+totalListCount);
        return ResponseEntity.ok().headers(headers).body(page);

    }
    
    @GetMapping("/ictc-test-result-views/basic")
    public ResponseEntity<List<NewICTCDto>> getAllICTCTestResultViewsBasic(@RequestParam("page") Integer page1,
            @RequestParam(name="testType.in" ) String testType,
            @RequestParam(name = "categoryId.equals", required = false) Integer equalsCategoryId,
            @RequestParam("facilityId.equals") int equalsFacilityId,
            @RequestParam ("sort") String sortBy ) {  	
    	if (page1 == null ) {
    		page1 = 0;
    	}
    	Pageable pageable = PageRequest.of(page1, 10, Sort.by("id").descending());

    	List<NewICTCDto> page= service.getTestResult(equalsFacilityId,equalsCategoryId, testType , pageable);
         
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", HEADER_X_TOTAL_COUNT);
        return ResponseEntity.ok().headers(headers).body(page);

    }
    
    @GetMapping("/ictc-test-result-views/advanced")
    public ResponseEntity<List<NewICTCDto>> getAllICTCTestResultViewsAdvance(@RequestParam("page") Integer page1,
            @RequestParam(name="testType.in" ) String testType,
            @RequestParam(name = "sampleCollectionStatus.notEquals", required = false) Integer equalsCategoryId,
            @RequestParam("facilityId.equals") int equalsFacilityId,
            @RequestParam ("sort") String sortBy ) {  	
    	if (page1 == null ) {
    		page1 = 0;
    	}
    	Pageable pageable = PageRequest.of(page1, 10, Sort.by("id").descending());

    	List<NewICTCDto> page= service.getTestResultAdvacne(equalsFacilityId,equalsCategoryId, testType , pageable);
         
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", HEADER_X_TOTAL_COUNT);
        return ResponseEntity.ok().headers(headers).body(page);

    }
    
    //dsrc
    
    @GetMapping("/ictc-counselling-list/basic")
	public ResponseEntity <List<DefaultFacilityDto>> ictcCouncelling(
      @RequestParam(defaultValue = "0") Integer page,
	  @RequestParam(defaultValue = "10") Integer size,
	  @RequestParam(name = "categoryId.notEquals", required = false) Integer categoryIdNotEquals,
	  @RequestParam(name = "beneficiaryStatus.equals", required = false) Integer beneficiaryStatusEquals,
	  @RequestParam(name = "isConsentDocumented.equals", required = false) Boolean isConsentDocumentedEquals,
	  @RequestParam(name = "facilityId.equals", required = false) Integer facilityIdEquals,
	  @RequestParam(name = "isPostTestCounsellingCompleted.equals", required = false) Boolean isPostTestCounsellingCompletedEquals,
	  @RequestParam(name = "pid.contains", defaultValue = " " ,required = false) String pid ,
	  @RequestParam(name = "sort", defaultValue = "id,desc") String[] sort)
		{
		
		if (page == null || size == null) {
			page = 0;
    	}
		
		
		int totalListCount=service.countList(facilityIdEquals, beneficiaryStatusEquals,categoryIdNotEquals);
		
    	Pageable pageable = PageRequest.of(page, size, Sort.by("beneficiaryId").descending());
    	
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Expose-Headers", HEADER_X_TOTAL_COUNT);
        headers.add(HEADER_X_TOTAL_COUNT, ""+totalListCount);
    
    	List<DefaultFacilityDto> page1= service.getQueryData(facilityIdEquals,beneficiaryStatusEquals,isPostTestCounsellingCompletedEquals, categoryIdNotEquals, page ,size,pid, pageable);
    
        return ResponseEntity.ok().headers(headers).body(page1);	
        
	}
	
	
	@GetMapping("/art-beneficiary-search")
	public ResponseEntity<List<IctcSearchResultDTO>> ictcMotherName(@RequestParam(required = true) Long facilityID, @RequestParam(required = true) String search){
		List<IctcSearchResultDTO> ictcSearchResultDTO = service.findArtBeneficiariesByBasicSearch(facilityID,search);
		return  ResponseEntity.ok().body(ictcSearchResultDTO);
		
	}
    

}
