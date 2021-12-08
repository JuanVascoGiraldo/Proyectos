
package casadeadopcion;

 public abstract class Mascota {
    protected String Nombre;
    protected String Genero;
    protected String Discapacidad;
    protected int Edad;
    public Mascota(String unNombre, String unGenero, boolean unaDiscapacidad, int unaEdad){
    Nombre= unNombre;
    Genero= unGenero;
    Discapacidad= String.valueOf(unaDiscapacidad);
    Edad= unaEdad;
    }      
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String unNombre){
        Nombre= unNombre;
    }
    public String getGenero(){
        return Genero;
    }
    public void setGenero(String unGenero){
        Genero= unGenero;
    }
    public String getDiscapacidad(){
        return Discapacidad;
    }
    public void setDiscapacidad(String unaDiscapacidad){
        Discapacidad= unaDiscapacidad;
    }
    public int getEdad(){
        return Edad;
    }
    public void setEdad(int unaEdad){
        Edad= unaEdad;
    }
    public String amar(){
        return Nombre +"amando";
    }
    public String dormir(){
        return Nombre +"dormir";
    }
    public String comer(){
        return Nombre +"comiendo";
    }
}
