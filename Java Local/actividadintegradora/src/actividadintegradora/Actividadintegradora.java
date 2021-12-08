
package actividadintegradora;

import java.util.Scanner;

public class Actividadintegradora {

    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Scanner letra= new Scanner(System.in);
        double $precio;
        double $descuento;
        double $total;
        String producto;
        int confirmacion;
        do{ 
            System.out.println("¿que producto desea comprar?");
            producto= letra.nextLine();
            System.out.println("introcucir el precio del producto a comprar");
            $precio= entrada.nextDouble();
            if($precio>=500){
                if($precio<=999){
                    System.out.println("El descuento es del 20%");
                    $descuento= $precio/5;
                }
                else{
                    System.out.println("El descuento es del 25%");
                    $descuento= $precio/4;}
            } 
            else {
                $descuento=0.0;
            }
            $total= $precio-$descuento;
            System.out.println("el descuento aplicado es de " + $descuento+"$");
            System.out.println("el total a pagar del/de la " + producto+ " es de " + $total+"$");
            System.out.println("<----------------------------------------------------->");
            System.out.println("¿desea seguir comprando?\n"
                    + "si(1) No(2) \t introduce el numero de la respuesta");
            confirmacion= entrada.nextInt();
            System.out.println("<----------------------------------------------------->");
        }
        while(confirmacion==1);
        System.out.println("________________________________________________________");
        System.out.println("gracias por comprar en la tienda de abarrotes FreeTime");
        System.out.println("---------------------------------------------------------");
    }
    
}
