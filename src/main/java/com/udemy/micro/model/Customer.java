package com.udemy.micro.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue()
    int id;
    @Size(min = 2,message="name should be atleast 2 characters")
    String name;

    @Past
    @JsonIgnore
    Date date;

    public Customer() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Date getDate() {
        return date;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Customer(int id, String name, Date date) {
        this.id=id;
        this.name=name;
        this.date=date;
    }
}
