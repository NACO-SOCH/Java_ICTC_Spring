package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCTestResult.class)
public abstract class ICTCTestResult_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<ICTCTestResult, Boolean> isTestedForTb;
	public static volatile SingularAttribute<ICTCTestResult, LocalDateTime> testedDate;
	public static volatile SingularAttribute<ICTCTestResult, Boolean> isTestedForSyphilis;
	public static volatile SingularAttribute<ICTCTestResult, LocalDate> reportReceivedDate;
	public static volatile SingularAttribute<ICTCTestResult, Boolean> isActive;
	public static volatile SingularAttribute<ICTCTestResult, ICTCBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<ICTCTestResult, LocalDate> reportDeliveryDate;
	public static volatile SingularAttribute<ICTCTestResult, Integer> tbTestResult;
	public static volatile SingularAttribute<ICTCTestResult, ICTCSampleCollection> sample;
	public static volatile SingularAttribute<ICTCTestResult, Integer> resultStatus;
	public static volatile SingularAttribute<ICTCTestResult, Integer> hivType;
	public static volatile SingularAttribute<ICTCTestResult, Boolean> isDeleted;
	public static volatile SingularAttribute<ICTCTestResult, Integer> syphilisTestResult;
	public static volatile SingularAttribute<ICTCTestResult, Long> id;
	public static volatile SingularAttribute<ICTCTestResult, ICTCVisit> visit;
	public static volatile SingularAttribute<ICTCTestResult, Integer> hivStatus;

	public static final String IS_TESTED_FOR_TB = "isTestedForTb";
	public static final String TESTED_DATE = "testedDate";
	public static final String IS_TESTED_FOR_SYPHILIS = "isTestedForSyphilis";
	public static final String REPORT_RECEIVED_DATE = "reportReceivedDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String REPORT_DELIVERY_DATE = "reportDeliveryDate";
	public static final String TB_TEST_RESULT = "tbTestResult";
	public static final String SAMPLE = "sample";
	public static final String RESULT_STATUS = "resultStatus";
	public static final String HIV_TYPE = "hivType";
	public static final String IS_DELETED = "isDeleted";
	public static final String SYPHILIS_TEST_RESULT = "syphilisTestResult";
	public static final String ID = "id";
	public static final String VISIT = "visit";
	public static final String HIV_STATUS = "hivStatus";

}

