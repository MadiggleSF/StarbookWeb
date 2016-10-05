<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Tester si le panier est vide ou pas : prendre un IF DE JSTL sur la palette; ça va rajouter le taglib --%>

<c:if test="${panierVide}" var="c">
    Panier vide !
</c:if>

<c:if test="${!panierVide}" var="c">    
    <c:forEach var="i" items="${liste}">
        ${i.title} / ${i.qty} / ${i.bookTaxedPrice} / ${i.linePrice}
        <a href="controllerML?section=caddy&inc=${i.isbn}">+</a>
        <a href="controllerML?section=caddy&dec=${i.isbn}">-</a>
        <a href="controllerML?section=caddy&del=${i.isbn}">X</a>
        <br>        
    </c:forEach>  
        <a href="controllerML?section=caddy&clean">Vider le panier !</a>
</c:if>