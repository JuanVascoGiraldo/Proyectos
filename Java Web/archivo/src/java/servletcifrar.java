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

public class servletcifrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tamano = request.getParameter("tamano");
        String key = request.getParameter("key");
        String texto = request.getParameter("texto");
        String cifrado = "";
        int seguir = 0;
        if(tamano.equals("128")){
            if(key.length() == 16) seguir =1;
        }else if(tamano.equals("192")){
            if(key.length() == 24) seguir =1;
        }else if (tamano.equals("256")){
            if(key.length() == 32) seguir =1;
        }
        if(seguir != 0){
            try{
                cifrado = AES.encrypt(texto, key);
            }catch(Exception e){
                System.out.println(e.getMessage());
                }
            PrintWriter bufferr = response.getWriter(); 
            String filename = "cifrado.txt";
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
            bufferr.write(cifrado);
            bufferr.close();
            response.sendRedirect("index.html");
        }else{
            response.sendRedirect("index.html");
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
