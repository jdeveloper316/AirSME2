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

public class PTenderInfor extends AppCompatActivity {
    public static Tender tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptender_infor);

        tender=BTenderInfor.tender;
        ((TextView) findViewById(R.id.btenderinfor_details)).setText(tender.toPrint());
        ((TextView) findViewById(R.id.btenderinfor_specialnotes)).setText(tender.getNotes());


        ((Button) findViewById(R.id.btenderinfor_mapbtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Globals.nextView(PTenderInfor.this, PDashboard.class);
            }
        });
        ((Button) findViewById(R.id.bmessage_client_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message.subject =tender;
                Globals.nextView(PTenderInfor.this, Message.class);
            }
        });
        ((Button) findViewById(R.id.btender_checklist_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PJobBoard.tender=tender;
                Globals.nextView(PTenderInfor.this, PJobBoard.class);
            }
        });
        ((Button) findViewById(R.id.btenderinfor_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.nextView(PTenderInfor.this, PDashboard.class);
            }
        });


        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.ptenderinfo_main));
        getSupportActionBar().setTitle(tender.getName());
        tender=null;
        //new GlobalTender(this, (LinearLayout) findViewById(R.id.bdashboard_layout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ptender_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(GlobalMenus.menuhandling(this, item, true)) return true;
        return(super.onOptionsItemSelected(item));
    }
}
