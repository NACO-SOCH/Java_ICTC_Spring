package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transfers.class)
public abstract class Transfers_ {

	public static volatile SingularAttribute<Transfers, LocalDate> modifiedTime;
	public static volatile SingularAttribute<Transfers, String> transferStatus;
	public static volatile SingularAttribute<Transfers, String> destinationFacilityType;
	public static volatile SingularAttribute<Transfers, Facility> sourceFacility;
	public static volatile SingularAttribute<Transfers, Facility> destinationFacility;
	public static volatile SingularAttribute<Transfers, Boolean> isActive;
	public static volatile SingularAttribute<Transfers, String> ostCode;
	public static volatile SingularAttribute<Transfers, String> dsrcCode;
	public static volatile SingularAttribute<Transfers, String> pidCode;
	public static volatile SingularAttribute<Transfers, String> sourceFacilityType;
	public static volatile SingularAttribute<Transfers, LocalDate> initiationDate;
	public static volatile SingularAttribute<Transfers, Boolean> isDeleted;
	public static volatile SingularAttribute<Transfers, Beneficiary> beneficiary;
	public static volatile SingularAttribute<Transfers, Integer> createdBy;
	public static volatile SingularAttribute<Transfers, String> artCode;
	public static volatile SingularAttribute<Transfers, LocalDate> createdTime;
	public static volatile SingularAttribute<Transfers, LocalDate> reportingDate;
	public static volatile SingularAttribute<Transfers, Integer> modifiedBy;
	public static volatile SingularAttribute<Transfers, Long> id;
	public static volatile SingularAttribute<Transfers, String> tiCode;
	public static volatile SingularAttribute<Transfers, String> category;
	public static volatile SingularAttribute<Transfers, String> hivStatus;
	public static volatile SingularAttribute<Transfers, String> remarks;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String TRANSFER_STATUS = "transferStatus";
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

