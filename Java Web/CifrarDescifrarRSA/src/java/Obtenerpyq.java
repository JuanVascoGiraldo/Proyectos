

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.Random;
import javax.servlet.http.HttpSession;

public class Obtenerpyq extends HttpServlet {

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
            BigInteger p = new BigInteger(request.getParameter("p"));
            BigInteger q = new BigInteger(request.getParameter("q"));
            BigInteger fi, n, e, d;
            n = p.multiply(q);
            fi = p.subtract(BigInteger.valueOf(1));
            fi = fi.multiply(q.subtract(BigInteger.valueOf(1)));
            do e = new BigInteger(2*3, new Random());
            while((e.compareTo(fi) != -1) || (e.gcd(fi).compareTo(BigInteger.valueOf(1)) != 0));
            //calcular a d = e ^ 1 mod fi   inverso multiplicativo de e
            d = e.modInverse(fi);
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("p", p);
            sesion.setAttribute("q", q);
            sesion.setAttribute("fi", fi);
            sesion.setAttribute("n", n);
            sesion.setAttribute("e", e);
            sesion.setAttribute("d", d);
            response.sendRedirect("inicio.jsp");
            
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
