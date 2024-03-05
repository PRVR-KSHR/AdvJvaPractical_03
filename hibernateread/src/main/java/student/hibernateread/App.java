package student.hibernateread;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
	 public static void main(String[] args) {
	        Configuration config = new Configuration();
	        config.configure("hibernate.cfg.xml");

	        SessionFactory sf = config.buildSessionFactory();
	        Session session = sf.openSession();

	        // Fetch
	        student fetchedStudent = session.get(student.class, 1);
	        System.out.println(fetchedStudent);

	        session.close();
	        sf.close();
	    }
}
