
package Control;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class accionesUsuario {
    
    public static List<Integer> yagregado(Usuario u, Connection con, int id){
        int confirmar= 1;
        int estatus= 0;
        List<Integer> respuesta = new ArrayList<Integer>();
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            String p = "select email_usu as correo, id_usu as usuario, activa from usuario";
            ps = con.prepareStatement(p);
            rs = ps.executeQuery();
            while(rs.next()){
                if(u.getEmail().equals(rs.getString("correo")) && 0 == rs.getInt("activa")){
                    //si el correo ya habia sido registra y esra inictiva la cuenta
                    u.setId(rs.getInt("usuario"));
                    estatus = CambiarUsoUsuario( rs.getInt("usuario") , "activar");
                    estatus = actualizarUsuario(u);
                    confirmar= 0;
                    break;
                }
                if(u.getEmail().equals(rs.getString("correo")) && 1 == rs.getInt("activa") && id != rs.getInt("usuario") && id!=0){
                    confirmar= 0;
                    estatus =1;
                    break;
                }
                if(u.getEmail().equals(rs.getString("correo")) && 1 == rs.getInt("activa") && id == 0){
                    confirmar= 0;
                    estatus =1;
                    break;
                }
                
            }
            respuesta.add(confirmar);
            respuesta.add(estatus);
        }
        catch(Exception e){
            System.out.println("error al comprobar");
            System.out.println(e.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return respuesta;
    }
    
    public static int registrarUsuario(Usuario u){
        int estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            List<Integer> respuesta = yagregado(u, con, 0);
            int confirmar = respuesta.get(0);
            estatus = respuesta.get(1);
            if(confirmar == 1){
                String q = "insert into usuario(nom_usu, email_usu, contra_usu, permisos_usu, activa) "
                        + "values(?,?,?,?,?)";

                ps = con.prepareStatement(q);
                ps.setString(1, u.getUsuario());
                ps.setString(2, u.getEmail());
                ps.setString(3, u.getContrasena());
                ps.setInt(4, u.isPermiso());
                ps.setInt(5, 1);
                estatus = ps.executeUpdate();
                System.out.println("Registro Exitoso del Usuario");  
            }
        }catch(Exception ed){
            System.out.println("Error al registrar al usuario");
            System.out.println(ed.getMessage());
        }
        finally{
            try{
            con.close();
            ps.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static int actualizarUsuario(Usuario u){
        int estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            List<Integer> respuesta = yagregado(u, con, u.getId());
            int confirmar = respuesta.get(0);
            estatus = respuesta.get(1);
            if(confirmar == 1){
                String q = "update usuario set nom_usu = ?, email_usu = ?, contra_usu = ? "
                        + "where id_usu = ?";

                ps = con.prepareStatement(q);
                //usar getter and setter
                ps.setString(1, u.getUsuario());
                ps.setString(2, u.getEmail());
                ps.setString(3, u.getContrasena());
                ps.setInt(4, u.getId());
                estatus = ps.executeUpdate();
                System.out.println("Actualizacion Exitosa del Usuario");
            }
        }catch(Exception ed){
            System.out.println("Error al actualizar al usuario");
            System.out.println(ed.getMessage());
        }finally{
            try{
            con.close();
            ps.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static int CambiarUsoUsuario(int id, String accion){
        int estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "update usuario set activa = ? where id_usu = ?";
            ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el acceso de la cuenta");
        }catch(Exception ed){
            System.out.println("Error al cambiar el acceso de la cuenta");
            System.out.println(ed.getMessage());
        }finally{
            try{
            con.close();
            ps.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static Usuario buscarUsuarioById(int id){
        Usuario u = new Usuario();
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from usuario where id_usu = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id_usu"));
                u.setUsuario(rs.getString("nom_usu"));
                u.setEmail(rs.getString("email_usu"));
                u.setContrasena(rs.getString("contra_usu"));
            }
            System.out.println("Usuario encontrado");
        }catch(Exception ed){
            System.out.println("Error al buscar al usuario");
            System.out.println(ed.getMessage());
        }finally{
            try{
            con.close();
            ps.close();
            rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return u;
    }
    
    public static List<Integer> iniciarsesion(String correo, String contrasena){
        List<Integer> respuesta = new ArrayList<Integer>();
        int permiso = 1;
        int id = 0;
        int confirmar=0;
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select contra_usu, id_usu, permisos_usu from usuario where email_usu = ? and activa = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, correo);
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                if(contrasena.equals(rs.getString("contra_usu"))){
                    confirmar = 1;
                    id = rs.getInt("id_usu");
                    permiso = rs.getInt("permisos_usu");
                    break;
                }
            }
            respuesta.add(confirmar);
            respuesta.add(permiso);
            respuesta.add(id);
        }catch(Exception e){
            System.out.println("No se ha podido verificar al usuario");
            System.out.println(e);
        }finally{
            try{
            con.close();
            ps.close();
            rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return respuesta;
    }
    
    public static boolean RutinaConfirmada(int id, String Fecha){
        boolean respuesta = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from cantidadcaloria where id_usu = ? AND dia = ? ";
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.setString(2, Fecha);
            rs = ps.executeQuery();
            if(rs.next()){
                respuesta = true;
            }
        }catch(Exception e){
            System.out.println("Ha ocurrido un error al verificar");
            System.out.println(e.getMessage());
        }finally{
            try{
            con.close();
            ps.close();
            rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return respuesta;
    }
}
