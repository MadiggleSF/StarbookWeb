<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Tester si le panier est vide ou pas : prendre un IF DE JSTL sur la palette; ça va rajouter le taglib --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <title>JSP Page</title>
        <jsp:include page="jspHeader.jsp" flush="true"/>
    </head>
    <body> 
        <c:if test="${cartEmpty}" var="c">
            <img id="panierVide" src="images/vide.jpg" alt="Panier vide !">
            <br>
            <form class="inner" method="POST" action="controllerSeb">
                <input type="hidden" name="section" value="" />
                <input type="submit" name="" value="< Poursuivre vos achats" /><br>
            </form>
        </c:if>

        <c:if test="${!cartEmpty}" var="c">  
            <table>
                <tr>
                    <th> Aperçu </th>
                    <th> Titre </th>
                    <th> Quantité </th>
                    <th> Prix unitaire </th>
                    <th> Sous total </th>
                </tr>

                <c:forEach var="i" items="${list}">
                    <tr class="insideTable">
                        <td><a href="controllerSeb?section=bookDetail&bookIsbn=${i.isbn}"><img src="images/${i.picture}" alt="${i.title}" height="68" width="50"></a></td>
                        <td>${i.title}</td>  
                        <td>${i.qty}</td> 
                        <td>${i.bookTaxedPrice}</td>
                        <td>${i.lineTaxedPrice}</td>
                        <td><a href="controllerML?section=caddy&inc=${i.isbn}"><img alt="+" src="images/Add.png"></a>
                            <a href="controllerML?section=caddy&dec=${i.isbn}"><img alt="-" src="images/button-decrease.png"></a>
                            <a href="controllerML?section=caddy&del=${i.isbn}"><img alt="X" src="images/button-remove.png"></a>
                        </td>
                    </tr>        
                </c:forEach> 
            </table>

            <div id="containerButtons">
                <form id="btn_left" class="inner" method="POST" action="controllerSeb">
                    <input type="hidden" name="section" value="" />
                    <input type="submit" name="" value="< Poursuivre vos achats" /><br>
                </form>
                <form id="btn_right" class="inner" method="POST" action="controllerML">
                    <input type="hidden" name="section" value="caddy" />
                    <input type="hidden" name="clean" value="ok" />
                    <input type="submit" name="cleanCart" value="Passer votre commande" />
                </form>     
            </div>
        </c:if>
    </body>
</html>

