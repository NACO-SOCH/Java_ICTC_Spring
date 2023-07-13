package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCBeneficiaryFollowUpView.class)
public abstract class ICTCBeneficiaryFollowUpView_ {

	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> lastName;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Integer> beneficiaryStatus;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> beneficiaryStatusDesc;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Integer> transmissionRoute;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> mobileNumber;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> pid;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> uid;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Long> ictcBeneficiaryId;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Integer> followUpType;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Long> visitId;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Long> testResultId;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, LocalDate> visitDate;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Long> id;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, LocalDate> deliveryDate;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Boolean> isCompleted;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, LocalDate> pregnancyLmpDate;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Long> facilityId;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, LocalDate> expectedDeliveryDate;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Integer> genderId;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, LocalDate> followUpDate;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> firstName;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> middleName;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, String> age;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Integer> categoryId;
	public static volatile SingularAttribute<ICTCBeneficiaryFollowUpView, Long> beneficiaryId;

	public static final String LAST_NAME = "lastName";
	public static final String BENEFICIARY_STATUS = "beneficiaryStatus";
	public static final String BENEFICIARY_STATUS_DESC = "beneficiaryStatusDesc";
	public static final String TRANSMISSION_ROUTE = "transmissionRoute";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String PID = "pid";
	public static final String UID = "uid";
	public static final String ICTC_BENEFICIARY_ID = "ictcBeneficiaryId";
	public static final String FOLLOW_UP_TYPE = "followUpType";
	public static final String VISIT_ID = "visitId";
	public static final String TEST_RESULT_ID = "testResultId";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String DELIVERY_DATE = "deliveryDate";
	public static final String IS_COMPLETED = "isCompleted";
	public static final String PREGNANCY_LMP_DATE = "pregnancyLmpDate";
	public static final String FACILITY_ID = "facilityId";
	public static final String EXPECTED_DELIVERY_DATE = "expectedDeliveryDate";
	public static final String GENDER_ID = "genderId";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String AGE = "age";
	public static final String CATEGORY_ID = "categoryId";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

