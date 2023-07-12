package hb02.cachingLevel;

import com.hb01.criteriaAPi.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {


        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

       //create Developer Object

        Developer developer1= new Developer();
        developer1.setName("Linda Tuba");
        developer1.setDeveloperSalary(900.0);

        Developer developer2= new Developer();
        developer2.setName("Zia Muslih");
        developer2.setDeveloperSalary(950.0);

        Developer developer3= new Developer();
        developer3.setName("Esra Tuba");
        developer3.setDeveloperSalary(800.0);

        session.save(developer1);
        session.save(developer2);
        session.save(developer3);




        trs.commit();
        session.close();
        sessionFactory.close();

    }
}
