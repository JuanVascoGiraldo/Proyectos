
package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Ejercicio;
import java.util.ArrayList;
import java.util.List;

public class AccionesEjercicio {
    
    public static boolean yagregado(String nombre, Connection con){
        boolean confirmar= true;
        try{
            String p = "select nom_eje as nombre from ejercicio";
            PreparedStatement pss = con.prepareStatement(p);
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                if(nombre.equals(rs.getString("nombre"))){
                    confirmar= false;
                }
            }
            pss.close();
            rs.close();
        }catch(Exception e){
            System.out.println("error al comprobar");
            System.out.println(e.getMessage());
        }
        return confirmar;
    }
    
    public static int registrarEjercio(Ejercicio e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            boolean confirmar = yagregado(e.getNombre() , con);
            if(confirmar == true){
                String q = "insert into ejercicio (nom_eje, calorias_eje, id_ec , activa) "
                        + "values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, e.getNombre());
                ps.setDouble(2, e.getCantidad());
                ps.setInt(3, e.getClasificacion());
                ps.setInt(4, 1);
                estatus = ps.executeUpdate();
                System.out.println("Registro Exitoso del Ejercio");
                ps.close();
            }else{
                estatus = 2;
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
            boolean confirmar = yagregado(e.getNombre() , con);
            if(confirmar == true){
            String q = "update ejercicio set nom_eje = ?, calorias_eje = ?,"
                    + "id_ec = ? "
                    + "where id_eje = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, e.getNombre());
            ps.setDouble(2, e.getCantidad());
            ps.setInt(3, e.getClasificacion());
            ps.setInt(4, e.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del Ejercicio");
            ps.close();
            }else{
                estatus = 2;
            }
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
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el uso del ejercicio");
            con.close();
            ps.close();
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
                e.setActiva(rs.getInt("activa"));
            }
            System.out.println("Ejercicio Encontrado");
            con.close();
            rs.close();
            ps.close();
        }catch(Exception ed){
            System.out.println("Error al buscar el Ejercicio en el registro");
            System.out.println(ed.getMessage());
        }
        return e;
    }
    
    public static Ejercicio buscarEjercicioById(int id, Connection con){
        Ejercicio e = new Ejercicio();
        try{
            String q = "select * from ejercicio where id_eje = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt("id_eje"));
                e.setNombre(rs.getString("nom_eje"));
                e.setCantidad(rs.getDouble("Calorias_eje"));
                e.setClasificacion(rs.getInt("id_EC"));
                e.setActiva(rs.getInt("activa"));
            }
            System.out.println("Ejercicio Encontrado");
            rs.close();
            ps.close();
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
                e.setActiva(rs.getInt("activa"));
                lista.add(e);
            }
            System.out.println("Se ha consultado todos los ejercicios");
            con.close();
            rs.close();
            ps.close();
        }catch(Exception ed){
            System.out.println("Error al buscar Los Ejercicios");
            System.out.println(ed.getMessage());
        }
        return lista;
    }
    
    public static int RelacionarEjercioUsuario(int id_usu, int id_eje, int repeticiones){
    
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String registrar= "insert into ejerciciousuario (id_usu, id_eje, repeticiones_eje) "
                    + "values(?,?,?)";
            PreparedStatement regi= con.prepareStatement(registrar);
            regi.setInt(1, id_usu);
            regi.setInt(2, id_eje);
            regi.setInt(3, repeticiones);
            estatus = regi.executeUpdate();
            con.close();
            regi.close();
        }catch(Exception e){
            System.out.println("Error al Relacionar");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int ModificarRelacionUsuarioEjercicio(int id_usu, int id_eje, int repeticiones, int ejeusu){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            // si el ejeusu es negativo es porque no se cuenta con el id y se debe consultar a la base de datos
            if(ejeusu == -1){
                ejeusu = ObteneridEjercicioUsuario( id_usu , id_eje, con);
            }
            //si el eje usu no es negativo significa que si lo tiene
            if(ejeusu != -1){
                String p= "UPDATE ejerciciousuario set repeticiones_eje = ? where id_ejeusu = ?";
                PreparedStatement ps2 = con.prepareStatement(p);
                ps2.setInt(1, repeticiones);
                ps2.setInt(2, ejeusu);
                estatus = ps2.executeUpdate();
                ps2.close();
            }
            System.out.println("Se ha modificado");
            con.close();
        }
        catch(Exception e){
            System.out.println("Error al Modificar");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static List<Ejercicio> EjerciciosdeUsuario(int id_usu){ //consultar todos los ejercicios que el usuario tiene relacionado
        List<Ejercicio> lista = new ArrayList<Ejercicio>();
        try{Connection con = Conexion.getConnection();
            /*Se hacen un INNER JOIN con la tabla ejerciciousuario y 
            la tabla de ejercicios para obtener los que se relacionan*/
            String p = "SELECT ejercicio.id_eje, ejercicio.nom_eje, ejercicio.id_ec, ejerciciousuario.repeticones_eje "
                    + "FROM ejerciciousuario "
                    + "INNER JOIN ejericicio ON ejercicio.id_eje = ejerciciousuario.id_eje "
                    + "where ejerciciousuario.id_usu = ? AND ejercicio.activa = ?";
            PreparedStatement ps = con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, 1);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Ejercicio e = new Ejercicio();
                e.setId(rs.getInt("id_eje"));
                e.setClasificacion(rs.getInt("id_ec"));
                e.setNombre(rs.getString("nom_eje"));
                e.setRepeticiones(rs.getInt("repeticones_eje"));
                lista.add(e);
            }
            System.out.println("Consulta Exitosa");
            con.close();
            ps.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    //hacer metodo para obtener el identificador de los ejericicos que coincidan 
    public static int ObteneridEjercicioUsuario(int id_usu , int id_eje, Connection con){
        int respuesta= -1;
        try{
            String q= "SELECT id_ejeusu from ejerciciousuario where id_usu = ? AND id_eje = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_eje);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                respuesta= rs.getInt("id_ejeusu");
            }
            con.close();
            ps.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public static int eliminarEjerciciodeUsuario(int id_usu, int id_eje){
        int estatus=0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from ejerciciousuario where id_usu = ? and id_eje = ?";
            PreparedStatement ps= con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_eje);
            estatus = ps.executeUpdate();
            con.close();
            ps.close();
        }
        catch(Exception ed){
            System.out.println("Error al Eliminar");
            System.out.println(ed.getMessage());
        }
        return estatus;
    }
    
    public static List<Ejercicio> EjerciciosActivos(){
        List<Ejercicio> lista = new ArrayList<Ejercicio>();
        try{
            Connection con = Conexion.getConnection();
            String q = "select id_eje from ejercicio where activa = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ejercicio e = buscarEjercicioById(rs.getInt("id_eje") , con);
                lista.add(e);
            }
            con.close();
            ps.close();
            rs.close();
        }
        catch(Exception ed){
            System.out.println("Error al buscar Los Ejercicios");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
    
    public static double CalcularCaloriaseje(Ejercicio e, Connection con){
        double respuesta = 0;
        try{
            String q="Select calorias_eje from ejercicio where id_eje = ?";
            PreparedStatement ps= con.prepareStatement(q);
            ps.setInt(1, e.getId());
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                respuesta = e.getRepeticiones() * rs.getDouble("calorias_eje");
            }
            ps.close();
            rs.close();
        }
        catch(Exception ed){
            System.out.println("Error al hacer el calculo");
            System.out.println(ed.getMessage());
        }
        return respuesta;
    }
    
    public static int confirmarrutina(int id_usu,List<Ejercicio> lista, String fecha){
        int estatus = 0;
        try{
            double total = 0;
            Connection con= Conexion.getConnection();
            //buscar si el dia de hoy ya habia registro una rutina el dia
            //para que solo agregue una rutina por dia
            String q= "select dia from CantidadCaloria where id_usu = ? and dia = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setString(2, fecha);
            ResultSet rs = ps.executeQuery();
            boolean seguir = true;
            while(rs.next()){
                seguir = false;
                estatus = 2;
                break;
            }
            if(seguir == true){
                for(Ejercicio e : lista){
                total += CalcularCaloriaseje(e, con);
                }
                String p= "insert into CantidadCaloria (id_usu, cantidad, dia) "
                        + "values (?, ? ,?)";
                ps= con.prepareStatement(p);
                ps.setInt(1, id_usu);
                ps.setDouble(2, total);
                ps.setString(3, fecha);
                estatus = ps.executeUpdate();
            }
            ps.close();
            con.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println("Error al hacer el registro de la rutina");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
}
