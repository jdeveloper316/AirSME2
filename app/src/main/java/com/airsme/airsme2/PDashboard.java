package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.ListenerMgr;
import com.airsme.datamodels.Proxy;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

public class PDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdashboard);
        Globals.setDummycontext(this);



        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.pdash_main));
        getSupportActionBar().setTitle("Dashboard");
        new GlobalTender(this, (LinearLayout)findViewById(R.id.pdashboard_layout), true).listenToAllTenders();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ptender_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(GlobalMenus.menuhandling(this, item, true, (LinearLayout)findViewById(R.id.pdashboard_layout))) return true;
        return(super.onOptionsItemSelected(item));
    }

}