package gov.naco.soch.service.dto;

import java.util.List;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.domain.LabTestSample;

public class IctcTestResultHistoryDTO {
	
	private List<ICTCTestResult> testResults;
	
	private Beneficiary motherDetails;
	
	private LabTestSample labTestSample;
	
	private Long currentResultId;

	public Beneficiary getMotherDetails() {
		return motherDetails;
	}

	public void setMotherDetails(Beneficiary motherDetails) {
		this.motherDetails = motherDetails;
	}

	public List<ICTCTestResult> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<ICTCTestResult> testResults) {
		this.testResults = testResults;
	}

	public LabTestSample getLabTestSample() {
		return labTestSample;
	}

	public void setLabTestSample(LabTestSample labTestSample) {
		this.labTestSample = labTestSample;
	}

	public Long getCurrentResultId() {
		return currentResultId;
	}

	public void setCurrentResultId(Long currentResultId) {
		this.currentResultId = currentResultId;
	}

}