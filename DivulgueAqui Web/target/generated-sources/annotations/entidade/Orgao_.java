package entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orgao.class)
public abstract class Orgao_ {

	public static volatile CollectionAttribute<Orgao, Publicacao> publicacao;
	public static volatile SingularAttribute<Orgao, String> senha;
	public static volatile SingularAttribute<Orgao, String> nome;
	public static volatile SingularAttribute<Orgao, String> usuario;
	public static volatile SingularAttribute<Orgao, Long> id;
	public static volatile SingularAttribute<Orgao, String> email;

}

