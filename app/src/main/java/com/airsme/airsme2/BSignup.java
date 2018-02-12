package com.airsme.airsme2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.airsme.datamodels.Business;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSignup extends AppCompatActivity {
    static Business business=new Business();
    Spinner beelevel;
    Spinner btype;
    Spinner bsize;



    private static final int PICK_IMAGE_REQUEST = 1;
    Uri filePath;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsignup);
        addspinners();
        Button submitbtn = (Button) findViewById(R.id.bsignupbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });


        imageView=findViewById(R.id.bsignup_imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();

            }
        });



        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.bsignup_main));
        getSupportActionBar().hide();

    }
    private void addspinners(){

        beelevel = (Spinner) findViewById(R.id.bsignup_beelevel);
        btype = (Spinner) findViewById(R.id.bsignup_type);
        bsize = (Spinner) findViewById(R.id.bsignup_size);

        // Spinner Drop down elements
        List<String> beelevels = Arrays.asList("bee1", "bee2", "bee3", "bee4");
        List<String> btypes = Arrays.asList("techno", "services", "mining", "farming");
        List<String> bsizes = Arrays.asList("small", "medium", "large", "xtra large");


        // Creating adapter for spinner
        ArrayAdapter<String> beelevela = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, beelevels);
        ArrayAdapter<String> btypea = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, btypes);
        ArrayAdapter<String> bsizea = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bsizes);

        // Drop down layout style - list view with radio button
        beelevela.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        btypea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bsizea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        beelevel.setAdapter(beelevela);
        btype.setAdapter(btypea);
        bsize.setAdapter(bsizea);

    }
    private void submit(){
        EditText name=findViewById(R.id.bsignup_name);
        if(name.getText().toString().isEmpty()){
            name.setError("Invalid input");
            return;
        }
        else{
            business.setName(name.getText().toString());
        }

        EditText regno=findViewById(R.id.bsignup_regno);
        if(regno.getText().toString().isEmpty()){
            regno.setError("Invalid input");
            return;
        }
        else{
            business.setRegno(regno.getText().toString());
        }

        EditText vatno=findViewById(R.id.bsignup_vatno);
        if(vatno.getText().toString().isEmpty()){
            vatno.setError("Invalid input");
            return;
        }
        else{
            business.setVatno(vatno.getText().toString());
        }

        EditText website=findViewById(R.id.bsignup_website);
        if(website.getText().toString().isEmpty()){
            website.setError("Invalid input");
            return;
        }
        else{
            business.setWebsite(website.getText().toString());
        }

        EditText tax=findViewById(R.id.bsignup_taxclearance);
        if(tax.getText().toString().isEmpty()){
            tax.setError("Invalid input");
            return;
        }
        else{
            business.setTaxclearance(tax.getText().toString());
        }

        business.setBeelevel(beelevel.getSelectedItem().toString());
        business.setSize(bsize.getSelectedItem().toString());
        business.setSize(bsize.getSelectedItem().toString());


        new GlobalStorage(BSignup.this).uploadImage(filePath, business.getLogo());

        Globals.nextView(this, BIndividual.class);
    }



    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
