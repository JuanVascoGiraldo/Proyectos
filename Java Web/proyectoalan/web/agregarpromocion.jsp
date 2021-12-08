<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, java.util.*, java.text.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Promocion</title>
    </head>
    <body>
        <%
            Connection con = null;
            Statement set = null;
            ResultSet rs = null;
            
            String url, userName, password, driver;
            
            url = "jdbc:mysql://localhost/bdhelado";
            userName = "root";
            password = "";
            driver = "com.mysql.jdbc.Driver";
         try{
                Class.forName(driver);
                con = DriverManager.getConnection(url, userName, password);
                
                try{
                    String nombre, aplica,q;
                    double descuento, compraminima;
                    nombre = request.getParameter("nombre");
                    aplica = request.getParameter("aplica");
                    descuento = Double.parseDouble(request.getParameter("precio"));
                    compraminima = Double.parseDouble(request.getParameter("compraminima"));
                    
                         set = con.createStatement();
                        q = "insert into promocion(nom_promo, apli_promo, pre_promo, min_promo) "
                                + "values ('"+nombre+"', '"+aplica+"', "+descuento+", "+ compraminima+");";
                        set.executeUpdate(q);
                        
                        q = "SELECT * FROM promocion;";
                        rs = set.executeQuery(q);
                        int total=0;
                        while(rs.next()){
                            total = total +1;
                        }
                    %>
        <h1>Se Ha registrado La nueva Promoción, el total de promociones registradas es <%= total %> </h1>            
                    <%
                        set.close();
                        rs.close();
                        %>
                 <h1>Se han introducido datos no validos</h1>       
        
        <%  
               }catch(SQLException ed){
                    System.out.println("Error al registrar el producto en la tabla");
                    System.out.println(ed.getMessage());
                    %>     
        <h1>Registro No Exitoso, error en la lectura de la tabla</h1>            
                    <%
                
                }
                con.close();
            
            }catch(Exception e){
                System.out.println("Error al conectar la base de datos");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            %>
        <h1>Sitio en Construcción</h1>            
                    <%
            }
        %>       
    </body>
</html>
