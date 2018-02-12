package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airsme.datamodels.Tender;

public class BTenderInfor extends AppCompatActivity {
    public static Tender tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btender_infor);

        final Tender ten=tender;
        ((TextView) findViewById(R.id.btenderinfor_details)).setText(tender.toPrint());
        ((TextView) findViewById(R.id.btenderinfor_specialnotes)).setText(tender.getNotes());


        ((Button) findViewById(R.id.btenderinfor_mapbtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.showMapLocation(BTenderInfor.this, tender);
            }
        });

        ((Button) findViewById(R.id.bresponses_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BResponses.tender=ten;
                Globals.nextView(BTenderInfor.this, BResponses.class);
            }
        });

        Button delbtn = (Button) findViewById(R.id.bdeletetender_btn);
        delbtn.setVisibility(View.INVISIBLE);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobalTender.deleteTender(BTenderInfor.this, tender);
            }
        });

        Button donbtn = (Button) findViewById(R.id.bmarkasdone_btn);
        donbtn.setVisibility(View.INVISIBLE);
        donbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalTender.markAsDone(BTenderInfor.this, tender);
            }
        });

        ((Button) findViewById(R.id.btenderinfor_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.nextView(BTenderInfor.this, BDashboard.class);
            }
        });

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bteninfo_main));
        getSupportActionBar().setTitle(tender.getName());

        tender=null;
        //new GlobalTender(this, (LinearLayout) findViewById(R.id.bdashboard_layout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.btender_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(GlobalMenus.menuhandling(this, item, false)) return true;
        return(super.onOptionsItemSelected(item));
    }
}
