package com.gamecodeschool.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.DateFormat;
import java.util.Calendar;

public class homePage2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText etSource,etDestination,etSick,etSymptoms;
    ImageView ivCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        etSource=findViewById(R.id.etSource);
        etDestination=findViewById(R.id.etDestination);
        etSick=findViewById(R.id.etSick);
        etSymptoms=findViewById(R.id.etSymptoms);
        ivCal=findViewById(R.id.ivCal);
        ivCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker =new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
    }

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
