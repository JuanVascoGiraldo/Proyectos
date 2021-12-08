
package adae;

import java.io.Serializable;


public class Actividad implements Serializable{
    String Nombre, Fecha;
    int porcentaje, parcial;
    double calificacion;
    String NombUni;
    

    public Actividad(String NombUni, String Nombre, String Fecha, double calificacion, int porcentaje, int parcial) {
        this.NombUni=NombUni;
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.calificacion = calificacion;
        this.porcentaje = porcentaje;
        this.parcial=parcial;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public String getNombUni() {
        return NombUni;
    }

    public void setNombUni(String NombUni) {
        this.NombUni = NombUni;
    }

    public int getParcial() {
        return parcial;
    }

    public void setParcial(int parcial) {
        this.parcial = parcial;
    }
    
    
}
