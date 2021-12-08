/*Vasco Giraldo Juan Esteban
 */
package examen;

import java.util.Scanner;
import javax.swing.JOptionPane;

/*Vasco Giraldo Juan Esteban
 */
public class Examen {

    /*Vasco Giraldo Juan Esteban
 */
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Scanner letra= new Scanner(System.in);
        int edad;
        String confirmacion;
       String recomendacion1= "¿ya sabes leer?\n"
               + "si es asi felicidades, tienes una inteligencia muy grande, aunque procura aprovechar tu niñez";
       String recomendacion2= "has tus tareas y come tus alimentos para que crescas grande y fuerte\n"
               + "portate bien, es importante que respetes a los adultos";
       String recomendacion3= "aprende a ser responsable en un futuro lo necesitaras,\n"
               + " aprovecha tu juventud porque el tiempo pasa volando";
       String recomendacion4= "madurar es un paso importante para que puedas seguir adelante,\n "
               + "preocura cuidar tu salud y ojala ya allas aprendido a ser responsable";
        
       do{
           JOptionPane.showMessageDialog(null,"----------> Recomendaciones para tu vidad<-------------");
        edad = Integer.parseInt(JOptionPane.showInputDialog("hola usuario, ¿Que edad tienes?"));
        if(edad<=5){
            JOptionPane.showMessageDialog(null,recomendacion1);}
        else{
            if(edad<=8){
                JOptionPane.showMessageDialog(null,recomendacion2);}
            else{ 
                if(edad<=18){
               JOptionPane.showMessageDialog(null,recomendacion3);}
                else{
                    JOptionPane.showMessageDialog(null,recomendacion4);}
            }
            }
           confirmacion= JOptionPane.showInputDialog("¿deseas introducir otra edad?\t (Si/No)");
       }
       while(confirmacion.equals("Si"));
        JOptionPane.showMessageDialog(null,"<------------tenga buen dia----------->" );
       }
        }
        
    
    

