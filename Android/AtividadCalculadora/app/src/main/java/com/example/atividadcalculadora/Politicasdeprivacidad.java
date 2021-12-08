package com.example.atividadcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Politicasdeprivacidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politicasdeprivacidad);
    }

    public void irapoliticadeprivacidad(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}