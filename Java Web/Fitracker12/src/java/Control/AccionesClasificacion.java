package Control;
    import Modelo.Clasificacion;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

public class AccionesClasificacion {
    
    public static List<Clasificacion> clasificacioneje(){
        List<Clasificacion> lista = new ArrayList<Clasificacion>();
        Connection con = null;
        ResultSet rs =  null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from clasificacion_eje";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()){
                Clasificacion c = new Clasificacion ();
                c.setId(rs.getInt("id_ec"));
                c.setDes(rs.getString("clasi_ec"));
                lista.add(c);
            }
        }catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();;
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return lista;
    }
    
    public static List<Clasificacion> clasificaciondie(){
        List<Clasificacion> lista = new ArrayList<Clasificacion>();
        Connection con = null;
        ResultSet rs =  null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from clasificacion_die";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()){
                Clasificacion c = new Clasificacion ();
                c.setId(rs.getInt("id_cd"));
                c.setDes(rs.getString("clasi_cd"));
                lista.add(c);
            }
        }catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();;
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return lista;
    }
    
    public static List<Clasificacion> Horario(){
        List<Clasificacion> lista = new ArrayList<Clasificacion>();
        Connection con = null;
        ResultSet rs =  null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String q = "select * from horario";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()){
                Clasificacion c = new Clasificacion ();
                c.setId(rs.getInt("id_horario"));
                c.setDes(rs.getString("des_horario"));
                lista.add(c);
            }
        }catch(Exception e){
            System.out.println("Error al consultar");
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();;
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return lista;
    }
}
