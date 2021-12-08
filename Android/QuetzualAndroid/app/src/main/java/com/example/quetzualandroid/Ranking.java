package com.example.quetzualandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quetzualandroid.Interfaces.API;
import com.example.quetzualandroid.Models.mes;
import com.example.quetzualandroid.Models.usuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ranking extends AppCompatActivity {

    String nombre, correo, fecha, genero;
    int id;

    TextView nom1, nom2, nom3, nom4, punt1, punt2, punt3, punt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        id = getIntent().getIntExtra("id", 2);
        nombre = getIntent().getStringExtra("nombre");
        correo = getIntent().getStringExtra("correo");
        fecha = getIntent().getStringExtra("fecha");
        genero = getIntent().getStringExtra("genero");

        nom1 = findViewById(R.id.nom1);
        nom2 = findViewById(R.id.nom2);
        nom3 = findViewById(R.id.nom3);
        nom4 = findViewById(R.id.nom4);
        punt1 = findViewById(R.id.punt1);
        punt2 = findViewById(R.id.punt2);
        punt3 = findViewById(R.id.punt3);
        punt4 = findViewById(R.id.punt4);

        ranking();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int idd = item.getItemId();
        if (idd == R.id.item1){
            Intent i = new Intent(this, PreguntasPendientes.class);
            i.putExtra("id",  id);
            i.putExtra("correo", correo);
            i.putExtra("fecha", fecha);
            i.putExtra("nombre", nombre);
            i.putExtra("genero", genero);
            startActivity(i);
            Toast.makeText(this, "Preguntas Pendientes",Toast.LENGTH_SHORT).show();
        }
        else if (idd == R.id.item2){
            Intent i = new Intent(this, Ranking.class);
            i.putExtra("id",  id);
            i.putExtra("correo", correo);
            i.putExtra("fecha", fecha);
            i.putExtra("nombre", nombre);
            i.putExtra("genero", genero);
            startActivity(i);
            Toast.makeText(this, "Ranking",Toast.LENGTH_SHORT).show();
        }
        else if (idd == R.id.item3){
            Intent i = new Intent(this, Cuenta.class);
            i.putExtra("id",  id);
            i.putExtra("correo", correo);
            i.putExtra("fecha", fecha);
            i.putExtra("nombre", nombre);
            i.putExtra("genero", genero);
            startActivity(i);
            Toast.makeText(this, "Cuenta",Toast.LENGTH_SHORT).show();
        }else if (idd == R.id.item4){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Inicio",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void ranking(){
        Calendar fecha = java.util.Calendar.getInstance();
        String mes = (fecha.get(java.util.Calendar.MONTH)+1) + "/"
                + fecha.get(java.util.Calendar.YEAR);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://basededatosandroid.herokuapp.com/quetzual/Doctor/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        mes mess = new mes();
        mess.setMes_punt(mes);
        Call<List<usuario>> call = api.ranking(mess);
        call.enqueue(new Callback<List<usuario>>() {

            @Override
            public void onResponse(Call<List<usuario>> call, Response<List<usuario>> response) {
               if(response.isSuccessful()){
                   List<usuario> usus = response.body();
                   mostrar(usus);
               }

            }

            @Override
            public void onFailure(Call<List<usuario>> call, Throwable t) {

            }
        });
    }

    public void mostrar(List<usuario> usus){
        int sizes =usus.size();

        if(sizes == 0){
            nom1.setText("");
            punt1.setText("");
            nom2.setText("");
            punt2.setText("");
            nom3.setText("");
            punt3.setText("");
            nom4.setText("");
            punt4.setText("");
        }else if(sizes == 1){
            usuario usu1 = usus.get(0);
            nom1.setText(usu1.getNom_usu());
            punt1.setText(String.valueOf(usu1.getCant_punt()));
            nom2.setText("");
            punt2.setText("");
            nom3.setText("");
            punt3.setText("");
            nom4.setText("");
            punt4.setText("");
        }else if(sizes == 2){
            usuario usu1 = usus.get(0);
            usuario usu2 = usus.get(1);
            nom1.setText(usu1.getNom_usu());
            punt1.setText(String.valueOf(usu1.getCant_punt()));
            nom2.setText(usu2.getNom_usu());
            punt2.setText(String.valueOf(usu2.getCant_punt()));
            nom3.setText("");
            punt3.setText("");
            nom4.setText("");
            punt4.setText("");
        }else if(sizes == 3){
            usuario usu1 = usus.get(0);
            usuario usu2 = usus.get(1);
            usuario usu3 = usus.get(2);
            nom1.setText(usu1.getNom_usu());
            punt1.setText(String.valueOf(usu1.getCant_punt()));
            nom2.setText(usu2.getNom_usu());
            punt2.setText(String.valueOf(usu2.getCant_punt()));
            nom3.setText(usu3.getNom_usu());
            punt3.setText(String.valueOf(usu3.getCant_punt()));
            nom4.setText("");
            punt4.setText("");
        }else if(sizes > 3){
            usuario usu1 = usus.get(0);
            usuario usu2 = usus.get(1);
            usuario usu3 = usus.get(2);
            usuario usu4 = usus.get(3);
            nom1.setText(usu1.getNom_usu());
            punt1.setText(String.valueOf(usu1.getCant_punt()));
            nom2.setText(usu2.getNom_usu());
            punt2.setText(String.valueOf(usu2.getCant_punt()));
            nom3.setText(usu3.getNom_usu());
            punt3.setText(String.valueOf(usu3.getCant_punt()));
            nom4.setText(usu4.getNom_usu());
            punt4.setText(String.valueOf(usu4.getCant_punt()));
        }
    }
}