
package Control;

import Modelo.Comidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccionesComida {
    public static boolean yagregado(String nombre, Connection con){
        boolean confirmar= true;
        try{
            con = Conexion.getConnection();
            // ver si ya se agrego la comida con el nombre
            String p = "SELECT nom_comi as nombre FROM comida";
            PreparedStatement ps = con.prepareStatement(p);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(nombre.equals(rs.getString("nombre"))){
                    confirmar= false;
                    break;
                }
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println("error al buscar");
            System.out.println(e.getMessage());
        }
        return confirmar;
    }
    
    public static int agregarcomida(Comidas c){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            // ver si ya se agrego la comida con el nombre
            boolean confirmar = yagregado(c.getNombre(), con);
            if(confirmar == true){
                String q = "insert into comida (nom_comi, des_comi , activa) "
                        + "values(?,?,?)";
                PreparedStatement ps = con.prepareStatement(q);
                 ps.setString(1, c.getNombre());
                 ps.setString(2, c.getDescripcion());
                 ps.setInt(3,1);
                 estatus = ps.executeUpdate();
                 ps.close();
            }
            else{
             estatus = 2;
            }
            con.close();
            
        }catch(Exception e){
            System.out.println("Se Agrego la comida");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int modificarcomida(Comidas c){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            boolean confirmar = yagregado(c.getNombre(), con);
            if(confirmar == true){
                String p = "update comida set nom_comi = ?, des_comi = ? "
                        + "where id_comida = ?";
                PreparedStatement ps = con.prepareStatement(p);
                ps.setString(1, c.getNombre());
                ps.setString(2, c.getDescripcion());
                ps.setInt(3, c.getId());
                estatus = ps.executeUpdate();
                ps.close();
            }
            else{
             estatus = 2;
            }
            con.close();
        }
        catch(Exception e){
            System.out.println("Se Agrego la comida");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int CambiarusoComida(int id, String accion){
        int estatus= 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update comida set activa = ? where id_comida = ?";
            PreparedStatement ps = con.prepareStatement(q);
            if(accion.equals("desactivar")){
                ps.setInt(1, 0);
            }
            else{
                ps.setInt(1, 1);
            }
            ps.setInt(2, id);
            estatus = ps.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println("Error a cambiar uso");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static Comidas ConsultarcomidaByid(int id){
        Comidas c = new Comidas();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from comida where id_comida = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("id_comida"));
                c.setDescripcion(rs.getString("des_comi"));
                c.setActiva(rs.getInt("activa"));
                c.setNombre(rs.getString("nom_comi"));
            }
            con.close();
            rs.close();
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error a consultar la comida");
            System.out.println(e.getMessage());
        }
        return c;
    }
    
    public static List<Comidas> ConsultarallComidas(){
        List<Comidas> lista = new ArrayList<Comidas>();
        try{
            Connection con = Conexion.getConnection();
            String q  = "select * from comida";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Comidas c = new Comidas();
                c.setId(rs.getInt("id_comida"));
                c.setNombre(rs.getString("nom_comi"));
                c.setDescripcion(rs.getString("des_comi"));
                c.setActiva(rs.getInt("activa"));
                lista.add(c);
            }
            con.close();
            rs.close();
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error a consultar todas las comidas");
            System.out.println(e.getMessage());
        
        }
        return lista;
    }
    
    public static int RelacionarComidaaDieta(int id_die, int id_comida , int horario){
        //metodo para hacer la relacion comida dieta y tambien modificarla
        int estatus = 0;
        try{
            boolean confirmar = true;
            Connection con = Conexion.getConnection();
            //primero verificar si entre las comidas registradas con el id de la dieta
            //esta la comida que se quiere agregar
            int encabezado = AccionesDieta.consultaridencabezado(con , id_die);
            String q = "select id_comida, id_cd from comidadedieta where id_endie = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, encabezado);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getInt("id_comida") == id_comida){
                    //si esta solo la actualiza
                    confirmar = false;
                    String b= "update comidadedieta set id_endie = ? , id_comida = ?, "
                            + "id_horario = ? where id_cd = ? ";
                    ps = con.prepareStatement(b);
                    ps.setInt(1, encabezado);
                    ps.setInt(2, id_comida);
                    ps.setInt(3, horario);
                    ps.setInt(4, rs.getInt("id_cd"));
                    estatus = ps.executeUpdate();
                    break;
                }
            }
            if(confirmar == true){
                //si no esa se registra
                String p = "insert into comidadedieta (id_endie, id_comida , id_horario)"
                            + "values(?,?,?)";
                ps = con.prepareStatement(p);
                ps.setInt(1, encabezado);
                ps.setInt(2, id_comida);
                ps.setInt(3, horario);
                estatus = ps.executeUpdate();
            }
            con.close();
            rs.close();
            ps.close();
        }
        catch (Exception e){
            System.out.println("Todo lo que podia fallar, fallo");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static int ElimininarComidadeDieta(int id_die, int id_comida){
        int estatus = 0;
        try{
            Connection con= Conexion.getConnection();
            int encabezado = AccionesDieta.consultaridencabezado(con , id_die);
            String p = "delete from comidadedieta where id_endie = ? and id_comida = ?";
            PreparedStatement ps = con.prepareStatement(p);
            ps.setInt(1, encabezado);
            ps.setInt(2, id_comida);
            estatus = ps.executeUpdate();
            con.close();
            ps.close();
        }
        catch(Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    public static List<Comidas> ConsultarComidasdeDieta(int id_die, int horario, Connection con){
    List<Comidas> lista = new ArrayList<Comidas>();
    try{
        int encabezado = AccionesDieta.consultaridencabezado(con , id_die);
        String q = "Select comida.id_comida, comida.nom_comi , comida.des_comi , comida.activa from comidadedieta "
                + "INNER JOIN comida ON comida.id_comida = comidadedieta.id_comida "
                + "where id_endie = ? AND id_horario = ? ";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, encabezado);
        ps.setInt(2, horario);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Comidas c =  new Comidas ();
            c.setActiva(rs.getInt("activa"));
            if(c.getActiva() == 1){
                c.setId(rs.getInt("id_comida"));
                c.setDescripcion(rs.getString("des_comi"));
                c.setNombre(rs.getString("nom_comi"));
                lista.add(c);
            }
        }
        ps.close();
        rs.close();
    }
    catch(Exception e){
        System.out.println("Error al consultar");
        System.out.println(e.getMessage());
    }
        return lista;
    }
}
