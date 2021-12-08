
package calculadoraconclases;

import java.util.Scanner;

public class Calculadoraconclases {

    public static void main(String[] args) {
       Scanner entrada= new Scanner(System.in);
       Operaciones calcular= new Operaciones();
       float unvalor;
       float otrovalor;
       float resultados;
       String operacion;
        System.out.println("Introduce las operaciones a realizar \t (intoduce la primera letra en mayuscula)");
        operacion= entrada.next();
        if(operacion.equals("Sumar")){
            System.out.println("introduce un numero");
            unvalor=entrada.nextFloat();
            System.out.println("introduce un numero");
            otrovalor= entrada.nextFloat();
            resultados= calcular.sumar(unvalor, otrovalor);
        }
        else{
            if(operacion.equals("Dividir")){
            System.out.println("introduce un numero");
            unvalor=entrada.nextFloat();
            System.out.println("introduce un numero");
            otrovalor= entrada.nextFloat();
            resultados= calcular.dividir(unvalor, otrovalor);
            }
            else{
            System.out.println("introduce un numero");
            unvalor=entrada.nextFloat();
            System.out.println("introduce un numero");
            otrovalor= entrada.nextFloat();
            resultados= calcular.multiplicar(unvalor, otrovalor);
            }
        }
        System.out.println(resultados);
    }
    
}
