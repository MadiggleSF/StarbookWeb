/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.BeanCart;
import java.io.IOException;
import java.io.PrintWriter;
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
         //Différencier l'affichage du caddie du traitement du caddie
        //Appeler mécanisme d'affichage du caddy
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

        //section traitement du panier qui n'a pas pour vocation d'afficher (donc on supprime l'URL)
        if ("caddy".equals(request.getParameter("section"))) {

            //url = "/WEB-INF/jspCaddy.jsp";
            //charger le bean panier dans la section (si un bean est important on le charge en variable globale plus haut)
            BeanCart monPanier = (BeanCart) session.getAttribute("panier");
            //Si mon panier n'existe pas dans ce cas là je le crée et je la mets dans l'environnement session
            if (monPanier == null) {
                monPanier = new BeanCart();
                session.setAttribute("panier", monPanier);
            }

            //Recopié de la jspPanier
            if (request.getParameter("add") != null) {
                monPanier.create(request.getParameter("add"));
            }
            if (request.getParameter("inc") != null) {
                monPanier.inc(request.getParameter("inc"));
            }
            if (request.getParameter("dec") != null) {
                monPanier.dec(request.getParameter("dec"));
            }
            if (request.getParameter("del") != null) {
                monPanier.del(request.getParameter("del"));
            }
            if (request.getParameter("clean") != null) {
                monPanier.clean();
            }

//            //Préparer le terrain de l'affichage
//            //Envoyer comme info à ma jsp si mon panier est vide (vrai ou faux)
//            request.setAttribute("panierVide", monPanier.isEmpty());
//            //envoyer ma liste
//            request.setAttribute("liste", monPanier.list());
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
