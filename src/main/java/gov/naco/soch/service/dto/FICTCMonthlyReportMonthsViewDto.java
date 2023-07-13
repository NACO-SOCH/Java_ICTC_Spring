
package gov.naco.soch.service.dto;

public class FICTCMonthlyReportMonthsViewDto {

	private Long id;
	private Integer monthNumber;
	private String monthName;
	private Integer year;
	private Boolean edited;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(Integer monthNumber) {
		this.monthNumber = monthNumber;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Boolean isEdited() {
		return edited;
	}
	public void setEdited(Boolean edited) {
		this.edited = edited;
	}
	
	
}
