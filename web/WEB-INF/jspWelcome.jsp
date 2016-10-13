<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/stylegab.css"/>
        <title>JSP Page</title>
    </head>
    <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    <body>
        <h1>Welcome ${welcome}!</h1>
        <a href="controllerGab?section=monProfil">Mon Profil</a><br><br>
        <br><a href="controller?section=login&deconnect">Deconnexion</a>
    </body>
    <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
</html>
