
package Modelo;

import java.math.BigInteger;

public class MReporte {
    int id, id_usu, id_maquina;
    Long boleta;
    String fecha_re, hora_re, fecha_so, hora_so, nom_usu, reporte, solucion;

    public MReporte() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Long getBoleta() {
        return boleta;
    }

    public void setBoleta(Long boleta) {
        this.boleta = boleta;
    }

    public String getFecha_re() {
        return fecha_re;
    }

    public void setFecha_re(String fecha_re) {
        this.fecha_re = fecha_re;
    }

    public String getHora_re() {
        return hora_re;
    }

    public void setHora_re(String hora_re) {
        this.hora_re = hora_re;
    }

    public String getFecha_so() {
        return fecha_so;
    }

    public void setFecha_so(String fecha_so) {
        this.fecha_so = fecha_so;
    }

    public String getHora_so() {
        return hora_so;
    }

    public void setHora_so(String hora_so) {
        this.hora_so = hora_so;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
    
    
}
