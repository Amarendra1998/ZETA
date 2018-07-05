package com.example.admin.alpha1;

import android.content.Context;
import android.location.Geocoder;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class UserRegister extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   private TextInputEditText name,email,phone,address,lastdonated,password;
   private Spinner spinner;
   private Button register;
    String[] blood = { "A", "A+","A-", "B", "B+","B-", "C","C+","C-","O","O+","O-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        name = (TextInputEditText)findViewById(R.id.edittext);
        email = (TextInputEditText)findViewById(R.id.edittext1);
        phone = (TextInputEditText)findViewById(R.id.edittext2);
        address = (TextInputEditText)findViewById(R.id.edittext3);
        password = (TextInputEditText)findViewById(R.id.edittext4);
        lastdonated = (TextInputEditText)findViewById(R.id.edittext5);
        register = (Button)findViewById(R.id.button5);
        spinner = (Spinner)findViewById(R.id.spinner);

         ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,blood);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(name.getText().toString())) {
                    Toast.makeText(UserRegister.this,"please enter your name",Toast.LENGTH_SHORT).show();
                    return;
                   }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(UserRegister.this,"please enter your email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone.getText().toString())) {
                    Toast.makeText(UserRegister.this,"please enter your phone number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(address.getText().toString())) {
                    Toast.makeText(UserRegister.this,"please enter your address",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(UserRegister.this,"please enter your password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(lastdonated.getText().toString())) {
                    Toast.makeText(UserRegister.this,"please enter your donation date",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String emailpattern= "[a-aZ-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+"\\@"+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+"("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"+")+";
                  if (email.getText().toString().matches(emailpattern)){
                      Toast.makeText(getApplicationContext(), "email is valid ", Toast.LENGTH_SHORT).show();

                  }else{
                      Toast.makeText(getApplicationContext(), "email is invalid", Toast.LENGTH_SHORT).show();
                      return;
                  }
                String datepattern = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
                if (lastdonated.getText().toString().matches(datepattern)){
                    Toast.makeText(getApplicationContext(), "date is valid", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(), "date is invalid", Toast.LENGTH_SHORT).show();
                    return;
                }
                    Toast.makeText(getApplicationContext(), "sign up successfully", Toast.LENGTH_SHORT).show();

            };


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
