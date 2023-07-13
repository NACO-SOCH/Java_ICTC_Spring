
package gov.naco.soch.service.dto;

import java.util.List;

public class FICTCMonthlyReportMonthsViewResponseDto {

	private List<FICTCMonthlyReportMonthsViewDto> prepareReports;
	private List<FICTCMonthlyReportMonthsViewDto> submittedReports;
	public List<FICTCMonthlyReportMonthsViewDto> getPrepareReports() {
		return prepareReports;
	}
	public void setPrepareReports(List<FICTCMonthlyReportMonthsViewDto> prepareReports) {
		this.prepareReports = prepareReports;
	}
	public List<FICTCMonthlyReportMonthsViewDto> getSubmittedReports() {
		return submittedReports;
	}
	public void setSubmittedReports(List<FICTCMonthlyReportMonthsViewDto> submittedReports) {
		this.submittedReports = submittedReports;
	}
	
	

}
