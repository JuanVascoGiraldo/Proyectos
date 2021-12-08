
package mundodesuperheroes;

import java.util.Scanner;

public class MundoDeSuperheroes {

    public static void main(String[] args) {
        
        /*Personaje miPersonaje[]= new Personaje [3];
        miPersonaje[0]= new Personaje("Peter","Masculino", false);
        miPersonaje[1]= new Personaje("Peter2","Masculino", false);
        miPersonaje[2]= new Personaje("Peter3","Masculino", false);
        for(int i=0; i<3; i++){
            System.out.println(miPersonaje[i].getNombre()+ ","+ miPersonaje[i].getSexo() + "," + miPersonaje[i].getesMutante());
        }
        */
        Villano miVillano[]= new Villano[2];
        miVillano[0]=new Villano("Joker", "Masculino", false, "Humano", true);
        miVillano[1]=new Villano("Thanos", "Masculino", false, "alienigena", true);
         
         for(int i=0; i<2; i++){
             if(miVillano[i].getesMutante().equals("true")){
             miVillano[i].setesMutante("si");}
                else{
                miVillano[i].setesMutante("no");}
             if(miVillano[i].getHistoriaTragica().equals("true")){
                miVillano[i].setHistoriaTragica("si");}
             else{
                miVillano[i].setHistoriaTragica("no");}
                    System.out.println("su nombre es: " +  miVillano[i].getNombre()+ "\t su genero es: " 
                        + miVillano[i].getSexo() + "\t es mutante?: " 
                        + miVillano[i].getesMutante() + " \t su tipo es: " + miVillano[i].getTipo()
                        + "\t Tiene historia tragica? "+ miVillano[i].getHistoriaTragica());
         }
         
        /*Scanner entrada= new Scanner(System.in);
        Scanner entrada2= new Scanner(System.in);
        String tunombre;
        String tugenero;
        String rol;
        String tutipo;
        boolean tuhistoria;
        boolean tumutante;
        System.out.println("Introduce tu nombre");
        tunombre= entrada.next();
        System.out.println("introduce tu genero");
        tugenero= entrada.next();
        System.out.println("Eres mutante?");
        tumutante= entrada.nextBoolean();
        System.out.println("eres heroe o villano?");
        rol= entrada.next();
        switch(rol){
            case "heroe": case "Heroe":
                System.out.println("que tipo de heroe eres");
                tutipo =entrada.next();
                Heroe objHeroe=new Heroe(tunombre,tugenero, tumutante,tutipo);
                System.out.println(objHeroe.volar());
                System.out.println(objHeroe.tenerRayosX());
                System.out.println(objHeroe);
                break;
            case "villano": case "Villano":
                System.out.println("que tipo de villano eres eres");
                tutipo =entrada.next();
                System.out.println("tienes historia tragica? (True / False)");
                tuhistoria= entrada2.nextBoolean();
                Villano objVillano= new Villano(tunombre,tugenero, tumutante,tutipo, tuhistoria);
                System.out.println(objVillano.matar());
                System.out.println(objVillano.hacerCosasMalas());
                break;
            default: 
                System.out.println("ese rol no hace nada especial");
                break;
        }
        */
    
    
    }
    
}
