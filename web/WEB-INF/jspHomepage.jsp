<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Tester si le panier est vide ou pas : prendre un IF DE JSTL sur la palette; ça va rajouter le taglib --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <link rel="stylesheet" href="css/styleseb.css"/>
        <title>JSP Page</title>
        <jsp:include page="jspHeader.jsp" flush="true"/>
    </head>
    <body> 
        <jsp:include flush="true" page="jspAllEvents.jsp"/>

        <jsp:include page="jspFooter.jsp" flush="true"/>
    </body>
</html>
