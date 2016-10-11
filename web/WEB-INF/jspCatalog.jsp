<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="i" items="${catalog}">
    
    <img src="images/${i.picture}"  alt="${i.title}_image" height="200" width="140" />
    <a href="controllerSeb?section=bookDetail&bookIsbn=${i.isbn}">${i.title}</a>
    <c:if  test="${i.subtitle} != null">
        /${i.subtitle}
    </c:if>
    <br>
    <c:forEach var="aut" items="${i.author}">
    <a href="controllerSeb?section=authorDetail&authorId=${aut.id}">${aut.firstname} ${aut.surname}</a>
    <br></c:forEach>
    <jsp:useBean class="beans.beanReview" scope="request" id="beanReview"/>
    <c:forEach var="rating" items="${ratingList}">
        <c:if test="${rating} == ${i.isbn}">
            Note: ${rating.qty}/10
        </c:if>
    </c:forEach>
    Note:
    ${i.summary}
    <br>
    Prix: ${i.price} euro(s)
    <br>
    <a href="controllerML?section=caddy&add=${i.isbn}&src=search">Ajouter au panier</a>
    <hr>
    
</c:forEach>