package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.BeneficiaryAppointment;

@Repository
public interface BeneficiaryAppointmentRepository extends JpaRepository<BeneficiaryAppointment, Long>, JpaSpecificationExecutor<BeneficiaryAppointment>{

	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary_appointment set modified_time=now(), appointment_status_id=4 where id=:appointmentId")
	void attendAppoinmentInIctc(@Param("appointmentId") Long appointmentId);
}
