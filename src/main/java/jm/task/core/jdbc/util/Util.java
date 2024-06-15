package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    public JDBCUtil getJDBCUtil() {
        return new JDBCUtil();
    }

    public HibernateUtil getHibernateUtil() {
        return new HibernateUtil();
    }

    public class JDBCUtil {


        private Connection connection = null;

        public JDBCUtil() {
            final String URL = "jdbc:mysql://localhost:3306/users";
            final String DB_USER = "root";
            final String DB_PASSWORD = "root";

            try {
                connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                System.out.println("Connection failed");
            }
        }

        public Connection getConnection() {
            return connection;
        }
    }

    public class HibernateUtil {
        private static SessionFactory sessionFactory;

        public SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();

                    // Hibernate settings equivalent to hibernate.cfg.xml's properties
                    Properties settings = new Properties();
                    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/users?useSSL=false");
                    settings.put(Environment.USER, "root");
                    settings.put(Environment.PASS, "root");
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                    settings.put(Environment.SHOW_SQL, "true");

                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                    configuration.setProperties(settings);

                    configuration.addAnnotatedClass(User.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sessionFactory;
        }
    }
}




