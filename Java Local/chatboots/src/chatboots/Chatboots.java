
package chatboots;

import java.util.Scanner;


public class Chatboots {

  
    public static void main(String[] args) {
      
        Scanner entrada= new Scanner(System.in);
         String platicar;
         String genero;
         String seguir;
         do{ 
             System.out.println("Hola, ¿de que tema quieres habalr el dia de hoy ? \n"
                     + "podemos hablar de comics, musica o peliculas");
             platicar= entrada.next();
             switch (platicar){
             case "comics": case "Comics":
                System.out.println("¿Que Genero de " + platicar + " te gusta");
                genero= entrada.next();
                switch(genero){
                    case "accion": case "Accion":
                        System.out.println("el genero de accion es muy bueno");
                        break;
                    case "fantasia": case "Fantasia":
                        System.out.println("el genero de fantasia es muy bueno");
                        break;
                    case "comedia": case "Comedia":
                        System.out.println("ese genero de comedia es bueno para leer");
                        break;
                    default:
                        System.out.println("Perdon no conozco de ese genero");
                        break;
                }
                 break;
             case "peliculas": case "Peliculas":
                System.out.println("¿Que Genero de " + platicar + " te gusta?");
                genero= entrada.next();
                    switch(genero){
                        case "accion": case "Accion":
                        System.out.println("el genero de accion es muy bueno");
                            break;
                        case "fantasia": case "Fantasia":
                        System.out.println("el genero de fantasia es muy bueno");
                            break;
                        case "comedia": case "Comedia":
                        System.out.println("ese genero de comedia es bueno para ver en familia");
                            break;
                        default:
                        System.out.println("Perdon no conozco de ese genero");
                            break;
                }
                    break;
             case "Musica": case "musica":
                System.out.println("¿Que Genero de " + platicar + " te gusta?"); 
                genero= entrada.next();
                    switch (genero){
                        case  "pop": case "Pop":
                            System.out.println("ese genero es muy agradable");
                            break;
                        case "metal": case "Metal":
                            System.out.println("date un baño");
                            break;
                        case "clasica": case "Clasica":
                            System.out.println("ese genero es bueno para concentrarse");
                            break;
                        default:
                            System.out.println("no conozco ese genero pero ha de ser agradable");
                            break;
                    }
                 break;
             default:
                 System.out.println("La opcion seleccionada no esta entre las opciones posibles");
                 break;
         }
             System.out.println("quiere continuar hablando?");
             seguir= entrada.next();
    }
         while(seguir.equals("S"));
         System.out.println("Fue agradable hablar, hasta la proxima");
    
}
}
