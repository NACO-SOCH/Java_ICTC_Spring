package gov.naco.soch.domain;

import java.io.Serializable;
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
@Table(name = "beneficiary_syphilis_treatment_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiarySyphilisTreatmentDetails extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_id")
	private BeneficiaryClinicalTreatment beneficiaryClinicalTreatment;

	@Column(name = "syphilis_test_result_id")
	private Long syphilisTestResultId;

	@Column(name = "is_treatment_completed")
	private Boolean isTreatmentCompleted;

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

	public Long getSyphilisTestResultId() {
		return syphilisTestResultId;
	}

	public BeneficiaryClinicalTreatment getBeneficiaryClinicalTreatment() {
		return beneficiaryClinicalTreatment;
	}

	public void setBeneficiaryClinicalTreatment(BeneficiaryClinicalTreatment beneficiaryClinicalTreatment) {
		this.beneficiaryClinicalTreatment = beneficiaryClinicalTreatment;
	}

	public void setSyphilisTestResultId(Long syphilisTestResultId) {
		this.syphilisTestResultId = syphilisTestResultId;
	}

	public Boolean getIsTreatmentCompleted() {
		return isTreatmentCompleted;
	}

	public void setIsTreatmentCompleted(Boolean isTreatmentCompleted) {
		this.isTreatmentCompleted = isTreatmentCompleted;
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
