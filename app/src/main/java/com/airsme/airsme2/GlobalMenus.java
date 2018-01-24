package com.airsme.airsme2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by M91p-04 on 1/19/2018.
 */

public class GlobalMenus extends Activity{






    //menu handling


    public static boolean menuhandling(Context context, MenuItem item, LinearLayout... layout) {

        switch(item.getItemId()) {
            case R.id.add:
                return(true);
            case R.id.alltenders:
                new GlobalTender(context, layout[0]).listenToAllTenders();
                return true;
            case R.id.appliedtenders:
                new GlobalTender(context, layout[0]).listenToAppliedTenders();
                return true;
            case R.id.pendingjobs:
                new GlobalTender(context, layout[0]).listenToPendingTenders();
                return true;
            case R.id.addtender:
                Globals.nextView(context, BTenderSpecifics.class);
                return(true);
            case R.id.about:
                return(true);
            case R.id.logout:
                logout(context);
                return(true);

        }
        return false;
    }

    private static void logout(Context c) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(c, LoginActivity.class);
        c.startActivity(intent);
    }
}
