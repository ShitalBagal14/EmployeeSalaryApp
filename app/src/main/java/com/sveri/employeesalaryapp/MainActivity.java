package com.sveri.employeesalaryapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit,btnCancle;
    EditText etName,etEmail,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit=findViewById(R.id.buttonSubmit);
        btnCancle=findViewById(R.id.buttonCancle);
        etName=findViewById(R.id.editTextName);
        etEmail=findViewById(R.id.editTextEmail);
        etPass=findViewById(R.id.editTextNumberPassword);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String pass=etPass.getText().toString().trim();
                if(!name.isEmpty()&&!email.isEmpty()&&!pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Login Successfully!!!", Toast.LENGTH_SHORT)
                            .show();
                    //Intent i=new Intent(MainActivity.this,SecondActivity.class);
                    //startActivity(i);
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));

                }else{
                    Toast.makeText(MainActivity.this, "Incorrect username and password !!!Please enter Correct username and password!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etName.setText(null);
                etEmail.setText(null);
                etPass.setText(null);

            }
        });
    }
}