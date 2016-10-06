/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.BeanCart;
import classes.Book;
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

        String url = "/WEB-INF/jspCaddy.jsp";
        HttpSession session = request.getSession();

        //section1
        //section2
        //section...
        if ("fillCart".equals(request.getParameter("section"))) {
            if (request.getParameter("fillCart") != null) {
                BeanCart monPanier = (BeanCart) session.getAttribute("cart");
                if (monPanier == null) {
                    monPanier = new BeanCart();
                    //session.setAttribute("panier", monPanier);
                    session.setAttribute("cart", monPanier);
                }
                //request.setAttribute("panierVide", monPanier.isEmpty());
                request.setAttribute("cartEmpty", monPanier.isEmpty());
//                request.setAttribute("liste", monPanier.list());
                request.setAttribute("list", monPanier.list());

                url = "/WEB-INF/jspCaddy.jsp";
            }
        }

        //mécanisme d'affichage du caddy
        if ("DisplayCaddy".equals(request.getParameter("section"))) {          
            BeanCart monPanier = (BeanCart) session.getAttribute("cart");
      
            if (monPanier == null) {
                monPanier = new BeanCart();
                session.setAttribute("cart", monPanier);
            }
            url = "/WEB-INF/jspCaddy.jsp";
            request.setAttribute("cartEmpty", monPanier.isEmpty());
            request.setAttribute("list", monPanier.list());
        }

        if ("caddy".equals(request.getParameter("section"))) {
            BeanCart monPanier = (BeanCart) session.getAttribute("cart");
            if (monPanier == null) {
                monPanier = new BeanCart();
                session.setAttribute("cart", monPanier);
            }
// A partir de la page résultat (miniatures) ou de la page zoom
            if (request.getParameter("add") != null) {
                
                monPanier.create(monPanier.testReturnBookFromIsbn(request.getParameter("add")));
            }
            if (request.getParameter("inc") != null) {
                System.out.println("ISBN du livre à incrémenter " + request.getParameter("inc"));
                Book bk01 = monPanier.testReturnBookFromIsbn(request.getParameter("inc"));
                System.out.println("Objet book à incrémenter : " + bk01);
                monPanier.inc(bk01);
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
            request.setAttribute("cartEmpty", monPanier.isEmpty());
            request.setAttribute("list", monPanier.list());
            if ("book".equals(request.getParameter("src"))) {
                url = "/WEB-INF/jspBook.jsp";
            }
            if ("search".equals(request.getParameter("src"))) {
                url = "/WEB-INF/jspSearch.jsp";
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
