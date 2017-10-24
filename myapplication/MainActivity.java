package com.ruben.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button signin;
    EditText textPssword, textEmail;
    SaveUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEmail = (EditText) findViewById(R.id.textEmail);
        textPssword = (EditText) findViewById(R.id.textPassword);

        signin = (Button) findViewById(R.id.sign_in);
        signin.setOnClickListener(this);

        user = new SaveUser(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sign_in:

                Usuario usuario = new Usuario(null,null);
                user.storeUserData(usuario);
                user.setUserLoggedIn(true);
                break;
        }

    }

    // Botão para ir do Layout "Login" para o Layout "Menu"
    public void enterMenu(View view){
        Intent intent_Menu = new Intent (this,MenuActivity.class);
        startActivity(intent_Menu);
    }

    // Botão para o aluno se registar
    public void register(View view){
        Intent intent_Register = new Intent(this,RegisterActivity.class);
        startActivity(intent_Register);
    }

}
