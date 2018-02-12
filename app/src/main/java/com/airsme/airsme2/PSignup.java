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
import android.widget.Toast;

import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.JNavigate;
import com.airsme.datamodels.Proxy;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PSignup extends AppCompatActivity {
    Spinner title;
    Spinner bank;
    static final Proxy proxy=new Proxy();






    private static final int PICK_IMAGE_REQUEST = 1;
    Uri filePath;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psignup);
        addspinners();

        imageView=findViewById(R.id.psignup_imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();

            }
        });
        Button submitbtn = (Button) findViewById(R.id.psignupbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
        //new RoundViews(this).round(submitbtn);
        //getSupportActionBar().hide();

        Button chooselocation = (Button) findViewById(R.id.psignupmap);
        chooselocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Globals.showMapLocation(PSignup.this, proxy);
                //tender.jsetMaplocation();
            }
        });

        new RoundViews(this).themeControls((LinearLayout) findViewById(R.id.psignup_main));
        getSupportActionBar().hide();
    }
    private void addspinners(){

        title = (Spinner) findViewById(R.id.psignup_title);
        bank = (Spinner) findViewById(R.id.psignup_bankname);

        // Spinner Drop down elements
        List<String> titles = Arrays.asList("Mr.", "Mrs.", "Dr.", "Miss");
        List<String> banks = Arrays.asList("FNB", "ABSA", "Standard", "IMB");


        // Creating adapter for spinner
        ArrayAdapter<String> titlesa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, titles);
        ArrayAdapter<String> banksa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, banks);

        // Drop down layout style - list view with radio button
        titlesa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        banksa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        title.setAdapter(titlesa);
        bank.setAdapter(banksa);

    }
    private void submit(){
        EditText name=findViewById(R.id.psignup_name);
        if(name.getText().toString().isEmpty()){
            name.setError("Invalid input");
            return;
        }
        else{
            proxy.setName(name.getText().toString());
        }

        EditText surname=findViewById(R.id.psignup_surname);
        if(surname.getText().toString().isEmpty()){
            surname.setError("Invalid input");
            return;
        }
        else{
            proxy.setSurname(surname.getText().toString());
        }

        EditText contact=findViewById(R.id.psignup_contact);
        if(contact.getText().toString().isEmpty()){
            contact.setError("Invalid input");
            return;
        }
        else{
            proxy.setContact(contact.getText().toString());
        }

        EditText email=findViewById(R.id.psignup_email);
        if(email.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            proxy.setEmail(email.getText().toString());
        }

        EditText address=findViewById(R.id.psignup_address);
        if(email.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            proxy.setAddress(email.getText().toString());
        }

        EditText dob=findViewById(R.id.psignup_dob);
        if(email.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            proxy.setDob(new Date());
        }

        EditText accno=findViewById(R.id.psignup_accno);
        if(accno.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            proxy.setAccountnumber(email.getText().toString());
        }

        EditText branchcode=findViewById(R.id.psignup_branchcode);
        if(branchcode.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            proxy.setBranchcode(email.getText().toString());
        }

        proxy.setTitle(bank.getSelectedItem().toString());
        proxy.setBankName(bank.getSelectedItem().toString());

        proxy.setPKeyValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
        //DBUtil.createModel(proxy);


        if(proxy.jgetMaplocation()==null){
            Toast.makeText(this, "Please choose map location", Toast.LENGTH_SHORT);
            return;
        }

        new GlobalStorage(PSignup.this).uploadImage(filePath, proxy.getPic());

        //JNavigate.updateUserSigned(this);

        Globals.nextView(this, PQualifications.class);
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
