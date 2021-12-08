package com.example.practica2_equipo6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraCientifica extends AppCompatActivity {

    private int numero =  1;
    private TextView num1;
    private TextView num2;
    private TextView resultado;
    private TextView operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_cientifica);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.Resultado);
        operacion = findViewById(R.id.op);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.tem1){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Calculadora Normal",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.item){
            Intent i = new Intent(this, CalculadoraCientifica.class);
            startActivity(i);
            Toast.makeText(this, "Calculadora Cientifica",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void numero2(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("2");
            }else{
                num1.setText(text+ "2");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("2");
            }else{
                num2.setText(text+ "2");
            }
        }
    }

    public void numero3(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA") ){
                num1.setText("3");
            }else{
                num1.setText(text+ "3");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("3");
            }else{
                num2.setText(text+ "3");
            }
        }
    }

    public void numero4(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("4");
            }else{
                num1.setText(text+ "4");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("4");
            }else{
                num2.setText(text+ "4");
            }
        }
    }

    public void numero5(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("5");
            }else{
                num1.setText(text+ "5");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("5");
            }else{
                num2.setText(text+ "5");
            }
        }
    }

    public void numero6(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("6");
            }else{
                num1.setText(text+ "6");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("6");
            }else{
                num2.setText(text+ "6");
            }
        }
    }

    public void numero7(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("7");
            }else{
                num1.setText(text+ "7");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("7");
            }else{
                num2.setText(text+ "7");
            }
        }
    }

    public void numero8(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("8");
            }else{
                num1.setText(text+ "8");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("8");
            }else{
                num2.setText(text+ "8");
            }
        }
    }

    public void numero9(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("9");
            }else{
                num1.setText(text+ "9");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("9");
            }else{
                num2.setText(text+ "9");
            }
        }
    }

    public void numero1(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("1");
            }else{
                num1.setText(text+ "1");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("1");
            }else{
                num2.setText(text+ "1");
            }
        }
    }

    public void numero0(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("0");
            }else{
                num1.setText(text+ "0");
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("0");
            }else{
                num2.setText(text+ "0");
            }
        }
    }

    public void punto(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(!text.equals("NA")) {
                if(!text.contains(".")){
                    num1.setText(text+ ".");
                }
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(!text.equals("NA")){
                if(!text.contains(".")){
                    num2.setText(text+ ".");
                }
            }
        }
    }

    public void menos(View view){
        if(numero == 1){
            String text =  num1.getText().toString();
            if(text.equals("NA")){
                num1.setText("-");
            }else{
                if(Double.parseDouble(text) > 0){
                    String text1= "-" + text;
                    num1.setText(text1);
                }else{
                    Double res= Double.parseDouble(text) * -1;
                    num1.setText(String.valueOf(res));
                }
            }
        }
        if(numero == 2){
            String text =  num2.getText().toString();
            if(text.equals("NA")){
                num2.setText("-");
            }else{
                if(Double.parseDouble(text) > 0){
                    String text1= "-" + text;
                    num2.setText(text1);
                }else{
                    Double res= Double.parseDouble(text) * -1;
                    num2.setText(String.valueOf(res));
                }
            }
        }
    }

    public void borrar(View view){
        if(numero == 1){
            String text = num1.getText().toString();
            if(!text.equals("NA")) {
                text = text.replaceFirst(".$", "");
                if(text.equals("")){
                    text = "NA";
                }
                num1.setText(text);
            }
        }
        if(numero == 2){
            String text = num2.getText().toString();
            if(!text.equals("NA")) {
                text = text.replaceFirst(".$", "");
                if(text.equals("")){
                    text = "NA";
                }
                num2.setText(text);
            }
        }
    }

    public void sumar(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1 ){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("Suma");
                    numero = 2;
                }
                else{
                    operacion.setText("Suma");
                    numero = 2;
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("Suma");
                    numero = 2;
                }
            }else if(numero == 3){
                operacion.setText("Suma");
                numero = 2;
            }
        }
    }

    public void restar(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("Resta");
                    numero = 2;
                }
                else{
                    operacion.setText("Resta");
                    numero = 2;
                }
            }
        }
        else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("Resta");
                    numero = 2;
                }
            }else if(numero == 3){
                operacion.setText("Resta");
                numero = 2;
            }
        }
    }

    public void multiplicar(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("Multiplicacion");
                    numero = 2;
                }else{
                    operacion.setText("Multiplicacion");
                    numero = 2;
                }
            }
        }
        else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("Multiplicacion");
                    numero = 2;
                }
            }else if(numero == 3){
                operacion.setText("Multiplicacion");
                numero = 2;
            }
        }
    }

    public void dividir(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("Division");
                    numero = 2;
                }else{
                    operacion.setText("Division");
                    numero = 2;
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("Division");
                    numero = 2;
                }
            }else if(numero == 3){
                operacion.setText("Division");
                numero = 2;
            }
        }
    }

    public void potencia(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("Potencia");
                    numero = 2;
                }else{
                    operacion.setText("Potencia");
                    numero = 2;
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("Potencia");
                    numero = 2;
                }
            }else if(numero == 3){
                operacion.setText("Potencia");
                numero = 2;
            }
        }
    }

    public void seno(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("seno");
                    num2.setText("0");
                    resultado(view);
                }else{
                    operacion.setText("seno");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("seno");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }
    }

    public void coseno(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("coseno");
                    num2.setText("0");
                    resultado(view);
                }else{
                    operacion.setText("coseno");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("coseno");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }
    }

    public void tangente(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("tangente");
                    num2.setText("0");
                    resultado(view);
                }else{
                    operacion.setText("tangente");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("tangente");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }
    }

    public void logaritmo(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("logaritmo");
                    num2.setText("0");
                    resultado(view);
                }else{
                    operacion.setText("logaritmo");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("logaritmo");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }
    }

    public void logaritmonatural(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("logaritmonatural");
                    num2.setText("0");
                    resultado(view);
                }else{
                    operacion.setText("logaritmonatural");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("logaritmonatural");
                    num2.setText("0");
                    resultado(view);
                }
            }
        }
    }

   public void reciproco(View view){
       String text =  resultado.getText().toString();
       if(!text.equals("NA")&& !text.equals("¡Error!") && !text.equals("Infinito")){
           if(numero == 1){
               if(num1.getText().toString().equals("NA")) {
                   num1.setText(text);
                   operacion.setText("reciproco");
                   num2.setText("0");
                   resultado(view);
               }else{
                   operacion.setText("reciproco");
                   num2.setText("0");
                   resultado(view);
               }
           }
       }else{
           if(numero == 1){
               String numer= num1.getText().toString();
               if(!numer.equals("NA")){
                   operacion.setText("reciproco");
                   num2.setText("0");
                   resultado(view);
               }
           }
       }
   }

    public void raiz(View view){
        String text =  resultado.getText().toString();
        if(!text.equals("NA")|| !text.equals("¡Error!") || !text.equals("Infinito")){
            if(numero == 1){
                if(num1.getText().toString().equals("NA")) {
                    num1.setText(text);
                    operacion.setText("Raiz");
                    numero = 2;
                }else{
                    operacion.setText("Raiz");
                    numero = 2;
                }
            }
        }else{
            if(numero == 1){
                String numer= num1.getText().toString();
                if(!numer.equals("NA")){
                    operacion.setText("Raiz");
                    numero = 2;
                }
            }else if(numero == 3){
                operacion.setText("Raiz");
                numero = 2;
            }
        }
    }

    public void Restablecer(View view){
        num1.setText("NA");
        num2.setText("NA");
        resultado.setText("NA");
        operacion.setText("");
        numero = 1;
    }

    public void editar (View view){
        switch(view.getId()){
            case R.id.editarnum11:
                numero=1;
                break;
            case R.id.editarnum22:
                numero =2;
                break;
            case R.id.editarop:
                numero =3;
                break;
        }
    }

    public void resultado(View view){
        String nn2 = num2.getText().toString();
        if(!nn2.equals("NA")){
            try {
                Double n1 = Double.valueOf(num1.getText().toString());
                Double n2 = Double.valueOf(nn2);
                String op = operacion.getText().toString();
                if (op.equals("Suma")) {
                    Double re = n1 + n2;
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                } else if (op.equals("Resta")) {
                    Double re = n1 - n2;
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                } else if (op.equals("Multiplicacion")) {
                    Double re = n1 * n2;
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                } else if (op.equals("Division")) {
                    if (n2 != 0.0) {
                        Double re = n1 / n2;
                        resultado.setText(String.valueOf(re));
                        num1.setText("NA");
                        num2.setText("NA");
                        operacion.setText("");
                        numero = 1;
                    }else{
                        resultado.setText("Infinito");
                        num1.setText("NA");
                        num2.setText("NA");
                        operacion.setText("");
                        numero = 1;
                    }
                }else if (op.equals("Raiz")) {
                    if(n2 % 2 == 0 && n1>0){
                        Double raiz= 1 / n2;
                        Double re = Math.pow(n1,raiz);
                        resultado.setText(String.valueOf(re));
                        num1.setText("NA");
                        num2.setText("NA");
                        operacion.setText("");
                        numero = 1;
                    }else if(n2 % 2 == 0 && n1<0){
                        resultado.setText("¡Error!");
                        num1.setText("NA");
                        num2.setText("NA");
                        operacion.setText("");
                        numero = 1;
                    }else if(n2 % 2 != 0 && n1>0){
                        Double raiz= 1 / n2;
                        Double re = Math.pow(n1,raiz);
                        resultado.setText(String.valueOf(re));
                        num1.setText("NA");
                        num2.setText("NA");
                        operacion.setText("");
                        numero = 1;
                    }else if(n2 % 2 != 0 && n1<0){
                        Double raiz= 1 / n2;
                        Double re = Math.pow(n1*-1,raiz);
                        resultado.setText("-" + String.valueOf(re));
                        num1.setText("NA");
                        num2.setText("NA");
                        operacion.setText("");
                        numero = 1;
                    }
                }else if (op.equals("Potencia")) {
                    Double re = Math.pow(n1,n2);
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }else if (op.equals("seno")){
                    Double re= Math.sin(n1);
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }else if (op.equals("coseno")){
                    Double re= Math.cos(n1);
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }else if (op.equals("tangente")){
                    Double re= Math.tan(n1);
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }else if (op.equals("logaritmo")){
                    Double re= Math.log10(n1);
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }else if (op.equals("logaritmonatural")){
                    Double re= Math.log(n1);
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }else if (op.equals("reciproco")){
                    Double re= 1/n1;
                    resultado.setText(String.valueOf(re));
                    num1.setText("NA");
                    num2.setText("NA");
                    operacion.setText("");
                    numero = 1;
                }
            }catch(Exception e){
                resultado.setText("¡Error!");
                num1.setText("NA");
                num2.setText("NA");
                operacion.setText("");
                numero=1;
            }
        }
    }

}