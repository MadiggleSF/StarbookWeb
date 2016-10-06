<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Tester si le panier est vide ou pas : prendre un IF DE JSTL sur la palette; �a va rajouter le taglib --%>

<c:if test="${panierVide}" var="c">
    Panier vide !
</c:if>

<c:if test="${!panierVide}" var="c">  
    <table>
        <tr>
            <th> Titre </th>
            <th> Quantit� </th>
            <th> Prix unitaire </th>
            <th> Sous total </th>
        </tr>
        
        <c:forEach var="i" items="${liste}">
        <tr>
            <td>${i.title}</td>  
            <td>${i.qty}</td> 
            <td>${i.bookTaxedPrice}</td>
            <td>${i.lineTaxedPrice}</td>
            <td><a href="controllerML?section=caddy&inc=${i.isbn}">+</a>
                <a href="controllerML?section=caddy&dec=${i.isbn}">-</a>
                <a href="controllerML?section=caddy&del=${i.isbn}">X</a>
            </td>
        </tr>        
    </c:forEach>  
    </table>
<a href="controllerML?section=caddy&clean">Vider le panier !</a>
</c:if>


