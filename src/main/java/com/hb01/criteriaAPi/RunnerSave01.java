package com.hb01.criteriaAPi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {


        Configuration con= new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Actor.class);

            SessionFactory sessionFactory = con.buildSessionFactory();
            Session session= sessionFactory.openSession();
            Transaction trs = session.beginTransaction();

            //Create 10 object Actor

        double input=1;
        for (int i = 1; i <11 ; i++) {
            Actor actor= new Actor();
            actor.setName("actor"+ i);//actor1 -actor2 -actor10
            actor.setActorRating(input);
            input+=1;//input=input+1;
            session.save(actor);

        }

            trs.commit();
            session.close();
            sessionFactory.close();
    }
}
