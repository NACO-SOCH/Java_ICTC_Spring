package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryFamilyDetails;

/**
 * Spring Data  repository for the BeneficiaryFamilyDetails entity.
 */
@Repository
public interface BeneficiaryFamilyDetailsRepository extends JpaRepository<BeneficiaryFamilyDetails, Long>, JpaSpecificationExecutor<BeneficiaryFamilyDetails> {
	List<BeneficiaryFamilyDetails> findByBeneficiaryIdAndRelationshipIdOrderByIdDesc(Long beneficiaryId, Integer relationshipId);
	List<BeneficiaryFamilyDetails> findByBeneficiaryIdAndMemberBeneficiaryIdOrderByIdDesc(Long beneficiaryId, Long memberBeneficiaryId);
	
	@Modifying
	@Query("update BeneficiaryFamilyDetails bfd set bfd.isDelete=true, bfd.isActive=false where bfd.id=:id")
	void markEntryAsDeletedAndInActive(@Param("id") Long id);
}
