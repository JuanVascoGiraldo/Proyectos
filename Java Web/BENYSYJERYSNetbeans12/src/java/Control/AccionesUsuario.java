package Control;
import Modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AccionesUsuario {
    
    public static int registrarUsuario(Usuario u){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            boolean confirmar = true;
            
            String p = "select email_usu as correo from usuarios";
            PreparedStatement pss = con.prepareStatement(p);
            ResultSet rs = pss.executeQuery();
            
            while(rs.next()){
                if(u.getEmail().equals(rs.getString("correo"))){
                    confirmar= false;
                }
            }
            
            if(confirmar == true){
                String q = "insert into usuarios(nom_usu, appat_usu, apmat_usu, fecha_usu, domicilio_usu,"
                        + " telpar_usu, telcel_usu, email_usu, contra_usu, permiso_usu) "
                        + "values(?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, u.getNombre());
                ps.setString(2, u.getAppat());
                ps.setString(3, u.getApmat());
                ps.setDate(4, (Date)u.getFecha());
                ps.setString(5, u.getDomicilio());
                ps.setInt(6, u.getTelparticular());
                ps.setInt(7, u.getTelcel());
                ps.setString(8, u.getEmail());
                ps.setString(9, u.getContra());
                ps.setInt(10, u.getPermiso());
                estatus = ps.executeUpdate();
                System.out.println("Registro Exitoso del Usuario");   
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
            String q = "update usuarios set nom_usu = ?, appat_usu = ?,"
                    + "apmat_usu = ?, fecha_usu = ?, domicilio_usu = ?,"
                    + "telpar_usu = ?, telcel_usu = ?, email_usu = ?, contra_usu = ? "
                    + "where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getAppat());
            ps.setString(3, u.getApmat());
            ps.setDate(4, (Date)u.getFecha());
            ps.setString(5, u.getDomicilio());
            ps.setInt(6, u.getTelparticular());
            ps.setInt(7, u.getTelcel());
            ps.setString(8, u.getEmail());
            ps.setString(9, u.getContra());
            ps.setInt(10, u.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del Usuario");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    
    public static int borrarUsuario(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from usuarios where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, id);
            
            
            estatus = ps.executeUpdate();
            System.out.println("Borrado Exitoso del Usuario");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al borrar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    
    public static Usuario buscarUsuarioById(int id){
        Usuario u = new Usuario();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from usuarios where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setAppat(rs.getString(3));
                u.setApmat(rs.getString(4));
                u.setFecha(rs.getDate(5));
                u.setDomicilio(rs.getString(6));
                u.setTelparticular(rs.getInt(7));
                u.setTelcel(rs.getInt(8));
                u.setEmail(rs.getString(9));
                u.setContra(rs.getString(10));
            }
            
            System.out.println("Usuario encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar al usuario");
            System.out.println(ed.getMessage());
        
        }
        return u;
    }
    
    public static List<Usuario> buscarAllUsuarios(){
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from usuarios";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setAppat(rs.getString(3));
                u.setApmat(rs.getString(4));
                u.setEmail(rs.getString(9));
                u.setFecha(rs.getDate(5));
                u.setDomicilio(rs.getString(6));
                u.setTelparticular(rs.getInt(7));
                u.setTelcel(rs.getInt(8));
                u.setEmail(rs.getString(9));
                u.setContra(rs.getString(10));
                lista.add(u);
            }
            
            System.out.println("Usuarios encontrados");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar a los usuarios");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
    
    public static List<Integer> iniciarsesion(String correo, String contraseña){
        List<Integer> respuesta = new ArrayList<Integer>();
        int id;
        int confirmar=0;
        try{
            Connection con = Conexion.getConnection();
            String q = "select contra_usu as contraseñas, id_usu as identificador from usuarios where email_usu = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(contraseña.equals(rs.getString("contraseñas"))){
                    confirmar = 1;
                    id = rs.getInt("identificador");
                    respuesta.add(id);
                    confirmar=1;
                }
            }
            respuesta.add(confirmar);
        }catch(Exception e){
            System.out.println("No se ha podido verificar al usuario");
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
}
