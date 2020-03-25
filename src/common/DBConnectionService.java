package common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnectionService {
		
	public static Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure("configuration/hibernate-configuration.xml");
         return cfg.buildSessionFactory().getCurrentSession();
	}
	public static Session openSession() {
		Configuration cfg = new Configuration();
		cfg.configure("configuration/hibernate-configuration.xml");
        return cfg.buildSessionFactory().openSession();
	}
	
}
