
package Control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Producto;

public class accionesProducto {
     public static int registrarProducto(Producto p){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "insert into producto(nom_pro, pre_pro, sabor_pro, imagen) "
                    + "values(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getPrecio());
            ps.setString(3, p.getSabor());
            ps.setString(4, p.getImagen());
            
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso del Produto");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al registrar el Producto");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
     
    public static int actualizarProducto(Producto p){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "update producto set nom_pro = ?, pre_pro = ?,"
                    + "sabor_pro = ?, imagen = ? "
                    + "where id_pro = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getPrecio());
            ps.setString(3, p.getSabor());
            ps.setString(4, p.getImagen());
            ps.setInt(5, p.getId());
            
            estatus = ps.executeUpdate();
            System.out.println("Actualizacion Exitosa del Producto");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al actualizar el Producto");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static int borrarProducto(int id){
        int estatus = 0;
        try{
            Connection con = Conexion.getConnection();
            String q = "delete from producto where id_pro = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, id);
            estatus = ps.executeUpdate();
            System.out.println("Se retiro exitosamente el producto del inventario");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al borrar el producto");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
    }
    
    public static Producto buscarProductoById(int id){
        Producto p = new Producto();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from producto where id_pro = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setSabor(rs.getString(4));
                p.setImagen(rs.getString(5));
            }
            
            System.out.println("Producto Encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar el producto en el registro");
            System.out.println(ed.getMessage());
        
        }
        return p;
    }
    
    public static List<Producto> buscarAllProducto(){
        List<Producto> lista = new ArrayList<Producto>();
        
        try{
            Connection con = Conexion.getConnection();
            String q = "select id_pro from producto";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = buscarProductoById(rs.getInt(1));
                lista.add(p);
            }
            
            System.out.println("Se ha consultado todos los helados");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar Los Productos");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
    
    public static List<Producto> buscarProductoBySabor(String sabor){
        List<Producto> lista = new ArrayList<Producto>();
        try{
            Connection con = Conexion.getConnection();
            String q = "select * from producto where sabor_pro = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, sabor);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setSabor(rs.getString(4));
                p.setImagen(rs.getString(5));
                lista.add(p);
            }
            
            System.out.println("Sabor Encontrado");
            con.close();
        
        }catch(Exception ed){
            System.out.println("Error al buscar el sabor en el registro");
            System.out.println(ed.getMessage());
        
        }
        return lista;
    }
}
