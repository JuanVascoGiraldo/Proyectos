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
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletConfig;


public class Modificar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modificar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Modificar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try (PrintWriter out = response.getWriter()) {
            start();
            String seleccionado="", cambio="", validar="", validar2="", validar3 ="";
            String q = "";
            int id = 0;
            boolean seguir= true, seguir2=false;
            seleccionado= request.getParameter("Parametro"); 
            id = Integer.parseInt(request.getParameter("idmodificar"));
            cambio= request.getParameter("cambios");
            validar = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM "
                    + "áéóúíÁÉÍÓÚ";
            validar2= validar + "._@-,$&";
            validar3= "12345679890";
            
            if(seleccionado.equals("Nombre") || seleccionado.equals("APaterno")|| seleccionado.equals("AMaterno")){
                for(int i=0; i<cambio.length(); i++){
                    char caracter = cambio.charAt(i);
                    for(int j = 0; j < validar.length(); j++){
                        if(caracter == validar.charAt(j))
                            break;
                        if(j == (validar.length()-1)){
                            seguir = false;
                            break;
                        }
                    }
                }
                if(cambio.length()>20 && cambio.length()==0){
                    seguir = false;
                }
            }
            if(seleccionado.equals("Correo")){
                for(int i=0; i<cambio.length(); i++){
                    char caracter = cambio.charAt(i);
                    for(int j = 0; j < validar2.length(); j++){
                        if(caracter == validar2.charAt(j))
                            break;
                        if(j == (validar2.length()-1)){
                            seguir = false;
                            break;
                        }
                    }
                }
                Pattern pat = Pattern.compile("([a-z0-9]+(\\\\.?[a-z0-9])*)+@(([a-z]+)\\\\.([a-z]+))+");
                Matcher mather = pat.matcher(cambio);
                if (mather.find() == false) {
                    seguir = false;
                }
            }
            if(seleccionado.equals("Edad")){
                for(int i=0; i<cambio.length(); i++){
                    char caracter = cambio.charAt(i);
                    for(int j = 0; j < validar3.length(); j++){
                        if(caracter == validar3.charAt(j))
                            break;
                        if(j == (validar3.length()-1)){
                            seguir = false;
                            break;
                        }
                    }
                }
                if(cambio.length()>2 && cambio.length()==0){
                    seguir = false;
                }
            }
            
            if(id <1 ){
                seguir = false;
            }
            if(seleccionado.equals("Edad") && seguir==true){
                if(Integer.parseInt(cambio)<1){
                    seguir = false;
                }
            }
            try{
                String w = "select * from mregistro";
                set = con.createStatement();
                rs = set.executeQuery(w);
                int idRegistados;
                while(rs.next()){
                    idRegistados = rs.getInt("id_usu");
                    if(idRegistados == id){
                        seguir2 = true;
                    }
                }
                
            
            }catch(Exception e){
                    System.out.println("No se ha podido Consultar");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());}
            
            
            
            if(seguir == true && seguir2==true){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro de Usuarios</title>");            
                out.println("<link rel='preconnect' href='https://fonts.gstatic.com'>");        
                out.println("<link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap' rel='stylesheet'>");      
                out.println("</head>");
                out.println("<body style='background-color: #0D3B66; text-align: center; color: white; font-family: 'Noto Sans JP';'>");
                try{
                    switch(seleccionado){
                        case "Nombre":
                            q = "UPDATE mregistro SET nom_usu ='"+cambio+"' where id_usu ="+id;
                            break;

                        case "APaterno":
                            q = " UPDATE mregistro SET appat_usu ='"+cambio+"' where id_usu ="+id;
                            break;
                            
                        case "AMaterno":
                            q = " UPDATE mregistro SET apmat_usu ='"+cambio+"' where id_usu ="+id;
                            break;
                            
                        case "Edad":
                            int ed= Integer.parseInt(cambio);
                            q = " UPDATE mregistro SET edad_usu ="+ed+" where id_usu ="+id;
                            break;
                            
                        case "Correo":
                            q = "UPDATE mregistro SET email_usu ='"+cambio+"'where id_usu ="+id;
                            break; 
                    }
                    if(!(q.equals(""))){
                        set.executeUpdate(q);
                    }
                    out.println("<h2>Se Ha actualizado El id "+ id
                            + "</h2>");
                
                }catch(Exception e){
                    out.println("<h2>No Se Ha actualizado El id"+ id
                            + "</h2>");
                    System.out.println("No se ha podido Actualizar");
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    
                }
                out.println("<a href='index.html'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Volver al inicio</h1>\n"
                            +"</div>\n" 
                            + "</a>"
                            +"<a href='VModificar.html'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Volver al Formulario</h1>\n"
                            +"</div>\n" 
                            + "</a>"
                            +"<a href='Consultar'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Consultar Tabla de Usuarios</h1>\n"
                            +"</div>\n" 
                            + "</a>");      
                out.println("</body>");
                out.println("</html>");
            
            }else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro de Usuarios</title>");            
                out.println("<link rel='preconnect' href='https://fonts.gstatic.com'>");        
                out.println("<link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap' rel='stylesheet'>");      
                out.println("</head>");
                out.println("<body style='background-color: #0D3B66; text-align: center; color: white; font-family: 'Noto Sans JP';'>"
                            +"<h1>Se introdujo un dato no valido o el Id no ha sido Registrado</h1>"
                            +"<a href='index.html'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Volver al inicio</h1>\n"
                            +"</div>\n" 
                            + "</a>"
                            +"<a href='VModificar.html'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Volver al Formulario</h1>\n"
                            +"</div>\n" 
                            + "</a>"
                            +"<a href='Consultar'>\n"
                            +"<div style='font-family: 'Noto Sans JP'; border-radius: 5px; width: 20%; '"
                            +"color: white; background-color: black; margin-left: 32rem; text-align: center;'>" 
                            +"<h1>Consultar Tabla de Usuarios</h1>\n"
                            +"</div>\n" 
                            + "</a>");      
                out.println("</body>");
                out.println("</html>");
            }
            
            
            
        }
            try{
                set.close();
            }
            catch(Exception e){
                System.out.println("No se ha podido cerrar la conección1");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            try{
                destroy();
            }
            catch(Exception e){
                System.out.println("No se ha podido cerrar la conección2");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            try{
                rs.close();
            }
            catch(Exception e){
                System.out.println("No se ha podido cerrar la conección3");
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
