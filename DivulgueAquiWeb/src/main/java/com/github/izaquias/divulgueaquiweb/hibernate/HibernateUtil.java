package com.github.izaquias.divulgueaquiweb.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Izaquias
 */
public class HibernateUtil {

    private final EntityManagerFactory factory;
    private static HibernateUtil hibernateUtil;

    //Estabelece a conexão com o BD!
    private HibernateUtil() {
        factory = Persistence.createEntityManagerFactory("Persistencia");//Persistencia: nome referenciado no persistence.xml
    }

    //Retorna a instância da classe EntityManagerFactory!
    public EntityManagerFactory getFactory() {
        return factory;
    }

    //Verifica se a instância já foi criada, se sim, retorna a instância, caso contrário cria uma!
    public static HibernateUtil getInstance() {
        if (hibernateUtil == null) {
            hibernateUtil = new HibernateUtil();
        }
        return hibernateUtil;
    }
}
