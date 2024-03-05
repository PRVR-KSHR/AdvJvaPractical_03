package student.hibernatedelete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        // Delete (transaction commit)
        Transaction tx = session.beginTransaction();
        student sToDelete = session.get(student.class, 1);
        session.delete(sToDelete);
        tx.commit();

        session.close();
        sf.close();
    }
}
