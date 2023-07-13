package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCFollowUp.class)
public abstract class ICTCFollowUp_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<ICTCFollowUp, LocalDate> followUpDate;
	public static volatile SingularAttribute<ICTCFollowUp, Integer> followUpType;
	public static volatile SingularAttribute<ICTCFollowUp, Boolean> isDeleted;
	public static volatile SingularAttribute<ICTCFollowUp, Long> id;
	public static volatile SingularAttribute<ICTCFollowUp, ICTCVisit> visit;
	public static volatile SingularAttribute<ICTCFollowUp, Boolean> isActive;
	public static volatile SingularAttribute<ICTCFollowUp, ICTCBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<ICTCFollowUp, ICTCTestResult> testResult;
	public static volatile SingularAttribute<ICTCFollowUp, Facility> facility;
	public static volatile SingularAttribute<ICTCFollowUp, Boolean> isCompleted;

	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String FOLLOW_UP_TYPE = "followUpType";
	public static final String IS_DELETED = "isDeleted";
	public static final String ID = "id";
	public static final String VISIT = "visit";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String TEST_RESULT = "testResult";
	public static final String FACILITY = "facility";
	public static final String IS_COMPLETED = "isCompleted";

}

