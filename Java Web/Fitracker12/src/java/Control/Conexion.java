package Control;
import java.sql.*;
public class Conexion {
    public static Connection getConnection(){
        String url, userName, password;
        
        url = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_d3addcd55daeffa";
        userName = "b00626f5b867f4";
        password = "11819e67";
        //mysql://b00626f5b867f4:11819e67@us-cdbr-east-04.cleardb.com/heroku_d3addcd55daeffa?reconnect=true
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, userName, password);
            
            System.out.println("Conexion Exitosa con la BD");
        
        }catch(Exception e){
            System.out.println("Error al conectar la BD");
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
