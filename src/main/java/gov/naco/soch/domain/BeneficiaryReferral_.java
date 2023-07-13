package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReferral.class)
public abstract class BeneficiaryReferral_ {

	public static volatile SingularAttribute<BeneficiaryReferral, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryReferral, Facility> referedTo;
	public static volatile SingularAttribute<BeneficiaryReferral, LocalDate> referDate;
	public static volatile SingularAttribute<BeneficiaryReferral, String> referralReason;
	public static volatile SingularAttribute<BeneficiaryReferral, Integer> referralStatusId;
	public static volatile SingularAttribute<BeneficiaryReferral, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryReferral, Facility> referedFrom;
	public static volatile SingularAttribute<BeneficiaryReferral, Long> tiBeneficiaryId;
	public static volatile SingularAttribute<BeneficiaryReferral, LocalDate> dateOfVisit;
	public static volatile SingularAttribute<BeneficiaryReferral, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryReferral, LocalDate> acceptedDate;
	public static volatile SingularAttribute<BeneficiaryReferral, String> referralType;
	public static volatile SingularAttribute<BeneficiaryReferral, LocalDate> declinedDate;
	public static volatile SingularAttribute<BeneficiaryReferral, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryReferral, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryReferral, Long> tiBenScrId;
	public static volatile SingularAttribute<BeneficiaryReferral, Facility> acceptedFacility;
	public static volatile SingularAttribute<BeneficiaryReferral, Integer> referredBy;
	public static volatile SingularAttribute<BeneficiaryReferral, LocalDateTime> createdTime;
	public static volatile SingularAttribute<BeneficiaryReferral, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryReferral, Long> id;
	public static volatile SingularAttribute<BeneficiaryReferral, Integer> referralTypeId;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String REFERED_TO = "referedTo";
	public static final String REFER_DATE = "referDate";
	public static final String REFERRAL_REASON = "referralReason";
	public static final String REFERRAL_STATUS_ID = "referralStatusId";
	public static final String IS_DELETE = "isDelete";
	public static final String REFERED_FROM = "referedFrom";
	public static final String TI_BENEFICIARY_ID = "tiBeneficiaryId";
	public static final String DATE_OF_VISIT = "dateOfVisit";
	public static final String IS_ACTIVE = "isActive";
	public static final String ACCEPTED_DATE = "acceptedDate";
	public static final String REFERRAL_TYPE = "referralType";
	public static final String DECLINED_DATE = "declinedDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String TI_BEN_SCR_ID = "tiBenScrId";
	public static final String ACCEPTED_FACILITY = "acceptedFacility";
	public static final String REFERRED_BY = "referredBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String REFERRAL_TYPE_ID = "referralTypeId";

}

