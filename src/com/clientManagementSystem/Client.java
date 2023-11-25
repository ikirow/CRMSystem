package com.clientManagementSystem;

import java.io.Serializable;

public class Client implements Serializable {
    private int ID = 1;
    private String name;
    private String industry;
    private String contactPerson;
    private double revenue;

    public Client(int ID, String name, String industry, String contactPerson, double revenue) {
        this.ID = ID;
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
        return ID + ',' + name + ',' + industry + ',' + contactPerson + ',' + revenue;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
