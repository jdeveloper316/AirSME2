package com.airsme.airsme2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airsme.datamodels.Business;
import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.ListenerMgr;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.io.IOException;

public class BDashboard extends AppCompatActivity {
    static Business business;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdashboard);
        Globals.setDummycontext(this);
        business=new Business();
        business.setPKeyValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
        DBUtil.retriaveModelByKey(business, new ListenerMgr(){

            @Override
            public void methodHolder(DataSnapshot dataSnapshot) {
                business=dataSnapshot.getValue(Business.class);
            }
        }.onchangeListener());

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bdash_main));
        //getSupportActionBar().hide();

        getSupportActionBar().setTitle("Dashboard");
        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bdash_main));
        new GlobalTender(this, (LinearLayout)findViewById(R.id.bdashboard_layout), false).listenMyBTenders();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.btender_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(GlobalMenus.menuhandling(this, item, false, (LinearLayout)findViewById(R.id.bdashboard_layout))) return true;
        return(super.onOptionsItemSelected(item));
    }

}
