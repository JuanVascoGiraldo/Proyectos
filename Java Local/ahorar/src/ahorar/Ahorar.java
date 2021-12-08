
package ahorar;

import java.util.Scanner;


public class Ahorar {

  
    public static void main(String[] args) {
       Scanner entrada= new Scanner(System.in);
       
       boolean continuar= true;
       double ahorro= 0;
       int opcion= 1;
       double cantidad=0;
        System.out.println("************************************************************");
        System.out.println("Bienbenido a tu alcancia de ahorro, tu ahorro es: "+ ahorro);
        System.out.println("Cuando llegues a 1000 pesos de avisaremos");
        System.out.println("************************************************************");
        do{
            System.out.println("Si quieres agregar dinero a su ahorro coloque (1) si no desea continuar coloque (0)");
            opcion=entrada.nextInt();
            if(opcion==1){
                continuar= true;
                System.out.println("¿que cantidad deseas ingresar?,recuerda quesolo puedes agregar hasta 100 pesos");
                cantidad= entrada.nextDouble();
                if(cantidad<=100){
                    ahorro= ahorro + cantidad;
                    if(ahorro>=1000){
                        System.out.println("felicidadestu ahorro es de " + ahorro);
                    }
                }
                else{ 
                    System.out.println("**************************************");
                    System.out.println("Disculpa la cantidad ingresada es mas de lo que se puede ingresar");
                    System.out.println("**************************************");}
            }
            if (opcion==0){
                continuar= false; 
            }
            System.out.println("Tu ahorro es de " + ahorro);
            
        }
        while(continuar == true);
        System.out.println("*****************Buen dia****************");
    }
    
    
}
