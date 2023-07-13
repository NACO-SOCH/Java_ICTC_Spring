package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryVisitRegister;

@Repository
public interface BeneficiaryVisitRegisterRepository extends JpaRepository<BeneficiaryVisitRegister, Long> {

	@Query("select bvr from BeneficiaryVisitRegister bvr where bvr.id=(select max(bv.id) from BeneficiaryVisitRegister bv where bv.isPregnant != null and bv.beneficiaryId=:beneficiaryId and bv.isActive = true and bv.isDelete = false)")
	Optional<BeneficiaryVisitRegister> findFirstByIsPregnantOrderByDesc(@Param("beneficiaryId") Long beneficiaryId);

}
