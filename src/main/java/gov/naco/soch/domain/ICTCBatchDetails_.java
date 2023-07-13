package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ICTCBatchDetails.class)
public abstract class ICTCBatchDetails_ {

	public static volatile SingularAttribute<ICTCBatchDetails, LocalDateTime> dispatchDate;
	public static volatile SingularAttribute<ICTCBatchDetails, String> consignmentId;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabState;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabCountry;
	public static volatile SingularAttribute<ICTCBatchDetails, LocalDate> reportReceivedDate;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabAddressLineOne;
	public static volatile SingularAttribute<ICTCBatchDetails, Integer> sampleCount;
	public static volatile SingularAttribute<ICTCBatchDetails, Integer> acceptedSampleCount;
	public static volatile SingularAttribute<ICTCBatchDetails, Long> labId;
	public static volatile SingularAttribute<ICTCBatchDetails, Integer> rejectedSampleCount;
	public static volatile SingularAttribute<ICTCBatchDetails, String> ictcName;
	public static volatile SingularAttribute<ICTCBatchDetails, Long> id;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabCode;
	public static volatile SingularAttribute<ICTCBatchDetails, Long> facilityId;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabAddress;
	public static volatile SingularAttribute<ICTCBatchDetails, LocalDateTime> sampleCollectionDate;
	public static volatile SingularAttribute<ICTCBatchDetails, String> batchStatusDesc;
	public static volatile SingularAttribute<ICTCBatchDetails, LocalDate> reportDeliveryDate;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabName;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabTown;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabAddressLineTwo;
	public static volatile SingularAttribute<ICTCBatchDetails, LocalDateTime> sampleReceivedDate;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabDistrict;
	public static volatile SingularAttribute<ICTCBatchDetails, String> eidLabPincode;
	public static volatile SingularAttribute<ICTCBatchDetails, String> batchStatus;
	public static volatile SingularAttribute<ICTCBatchDetails, String> ictcCode;

	public static final String DISPATCH_DATE = "dispatchDate";
	public static final String CONSIGNMENT_ID = "consignmentId";
	public static final String EID_LAB_STATE = "eidLabState";
	public static final String EID_LAB_COUNTRY = "eidLabCountry";
	public static final String REPORT_RECEIVED_DATE = "reportReceivedDate";
	public static final String EID_LAB_ADDRESS_LINE_ONE = "eidLabAddressLineOne";
	public static final String SAMPLE_COUNT = "sampleCount";
	public static final String ACCEPTED_SAMPLE_COUNT = "acceptedSampleCount";
	public static final String LAB_ID = "labId";
	public static final String REJECTED_SAMPLE_COUNT = "rejectedSampleCount";
	public static final String ICTC_NAME = "ictcName";
	public static final String ID = "id";
	public static final String EID_LAB_CODE = "eidLabCode";
	public static final String FACILITY_ID = "facilityId";
	public static final String EID_LAB_ADDRESS = "eidLabAddress";
	public static final String SAMPLE_COLLECTION_DATE = "sampleCollectionDate";
	public static final String BATCH_STATUS_DESC = "batchStatusDesc";
	public static final String REPORT_DELIVERY_DATE = "reportDeliveryDate";
	public static final String EID_LAB_NAME = "eidLabName";
	public static final String EID_LAB_TOWN = "eidLabTown";
	public static final String EID_LAB_ADDRESS_LINE_TWO = "eidLabAddressLineTwo";
	public static final String SAMPLE_RECEIVED_DATE = "sampleReceivedDate";
	public static final String EID_LAB_DISTRICT = "eidLabDistrict";
	public static final String EID_LAB_PINCODE = "eidLabPincode";
	public static final String BATCH_STATUS = "batchStatus";
	public static final String ICTC_CODE = "ictcCode";

}

