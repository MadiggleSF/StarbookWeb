
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Search!</h1>
        <form method="POST" action="controllerSeb">
        <input type="hidden" name="section" value="search"/>
        Recherche: <input type="text" name="search" value=""/>
        Titre:<input type="radio" name="buttonGroup01" value="title" checked="checked" />
        Auteur:<input type="radio" name="buttonGroup01" value="author" />
        ISBN:<input type="radio" name="buttonGroup01" value="isbn" />
        
        <input type="submit" name="sendResearch" value="Ok"/>
        <a href="controllerSeb?section=eventDetail&eventId=1">Event</a>
        </form>
        <hr>
        <jsp:include page="/WEB-INF/jspCatalog.jsp"/>
    </body>
</html>
