package com.hb01.criteriaAPi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {



        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction trs = session.beginTransaction();

         CriteriaBuilder cb= session.getCriteriaBuilder();
         CriteriaQuery<Actor> criteriaQuery = cb.createQuery(Actor.class);
         Root<Actor> root = criteriaQuery.from(Actor.class);

        //print all actors

//        String hqlQuery= "FROM Actor";
//        List<Actor> actorList = session.createQuery(hqlQuery).getResultList();
//        actorList.forEach(actor -> System.out.println(actor));
//
//
//        System.out.println("--------------------------");
//
//        //print all Actor
//        criteriaQuery.select(root);//SELECT * FROM Actor;
//       List<Actor> list = session.createQuery(criteriaQuery).getResultList();
//       list.forEach(System.out::println);


        //  Example 2: Retrieve actor information with the name "actor2":

//        criteriaQuery.select(root).where(cb.equal(root.get("name"),"actor2"));
//
//        List<Actor> list2 = session.createQuery(criteriaQuery).getResultList();
//        list2.forEach(System.out::println);
//        System.out.println("------------------------");
//
//        Actor list3 = session.createQuery(criteriaQuery).uniqueResult();
//        System.out.println(list3);

        //  Example 3: Retrieve actor information with actorRating greater than 6:

        criteriaQuery.select(root).where(cb.greaterThan(root.get("actorRating"),6));

        List<Actor> list4 = session.createQuery(criteriaQuery).getResultList();
        list4.forEach(System.out::println);

        ////Example 4: Retrieve actor information with actorRating less than 3:



        criteriaQuery.select(root).where(cb.lessThan(root.get("actorRating"),3));

        List<Actor> list5 = session.createQuery(criteriaQuery).getResultList();
        list5.forEach(System.out::println);




        trs.commit();
        session.close();
        sessionFactory.close();

    }
}
