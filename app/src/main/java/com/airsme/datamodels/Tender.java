package com.airsme.datamodels;

import java.util.Date;

/**
 * Created by user on 12/11/2017.
 */

public class Tender extends Model {
    private String ID;
    private String tenderno;
    private String businessUid;
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


    private String status="Pending";
    private String name="Tender name";


    private String notes;
    private String maplocation;
    private String contactperson;
    private String courierOptions;

    @Override
    public String getNode() {
        return "tender";
    }

    @Override
    public String getPKeyValue() {
        return ID;
    }

    @Override
    public String getPKeyName() {
        return "tenderno";
    }

    @Override
    public void setPKeyValue(String id) {
        this.ID=id;
    }


    public Tender(String tenderno, String businessUid, Date date, String time, String building,
                  String unit, String floor, String street, String surbub, String town,
                  String contact, String email) {
        this.tenderno = tenderno;
        this.businessUid = businessUid;
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
        date=new Date();
    }

    public String getImageURL() {
        return "images/tender/"+getTenderno();
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenderno() {
        return tenderno;
    }

    public void setTenderno(String tenderno) {
        this.tenderno = tenderno;
    }

    public String getBusinessUid() {
        return businessUid;
    }

    public void setBusinessUid(String businessUid) {
        this.businessUid = businessUid;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMaplocation() {
        return maplocation;
    }

    public void setMaplocation(String maplocation) {
        this.maplocation = maplocation;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getCourierOptions() {
        return courierOptions;
    }

    public void setCourierOptions(String courierOptions) {
        this.courierOptions = courierOptions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "ID='" + ID + '\'' +
                ", tenderno='" + tenderno + '\'' +
                ", businessUid='" + businessUid + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", building='" + building + '\'' +
                ", unit='" + unit + '\'' +
                ", floor='" + floor + '\'' +
                ", street='" + street + '\'' +
                ", surbub='" + surbub + '\'' +
                ", town='" + town + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", notes='" + notes + '\'' +
                ", maplocation='" + maplocation + '\'' +
                ", contactperson='" + contactperson + '\'' +
                ", courierOptions='" + courierOptions + '\'' +
                '}';
    }
    public String toPrint() {
        return  "tenderno='" + tenderno + '\'' +'\n'+
                "date=" + date +'\n'+
                "time='" + time + '\'' +'\n'+
                "building='" + building + '\'' +'\n'+
                "unit='" + unit + '\'' +'\n'+
                "floor='" + floor + '\'' +'\n'+
                "street='" + street + '\'' +'\n'+
                "surbub='" + surbub + '\'' +'\n'+
                "town='" + town + '\'' +'\n'+
                "contact='" + contact + '\'' +'\n'+
                "email='" + email + '\'' +'\n'+
                "notes='" + notes + '\'' +'\n'+
                "maplocation='" + maplocation + '\'' +'\n'+
                "contactperson='" + contactperson + '\'' +'\n'+
                "courierOptions='" + courierOptions + '\'';
    }
}
