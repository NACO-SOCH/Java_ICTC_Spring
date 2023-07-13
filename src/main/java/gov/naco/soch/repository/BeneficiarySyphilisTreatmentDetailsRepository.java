package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiarySyphilisTreatmentDetails;

@Repository
public interface BeneficiarySyphilisTreatmentDetailsRepository extends JpaRepository<BeneficiarySyphilisTreatmentDetails, Long> {

}
