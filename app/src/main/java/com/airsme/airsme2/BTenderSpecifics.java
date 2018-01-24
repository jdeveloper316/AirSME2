package com.airsme.airsme2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.JNavigate;
import com.airsme.datamodels.Tender;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BTenderSpecifics extends AppCompatActivity {
    static Tender tender;
    Spinner courieroptions;
    // Spinner Drop down elements
    List<String> beelevels = Arrays.asList("Postnet", "DHL", "Swift", "Post office");




    private static final int PICK_IMAGE_REQUEST = 1;
    Uri filePath;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btender_specifics);
        addspinners();
        if(tender!=null) {
            ((TextView) findViewById(R.id.unit)).setText(tender.getUnit());
            ((TextView) findViewById(R.id.floor)).setText(tender.getFloor());
            ((TextView) findViewById(R.id.street)).setText(tender.getStreet());
            ((TextView) findViewById(R.id.suburb)).setText(tender.getSurbub());
            ((TextView) findViewById(R.id.town)).setText(tender.getTown());
            ((TextView) findViewById(R.id.tenderno)).setText(tender.getTenderno());
            (findViewById(R.id.tenderno)).setEnabled(false);
            ((TextView) findViewById(R.id.tendername)).setText(tender.getName());
            ((TextView) findViewById(R.id.contactperson)).setText(tender.getContactperson());
            ((TextView) findViewById(R.id.specialnotes)).setText(tender.getNotes());
            courieroptions.setSelection(beelevels.indexOf(tender.getCourierOptions()));

            imageView=findViewById(R.id.btender_imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chooseImage();

                }
            });

            new GlobalStorage(this).loadImage(tender.getImageURL(), imageView);


        }
        Button submitbtn = (Button) findViewById(R.id.tender_specsbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

    }
    private void addspinners(){

        courieroptions = (Spinner) findViewById(R.id.courieroption);

        // Creating adapter for spinner
        ArrayAdapter<String> beelevela = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, beelevels);

        // Drop down layout style - list view with radio button
        beelevela.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        courieroptions.setAdapter(beelevela);

    }
    private void submit(){
        EditText name=findViewById(R.id.unit);
        if(name.getText().toString().isEmpty()){
            name.setError("Invalid input");
            return;
        }
        else{
            tender.setUnit(name.getText().toString());
        }

        EditText surname=findViewById(R.id.floor);
        if(surname.getText().toString().isEmpty()){
            surname.setError("Invalid input");
            return;
        }
        else{
            tender.setFloor(surname.getText().toString());
        }

        EditText street=findViewById(R.id.street);
        if(street.getText().toString().isEmpty()){
            street.setError("Invalid input");
            return;
        }
        else{
            tender.setStreet(street.getText().toString());
        }

        EditText email=findViewById(R.id.suburb);
        if(email.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            tender.setSurbub(email.getText().toString());
        }

        EditText town=findViewById(R.id.town);
        if(town.getText().toString().isEmpty()){
            town.setError("Invalid input");
            return;
        }
        else{
            tender.setTown(town.getText().toString());
        }

        EditText contact=findViewById(R.id.contactperson);
        if(contact.getText().toString().isEmpty()){
            contact.setError("Invalid input");
            return;
        }
        else{
            tender.setContactperson(contact.getText().toString());
        }

        EditText tendername=findViewById(R.id.tendername);
        if(contact.getText().toString().isEmpty()){
            tendername.setError("Invalid input");
            return;
        }
        else{
            tender.setName(tendername.getText().toString());
        }

        EditText tenderno=findViewById(R.id.tenderno);
        if(contact.getText().toString().isEmpty()){
            tenderno.setError("Invalid input");
            return;
        }
        else{
            tender.setTenderno(tenderno.getText().toString());
        }

        EditText notes=findViewById(R.id.specialnotes);
        if(notes.getText().toString().isEmpty()){
            notes.setError("Invalid input");
            return;
        }
        else{
            tender.setNotes(notes.getText().toString());
        }

        tender.setCourierOptions(courieroptions.getSelectedItem().toString());


        tender.setPKeyValue(FirebaseAuth.getInstance().getCurrentUser().getUid());

        DBUtil.createModel(tender);
        new GlobalStorage(BTenderSpecifics.this).uploadImage(filePath, tender.getImageURL());


        Globals.nextView(this, BDashboard.class);
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
