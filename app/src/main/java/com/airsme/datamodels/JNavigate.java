package com.airsme.datamodels;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.airsme.airsme2.BDashboard;
import com.airsme.airsme2.BSignup;
import com.airsme.airsme2.Globals;
import com.airsme.airsme2.LoginActivity;
import com.airsme.airsme2.PDashboard;
import com.airsme.airsme2.PSignup;
import com.airsme.airsme2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;

/**
 * Created by M91p-04 on 1/12/2018.
 */

public class JNavigate {
    public static User USER;

    static UserType userType =new UserType();
    static class UserType{
        Boolean notproxy=null;
    }

    public static void updateUserSigned(final Context context){
        //Globals.showprogress(context);
        FirebaseUser cuser= FirebaseAuth.getInstance().getCurrentUser();
        User user=new User();
        if(USER != null){//if authenticated

            USER.setRegistered(true);
            DBUtil.createModel(USER);
        }
        else{//else login
            login(context);
        }
        //Globals.hideprogress(context);
    }

    public static void overalldecider(final Context context){
        Globals.showprogress(context);
        FirebaseUser cuser= FirebaseAuth.getInstance().getCurrentUser();
        User user=new User();
        if(cuser != null){//if authenticated
            user.setPKeyValue(cuser.getUid());
            ListenerMgr lmp=new ListenerMgr() {
                @Override
                public void methodHolder(DataSnapshot dataSnapshot) {
                    User u = dataSnapshot.getValue(User.class);
                    System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy______"+dataSnapshot.getRef().toString());
                    Globals.CURRENT_USER=u;
                    USER=u;
                    if(u==null)return;
                    if(u.isRegistered()){

                        if(User.PROXY.equalsIgnoreCase(u.getRoles())){
                            Globals.nextView(context, PDashboard.class);
                        }
                        else{
                            Globals.nextView(context, BDashboard.class);
                        }
                    }
                    else{
                        if(User.PROXY.equalsIgnoreCase(u.getRoles())){
                            Globals.nextView(context, PSignup.class);
                        }
                        else{
                            Globals.nextView(context, BSignup.class);
                        }
                    }
                }
            };
            DBUtil.retriaveModelByKey(user, lmp.onchangeListener());

        }
        else{//else login
            login(context);
        }
        Globals.hideprogress(context);
    }

    static void login(Context context){
        Globals.showprogress(context);

        Globals.nextView(context, LoginActivity.class);

        Globals.hideprogress(context);
    }

    public static void autCheck(Context context){
        Globals.showprogress(context);

        if(FirebaseAuth.getInstance().getCurrentUser()==null)
            login(context);

        Globals.hideprogress(context);
    }

    public static void overalldecider3(Context context){
        Globals.showprogress(context);

        Globals.hideprogress(context);
    }
}
