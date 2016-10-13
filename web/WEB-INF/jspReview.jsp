<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="review" items="${reviews}">
    <img src="images/${review.book.picture}" alt="${review.book.title}_image" height="200" width="140"/>
    ${review.book.title}<br>
    <c:forEach var="author" items="${review.book.author}">
        ${author.firstname} ${author.surname}<br>
    </c:forEach>
    Note: ${review.rating} | Posté le: ${review.date}<br>
    ${review.comment}
    <hr>

</c:forEach>


