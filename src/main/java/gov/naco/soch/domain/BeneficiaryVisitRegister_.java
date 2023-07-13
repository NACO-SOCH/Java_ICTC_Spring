package gov.naco.soch.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryVisitRegister.class)
public abstract class BeneficiaryVisitRegister_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDateTime> ostStatusDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Float> weight;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDateTime> ostClientStatusDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, MasterPregnancyTypeCase> masterPregnancyTypeCase;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDate> lmp;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> foursSymptoms;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, String> visitBy;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDateTime> tiClientStatusDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Long> deliveryOutcome;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, LocalDate> visitDate;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Long> id;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Boolean> isPregnant;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Long> facility;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Float> height;
	public static volatile SingularAttribute<BeneficiaryVisitRegister, Long> beneficiaryId;

	public static final String OST_STATUS_DATE = "ostStatusDate";
	public static final String IS_DELETE = "isDelete";
	public static final String WEIGHT = "weight";
	public static final String OST_CLIENT_STATUS_DATE = "ostClientStatusDate";
	public static final String MASTER_PREGNANCY_TYPE_CASE = "masterPregnancyTypeCase";
	public static final String IS_ACTIVE = "isActive";
	public static final String LMP = "lmp";
	public static final String FOURS_SYMPTOMS = "foursSymptoms";
	public static final String VISIT_BY = "visitBy";
	public static final String TI_CLIENT_STATUS_DATE = "tiClientStatusDate";
	public static final String DELIVERY_OUTCOME = "deliveryOutcome";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String IS_PREGNANT = "isPregnant";
	public static final String FACILITY = "facility";
	public static final String HEIGHT = "height";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

