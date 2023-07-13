package gov.naco.soch.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Facility.class)
public abstract class Facility_ {

	public static volatile SingularAttribute<Facility, String> code;
	public static volatile SingularAttribute<Facility, Address> address;
	public static volatile SingularAttribute<Facility, Boolean> isDelete;
	public static volatile SingularAttribute<Facility, String> name;
	public static volatile SingularAttribute<Facility, Long> facilityTypeId;
	public static volatile SingularAttribute<Facility, Long> id;
	public static volatile SingularAttribute<Facility, Boolean> isActive;

	public static final String CODE = "code";
	public static final String ADDRESS = "address";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String FACILITY_TYPE_ID = "facilityTypeId";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

