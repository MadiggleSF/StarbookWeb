<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean scope="request" id="beanReview" class="beans.beanReview"/>
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
    <jsp:setProperty name="beanReview" property="bookRating" value="${i.isbn}" />
    <% if (beanReview.getReviews().size() < 1) {%>
    Pas de notes !<br> 
    <%} else {%>
    Note moyenne: <jsp:getProperty name="beanReview" property="bookRating"/>/10<br>
    <%}%>
    ${i.summary}
    <br>
    Prix: ${i.price} euro(s)
    <br>
    <a href="controllerML?section=caddy&add=${i.isbn}&src=search">Ajouter au panier</a>
    <hr>

</c:forEach>