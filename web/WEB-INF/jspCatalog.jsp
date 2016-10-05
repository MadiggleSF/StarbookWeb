<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="i" items="${catalog}">
    <img src="${i.picture}"  alt="authorImage" />
    <a href="controllerSeb?section=bookDetail&bookIsbn=${i.isbn}">${i.title}</a>
    <c:if  var="i.subtitle" test="!= null">
        /${i.subtitle}
    </c:if>
    <br>
    ${i.author}
    <br>
    ${i.summary}
    ${i.price}
    <br>
    <a href="">Ajouter au panier</a>
    <hr>
    
</c:forEach>