package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class BPending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpending);

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bpending_main));
        getSupportActionBar().hide();
    }
}
