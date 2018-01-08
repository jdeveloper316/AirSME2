package com.airsme.datamodels;

import com.google.firebase.database.IgnoreExtraProperties;

// [START blog_user_class]
@IgnoreExtraProperties
public class User extends Model {
    private String ID;
    private String uid;
    private Role roles;

    @Override
    public String getNode() {
        return "user";
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
        this.uid=ID;
    }

    public static enum Role{BUSINESS, PROXY};

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
        this.ID = uid;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String uid, Role roles) {
        this.uid = uid;
        this.ID = this.uid;
        this.roles = roles;
    }

}
// [END blog_user_class]
