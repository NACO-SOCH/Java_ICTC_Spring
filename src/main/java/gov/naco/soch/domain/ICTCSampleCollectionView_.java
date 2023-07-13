package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCSampleCollectionView.class)
public abstract class ICTCSampleCollectionView_ {

	public static volatile SingularAttribute<ICTCSampleCollectionView, String> infantCode;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> lastName;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Integer> testType;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> pid;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Long> batchId;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> resultStatusDesc;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> uid;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Long> ictcBeneficiaryId;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Long> visitId;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Integer> infantBreastFed;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Long> testResultId;
	public static volatile SingularAttribute<ICTCSampleCollectionView, LocalDate> visitDate;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Long> id;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> barcode;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> testTypeDesc;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Long> facilityId;
	public static volatile SingularAttribute<ICTCSampleCollectionView, LocalDateTime> sampleCollectionDate;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Integer> genderId;
	public static volatile SingularAttribute<ICTCSampleCollectionView, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> sampleCollectionStatusDesc;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Integer> sampleCollectionStatus;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Integer> resultStatus;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> firstName;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> middleName;
	public static volatile SingularAttribute<ICTCSampleCollectionView, String> age;
	public static volatile SingularAttribute<ICTCSampleCollectionView, Integer> categoryId;

	public static final String INFANT_CODE = "infantCode";
	public static final String LAST_NAME = "lastName";
	public static final String TEST_TYPE = "testType";
	public static final String PID = "pid";
	public static final String BATCH_ID = "batchId";
	public static final String RESULT_STATUS_DESC = "resultStatusDesc";
	public static final String UID = "uid";
	public static final String ICTC_BENEFICIARY_ID = "ictcBeneficiaryId";
	public static final String VISIT_ID = "visitId";
	public static final String INFANT_BREAST_FED = "infantBreastFed";
	public static final String TEST_RESULT_ID = "testResultId";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String BARCODE = "barcode";
	public static final String TEST_TYPE_DESC = "testTypeDesc";
	public static final String FACILITY_ID = "facilityId";
	public static final String SAMPLE_COLLECTION_DATE = "sampleCollectionDate";
	public static final String GENDER_ID = "genderId";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String SAMPLE_COLLECTION_STATUS_DESC = "sampleCollectionStatusDesc";
	public static final String SAMPLE_COLLECTION_STATUS = "sampleCollectionStatus";
	public static final String RESULT_STATUS = "resultStatus";
	public static final String FIRST_NAME = "firstName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String AGE = "age";
	public static final String CATEGORY_ID = "categoryId";

}

