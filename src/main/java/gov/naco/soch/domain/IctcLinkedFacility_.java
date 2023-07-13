package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcLinkedFacility.class)
public abstract class IctcLinkedFacility_ {

	public static volatile SingularAttribute<IctcLinkedFacility, LocalDate> modifiedTime;
	public static volatile SingularAttribute<IctcLinkedFacility, Long> facilityId;
	public static volatile SingularAttribute<IctcLinkedFacility, Long> linkedFacilityId;
	public static volatile SingularAttribute<IctcLinkedFacility, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcLinkedFacility, String> facilityType;
	public static volatile SingularAttribute<IctcLinkedFacility, Long> createdBy;
	public static volatile SingularAttribute<IctcLinkedFacility, LocalDate> createdTime;
	public static volatile SingularAttribute<IctcLinkedFacility, Long> modifiedBy;
	public static volatile SingularAttribute<IctcLinkedFacility, Long> id;
	public static volatile SingularAttribute<IctcLinkedFacility, String> facilityName;
	public static volatile SingularAttribute<IctcLinkedFacility, Boolean> isActive;
	public static volatile SingularAttribute<IctcLinkedFacility, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String FACILITY_ID = "facilityId";
	public static final String LINKED_FACILITY_ID = "linkedFacilityId";
	public static final String IS_DELETED = "isDeleted";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String FACILITY_NAME = "facilityName";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

