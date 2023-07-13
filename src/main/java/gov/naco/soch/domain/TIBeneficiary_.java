package gov.naco.soch.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBeneficiary.class)
public abstract class TIBeneficiary_ {

	public static volatile SingularAttribute<TIBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<TIBeneficiary, Long> id;
	public static volatile SingularAttribute<TIBeneficiary, MasterTiClientStatus> status;

	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

