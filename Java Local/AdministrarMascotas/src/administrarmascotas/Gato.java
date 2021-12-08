
package administrarmascotas;

import java.io.Serializable;

public class Gato implements Serializable{
    public String nombre;
    public String edad;
    public String genero;
    public String discapacidad;
    public String rescatado;
    public String id;
     // hecho por vasco giraldo juan esteban
     // hecho por vasco giraldo juan esteban
    public Gato(String nombre, String edad, String genero, String discapacidad, String rescatado, String id) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.discapacidad = discapacidad;
        this.rescatado = rescatado;
        this.id = id;
    }

    
    

    public void setNombre(String unnombre) {
        nombre = unnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String unaedad) {
        edad = unaedad;
    }
    
    public String getGenero() {
        return genero;
    }
    public void setGenero(String ungenero) {
        genero = ungenero;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setRescatado(String rescatado) {
        this.rescatado = rescatado;
    }

    public String getRescatado() {
        return rescatado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
