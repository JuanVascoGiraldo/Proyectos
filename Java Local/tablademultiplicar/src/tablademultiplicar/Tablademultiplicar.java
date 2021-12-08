
package tablademultiplicar;

import java.util.Scanner;

public class Tablademultiplicar {

 
    public static void main(String[] args) {
     
        Scanner in= new Scanner (System.in);    
    
        System.out.println("Digite un numero entero");
    
        int numero = in.nextInt();
    
        System.out.println("Digite hasta que numero lo desea multiplicar");
    
        int cantidad= in.nextInt();
    
        int multiplicador=0;
    
        int resultado;
        
        while(multiplicador < cantidad){
        multiplicador++;
            resultado= multiplicador * numero;
            System.out.println(numero + "x" + multiplicador + "=" + resultado);
        }
    } 
    }
    

