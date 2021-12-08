
package adae;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    String Nombre="", Contraseña="", Actividad="", Unidad="";

    public Usuario(String unNombre, String unaContraseña,String unaActividad, String unaUnidad) {
        Nombre= unNombre;
        Contraseña= unaContraseña;
        Actividad=unaActividad;
        Unidad=unaUnidad;
    }
    
    public Usuario() {
    }

    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }
    
    
}
