package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class BPushNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpush_notification);


        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.signup_main));
        getSupportActionBar().setTitle("Reminder");
    }
}
