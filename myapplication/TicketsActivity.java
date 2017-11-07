package com.ruben.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TicketsActivity extends AppCompatActivity {

    // Servirá para mostrar ao usuário as senhas que comprou
    BuyActivity buyActivity = new BuyActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
    }

    public TicketsActivity(){

    }

}
