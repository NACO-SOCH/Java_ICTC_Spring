package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryClinicalTreatment;
import gov.naco.soch.projection.BeneficiaryClinicalTreatmentSyphilisProjection;

@Repository
public interface BeneficiaryClinicalTreatmentRepository extends JpaRepository<BeneficiaryClinicalTreatment, Long> {

	@Query(nativeQuery = true, value = "select bst.id as id, bst.syphilis_test_result_id as syphilisTestResultId, bst.is_treatment_completed as isTreatmentCompleted "
			+ "from soch.beneficiary_clinical_treatment as bct "
			+ "join soch.beneficiary_syphilis_treatment_details as bst on bct.id = bst.clinical_treatment_id "
			+ "where bct.beneficiary_id=:beneficiaryId and bct.is_active = true and bct.is_delete = false limit 1")
	Optional<BeneficiaryClinicalTreatmentSyphilisProjection> findSyphilisTestResultDetailsInClinicalTreatment(
			@Param("beneficiaryId") Long beneficiaryId);
}
