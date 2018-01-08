package com.airsme.datamodels;

import java.util.List;

/**
 * Created by user on 12/11/2017.
 */

public class Proxy extends Model {
    private String ID;
    private String pic;
    private String title;
    private String name;
    private String surname;
    private String education;
    private String languages;
    private String transport;
    private String employmentstatus;
    private String aboutme;
    private String accountname;
    private String accountnumber;
    private String branchcode;
    private String profession;
    private List<String> skills;
    private List<String> qualifications;

    @Override
    public String getNode() {
        return "proxy";
    }

    public Proxy(String title) {
        this.title = title;
    }

    public Proxy() {
    }

    public Proxy(String pic, String title, String name, String surname, String education,
                 String languages, String transport, String employmentstatus, String aboutme,
                 String accountname, String accountnumber, String branchcode, String professions,
                 List<String> skills, List<String> qualifications) {
        this.pic = pic;
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.languages = languages;
        this.transport = transport;
        this.employmentstatus = employmentstatus;
        this.aboutme = aboutme;
        this.accountname = accountname;
        this.accountnumber = accountnumber;
        this.branchcode = branchcode;
        this.profession = profession;
        this.skills = skills;
        this.qualifications = qualifications;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getEmploymentstatus() {
        return employmentstatus;
    }

    public void setEmploymentstatus(String employmentstatus) {
        this.employmentstatus = employmentstatus;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }
}