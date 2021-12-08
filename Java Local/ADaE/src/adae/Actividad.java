
package adae;

import java.io.Serializable;


public class Actividad extends Unidad implements Serializable{
    String Nombre, Fecha;
    int porcentaje;
    double calificacion;

    public Actividad(String NombUni, String Nombre, String Fecha, double calificacion, int porcentaje) {
        super(NombUni);
        this.Nombre = Nombre;
        this.Fecha = Fecha;
        this.calificacion = calificacion;
        this.porcentaje = porcentaje;
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
    
    
    
}
