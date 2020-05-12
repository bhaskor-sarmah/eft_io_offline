/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Bhaskor
 */
public class HibernateUtil {

     private static final  SessionFactory sessionFactory;
     private static final  ServiceRegistry serviceRegistry;
     static {
          try {
               Configuration config = getConfiguration();
               serviceRegistry = new ServiceRegistryBuilder().applySettings(
                         config.getProperties()).buildServiceRegistry();
               config.setSessionFactoryObserver(new SessionFactoryObserver() {
                    private static final long  serialVersionUID = 1L;



                    @Override
                    public void sessionFactoryCreated(SessionFactory factory) {
                    }



                    @Override
                    public void sessionFactoryClosed(SessionFactory factory) {
                         ServiceRegistryBuilder.destroy(serviceRegistry);
                    }
               });
               sessionFactory = config.buildSessionFactory(serviceRegistry);
          } catch (Throwable ex) {
               System.err.println("Initial SessionFactory creation failed." + ex);
               throw new ExceptionInInitializerError(ex);
          }
     }
     public static  Session openSession() {
          return sessionFactory.openSession();
     }



     private static  Configuration getConfiguration() {
          Configuration cfg = new Configuration();
//          cfg.addAnnotatedClass(PinMaster.class );
          cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
          cfg.setProperty("hibernate.connection.url","jdbc:mysql://localhost/hr");
          cfg.setProperty("hibernate.connection.username", "user1");
          cfg.setProperty("hibernate.connection.password", "secret");
          cfg.setProperty("hibernate.show_sql", "true");
          cfg.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLSQLDialect");
          cfg.setProperty("hibernate.hbm2ddl.auto", "update");
          cfg.setProperty("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");
          cfg.setProperty("hibernate.current_session_context_class", "thread");
          return cfg;
     }
}