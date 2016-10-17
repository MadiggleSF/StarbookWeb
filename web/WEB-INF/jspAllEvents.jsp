<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Ev�nements</h1>
<div id="allEvent">

    <c:forEach var="event" items="${events}">
        <div class="conteneur">

            <img src="images/${event.picture}" alt="${event.name}_image" height="200" width="140"/>

            <div class="element">
                <a class="eventDetail" href="controllerSeb?section=eventDetail&eventId=${event.id}">${event.name}</a> 
                <h2>D�but:</h2> ${event.start}
                <h2>Fin:</h2> ${event.end}
                <c:if test="${event.discountRate} != null">
                    <h2>Promotion:</h2> ${event.discountRate}
                </c:if>
            </div>
        </div>
        <hr>
    </c:forEach>
</div>