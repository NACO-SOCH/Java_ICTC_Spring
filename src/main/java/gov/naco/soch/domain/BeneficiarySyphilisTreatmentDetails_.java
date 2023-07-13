package gov.naco.soch.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiarySyphilisTreatmentDetails.class)
public abstract class BeneficiarySyphilisTreatmentDetails_ extends gov.naco.soch.domain.Auditable_ {

	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Long> syphilisTestResultId;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isTreatmentCompleted;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, BeneficiaryClinicalTreatment> beneficiaryClinicalTreatment;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Long> id;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isActive;

	public static final String SYPHILIS_TEST_RESULT_ID = "syphilisTestResultId";
	public static final String IS_TREATMENT_COMPLETED = "isTreatmentCompleted";
	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_CLINICAL_TREATMENT = "beneficiaryClinicalTreatment";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

