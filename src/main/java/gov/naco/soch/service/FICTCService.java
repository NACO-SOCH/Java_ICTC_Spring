
package gov.naco.soch.service;

import java.util.List;
import java.util.Optional;

import gov.naco.soch.domain.FictcBeneficiary;
import gov.naco.soch.projection.FICTCBeneficiaryProjection;
import gov.naco.soch.service.dto.FICTCMonthlyReportMonthsViewResponseDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportRequestDto;
import gov.naco.soch.service.dto.FICTCMonthlyReportResponseDto;
import gov.naco.soch.service.dto.FICTCOutReferralHistoryRequestDto;
import gov.naco.soch.service.dto.FICTCOutReferralHistoryResponseDto;
import io.undertow.util.BadRequestException;

public interface FICTCService {

	//FictcBeneficiary saveBeneficiaryForFictc(FICTCBeneficiaryRequestDto fictcBeneficiaryRequestDto);
	List<FICTCBeneficiaryProjection> getAllInProgressBeneficiariesForFictc();
	Optional<FictcBeneficiary> getBeneficiariesDetailById(Long id);
	int markBeneficiaryAsDeleted(Long id);


	FICTCMonthlyReportResponseDto saveMonthlyReportsForFictc(FICTCMonthlyReportRequestDto fictcMonthlyReportDto) throws BadRequestException;
	FICTCMonthlyReportResponseDto getDetailsOfMonthlyReport(Long id);
	
	List<FICTCOutReferralHistoryResponseDto> outReferralHistoryReport(FICTCOutReferralHistoryRequestDto requestDto);
	FICTCMonthlyReportMonthsViewResponseDto showMonthsToView();

	FICTCMonthlyReportResponseDto getDetailsOfMonthlyReportWeb(Integer facilityId, Integer reportYear,
			Integer reportMonth);

}
