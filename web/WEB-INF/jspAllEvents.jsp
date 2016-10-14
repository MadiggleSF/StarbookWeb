<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="allEvent">
    <h1>Evénement</h1>
    <c:forEach var="event" items="${events}">
        <img src="images/${event.picture}" alt="${event.name}_image" height="200" width="140"/>
        <div id="eventInfo">
            <a class="eventDetail" href="controllerSeb?section=eventDetail&eventId=${event.id}">${event.name}</a> 
            <h2>Début:</h2> ${event.start}
            <h2>Fin:</h2> ${event.end}
            <c:if test="${event.discountRate} != null">
                <h2>Promotion:</h2> ${event.discountRate}
            </c:if>
        </div>
        <br>
        <br>
        <br>
        <hr>
    </c:forEach>
</div>