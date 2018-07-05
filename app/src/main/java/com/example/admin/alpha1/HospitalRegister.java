package com.example.admin.alpha1;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static android.view.View.Z;

public class HospitalRegister extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextInputEditText name,address,bloodaverage,password;
    private Spinner spinner;
    private Button register;
    String[] sex = { "male","female"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);
        name = (TextInputEditText)findViewById(R.id.edittextd);
        address = (TextInputEditText)findViewById(R.id.edittextc);
        bloodaverage = (TextInputEditText)findViewById(R.id.edittextb);
        password = (TextInputEditText)findViewById(R.id.edittexta);
        register = (Button)findViewById(R.id.button6);
        spinner = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sex);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText().toString())) {
                    Toast.makeText(HospitalRegister.this,"please enter your name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address.getText().toString())) {
                    Toast.makeText(HospitalRegister.this,"please enter your email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(bloodaverage.getText().toString())) {
                    Toast.makeText(HospitalRegister.this,"please enter your phone number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(HospitalRegister.this,"please enter your address",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(getApplicationContext(),"you signed up successfully",Toast.LENGTH_SHORT).show();
            }

        });

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
