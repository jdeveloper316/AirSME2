package com.airsme.airsme2;

        import android.content.Context;
        import android.graphics.Color;
        import android.graphics.PorterDuff;
        import android.graphics.drawable.GradientDrawable;
        import android.support.v4.content.res.ResourcesCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Layout;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class RoundViews {
    Context c;

    public RoundViews(Context c) {
        this.c = c;
    }

    public void roundcolored(View v, int color) {

        // Initialize a new GradientDrawable
        GradientDrawable gd = new GradientDrawable();

        // Specify the shape of drawable
        gd.setShape(GradientDrawable.RECTANGLE);

        // Set the fill color of drawable
        gd.setColor(Color.TRANSPARENT); // make the background transparent
        //gd.setBackgroundColor(Color.TRANSPARENT);

        // Create a 2 pixels width red colored border for drawable
        gd.setStroke(2, Color.WHITE); // border width and color

        // Make the border rounded
        //gd.setCornerRadius(35.0f); // border corner radius

        // Finally, apply the GradientDrawable as TextView background
        v.setBackgroundDrawable(gd);

    }

    public void justtransparent(View v) {

        // Initialize a new GradientDrawable
        GradientDrawable gd = new GradientDrawable();

        // Specify the shape of drawable
        gd.setShape(GradientDrawable.RECTANGLE);

        // Set the fill color of drawable
        gd.setColor(Color.TRANSPARENT); // make the background transparent
        //gd.setBackgroundColor(Color.TRANSPARENT);

        // Create a 2 pixels width red colored border for drawable
        gd.setStroke(0, Color.TRANSPARENT); // border width and color

        // Make the border rounded
        //gd.setCornerRadius(35.0f); // border corner radius

        // Finally, apply the GradientDrawable as TextView background
        v.setBackgroundDrawable(gd);

    }

    public void transparentYellow(Button v) {

        v.setTextColor(ResourcesCompat.getColor(c.getResources(), R.color.airsmeyellow, null));
        justtransparent(v);

    }

    public void justwhitetext(TextView v) {

        v.setTextColor(Color.WHITE);
        //justtransparent(v);

    }

    public void round(Button v) {

        v.setTextColor(ResourcesCompat.getColor(c.getResources(), R.color.airsmeyellow, null));
        roundcolored(v, Color.GRAY);

    }

    public void round(Button v, boolean yellow) {

        v.setTextColor(Color.BLUE);
        roundcolored(v, ResourcesCompat.getColor(c.getResources(), R.color.airsmeyellow, null));

    }

    public void round(View v) {

        //v.setPadding(36, 36, 36, 36);
        //v.setTextColor(Color.BLUE);
        if(v instanceof EditText){
            EditText e=(EditText)v;
            e.setTextColor(Color.WHITE);
            e.setHintTextColor(Color.WHITE);
            e.getBackground().mutate().setColorFilter(this.c.getResources().getColor(android.R.color.holo_orange_light), PorterDuff.Mode.SRC_ATOP);
            return;
        }
        roundcolored(v, Color.GRAY);

    }

    public void round(EditText v) {

        //v.setPadding(36, 36, 36, 36);
        //v.setTextColor(Color.WHITE);
        //v.setHintTextColor(Color.WHITE);
        v.setBackgroundColor(Color.TRANSPARENT);
        //roundcolored(v, Color.GRAY);

    }

    public void round(Spinner v) {


        v.setPadding(36, 36, 36, 36);
        v.setBackgroundColor(Color.WHITE);
        //v.setHintTextColor(Color.WHITE);
        //roundcolored(v, Color.GRAY);

    }

    public void themeControls(ViewGroup linearLayout){
        for( int i = 0; linearLayout!=null&&i < linearLayout.getChildCount(); i++ ){
            if(linearLayout.getChildAt( i ) instanceof ViewGroup)
                themeControls((ViewGroup)linearLayout.getChildAt( i ));
            if( linearLayout.getChildAt( i ) instanceof EditText
                    ||linearLayout.getChildAt( i ) instanceof Button
                    ||linearLayout.getChildAt( i ) instanceof Spinner ){
                round( linearLayout.getChildAt( i ) );
            }
    }}

}
