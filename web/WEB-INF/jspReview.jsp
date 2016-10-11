<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<img src="images/${review.book.picture}" alt="${review.book.title}_image"/>
${review.book.title}<br>
<c:forEach var="author" items="${review.book.author}">
    ${author.firstname} ${author.surname}<br>
</c:forEach>
    ${review.rating} | ${review.date}<br>
${review.comment}

