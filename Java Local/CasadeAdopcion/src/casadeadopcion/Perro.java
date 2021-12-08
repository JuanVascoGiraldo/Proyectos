
package casadeadopcion;

public class Perro extends Mascota{
    protected String Esterelizado;
    protected String Raza;
    protected String Rescatado;
    protected String Agresivo;
    protected String Amoroso;
    
    public Perro(String unNombre,  String unGenero, boolean unaDiscapacidad,
             int unaEdad,boolean esEsterelizado, String unaRaza,boolean esRescatado,
             boolean esAgresivo, boolean esAmoroso){
    super(unNombre, unGenero, unaDiscapacidad, unaEdad);
     Esterelizado = String.valueOf(esEsterelizado);
     Raza= unaRaza;
     Rescatado= String.valueOf(esRescatado);
     Agresivo= String.valueOf(esAgresivo);
     Amoroso= String.valueOf(esAmoroso);
    }
    
     public String getEsterelizado(){
    return Esterelizado;
    }
    public void setEsterelizado(String esEsterelizado){
    Esterelizado= esEsterelizado;
    }
    
    public String getRaza(){
    return Raza;
    }
    public void setRaza(String unaRaza){
    Raza= unaRaza;
    }
    
    public String getRescatado(){
    return Rescatado;}
    
    public void setRescatado(String esRescatado){
    Rescatado= esRescatado;
    }
    public String getAgresivo(){
    return Agresivo;}
    
    public void setAgresivo(String esAgresivo){
    Agresivo= esAgresivo;
    }
    public String getAmoroso(){
    return Amoroso;}
    
    public void setAmoroso(String esAmoroso){
    Amoroso= esAmoroso;
    }
    public String ladrar(){
    return Nombre +" -guau";
    }
    public String Jugar(){
    return Nombre + " -jugando";
    }
}
