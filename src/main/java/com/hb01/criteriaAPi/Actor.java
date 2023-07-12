package com.hb01.criteriaAPi;


import javax.persistence.*;

@Entity
@Table(name = "tbl_actor")
public class Actor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private double actorRating;
    //getter and setter

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getActorRating() {
        return actorRating;
    }

    public void setActorRating(double actorRating) {
        this.actorRating = actorRating;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actorRating=" + actorRating +
                '}';
    }
}
