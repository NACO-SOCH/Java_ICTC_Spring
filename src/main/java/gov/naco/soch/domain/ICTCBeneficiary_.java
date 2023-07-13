package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCBeneficiary.class)
public abstract class ICTCBeneficiary_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<ICTCBeneficiary, String> infantCode;
	public static volatile SingularAttribute<ICTCBeneficiary, Integer> beneficiaryStatus;
	public static volatile SingularAttribute<ICTCBeneficiary, Boolean> isConsentDocumented;
	public static volatile SingularAttribute<ICTCBeneficiary, String> pid;
	public static volatile SingularAttribute<ICTCBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<ICTCBeneficiary, Boolean> isDeleted;
	public static volatile SingularAttribute<ICTCBeneficiary, String> tiReferralName;
	public static volatile SingularAttribute<ICTCBeneficiary, LocalDate> registrationDate;
	public static volatile SingularAttribute<ICTCBeneficiary, String> artReferralName;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> id;
	public static volatile SingularAttribute<ICTCBeneficiary, String> dsrcReferralName;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> currentTestResultId;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> dsrcReferralId;
	public static volatile SingularAttribute<ICTCBeneficiary, LocalDate> dateOfStartOfAntiTbTreatment;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> artReferralId;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> rntcpReferralId;
	public static volatile SingularAttribute<ICTCBeneficiary, Integer> deleteReason;
	public static volatile SingularAttribute<ICTCBeneficiary, String> rntcpReferralName;
	public static volatile SingularAttribute<ICTCBeneficiary, String> deleteReasonComment;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> tiReferralId;
	public static volatile SingularAttribute<ICTCBeneficiary, Boolean> onTbTreatment;
	public static volatile SingularAttribute<ICTCBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ICTCBeneficiary, Integer> referredBy;
	public static volatile SingularAttribute<ICTCBeneficiary, Boolean> onSyphilisTreatment;
	public static volatile SingularAttribute<ICTCBeneficiary, Facility> facility;
	public static volatile SingularAttribute<ICTCBeneficiary, Long> recentVisitId;

	public static final String INFANT_CODE = "infantCode";
	public static final String BENEFICIARY_STATUS = "beneficiaryStatus";
	public static final String IS_CONSENT_DOCUMENTED = "isConsentDocumented";
	public static final String PID = "pid";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_DELETED = "isDeleted";
	public static final String TI_REFERRAL_NAME = "tiReferralName";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String ART_REFERRAL_NAME = "artReferralName";
	public static final String ID = "id";
	public static final String DSRC_REFERRAL_NAME = "dsrcReferralName";
	public static final String CURRENT_TEST_RESULT_ID = "currentTestResultId";
	public static final String DSRC_REFERRAL_ID = "dsrcReferralId";
	public static final String DATE_OF_START_OF_ANTI_TB_TREATMENT = "dateOfStartOfAntiTbTreatment";
	public static final String ART_REFERRAL_ID = "artReferralId";
	public static final String RNTCP_REFERRAL_ID = "rntcpReferralId";
	public static final String DELETE_REASON = "deleteReason";
	public static final String RNTCP_REFERRAL_NAME = "rntcpReferralName";
	public static final String DELETE_REASON_COMMENT = "deleteReasonComment";
	public static final String TI_REFERRAL_ID = "tiReferralId";
	public static final String ON_TB_TREATMENT = "onTbTreatment";
	public static final String BENEFICIARY = "beneficiary";
	public static final String REFERRED_BY = "referredBy";
	public static final String ON_SYPHILIS_TREATMENT = "onSyphilisTreatment";
	public static final String FACILITY = "facility";
	public static final String RECENT_VISIT_ID = "recentVisitId";

}

