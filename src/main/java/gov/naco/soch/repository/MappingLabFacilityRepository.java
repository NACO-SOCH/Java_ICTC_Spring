package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.MappingLabFacility;

/**
 * Spring Data  repository for the MappingLabFacility entity.
 */
@Repository
public interface MappingLabFacilityRepository extends JpaRepository<MappingLabFacility, Long>, JpaSpecificationExecutor<MappingLabFacility> {
	
	@Query("select m from MappingLabFacility m where m.facility.id=:facilityId and m.lab.facilityTypeId=:labTypeId and m.isDelete != true")
	List<MappingLabFacility> findAllLabsMappingToICTC(@Param("facilityId") Long facilityId, @Param("labTypeId") Long facilityTypeId);
	
	@Query("select m from MappingLabFacility m where m.facility.id=:facilityId and m.isDelete != true")
	List<MappingLabFacility> findAllLabsMappingToICTC(@Param("facilityId") Long facilityId);
	
}
