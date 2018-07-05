package com.example.admin.alpha1;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class User extends AppCompatActivity {
    private TextInputEditText email,password;
    private Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        password = (TextInputEditText)findViewById(R.id.edittext2);
        email = (TextInputEditText)findViewById(R.id.edittext);
        register = (Button)findViewById(R.id.button3);
        login = (Button)findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getText().toString())) {
                    Toast.makeText(User.this,"please enter your email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(User.this,"please enter your password",Toast.LENGTH_SHORT).show();
                    return;
                }
                String emailpattern= "[a-aZ-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+"\\@"+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+"("+"\\."+"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"+")+";
                if (email.getText().toString().matches(emailpattern)){
                    Toast.makeText(getApplicationContext(), "email is valid ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "email is invalid", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(User.this,"login successfully",Toast.LENGTH_SHORT).show();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myne = new Intent(User.this,UserRegister.class);
                startActivity(myne);
            }
        });
    }
}
