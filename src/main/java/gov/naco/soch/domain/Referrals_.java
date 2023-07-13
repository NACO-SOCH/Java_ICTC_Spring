package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Referrals.class)
public abstract class Referrals_ {

	public static volatile SingularAttribute<Referrals, LocalDate> modifiedTime;
	public static volatile SingularAttribute<Referrals, String> referralStatus;
	public static volatile SingularAttribute<Referrals, String> destinationFacilityType;
	public static volatile SingularAttribute<Referrals, Facility> sourceFacility;
	public static volatile SingularAttribute<Referrals, Facility> destinationFacility;
	public static volatile SingularAttribute<Referrals, Boolean> isActive;
	public static volatile SingularAttribute<Referrals, String> ostCode;
	public static volatile SingularAttribute<Referrals, String> dsrcCode;
	public static volatile SingularAttribute<Referrals, String> pidCode;
	public static volatile SingularAttribute<Referrals, String> sourceFacilityType;
	public static volatile SingularAttribute<Referrals, LocalDate> initiationDate;
	public static volatile SingularAttribute<Referrals, Boolean> isDeleted;
	public static volatile SingularAttribute<Referrals, Beneficiary> beneficiary;
	public static volatile SingularAttribute<Referrals, Integer> createdBy;
	public static volatile SingularAttribute<Referrals, String> artCode;
	public static volatile SingularAttribute<Referrals, LocalDate> createdTime;
	public static volatile SingularAttribute<Referrals, LocalDate> reportingDate;
	public static volatile SingularAttribute<Referrals, Integer> modifiedBy;
	public static volatile SingularAttribute<Referrals, Long> id;
	public static volatile SingularAttribute<Referrals, String> tiCode;
	public static volatile SingularAttribute<Referrals, String> category;
	public static volatile SingularAttribute<Referrals, String> hivStatus;
	public static volatile SingularAttribute<Referrals, String> remarks;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String REFERRAL_STATUS = "referralStatus";
	public static final String DESTINATION_FACILITY_TYPE = "destinationFacilityType";
	public static final String SOURCE_FACILITY = "sourceFacility";
	public static final String DESTINATION_FACILITY = "destinationFacility";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String DSRC_CODE = "dsrcCode";
	public static final String PID_CODE = "pidCode";
	public static final String SOURCE_FACILITY_TYPE = "sourceFacilityType";
	public static final String INITIATION_DATE = "initiationDate";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String ART_CODE = "artCode";
	public static final String CREATED_TIME = "createdTime";
	public static final String REPORTING_DATE = "reportingDate";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String CATEGORY = "category";
	public static final String HIV_STATUS = "hivStatus";
	public static final String REMARKS = "remarks";

}

