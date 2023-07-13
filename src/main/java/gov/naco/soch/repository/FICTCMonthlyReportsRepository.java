package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.domain.FICTCMonthlyReportEntity;

/**
 * Spring Data repository for the FICTC monthly report entity.
 */
public interface FICTCMonthlyReportsRepository
		extends JpaRepository<FICTCMonthlyReportEntity, Long>, JpaSpecificationExecutor<FICTCMonthlyReportEntity> {

	@Query(nativeQuery = true, value = "select * from soch.fictc_monthly_report where created_by = :userId and id = :reportId")
	FICTCMonthlyReportEntity getDetailsOfMonthlyReport(@Param("userId") Long userId, @Param("reportId") Long reportId);
	
	@Query(nativeQuery = true, value = "select * from soch.fictc_monthly_report where created_by = :userId order by report_year, report_month DESC")
	List<FICTCMonthlyReportEntity> getAllMonthlyReportsForUser(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select * from soch.fictc_monthly_report where"
			+ " facility_id=:facilityId and report_year=:reportYear and report_month=:reportMonth and report_status=true"
			+ " order by report_year, report_month DESC")
	FICTCMonthlyReportEntity getFictcMonthlyReportWeb(@Param("facilityId") Integer facilityId,
			@Param("reportYear") Integer reportYear, @Param("reportMonth") Integer reportMonth);

}
