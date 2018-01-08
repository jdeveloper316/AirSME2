package com.airsme.airsme2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class BDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdashboard);
        Globals.setDummycontext(this);


        FirebaseUser fuser = FirebaseAuth.getInstance().getCurrentUser();
        User user = new User();
        user.setUid(fuser.getUid());

        // [START_EXCLUDE]
        User u=(User)DBUtil.retriaveModelByKey(user);
        if(u==null){

        }
        if(u!=null&&u.getRoles().equals(User.Role.PROXY)) {
            Intent intent = new Intent(BDashboard.this, PDashboard.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(Globals.menuhandling(item)) return true;
        return(super.onOptionsItemSelected(item));
    }

}
