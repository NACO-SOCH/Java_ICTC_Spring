package gov.naco.soch.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCSampleBatch.class)
public abstract class ICTCSampleBatch_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<ICTCSampleBatch, Boolean> isDeleted;
	public static volatile SingularAttribute<ICTCSampleBatch, LocalDateTime> dispatchDate;
	public static volatile SingularAttribute<ICTCSampleBatch, String> consignmentId;
	public static volatile SingularAttribute<ICTCSampleBatch, Long> id;
	public static volatile SingularAttribute<ICTCSampleBatch, Boolean> isActive;
	public static volatile SingularAttribute<ICTCSampleBatch, Facility> lab;
	public static volatile SingularAttribute<ICTCSampleBatch, Integer> batchStatus;
	public static volatile SingularAttribute<ICTCSampleBatch, Facility> facility;

	public static final String IS_DELETED = "isDeleted";
	public static final String DISPATCH_DATE = "dispatchDate";
	public static final String CONSIGNMENT_ID = "consignmentId";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String LAB = "lab";
	public static final String BATCH_STATUS = "batchStatus";
	public static final String FACILITY = "facility";

}

