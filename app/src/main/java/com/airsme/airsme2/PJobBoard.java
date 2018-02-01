package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airsme.datamodels.Tender;

public class PJobBoard extends AppCompatActivity {

    public static Tender tender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pjob_board);
    }
}
