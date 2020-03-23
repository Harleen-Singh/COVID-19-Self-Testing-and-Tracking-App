package com.gamecodeschool.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class homePage1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {
    EditText etName,etAge,etAddress,etSubsidaryPhones;
    ImageView ivCld;
    Button btnNext1;
    Spinner spGender;

  //  public FirebaseAuth mAuth;
 //   public DatabaseReference databaseDrivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);
        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        ivCld=findViewById(R.id.ivCld);
        btnNext1=findViewById(R.id.btnNext1);
        etAddress=findViewById(R.id.etAddress);
        etSubsidaryPhones=findViewById(R.id.etSubsidaryPhones);

//        databaseDrivers= FirebaseDatabase.getInstance().getReference("User_Info");
    //    mAuth=FirebaseAuth.getInstance();

        ivCld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker =new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        final Spinner spinner=findViewById(R.id.spGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sex, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name,Dob,Gen,Address,SubPhn;
                Name=etName.getText().toString().trim();
                Dob=etAge.getText().toString().trim();
                Gen=spGender.getSelectedItem().toString().trim();
                Address=etAddress.getText().toString().trim();
                SubPhn=etSubsidaryPhones.getText().toString().trim();

                if (Name.isEmpty()||Dob.isEmpty()||(SubPhn.length()<10)||Gen.isEmpty()||Address.isEmpty())
                    Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_LONG).show();
                else{
                    btnNext1.setVisibility(View.VISIBLE);
                   // addCredentials();
                }
            }

        });
    }
 /*   public void addCredentials()
    {

        String dvAdd,dvPhn,dvName,dvGen,dvDob = new String();
        String dvid= databaseDrivers.push().getKey();
        dvAdd=etAddress.getText().toString().trim();
        dvPhn=etSubsidaryPhones.getText().toString().trim();
        dvName=etName.getText().toString().trim();
       dvGen=spGender.getSelectedItem().toString().trim();
        dvDob=etAge.getText().toString().trim();
        user_info dCredentials= new user_info(dvAdd,dvPhn,dvName,dvGen,dvDob);
        databaseDrivers.child(dvid).setValue(dCredentials);
    }*/

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        etAge.setText(currentDateString);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text1=parent.getItemAtPosition(position).toString();
       // Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
