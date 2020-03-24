package com.gamecodeschool.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class homePage2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText etSource,etDestination,etSick,etSymptoms;
    ImageView ivCal;
    Button btnNext2;
    Switch swExposure;

    DatabaseReference databaseDrivers2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        etSource=findViewById(R.id.etSource);
        etDestination=findViewById(R.id.etDestination);
        etSick=findViewById(R.id.etSick);
        btnNext2=findViewById(R.id.btnNext2);
        etSymptoms=findViewById(R.id.etSymptoms);
        ivCal=findViewById(R.id.ivCal);

        databaseDrivers2= FirebaseDatabase.getInstance().getReference("User_Info2");

        ivCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker =new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

     /*   btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Source,Destination,Sick,Symptons;
                Source=etSource.getText().toString().trim();
                Destination=etDestination.getText().toString().trim();
                Sick=etSick.getText().toString().trim();
                Symptons=etSymptoms.getText().toString().trim();

                if (Source.isEmpty()|| Destination.isEmpty()|| Sick.isEmpty() || Symptons.isEmpty()){
                    Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_LONG).show();
                    btnNext2.setEnabled(false);
                }
                else {
                    btnNext2.setEnabled(true);
                    addCredentials2();
                }
            }
        });*/
    }
  /*  public void addCredentials2()
    {

        String dvSrc,dvDest,dvSick,dvSymptons = new String();
        String dvid= databaseDrivers2.push().getKey();
        dvSrc=etSource.getText().toString().trim();
        dvDest=etDestination.getText().toString().trim();
        dvSick=etSick.getText().toString().trim();
        dvSymptons=etSymptoms.getText().toString().trim();
        user_info2 dCredentials= new user_info2(dvSrc,dvDest,dvSick,dvSymptons);
        databaseDrivers2.child(dvid).setValue(dCredentials);
    }*/


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        etSick.setText(currentDateString);
    }

}
