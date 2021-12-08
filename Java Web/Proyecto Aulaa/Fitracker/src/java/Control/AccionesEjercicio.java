
package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Ejercicio;
import java.util.ArrayList;
import java.util.List;

public class AccionesEjercicio {
    
    public static boolean yagregado(String nombre, Connection con, int id){
        boolean confirmar= true;
        PreparedStatement pss = null;
        ResultSet rs = null;
        try{
            String p = "select nom_eje as nombre, id_eje as id from ejercicio";
            pss = con.prepareStatement(p);
            rs = pss.executeQuery();
            while(rs.next()){
                if(nombre.equals(rs.getString("nombre"))){
                    if(id != 0 && id != rs.getInt("id")){
                        confirmar= false;
                        break;
                    }
                    if(id == 0){
                        confirmar= false;
                        break;
                    }
                }
            }
        }catch(Exception e){
            System.out.println("error al comprobar");
            System.out.println(e.getMessage());
        }
        finally{
            try{
            pss.close();
            rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return confirmar;
    }
    
    public static int registrarEjercio(Ejercicio e){
        int estatus = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try{
            con = Conexion.getConnection();
            boolean confirmar = yagregado(e.getNombre() , con, 0);
            if(confirmar == true){
                String q = "insert into ejercicio (nom_eje, calorias_eje, id_ec , activa) "
                        + "values(?,?,?,?)";
                ps = con.prepareStatement(q);
                ps.setString(1, e.getNombre());
                ps.setDouble(2, e.getCantidad());
                ps.setInt(3, e.getClasificacion());
                ps.setInt(4, 1);
                estatus = ps.executeUpdate();
                System.out.println("Registro Exitoso del Ejercio");
            }else{
                estatus = 2;
            }
        
        }catch(Exception ed){
            System.out.println("Error al registrar al ejercicio");
            System.out.println(ed.getMessage());
        }finally{
            try{
                ps.close();
                con.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static int actualizarEjercicio(Ejercicio e){
        int estatus = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try{
            con = Conexion.getConnection();
            boolean confirmar = yagregado(e.getNombre() , con, e.getId());
            if(confirmar == true){
            String q = "update ejercicio set nom_eje = ?, calorias_eje = ?,"
                    + "id_ec = ? "
                    + "where id_eje = ?";
            
            ps = con.prepareStatement(q);
            //usar getter and setter
            ps.setString(1, e.getNombre());
            ps.setDouble(2, e.getCantidad());
            ps.setInt(3, e.getClasificacion());
            ps.setInt(4, e.getId());
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del Ejercicio");
            }else{
                estatus = 2;
            }
        
        }catch(Exception ed){
            System.out.println("Error al actualizar el Ejercicio");
            System.out.println(ed.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static int CambiarUsoEjercicio(int id, String accion){
        int estatus = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try{
            con = Conexion.getConnection();
            String q = "update ejercicio set activa = ? where id_eje = ?";
            
            ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el uso del ejercicio");
        }catch(Exception ed){
            System.out.println("Error al cambiar el uso el ejercicio");
            System.out.println(ed.getMessage());
        }finally{
            try{
                ps.close();
                con.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static Ejercicio buscarEjercicioById(int id){
        Ejercicio e = new Ejercicio();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from ejercicio "
                    + "INNER JOIN clasificacion_eje ON clasificacion_eje.id_ec = ejercicio.id_ec "
                    + "where ejercicio.id_eje = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt("id_eje"));
                e.setNombre(rs.getString("nom_eje"));
                e.setCantidad(rs.getDouble("Calorias_eje"));
                e.setClasi(rs.getString("clasi_ec"));
                e.setActiva(rs.getInt("activa"));
            }
            System.out.println("Ejercicio Encontrado");
        }catch(Exception ed){
            System.out.println("Error al buscar el Ejercicio en el registro");
            System.out.println(ed.getMessage());
        }finally{
            try{
                ps.close();
                con.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return e;
    }
    
    public static List<Ejercicio> buscarAllEjercicio(){
        List<Ejercicio> lista = new ArrayList<Ejercicio>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from ejercicio "
                    + "INNER JOIN clasificacion_eje ON clasificacion_eje.id_ec = ejercicio.id_ec ";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Ejercicio e = new Ejercicio();
                e.setId(rs.getInt("id_eje"));
                e.setNombre(rs.getString("nom_eje"));
                e.setCantidad(rs.getDouble("Calorias_eje"));
                e.setClasi(rs.getString("clasi_ec"));
                e.setActiva(rs.getInt("activa"));
                lista.add(e);
            }
            System.out.println("Se ha consultado todos los ejercicios");
        }catch(Exception ed){
            System.out.println("Error al buscar Los Ejercicios");
            System.out.println(ed.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return lista;
    }
    
    public static int RelacionarEjercioUsuario(int id_usu, int id_eje, int repeticiones){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        int estatus = 0;
        try{
            con = Conexion.getConnection();
            String q = "select count(*) as contar from ejerciciousuario where id_usu = ? and id_eje = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_eje);
            rs = ps.executeQuery();
            boolean seguir = true;
            while(rs.next()){
                if(rs.getInt("contar") == 1){
                    seguir = false;
                }
            }
            if(seguir == true){
                String registrar= "insert into ejerciciousuario (id_usu, id_eje, repeticiones_eje) "
                        + "values(?,?,?)";
                ps= con.prepareStatement(registrar);
                ps.setInt(1, id_usu);
                ps.setInt(2, id_eje);
                ps.setInt(3, repeticiones);
                estatus = ps.executeUpdate();
            }else{
                estatus = ModificarRelacionUsuarioEjercicio(id_usu, id_eje, repeticiones, -1,  con);
            
            }
        }catch(Exception e){
            System.out.println("Error al Relacionar");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static int ModificarRelacionUsuarioEjercicio(int id_usu, int id_eje, int repeticiones, int ejeusu){
        int estatus = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try{
            con = Conexion.getConnection();
            // si el ejeusu es negativo es porque no se cuenta con el id y se debe consultar a la base de datos
            if(ejeusu == -1){
                ejeusu = ObteneridEjercicioUsuario( id_usu , id_eje, con);
            }
            //si el eje usu no es negativo significa que si lo tiene
            if(ejeusu != -1){
                String p= "UPDATE ejerciciousuario set repeticiones_eje = ? where id_ejeusu = ?";
                ps = con.prepareStatement(p);
                ps.setInt(1, repeticiones);
                ps.setInt(2, ejeusu);
                estatus = ps.executeUpdate();
            }
            System.out.println("Se ha modificado");
        }
        catch(Exception e){
            System.out.println("Error al Modificar");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static int ModificarRelacionUsuarioEjercicio(int id_usu, int id_eje, int repeticiones, int ejeusu, Connection con){
        int estatus = 0;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            // si el ejeusu es negativo es porque no se cuenta con el id y se debe consultar a la base de datos
            if(ejeusu == -1){
                ejeusu = ObteneridEjercicioUsuario( id_usu , id_eje, con);
            }
            //si el eje usu no es negativo significa que si lo tiene
            if(ejeusu != -1){
                String p= "UPDATE ejerciciousuario set repeticiones_eje = ? where id_ejeusu = ?";
                ps = con.prepareStatement(p);
                ps.setInt(1, repeticiones);
                ps.setInt(2, ejeusu);
                estatus = ps.executeUpdate();
            }
            System.out.println("Se ha modificado");
        }
        catch(Exception e){
            System.out.println("Error al Modificar");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                ps.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static List<Ejercicio> EjerciciosdeUsuario(int id_usu){ //consultar todos los ejercicios que el usuario tiene relacionado
        List<Ejercicio> lista = new ArrayList<Ejercicio>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            /*Se hacen un INNER JOIN con la tabla ejerciciousuario y 
            la tabla de ejercicios para obtener los que se relacionan*/
            String p = "SELECT ejercicio.id_eje, ejercicio.nom_eje, ejercicio.id_ec, clasificacion_eje.clasi_ec, ejerciciousuario.repeticiones_eje "
                    + "FROM ejerciciousuario "
                    + "INNER JOIN ejercicio ON ejercicio.id_eje = ejerciciousuario.id_eje "
                    + "INNER JOIN clasificacion_eje ON clasificacion_eje.id_ec = ejercicio.id_ec "
                    + "where ejerciciousuario.id_usu = ? AND ejercicio.activa = ?";
            ps = con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, 1);
            rs= ps.executeQuery();
            while(rs.next()){
                Ejercicio e = new Ejercicio();
                e.setId(rs.getInt("id_eje"));
                e.setClasificacion(rs.getInt("id_ec"));
                e.setClasi(rs.getString("clasi_ec"));
                e.setNombre(rs.getString("nom_eje"));
                e.setRepeticiones(rs.getInt("repeticiones_eje"));
                lista.add(e);
            }
            System.out.println("Consulta Exitosa");
        }
        catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return lista;
    }
    
    public static Ejercicio ObtenerEjercioUsuarioByid(int id_eje, int id_usu){
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        Ejercicio e = new Ejercicio();
        try{
            con = Conexion.getConnection();
            String p = "SELECT ejercicio.id_eje, ejercicio.nom_eje, ejerciciousuario.repeticiones_eje "
                    + "FROM ejerciciousuario "
                    + "INNER JOIN ejercicio ON ejercicio.id_eje = ejerciciousuario.id_eje "
                    + "where ejerciciousuario.id_usu = ? AND ejercicio.id_eje = ?";
            ps = con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_eje);
            rs= ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt("id_eje"));
                e.setNombre(rs.getString("nom_eje"));
                e.setRepeticiones(rs.getInt("repeticiones_eje"));
            }
            System.out.println("Consulta Exitosa");
        }
        catch(Exception ed){
            System.out.println("Error al consultar");
            System.out.println(ed.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return e;
    }
    
    //hacer metodo para obtener el identificador de los ejericicos que coincidan 
    public static int ObteneridEjercicioUsuario(int id_usu , int id_eje, Connection con){
        int respuesta= -1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String q= "SELECT id_ejeusu from ejerciciousuario where id_usu = ? AND id_eje = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_eje);
            rs= ps.executeQuery();
            if(rs.next()){
                respuesta= rs.getInt("id_ejeusu");
            }
        }
        catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }
        finally{
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
    
    public static int eliminarEjerciciodeUsuario(int id_usu, int id_eje){
        int estatus=0;
        PreparedStatement ps = null;
        Connection con = null;
        try{
            con = Conexion.getConnection();
            String q = "delete from ejerciciousuario where id_usu = ? and id_eje = ?";
            ps= con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_eje);
            estatus = ps.executeUpdate();
        }
        catch(Exception ed){
            System.out.println("Error al Eliminar");
            System.out.println(ed.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
    public static List<Ejercicio> EjerciciosActivos(){
        List<Ejercicio> lista = new ArrayList<Ejercicio>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String q = "select ejercicio.nom_eje, ejercicio.calorias_eje, clasificacion_eje.clasi_ec, "
                    + "ejercicio.id_eje, ejercicio.id_ec from ejercicio "
                    + "INNER JOIN clasificacion_eje ON clasificacion_eje.id_ec = ejercicio.id_ec "
                    + "where activa = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                Ejercicio e = new Ejercicio();
                e.setId(rs.getInt("id_eje"));
                e.setClasificacion(rs.getInt("id_ec"));
                e.setNombre(rs.getString("nom_eje"));
                e.setCantidad(rs.getDouble("Calorias_eje"));
                e.setClasi(rs.getString("clasi_ec"));
                lista.add(e);
            }
        }
        catch(Exception ed){
            System.out.println("Error al buscar Los Ejercicios");
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
        return lista;
    }
    
    public static double CalcularCaloriaseje(Ejercicio e, Connection con){
        double respuesta = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String q="Select calorias_eje from ejercicio where id_eje = ?";
            ps= con.prepareStatement(q);
            ps.setInt(1, e.getId());
            rs= ps.executeQuery();
            if(rs.next()){
                respuesta = (e.getRepeticiones())* (rs.getDouble("calorias_eje"));
            }
        }
        catch(Exception ed){
            System.out.println("Error al hacer el calculo");
            System.out.println(ed.getMessage());
        }
        finally{
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
    
    public static int confirmarrutina(int id_usu,List<Ejercicio> lista, String fecha){
        int estatus = 0;
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try{
            double total = 0;
            con= Conexion.getConnection();
            //buscar si el dia de hoy ya habia registro una rutina el dia
            //para que solo agregue una rutina por dia
            String q= "select dia from CantidadCaloria where id_usu = ? and dia = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id_usu);
            ps.setString(2, fecha);
            rs = ps.executeQuery();
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
        }
        catch(Exception e){
            System.out.println("Error al hacer el registro de la rutina");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                ps.close();
                con.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estatus;
    }
    
}
