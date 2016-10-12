<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean scope="request" id="beanReview" class="beans.beanReview"/>
<jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>

<img src="images/${book.picture}"  alt="${book.title}_image"  height="200" width="140"/><br>
${book.title}
<c:if test="${book.subtitle} != null">
    /${book.subtitle}
</c:if>
<br>
<c:forEach var="aut" items="${book.author}">
    <a href="controllerSeb?section=authorDetail&authorId=${aut.id}">
        ${aut.firstname} ${aut.surname}</a><br>
    </c:forEach>
    ${book.idiom}/${book.print}/${book.date}<br>
<jsp:setProperty name="beanReview" property="bookRating" value="${book.isbn}" />

<% if (beanReview.getReviews().size() < 1) {%>
    Pas de notes !<br> 
    <%} else {%>
    Note moyenne: <jsp:getProperty name="beanReview" property="bookRating"/>/10<br>
    <%}%>
${book.summary}<br>
Prix: ${book.price} euros<br>
Stock: ${book.quantity}<br>
Pages:${book.pages}<br>
Poids:${book.weight}<br>

<a href="controllerML?section=caddy&add=${book.isbn}&src=book" >Ajouter au Panier</a>
<br>
Commentaires:
<br>
<jsp:include flush="true" page="/WEB-INF/jspReviews.jsp"/>
<hr>

<c:if test="${login} != null">
    <jsp:include flush="true" page="/WEB-INF/jspAddReview.jsp"/>
</c:if>
<jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
