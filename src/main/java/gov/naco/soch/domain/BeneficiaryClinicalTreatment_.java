package gov.naco.soch.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryClinicalTreatment.class)
public abstract class BeneficiaryClinicalTreatment_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Long> id;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryClinicalTreatment, Long> clinicalTreatmentTypeId;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String CLINICAL_TREATMENT_TYPE_ID = "clinicalTreatmentTypeId";

}

