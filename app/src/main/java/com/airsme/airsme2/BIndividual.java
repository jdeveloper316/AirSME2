package com.airsme.airsme2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.airsme.datamodels.Business;
import com.airsme.datamodels.DBUtil;
import com.airsme.datamodels.Individual;
import com.airsme.datamodels.JNavigate;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

public class BIndividual extends AppCompatActivity {
    static Business business=BSignup.business;
    static Individual individual=new Individual();
    Spinner position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindividual);
        addspinners();
        Button submitbtn = (Button) findViewById(R.id.bindividualbtn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

    }
    private void addspinners(){

        position = (Spinner) findViewById(R.id.position);

        // Spinner Drop down elements
        List<String> beelevels = Arrays.asList("bee1", "bee2", "bee3", "bee4");


        // Creating adapter for spinner
        ArrayAdapter<String> beelevela = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, beelevels);

        // Drop down layout style - list view with radio button
        beelevela.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        position.setAdapter(beelevela);

    }
    private void submit(){
        EditText name=findViewById(R.id.bindividual_name);
        if(name.getText().toString().isEmpty()){
            name.setError("Invalid input");
            return;
        }
        else{
            individual.setName(name.getText().toString());
        }

        EditText surname=findViewById(R.id.bindividual_surname);
        if(surname.getText().toString().isEmpty()){
            surname.setError("Invalid input");
            return;
        }
        else{
            individual.setSurname(surname.getText().toString());
        }

        EditText contact=findViewById(R.id.bindividual_contactno);
        if(contact.getText().toString().isEmpty()){
            contact.setError("Invalid input");
            return;
        }
        else{
            individual.setContent(contact.getText().toString());
        }

        EditText email=findViewById(R.id.bindividual_email);
        if(email.getText().toString().isEmpty()){
            email.setError("Invalid input");
            return;
        }
        else{
            individual.setEmail(email.getText().toString());
        }

        individual.setPosition(position.getSelectedItem().toString());

        //business.getIndividuals().add(individual);

        individual.setBusiness(business);

        business.setPKeyValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
        individual.setPKeyValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
        DBUtil.createModel(business);
        DBUtil.createModel(individual);

        JNavigate.updateUserSigned(this);

        Globals.nextView(this, BDashboard.class);
    }
}
