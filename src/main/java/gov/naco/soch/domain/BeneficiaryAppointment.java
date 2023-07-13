package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the captcha database table.
 * 
 */
@Entity
@Table(name = "beneficiary_appointment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiaryAppointment extends Auditable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@Column(name = "facility_type_id")
	private Long facilityTypeId;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;
	
	@Column(name = "appointment_date")
	private LocalDateTime dateOfAppointment;
	
//	@Column(name = "purpose_visit_id")
//	private Long purposeOfVisit;
	
	@Column(name = "appointment_status_id")
	private Long appointmentStatus;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public LocalDateTime getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDateTime dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

//	public Long getPurposeOfVisit() {
//		return purposeOfVisit;
//	}

//	public void setPurposeOfVisit(Long purposeOfVisit) {
//		this.purposeOfVisit = purposeOfVisit;
//	}

	public Long getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(Long appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
}