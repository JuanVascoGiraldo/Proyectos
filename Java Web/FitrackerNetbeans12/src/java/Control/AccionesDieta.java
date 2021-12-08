
package Control;

import Modelo.Dietas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccionesDieta {
    
    public static boolean yagregado(String nombre, Connection con){
        boolean confirmar= true;
        try{
            String p = "SELECT nom_die as nombre FROM dieta";
            PreparedStatement ps = con.prepareStatement(p);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(nombre.equals(rs.getString("nombre"))){
                    confirmar= false;
                    break;
                }
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            System.out.println("error al comprobar");
            System.out.println(e.getMessage());
        
        }
        return confirmar;
    }
    
    public static int Agregardieta(Dietas d){
        int estatus = 0;
        try{Connection con = Conexion.getConnection();
            // ver si ya se agrego la dieta con el nombre
            boolean confirmar= yagregado(d.getNombre(), con);
            if(confirmar == true){
                String q = "insert into dieta (nom_die, id_cd , des_die , activa) "
                        + "values(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, d.getNombre());
                ps.setInt(2, d.getClasificacion());
                ps.setString(3, d.getDescripcion());
                ps.setInt(4,1);
                estatus = ps.executeUpdate();
                
                String b = "select id_die from dieta where nom_die = ?";
                ps = con.prepareStatement(b);
                ps.setString(1, d.getNombre());
                ResultSet rs = ps.executeQuery();
                int id_die = 0;
                while(rs.next()){
                    id_die= rs.getInt("id_die");
                    String die= "insert into EncabezadoDieta (id_die) values (?)";
                    ps = con.prepareStatement(die);
                    ps.setInt(1, id_die);
                    estatus = ps.executeUpdate();
                    break;
                }
                ps.close();
                rs.close();
            }
            else{
                estatus =2;
            }
        con.close();
        
        }catch(Exception e){
            System.out.println("Error al registrar la dieta");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int actualizardieta(Dietas d){
       int estatus = 0;
       try{
            Connection con = Conexion.getConnection();
            boolean confirmar= yagregado(d.getNombre(), con);
            if(confirmar == true){
            String q = "update dieta set nom_die = ?, id_cd = ?,"
                    + "des_die  = ? "
                    + "where id_die = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, d.getNombre());
            ps.setInt(2, d.getClasificacion());
            ps.setString(3, d.getDescripcion());
            ps.setInt(4, d.getId());
            estatus = ps.executeUpdate();
            ps.close();
            }else{
            estatus =2;
            }
            con.close();
       }
       catch(Exception e){
            System.out.println("Error al actualizar la dieta");
            System.out.println(e.getMessage());
        }
       return estatus;
    }
    
    public static int cambiarusodieta (int id, String accion){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update dieta set activa = ? where id_die = ?";
            PreparedStatement ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Se cambio el uso de la dieta");
            con.close();
            ps.close();
        
        }catch(Exception ed){
            System.out.println("Error al cambiar el uso de la dieta");
            System.out.println(ed.getMessage());
        }
        return estatus;
    }
    
    public static Dietas buscarDietaById(int id){
        Dietas d = new Dietas();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from dieta where id_die = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                d.setId(id);
                d.setNombre(rs.getString("nom_die"));
                d.setActiva(rs.getInt("activa"));
                d.setDescripcion(rs.getString("des_die"));
                d.setClasificacion(rs.getInt("id_cd"));
                d.setMañana(AccionesComida.ConsultarComidasdeDieta(id,1, con));
                d.setTarde(AccionesComida.ConsultarComidasdeDieta(id,2, con));
                d.setNoche(AccionesComida.ConsultarComidasdeDieta(id,3, con));
            }
            System.out.println("Dieta Encontrado");
            con.close();
            rs.close();
            ps.close();
        }catch(Exception ed){
            System.out.println("Error al buscar la dieta en el registro");
            System.out.println(ed.getMessage());
        }
        return d;
    }
    
    public static List<Dietas> buscarAllNombreDie(){
        List<Dietas> lista = new ArrayList<Dietas>();
        try{
            Connection con = Conexion.getConnection();
            String q = "select id_die, nom_die, activa from dieta";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dietas d = new Dietas();
                d.setId(rs.getInt("id_die"));
                d.setNombre(rs.getString("nom_die"));
                d.setActiva(rs.getInt("activa"));
                lista.add(d);
            }
            System.out.println("Se ha consultado todas las dietas");
            con.close();
            rs.close();
            ps.close();
        }catch(Exception ed){
            System.out.println("Error al buscar Las dietas");
            System.out.println(ed.getMessage());
        }
        return lista;
    }
    
    public static int RelacionaDietaUsuario(int id_usu, int id_die){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            boolean seguir = true;
            String p="select count(*) from encabezadodieta "
                    + "INNE JOIN bibliotecadieta ON bibliotecadieta.id_endie = encabezadodieta.id_endie "
                    + "where bibliotecadieta.id_usu = ? and encabezadodieta.id_die = ?";
            PreparedStatement ps= con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_die);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                   seguir = false;
                   estatus = 2;
            }
            if(seguir == true){
                int encabezado = consultaridencabezado(con , id_die);
                String q= "insert into bibliotecadietas (id_usu , id_endie)"
                        + " values (? , ?)";
                ps = con.prepareStatement(q);
                ps.setInt(1, id_usu);
                ps.setInt(2,encabezado);
                estatus = ps.executeUpdate();
            }
            con.close();
            rs.close();
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error al relacionar");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int EliminarDietadeUsuario(int id_usu, int id_die){
        int estatus = 0;
        try{
            int id_bli = -1;
            Connection con= Conexion.getConnection();
            String p= "select bibliotecadieta.id_bli from encabezadodieta "
                    + "INNE JOIN bibliotecadieta ON bibliotecadieta.id_endie = encabezadodieta.id_endie"
                    + "where bibliotecadieta.id_usu = ? and encabezadodieta.id_die = ?";
            PreparedStatement ps= con.prepareStatement(p);
            ps.setInt(1, id_usu);
            ps.setInt(2, id_die);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                id_bli= rs.getInt("id_bli");
            }
            if(id_bli != -1){
                String q = "delete from bibliotecadietas where id_bli = ?";
                ps= con.prepareStatement(q);
                ps.setInt(1, id_bli);
                estatus = ps.executeUpdate();
            }
            con.close();
            rs.close();
            ps.close();
        }catch(Exception e){
            System.out.println("Error al Eliminar");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int consultaridencabezado(Connection con, int id_die){
        int encabezado = 0;
        try{
            String d= "select id_endie from encabezadodieta where id_die = ?";
            PreparedStatement ps = con.prepareStatement(d);
            ps.setInt(1, id_die);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                encabezado = rs.getInt("id_endie");
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("Error al Consultar");
            System.out.println(e.getMessage());
        }
        return encabezado;
    }
    
}
