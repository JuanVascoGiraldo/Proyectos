package jubilacion_1;

import java.util.Scanner;

public class Jubilacion_1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
       
        System.out.println("¿cuanto dinero necesita para retirarse");
        double importe = entrada.nextDouble();
        
        System.out.println("¿cunto van a agregar anualmente?");
        double TipoDeInteres = entrada.nextDouble (); 
        double saldo=0;
        int periodosAnuales = 12;
        while (saldo< importe){
            saldo += importe;
            double intereses= 0;
            intereses= saldo * TipoDeInteres / 100;
            saldo += intereses;
            periodosAnuales++;
        }
        System.out.println("podra retirarse al cabo de " + periodosAnuales + " años");
    }
}
