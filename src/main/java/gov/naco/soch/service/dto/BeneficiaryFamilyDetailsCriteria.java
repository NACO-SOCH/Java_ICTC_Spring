package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 * Criteria class for the {@link gov.naco.soch.domain.BeneficiaryFamilyDetails} entity. This class is used
 * in {@link gov.naco.soch.web.rest.BeneficiaryFamilyDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /beneficiary-family-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryFamilyDetailsCriteria  {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String familyUid;

    private Integer relationshipId;

    private Long beneficiaryId;

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer genderId;

    private Integer ageYears;

    private Integer ageMonths;

    private Boolean isAlive;

    private Integer hivStatusId;

    private Boolean onArt;

    private Boolean isBeneficiary;

    private Long memberBeneficiaryId;

    private Integer createdBy;

    private Date createdTime;

    private Integer modifiedBy;

    private Date modifiedTime;

    private Boolean isActive;

    private Boolean isDelete;

    public BeneficiaryFamilyDetailsCriteria() {
    }

//    public BeneficiaryFamilyDetailsCriteria(BeneficiaryFamilyDetailsCriteria other) {
//        this.id = other.id == null ? null : other.id.copy();
//        this.familyUid = other.familyUid == null ? null : other.familyUid.copy();
//        this.relationshipId = other.relationshipId == null ? null : other.relationshipId.copy();
//        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
//        this.firstName = other.firstName == null ? null : other.firstName.copy();
//        this.middleName = other.middleName == null ? null : other.middleName.copy();
//        this.lastName = other.lastName == null ? null : other.lastName.copy();
//        this.genderId = other.genderId == null ? null : other.genderId.copy();
//        this.ageYears = other.ageYears == null ? null : other.ageYears.copy();
//        this.ageMonths = other.ageMonths == null ? null : other.ageMonths.copy();
//        this.isAlive = other.isAlive == null ? null : other.isAlive.copy();
//        this.hivStatusId = other.hivStatusId == null ? null : other.hivStatusId.copy();
//        this.onArt = other.onArt == null ? null : other.onArt.copy();
//        this.isBeneficiary = other.isBeneficiary == null ? null : other.isBeneficiary.copy();
//        this.memberBeneficiaryId = other.memberBeneficiaryId == null ? null : other.memberBeneficiaryId.copy();
//        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
//        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
//        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
//        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
//        this.isActive = other.isActive == null ? null : other.isActive.copy();
//        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
//    }
//
//    @Override
//    public BeneficiaryFamilyDetailsCriteria copy() {
//        return new BeneficiaryFamilyDetailsCriteria(this);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyUid() {
        return familyUid;
    }

    public void setFamilyUid(String familyUid) {
        this.familyUid = familyUid;
    }

    public Integer getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(Integer ageYears) {
        this.ageYears = ageYears;
    }

    public Integer getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
    }

    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Integer getHivStatusId() {
        return hivStatusId;
    }

    public void setHivStatusId(Integer hivStatusId) {
        this.hivStatusId = hivStatusId;
    }

    public Boolean getOnArt() {
        return onArt;
    }

    public void setOnArt(Boolean onArt) {
        this.onArt = onArt;
    }

    public Boolean getIsBeneficiary() {
        return isBeneficiary;
    }

    public void setIsBeneficiary(Boolean isBeneficiary) {
        this.isBeneficiary = isBeneficiary;
    }

    public Long getMemberBeneficiaryId() {
        return memberBeneficiaryId;
    }

    public void setMemberBeneficiaryId(Long memberBeneficiaryId) {
        this.memberBeneficiaryId = memberBeneficiaryId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BeneficiaryFamilyDetailsCriteria that = (BeneficiaryFamilyDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(familyUid, that.familyUid) &&
            Objects.equals(relationshipId, that.relationshipId) &&
            Objects.equals(beneficiaryId, that.beneficiaryId) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(genderId, that.genderId) &&
            Objects.equals(ageYears, that.ageYears) &&
            Objects.equals(ageMonths, that.ageMonths) &&
            Objects.equals(isAlive, that.isAlive) &&
            Objects.equals(hivStatusId, that.hivStatusId) &&
            Objects.equals(onArt, that.onArt) &&
            Objects.equals(isBeneficiary, that.isBeneficiary) &&
            Objects.equals(memberBeneficiaryId, that.memberBeneficiaryId) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        familyUid,
        relationshipId,
        beneficiaryId,
        firstName,
        middleName,
        lastName,
        genderId,
        ageYears,
        ageMonths,
        isAlive,
        hivStatusId,
        onArt,
        isBeneficiary,
        memberBeneficiaryId,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        isActive,
        isDelete
        );
    }

    @Override
    public String toString() {
        return "BeneficiaryFamilyDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (familyUid != null ? "familyUid=" + familyUid + ", " : "") +
                (relationshipId != null ? "relationshipId=" + relationshipId + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (lastName != null ? "lastName=" + lastName + ", " : "") +
                (genderId != null ? "genderId=" + genderId + ", " : "") +
                (ageYears != null ? "ageYears=" + ageYears + ", " : "") +
                (ageMonths != null ? "ageMonths=" + ageMonths + ", " : "") +
                (isAlive != null ? "isAlive=" + isAlive + ", " : "") +
                (hivStatusId != null ? "hivStatusId=" + hivStatusId + ", " : "") +
                (onArt != null ? "onArt=" + onArt + ", " : "") +
                (isBeneficiary != null ? "isBeneficiary=" + isBeneficiary + ", " : "") +
                (memberBeneficiaryId != null ? "memberBeneficiaryId=" + memberBeneficiaryId + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDelete != null ? "isDelete=" + isDelete + ", " : "") +
            "}";
    }

}
