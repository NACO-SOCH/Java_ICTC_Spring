package gov.naco.soch.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.projection.InventoryProjection;
import gov.naco.soch.projection.StatisticsProjection;

@Repository
public interface ICTCDashBordRepository extends JpaRepository<Beneficiary, Long> {

	@Query(value = "select regclient_pw,regclient_gc,regclient_infant,hiv_pw,hiv_gc,hiv_infant,artlinked_pw,artlinked_gc,artlinked_infant,\r\n"
			+ "coalesce((case when (artlinked_count = 0 and  artreferred_count = 0) \r\n"
			+ "then 0 when (artlinked_count>0) then cast((cast(artlinked_count as float)/cast(artlinked_count+artreferred_count as float))*100 as int8) else 0 end),0) as link_percentage\r\n"
			+ "from soch.summarydataictc(:facilityId)", nativeQuery = true)
	Object getSummaryData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn \n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\t\n" +
        "LEFT JOIN soch.ictc_visit iv ON ibn.recent_visit_id = iv.id\t\n" +
        "WHERE ibn.facility_id =:facilityId and ibn.referred_by=1 and bn.hiv_status_id = 2 and ibn.is_active = true and ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM iv.visit_date) =:filterYear and EXTRACT(MONTH FROM iv.visit_date) =:filterMonth ")
	List<BigInteger> getSelfInitiatedCountForPositive(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn\n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\n" +
        "LEFT JOIN soch.ictc_visit iv ON ibn.recent_visit_id = iv.id\t\n" +
        "WHERE ibn.facility_id =:facilityId and ibn.referred_by=1 and bn.hiv_status_id = 1 and ibn.is_active = true and ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM iv.visit_date) =:filterYear and EXTRACT(MONTH FROM iv.visit_date) =:filterMonth")
	List<BigInteger> getSelfInitiatedCountForNegative(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn\n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\n" +
        "LEFT JOIN soch.ictc_visit iv ON ibn.recent_visit_id = iv.id\t\n" +
        "WHERE ibn.facility_id =:facilityId and ibn.referred_by=1 and bn.hiv_status_id = 3 and ibn.is_active = true and ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM iv.visit_date) =:filterYear and EXTRACT(MONTH FROM iv.visit_date) =:filterMonth")
	List<BigInteger> getSelfInitiatedCountForIntermediate(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn\n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\n" +
        "LEFT JOIN soch.ictc_visit iv ON ibn.recent_visit_id = iv.id\t\n" +
        "WHERE ibn.facility_id=:facilityId and ibn.referred_by<>1 and bn.hiv_status_id = 1 and ibn.is_active = true AND ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM iv.visit_date) =:filterYear and EXTRACT(MONTH FROM iv.visit_date) =:filterMonth")
	List<BigInteger> getProviderInitiatedCountForNegative(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn\n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\n" +
        "LEFT JOIN soch.ictc_visit iv ON ibn.recent_visit_id = iv.id\t\n" +
        "WHERE ibn.facility_id=:facilityId and ibn.referred_by<>1 and bn.hiv_status_id = 2 and ibn.is_active = true AND ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM iv.visit_date) =:filterYear and EXTRACT(MONTH FROM iv.visit_date) =:filterMonth")
	List<BigInteger> getProviderInitiatedCountForPositive(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.ictc_beneficiary ibn\n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\n" +
        "LEFT JOIN soch.ictc_visit iv ON ibn.recent_visit_id = iv.id\n" +
        "WHERE ibn.facility_id=:facilityId and ibn.referred_by<>1 and bn.hiv_status_id = 3 and ibn.is_active = true AND ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM iv.visit_date) =:filterYear and EXTRACT(MONTH FROM iv.visit_date) =:filterMonth")
	List<BigInteger> getProviderInitiatedCountForIntermediate(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.beneficiary bn \r\n"
			+ "			    JOIN soch.ictc_beneficiary ibn on bn.id = ibn.beneficiary_id \r\n"
			+ "			    JOIN soch.ictc_visit ivs ON ibn.id = ivs.ictc_beneficiary_id\r\n"
			+ "			    JOIN soch.ictc_follow_up ifp  ON ifp.ictc_beneficiary_id = ivs.ictc_beneficiary_id\r\n"
			+ "			    WHERE ibn.facility_id=:facilityId and ifp.follow_up_date IS NOT null and ibn.is_active = true AND ibn.is_deleted = false\r\n"
			+ "			    and ibn.beneficiary_status = 3 and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth")
	List<BigInteger> getFollowupCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT count(distinct ibn.id) from soch.beneficiary bn \r\n"
			+ "			    JOIN soch.ictc_beneficiary ibn on bn.id = ibn.beneficiary_id \r\n"
			+ "			    JOIN soch.ictc_visit ivs ON ibn.id = ivs.ictc_beneficiary_id\r\n"
			+ "			    JOIN soch.ictc_follow_up ifp  ON ifp.ictc_beneficiary_id = ivs.ictc_beneficiary_id\r\n"
			+ "			    WHERE ibn.facility_id=:facilityId and ifp.follow_up_date IS NOT null  and ifp.is_completed =true and ibn.is_active = true AND ibn.is_deleted = false\r\n"
			+ "			    and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and EXTRACT(MONTH FROM ibn.created_time) =:filterMonth")
	List<BigInteger> getRepeatTestCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(ifw.ictc_beneficiary_id) from soch.ictc_follow_up ifw\n" +
        "join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id\n" +
        "left join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id\n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "where ifw.follow_up_type=2  and ib.facility_id =:facilityId\n" +
        "and iv.is_pregnant = false and b.category_id<> 1\n" +
        "and ib.is_active = true AND ib.is_deleted = false\n" +
        "and extract(YEAR FROM iv.visit_date ) =:filterYear\n" +
        "and extract(MONTH FROM iv.visit_date) =:filterMonth", nativeQuery = true)
	int getPartnersFollowedUpGC(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(ifw.ictc_beneficiary_id) from soch.ictc_follow_up ifw\n" +
        "join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id\n" +
        "left join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id\n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "where ifw.follow_up_type=2  and ib.facility_id =:facilityId\n" +
        "and iv.is_pregnant = true and b.category_id<> 1\n" +
        "and ib.is_active = true AND ib.is_deleted = false\n" +
        "and extract(YEAR FROM iv.visit_date ) =:filterYear\n" +
        "and extract(MONTH FROM iv.visit_date) =:filterMonth", nativeQuery = true)
	int getPartnersFollowedUpPW(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ibt.beneficiary_id ) from soch.ictc_follow_up ifw\n" +
        "join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id\n" +
        "left join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id\n" +
        "inner join soch.beneficiary_family_details bfd on bfd.beneficiary_id  = ib.beneficiary_id\n" +
        "inner join soch.ictc_beneficiary ibt  on ibt.beneficiary_id  = bfd.member_beneficiary_id \n" +
        "inner join soch.ictc_test_result itrt on itrt.ictc_beneficiary_id  = ibt.id \n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "where ifw.follow_up_type=2 and ifw.is_active = true and ib.facility_id =:facilityId\n" +
        "and iv.is_pregnant = false and b.category_id<>1 and itrt.tested_date is not null\n" +
        "and ib.is_active = true AND ib.is_deleted = false\n" +
        "and extract(YEAR FROM iv.visit_date) =:filterYear\n" +
        "and extract(MONTH FROM iv.visit_date) =:filterMonth", nativeQuery = true)
	int getPartnersTestedGC(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	// ifw.created_time is considered for tested_date
	@Query(value = "select count(distinct ibt.beneficiary_id ) from soch.ictc_follow_up ifw\n" +
        "join soch.ictc_beneficiary ib on ib.id = ifw.ictc_beneficiary_id\n" +
        "left join soch.ictc_visit iv on iv.ictc_beneficiary_id = ib.id\n" +
        "inner join soch.beneficiary_family_details bfd on bfd.beneficiary_id  = ib.beneficiary_id\n" +
        "inner join soch.ictc_beneficiary ibt  on ibt.beneficiary_id  = bfd.member_beneficiary_id \n" +
        "inner join soch.ictc_test_result itrt on itrt.ictc_beneficiary_id  = ibt.id \n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "where ifw.follow_up_type=2 and ifw.is_active = true and ib.facility_id =:facilityId\n" +
        "and iv.is_pregnant = true and b.category_id<>1 and itrt.tested_date is not null\n" +
        "and ib.is_active = true AND ib.is_deleted = false\n" +
        "and extract(YEAR FROM iv.visit_date) =:filterYear\n" +
        "and extract(MONTH FROM iv.visit_date) =:filterMonth", nativeQuery = true)
	int getPartnersTestedPW(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT COUNT(distinct ibn.beneficiary_id) from soch.ictc_beneficiary ibn "
			+ "   JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id "
			+ "   WHERE ibn.facility_id=:facilityId and bn.category_id = 1 and bn.hiv_status_id = 2 and "
			+ "	  ibn.is_active = true and ibn.is_deleted = false"
			+ "   and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and  EXTRACT(MONTH FROM ibn.created_time) =:filterMonth  ")
	List<BigInteger> getConfirmedPositiveCount(@Param("facilityId") Long facilityId,
			@Param("filterYear") int filterYear, @Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "SELECT COUNT(distinct ibn.beneficiary_id) from soch.ictc_beneficiary ibn\n" +
        "JOIN soch.beneficiary bn  ON bn.id = ibn.beneficiary_id\n" +
        "JOIN soch.ictc_test_result itr ON itr.ictc_beneficiary_id = ibn.id\n" +
        "WHERE ibn.facility_id=:facilityId and bn.category_id = 1 and  ibn.is_active = true and ibn.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM ibn.created_time) =:filterYear and  EXTRACT(MONTH FROM ibn.created_time) =:filterMonth")
	List<BigInteger> getTestedCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ib.beneficiary_id) from soch.ictc_test_result itr\n" +
        "join soch.ictc_beneficiary ib on ib.id = itr.ictc_beneficiary_id\n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\n" +
        "where itr.is_tested_for_syphilis = true\n" +
        "and iv.is_pregnant = true and ib.is_active = true and ib.is_deleted = false and ib.facility_id = :facilityId\n" +
        "and extract(YEAR FROM itr.tested_date) = :filterYear\n" +
        "and extract(MONTH FROM itr.tested_date) = :filterMonth", nativeQuery = true)
	List<BigInteger> getPWTestedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ib.beneficiary_id) from soch.ictc_test_result itr \n" +
        "join soch.ictc_beneficiary ib on ib.id = itr.ictc_beneficiary_id\n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\n" +
        "where itr.is_tested_for_syphilis = true \n" +
        "and iv.is_pregnant = false and ib.facility_id = :facilityId and ib.is_active = true and ib.is_deleted = false\n" +
        "and extract(YEAR FROM itr.tested_date) = :filterYear\n" +
        "and extract(MONTH FROM itr.tested_date) = :filterMonth ", nativeQuery = true)
	List<BigInteger> getGCTestedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ib.beneficiary_id) from soch.ictc_beneficiary ib\n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id \n" +
        "join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\n" +
        "join soch.ictc_test_result itr on b.id  = itr.ictc_beneficiary_id\n" +
        "where ib.on_syphilis_treatment = true and iv.is_pregnant = true  and ib.is_active = true and ib.is_deleted = false\n" +
        "and ib.facility_id =:facilityId and extract(YEAR FROM itr.report_received_date) =:filterYear\n" +
        "and extract(MONTH FROM itr.report_received_date ) =:filterMonth", nativeQuery = true)
	List<BigInteger> getPWTreatedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(value = "select count(distinct ib.beneficiary_id) from soch.ictc_beneficiary ib\n" +
        "join soch.beneficiary b on b.id  = ib.beneficiary_id\n" +
        "join soch.ictc_visit iv on ib.id  = iv.ictc_beneficiary_id\n" +
        "join soch.ictc_test_result itr on b.id  = itr.ictc_beneficiary_id\n" +
        "where ib.on_syphilis_treatment = true and iv.is_pregnant = false  and ib.is_active = true and ib.is_deleted = false\n" +
        "and ib.facility_id =:facilityId and extract(YEAR FROM itr.report_received_date) =:filterYear\n" +
        "and extract(MONTH FROM itr.report_received_date ) =:filterMonth", nativeQuery = true)
	List<BigInteger> getGCTreatedForSyphilis(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select COUNT(distinct ib.beneficiary_id )  from beneficiary b  inner join ictc_beneficiary ib on b.id = ib.beneficiary_id \r\n"
			+ "			  	inner join ictc_visit iv on iv.ictc_beneficiary_id  = ib.id where iv.is_pregnant = true and iv.delivery_outcome in (1,2,3) and ib.facility_id =:facilityId\r\n"
			+ "			 	and ib.is_active = true and b.hiv_status_id = 2 and ib.is_deleted = false AND EXTRACT(YEAR FROM iv.delivery_date) =:filterYear \r\n"
			+ "			    and EXTRACT(MONTH FROM iv.delivery_date) =:filterMonth")
	List<BigInteger> getPositiveMotherCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select  count(distinct ibi.beneficiary_id ) from beneficiary b  inner join ictc_beneficiary ib on b.id = ib.beneficiary_id \r\n"
			+ "			  	inner join ictc_visit iv on iv.ictc_beneficiary_id  = ib.id inner join beneficiary_family_details bfd on bfd.beneficiary_id  = b.id\r\n"
			+ "			  	inner join beneficiary bi on bi.id = bfd.member_beneficiary_id inner join ictc_beneficiary ibi on ibi.beneficiary_id  = bi.id \r\n"
			+ "			  	inner join ictc_visit ivi on ivi.ictc_beneficiary_id  = ibi.id \r\n"
			+ "			  	where iv.is_pregnant = true and b.hiv_status_id  = 2 and iv.delivery_outcome in (1,2,3) and ib.facility_id =:facilityId and bi.category_id =1 and EXTRACT(YEAR FROM ivi.visit_date ) =  extract(YEAR FROM(iv.delivery_date + interval '6 week'))\r\n"
			+ "			    and EXTRACT(MONTH FROM ivi.visit_date) = extract(MONTH FROM(iv.delivery_date + interval '6 week'))\r\n"
			+ "			    and EXTRACT(WEEK FROM ivi.visit_date) = extract(WEEK FROM(iv.delivery_date + interval '6 week'))\r\n"
			+ "			    and ib.is_active = true and ib.is_deleted = false AND EXTRACT(YEAR FROM iv.delivery_date ) =:filterYear \r\n"
			+ "			    and EXTRACT(MONTH FROM iv.delivery_date) =:filterMonth and ib.is_deleted =false and ibi.is_deleted =false")
	List<BigInteger> getSixWeekInfantCount(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 1 GROUP BY 1")
	List<StatisticsProjection> getHIVFirstKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 2 GROUP BY 1")
	List<StatisticsProjection> getHIVSecondKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 3 GROUP BY 1")
	List<StatisticsProjection> getHIVThirdKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select TO_CHAR(DATE_TRUNC('month',fsa.date_of_addition_or_consupmtion),'MONTH') AS name,\r\n"
			+ "		 sum(fsa.testing_quantity) AS value  from facility_stock_adjustment fsa inner join facility f on f.id = fsa.facility_id \r\n"
			+ "					 inner join product p on p.id = fsa.product_id \r\n"
			+ "					 where  f.id =:facilityId and p.id = 11 GROUP BY 1")
	List<StatisticsProjection> getSyphilisFirstKITConsumptionData(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  =:facilityId and p.id = 1) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id = 1) as TotalQuantity")
	InventoryProjection getHIVFirstKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select  coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  = :facilityId and p.id = 2) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id = 2) as TotalQuantity ")
	InventoryProjection getHIVSecondKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select  coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  =:facilityId and p.id = 3) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id =3) as TotalQuantity ")
	InventoryProjection getHIVThirdKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select (select coalesce (sum(adjust_stock_quantity)/3,0) from soch.facility_stock_adjustment sd  \r\n"
			+ "			 inner join soch.facility f on f.id = sd.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sd.product_id  \r\n"
			+ "			where sd.date_of_addition_or_consupmtion >= date_trunc('month', now())- interval '3 month' and \r\n"
			+ "			 sd.date_of_addition_or_consupmtion < date_trunc('month', now()) and f.id  =:facilityId and p.id = 11) as AverageCount , \r\n"
			+ "			 (select  coalesce (min(sda.current_quantity),0) from soch.facility_stock sda \r\n"
			+ "		 inner join soch.facility f on f.id = sda.facility_id \r\n"
			+ "		 inner join soch.product p on p.id = sda.product_id  where f.id =:facilityId and p.id = 11) as TotalQuantity ")
	InventoryProjection getSyphilisFirstKITdata(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true , value = "select tr.id as value , tr.name as name from soch.master_tb_result tr")
	List<StatisticsProjection> getMasterTBResults();

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b\n" +
        "inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id\n" +
        "inner join soch.facility f on ib.facility_id  = f.id \n" +
        "inner join soch.ictc_test_result itr on itr.ictc_beneficiary_id  = ib.id\n" +
        "inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id\n" +
        "inner join soch.master_tb_result tr on tr.id = itr.tb_test_result \n" +
        "where ib.facility_id=:facilityId and  itr.is_tested_for_tb  = true and iv.is_pregnant = false and tr.id =:tbId\n" +
        "and tr.id in(select tb_test_result from soch.ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 ) and ib.is_active = true and ib.is_deleted = false\n" +
        "and EXTRACT(YEAR FROM itr.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM itr.report_delivery_date) =:filterMonth")
	List<BigInteger> getTBCountForGC(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth, @Param("tbId") int tbId);

	@Query(nativeQuery = true, value = "select count(distinct ib.id) from soch.beneficiary b\n" +
        "inner join soch.ictc_beneficiary ib on b.id = ib.beneficiary_id\n" +
        "inner join soch.facility f on ib.facility_id  = f.id\n" +
        "inner join soch.ictc_test_result itr on itr.ictc_beneficiary_id  = ib.id\n" +
        "inner join soch.ictc_visit iv on iv.ictc_beneficiary_id  = ib.id\n" +
        "inner join soch.master_tb_result tr on tr.id = itr.tb_test_result\n" +
        "where ib.facility_id=:facilityId and itr.is_tested_for_tb  = true and iv.is_pregnant = true and tr.id = :tbId and ib.is_active = true and ib.is_deleted = false\n" +
        "and tr.id in(select tb_test_result from soch.ictc_test_result where ictc_beneficiary_id  = ib.id and report_delivery_date is not null order by tested_date desc limit 1 )\n" +
        "and EXTRACT(YEAR FROM itr.report_delivery_date) =:filterYear and  EXTRACT(MONTH FROM itr.report_delivery_date) =:filterMonth")
	List<BigInteger> getTBCountForPW(@Param("facilityId") Long facilityId, @Param("filterYear") int filterYear,
			@Param("filterMonth") int filterMonth, @Param("tbId") int tbId);


}
