<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Tester si le panier est vide ou pas : prendre un IF DE JSTL sur la palette; ça va rajouter le taglib --%>

<c:if test="${panierVide}" var="c">
    Panier vide !
</c:if>

<c:if test="${!panierVide}" var="c">    
    <c:forEach var="i" items="${liste}">
        ${i.ref} / ${i.qty}
        <a href="controller?section=caddy&inc=${i.ref}">+</a>
        <a href="controller?section=caddy&dec=${i.ref}">-</a>
        <a href="controller?section=caddy&del=${i.ref}">X</a>
        <br>        
    </c:forEach>  
        <a href="controller?section=caddy&clean">Vider le panier !</a>
</c:if>