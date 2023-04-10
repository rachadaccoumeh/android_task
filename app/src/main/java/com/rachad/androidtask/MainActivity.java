package com.rachad.androidtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextFirstName,editTextLastName,editTextAge;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFirstName=findViewById(R.id.editTextFirstName);
        editTextLastName=findViewById(R.id.editTextLastName);
        editTextAge=findViewById(R.id.editTextAge);
        textViewResult=findViewById(R.id.textViewResult);
        findViewById(R.id.buttonSubmit).setOnClickListener(v -> {
            String firstName=editTextFirstName.getText().toString();
            String lastName=editTextLastName.getText().toString();
            String age=editTextAge.getText().toString();
            if(firstName.isEmpty()){
                editTextFirstName.setError("First Name is required");
                editTextFirstName.requestFocus();
                return;
            }
            if(lastName.isEmpty()){
                editTextLastName.setError("Last Name is required");
                editTextLastName.requestFocus();
                return;
            }
            if(age.isEmpty()){
                editTextAge.setError("Age is required");
                editTextAge.requestFocus();
                return;
            }

            //get current year
            int currentYear=java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            textViewResult.setText("Your full name is: "+firstName+" "+lastName+"\nyou were born in"+(currentYear-Integer.parseInt(age)));
        });
    }
}