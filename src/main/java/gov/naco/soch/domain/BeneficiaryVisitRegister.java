package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "beneficiary_visit_register")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiaryVisitRegister extends Auditable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	@Column(name = "weight")
	private Float weight;

	@Column(name = "height")
	private Float height;

	@Column(name = "is_pregnant")
	private Boolean isPregnant;

	@Column(name = "lmp")
	private LocalDate lmp;

	@Column(name = "four_s_symptoms")
	private Boolean foursSymptoms;

	@Column(name = "visit_by")
	private String visitBy;
	
	@Column(name="ost_client_status_date")
	private LocalDateTime ostClientStatusDate;
	
	@Column(name="ti_client_status_date")
	private LocalDateTime tiClientStatusDate;
	
	@Column(name="ost_status_date")
	private LocalDateTime ostStatusDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pregnant_case_type_id")
	private MasterPregnancyTypeCase masterPregnancyTypeCase;

	@Column(name = "beneficiary_id")
	private Long beneficiaryId;

	@Column(name = "delivery_outcome_id")
	private Long deliveryOutcome;

	// bi-directional many-to-one association to Facility
	@Column(name = "facility_id")
	private Long facility;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public LocalDate getLmp() {
		return lmp;
	}

	public void setLmp(LocalDate lmp) {
		this.lmp = lmp;
	}

	public Boolean getFoursSymptoms() {
		return foursSymptoms;
	}

	public void setFoursSymptoms(Boolean foursSymptoms) {
		this.foursSymptoms = foursSymptoms;
	}

	public String getVisitBy() {
		return visitBy;
	}

	public void setVisitBy(String visitBy) {
		this.visitBy = visitBy;
	}

	public LocalDateTime getOstClientStatusDate() {
		return ostClientStatusDate;
	}

	public void setOstClientStatusDate(LocalDateTime ostClientStatusDate) {
		this.ostClientStatusDate = ostClientStatusDate;
	}

	public LocalDateTime getTiClientStatusDate() {
		return tiClientStatusDate;
	}

	public void setTiClientStatusDate(LocalDateTime tiClientStatusDate) {
		this.tiClientStatusDate = tiClientStatusDate;
	}

	public LocalDateTime getOstStatusDate() {
		return ostStatusDate;
	}

	public void setOstStatusDate(LocalDateTime ostStatusDate) {
		this.ostStatusDate = ostStatusDate;
	}
	
	public MasterPregnancyTypeCase getMasterPregnancyTypeCase() {
		return masterPregnancyTypeCase;
	}

	public void setMasterPregnancyTypeCase(MasterPregnancyTypeCase masterPregnancyTypeCase) {
		this.masterPregnancyTypeCase = masterPregnancyTypeCase;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(Long deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public Long getFacility() {
		return facility;
	}

	public void setFacility(Long facility) {
		this.facility = facility;
	}

}
