package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryMultiFacilityService.class)
public abstract class BeneficiaryMultiFacilityService_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, LocalDate> followUpDate;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Boolean> isDeleted;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Boolean> isIctcPostTestCounsellingCompleted;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Long> ictcVisitId;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Long> visitedFacilityId;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, LocalDate> visitDate;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Long> id;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Long> beneficiaryGlobalVisitId;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, LocalDate> postTestCounsellingDate;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Long> beneficiaryId;
	public static volatile SingularAttribute<BeneficiaryMultiFacilityService, Long> registeredFacilityId;

	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String IS_DELETED = "isDeleted";
	public static final String IS_ICTC_POST_TEST_COUNSELLING_COMPLETED = "isIctcPostTestCounsellingCompleted";
	public static final String ICTC_VISIT_ID = "ictcVisitId";
	public static final String VISITED_FACILITY_ID = "visitedFacilityId";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String BENEFICIARY_GLOBAL_VISIT_ID = "beneficiaryGlobalVisitId";
	public static final String POST_TEST_COUNSELLING_DATE = "postTestCounsellingDate";
	public static final String BENEFICIARY_ID = "beneficiaryId";
	public static final String REGISTERED_FACILITY_ID = "registeredFacilityId";

}

