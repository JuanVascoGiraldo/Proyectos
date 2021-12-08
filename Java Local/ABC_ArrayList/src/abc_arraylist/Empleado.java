/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc_arraylist;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
public class Empleado implements Serializable  {
    private int idEmpleado;
    private String nombre;
    private String correo;


    public Empleado(int idEmpleado, String nombre, String correo){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.correo = correo;
    }
    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
    @Override
    public String toString(){
        return "[idEmpleado:"+getIdEmpleado()
                +", Nombre:"+getNombre()
                +", Correo:"+getCorreo()
                +"]";
           
    }


   
    
}
