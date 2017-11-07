package com.ruben.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DefinitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);
    }

    //CRIAR UM CLASSE E ACTIVIVIDADE "CREDITS"
    /*
    public void Credits(View view){
        Intent intent = new Intent (this,CreditsActivity.class);
        startActivity(intent);
    }
    */
}
