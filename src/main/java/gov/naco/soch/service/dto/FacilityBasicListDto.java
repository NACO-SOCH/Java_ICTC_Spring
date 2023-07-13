package gov.naco.soch.service.dto;

public class FacilityBasicListDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String code;
	private Long facilityTypeId;
	private String facilityTypeName;
	
	public FacilityBasicListDto() {
		super();
	}

	public FacilityBasicListDto(Long id, String name, String code, Long facilityTypeId, String facilityTypeName) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.facilityTypeId = facilityTypeId;
		this.facilityTypeName = facilityTypeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public String getFacilityTypeName() {
		return facilityTypeName;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "FacilityBasicListDto [id=" + id + ", name=" + name + ", code=" + code + ", facilityTypeId="
				+ facilityTypeId + ", facilityTypeName=" + facilityTypeName + "]";
	}

}
