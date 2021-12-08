
package casadeadopcion;

import java.util.Scanner;

public class CasadeAdopcion {
    
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        Scanner entrada2= new Scanner(System.in);
        String Mascota;
        boolean Repeticion= true;
        boolean Repeticion2= true;
        String confirmacion2;
        String confirmacion;
        int nMascota;
        int j =1;
        System.out.println("-----------Hola Bienvenido a la casa de adopicion-----------");
        do{
        System.out.println("¿Que tipo de mascota deseas adoptar el dia de hoy? \n"
                + "\t (1) Gato \n" + "\t (2) Perro \n" + "\t (3) Loro");
        Mascota= entrada.next();
        switch(Mascota){
            case "Gato": case "gato": case "1":
                Repeticion2= true;
                System.out.println("Los Gatos disponibles para adopción son:");
                Gato Gatos[]= new Gato[3];
                    Gatos[0]= new Gato("Michi", "Macho", false, 2, true, "Largo y gris", "Mezcla", true, true);
                    Gatos[1]= new Gato("Mirai", "Hembra", false, 1, true, "MedioLargo y blanco", "Persa", false, false);      
                    Gatos[2]= new Gato("Hamburgueso", "Macho", true, 6, true, "Corto y negro", "Bombay", true, false);
                do{
                    j=1;
                for(int i=0; i<3; i++){
                    if(Gatos[i].getDiscapacidad().equals("true"))
                        { Gatos[i].setDiscapacidad("Si");}
                    else{Gatos[i].setDiscapacidad("No");}
                    if(Gatos[i].getEsterelizado().equals("true"))
                        {Gatos[i].setEsterelizado("Si");}
                    else {Gatos[i].setEsterelizado("No");}
                    if(Gatos[i].getRescatado().equals("true"))
                        {Gatos[i].setRescatado("Si");}
                    else{Gatos[i].setRescatado("No");}
                    if(Gatos[i].getCallejero().equals("true"))
                        {Gatos[i].setCallejero("Si");}
                    else{Gatos[i].setCallejero("No");}
                    System.out.println("("+ j+")~Nombre: (" + Gatos[i].getNombre()
                    +") ~Sexo: ("+ Gatos[i].getGenero() + ") ~Discapacidad: ("+ Gatos[i].getDiscapacidad()
                    +") ~Edad: ("+ Gatos[i].getEdad() +") ~Esterelizado: ("+ Gatos[i].getEsterelizado()
                    +") ~Pelaje: ("+ Gatos[i].getPelaje() +") ~Raza: ("+ Gatos[i].getRaza()
                    +") ~Rescatado: ("+ Gatos[i].getRescatado() +") ~Callejero: ("+ Gatos[i].getCallejero() +")"
                    );
                    j ++;}
                System.out.println("----------¿Cual Gato desea adoptar?----------");
                System.out.println("introduce el numero");
                nMascota= entrada.nextInt();
                 switch(nMascota){
                     case 1:
                         System.out.println("Gracias por adoptar a " + Gatos[0].getNombre() + ", cuidelo mucho, como sugerencia "
                                 + "puedes llevar al Gato al veterinario al menos una vez al mes");
                         System.out.println(Gatos[0].dormir());
                         Repeticion= true;
                         break;
                     case 2:
                         System.out.println("Gracias por adoptar a " + Gatos[1].getNombre() + ", cuidela mucho, como sugerencia "
                                 + "puedes llevar a la Gata al veterinario al menos una vez al mes");
                         System.out.println(Gatos[1].maullar());
                         Repeticion= true;
                        break;
                     case 3:
                         System.out.println("Gracias por adoptar a " + Gatos[2].getNombre() + ", cuidelo mucho, como sugerencia "
                                 + "puedes llevar al Gato al veterinario al menos una vez al mes");
                         System.out.println(Gatos[2].maullar());
                         Repeticion= true;
                         break;
                     default:
                         System.out.println("disculpe el numero introducido no corresponde a ninguno de los gatos");
                         System.out.println("Quiere volver a introducir un numero? \n Si \t No");
                         confirmacion= entrada.next();
                         if(confirmacion.equals("Si")){
                         Repeticion= false;}
                         else{
                             System.out.println("---------Gracias por venir---------");
                             Repeticion= true;}
                         break;
                 }
                }while (Repeticion == false);
                break;
            case "Perro": case "perro": case "2":
                Repeticion2= true;
                System.out.println("Los Perros disponibles para adopción son:");
                Perro Perros[]= new Perro[3];
                Perros[0]= new Perro("Chems", "Macho", false, 5, true, "Shiba Inu", true, false, true);
                Perros[1]= new Perro("Pelusa", "Hembra", false, 3, false, "Golden retriever", false, false, true);
                Perros[2]= new Perro("Rocky", "Macho", true , 8, true, "Mezcla", true, true, false);
                do{
                    j=1;
                    for(int i=0; i<3; i++ ){
                        if(Perros[i].getDiscapacidad().equals("true"))
                            { Perros[i].setDiscapacidad("Si");}
                        else{Perros[i].setDiscapacidad("No");}
                        if(Perros[i].getEsterelizado().equals("true"))
                            {Perros[i].setEsterelizado("Si");}
                        else {Perros[i].setEsterelizado("No");}
                        if(Perros[i].getRescatado().equals("true"))
                            {Perros[i].setRescatado("Si");}
                        else{Perros[i].setRescatado("No");}
                        if(Perros[i].getAgresivo().equals("true"))
                            {Perros[i].setAgresivo("Si");}
                        else{ Perros[i].setAgresivo("No");}
                        if(Perros[i].getAmoroso().equals("true"))
                            {Perros[i].setAmoroso("Si");}
                        else {Perros[i].setAmoroso("No");}
                        System.out.println("("+ j+")~Nombre: (" + Perros[i].getNombre()
                        +") ~Sexo: ("+ Perros[i].getGenero() + ") ~Discapacidad: ("+ Perros[i].getDiscapacidad()
                        +") ~Edad: ("+ Perros[i].getEdad() +") ~Esterelizado: ("+ Perros[i].getEsterelizado()
                        +") ~Raza: ("+ Perros[i].getRaza()+") ~Rescatado: ("+ Perros[i].getRescatado() 
                        +") ~Agresivo: ("+ Perros[i].getAgresivo()+ ") ~Amoroso: ("+ Perros[i].getAmoroso() + ")"
                        );
                        j ++;}
                    System.out.println("----------¿Cual Perro desea adoptar?----------");
                    System.out.println("introduce el numero");
                    nMascota= entrada.nextInt();
                     switch(nMascota){
                         case 1:
                             System.out.println("Gracias por adoptar a "+ Perros[0].getNombre() +", cuidelo mucho, como sugerencia "
                                     + "puedes llevar al Perro al veterinario al menos una vez al mes");
                             System.out.println(Perros[0].ladrar());
                             Repeticion= true;
                             break;
                         case 2:
                             System.out.println("Gracias por adoptar a "+ Perros[1].getNombre() +", cuidela mucho, como sugerencia "
                                     + "puedes llevar al Perro al veterinario al menos una vez al mes");
                             System.out.println(Perros[1].Jugar());
                             Repeticion= true;
                            break;
                         case 3:
                             System.out.println("Gracias por adoptar a "+ Perros[2].getNombre() +", cuidelo mucho, como sugerencia "
                                     + "puedes llevar al Perro al veterinario al menos una vez al mes");
                             System.out.println(Perros[2].comer());
                             Repeticion= true;
                             break;
                         default:
                             System.out.println("disculpe el numero introducido no corresponde a ninguno de los Perros");
                             System.out.println("Quiere volver a introducir un numero? \n Si \t  No");
                             confirmacion= entrada.next();
                             if(confirmacion.equals("Si")){
                             Repeticion= false;}
                             else{
                                 System.out.println("---------Gracias por venir---------");
                                 Repeticion= true;}
                             break;
                     }
                }while (Repeticion == false);
                break;
            case "Loro": case  "loro": case "3":
                Repeticion2= true;
                System.out.println("Los Loros disponibles para adopción son:");
                Loro Loros[]= new Loro[3];
                Loros[0]= new Loro("Pepe", "Macho", false, 1, "Azul", true, false, true );
                Loros[1]= new Loro("Blue", "Hembra", true, 2, "Verde", false, true, true );
                Loros[2]= new Loro("Sech", "Macho", false, 3, "Amarillo", true, true, true );
                do{
                    j=1;
                    for(int i=0; i<3; i++){
                        if(Loros[i].getDiscapacidad().equals("true"))
                            { Loros[i].setDiscapacidad("Si");}
                        else{Loros[i].setDiscapacidad("No");}
                        if(Loros[i].getVuela().equals("true"))
                        { Loros[i].setVuela("Si");}
                        else{ Loros[i].setVuela("No");}
                        if(Loros[i].getCantar().equals("true")){
                            Loros[i].setCantar("Si");}
                        else{Loros[i].setCantar("No");}
                        if(Loros[i].getHablar().equals("true")){
                            Loros[i].setHablar("Si");}
                        else{Loros[i].setHablar("No");}
                        System.out.println("("+ j+")~Nombre: (" + Loros[i].getNombre()
                        +") ~Sexo: ("+ Loros[i].getGenero() + ") ~Discapacidad: ("+ Loros[i].getDiscapacidad()
                        +") ~Edad: ("+ Loros[i].getEdad()+ ") ~Color: ("+ Loros[i].getColor()+ ") ~PuedeVolar: (" + Loros[i].getVuela()
                        +") ~PuedeCantar: ("+ Loros[i].getCantar() +") ~PuedeHablar: ("+ Loros[i].getHablar()+ ")");
                        j++;}
                    System.out.println("----------¿Cual Loro desea adoptar?----------");
                    System.out.println("introduce el numero");
                    nMascota= entrada.nextInt();
                     switch(nMascota){
                         case 1:
                             System.out.println("Gracias por adoptar a "+ Loros[0].getNombre() +", No olvides cuidarlo apropiadamente "
                                     + "y darle de comer como se sugiere");
                             System.out.println(Loros[0].DecirCosasSinContexto());
                             Repeticion= true;
                             break;
                         case 2:
                             System.out.println("Gracias por adoptar a "+ Loros[1].getNombre() +", No olvides cuidarlo apropiadamente "
                                     + "y darle de comer como se sugiere");
                             System.out.println(Loros[1].Repetircosas());
                             Repeticion= true;
                            break;
                         case 3:
                             System.out.println("Gracias por adoptar a "+ Loros[2].getNombre() +", No olvides cuidarlo apropiadamente "
                                     + "y darle de comer como se sugiere");
                             System.out.println(Loros[2].comer());
                             Repeticion= true;
                             break;
                         default:
                             System.out.println("disculpe el numero introducido no corresponde a ninguno de los Loros");
                             System.out.println("Quiere volver a introducir un numero? \n Si \t  No");
                             confirmacion= entrada.next();
                             if(confirmacion.equals("Si")){
                             Repeticion= false;}
                             else{
                                 System.out.println("---------Gracias por venir---------");
                                 Repeticion= true;}
                             break;
                    
                    }
                }while (Repeticion == false);
                break;
            default:
                System.out.println("Disculpe no tenemos ese tipo de mascota");
                System.out.println("Quiere volver a introducir un numero? \n Si \t  No");
                             confirmacion2= entrada2.next();
                             if(confirmacion2.equals("Si")){
                             Repeticion2= false;}
                             else{
                                 System.out.println("---------Gracias por venir---------");
                                 Repeticion2= true;}
                break;
        }
        }while (Repeticion2 == false);
    }
    
}
