package com.ruben.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

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

    // Botão LogOut (Usar o Objeto View)
}
