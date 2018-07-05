package com.example.admin.alpha1;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Hospital extends AppCompatActivity {
    private TextInputEditText name,pass;
    private Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        name = (TextInputEditText)findViewById(R.id.edittextl);
        pass = (TextInputEditText)findViewById(R.id.edittextk);
        register = (Button)findViewById(R.id.button7);
        login = (Button)findViewById(R.id.button8);
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent mine = new Intent(Hospital.this,HospitalRegister.class);
                 startActivity(mine);

             }
         });
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (TextUtils.isEmpty(name.getText().toString())) {
                     Toast.makeText(Hospital.this,"please enter your name",Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if (TextUtils.isEmpty(pass.getText().toString())) {
                     Toast.makeText(Hospital.this,"please enter your password",Toast.LENGTH_SHORT).show();
                     return;
                 }
                 Toast.makeText(Hospital.this,"login successfully",Toast.LENGTH_SHORT).show();
             }
         });
    }
}
