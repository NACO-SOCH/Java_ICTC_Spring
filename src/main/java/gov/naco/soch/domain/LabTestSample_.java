package gov.naco.soch.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabTestSample.class)
public abstract class LabTestSample_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<LabTestSample, Integer> masterResultStatus;
	public static volatile SingularAttribute<LabTestSample, String> barcodeNumber;
	public static volatile SingularAttribute<LabTestSample, Integer> authorizerId;
	public static volatile SingularAttribute<LabTestSample, UserMaster> labInCharge;
	public static volatile SingularAttribute<LabTestSample, String> errorCode;
	public static volatile SingularAttribute<LabTestSample, Integer> testMachineId;
	public static volatile SingularAttribute<LabTestSample, Facility> lab;
	public static volatile SingularAttribute<LabTestSample, String> labTechnicianSignature;
	public static volatile SingularAttribute<LabTestSample, LocalDateTime> sampleDispatchDate;
	public static volatile SingularAttribute<LabTestSample, Integer> testTypeId;
	public static volatile SingularAttribute<LabTestSample, UserMaster> labTechnician;
	public static volatile SingularAttribute<LabTestSample, Boolean> isError;
	public static volatile SingularAttribute<LabTestSample, Integer> resultTypeId;
	public static volatile SingularAttribute<LabTestSample, LocalDateTime> resultDispatchDate;
	public static volatile SingularAttribute<LabTestSample, Long> id;
	public static volatile SingularAttribute<LabTestSample, LocalDateTime> resultReceivedDate;
	public static volatile SingularAttribute<LabTestSample, Integer> testMachineTypeId;
	public static volatile SingularAttribute<LabTestSample, String> testRequestFormLink;
	public static volatile SingularAttribute<LabTestSample, String> typeOfSpecimen;
	public static volatile SingularAttribute<LabTestSample, Integer> sampleStatusId;
	public static volatile SingularAttribute<LabTestSample, String> resultValue;
	public static volatile SingularAttribute<LabTestSample, Boolean> isDelete;
	public static volatile SingularAttribute<LabTestSample, LabTestSampleBatch> batch;
	public static volatile SingularAttribute<LabTestSample, String> authorizerSignature;
	public static volatile SingularAttribute<LabTestSample, String> logValue;
	public static volatile SingularAttribute<LabTestSample, Beneficiary> beneficiary;
	public static volatile SingularAttribute<LabTestSample, Boolean> isUndone;
	public static volatile SingularAttribute<LabTestSample, LocalDateTime> resultApprovedDate;
	public static volatile SingularAttribute<LabTestSample, Integer> remarksId;
	public static volatile SingularAttribute<LabTestSample, LocalDateTime> sampleReceivedDate;
	public static volatile SingularAttribute<LabTestSample, Integer> testId;
	public static volatile SingularAttribute<LabTestSample, String> labInchargeSignature;
	public static volatile SingularAttribute<LabTestSample, LocalDateTime> sampleCollectedDate;
	public static volatile SingularAttribute<LabTestSample, Facility> facility;

	public static final String MASTER_RESULT_STATUS = "masterResultStatus";
	public static final String BARCODE_NUMBER = "barcodeNumber";
	public static final String AUTHORIZER_ID = "authorizerId";
	public static final String LAB_IN_CHARGE = "labInCharge";
	public static final String ERROR_CODE = "errorCode";
	public static final String TEST_MACHINE_ID = "testMachineId";
	public static final String LAB = "lab";
	public static final String LAB_TECHNICIAN_SIGNATURE = "labTechnicianSignature";
	public static final String SAMPLE_DISPATCH_DATE = "sampleDispatchDate";
	public static final String TEST_TYPE_ID = "testTypeId";
	public static final String LAB_TECHNICIAN = "labTechnician";
	public static final String IS_ERROR = "isError";
	public static final String RESULT_TYPE_ID = "resultTypeId";
	public static final String RESULT_DISPATCH_DATE = "resultDispatchDate";
	public static final String ID = "id";
	public static final String RESULT_RECEIVED_DATE = "resultReceivedDate";
	public static final String TEST_MACHINE_TYPE_ID = "testMachineTypeId";
	public static final String TEST_REQUEST_FORM_LINK = "testRequestFormLink";
	public static final String TYPE_OF_SPECIMEN = "typeOfSpecimen";
	public static final String SAMPLE_STATUS_ID = "sampleStatusId";
	public static final String RESULT_VALUE = "resultValue";
	public static final String IS_DELETE = "isDelete";
	public static final String BATCH = "batch";
	public static final String AUTHORIZER_SIGNATURE = "authorizerSignature";
	public static final String LOG_VALUE = "logValue";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_UNDONE = "isUndone";
	public static final String RESULT_APPROVED_DATE = "resultApprovedDate";
	public static final String REMARKS_ID = "remarksId";
	public static final String SAMPLE_RECEIVED_DATE = "sampleReceivedDate";
	public static final String TEST_ID = "testId";
	public static final String LAB_INCHARGE_SIGNATURE = "labInchargeSignature";
	public static final String SAMPLE_COLLECTED_DATE = "sampleCollectedDate";
	public static final String FACILITY = "facility";

}

