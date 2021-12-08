
package jubilacion_2;

import java.util.Scanner;

public class Jubilacion_2 {


    
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        
        System.out.println("¿Cuanto dinero va a aportar cada año?");
        Double aportacion= in.nextDouble();
        
        System.out.println("Tipo de interes en %");
        Double tipodeinteres= in.nextDouble();
       String confirmacion;
        double saldo=0;
        int periodos = 0;
        do {
            saldo += aportacion;
            double interes = saldo * tipodeinteres / 100;
            saldo += interes;
             periodos++;
             System.out.println("al cabo de %d, el importe aculado es " + 
                     periodos + saldo);
             System.out.println("ya puede retirarse? (S/N)");
            confirmacion = in.next();
        } while(confirmacion.equals("N"));
    }}
    

