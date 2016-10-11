<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="review" items="${reviews}">
    ${review.customer.firstname} ${review.customer.surname}     note: ${review.rating}/10   |   Posté le: ${review.date}
    <br>
    ${review.comment}<br>
</c:forEach>