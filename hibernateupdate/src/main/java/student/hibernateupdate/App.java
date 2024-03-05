package student.hibernateupdate;

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

        // Edit or modify the data (transaction commit)
        Transaction tx = session.beginTransaction();
        student sToUpdate = session.get(student.class, 1);
        sToUpdate.setName("Golu");
        sToUpdate.setAge(22);
        session.saveOrUpdate(sToUpdate);
        tx.commit();

        session.close();
        sf.close();
    }
}
