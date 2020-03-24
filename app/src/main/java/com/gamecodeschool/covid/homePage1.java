package com.gamecodeschool.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class homePage1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {
    EditText etName,etAge,etAddress,etSubsidaryPhones,etSource,etDestination,etSick,etSymptoms;
    ImageView ivCld,bAddPhn,ivCal,bAddSym,ivAddSymptoms;
    Button btnNext2;
    Spinner spGender;
    ListView lvSubphones,lvSymp;

    ArrayList<String> arrayList1,arrayList;
    ArrayAdapter<String> adapter1,adap;

     DatabaseReference databaseDrivers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page1);
        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        ivCld=findViewById(R.id.ivCld);
       btnNext2=findViewById(R.id.btnNext2);
       etAddress=findViewById(R.id.etAddress);
       etSubsidaryPhones=findViewById(R.id.etSubsidaryPhones);
        lvSubphones=findViewById(R.id.lvSubphones);
        bAddPhn=findViewById(R.id.bAddPhn);
        etSource=findViewById(R.id.etSource);
        etDestination=findViewById(R.id.etDestination);
        etSick=findViewById(R.id.etSick);
        ivAddSymptoms=findViewById(R.id.ivAddSymptoms);
        etSymptoms=findViewById(R.id.etSymptoms);
        ivCal=findViewById(R.id.ivCal);
        bAddSym=findViewById(R.id.bAddSym);
        lvSymp=findViewById(R.id.lvSymp);

        arrayList=new ArrayList<String>();
        adap=new ArrayAdapter<String>(homePage1.this,android.R.layout.simple_list_item_1,arrayList);
        lvSymp.setAdapter(adap);
        onBtnClick();


       databaseDrivers= FirebaseDatabase.getInstance().getReference("User_Info");

        arrayList1=new ArrayList<String>();
        adapter1=new ArrayAdapter<String>(homePage1.this,android.R.layout.simple_list_item_1,arrayList1);
        lvSubphones.setAdapter(adapter1);
        onBtnClick2();

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

        ivCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker1 =new DatePickerFragment();
                datePicker1.show(getSupportFragmentManager(),"date picker 2");
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


       btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name,Dob,Gen,Address,SubPhn,Source,Destination,Sick,Symptons;
                Name=etName.getText().toString().trim();
                Dob=etAge.getText().toString().trim();
                Gen=spinner.getSelectedItem().toString().trim();
                Address=etAddress.getText().toString().trim();
                SubPhn=etSubsidaryPhones.getText().toString().trim();
                Source=etSource.getText().toString().trim();
                Destination=etDestination.getText().toString().trim();
                Sick=etSick.getText().toString().trim();
                Symptons=etSymptoms.getText().toString().trim();

                if (Name.isEmpty()||Dob.isEmpty()||(SubPhn.length()<10)||Gen.isEmpty()||Address.isEmpty() ||Source.isEmpty()|| Destination.isEmpty()|| Sick.isEmpty())
                { Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_LONG).show();
              //  btnNext1.setVisibility(View.INVISIBLE);
                    }
                else {
                    //btnNext1.setVisibility(View.VISIBLE);
                    addCredentials();
                }

            }

        });

}
    public void addCredentials()
    {

        String dvAdd,dvPhn,dvName,dvDob,dvGen,dvSrc,dvDest,dvSick,dvSymptons = new String();
        String dvid= databaseDrivers.push().getKey();
        dvAdd=etAddress.getText().toString().trim();
        dvPhn=etSubsidaryPhones.getText().toString().trim();
        dvGen=spGender.getSelectedItem().toString().trim();
        dvName=etName.getText().toString().trim();
        dvDob=etAge.getText().toString().trim();
        dvSrc=etSource.getText().toString().trim();
        dvDest=etDestination.getText().toString().trim();
        dvSick=etSick.getText().toString().trim();
        dvSymptons=etSymptoms.getText().toString().trim();
        user_info dCredentials= new user_info(dvAdd,dvPhn,dvName,dvDob,dvGen,dvSrc,dvDest,dvSick,dvSymptons);
        databaseDrivers.child(dvid).setValue(dCredentials);
    }

    public void onBtnClick2(){
        bAddPhn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mSub=etSubsidaryPhones.getText().toString();
                arrayList1.add(mSub);
                adapter1.notifyDataSetChanged();
            }
        });
    }

    public void onBtnClick(){
        ivAddSymptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mSym=etSymptoms.getText().toString();
                arrayList.add(mSym);
                adap.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view,int year, int month, int dayOfMonth ) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);


        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        String currentDateString2 = DateFormat.getDateInstance().format(c.getTime());
        etAge.setText(currentDateString);
        etSick.setText(currentDateString2);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text1=parent.getItemAtPosition(position).toString();
       Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
