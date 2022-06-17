
package Control;

import java.sql.*;
public class Conexion {
    public static Connection getConnection(){
        String url, userName, password;
        
        url = "jdbc:mysql://us-cdbr-east-05.cleardb.net/heroku_b3b88c0337e26c9";
        userName = "b21ae80ea3e3cb";
        password = "f1eab042";
        Connection con = null;
        //mysql://b21ae80ea3e3cb:f1eab042@us-cdbr-east-05.cleardb.net/heroku_b3b88c0337e26c9?reconnect=true
        
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
