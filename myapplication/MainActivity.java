package com.ruben.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Botão para ir do Layout "Login" para o Layout "Menu"
    public void enterMenu(View view){
        Intent intent = new Intent (this,MenuActivity.class);
        startActivity(intent);
    }






}
