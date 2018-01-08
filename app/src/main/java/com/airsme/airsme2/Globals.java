package com.airsme.airsme2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by M91p-04 on 1/4/2018.
 */

public class Globals {

    private static Context dummycontext;

    public static void setDummycontext(Context dummycontext) {
        Globals.dummycontext = dummycontext;
    }

    public static void msgbox(Context contex, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(contex);
        builder.setTitle("Message");
        builder.setMessage(msg);

        // add a button
        builder.setPositiveButton("OK", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public static void showprogress(Context context){
        BaseActivity.getObj().setContext(context);
        BaseActivity.getObj().showProgressDialog();
    }
    public static void hideprogress(Context context){
        BaseActivity.getObj().setContext(context);
        BaseActivity.getObj().hideProgressDialog();
    }
    static class BaseActivity extends AppCompatActivity {
        final static BaseActivity obj=new BaseActivity();
            @VisibleForTesting
            public ProgressDialog mProgressDialog;
            Context context;
            public void showProgressDialog() {
                if (mProgressDialog == null) {
                    mProgressDialog = new ProgressDialog(context);
                    mProgressDialog.setMessage("Loading…");
                    mProgressDialog.setIndeterminate(true);
                }

                mProgressDialog.show();
            }

            public void hideProgressDialog() {
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
            }

            @Override
            public void onStop() {
                super.onStop();
                hideProgressDialog();
            }

        public static BaseActivity getObj() {
            return obj;
        }

        public void setContext(Context context) {
            this.context = context;
        }
    }

    //menu handling


    public static boolean menuhandling(MenuItem item) {

        switch(item.getItemId()) {
        case R.id.add:
            return(true);
        case R.id.reset:
            return(true);
        case R.id.about:
            return(true);
        case R.id.exit:
            logout(dummycontext);
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

