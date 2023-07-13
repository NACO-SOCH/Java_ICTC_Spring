package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.IctcLinkedFacility;

/**
 * Spring Data  repository for the IctcLinkedFacility entity.
 */
@Repository
public interface IctcLinkedFacilityRepository extends JpaRepository<IctcLinkedFacility, Long>, JpaSpecificationExecutor<IctcLinkedFacility> {
	
	@Modifying
	@Query("delete from IctcLinkedFacility lf where lf.facilityId=:facilityId")
	void deleteIctcFacilityLinkings(@Param("facilityId") Long facilityId);
}
