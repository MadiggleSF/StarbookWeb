<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }%>
<jsp:useBean scope="request" id="beanReview" class="beans.beanReview"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <link rel="stylesheet" href="css/styleseb.css"/>
        <title>JSP Page</title>
        
    </head>
    <body>
        <jsp:include page="jspHeader.jsp" flush="true"/>
        <jsp:include flush="true" page="jspNavBar.jsp"/>
        <h1 id="bookTitle">${book.title} </h1>
        <div id="book" >
            <img src="images/${book.picture}"  alt="${book.title}_image"  height="200" width="140"/><br>
            <div class="element">
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
            </div>
            <br>
            <div class="element">
                <h2>Commentaires:</h2>
                <br>
                <jsp:include flush="true" page="/WEB-INF/jspReviews.jsp"/>
                <hr>
                <h2>Ajouter un commentaire</h2>
                <jsp:include flush="true" page="/WEB-INF/jspAddReview.jsp"/>
                <% if (request.getAttribute("login") != null) {%>

                <%}%>
                <c:if test="${login} != null">

                </c:if>
            </div>
        </div>
        <jsp:include page="jspFooter.jsp" flush="true"/>
    </body>
</html>

