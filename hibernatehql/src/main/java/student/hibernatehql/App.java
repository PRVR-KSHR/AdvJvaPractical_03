package student.hibernatehql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class App 
{
	public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Insert
        student s1 = new student();
        s1.setName("Praveer");
        s1.setAge(21);
        s1.setMarks(85.25);
        s1.setGender("male");
        session.save(s1);

        // HQL Select
        @SuppressWarnings("unchecked")
		List<student> students = session.createQuery("from student").list();
        for (student student : students) {
            System.out.println(student);
        }

        // HQL Update
        int updatedRows = session.createQuery("update student set name = :name where id = :id")
                                .setParameter("name", "Golu")
                                .setParameter("id", 1)
                                .executeUpdate();
        System.out.println("Updated " + updatedRows + " rows.");

        // HQL Delete
        int deletedRows = session.createQuery("delete from student where id = :id")
                                .setParameter("id", 1)
                                .executeUpdate();
        System.out.println("Deleted " + deletedRows + " rows.");

        tx.commit();
        session.close();
        sf.close();
    }
}
