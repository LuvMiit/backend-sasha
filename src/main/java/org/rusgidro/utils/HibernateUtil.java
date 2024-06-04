package org.rusgidro.utils;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    @Getter
    private static SessionFactory sessionFactory;
    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Throwable e){
            StandardServiceRegistryBuilder.destroy(registry);
            System.err.println(e);
        }
    }
}
