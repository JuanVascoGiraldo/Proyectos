/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author Juanv
 */
public class Registro extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    public void init(ServletConfig cfg) throws ServletException{
        String url = "jdbc:mysql://localhost/registro4iv7";
        String userName= "root";
        String password= "03042021";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            System.out.println("Se ha conectado a la BD");
        }catch(Exception e){
            System.out.println("No se Ha conectado");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            start();
            String nom, appat, appmat, correo, validar2, validar, comprobar;
            int edad;
            boolean seguir = true;
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            appmat = request.getParameter("appmat");
            correo = request.getParameter("email");
            edad = Integer.parseInt(request.getParameter("edad"));
            comprobar= nom+appat+appmat;
            validar = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM "
                    + "áéóúíÁÉÍÓÚ";
            validar2= validar + "._@-,$&0123456789";
            for(int i=0; i<comprobar.length(); i++){
                char caracter = comprobar.charAt(i);
            for(int j = 0; j < validar.length(); j++){
                if(caracter == validar.charAt(j) || String.valueOf(caracter).equals("ñ")|| String.valueOf(caracter).equals("Ñ"))
                    break;
                if(j == (validar.length()-1)){
                    seguir = false;
                    break;
                }
            }
            }
            for(int i=0; i<correo.length(); i++){
                char caracter = correo.charAt(i);
            for(int j = 0; j < validar2.length(); j++){
                if(caracter == validar2.charAt(j))
                    break;
                if(j == (validar2.length()-1)){
                    seguir = false;
                    break;
                }
            }
            }
            if(edad<1){
                    seguir = false;
                }
            if(seguir==true){
            
            try{
            
                //querry para poder insertar los datos en la bd
                /*
                insert into nombretabla (atributo, atributo, ...)
                values ("valor1", 'valor2', valor3, ...)
                */
                
                String q = "insert into Mregistro "
                        + "(nom_usu, appat_usu, apmat_usu, edad_usu, email_usu) "
                        + "values "
                        + "('"+nom+"', '"+appat+"', '"+appmat+"', "+edad+", '"+correo+"')";
            
                set.executeUpdate(q);
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Usuarios</title>"); 
            out.println("<link rel='preconnect' href='https://fonts.gstatic.com'>");        
             out.println("<link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap' rel='stylesheet'>");      
            out.println("</head>");
            out.println("<body style='background-color: #0D3B66; text-align: center; color: white; font-family: 'Noto Sans JP';'>"
                    + "<br><h1>Tu nombre es: " + nom);
            out.println("</h1><br>"
                    + "<h1>Tu Apellido Paterno es:"+appat
                    + "</h1><br>"
                    + "<h1>Tu Apellido Materno es:"+appmat
                    + "</h1><br>"
                    + "<h1>Tu Edad es:"+edad
                    + "</h1><br>"
                    + "<h1>Tu correo electronico es:"+correo
                    + "</h1><br>");
            out.println("<h1>Registro Exitoso</h1>"
                    + "<br>"
                    + "<br>"
                    + "<a href='index.html'>\n"
                    +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                    +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                    +"<h1>Volver al inicio</h1>\n"
                    +"</div>\n" 
                    + "</a>"
                    + "<br>");
            out.println("<br>"
                    + "<br>"
                    + "<a href='consultar>\n"
                    +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                    +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                    +"<h1>Consultar tabla de usuarios</h1>\n"
                    +"</div>\n" 
                    + "</a>"
                    + "<br>"
                    +"<a href='VRegistro.html'>\n"
                    +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                    +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                    +"<h1>Registrar Nuevo Usuario</h1>\n"
                    +"</div>\n" 
                    + "</a>");
            out.println("</body>");
            out.println("</html>");
            
                System.out.println("Datos registrados en la tabla");
            
            }catch(Exception e){
                
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Registro de Usuarios</title>"); 
                    out.println("<link rel='preconnect' href='https://fonts.gstatic.com'>");        
                    out.println("<link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap' rel='stylesheet'>");      
                    out.println("</head>");
                    out.println("<body style='background-color: #0D3B66; text-align: center; color: white; font-family: 'Noto Sans JP';'>"
                        + "<h1>No se pudo registrar, hubo un error</h1>"
                        +"<a href='index.html'>\n"
                        +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                        +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                        +"<h1>Volver al inicio</h1>\n"
                        +"</div>\n" 
                        + "</a>");     
                    out.println("</body>");
                    out.println("</html>");
            }
            }
            else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro de Usuarios</title>");            
                out.println("<link rel='preconnect' href='https://fonts.gstatic.com'>");        
                out.println("<link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap' rel='stylesheet'>");      
                out.println("</head>");
                out.println("<body style='background-color: #0D3B66; text-align: center; color: white; font-family: 'Noto Sans JP';'>"
                            +"<h1>Se introdujo un dato no valido</h1>"
                            +"<a href='index.html'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Volver al inicio</h1>\n"
                            +"</div>\n" 
                            + "</a>"
                            +"<a href='VRegistro.html'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Volver al Formulario</h1>\n"
                            +"</div>\n" 
                            + "</a>");      
                out.println("</body>");
                out.println("</html>");
            }
            
            
        }
        try{
                rs.close();
                set.close();
                destroy();
            }
            catch(Exception e){
                System.out.println("No se ha podido cerrar la conección");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public void destroy(){
        try{
            con.close();
        
        }catch(Exception e){
            System.out.println("F");
            super.destroy();
        
        }
    }
    public void start(){
    
        String url = "jdbc:mysql:3306//localhost/registro4iv7";
                    //driver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "03042021";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            /*
            a veces el driver ya maneja por defecto el puerto de comunicacion
            es por ello que pueden mandar un error, en ese caso
            url = "jdbc:mysql://localhost/registro4iv7";
            */
            url = "jdbc:mysql://localhost/registro4iv7";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Se ha conectado a la BD");
        
        }catch(Exception e ){
            System.out.println("No se ha conectado a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
