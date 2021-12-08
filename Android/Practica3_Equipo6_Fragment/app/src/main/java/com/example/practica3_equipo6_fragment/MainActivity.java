package com.example.practica3_equipo6_fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practica3_equipo6_fragment.ui.main.MainFragment;
import com.example.practica3_equipo6_fragment.ui.mainfragment2.MainFragment2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.item1){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Mamiferos",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.item2){
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
            Toast.makeText(this, "Reptiles",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.item3){
            Intent i = new Intent(this, MainActivity3.class);
            startActivity(i);
            Toast.makeText(this, "Aves",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}