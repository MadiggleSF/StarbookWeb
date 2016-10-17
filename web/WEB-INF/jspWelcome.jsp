<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <link rel="stylesheet" href="css/stylegab.css"/>
        <title>Starbook</title>
    <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    </head>
    <jsp:include page="/WEB-INF/jspNavBar.jsp" flush="true"/>
    <body>
        <div id="welcome">
        <h1>Welcome ${welcome}!</h1>
        <a class ="menuItem" href="controllerGab?section=monProfil">Mon Profil</a><br><br>
        <br><a class ="menuItem" href="controller?section=login&deconnect">Deconnexion</a>
        </div>   
        <%--<jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>--%>
    </body>
    
</html>
