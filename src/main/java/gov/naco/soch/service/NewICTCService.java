package gov.naco.soch.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import gov.naco.soch.dto.DefaultFacilityDto;
import gov.naco.soch.dto.IctcSearchResultDTO;
import gov.naco.soch.dto.NewICTCDto;
import gov.naco.soch.repository.DsrcDefaultFacilityLinkedFacilityRepository;
import gov.naco.soch.repository.PrisonResultRepository;

@Transactional
@Service
public class NewICTCService {
	
	
    @Autowired
    private DsrcDefaultFacilityLinkedFacilityRepository dsrcDefaultFacilityLinkedFacilityRepository;
    
    @Autowired
	private PrisonResultRepository ictc;
	
	Logger log = LoggerFactory.getLogger (NewICTCService.class);
	
	
	public Integer findCount(Integer equalsFacilityId, Integer notEqualsCategoryId,Integer equalsCategoryId) {
		if(notEqualsCategoryId != null) {
			return ictc.countOfBeneficiaryNotCategory(equalsFacilityId, notEqualsCategoryId);
		}
		else {
			return ictc.countOfBeneficiary(equalsFacilityId, equalsCategoryId);
		}
		
	}
	
	public List<NewICTCDto> findByCriteriaBasic(int equalsFacilityId, Integer notEqualsCategoryId,Integer equalsCategoryId, String pid, String mobile, String firstName , Pageable page) {
		
		Integer categoryId = notEqualsCategoryId != null ? notEqualsCategoryId : equalsCategoryId;
		log.info("params"+  pid, mobile, firstName);

		List<Object[]> obj;
		if(notEqualsCategoryId != null) {
			//not equal wala case hai <>
			obj= ictc.listOfBeneficiaryNotCategory(equalsFacilityId, categoryId, "%"+pid+"%", page );
		}
		else {
			// equal wala case hai =
			obj= ictc.listOfBeneficiary(equalsFacilityId, categoryId, "%"+pid+"%", page );
		}
		
		log.info("Obj Size : {}" + obj.size());
		List<NewICTCDto> dtoList = new ArrayList<>();
		dtoList = obj.stream()
			    .map(dto -> {
			    	
			    	NewICTCDto mapper = new NewICTCDto();
		        	try {
			    	
		        	//important
		        	mapper.setId(dto[0] != null ? ((Integer) dto[0]).intValue() : null);
		        	mapper.setUid(dto[1] != null ? (String) dto[1] : null);
		        	mapper.setPid(dto[2] != null ? (String) dto[2] : null);
		        	mapper.setFirstName(dto[3] != null ? (String) dto[3] : null);
		        	mapper.setMiddleName(dto[4] != null ? (String) dto[4] : null);
		        	mapper.setLastName(dto[5] != null ? (String) dto[5] : null);
		        	mapper.setVisitDate(dto[6] != null ? (Date) dto[6] : null);
		        	mapper.setBeneficiaryId(dto[7] != null ? ((Integer) dto[7]).intValue() : null);
		        	mapper.setMobileNumber(dto[8] != null ? (String) dto[8] : null);
		        	mapper.setAge(dto[9] != null ? (String) dto[9] : null);
		        	
		        	mapper.setGenderId(dto[18] != null ? ((Integer) dto[18]).intValue() : null);
		        	
		        	mapper.setIsPregnant(dto[10] != null ? (Boolean) dto[10] : null);
		        	mapper.setTestedDate(dto[11] != null ? (Date) dto[11] : null);
		        	mapper.setHivStatus(dto[12] != null ? ((Integer) dto[12]).intValue() : null);
	        		mapper.setHivType(dto[13] != null ? ((Integer) dto[13]).intValue() : null);
	        		mapper.setDateOfBirth(dto[14] != null ? (Date) dto[14] : null); 
		        	mapper.setResultStatus(dto[15] != null ? ((Integer) dto[15]).intValue() : null);
	        		mapper.setVisitId(dto[16] != null ? ((Integer) dto[16]).intValue() : null);
	        		mapper.setBeneficiaryStatus(dto[17] != null ? ((Integer) dto[17]).intValue() : null);
	        		mapper.setGenderId(dto[18] != null ? ((Integer) dto[18]).intValue() : null);
	        		mapper.setIsActive(dto[19] != null ? (Boolean) dto[19] : null);
	        		mapper.setIsDeleted(dto[20] != null ? (Boolean) dto[20] : null);
	        		mapper.setDeletedReason(dto[21] != null ? ((Integer) dto[21]).intValue() : null);
	        		
	        		mapper.setDeletedReasonComment(dto[22] != null ? (String) dto[22] : null);
	        		mapper.setRegisteredFacilityId(dto[23] != null ? ((Integer) dto[23]).intValue() : null);
	        		mapper.setBeneficiaryStatusDesc(dto[24] != null ? (String) dto[24] : null);
	        		mapper.setHivStatusDesc(dto[25] != null ? (String) dto[25] : null);
	        		mapper.setInfantCode(dto[26] != null ? (String) dto[26] : null);
		        	}catch(Exception ex) {
		        		ex.getMessage();
		        	}
		            return mapper;
		        })
		        .collect(Collectors.toList());
	
//		Page<NewICTCDto> visitDTOPage = new PageImpl<>(dtoList, page, dtoList.size());

		return dtoList;
		
	}
	
	
	public List<NewICTCDto> getTestResult(int equalsFacilityId,Integer equalsCategoryId, String testType , Pageable page){
		
		List<Object[]> obj; 
		
		obj = ictc.listOfICTCResultView(equalsFacilityId, page);
		
		List<NewICTCDto> dtoList = new ArrayList<>();
		dtoList = obj.stream()
			    .map(dto -> {
			    	
			    	NewICTCDto mapper = new NewICTCDto();
		        	try {
		        		
		        		mapper.setAge(dto[6] != null ? (String) dto[6] : null);
		        		
		        		mapper.setId(dto[0] != null ? ((Integer) dto[0]).intValue() : null);
		        		mapper.setPid(dto[1] != null ? (String) dto[1] : null);
		        		mapper.setUid(dto[2] != null ? (String) dto[2] : null);
		        		mapper.setFirstName(dto[3] != null ? (String) dto[3] : null);
		        		mapper.setMiddleName(dto[4] != null ? (String) dto[4] : null);
		        		mapper.setLastName(dto[5] != null ? (String) dto[5] : null);
		        		mapper.setAge(dto[6] != null ? (String) dto[6] : null);
		        		mapper.setSampleCollectionDate(dto[7] != null ? (Date) dto[7] : null);
		        		mapper.setTestType(dto[8] != null ? ((Integer) dto[8]).intValue() : null);
		        		mapper.setTestTypeDesc(dto[9] != null ? (String) dto[9] : null);
		        		mapper.setResultStatus(dto[10] != null ? ((Integer) dto[10]).intValue() : null);
		        		mapper.setResultStatus1(dto[11] != null ? (String) dto[11] : null);
		        		//12 is null
		        		mapper.setHivStatusDesc(dto[13] != null ? (String) dto[13] : null);
		        		//14 is null
		        		mapper.setHivTypeDesc(dto[15] != null ? (String) dto[15] : null);
		        		//16 is null
		        		//17 is null
		        		//18 is null
		        		mapper.setConsignmentId(dto[19] != null ? ((String) dto[19]) : null);
		        		mapper.setBeneficiaryId(dto[20] != null ? ((Integer) dto[20]).intValue() : null);
		        		mapper.setIctcBeneficiaryId(dto[21] != null ? ((Integer) dto[21]).intValue() : null) ;
		        		mapper.setVisitId(dto[22] != null ? ((Integer) dto[22]).intValue() : null);
		        		mapper.setDateOfBirth(dto[23] != null ? (Date) dto[23] : null);
		        		//24 is null
		        		//25 is null
		        		//26 is null
		        		//27 is null
		        		//28 is null
		        		mapper.setFollowUpDate(dto[29] != null ? (Date) dto[29] : null) ;
		        		//30 is null
		        		//31 is null
		        		mapper.setReportReceivedDate(dto[32] != null ? (Date) dto[32] : null) ;
		        		//33 is null
		        		//34 is null
		        		mapper.setLabName(dto[33] != null ? ((String) dto[33]) : null) ;
		        		//36 is null
		        		//37 is null
		        		//38 is null
		        		mapper.setGenderId(dto[39] != null ? ((Integer) dto[39]).intValue() : null);
		        		//40 is null
		        		mapper.setInfantCode(dto[41] != null ? (String) dto[41] : null);
		        		//42 is null
		        		//43 is null
		        		//44 is null
		        		mapper.setHivType(dto[45] != null ? ((Integer) dto[45]).intValue() : null) ;
		        		                            
		        	}catch(Exception ex) {
		        		ex.getMessage();
		        	}
		            return mapper;
		        })
		        .collect(Collectors.toList());
		
		return dtoList;
	}
	
public List<NewICTCDto> getTestResultAdvacne(int equalsFacilityId,Integer equalsCategoryId, String testType , Pageable page){
		
		List<Object[]> obj; 
		
		obj = ictc.listOfICTCResultViewAdv(equalsFacilityId, page);
		
		List<NewICTCDto> dtoList = new ArrayList<>();
		dtoList = obj.stream()
			    .map(dto -> {
			    	
			    	NewICTCDto mapper = new NewICTCDto();
		        	try {
		        		
		        		mapper.setAge(dto[6] != null ? (String) dto[6] : null);
		        		
		        		mapper.setId(dto[0] != null ? ((Integer) dto[0]).intValue() : null);
		        		mapper.setPid(dto[1] != null ? (String) dto[1] : null);
		        		mapper.setUid(dto[2] != null ? (String) dto[2] : null);
		        		mapper.setFirstName(dto[3] != null ? (String) dto[3] : null);
		        		mapper.setMiddleName(dto[4] != null ? (String) dto[4] : null);
		        		mapper.setLastName(dto[5] != null ? (String) dto[5] : null);
		        		mapper.setAge(dto[6] != null ? (String) dto[6] : null);
		        		mapper.setSampleCollectionDate(dto[7] != null ? (Date) dto[7] : null);
		        		
		        		mapper.setConsignmentId(dto[19] != null ? ((String) dto[19]) : null);
		        		mapper.setLabName(dto[35] != null ? ((String) dto[35]) : null) ;
		        		//8 is null
		        		mapper.setTestTypeDesc(dto[9] != null ? (String) dto[9] : null);
		        		//10 is null
		        		mapper.setResultStatus1(dto[11] != null ? (String) dto[11] : null);
		        		//12 is null
		        		mapper.setHivStatusDesc(dto[13] != null ? (String) dto[13] : null);
		        		//14 is null
		        		mapper.setHivTypeDesc(dto[15] != null ? (String) dto[15] : null);
		        		//16 is null
		        		//17 is null
		        		//18 is null
		        		
		        		mapper.setBeneficiaryId(dto[20] != null ? ((Integer) dto[20]).intValue() : null);
		        		mapper.setIctcBeneficiaryId(dto[21] != null ? ((Integer) dto[21]).intValue() : null) ;
		        		mapper.setVisitId(dto[22] != null ? ((Integer) dto[22]).intValue() : null);
		        		mapper.setDateOfBirth(dto[23] != null ? (Date) dto[23] : null);
		        		//24 is null
		        		//25 is null
		        		//26 is null
		        		//27 is null
		        		//28 is null
		        		mapper.setFollowUpDate(dto[29] != null ? (Date) dto[29] : null) ;
		        		//30 is null
		        		//31 is null
		        		mapper.setReportReceivedDate(dto[32] != null ? (Date) dto[32] : null) ;
		        		//33 is null
		        		//34 is null
		        		
		        		//36 is null
		        		//37 is null
		        		mapper.setGenderId(dto[39] != null ? ((Integer) dto[39]).intValue() : null);
		        		//40 is null
		        		mapper.setInfantCode(dto[41] != null ? (String) dto[41] : null);
		        		//42 is null
		        		//43 is null
		        		//44 is null
		        		mapper.setHivType(dto[45] != null ? ((Integer) dto[45]).intValue() : null) ;                             
		        	}catch(Exception ex) {
		        		ex.getMessage();
		        	}
		            return mapper;
		        })
		        .collect(Collectors.toList());
		
		return dtoList;
	}

public List<DefaultFacilityDto> getQueryData(Integer facilityId, Integer beneficiary_status,Boolean isPostTestCounsellingCompleted, Integer categoryId,
		Integer pageNumber, Integer pageSize, String searchParam,Pageable pageable){
	
		log.debug("Entering into ictc method");
		
		if (pageSize != null && pageNumber != null) {
			pageable = PageRequest.of(pageNumber, pageSize);
		} else {
			pageable = PageRequest.of(0, 10);
		}
		List<Object[]> obj = new ArrayList<>();
		log.debug(""+facilityId, beneficiary_status, isPostTestCounsellingCompleted, categoryId ,pageable);
		searchParam ='%' + searchParam.toLowerCase().trim() + '%';
		obj = dsrcDefaultFacilityLinkedFacilityRepository.findDataic1(facilityId, beneficiary_status, categoryId, searchParam ,pageable);
		List<DefaultFacilityDto> dtoList = new ArrayList<>();
		dtoList = obj.stream()
			    .map(dto -> {
			    	
			    	DefaultFacilityDto mapper = new DefaultFacilityDto();
		        	try {
		        		
		        		
		        		mapper.setId(dto[0] != null ? ((Integer) dto[0]).intValue() : null);

		        		mapper.setUid(dto[1] != null ? dto[1].toString() : null);
		        		mapper.setPid(dto[2] != null ? dto[2].toString() : null);

		        		mapper.setFirstName(dto[3] != null ? dto[3].toString() : null);
		        		mapper.setMiddleName(dto[4] != null ? dto[4].toString() : null);
		        		mapper.setLastName(dto[5] != null ? dto[5].toString() : null);

		        		mapper.setGenderId(dto[6] != null ? ((Integer) dto[6]).intValue() : null);
		        		mapper.setAge(dto[7] != null ? dto[7].toString() : null);
		        		mapper.setDateOfBirth(dto[8] != null ? (Date) dto[8] : null);

		        		mapper.setMobileNumber(dto[9] != null ? dto[9].toString() : null);

		        		mapper.setVisitDate(dto[10] != null ? (Date) dto[10] : null);
		        		mapper.setTestedDate(dto[11] != null ? (Date) dto[11] : null);
		        		mapper.setReportReceivedDate(dto[12] != null ? (Date) dto[12] : null);
		        		mapper.setHivStatus(dto[13] != null ? ((Integer) dto[13]).intValue() : null);
		        		mapper.setHivType(dto[14] != null ? ((Integer) dto[14]).intValue() : null);
		        		mapper.setResultStatus(dto[15] != null ? ((Integer) dto[15]).intValue() : null);
		        		mapper.setHivStatusDesc(dto[16] != null ? dto[16].toString() : null);
		        		mapper.setCurrentResultId(dto[17] != null ? ((Integer) dto[17]).intValue() : null);

		        		
		        	}catch(Exception ex) {
		        		ex.getMessage();
		        	}
		            return mapper;
		        })
		        .collect(Collectors.toList());
	
		return dtoList;
	}


