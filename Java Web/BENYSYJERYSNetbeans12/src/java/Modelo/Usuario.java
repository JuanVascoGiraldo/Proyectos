package Modelo;

import java.util.Date;

public class Usuario {
    public int id, telparticular, telcel, permiso;
    public String nombre, appat, apmat, domicilio, email, contra;
    public Date fecha = new Date();
    
    public Usuario(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelparticular() {
        return telparticular;
    }

    public void setTelparticular(int telparticular) {
        this.telparticular = telparticular;
    }

    /**
     * @return the telcel
     */
    public int getTelcel() {
        return telcel;
    }

    /**
     * @param telcel the telcel to set
     */
    public void setTelcel(int telcel) {
        this.telcel = telcel;
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
     * @return the appat
     */
    public String getAppat() {
        return appat;
    }

    /**
     * @param appat the appat to set
     */
    public void setAppat(String appat) {
        this.appat = appat;
    }

    /**
     * @return the apmat
     */
    public String getApmat() {
        return apmat;
    }

    /**
     * @param apmat the apmat to set
     */
    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contra
     */
    public String getContra() {
        return contra;
    }

    /**
     * @param contra the contra to set
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPermiso() {
        return permiso;
    }

    public void setPermiso(int permiso) {
        this.permiso = permiso;
    }
    
    
}
