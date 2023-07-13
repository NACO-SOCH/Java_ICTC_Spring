
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.domain.FictcBeneficiary;
import gov.naco.soch.projection.FICTCBeneficiaryProjection;

/**
 * Spring Data repository for the FICTC beneficiary entity.
 */
@Repository
public interface FICTCBeneficiaryEntityRepository
		extends JpaRepository<FictcBeneficiary, Long>, JpaSpecificationExecutor<FictcBeneficiary> {

	@Query( "select fb.id as id, fb.beneficiary.firstName as firstName, fb.beneficiary.middleName as middleName, \r\n" + 
			"fb.beneficiary.lastName as lastName \r\n" + 
			"from FictcBeneficiary fb \r\n" + 
			"where \r\n" + 
			"fb.createdBy=:createdBy \r\n" + 
			"and fb.profileStatus is false \r\n" + 
			"and fb.isDelete is false \r\n" + 
			"order by fb.createdTime desc")
	List<FICTCBeneficiaryProjection> getAllInProgressBeneficiariesForFictc(@Param("createdBy") Long createdBy);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update soch.fictc_beneficiary set is_delete = true where id = :id")
	int markBeneficiaryAsDeleted(@Param("id") Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM soch.fictc_beneficiary \r\n" + 
			"WHERE \r\n" + 
			"extract(month FROM hiv_screening_date) = :month \r\n" + 
			"and extract(year FROM hiv_screening_date) = :year \r\n" + 
			"and facility_id = :referredFrom and profile_status = true")
	List<FictcBeneficiary> outReferralHistoryDataForAllIctc(@Param("month")int month, @Param("year")int year, @Param("referredFrom")Long referredFrom);

}