   public Integer countList(Integer facilityId, Integer beneficiary_status,Integer categoryId) {
			if(beneficiary_status == 2) {
				return dsrcDefaultFacilityLinkedFacilityRepository.countPostTestCouncelling(facilityId,beneficiary_status, categoryId);
			}
			else {
				return dsrcDefaultFacilityLinkedFacilityRepository.countPreTestCouncelling(facilityId,beneficiary_status, categoryId);
			}
   }
   
   public List<IctcSearchResultDTO>findArtBeneficiariesByBasicSearch( Long facilityID, String search) {
	   List<Object[]> obj = new ArrayList<>();
	   List<IctcSearchResultDTO> searchResultList = new ArrayList<>();
	   obj = dsrcDefaultFacilityLinkedFacilityRepository.findArtBeneficiaryWithTsVector(facilityID, search);
	   log.info(obj.size()+"size");
	   
	   for (Object[] dto : obj) {
		   log.info("size2");
		   IctcSearchResultDTO ictcSearchResultDTO = new IctcSearchResultDTO();
		   try { 
    		   ictcSearchResultDTO.setBeneficiaryId(dto[0] != null ? (Integer) dto[0] : null);
    		   ictcSearchResultDTO.setUid(dto[1] != null ? (String) dto[1] : null);
    		   ictcSearchResultDTO.setFirstName(dto[2] != null ? (String) dto[2] : null);
    		   ictcSearchResultDTO.setMiddleName(dto[3] != null ? (String) dto[3] : null);
    		   ictcSearchResultDTO.setLastName(dto[4] != null ? (String) dto[4] : null);
    		   ictcSearchResultDTO.setGender(dto[5] != null ? (String) dto[5] : null);
    		   ictcSearchResultDTO.setMobileNumber(dto[6] != null ? (String) dto[6] : null);
    		   ictcSearchResultDTO.setDateOfBirth(dto[7] != null ? (Date) dto[7] : null);
    		   ictcSearchResultDTO.setOldPreArtNumber(null);
    		   ictcSearchResultDTO.setOldArtNumber(null);
    		   ictcSearchResultDTO.setPreArtNumber(dto[10] != null ? (String) dto[10] : null);
    		   ictcSearchResultDTO.setArtNumber(dto[11] != null ? (String) dto[11] : null);
    		   ictcSearchResultDTO.setStatus(dto[12] != null ? (String) dto[12] : null);
    		   ictcSearchResultDTO.setLacLinked(dto[13] != null ? (Boolean) dto[13] : null);
    		   ictcSearchResultDTO.setIsTransit(dto[14] != null ? (Boolean) dto[14] : null);
    		   ictcSearchResultDTO.setrSeq(dto[15] != null ? (Date) dto[15] : null);
    		   ictcSearchResultDTO.setArtTransferStatus(null);
    		   ictcSearchResultDTO.setTransferredTo(null);
    		   searchResultList.add(ictcSearchResultDTO);
		   }catch(Exception ex) {
        		ex.getMessage();
        	}       
	    }
	return searchResultList;
	
	
   }
	
}
