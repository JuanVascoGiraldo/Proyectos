
package Control;

import Modelo.Dietas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccionesDieta {
    
     public static boolean yagregado(String nombre, Connection con, int id){
        boolean confirmar= true;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            String p = "SELECT nom_die as nombre, id_die AS id FROM dieta";
            ps = con.prepareStatement(p);
            rs = ps.executeQuery();
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
        }finally{
            try{
                ps.close();
                rs.close();}
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return confirmar;
    }
    
    public static int Agregardieta(Dietas d){
        int estatus = 0;
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            // ver si ya se agrego la dieta con el nombre
            boolean confirmar= yagregado(d.getNombre(), con, 0);
            if(confirmar == true){
                String q = "insert into dieta (nom_die, id_cd , des_die , activa) "
                        + "values(?,?,?,?)";
                ps = con.prepareStatement(q);
                ps.setString(1, d.getNombre());
                ps.setInt(2, d.getClasificacion());
                ps.setString(3, d.getDescripcion());
                ps.setInt(4,1);
                estatus = ps.executeUpdate();
                String b = "select id_die from dieta where nom_die = ?";
                ps = con.prepareStatement(b);
                ps.setString(1, d.getNombre());
                rs = ps.executeQuery();
                int id_die = 0;
                while(rs.next()){
                    id_die= rs.getInt("id_die");
                    String die= "insert into EncabezadoDieta (id_die) values (?)";
                    ps = con.prepareStatement(die);
                    ps.setInt(1, id_die);
                    estatus = ps.executeUpdate();
                    break;
                }
            }
            else{
                estatus =2;
            }
        
        }catch(Exception e){
            System.out.println("Error al registrar la dieta");
            System.out.println(e.getMessage());
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
        return estatus;
    }
    
    public static int actualizardieta(Dietas d){
        int estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try{
             con = Conexion.getConnection();
             boolean confirmar= yagregado(d.getNombre(), con, d.getId());
             if(confirmar == true){
             String q = "update dieta set nom_die = ?, id_cd = ?,"
                     + "des_die  = ? "
                     + "where id_die = ?";
             ps = con.prepareStatement(q);
             ps.setString(1, d.getNombre());
             ps.setInt(2, d.getClasificacion());
             ps.setString(3, d.getDescripcion());
             ps.setInt(4, d.getId());
             estatus = ps.executeUpdate();
             }else{
             estatus =2;
             }
        }
        catch(Exception e){
             System.out.println("Error al actualizar la dieta");
             System.out.println(e.getMessage());
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
    
    public static int cambiarusodieta (int id, String accion){
        int estatus = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "update dieta set activa = ? where id_die = ?";
            ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el uso de la dieta");
        
        }catch(Exception ed){
            System.out.println("Error al cambiar el uso de la dieta");
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
    
    public static Dietas buscarDietaById(int id){
        Dietas d = new Dietas();
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from dieta "
                    + "INNER JOIN clasificacion_die ON clasificacion_die.id_cd = dieta.id_cd "
                    + "where id_die = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                d.setId(id);
                d.setNombre(rs.getString("nom_die"));
                d.setActiva(rs.getInt("activa"));
                d.setDescripcion(rs.getString("des_die"));
                d.setClasi(rs.getString("clasificacion_die.clasi_cd"));
                d.setMañana(AccionesComida.ConsultarComidasdeDieta(id,1, con));
                d.setTarde(AccionesComida.ConsultarComidasdeDieta(id,2, con));
                d.setNoche(AccionesComida.ConsultarComidasdeDieta(id,3, con));
            }
            System.out.println("Dieta Encontrado");
        }catch(Exception ed){
            System.out.println("Error al buscar la dieta en el registro");
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
        return d;
    }
    
    public static Dietas buscarDieta(int id){
        Dietas d = new Dietas();
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from dieta "
                    + "INNER JOIN clasificacion_die ON clasificacion_die.id_cd = dieta.id_cd "
                    + "where id_die = ?";
            ps = con.prepareStatement(q);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                d.setId(id);
                d.setNombre(rs.getString("nom_die"));
                d.setActiva(rs.getInt("activa"));
                d.setDescripcion(rs.getString("des_die"));
                d.setClasi(rs.getString("clasificacion_die.clasi_cd"));
            }
            System.out.println("Dieta Encontrado");
        }catch(Exception ed){
            System.out.println("Error al buscar la dieta en el registro");
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
        return d;
    }
    
    public static List<Dietas> buscarAllNombreDie(){
        List<Dietas> lista = new ArrayList<Dietas>();
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select id_die, nom_die, activa, clasificacion_die.clasi_cd from dieta "
                    + "INNER JOIN clasificacion_die ON clasificacion_die.id_cd = dieta.id_cd ";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Dietas d = new Dietas();
                d.setId(rs.getInt("id_die"));
                d.setNombre(rs.getString("nom_die"));
                d.setActiva(rs.getInt("activa"));
                d.setClasi(rs.getString("clasificacion_die.clasi_cd"));
                lista.add(d);
            }
            System.out.println("Se ha consultado todas las dietas");
        }catch(Exception ed){
            System.out.println("Error al buscar Las dietas");
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
        return lista;
    }
    
    public static int RelacionaDietaUsuario(int id_usu, int id_die){
        int estatus = 0;
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            boolean seguir = true;
            String p="select count(*) AS contar from encabezadodieta "
                    + "INNER JOIN bibliotecadedieta ON bibliotecadedieta.id_endie = encabezadodieta.id_endie "
                    + "where bibliotecadedieta.id_usu = ? and encabezadodieta.id_die = ?";
            ps= con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_die);
            rs = ps.executeQuery();
            while(rs.next()){
                    if(rs.getInt("contar") != 0){
                        seguir = false;
                        estatus = 2;
                    }
            }
            if(seguir == true){
                int encabezado = consultaridencabezado(con, id_die);
                String q= "insert into bibliotecadedieta (id_usu , id_endie)"
                        + " values (? , ?)";
                ps = con.prepareStatement(q);
                ps.setInt(1, id_usu);
                ps.setInt(2,encabezado);
                estatus = ps.executeUpdate();
            }
        }
        catch(Exception e){
            System.out.println("Error al relacionar");
            System.out.println(e.getMessage());
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
        return estatus;
    }
    
    public static int EliminarDietadeUsuario(int id_usu, int id_die){
        int estatus = 0;
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            int id_bli = -1;
            con= Conexion.getConnection();
            String p= "select bibliotecadedieta.id_bli from encabezadodieta "
                    + "INNER JOIN bibliotecadedieta ON bibliotecadedieta.id_endie = encabezadodieta.id_endie "
                    + "where bibliotecadedieta.id_usu = ? and encabezadodieta.id_die = ?";
            ps= con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_die);
            rs= ps.executeQuery();
            if(rs.next()){
                id_bli= rs.getInt("id_bli");
            }
            if(id_bli != -1){
                String q = "delete from bibliotecadedieta where id_bli = ?";
                ps= con.prepareStatement(q);
                ps.setInt(1, id_bli);
                estatus = ps.executeUpdate();
            }
        }catch(Exception e){
            System.out.println("Error al Eliminar");
            System.out.println(e.getMessage());
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
        return estatus;
    }
    
    public static int consultaridencabezado(Connection con,int id_die){
        int encabezado = 0;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            String d= "select id_endie from encabezadodieta where id_die = ?";
            ps = con.prepareStatement(d);
            ps.setInt(1, id_die);
            rs = ps.executeQuery();
            if(rs.next()){
                encabezado = rs.getInt("id_endie");
            }
        }catch(Exception e){
            System.out.println("Error al Consultar");
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
        
        return encabezado;
    }
    
    public static List<Dietas> buscardietasusuario(int id){
        List<Dietas> lista = new ArrayList<Dietas>();
        Connection con = null;
        ResultSet rs= null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String p="select dieta.nom_die, clasificacion_die.clasi_cd, dieta.id_die   from encabezadodieta "
                    + "INNER JOIN bibliotecadedieta ON bibliotecadedieta.id_endie = encabezadodieta.id_endie "
                    + "INNER JOIN dieta ON dieta.id_die = encabezadodieta.id_die "
                    + "INNER JOIN clasificacion_die ON clasificacion_die.id_cd = dieta.id_cd "
                    + "where bibliotecadedieta.id_usu = ? AND dieta.activa= ?";
            ps = con.prepareStatement(p);
            ps.setInt(1, id);
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                Dietas d = new Dietas();
                d.setId(rs.getInt("id_die"));
                d.setNombre(rs.getString("nom_die"));
                d.setClasi(rs.getString("clasi_cd"));
                lista.add(d);
            }
        }catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
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
        return lista;
    }
}
