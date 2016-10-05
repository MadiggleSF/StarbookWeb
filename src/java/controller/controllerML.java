/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.BeanCart;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi313
 */
@WebServlet(name = "controllerML", urlPatterns = {"/controllerML"})
public class controllerML extends HttpServlet {

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

        String url = "/WEB-INF/TempJspFillCart.jsp";
        HttpSession session = request.getSession();

        //section1
        //section2
        //section...
        if ("fillCart".equals(request.getParameter("section"))) {
            if (request.getParameter("fillCart") != null) {
                BeanCart monPanier = (BeanCart) session.getAttribute("panier");
                if (monPanier == null) {
                    monPanier = new BeanCart();
                    session.setAttribute("panier", monPanier);
                }
            request.setAttribute("panierVide", monPanier.isEmpty());
            request.setAttribute("liste", monPanier.list());

                url = "/WEB-INF/jspCaddy.jsp";

            }
        }

        //mécanisme d'affichage du caddy
        if ("DisplayCaddy".equals(request.getParameter("section"))) {
            //Il me faut ce que j'ai besoin d'afficher
            BeanCart monPanier = (BeanCart) session.getAttribute("panier");
            //Si mon panier n'existe pas dans ce cas là je le crée et je la mets dans l'environnement session
            if (monPanier == null) {
                monPanier = new BeanCart();
                session.setAttribute("panier", monPanier);
            }
            url = "/WEB-INF/jspCaddy.jsp";
            request.setAttribute("panierVide", monPanier.isEmpty());
            request.setAttribute("liste", monPanier.list());
          
        }

        if ("caddy".equals(request.getParameter("section"))) {
            BeanCart monPanier = (BeanCart) session.getAttribute("panier");
            if (monPanier == null) {
                monPanier = new BeanCart();
                session.setAttribute("panier", monPanier);
            }

            if (request.getParameter("add") != null) {
                monPanier.create(monPanier.testReturnBookFromIsbn(request.getParameter("add")));
            }
            if (request.getParameter("inc") != null) {
                monPanier.inc(monPanier.testReturnBookFromIsbn(request.getParameter("inc")));
            }
            if (request.getParameter("dec") != null) {
                monPanier.dec(monPanier.testReturnBookFromIsbn(request.getParameter("dec")));
            }
            if (request.getParameter("del") != null) {
                monPanier.del(monPanier.testReturnBookFromIsbn(request.getParameter("del")));
            }
            if (request.getParameter("clean") != null) {
                monPanier.clean();
            }
        }

        request.getRequestDispatcher(url).include(request, response);
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
