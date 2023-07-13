package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFamilyDetails.class)
public abstract class BeneficiaryFamilyDetails_ {

	public static volatile SingularAttribute<BeneficiaryFamilyDetails, String> lastName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, LocalDate> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> ageMonths;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> hivStatusId;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> genderId;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Boolean> onArt;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> relationshipId;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Beneficiary> memberBeneficiary;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, String> firstName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Boolean> isAlive;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Long> memberBeneficiaryId;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> ageYears;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, String> familyUid;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, LocalDate> createdTime;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, String> middleName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Long> id;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Boolean> isBeneficiary;
	public static volatile SingularAttribute<BeneficiaryFamilyDetails, Long> beneficiaryId;

	public static final String LAST_NAME = "lastName";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String AGE_MONTHS = "ageMonths";
	public static final String HIV_STATUS_ID = "hivStatusId";
	public static final String IS_DELETE = "isDelete";
	public static final String GENDER_ID = "genderId";
	public static final String ON_ART = "onArt";
	public static final String RELATIONSHIP_ID = "relationshipId";
	public static final String IS_ACTIVE = "isActive";
	public static final String MEMBER_BENEFICIARY = "memberBeneficiary";
	public static final String FIRST_NAME = "firstName";
	public static final String IS_ALIVE = "isAlive";
	public static final String MEMBER_BENEFICIARY_ID = "memberBeneficiaryId";
	public static final String AGE_YEARS = "ageYears";
	public static final String CREATED_BY = "createdBy";
	public static final String FAMILY_UID = "familyUid";
	public static final String CREATED_TIME = "createdTime";
	public static final String MIDDLE_NAME = "middleName";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_BENEFICIARY = "isBeneficiary";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

