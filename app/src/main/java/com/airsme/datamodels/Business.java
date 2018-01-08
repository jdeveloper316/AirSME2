package com.airsme.datamodels;

import java.util.List;

/**
 * Created by user on 12/11/2017.
 */

public class Business extends Model {
    private String ID;
    private String name;
    private String regno;
    private String vatno;
    private String website;
    private String beelevel;
    private String taxclearance;
    private String type;
    private String logo;
    private String size;
    private List<Tender> tenders;
    private List<Individual> individuals;

    @Override
    public String getNode() {
        return "business";
    }

    public Business(String name, String regno, String vatno, String website, String beelevel,
                    String taxclearance, String type, String size, String logo, List<Tender> tenders,
                    List<Individual> individuals) {
        this.name = name;
        this.regno = regno;
        this.vatno = vatno;
        this.website = website;
        this.beelevel = beelevel;
        this.taxclearance = taxclearance;
        this.type = type;
        this.size = size;
        this.logo = logo;
        this.tenders = tenders;
        this.individuals = individuals;
    }

    public Business() {
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

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getVatno() {
        return vatno;
    }

    public void setVatno(String vatno) {
        this.vatno = vatno;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBeelevel() {
        return beelevel;
    }

    public void setBeelevel(String beelevel) {
        this.beelevel = beelevel;
    }

    public String getTaxclearance() {
        return taxclearance;
    }

    public void setTaxclearance(String taxclearance) {
        this.taxclearance = taxclearance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Tender> getTenders() {
        return tenders;
    }

    public void setTenders(List<Tender> tenders) {
        this.tenders = tenders;
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
    }
}
