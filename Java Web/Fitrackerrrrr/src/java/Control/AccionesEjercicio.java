
package Control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Ejercicio;
import java.util.ArrayList;
import java.util.List;

public class AccionesEjercicio {
    
    public static int registrarEjercio(Ejercicio e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            boolean confirmar = true;
            
            String p = "select nom_eje as nombre from ejercicio";
            PreparedStatement pss = con.prepareStatement(p);
            ResultSet rs = pss.executeQuery();
            
            while(rs.next()){
                if(e.getNombre().equals(rs.getString("nombre"))){
                    confirmar= false;
                }
            }
            
            if(confirmar == true){
                String q = "insert into ejercicio (nom_eje, Calorias_eje, id_EC , activa) "
                        + "values(?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, e.getNombre());
                ps.setDouble(2, e.getCantidad());
                ps.setInt(3, e.getClasificacion());
                ps.setBoolean(4, true);
                estatus = ps.executeUpdate();
                System.out.println("Registro Exitoso del Ejercio");   
            }
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar al ejercicio");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    public static int actualizarEjercicio(Ejercicio e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update ejercicio set nom_eje = ?, Calorias_eje = ?,"
                    + "id_EC = ? "
                    + "where id_eje = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getNombre());
            ps.setDouble(2, e.getCantidad());
            ps.setInt(3, e.getClasificacion());
            ps.setInt(4, e.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del Ejercicio");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar el Ejercicio");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static int CambiarUsoEjercicio(int id, String accion){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update ejercicio set activa = ? where id_eje = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setBoolean(1, false);
            }
            else{
                ps.setBoolean(1, true);
            }
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el uso del ejercicio");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al cambiar el uso el ejercicio");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static Ejercicio buscarEjercicioById(int id){
        Ejercicio e = new Ejercicio();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from ejercicio where id_eje = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt("id_eje"));
                e.setNombre(rs.getString("nom_eje"));
                e.setCantidad(rs.getDouble("Calorias_eje"));
                e.setClasificacion(rs.getInt("id_EC"));
                e.setActiva(rs.getBoolean("activa"));
            }
            
            System.out.println("Ejercicio Encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar el Ejercicio en el registro");
            System.out.println(ed.getMessage());
        
        }
        return e;
    }
   
    public static List<Ejercicio> buscarAllEjercicio(){
        List<Ejercicio> lista = new ArrayList<Ejercicio>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from ejercicio";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ejercicio e = new Ejercicio();
                e.setId(rs.getInt("id_eje"));
                e.setNombre(rs.getString("nom_eje"));
                e.setCantidad(rs.getDouble("Calorias_eje"));
                e.setClasificacion(rs.getInt("id_EC"));
                e.setActiva(rs.getBoolean("activa"));
                lista.add(e);
            }
            
            System.out.println("Se ha consultado todos los ejercicios");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar Los Ejercicios");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
