package com.airsme.datamodels;

/**
 * Created by user on 12/11/2017.
 */

public abstract class Model {

    public abstract String getNode();
    public abstract String getID();
    public abstract void setID(String id);
    public boolean save(Model m){

        return true;
    }
    public boolean update(Model m){

        return true;
    }
    public boolean delete(Model m){

        return true;
    }
    public Model retrieve(){

        return null;
    }
    public Model search(Model m){

        return null;
    }

}
