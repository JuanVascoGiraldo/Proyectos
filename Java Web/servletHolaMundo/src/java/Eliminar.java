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
//de poder realizar la conexion con la bd
import java.sql.Connection;
import java.sql.DriverManager;
//de poder realizar las sentencias sql, create, insert, delete, drop, update, alter
import java.sql.Statement;
//de poder realizar las consultas a la bd
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;

/**
 *
 * @author demon
 */
public class Eliminar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //vamos a crear el metodo constructor
    
    public void init(ServletConfig cfg) throws ServletException{
        //para conectarnos con la bd
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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            start();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>");            
            out.println("<link rel='preconnect' href='https://fonts.gstatic.com'>");        
            out.println("<link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap' rel='stylesheet'>");      
            out.println("</head>");
            out.println("<body style='background-color: #0D3B66; text-align: center; color: white; font-family: 'Noto Sans JP';'>");
            
            int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            boolean seguir=true;
            if(id <1 ){
                seguir = false;
            }
            
            /*
            para poder eliminar es 
            delete from nombretabla where atributo (condicion) valor
            */
            String q = "delete from mregistro where id_usu = "+id;
            try{
                if(seguir== true){
                set.executeUpdate(q);
                System.out.println("Registro eliminado con exito");
                out.println("<h1>Registro Eliminado</h1>");
                }
                else{
                    out.println("<h1>Registro No Eliminado, sucedio un error</h1>");
                }
            }catch(Exception e){
                out.println("<h1>Registro No Eliminado, sucedio un error</h1>");
                System.out.println("Error al eliminar el registro");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }

            out.println("<a href='index.html'>\n"
                    +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                    +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                    +"<h1>Volver al inicio</h1>\n"
                    +"</div>\n" 
                    + "</a>"
                    + "<br>"
                    + "<br>"
                    +"<a href='VRegistro.html'>\n"
                    +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                    +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                    +"<h1>Registrar Nuevo Usuario</h1>\n"
                    +"</div>\n" 
                    + "</a>"
                    + "<br>"
                    + "<br>"
                    +"<a href='Consultar'>\n"
                    +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                    +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                    +"<h1>Consultar Tabla de Usuarios</h1>\n"
                    +"</div>\n" 
                    + "</a>"
            
            );
            out.println("</body>");
            out.println("</html>");
            
            
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
    
    public void destroy(){
        try{
            con.close();
        
        }catch(Exception e){
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
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}