
package Modelo;

public class Ejercicio {
    int id, clasificacion,activa, repeticiones;
    double cantidad;
    String nombre;
    // el valor si está o no está activo es por si se decide eliminar los valores posibles son
    // 0 = no esta activo
    // 1 = está activo
    
    public Ejercicio(){
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int isActiva() {
        return activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    
}
