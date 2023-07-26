package com.sveri.employeesalaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    //eTextView tv1,tv2,tv3,tv4;
    EditText et1,et2,et3,et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        et1=findViewById(R.id.empname);
        et2=findViewById(R.id.empsal);
        et3=findViewById(R.id.emptax);
        et4=findViewById(R.id.netsal);
        et1.setText(getIntent().getExtras().getString("Name"));
        et2.setText(getIntent().getExtras().getString("Salary"));
        et3.setText(getIntent().getExtras().getString("Tax"));
        et4.setText(getIntent().getExtras().getString("NetSalary"));






    }
}