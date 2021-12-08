
package adae;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    String Nombre="", Contraseña="";

    public Usuario(String unNombre, String unaContraseña) {
        Nombre= unNombre;
        Contraseña= unaContraseña;
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
    
    
}
