<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean scope="request" id="beanReview" class="beans.beanReview"/>
<div id="catalog">
    <c:forEach var="i" items="${catalog}">
        <div class="conteneur">
            <img src="images/${i.picture}"  alt="${i.title}_image" height="200" width="140" />
            <div class="element">
                <h2><a href="controllerSeb?section=bookDetail&bookIsbn=${i.isbn}">${i.title}</a></h2>
                <c:if  test="${i.subtitle} != null">
                    /${i.subtitle}
                </c:if>
                <br>
                <h3><c:forEach var="aut" items="${i.author}">
                    /<a href="controllerSeb?section=authorDetail&authorId=${aut.id}">${aut.firstname} ${aut.surname}</a>
                    </c:forEach></h3>
                <jsp:setProperty name="beanReview" property="bookRating" value="${i.isbn}" />
                <% if (beanReview.getReviews().size() < 1) {%>
                <h3>Pas de note !<br></h3> 
                <%} else {%>
                <h3>Note moyenne:</h3> <jsp:getProperty name="beanReview" property="bookRating"/>/10<br>
                <%}%>
                ${i.summary}
                <br>
                <h3>Prix:</h3> ${i.price} euro(s)
                <br>
                <a href="controllerML?section=caddy&add=${i.isbn}&src=search">Ajouter au panier</a>
            </div>
        </div>
        <hr>

    </c:forEach>
</div>