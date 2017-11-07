package com.ruben.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button logout;
    SaveUser newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        logout =(Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);
        newUser = new SaveUser(this);
    }

    //////////////////////////////////////////////////////////////////////
    // Botão para os Layout "Senhas" ,"Compras" e "Definições
    public void Senhas(View view){
        Intent intent = new Intent (this,TicketsActivity.class);
        startActivity(intent);
    }

    public void Comprar(View view){
        Intent intent = new Intent (this,BuyActivity.class);
        startActivity(intent);
    }

    public void Definition(View view){
        Intent intent = new Intent (this,DefinitionActivity.class);
        startActivity(intent);
    }
    //////////////////////////////////////////////////////////////////////


    public void onStart(){
        super.onStart();
    }

    private boolean authentication(){
        return newUser.getIfUserLoggedIn();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logout:
                newUser.clearUserData();
                newUser.setUserLoggedIn(false);
                startActivity(new Intent(this, MainActivity.class));
                break;


        }
    }

}
