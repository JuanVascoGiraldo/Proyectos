package Modelo;
import java.util.List;
import java.util.ArrayList;

public class Dietas {
    public int id;
    public int clasificacion;
    public String nombre;
    public String descripcion;
    public int activa;
    public List<Comidas> mañana = new ArrayList<Comidas>();
    public List<Comidas> tarde = new ArrayList<Comidas>();
    public List<Comidas> noche = new ArrayList<Comidas>();
    
    public Dietas(){
        
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int isActiva() {
        return activa;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    public List<Comidas> getMañana() {
        return mañana;
    }

    public void setMañana(List<Comidas> mañana) {
        this.mañana = mañana;
    }

    public List<Comidas> getTarde() {
        return tarde;
    }

    public void setTarde(List<Comidas> tarde) {
        this.tarde = tarde;
    }

    public List<Comidas> getNoche() {
        return noche;
    }

    public void setNoche(List<Comidas> noche) {
        this.noche = noche;
    }
}
