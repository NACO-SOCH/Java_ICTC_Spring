package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcPartnerDetails.class)
public abstract class IctcPartnerDetails_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<IctcPartnerDetails, Integer> partnerStatusKnown;
	public static volatile SingularAttribute<IctcPartnerDetails, ICTCFollowUp> followUp;
	public static volatile SingularAttribute<IctcPartnerDetails, LocalDate> createdDate;
	public static volatile SingularAttribute<IctcPartnerDetails, Integer> partnerHivStatus;
	public static volatile SingularAttribute<IctcPartnerDetails, Boolean> isPartnerPrevTreatedForHiv;
	public static volatile SingularAttribute<IctcPartnerDetails, LocalDate> partnerTestFollowUpDate;
	public static volatile SingularAttribute<IctcPartnerDetails, Long> id;
	public static volatile SingularAttribute<IctcPartnerDetails, Facility> partnerArtCenter;
	public static volatile SingularAttribute<IctcPartnerDetails, ICTCBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<IctcPartnerDetails, Integer> partnerNotTestedReason;

	public static final String PARTNER_STATUS_KNOWN = "partnerStatusKnown";
	public static final String FOLLOW_UP = "followUp";
	public static final String CREATED_DATE = "createdDate";
	public static final String PARTNER_HIV_STATUS = "partnerHivStatus";
	public static final String IS_PARTNER_PREV_TREATED_FOR_HIV = "isPartnerPrevTreatedForHiv";
	public static final String PARTNER_TEST_FOLLOW_UP_DATE = "partnerTestFollowUpDate";
	public static final String ID = "id";
	public static final String PARTNER_ART_CENTER = "partnerArtCenter";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String PARTNER_NOT_TESTED_REASON = "partnerNotTestedReason";

}

