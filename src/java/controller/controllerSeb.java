/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.beanCatalog;
import beans.beanAuthor;
import beans.beanEvents;
import beans.beanGenre;
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
            url = "/WEB-INF/jspSearchResult.jsp";
            beanCatalog bc = (beanCatalog) session.getAttribute("beanCatalog");
            if (request.getParameter("sendResearch") != null) {
                if (bc == null) {
                    bc = new beanCatalog();
                    session.setAttribute("beanCatalog", bc);

                }
                bc.getCatalog().clear();
                switch (request.getParameter("searchCategory")) {
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
            beanCatalog bc = (beanCatalog) session.getAttribute("beanCatalog");
            if (request.getParameter("sendResearch") != null) {
                if (bc == null) {
                    bc = new beanCatalog();
                    session.setAttribute("beanCatalog", bc);
                }
                bc.getCatalog().clear();
            }
            request.setAttribute("book", bc.getBook(request.getParameter("bookIsbn")));
        }

        //section3
        if ("authorDetail".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspAuthor.jsp";
            beanAuthor bda = (beanAuthor) session.getAttribute("beanDisplayAuthor");
            if (bda == null) {
                bda = new beanAuthor();
                session.setAttribute("beanDisplayAuthor", bda);
            }
            request.setAttribute("author", bda.getAuthor(Integer.valueOf(request.getParameter("authorId"))));
            beanCatalog bc = (beanCatalog) session.getAttribute("beanCatalog");

            if (bc == null) {
                bc = new beanCatalog();
                session.setAttribute("beanCatalog", bc);
            }

            bc.getCatalog().clear();
            bc.fillCatalog(request.getParameter("authorId"), 5);
            session.setAttribute("catalog", bc.getCatalogList());
        }

        //section4
        if ("eventDetail".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspEvent.jsp";
            beanEvents be = (beanEvents) session.getAttribute("beanEvents");
            if (be == null) {
                be = new beanEvents();
                session.setAttribute("beanEvents", be);
            }
            request.setAttribute("event", be.getEvent(request.getParameter("eventId")));

            beanCatalog bc = (beanCatalog) session.getAttribute("beanCatalog");
            if (bc == null) {
                bc = new beanCatalog();
                session.setAttribute("beanCatalog", bc);
            }
            bc.getCatalog().clear();
            bc.fillCatalog(request.getParameter("eventId"), 4);

            session.setAttribute("catalog", bc.getCatalogList());
        }

        //section5
        if ("events".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspSectionEvents.jsp";
            beanEvents be = (beanEvents) session.getAttribute("beanEvents");
            if (be == null) {
                be = new beanEvents();
                session.setAttribute("beanEvents", be);
            }
            be.fillEvents();
            session.setAttribute("events", be.getEventBookList());
        }
        
        //section6
        if ("rayons".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspSectionRayons.jsp";
            beanGenre bg = (beanGenre)session.getAttribute("beanGenre");
            if (bg == null) {
                bg = new beanGenre();
                session.setAttribute("beanGenre", bg);
            }
            bg.fillGenre();
            session.setAttribute("genres", bg.getGenresList());
            
        }
        
        //section7
        if ("genreDetail".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspGenre.jsp";
            beanGenre bg = (beanGenre)session.getAttribute("beanGenre");
            if (bg == null) {
                bg = new beanGenre();
                session.setAttribute("beanGenre", bg);
            }
            request.setAttribute("genre", bg.getGenre(request.getParameter("genreName")));
            
            beanCatalog bc = (beanCatalog) session.getAttribute("beanCatalog");
            if (bc == null) {
                bc = new beanCatalog();
                session.setAttribute("beanCatalog", bc);
            }
            bc.getCatalog().clear();
            bc.fillCatalog(request.getParameter("genreName"), 6);

            session.setAttribute("catalog", bc.getCatalogList());
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
