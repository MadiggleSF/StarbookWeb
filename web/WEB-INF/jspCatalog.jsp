<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="i" items="${catalog}">
    <img src="images/${i.picture}"  alt="${i.author.surname}_image" height="200" width="140" />
    <a href="controllerSeb?section=bookDetail&bookIsbn=${i.isbn}">${i.title}</a>
    <c:if  test="${i.subtitle} != null">
        /${i.subtitle}
    </c:if>
    <br>
    <a href="controllerSeb?section=authorDetail&authorId=${i.author.id}">${i.author.firstname} ${i.author.surname}</a>
    <br>
    ${i.summary}
    <br>
    Prix: ${i.price} euro(s)
    <br>
    <a href="controllerML?section=caddy&add=${i.isbn}&src=search">Ajouter au panier</a>
    <hr>
    
</c:forEach>