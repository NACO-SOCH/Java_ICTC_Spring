//package gov.naco.soch.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import gov.naco.soch.domain.ICTCBeneficiaryCounsellingView;
//
//@Repository
//public interface Test1 extends JpaRepository<ICTCBeneficiaryCounsellingView, Long> {

//	@Query("select ictcbenefi0_.id as id1_19_, ictcbenefi0_.age as age2_19_, ictcbenefi0_.art_referral_id as art_refe3_19_,"
//			+ " ictcbenefi0_.art_referral_name as art_refe4_19_, ictcbenefi0_.barcode as barcode5_19_, ictcbenefi0_.batch_id as batch_id6_19_, ictcbenefi0_.beneficiary_id as benefici7_19_, "
//			+ "ictcbenefi0_.beneficiary_status as benefici8_19_, ictcbenefi0_.beneficiary_status_desc as benefici9_19_, ictcbenefi0_.category_id as categor10_19_,"
//			+ " ictcbenefi0_.consignment_id as consign11_19_, ictcbenefi0_.current_test_result_id as current12_19_, ictcbenefi0_.date_of_birth as date_of13_19_, "
//			+ "ictcbenefi0_.ictc_ben_deleted_reason as ictc_be14_19_, ictcbenefi0_.ictc_ben_deleted_reason_comment as ictc_be15_19_, ictcbenefi0_.dsrc_referral_id as dsrc_re16_19_, "
//			+ "ictcbenefi0_.dsrc_referral_name as dsrc_re17_19_, ictcbenefi0_.facility_id as facilit18_19_, ictcbenefi0_.first_name as first_n19_19_,"
//			+ " ictcbenefi0_.gender_id as gender_20_19_, ictcbenefi0_.hiv_status as hiv_sta21_19_, ictcbenefi0_.hiv_status_desc as hiv_sta22_19_, ictcbenefi0_.hiv_type as hiv_typ23_19_,"
//			+ " ictcbenefi0_.infant_breast_fed as infant_24_19_, ictcbenefi0_.infant_code as infant_25_19_, ictcbenefi0_.infant_mother_art_id as infant_26_19_, "
//			+ "ictcbenefi0_.infant_mother_art_no as infant_27_19_, ictcbenefi0_.infant_mother_beneficiary_id as infant_28_19_, ictcbenefi0_.infant_mother_first_name as infant_29_19_, "
//			+ "ictcbenefi0_.infant_mother_last_name as infant_30_19_, ictcbenefi0_.ictc_ben_is_active as ictc_be31_19_,"
//			+ " ictcbenefi0_.is_consent_documented as is_cons32_19_, ictcbenefi0_.ictc_ben_is_deleted as ictc_be33_19_, ictcbenefi0_.is_post_test_counselling_completed as is_post34_19_, "
//			+ "ictcbenefi0_.is_pregnant as is_preg35_19_, ictcbenefi0_.lab_code as lab_cod36_19_, ictcbenefi0_.lab_id as lab_id37_19_, ictcbenefi0_.lab_name as lab_nam38_19_,"
//			+ " ictcbenefi0_.last_name as last_na39_19_, ictcbenefi0_.marital_status_id as marital40_19_, ictcbenefi0_.middle_name as middle_41_19_, ictcbenefi0_.mobile_number as mobile_42_19_, "
//			+ "ictcbenefi0_.occupation_id as occupat43_19_, ictcbenefi0_.pid as pid44_19_, ictcbenefi0_.registered_facility_id as registe45_19_, ictcbenefi0_.report_delivery_date as report_46_19_,"
//			+ " ictcbenefi0_.report_received_date as report_47_19_, ictcbenefi0_.result_modified_time as result_48_19_, ictcbenefi0_.result_status as result_49_19_, ictcbenefi0_.rntcp_referral_id as "
//			+ "rntcp_r50_19_, ictcbenefi0_.rntcp_referral_name as rntcp_r51_19_, ictcbenefi0_.sample_collection_date as sample_52_19_, "
//			+ "ictcbenefi0_.test_type as test_ty53_19_, ictcbenefi0_.test_type_desc as test_ty54_19_, ictcbenefi0_.tested_date as tested_55_19_, ictcbenefi0_.ti_referral_id as ti_refe56_19_,"
//			+ " ictcbenefi0_.ti_referral_name as ti_refe57_19_, ictcbenefi0_.uid as uid58_19_, ictcbenefi0_.visit_date as visit_d59_19_, ictcbenefi0_.visit_id "
//			+ "as visit_i60_19_ from soch.ictc_beneficiary_counselling_view ictcbenefi0_ where ictcbenefi0_.is_post_test_counselling_completed=false and ictcbenefi0_.category_id<>1 and "
//			+ "ictcbenefi0_.facility_id=8991 and ictcbenefi0_.is_consent_documented=true and ictcbenefi0_.beneficiary_status=1")
//	@Query("select ictcbenefi0_ from ictc_beneficiary_counselling_view")
//			@Query("SELECT b.pid, b.first_name FROM soch.beneficiary b")
//			Page<ICTCBeneficiaryCounsellingView> findByPostData(Pageable pageable);
//}
