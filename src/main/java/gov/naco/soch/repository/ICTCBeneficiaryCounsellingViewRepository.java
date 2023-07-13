package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.ICTCBeneficiaryCounsellingView;
import gov.naco.soch.domain.ICTCBeneficiaryVisit;

/**
 * Spring Data  repository for the ICTCBeneficiaryVisit entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCBeneficiaryCounsellingViewRepository extends JpaRepository<ICTCBeneficiaryCounsellingView, Long>, JpaSpecificationExecutor<ICTCBeneficiaryCounsellingView> {
}
