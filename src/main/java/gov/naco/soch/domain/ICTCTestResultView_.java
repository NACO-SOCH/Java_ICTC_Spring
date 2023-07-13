package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCTestResultView.class)
public abstract class ICTCTestResultView_ {

	public static volatile SingularAttribute<ICTCTestResultView, String> infantCode;
	public static volatile SingularAttribute<ICTCTestResultView, String> lastName;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDate> referDate;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDateTime> testedDate;
	public static volatile SingularAttribute<ICTCTestResultView, String> consignmentId;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> testType;
	public static volatile SingularAttribute<ICTCTestResultView, String> labName;
	public static volatile SingularAttribute<ICTCTestResultView, String> artCenterCode;
	public static volatile SingularAttribute<ICTCTestResultView, Long> batchId;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDate> reportReceivedDate;
	public static volatile SingularAttribute<ICTCTestResultView, String> hivStatusDesc;
	public static volatile SingularAttribute<ICTCTestResultView, String> resultStatusDesc;
	public static volatile SingularAttribute<ICTCTestResultView, String> uid;
	public static volatile SingularAttribute<ICTCTestResultView, Long> ictcBeneficiaryId;
	public static volatile SingularAttribute<ICTCTestResultView, Long> visitId;
	public static volatile SingularAttribute<ICTCTestResultView, Long> labId;
	public static volatile SingularAttribute<ICTCTestResultView, Long> id;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> hivStatus;
	public static volatile SingularAttribute<ICTCTestResultView, String> barcode;
	public static volatile SingularAttribute<ICTCTestResultView, String> testTypeDesc;
	public static volatile SingularAttribute<ICTCTestResultView, Long> facilityId;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDateTime> sampleCollectionDate;
	public static volatile SingularAttribute<ICTCTestResultView, Long> sampleId;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> genderId;
	public static volatile SingularAttribute<ICTCTestResultView, String> batchStatusDesc;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<ICTCTestResultView, Long> sampleCollectedLabId;
	public static volatile SingularAttribute<ICTCTestResultView, String> sampleCollectionStatusDesc;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDate> reportDeliveryDate;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> currentHivType;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> sampleCollectionStatus;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> resultStatus;
	public static volatile SingularAttribute<ICTCTestResultView, LocalDate> followUpDate;
	public static volatile SingularAttribute<ICTCTestResultView, String> artCenterName;
	public static volatile SingularAttribute<ICTCTestResultView, String> firstName;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> currentHivStatus;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> hivType;
	public static volatile SingularAttribute<ICTCTestResultView, String> labCode;
	public static volatile SingularAttribute<ICTCTestResultView, String> hivTypeDesc;
	public static volatile SingularAttribute<ICTCTestResultView, String> middleName;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> batchStatus;
	public static volatile SingularAttribute<ICTCTestResultView, String> age;
	public static volatile SingularAttribute<ICTCTestResultView, Integer> categoryId;
	public static volatile SingularAttribute<ICTCTestResultView, Long> beneficiaryId;

	public static final String INFANT_CODE = "infantCode";
	public static final String LAST_NAME = "lastName";
	public static final String REFER_DATE = "referDate";
	public static final String TESTED_DATE = "testedDate";
	public static final String CONSIGNMENT_ID = "consignmentId";
	public static final String TEST_TYPE = "testType";
	public static final String LAB_NAME = "labName";
	public static final String ART_CENTER_CODE = "artCenterCode";
	public static final String BATCH_ID = "batchId";
	public static final String REPORT_RECEIVED_DATE = "reportReceivedDate";
	public static final String HIV_STATUS_DESC = "hivStatusDesc";
	public static final String RESULT_STATUS_DESC = "resultStatusDesc";
	public static final String UID = "uid";
	public static final String ICTC_BENEFICIARY_ID = "ictcBeneficiaryId";
	public static final String VISIT_ID = "visitId";
	public static final String LAB_ID = "labId";
	public static final String ID = "id";
	public static final String HIV_STATUS = "hivStatus";
	public static final String BARCODE = "barcode";
	public static final String TEST_TYPE_DESC = "testTypeDesc";
	public static final String FACILITY_ID = "facilityId";
	public static final String SAMPLE_COLLECTION_DATE = "sampleCollectionDate";
	public static final String SAMPLE_ID = "sampleId";
	public static final String GENDER_ID = "genderId";
	public static final String BATCH_STATUS_DESC = "batchStatusDesc";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String SAMPLE_COLLECTED_LAB_ID = "sampleCollectedLabId";
	public static final String SAMPLE_COLLECTION_STATUS_DESC = "sampleCollectionStatusDesc";
	public static final String REPORT_DELIVERY_DATE = "reportDeliveryDate";
	public static final String CURRENT_HIV_TYPE = "currentHivType";
	public static final String SAMPLE_COLLECTION_STATUS = "sampleCollectionStatus";
	public static final String RESULT_STATUS = "resultStatus";
	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String ART_CENTER_NAME = "artCenterName";
	public static final String FIRST_NAME = "firstName";
	public static final String CURRENT_HIV_STATUS = "currentHivStatus";
	public static final String HIV_TYPE = "hivType";
	public static final String LAB_CODE = "labCode";
	public static final String HIV_TYPE_DESC = "hivTypeDesc";
	public static final String MIDDLE_NAME = "middleName";
	public static final String BATCH_STATUS = "batchStatus";
	public static final String AGE = "age";
	public static final String CATEGORY_ID = "categoryId";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

