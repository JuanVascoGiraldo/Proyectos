/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.ConexionAPI;
import Modelo.listaanime;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Filtro extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int filtro = Integer.valueOf(request.getParameter("filtro"));
            HttpSession sesion = request.getSession(true);
            int id = Integer.valueOf(sesion.getAttribute("id").toString());
            List<listaanime> lista = ConexionAPI.listausuario(id);
            if(filtro == 2){
                out.println("<div class=\"agre\" background=\"img/horis.png\" data-open=\"modalR\">");
                   out.println("<img src=\"img/add_40px.png\">");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<br>");
                out.println("</div>");
                for(listaanime anime:lista){
                    if(anime.getEstado() == 0){
                            out.println("<div class=\"anime1\">");
                            out.println("<h5>Pendiente</h5>");
                            out.println("<h5>"+anime.getDes_anime() + "</h5>");
                            out.println("<h5>"+ anime.getCapitulos() + " Capitulos</h5>");
                            out.println("<h5>"+ anime.getDes_gen() + "</h5>");
                            out.println("<button type=\"button\" class=\"botonees1\" onclick=\"visto("+anime.getId_dlista()+")\" id=\"enviar\">Visto</button>");
                            out.println("<button type=\"button\" class=\"botonees\" onclick=\"eliminar("+anime.getId_dlista() + ")\" id=\"enviar\">Eliminar</button>");
                            out.println("<br>");
                        out.println("</div>");
                    }else if(anime.getEstado() == 1){
                        out.println("<div class=\"anime2\">");
                            out.println("<h5>Visto</h5>");
                            out.println("<h5>"+anime.getDes_anime() +"</h5>");
                            out.println("<h5>"+anime.getCapitulos() +" Capitulos</h5>");
                            out.println("<h5>"+anime.getDes_gen() +"</h5>");
                            out.println("<button type=\"button\" class=\"botonees2\" onclick=\"pendiente("+ anime.getId_dlista() +" )\" id=\"enviar\">Pendiente</button>");
                            out.println("<button type=\"button\" class=\"botonees\" onclick=\"eliminar("+ anime.getId_dlista() +")\" id=\"enviar\">Eliminar</button>");
                            out.println("<br>");
                        out.println("</div>");
                    }
                }
            }else{
                out.println("<div class=\"agre\" background=\"img/horis.png\" data-open=\"modalR\">");
                   out.println("<img src=\"img/add_40px.png\">");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<br>");
                   out.println("<br>");
                out.println("</div>");
                for(listaanime anime:lista){
                    if(anime.getEstado() == filtro && anime.getEstado() == 0){
                            out.println("<div class=\"anime1\">");
                            out.println("<h5>Pendiente</h5>");
                            out.println("<h5>"+anime.getDes_anime() + "</h5>");
                            out.println("<h5>"+ anime.getCapitulos() + " Capitulos</h5>");
                            out.println("<h5>"+ anime.getDes_gen() + "</h5>");
                            out.println("<button type=\"button\" class=\"botonees1\" onclick=\"visto("+anime.getId_dlista()+")\" id=\"enviar\">Visto</button>");
                            out.println("<button type=\"button\" class=\"botonees\" onclick=\"eliminar("+anime.getId_dlista() + ")\" id=\"enviar\">Eliminar</button>");
                            out.println("<br>");
                        out.println("</div>");
                    }else if(anime.getEstado() == filtro && anime.getEstado() == 1){
                        out.println("<div class=\"anime2\">");
                            out.println("<h5>Visto</h5>");
                            out.println("<h5>"+anime.getDes_anime() +"</h5>");
                            out.println("<h5>"+anime.getCapitulos() +" Capitulos</h5>");
                            out.println("<h5>"+anime.getDes_gen() +"</h5>");
                            out.println("<button type=\"button\" class=\"botonees2\" onclick=\"pendiente("+ anime.getId_dlista() +" )\" id=\"enviar\">Pendiente</button>");
                            out.println("<button type=\"button\" class=\"botonees\" onclick=\"eliminar("+ anime.getId_dlista() +")\" id=\"enviar\">Eliminar</button>");
                            out.println("<br>");
                        out.println("</div>");
                    }
                }
            }
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
