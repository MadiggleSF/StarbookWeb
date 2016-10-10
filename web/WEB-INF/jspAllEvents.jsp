<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="event" items="${events}">
    <img src="images/${event.picture}" alt="${event.name}_image" height="200" width="140"/>
    <a href="controllerSeb?section=eventDetail&eventId=${event.id}">${event.name}</a> 
    Début: ${event.start}
    Fin: ${event.end}
    <c:if test="${event.discountRate} != null">
        Promotion: ${event.discountRate}
    </c:if>
        <hr>
</c:forEach>