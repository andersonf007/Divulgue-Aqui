package com.github.izaquias.divulgueaquiweb.model;

import com.github.izaquias.divulgueaquiweb.model.Problema;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-20T15:34:18")
@StaticMetamodel(Orgao.class)
public class Orgao_ { 

    public static volatile SingularAttribute<Orgao, String> endereco;
    public static volatile ListAttribute<Orgao, Problema> problemas;
    public static volatile SingularAttribute<Orgao, String> nome;
    public static volatile SingularAttribute<Orgao, Long> id;

}