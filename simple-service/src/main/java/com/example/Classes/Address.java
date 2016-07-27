package com.example.Classes;

/**
 * Created by Taylor on 7/22/2016.
 */
public class Address {
    private String building;
    private Coordinate coord;
    private String street;
    int zipcode;

    public Address(String building, Coordinate coord, String street) {
        this.building = building;
        this.coord = coord;
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) throws IllegalArgumentException{
        this.coord.setLatitude(coord.getLatitude());
        this.coord.setLongitude(coord.getLongitude());
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
