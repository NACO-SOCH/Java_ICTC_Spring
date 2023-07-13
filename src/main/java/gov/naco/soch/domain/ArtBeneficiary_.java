package gov.naco.soch.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiary.class)
public abstract class ArtBeneficiary_ {

	public static volatile SingularAttribute<ArtBeneficiary, Boolean> lacLinked;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> artStartDate;
	public static volatile SingularAttribute<ArtBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiary, Long> artBeneficiaryStatusId;
	public static volatile SingularAttribute<ArtBeneficiary, String> linkageInstituteName;
	public static volatile SingularAttribute<ArtBeneficiary, Long> id;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> artRegistrationDate;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> artEligibilityDate;
	public static volatile SingularAttribute<ArtBeneficiary, Facility> facility;
	public static volatile SingularAttribute<ArtBeneficiary, Long> hivRiskFactorId;

	public static final String LAC_LINKED = "lacLinked";
	public static final String ART_START_DATE = "artStartDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ART_BENEFICIARY_STATUS_ID = "artBeneficiaryStatusId";
	public static final String LINKAGE_INSTITUTE_NAME = "linkageInstituteName";
	public static final String ID = "id";
	public static final String ART_REGISTRATION_DATE = "artRegistrationDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String ART_ELIGIBILITY_DATE = "artEligibilityDate";
	public static final String FACILITY = "facility";
	public static final String HIV_RISK_FACTOR_ID = "hivRiskFactorId";

}

