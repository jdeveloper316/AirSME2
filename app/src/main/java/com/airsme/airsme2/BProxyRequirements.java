package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class BProxyRequirements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bproxy_requirements);

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bproxyreq_main));
        getSupportActionBar().hide();
    }
}
