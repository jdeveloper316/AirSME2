package com.airsme.airsme2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.text.DynamicLayout;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.JNavigate;
import com.airsme.datamodels.ListenerMgr;
import com.airsme.datamodels.Tender;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import java.text.DateFormat;

/**
 * Created by M91p-04 on 1/19/2018.
 */

public class GlobalTender {

    DynamicLayout dynamicLayout;
    Context context;
    LinearLayout layout;

    private boolean pending=false;

    ListenerMgr listenerMgr=new ListenerMgr() {
        @Override
        public void methodHolder(DataSnapshot dataSnapshot) {
            for(DataSnapshot ds:dataSnapshot.getChildren()){
                ListenerMgr lm=new ListenerMgr() {
                    @Override
                    public void methodHolder(DataSnapshot dataSnapshot) {
                        Tender tender=dataSnapshot.getValue(Tender.class);
                        if(tender!=null && tender.getTenderno()!=null){
                            if(!pending)
                                handle(tender);
                            else if(tender.getStatus().equalsIgnoreCase("Pending"))
                                handle(tender);
                        }
                    }
                };
                dataSnapshot.child(ds.getKey()).getRef().addValueEventListener(lm.onchangeListener());
            }
        }
    };

    ListenerMgr alllistenerMgr=new ListenerMgr() {
        @Override
        public void methodHolder(DataSnapshot dataSnapshot) {
            for(DataSnapshot ds:dataSnapshot.getChildren()){
                dataSnapshot.child(ds.getKey()).getRef().addValueEventListener(listenerMgr.onchangeListener());
            }
        }
    };

    public GlobalTender(Context context, LinearLayout layout) {
        this.context = context;
        this.layout = layout;
        layout.removeAllViewsInLayout();
    }

    public void listenToAllTenders(){
        pending=false;
        DBUtil.listenToNode(alllistenerMgr, "tender");
    }

    public void listenToAppliedTenders(){
        pending=false;
        DBUtil.listenToNode(alllistenerMgr, "tender");
    }

    public void listenToPendingTenders(){
        pending=true;
        DBUtil.listenToNode(listenerMgr, "tender/"+ JNavigate.USER.getUid());
    }
    public void handle(final Tender... tenders) {
        for(Tender t:tenders){
            final Tender tender=t;
            Button infobtn = new Button(context);
            infobtn.setText("Infor");
            infobtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BTenderInfor.tender = tender;
                    Globals.nextView(context, BTenderInfor.class);
                }
            });

            Button applybtn = new Button(context);
            if(FirebaseAuth.getInstance().getCurrentUser().getUid().equalsIgnoreCase(tender.getPKeyValue())) {
                applybtn.setText("Edit");
                applybtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BTenderSpecifics.tender = tender;
                        Globals.nextView(context, BTenderSpecifics.class);
                    }
                });
            }
            else{
                applybtn.setText("Apply");
                applybtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Globals.msgbox(context, "Application sent!");
                    }
                });
            }
            LinearLayout lytrightbtns = new LinearLayout(context);
            lytrightbtns.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams matchmatch = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams matchwrap = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            LinearLayout.LayoutParams wrapwrap = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            LinearLayout.LayoutParams wrapmatch = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1);
            LinearLayout.LayoutParams imgdim = new LinearLayout.LayoutParams(333,
                    300);


            //Button b = new Button(this);

            RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            rl.addRule(RelativeLayout.ALIGN_RIGHT);
            infobtn.setLayoutParams(rl);
            RelativeLayout rlytinfo=new RelativeLayout(context);
            applybtn.setLayoutParams(rl);
            lytrightbtns.setLayoutParams(rl);
            RelativeLayout rlytapply=new RelativeLayout(context);

            rlytinfo.addView(infobtn, wrapwrap);
            rlytapply.addView(applybtn, wrapwrap);

            lytrightbtns.addView(rlytinfo, rl);
            lytrightbtns.addView(rlytapply, rl);
            //lytrightbtns.setPadding(0,0,30,0);

            //lytrightbtns.setBaselineAlignedChildIndex(0);

            //////////////////////////////////////////////////////////

            LinearLayout lyttendetails = new LinearLayout(context);
            lyttendetails.setOrientation(LinearLayout.VERTICAL);
            lyttendetails.setWeightSum(1);

            TextView tendername = new TextView(context);
            TextView daysleft = new TextView(context);
            TextView status = new TextView(context);

            tendername.setText(tender.getName());
            tendername.setTextSize(24);
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            daysleft.setText(df.format(tender.getDate()).toString());
            status.setText(tender.getTenderno());


            lyttendetails.addView(tendername, matchwrap);
            lyttendetails.addView(daysleft, matchwrap);
            lyttendetails.addView(status, matchwrap);

            /////////////////////////////////////////////////////////////

            LinearLayout lytimg = new LinearLayout(context);
            lytimg.setOrientation(LinearLayout.HORIZONTAL);

            ImageView prof = new ImageView(context);
            prof.setPadding(0,0,0,0);
            //prof.setCropToPadding(true);
            prof.setImageResource(R.drawable.com_facebook_profile_picture_blank_portrait);
            new GlobalStorage(context).loadImage(tender.getImageURL(), prof);

            lytimg.addView(prof, imgdim);
            lytimg.addView(lyttendetails, wrapwrap);
            lytimg.addView(lytrightbtns, rl);

            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setBackgroundColor(Color.rgb(244, 245, 222));
            layout.setPadding(0,25,0,20);
            layout.addView(lytimg, matchwrap);

            LinearLayout lastlayout = new LinearLayout(context);

            lastlayout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(lastlayout, matchwrap);
            layout = lastlayout;
        }
    }
}
