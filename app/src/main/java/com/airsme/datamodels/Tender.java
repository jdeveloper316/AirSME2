package com.airsme.datamodels;

import java.util.Date;

/**
 * Created by user on 12/11/2017.
 */

public class Tender extends Model {
    private String ID;
    private String tenderno;
    private String businessname;
    private Date date;
    private String time;
    private String building;
    private String unit;
    private String floor;
    private String street;
    private String surbub;
    private String town;
    private String contact;
    private String email;

    @Override
    public String getNode() {
        return "tender";
    }

    public Tender(String tenderno, String businessname, Date date, String time, String building,
                  String unit, String floor, String street, String surbub, String town,
                  String contact, String email) {
        this.tenderno = tenderno;
        this.businessname = businessname;
        this.date = date;
        this.time = time;
        this.building = building;
        this.unit = unit;
        this.floor = floor;
        this.street = street;
        this.surbub = surbub;
        this.town = town;
        this.contact = contact;
        this.email = email;
    }

    public Tender() {
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenderno() {
        return tenderno;
    }

    public void setTenderno(String tenderno) {
        this.tenderno = tenderno;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSurbub() {
        return surbub;
    }

    public void setSurbub(String surbub) {
        this.surbub = surbub;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
