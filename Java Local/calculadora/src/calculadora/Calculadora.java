
package calculadora;
import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        double numero1;
        double numero2;
        int opcion;
        double resultado;
        String confirmacion;
        do{
                System.out.println("**********operaciones entre dos numeros***********");
                System.out.println("elige el numero que contenga la operacion que deas realizar");
                System.out.println("multiplicacion (1)");
                System.out.println("division (2)");
                System.out.println("suma (3)");
                System.out.println("resta (4)");
                opcion= entrada.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("ingrese un numero para realizar la operacion");
                        numero1= entrada.nextDouble();
                        System.out.println("ingrese el numero por el que sera multiplicado");
                        numero2= entrada.nextDouble();
                        resultado= numero1 * numero2;
                        System.out.println("----------el resultado es-----------");
                        System.out.println(numero1 + " * " + numero2 + " = " + resultado);
                        break;
                    case 2:
                        System.out.println("ingrese el dividiendo");
                        numero1= entrada.nextDouble();
                        System.out.println("ingrese divisor");
                        numero2= entrada.nextDouble();
                        resultado= numero1 / numero2;
                        System.out.println("----------el resultado es-----------");
                        System.out.println(numero1 + " / " + numero2 + " = " + resultado);
                        break;
                    case 3:
                        System.out.println("ingrese el numero a sumar");
                        numero1= entrada.nextDouble();
                        System.out.println("ingrese el segundo numero a sumar");
                        numero2= entrada.nextDouble();
                        resultado= numero1 + numero2;
                        System.out.println("----------el resultado es-----------");
                        System.out.println(numero1 + " + " + numero2 + " = " + resultado);
                        break;
                    case 4:
                        System.out.println("ingrese el minuendo");
                        numero1= entrada.nextDouble();
                        System.out.println("ingrese el sustraendo");
                        numero2= entrada.nextDouble();
                        resultado= numero1 - numero2;
                        System.out.println("----------el resultado es-----------");
                        System.out.println(numero1 + " - " + numero2 + " = " + resultado);
                        break;
                    default:
                        System.out.println("Disculpa la operacion introducida no la podemos resolver");
                        break;
                }
            System.out.println("**********************************************************************");
            System.out.println("********Deseas continuar haciendo operaciones? (S/N)*********");
            confirmacion= entrada.next();
    }
        while(confirmacion.equals("S"));
        
        }
}
