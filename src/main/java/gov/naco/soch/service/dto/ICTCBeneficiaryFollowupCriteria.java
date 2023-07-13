package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class ICTCBeneficiaryFollowupCriteria implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobileNumber;

    private String followUpType;

    private Date followUpDate;

    private Long beneficiaryId;

    private Long facilityId;

    private String remarks;

    private Boolean isCompleted;

    private Long visitId;

    private Date expectedDeliveryDate;

    private Date pregnancyLmpDate;

    public ICTCBeneficiaryFollowupCriteria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(String followUpType) {
        this.followUpType = followUpType;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getPregnancyLmpDate() {
        return pregnancyLmpDate;
    }

    public void setPregnancyLmpDate(Date pregnancyLmpDate) {
        this.pregnancyLmpDate = pregnancyLmpDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ICTCBeneficiaryFollowupCriteria that = (ICTCBeneficiaryFollowupCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(mobileNumber, that.mobileNumber) &&
            Objects.equals(followUpType, that.followUpType) &&
            Objects.equals(followUpDate, that.followUpDate) &&
            Objects.equals(beneficiaryId, that.beneficiaryId) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(remarks, that.remarks) &&
            Objects.equals(isCompleted, that.isCompleted) &&
            Objects.equals(visitId, that.visitId) &&
            Objects.equals(expectedDeliveryDate, that.expectedDeliveryDate) &&
            Objects.equals(pregnancyLmpDate, that.pregnancyLmpDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        firstName,
        middleName,
        lastName,
        mobileNumber,
        followUpType,
        followUpDate,
        beneficiaryId,
        facilityId,
        remarks,
        isCompleted,
        visitId,
        expectedDeliveryDate,
        pregnancyLmpDate
        );
    }

    @Override
    public String toString() {
        return "ICTCBeneficiaryFollowupCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (lastName != null ? "lastName=" + lastName + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
                (followUpType != null ? "followUpType=" + followUpType + ", " : "") +
                (followUpDate != null ? "followUpDate=" + followUpDate + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (remarks != null ? "remarks=" + remarks + ", " : "") +
                (isCompleted != null ? "isCompleted=" + isCompleted + ", " : "") +
                (visitId != null ? "visitId=" + visitId + ", " : "") +
                (expectedDeliveryDate != null ? "expectedDeliveryDate=" + expectedDeliveryDate + ", " : "") +
                (pregnancyLmpDate != null ? "pregnancyLmpDate=" + pregnancyLmpDate + ", " : "") +
            "}";
    }

}
