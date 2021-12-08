<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, java.util.*, java.text.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Producto</title>
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
                    String nombre, tipo, sabor, q;
                    double precio;
                    nombre = request.getParameter("nombre");
                    tipo = request.getParameter("tipo");
                    sabor = request.getParameter("sabor");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    
                         set = con.createStatement();
                        q = "insert into producto(nom_pro, tip_pro, sabor_pro, precio_pro) "
                                + "values ('"+nombre+"', '"+tipo+"', '"+sabor+"', "+ precio+")";
                        set.executeUpdate(q);
                        
                        q = "SELECT * FROM producto;";
                        rs = set.executeQuery(q);
                        int total=0;
                        while(rs.next()){
                            total = total +1;
                        }
                    %>
        <h1>Se Ha registrado el nuevo producto, el total de productos registrados es <%= total %> </h1>            
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
