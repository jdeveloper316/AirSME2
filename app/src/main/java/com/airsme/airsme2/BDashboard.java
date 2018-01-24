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

import java.io.IOException;

public class BDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdashboard);
        Globals.setDummycontext(this);
        new GlobalTender(this, (LinearLayout)findViewById(R.id.bdashboard_layout)).listenToAllTenders();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.btender_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(GlobalMenus.menuhandling(this, item, (LinearLayout)findViewById(R.id.bdashboard_layout))) return true;
        return(super.onOptionsItemSelected(item));
    }

}
