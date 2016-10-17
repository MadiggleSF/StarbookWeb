<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Tester si le panier est vide ou pas : prendre un IF DE JSTL sur la palette; ça va rajouter le taglib --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <link rel="stylesheet" href="css/styleseb.css"/>
        <title>Starbook</title>
        <jsp:include page="jspHeader.jsp" flush="true"/>
    </head>
    <body> 
        <jsp:include flush="true" page="jspNavBar.jsp"/>
        <h1>${event.name}</h1><br>
        <div id="eventDates">
            
            <h2>Début:</h2> ${event.start}<br>
            <h2>Fin:</h2> ${event.end}<br>
            <c:if test="${event.discountRate} != null">
                Promotion: ${event.discountRate}
            </c:if>
        </div>
        <h1>Livres présentés:</h1>
        <hr>
        <jsp:include page="/WEB-INF/jspCatalog.jsp" flush="true"/>

        <jsp:include page="jspFooter.jsp" flush="true"/>
    </body>

</html>