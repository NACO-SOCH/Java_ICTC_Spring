package gov.naco.soch.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.projection.MinimasterProjection;
import gov.naco.soch.service.MinimasterService;
import gov.naco.soch.service.dto.MinimasterResponseDto;

@RestController
@RequestMapping("/api")
public class MinimasterController {
	
	private final MinimasterService minimasterService;

	public MinimasterController(MinimasterService minimasterService) {
		this.minimasterService = minimasterService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@GetMapping("/minimaster/{tableName}")
	public List<MinimasterProjection> get(@PathVariable String tableName)
	{
		return minimasterService.get(tableName);
			
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	@GetMapping("/minimasters")
	public MinimasterResponseDto get()
	{
		System.out.println("minimasters calling .....");
		return minimasterService.get();
			
	}
	

}
