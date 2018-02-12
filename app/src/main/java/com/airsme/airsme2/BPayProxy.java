package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class BPayProxy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpay_proxy);

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bpay_main));
        getSupportActionBar().setTitle("Payment");
    }
}
