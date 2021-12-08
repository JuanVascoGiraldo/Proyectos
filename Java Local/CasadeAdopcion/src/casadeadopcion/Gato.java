
package casadeadopcion;

public class Gato extends Mascota{
    
    protected String Pelaje;
    protected String Raza;
    protected String Rescatado;
    protected String Callejero;
    protected String Esterelizado;
    public Gato(String unNombre,  String unGenero, boolean unaDiscapacidad,
             int unaEdad,boolean esEsterelizado, String unPelaje, String unaRaza, 
            boolean esRescatado, boolean esCallejero){
    super(unNombre, unGenero, unaDiscapacidad, unaEdad);
     Esterelizado = String.valueOf(esEsterelizado);
     Pelaje= unPelaje;
     Raza= unaRaza;
     Rescatado= String.valueOf(esRescatado);
     Callejero= String.valueOf(esCallejero);
    }
      
    public String getEsterelizado(){
    return Esterelizado;
    }
    public void setEsterelizado(String esEsterelizado){
    Esterelizado= esEsterelizado;
    }
    public String getPelaje(){
    return Pelaje;
    }
    public void setPelaje(String unPelaje){
    Pelaje= unPelaje;
    }
    
    public String getRaza(){
    return Raza;
    }
    public void setRaza(String unaRaza){
    Raza= unaRaza;
    }
    
    public String getRescatado(){
    return Rescatado;
    }
    public void setRescatado(String esRescatado){
    Rescatado= esRescatado;
    }
    
    public String getCallejero(){
    return Callejero;
    }
    public void setCallejero(String esCallejero){
    Callejero= esCallejero;
    }
    
    public String maullar(){
    return Nombre +" -miau";
    }
    public String ronronear(){
    return Nombre +" -rrrrrrr";
    }
    public String arañar(){
    return Nombre +" -arañando";
    }
    public String cazar(){
    return Nombre + " -cazando";
    }
}
