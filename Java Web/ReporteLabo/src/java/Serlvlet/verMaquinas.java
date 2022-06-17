/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serlvlet;

import Control.Acciones;
import Modelo.MEquipo;
import Modelo.MUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juanv
 */
public class verMaquinas extends HttpServlet {

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
            HttpSession sesion = request.getSession(true);
            if(sesion.getAttribute("usuario")!= null){
                 MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
                if(usu.getRol()==2){
                    List<MEquipo> equi = Acciones.ConsultarEquipos();
                    if(equi.size() > 0){
                        int filtro = 0;
                        try{
                            filtro = Integer.valueOf(request.getParameter("filtro"));
                        }catch(Exception e){
                            filtro = 0;
                        }
                        if(filtro !=0){
                            for(MEquipo e:equi){
                                if(filtro == e.getId_estado()){
                                    out.println("<div class=\"equipo\">");
                                        out.println("<img src=\"./img/computadora.png\">");
                                        out.println("<br>");
                                        out.println("Numero de Equipo:"+e.getNumero());
                                        out.println("<br>");
                                        out.println("Laboratorio:"+e.getDes_labo());
                                        out.println("<br>");
                                        out.println("Estado:"+e.getDes_estado());
                                        out.println("<br>");
                                        out.println("<button class=\"boton\" onclick=\"location.href = './verReporte.jsp?id="+e.getId()+"'\">Ver Reportes</button>");
                                    out.println("</div>");
                                }
                            }
                        }else if(filtro == 0){
                            for(MEquipo e:equi){
                                out.println("<div class=\"equipo\">");
                                    out.println("<img src=\"./img/computadora.png\">");
                                    out.println("<br>");
                                    out.println("Numero de Equipo:"+e.getNumero());
                                    out.println("<br>");
                                    out.println("Laboratorio:"+e.getDes_labo());
                                    out.println("<br>");
                                    out.println("Estado:"+e.getDes_estado());
                                    out.println("<br>");
                                    out.println("<button class=\"boton\" onclick=\"location.href = './verReporte.jsp?id="+e.getId()+"'\">Ver Reportes</button>");
                                out.println("</div>");
                            }
                        }
                    }else{
                        out.println("<div class=\"equipo\">");
                            out.println("<img src=\"./img/computadora.png\">");
                            out.println(" <br>");
                            out.println("Sin equipos Registrados");
                        out.println("</div>");
                    }
                }else if(usu.getRol()==1){
                    response.sendRedirect("MisEquipos.jsp");
                }
            }else{
                response.sendRedirect("index.jsp");
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
