package com.airsme.datamodels;

/**
 * Created by user on 12/11/2017.
 */

public class Individual extends Model {
    private String ID;
    private String name;
    private String surname;
    private String position;
    private String content;
    private String email;
    private String password;
    private Business business;

    @Override
    public String getNode() {
        return "individual";
    }

    public Individual(String name, String surname, String position, String content, String email, String password, Business business) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.content = content;
        this.email = email;
        this.password = password;
        this.business = business;
    }

    public Individual() {
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
