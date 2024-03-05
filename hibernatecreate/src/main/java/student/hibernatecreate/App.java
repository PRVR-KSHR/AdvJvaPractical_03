package student.hibernatecreate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App{
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        // Insert
        student s1 = new student();
        s1.setName("Praveer");
        s1.setAge(21);
        s1.setMarks(85.25);
        s1.setGender("male");

        Transaction tx = session.beginTransaction();
        session.save(s1);
        tx.commit();

        session.close();
        sf.close();
    }
}

