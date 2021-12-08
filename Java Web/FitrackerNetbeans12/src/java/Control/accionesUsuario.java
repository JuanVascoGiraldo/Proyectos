
package Control;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class accionesUsuario {
    
    public static List<Integer> yagregado(Usuario u, Connection con){
        int confirmar= 1;
        int estatus= 0;
        List<Integer> respuesta = new ArrayList<Integer>();
        try{
            String p = "select email_usu as correo, id_usu as usuario, activa from usuarios";
            PreparedStatement pss = con.prepareStatement(p);
            ResultSet rs = pss.executeQuery();
            while(rs.next()){
                if(u.getEmail().equals(rs.getString("correo")) && 0 == rs.getInt("activa")){
                    //si el correo ya habia sido registra y esra inictiva la cuenta
                    u.setId(rs.getInt("usuario"));
                    estatus = actualizarUsuario(u);
                    estatus = CambiarUsoUsuario( rs.getInt("usuario") , "activar");
                    confirmar= 0;
                    break;
                }
            }
            respuesta.add(confirmar);
            respuesta.add(estatus);
            pss.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println("error al comprobar");
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public static int registrarUsuario(Usuario u){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            List<Integer> respuesta = yagregado(u, con);
            int confirmar = respuesta.get(0);
            estatus = respuesta.get(1);
            if(confirmar == 1){
                String q = "insert into usuarios(nom_usu, email_usu, contra_usu, permisos_usu, activa) "
                        + "values(?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, u.getUsuario());
                ps.setString(2, u.getEmail());
                ps.setString(3, u.getContraseña());
                ps.setInt(4, u.isPermiso());
                ps.setInt(5, 1);
                estatus = ps.executeUpdate();
                System.out.println("Registro Exitoso del Usuario");  
                ps.close();
            }
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static int actualizarUsuario(Usuario u){
        int estatus = 0;
        try{
            
            Connection con = Conexion.getConnection();
            List<Integer> respuesta = yagregado(u, con);
            int confirmar = respuesta.get(0);
            estatus = respuesta.get(1);
            if(confirmar == 1){
                String q = "update usuario set nom_usu = ?, email_usu = ?, contra_usu = ? "
                        + "where id_usu = ?";

                PreparedStatement ps = con.prepareStatement(q);

                //usar getter and setter
                ps.setString(1, u.getUsuario());
                ps.setString(2, u.getEmail());
                ps.setString(3, u.getContraseña());
                ps.setInt(4, u.getId());
                estatus = ps.executeUpdate();
                System.out.println("Actualizacion Exitosa del Usuario");
                ps.close();
            }
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static int CambiarUsoUsuario(int id, String accion){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update usuario set activa = ? where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el acceso de la cuenta");
            con.close();
            ps.close();
        }catch(Exception ed){
            System.out.println("Error al cambiar el acceso de la cuenta");
            System.out.println(ed.getMessage());
        }
        return estatus;
    }
    
    public static Usuario buscarUsuarioById(int id){
        Usuario u = new Usuario();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from usuario where id_usu = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt("id_usu"));
                u.setUsuario(rs.getString("nom_usu"));
                u.setEmail(rs.getString("email_usu"));
                u.setContraseña(rs.getString("contra_usu"));
            }
            System.out.println("Usuario encontrado");
            con.close();
            rs.close();
            ps.close();
        }catch(Exception ed){
            System.out.println("Error al buscar al usuario");
            System.out.println(ed.getMessage());
        }
        return u;
    }
    
    public static List<Integer> iniciarsesion(String correo, String contraseña){
        List<Integer> respuesta = new ArrayList<Integer>();
        int permiso = 1;
        int id = 0;
        int confirmar=0;
        try{
            Connection con = Conexion.getConnection();
            String q = "select contra_usu as contraseñas, id_usu as identificador, permisos_usu from usuarios where email_usu = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(contraseña.equals(rs.getString("contraseñas"))){
                    confirmar = 1;
                    id = rs.getInt("identificador");
                    permiso = rs.getInt("permisos");
                    break;
                }
            }
            respuesta.add(confirmar);
            respuesta.add(permiso);
            respuesta.add(id);
            con.close();
            rs.close();
            ps.close();
        }catch(Exception e){
            System.out.println("No se ha podido verificar al usuario");
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}
