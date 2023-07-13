package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserMaster.class)
public abstract class UserMaster_ {

	public static volatile SingularAttribute<UserMaster, String> firstname;
	public static volatile SingularAttribute<UserMaster, Long> designationId;
	public static volatile SingularAttribute<UserMaster, Boolean> isDelete;
	public static volatile SingularAttribute<UserMaster, String> mobileNumber;
	public static volatile SingularAttribute<UserMaster, String> orwCode;
	public static volatile SingularAttribute<UserMaster, LocalDate> lastDateOfTraining;
	public static volatile SingularAttribute<UserMaster, String> landlineNumber;
	public static volatile SingularAttribute<UserMaster, String> peCode;
	public static volatile SingularAttribute<UserMaster, Boolean> isActive;
	public static volatile SingularAttribute<UserMaster, Boolean> activeRole;
	public static volatile SingularAttribute<UserMaster, String> lastname;
	public static volatile SingularAttribute<UserMaster, Long> id;
	public static volatile SingularAttribute<UserMaster, Facility> facility;
	public static volatile SingularAttribute<UserMaster, String> email;
	public static volatile SingularAttribute<UserMaster, String> isBeneficiary;

	public static final String FIRSTNAME = "firstname";
	public static final String DESIGNATION_ID = "designationId";
	public static final String IS_DELETE = "isDelete";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String ORW_CODE = "orwCode";
	public static final String LAST_DATE_OF_TRAINING = "lastDateOfTraining";
	public static final String LANDLINE_NUMBER = "landlineNumber";
	public static final String PE_CODE = "peCode";
	public static final String IS_ACTIVE = "isActive";
	public static final String ACTIVE_ROLE = "activeRole";
	public static final String LASTNAME = "lastname";
	public static final String ID = "id";
	public static final String FACILITY = "facility";
	public static final String EMAIL = "email";
	public static final String IS_BENEFICIARY = "isBeneficiary";

}

