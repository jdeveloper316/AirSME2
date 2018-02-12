package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.airsme.datamodels.Tender;

public class PJobBoard extends AppCompatActivity {

    public static Tender tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pjob_board);

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.pjob_main));
        getSupportActionBar().setTitle(tender.getName());
    }
}
