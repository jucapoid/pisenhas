package com.ruben.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button register;
    EditText textName, textNickname, textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Button
        register =(Button) findViewById(R.id.register);

        // User info
        textEmail = (EditText) findViewById(R.id.textEmail);
        textPassword = (EditText) findViewById(R.id.textPassword);
        textName = (EditText) findViewById(R.id.textName);
        textNickname = (EditText) findViewById(R.id.textNickname);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.register:
                String name = textName.getText().toString();
                String nickname = textNickname.getText().toString();
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();

                Usuario usuario = new Usuario(name, nickname, email, password);
                break;
        }
    }
}
