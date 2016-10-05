
package controller;

import beans.BeanLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
Gab
 */
@WebServlet(name = "controllerGab", urlPatterns = {"/controllerGab"})
public class controllerGab extends HttpServlet {

 
     private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }
     
     
     
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String url = "/WEB-INF/jspLogin.jsp";
        HttpSession session = request.getSession();
        
        
        
        if ("login".equals(request.getParameter("section"))) {
            if (request.getParameter("Connexion") != null) {
                BeanLogin bLogin = (BeanLogin) session.getAttribute("beanLogin");
                if (bLogin == null) {
                    bLogin = new BeanLogin();
                    session.setAttribute("beanLogin", bLogin);
                }
                if (bLogin.check(request.getParameter("login"),
                        request.getParameter("password"))) {
                    url = "/WEB-INF/jspWelcome.jsp";
                    request.setAttribute("welcome", request.getParameter("login"));
                    Cookie c = new Cookie("LOGIN", request.getParameter("login"));
                    response.addCookie(c);
                    c = new Cookie("try", "");
                    c.setMaxAge(0);
                    response.addCookie(c);
                } else {
                    url = "/WEB-INF/jspLogin.jsp";
                    request.setAttribute("login", request.getParameter("login"));
                    request.setAttribute("msg", "ERREUR:Login/Mot de passe invalide !!!");
                    Cookie c = getCookie(request.getCookies(), "try");
                    if (c == null) {
                        c = new Cookie("try", "*");
                    } else {
                        c.setValue(c.getValue() + "*");
                    }
                    c.setMaxAge(45);
                    response.addCookie(c);
                    if (c.getValue().length() > 3) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalerror", "Trop de tentatives !!!");
                    }
                }
            }

            Cookie cccc = getCookie(request.getCookies(), "login");
            if (request.getParameter("deconnect") != null) {
                if (cccc != null) {
                    url = "/WEB-INF/jspLogin.jsp";
                    request.setAttribute("login", cccc.getValue());
                    cccc.setValue("");
                    cccc.setMaxAge(0);
                    response.addCookie(cccc);
                }
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
