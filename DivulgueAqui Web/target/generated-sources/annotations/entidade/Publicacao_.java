package entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Publicacao.class)
public abstract class Publicacao_ {

	public static volatile SingularAttribute<Publicacao, Date> data;
	public static volatile SingularAttribute<Publicacao, String> localidade;
	public static volatile SingularAttribute<Publicacao, String> categoria;
	public static volatile SingularAttribute<Publicacao, Long> id;
	public static volatile CollectionAttribute<Publicacao, Usuario> usuarios;
	public static volatile SingularAttribute<Publicacao, String> descricao;
	public static volatile SingularAttribute<Publicacao, String> status;

}

