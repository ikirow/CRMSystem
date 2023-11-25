package com.clientManagementSystem;

import java.io.Serializable;

public class Client implements Serializable {
    private int id = 1;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;

    public Client(int id, String name, String industry, String contactPerson, double revenue) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.revenue = revenue;
    }

    public String getInfo() {
        return this.toString();
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + industry + ", " + contactPerson + ", " + revenue;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }



}
