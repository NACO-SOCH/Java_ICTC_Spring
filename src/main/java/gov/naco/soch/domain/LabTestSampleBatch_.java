package gov.naco.soch.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabTestSampleBatch.class)
public abstract class LabTestSampleBatch_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<LabTestSampleBatch, UserMaster> ictcLabTechnician;
	public static volatile SingularAttribute<LabTestSampleBatch, UserMaster> eidLabTechnician;
	public static volatile SingularAttribute<LabTestSampleBatch, LocalDateTime> dispatchDate;
	public static volatile SingularAttribute<LabTestSampleBatch, Boolean> isDelete;
	public static volatile SingularAttribute<LabTestSampleBatch, Integer> batchStatusId;
	public static volatile SingularAttribute<LabTestSampleBatch, Facility> lab;
	public static volatile SingularAttribute<LabTestSampleBatch, String> bdnSerialNumber;
	public static volatile SingularAttribute<LabTestSampleBatch, Integer> rejectedSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, Integer> acceptedSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, Integer> numOfSamples;
	public static volatile SingularAttribute<LabTestSampleBatch, Long> id;
	public static volatile SingularAttribute<LabTestSampleBatch, LocalDateTime> receivedDate;
	public static volatile SingularAttribute<LabTestSampleBatch, Facility> facility;

	public static final String ICTC_LAB_TECHNICIAN = "ictcLabTechnician";
	public static final String EID_LAB_TECHNICIAN = "eidLabTechnician";
	public static final String DISPATCH_DATE = "dispatchDate";
	public static final String IS_DELETE = "isDelete";
	public static final String BATCH_STATUS_ID = "batchStatusId";
	public static final String LAB = "lab";
	public static final String BDN_SERIAL_NUMBER = "bdnSerialNumber";
	public static final String REJECTED_SAMPLES = "rejectedSamples";
	public static final String ACCEPTED_SAMPLES = "acceptedSamples";
	public static final String NUM_OF_SAMPLES = "numOfSamples";
	public static final String ID = "id";
	public static final String RECEIVED_DATE = "receivedDate";
	public static final String FACILITY = "facility";

}

