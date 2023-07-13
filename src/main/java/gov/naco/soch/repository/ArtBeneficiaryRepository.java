package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.ArtBeneficiary;


/**
 * Spring Data  repository for the ArtBeneficiary entity.
 */
@Repository
public interface ArtBeneficiaryRepository extends JpaRepository<ArtBeneficiary, Long>, JpaSpecificationExecutor<ArtBeneficiary> {
	
	@Query("select ab from ArtBeneficiary ab where ab.beneficiary.id=:beneficiaryId")
	Optional<ArtBeneficiary> findByBeneficiaryId(@Param("beneficiaryId")Long beneficiaryId);
	
	@Query("select ab from ArtBeneficiary ab where ab.beneficiary.id=:beneficiaryId and ab.isActive = true and ab.isDelete = false")
	Optional<ArtBeneficiary> findActiveArtBeneficiaryByBeneficiaryId(@Param("beneficiaryId")Long beneficiaryId);

}
