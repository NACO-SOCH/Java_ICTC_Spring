package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FICTCBeneficiaryEntity.class)
public abstract class FICTCBeneficiaryEntity_ {

	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> lastName;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> gender;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, LocalDateTime> hivScreeningDate;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> mobileNumber;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, Boolean> profileStatus;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> pid;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> uid;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, ReferredICTC> referredTo;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, LocalDateTime> createdTime;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, Long> modifiedBy;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, Long> id;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> state;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, Boolean> pregnant;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> addressLineOne;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> firstName;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> addressLineTwo;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, Long> createdBy;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> district;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> pinCode;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> pregnancyStatus;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> middleName;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> referredFrom;
	public static volatile SingularAttribute<FICTCBeneficiaryEntity, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String GENDER = "gender";
	public static final String HIV_SCREENING_DATE = "hivScreeningDate";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String PROFILE_STATUS = "profileStatus";
	public static final String PID = "pid";
	public static final String UID = "uid";
	public static final String REFERRED_TO = "referredTo";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String PREGNANT = "pregnant";
	public static final String ADDRESS_LINE_ONE = "addressLineOne";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FIRST_NAME = "firstName";
	public static final String ADDRESS_LINE_TWO = "addressLineTwo";
	public static final String CREATED_BY = "createdBy";
	public static final String DISTRICT = "district";
	public static final String PIN_CODE = "pinCode";
	public static final String PREGNANCY_STATUS = "pregnancyStatus";
	public static final String MIDDLE_NAME = "middleName";
	public static final String REFERRED_FROM = "referredFrom";
	public static final String AGE = "age";

}

