package com.sveri.employeesalaryapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button btn1,btn2;
    Button btn3;
    MyHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        ed1 = findViewById(R.id.empsal);
        ed2 = findViewById(R.id.emptax);
        ed3 = findViewById(R.id.netsal);
        ed4 = findViewById(R.id.empname);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn3=findViewById(R.id.btnInsert);
        db=new MyHelper(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed4.setText("");

                ed4.requestFocus();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double salary = Double.parseDouble(ed1.getText().toString());
                double tax;

                if(salary > 50000)

                {
                    tax =  salary * 10/100;

                }

                else if(salary > 30000)
                {

                    tax =  salary * 5/100;
                }

                else
                {
                    tax = 0;
                }

                ed2.setText(String.valueOf(tax));
                double netsal = salary - tax;
                ed3.setText(String.valueOf(netsal));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SecondActivity.this,ThirdActivity.class);
                i.putExtra("Name",ed4.getText().toString());
                i.putExtra("Salary",ed1.getText().toString());
                i.putExtra("Tax",ed2.getText().toString());
                i.putExtra("NetSalary",ed3.getText().toString());
                startActivity(i);
                Toast.makeText(SecondActivity.this, "Data Inserted Successfully!!!", Toast.LENGTH_SHORT).show();
                ed4.setText(null);
                ed1.setText(null);
                ed2.setText(null);
                ed3.setText(null);

            }
        });
    }
}
