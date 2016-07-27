package com.example.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Taylor on 7/22/2016.
 */

@XmlRootElement(name = "Restaurant")
public class Restaurant {

    private Address address;
    private String cuisine;
    private Grade[] grades;
    private String name;
    private int restaurant_id;

    public Restaurant(int id, Address address, String cuisine, Grade[] grades, String name, int restaurant_id) {
        this.address = address;
        this.cuisine = cuisine;
        this.grades = grades;
        this.name = name;
        this.restaurant_id = restaurant_id;
    }
    @XmlElement
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlElement
    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @XmlElement
    public Grade[] getGrades() {
        return grades;
    }

    public void setGrades(Grade[] grades) {
        this.grades = grades;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
