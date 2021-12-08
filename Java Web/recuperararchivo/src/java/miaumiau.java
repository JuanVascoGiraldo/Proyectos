/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import intento.cifrado;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.* ;

/**
 *
 * @author Juanv
 */
@WebServlet("/ProcesoArchivo")
   @MultipartConfig
public class miaumiau extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public static final String ruta= "C:\\Users\\Juanv\\Desktop\\recuperararchivo\\";//cambiar por la ruta en l aque tengas tu carpeta
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            String accion = request.getParameter("accion");
            String key = request.getParameter("llave");
            InputStream inputStream = null;
            int jalo = 0;
            Part filePart = request.getPart("archivo");
                    if (filePart.getSize() > 0) {
                        inputStream = filePart.getInputStream();
                    }
                    FileOutputStream ous = new FileOutputStream(ruta + "Recuperado.txt");
                    int dato = inputStream.read();
                        while(dato != -1){
                                ous.write(dato);
                                dato = inputStream.read();
                        }

                    ous.close();
                    inputStream.close();
            try{
                if(accion.equals("Cifrar")){
                    
                    jalo = cifrado.Cifrar("Recuperado.txt", key);
                    
                }else if(accion.equals("Descifrar")){
                    
                    jalo = cifrado.Descifrar("Recuperado.txt", key);
                    
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                jalo = 2;
            }
            if(jalo == 1){
                if(accion.equals("Cifrar")){
                    response.sendRedirect("NewServlet?accion=Cifrar");
                }else if(accion.equals("Descifrar")){
                    response.sendRedirect("NewServlet?accion=Descifrar");
                }
            }
            else{
                
                
            }
            /*
            out.println("</body>");
            out.println("</html>");
            */
            
            
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
