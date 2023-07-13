package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

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
 * A ICTCFollowUp.
 */
@Entity
@Table(name = "ictc_follow_up")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCFollowUp extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "follow_up_type")
    private Integer followUpType;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;
    
    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "ictc_beneficiary_id")
    private ICTCBeneficiary ictcBeneficiary;
    
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private ICTCVisit visit;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    
    @ManyToOne
    @JoinColumn(name = "test_result_id")
    private ICTCTestResult testResult;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public ICTCVisit getVisit() {
		return visit;
	}

	public void setVisit(ICTCVisit visit) {
		this.visit = visit;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public ICTCTestResult getTestResult() {
		return testResult;
	}

	public void setTestResult(ICTCTestResult testResult) {
		this.testResult = testResult;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ICTCFollowUp)) {
            return false;
        }
        return id != null && id.equals(((ICTCFollowUp) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "ICTCFollowUp [id=" + id + ", followUpType=" + followUpType + ", followUpDate=" + followUpDate
				+ ", isCompleted=" + isCompleted + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", ictcBeneficiary=" + ictcBeneficiary + ", visit=" + visit + ", facility=" + facility
				+ ", testResult=" + testResult + "]";
	}

}
