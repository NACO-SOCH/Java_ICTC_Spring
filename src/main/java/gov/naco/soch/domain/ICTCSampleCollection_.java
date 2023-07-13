package gov.naco.soch.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCSampleCollection.class)
public abstract class ICTCSampleCollection_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<ICTCSampleCollection, Boolean> isEighteenPlus;
	public static volatile SingularAttribute<ICTCSampleCollection, LocalDateTime> sampleCollectionDate;
	public static volatile SingularAttribute<ICTCSampleCollection, Boolean> isDispatched;
	public static volatile SingularAttribute<ICTCSampleCollection, ICTCSampleBatch> batch;
	public static volatile SingularAttribute<ICTCSampleCollection, Integer> testType;
	public static volatile SingularAttribute<ICTCSampleCollection, Boolean> isActive;
	public static volatile SingularAttribute<ICTCSampleCollection, ICTCBeneficiary> ictcBeneficiary;
	public static volatile SingularAttribute<ICTCSampleCollection, Integer> sampleCollectionStatus;
	public static volatile SingularAttribute<ICTCSampleCollection, UserMaster> labTechnician;
	public static volatile SingularAttribute<ICTCSampleCollection, Boolean> isDeleted;
	public static volatile SingularAttribute<ICTCSampleCollection, LocalDateTime> sampleReceivedDate;
	public static volatile SingularAttribute<ICTCSampleCollection, UserMaster> labIncharge;
	public static volatile SingularAttribute<ICTCSampleCollection, Long> id;
	public static volatile SingularAttribute<ICTCSampleCollection, ICTCVisit> visit;
	public static volatile SingularAttribute<ICTCSampleCollection, String> barcode;
	public static volatile SingularAttribute<ICTCSampleCollection, Facility> facility;

	public static final String IS_EIGHTEEN_PLUS = "isEighteenPlus";
	public static final String SAMPLE_COLLECTION_DATE = "sampleCollectionDate";
	public static final String IS_DISPATCHED = "isDispatched";
	public static final String BATCH = "batch";
	public static final String TEST_TYPE = "testType";
	public static final String IS_ACTIVE = "isActive";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String SAMPLE_COLLECTION_STATUS = "sampleCollectionStatus";
	public static final String LAB_TECHNICIAN = "labTechnician";
	public static final String IS_DELETED = "isDeleted";
	public static final String SAMPLE_RECEIVED_DATE = "sampleReceivedDate";
	public static final String LAB_INCHARGE = "labIncharge";
	public static final String ID = "id";
	public static final String VISIT = "visit";
	public static final String BARCODE = "barcode";
	public static final String FACILITY = "facility";

}

