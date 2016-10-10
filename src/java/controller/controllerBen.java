/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import classes.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi313
 */
@WebServlet(name = "controllerBen", urlPatterns = {"/controllerBen"})
public class controllerBen extends HttpServlet {

    
    protected Cookie getCookie(Cookie[] cookies, String name) {

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

        String url = "/WEB-INF/jspValidateOrder.jsp";
        HttpSession session = request.getSession();

        // *************** TEST ******************
        session.setAttribute("LOGIN", "seb@gmail.com");
        Tax t1 = new Tax(1, "Basic", 19.5f);
        Book bk1 = new Book("012546-31AA", null, "Coincoin", "", null, "ecece", "summary", "Fr", 30.5f, t1, 999, "128", "Relié", 154);
        Book bk2 = new Book("561698-FF8", null, "Le ciment de la joie", "", null, "zece", "summary", "Fr", 12.0f, t1, 999, "152", "Relié", 110);
        BeanCart panierTest = new BeanCart();
        panierTest.add(bk1, 4);
        panierTest.add(bk2, 9);
        session.setAttribute("cart", panierTest);
        // ***************************************

        if ("displayOrder".equals(request.getParameter("section"))) {

            BeanCart cart = (BeanCart) session.getAttribute("cart");
            if (cart == null) {
                cart = new BeanCart();
                session.setAttribute("cart", cart);
            }
            request.setAttribute("emptyOrder", cart.isEmpty());
            request.setAttribute("order", cart.list());
            request.setAttribute("orderQty", cart.quantify());
            request.setAttribute("orderPrice", cart.calculateTotalPrice());

            url = "/WEB-INF/jspDisplayOrder.jsp";

        }

        if ("shippingType".equals(request.getParameter("section"))) {
            String msg = "";
            if (request.getParameter("noShipping") != null) {

            }
            if (request.getParameter("colissimo") != null) {
                msg = "Livraison 48h - Gratuit !";
            }
            if (request.getParameter("chronopost") != null) {
                msg = "Livraison 24h - Gratuit !";
            }

            request.setAttribute("shippingMsg", msg);
        }

        if ("shippingAddresses".equals(request.getParameter("section"))) {
            
            beanAddresses adList = new beanAddresses();
            if (session.getAttribute("LOGIN") != null) {
                String login = (String) session.getAttribute("LOGIN");
                adList.getCustomerAddresses(login);
                request.setAttribute("adList", adList.list());

                if (request.getParameter("okDelivery") != null || request.getParameter("okBilling") != null) {
                    if (request.getParameter("deliveryList") != null) {
                        Address sda = adList.getAddress(Integer.valueOf(request.getParameter("deliveryList")));
                        session.setAttribute("sda", sda);
                    }
                    if (request.getParameter("billingList") != null) {
                        Address sba = adList.getAddress(Integer.valueOf(request.getParameter("billingList")));
                        session.setAttribute("sba", sba);
                    }
                    request.setAttribute("sda", session.getAttribute("sda"));
                    request.setAttribute("sba", session.getAttribute("sba"));
                }
            }
            url = "/WEB-INF/jspShippingAddresses.jsp";
            
        }
        
        if("payment".equals(request.getParameter("section"))){
            Address sda = (Address) session.getAttribute("sda");
            Address sba = (Address) session.getAttribute("sba");
            request.setAttribute("sda", sda);
            request.setAttribute("sba", sba);            
            
            
            url ="/WEB-INF/jspPayment.jsp";
        }

        //section1
        //section2
        //section...
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
