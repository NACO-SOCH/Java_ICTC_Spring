package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFacilityMapping.class)
public abstract class BeneficiaryFacilityMapping_ {

	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> registrationDate;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> artNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> createdTime;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> preArtNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> pid;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Long> id;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> mappingDate;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Facility> facility;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String ART_NUMBER = "artNumber";
	public static final String CREATED_TIME = "createdTime";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String PID = "pid";
	public static final String ID = "id";
	public static final String MAPPING_DATE = "mappingDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

