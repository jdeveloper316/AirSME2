package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airsme.datamodels.Proxy;
import com.airsme.datamodels.Tender;

public class BProxyInfor extends AppCompatActivity {

    public static Proxy proxy;
    public static Tender subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bproxy_infor);

        TextView t=findViewById(R.id.bproxy_infor_text);
        t.setEnabled(false);
        t.setText(proxy.toString());
        Button b=findViewById(R.id.bproxy_infor_paymentbtn);
        b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });
    }
}
