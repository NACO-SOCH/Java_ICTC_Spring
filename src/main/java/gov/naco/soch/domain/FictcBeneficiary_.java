package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FictcBeneficiary.class)
public abstract class FictcBeneficiary_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<FictcBeneficiary, LocalDate> hivScreeningDate;
	public static volatile SingularAttribute<FictcBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<FictcBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<FictcBeneficiary, Boolean> profileStatus;
	public static volatile SingularAttribute<FictcBeneficiary, MasterPregnancyTypeCase> pregnancyType;
	public static volatile SingularAttribute<FictcBeneficiary, Long> id;
	public static volatile SingularAttribute<FictcBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<FictcBeneficiary, Boolean> isPregnant;
	public static volatile SingularAttribute<FictcBeneficiary, Facility> facility;

	public static final String HIV_SCREENING_DATE = "hivScreeningDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String PROFILE_STATUS = "profileStatus";
	public static final String PREGNANCY_TYPE = "pregnancyType";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_PREGNANT = "isPregnant";
	public static final String FACILITY = "facility";

}

