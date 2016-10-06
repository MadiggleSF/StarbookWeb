/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.beanCatalog;
import beans.beanDisplayAuthor;
import beans.beanDisplayBook;
import beans.beanDisplayEvent;
import beans.beanEvents;
import classes.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
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
@WebServlet(name = "controllerSeb", urlPatterns = {"/controllerSeb"})
public class controllerSeb extends HttpServlet {

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
        
        String url = "/WEB-INF/jspHeader.jsp";
        HttpSession session = request.getSession();
        
        //section1
        if ("search".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspSearch.jsp";
            beanCatalog bc = (beanCatalog) request.getAttribute("beanCatalog");
            if (request.getParameter("sendResearch") != null) { 
                if (bc == null) {
                    bc = new beanCatalog();
                    session.setAttribute("beanCatalog", bc);
                }
                switch (request.getParameter("buttonGroup01")) {
                    case "title":
                        bc.fillCatalog(request.getParameter("search"), 1);
                        break;
                    case "author":
                        bc.fillCatalog(request.getParameter("search"), 2);
                        break;
                    case "isbn":
                        bc.fillCatalog(request.getParameter("search"), 3);
                        break;

                }
            }
            session.setAttribute("catalog", bc.getCatalogList());
        }
        //section2
        if ("bookDetail".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspBook.jsp";
            beanDisplayBook bdb = (beanDisplayBook)session.getAttribute("beanDisplayBook");
            if (bdb == null) {
                bdb = new beanDisplayBook();
                session.setAttribute("beanDisplayBook", bdb);
            }
           session.setAttribute("book", bdb.getBook(request.getParameter("bookIsbn")));
           
           
        }
        
        //section3
        if ("authorDetail".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspAuthor.jsp";
            beanDisplayAuthor bda = (beanDisplayAuthor)session.getAttribute("beanDisplayAuthor");
            if (bda == null) {
                bda = new beanDisplayAuthor();
                session.setAttribute("beanDisplayAuthor", bda);
            }
            request.setAttribute("author", bda.getAuthor(Integer.valueOf(request.getParameter("authorId"))));
        }
        
        //section4
        if ("eventDetail".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspEvent.jsp";
            beanDisplayEvent bde = (beanDisplayEvent)session.getAttribute("beanDisplayEvent");
            if (bde == null) {
                bde = new beanDisplayEvent();
                session.setAttribute("beanDisplayEvent", bde);
            }
            request.setAttribute("event", bde.getEvent(Integer.valueOf(request.getParameter("eventId"))));
            
            beanEvents be = (beanEvents)session.getAttribute("beanEvents");
            if (be == null) {
                be = new beanEvents();
                session.setAttribute("beanEvents", be);
            }
            be.fillEvents(request.getParameter("eventId"));
            request.setAttribute("catalog", be.getEventBookList());
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
