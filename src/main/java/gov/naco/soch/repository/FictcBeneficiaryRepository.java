package gov.naco.soch.repository;

import gov.naco.soch.domain.FictcBeneficiary;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the FictcBeneficiary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FictcBeneficiaryRepository extends JpaRepository<FictcBeneficiary, Long>, JpaSpecificationExecutor<FictcBeneficiary> {

}
