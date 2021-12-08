
package signozodiacal;

import java.util.Scanner;

public class Signozodiacal {

    
    public static void main(String[] args) {
        
        Scanner entrada= new Scanner(System.in);
        String signo;
        String confirmacion;
        do{
            System.out.println("introducir tu signo zodiacal");
            signo = entrada.next();
        switch(signo){
            case "Aries": case "aries":
                System.out.println("21 de marzo a 20 de abril");
                System.out.println("Persona fuerte,con energia,instintivos y dinamica \n con coraje a veces egocentricas, tienden a acapar el \n liderazgo, signo vital asociado a gandes deportistas de competicion");
                break;
            case "tauro" : case "Tauro":
                System.out.println("21 de abril a 20 de mayo");
                System.out.println("Personas resistentes, pacientes, que saben guardar la calma \n"
                + "Tienen como activo la inteligencia. Son personas muy realistas");
                break;
            case "geminis":  case "Geminis":
                System.out.println("21 de mayo a 20 de junio");
                System.out.println("Contradictorios y versátiles, cambian con facilidad.\n "
                        + "Pasan de ser serenos, y fascinantes, a pesimistas y amorfos. \n"
                        + "Fantasiosos, aman la libertad e independencia.");
                break;
            case "cancer": case "Cancer":
                System.out.println("21 de junio a 20 de julio");
                System.out.println("Familares, tímidos, posesivos, imaginativos y románticos.\n"
                        + "Dulces que viajan entre la melancolía y la alegría. ");
                break;
            case "leo": case "Leo":
                System.out.println("21 de julio a 21 de agosto");
                System.out.println("Extrovertidos, autoritarios,libres, fuertes, pasionales y generosos.\n"
                        + " Optimistas y a veces un poco imprudentes. ");
                break;
            case "virgo": case "Virgo":
                System.out.println("22 de agosto a 22 de septiembre");
                System.out.println("Meticulosos en los detalles, eficientes, severos y \n "
                        + "racionales en su vida y trabajo. Buenos ahorradores.");
                break;
            case "Libra": case"libra":
                System.out.println("23 de sempriembre a 22 de octubre");
                System.out.println("Diplomatico, encantador y sociable. \n "
                        + "Los libra son idealistas, pacíficos, optimistas y románticos. ");
                break;
            case "escorpio": case "Escorpio":
                System.out.println("23 de octubre a 22 de noviembre");
                System.out.println("Los más intuitivos, tienden a ser profundos y serios, \n"
                        + "autoritario, celoso, posesivo pero mutables y pasionales.");
                break;
            case "sagitario": case "Sagitario":
                System.out.println("23 de noviembre a 20 de diciembre");
                System.out.println("Confiados, alegres, sinceros, fieles amigos,\n "
                        + "amantes de la naturaleza y el aire libre. ");
                break;
            case "capricornio": case"Capricornio":
                System.out.println("21 de diciembre a 19 de enero");
                System.out.println("Son introvertidos impulsivos... Rasgos en ellos son la \n"
                        + "timidez y la inseguridad; perfil ambicioso, frío, melancólico, \n"
                        + "pero son afectuosos.");
                break;
            case "acuario": case"Acuario":
                System.out.println("20 de enero a 18 de febrero");
                System.out.println("Sinceros, altruistas, simpáticos y activos, pero pasan \n"
                        + " por momentos de gran nerviosismo y tensión, vanidosos, \n"
                        + "muy creativos, agradables. ");
                break;
            case "piscis": case "Picis":
                System.out.println("19 de febrero a 20 de marzo");
                System.out.println("Sutiles, dulces, tolerantes, imprevisibles, \n"
                        + "románticos pero quisquillosos e incluso infieles. \n"
                        + "Creen en la amistad y el amor. \n");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
         }
        System.out.println("quieres contuinar ingresado datos (S/N) ");
        confirmacion= entrada.next();
        } 
        while (confirmacion.equals("S"));
        
        
     }

}
