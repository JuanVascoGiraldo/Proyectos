
package Control;
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;
    import Modelo.Promocion;
public class accionesPromocion {
     public static int registrarPromocion(Promocion p){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "insert into promocion(nom_promo, compra_min, des_promo, id_pro) "
                    + "values(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCompraminima());
            ps.setInt(3, p.getDescuento());
            ps.setInt(4, p.getIdproducto());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso de la Promocion");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar la Promoción");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
     public static int actualizarPromoción(Promocion p){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update promocion set nom_promo = ?, compra_min = ?,"
                    + "des_promo = ?, id_pro = ? "
                    + "where id_promo = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCompraminima());
            ps.setInt(3, p.getDescuento());
            ps.setInt(4, p.getIdproducto());
            ps.setInt(5, p.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa de la Promocion");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar la Promoción");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
     
    public static int borrarPromocion(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from promocion where id_promo = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, id);
            estatus = ps.executeUpdate();
            System.out.println("Se retiro exitosamente la promocion del inventario");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al borrar la promocion");
            System.out.println(ed.getMessage());
        }
        return estatus;
    }
    public static Promocion buscarPromocionById(int id){
        Promocion p = new Promocion();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from promocion where id_promo = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCompraminima(rs.getInt(3));
                p.setDescuento(rs.getInt(4));
                p.setIdproducto(rs.getInt(5));
            }
            
            System.out.println("Promoción Encontrada");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar La promocion en el registro");
            System.out.println(ed.getMessage());
        
        }
        return p;
    }
    
    public static List<Promocion> buscarAllPromocion(){
        List<Promocion> lista = new ArrayList<Promocion>();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from promocion";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Promocion p = new Promocion();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCompraminima(rs.getInt(3));
                p.setDescuento(rs.getInt(4));
                p.setIdproducto(rs.getInt(5));
                lista.add(p);
            }
            System.out.println("Se ha consultado todos las promociones");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al Consultar Las promociones");
            System.out.println(ed.getMessage());
        }
        return lista;
    }
    
    public static List<Promocion> buscarPromocionByIdHelado(int id){
        List<Promocion> lista = new ArrayList<Promocion>();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from promocion where id_pro = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Promocion p = new Promocion();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setCompraminima(rs.getInt(3));
                p.setDescuento(rs.getInt(4));
                p.setIdproducto(rs.getInt(5));
                lista.add(p);
            }
            System.out.println("Se ha consultado todos las promociones");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al Consultar Las promociones");
            System.out.println(ed.getMessage());
        }
        return lista;
    }
}


