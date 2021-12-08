package com.example.quetzualandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quetzualandroid.Interfaces.API;
import com.example.quetzualandroid.Models.status;
import com.example.quetzualandroid.Models.usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText correo, contra;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correo = findViewById(R.id.correo);
        contra = findViewById(R.id.contra);
        boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar();
            }
        });

    }

    public void iniciar(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://basededatosandroid.herokuapp.com/quetzual/Doctor/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        usuario usu = new usuario();
        usuario user = new usuario() ;
        final boolean[] seguir = {false};
        usu.setContra_usu(contra.getText().toString());
        usu.setEmail_usu(correo.getText().toString());
        Call<usuario> call= api.iniciarsesion(usu);
        String[] sts = new String[2];
        call.enqueue(new Callback<usuario>() {
            @Override
            public void onResponse(Call<usuario> call, Response<usuario> response) {
                if(response.isSuccessful()){
                    usuario usuer= response.body();
                    sts[0]= usuer.getStatus();
                    if (sts[0].equals("encontrado")) {
                        user.setId_usu(usuer.getId_usu());
                        user.setEmail_usu(usuer.getEmail_usu());
                        user.setNom_usu(usuer.getNom_usu());
                        user.setId_gen(usuer.getId_gen());
                        user.setFecha_nac(usuer.getFecha_nac());
                        ir(user);
                    }else{
                        no();
                    }
                }
            }

            @Override
            public void onFailure(Call<usuario> call, Throwable t) {

            }
        });
    }

    public void ir(usuario user){
        Intent i = new Intent(this, InicioDoctor.class);
        i.putExtra("id",  user.getId_usu());
        i.putExtra("correo", user.getEmail_usu() );
        i.putExtra("fecha", user.getFecha_nac());
        i.putExtra("nombre", user.getNom_usu());
        String genero = "";
        if(user.getId_gen() == 1){
            genero = "Prefiero no Decirlo";
        }else if(user.getId_gen()== 2){
            genero = "femenino";
        }else{
            genero = "masculino";
        }
        i.putExtra("genero", genero);

        startActivity(i);

    }
    public void no(){
        Toast.makeText(this, "Usuario no encontrado",Toast.LENGTH_SHORT).show();
    }
}