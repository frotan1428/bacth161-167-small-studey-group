package hb02.cachingLevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class RunnerFetch02 {

    public static void main(String[] args) {

        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

        //Query Cache Level

        Query query = session.createQuery("FROM Developer").setCacheable(true);
        System.out.println("First call method in the session ....");
        query.getResultList();//1 st Query

        System.out.println("Second call the method in the same session ");

        query.getResultList();//2nd Query

       List<Developer>  list = query.getResultList(); // 3th Query

       for (Developer dev:list){
           System.out.println(dev.getName());
       }

        //First Level Cache

//        System.out.println("First Get method for developer With Id 1 ");
//
//         Developer developer1 =  session.get(Developer.class,1);
//         System.out.println(developer1);

       //  session.clear();

//        System.out.println("Second  Get method for developer With Id 1 ");
//
//        Developer developer2 =  session.get(Developer.class,1);
//        System.out.println(developer2);


        trs.commit();
        session.close();




//        Session session1= sessionFactory.openSession();
//        Transaction transaction =  session1.beginTransaction();
//
//
//        System.out.println("Third  Get method for developer With Id 1 ");
//
//        Developer developer3 =  session1.get(Developer.class,1);//second Cache Level .
//        System.out.println(developer3);
//
//
//        transaction.commit();
//        session1.close();


        sessionFactory.close();

    }
}
