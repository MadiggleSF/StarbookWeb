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
            String oMsgs = "";
            request.setAttribute("oMsgs", oMsgs);
            BeanCart cart = (BeanCart) session.getAttribute("cart");
            if (cart == null) {
                cart = new BeanCart();
                session.setAttribute("cart", cart);
            }
            request.setAttribute("emptyOrder", cart.isEmpty());
            request.setAttribute("order", cart.list());
            request.setAttribute("orderQty", cart.quantify());
            request.setAttribute("orderPrice", cart.calculateTotalPrice());
            if(session.getAttribute("shippingType") != null){
                request.setAttribute("shippingType", (String) session.getAttribute("shippingType"));
            }

            url = "/WEB-INF/jspDisplayOrder.jsp";

        }

        if ("shippingAddresses".equals(request.getParameter("section"))) {

            beanAddresses adList = new beanAddresses();
            session.setAttribute("shippingType", request.getParameter("shippingTypeList"));

            if (session.getAttribute("LOGIN") != null) {
                String login = (String) session.getAttribute("LOGIN");
                adList.getCustomerAddresses(login);
                request.setAttribute("adList", adList.list());
                request.setAttribute("showNewForm", false);
                //Select address
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

                if (request.getParameter("modDelivery") != null) {
                    Address sda = (Address) session.getAttribute("sda");
                    if (sda != null) {
                        adList.update(sda.getId(),
                                request.getParameter("sdaStreet"),
                                request.getParameter("sdaZipcode"),
                                request.getParameter("sdaCity"),
                                request.getParameter("sdaCountry"),
                                request.getParameter("sdaCountry"));
                    }
                }

                if (request.getParameter("modBilling") != null) {
                    Address sba = (Address) session.getAttribute("sba");
                    if (sba != null) {
                        adList.update(sba.getId(),
                                request.getParameter("sbaStreet"),
                                request.getParameter("sbaZipcode"),
                                request.getParameter("sbaCity"),
                                request.getParameter("sbaCountry"),
                                request.getParameter("sbaCountry"));
                    }

                }

                if (request.getParameter("delDelivery") != null) {
                    Address sda = (Address) session.getAttribute("sda");
                    if (sda != null) {
                        adList.remove(sda.getId());
                        session.setAttribute("sda", null);
                    }
                }

                if (request.getParameter("delBilling") != null) {
                    Address sba = (Address) session.getAttribute("sba");
                    if (sba != null) {
                        adList.remove(sba.getId());
                        session.setAttribute("sba", null);
                    }
                }
                
                if(request.getParameter("okNewFormAppears") != null){
                    request.setAttribute("showNewForm", true);
                }

                if (request.getParameter("okNew") != null) {
                    if (request.getParameter("naZipcode") != null
                            && request.getParameter("naCity") != null
                            && request.getParameter("naCountry") != null) {
                        Address na = new Address(0, 
                                request.getParameter("naStreet"), 
                                request.getParameter("naOther"), 
                                request.getParameter("naZipcode"), 
                                request.getParameter("naCity"), 
                                request.getParameter("naCountry"));
                        adList.insertAddress(na);
                        if(request.getParameter("daNew") != null){
                            adList.setDelivery(login, na);
                            request.setAttribute("showNewForm", false);
                        }
                        if(request.getParameter("baNew") != null){
                            adList.setBilling(login, na);
                            request.setAttribute("showNewForm", false);
                        }
                        if(request.getParameter("daNew") == null && request.getParameter("baNew") == null){
                            String oMsgs = "Nouvelle adresse : facturation et/ou livraison ?";
                            request.setAttribute("oMsgs", oMsgs);
                        }
                    }
                    
                }

            }
            url = "/WEB-INF/jspShippingAddresses.jsp";

        }

        if ("payment".equals(request.getParameter("section"))) {
            String oMsgs = "";
            request.setAttribute("oMsgs", oMsgs);
            request.setAttribute("shippingType", session.getAttribute("shippingType"));
            Address sda = (Address) session.getAttribute("sda");
            Address sba = (Address) session.getAttribute("sba");
            if (sda == null || sba == null) {
                oMsgs = "Adresses non valides";
                url = "controllerBen?section=shippingAddresses";
                request.setAttribute("oMsgs", oMsgs);

            }
            if (sda != null && sba != null) {
                request.setAttribute("sda", sda);
                request.setAttribute("sba", sba);

                url = "/WEB-INF/jspPayment.jsp";
            }

        }


        if ("paymentCheck".equals(request.getParameter("section"))) {
            String pMsgs = "";
            String login = (String) session.getAttribute("LOGIN");
            Address sda = (Address) session.getAttribute("sda");
            Address sba = (Address) session.getAttribute("sba");
            if (request.getParameter("okPayment") != null) {

                beanPayment payment = new beanPayment(
                        request.getParameter("ccOwner"),
                        request.getParameter("ccNumber"),
                        request.getParameter("ccCrypto"));
                boolean check = payment.checkCC();
                if (!check) {
                    pMsgs = "Carte invalide";
                    url = "/WEB-INF/jspPayment.jsp";
                    request.setAttribute("pMsgs", pMsgs);
                }

                if (check) {
                    pMsgs = "";
                    request.setAttribute("cMail", session.getAttribute("LOGIN"));
                    beanOrder bo = new beanOrder();
                    BeanCart cart = (BeanCart) session.getAttribute("cart");
                    bo.fill(cart.list());
                    bo.makeOrder(login, sda.getId(), sba.getId());
                    url = "/WEB-INF/jspMoneyMoneyMoney.jsp";
                }
            }
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
