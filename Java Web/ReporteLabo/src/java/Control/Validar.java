package Control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validar {
    private static final String ExpTexto = "^[a-zA-Z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑ \\? \\¿,\\.]+$";
    private static final String ExpNombre = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑ ]+$";
    private static final String ExpBoleta ="^([0-9])*$";
    private static final String ExpContra = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
    
    public static boolean ValidarBoleta(String boleta){
        Pattern pattern = Pattern.compile(ExpBoleta);
        Matcher matcher = pattern.matcher(boleta);
        if(matcher.matches()){
           if(boleta.length() != 10){
               return false;
           }else{
               return true;
           }
        }else{
            return false;
        }
    }
    
    public static boolean ValidarNombre(String nombre){
        Pattern pattern = Pattern.compile(ExpNombre);
        Matcher matcher = pattern.matcher(nombre);
        if(matcher.matches()){
           if(nombre.length() > 80 || nombre.length()==0){
               return false;
           }else{
               return true;
           }
        }else{
            return false;
        }
    }
    
    public static boolean ValidarTexto(String texto){
        Pattern pattern = Pattern.compile(ExpTexto);
        Matcher matcher = pattern.matcher(texto);
        if(matcher.matches()){
           if(texto.length() > 200 || texto.length()<11){
               return false;
           }else{
               return true;
           }
        }else{
            return false;
        }
    }
    
    public static boolean ValidarContra(String contra){
        Pattern pattern = Pattern.compile(ExpContra);
        Matcher matcher = pattern.matcher(contra);
        if(matcher.matches()){
               return true;
        }else{
            return false;
        }
    }
    
}
