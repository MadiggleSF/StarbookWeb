
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <link rel="stylesheet" href="css/stylegab.css"/>
        <title>JSP Page</title>
        
   
    </head>
    
    
    <body>
        <jsp:include page="/WEB-INF/jspNavBar.jsp" flush="true"/>
         <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
          <div id ="signupvalidation">
        <h1>Merci! Votre inscription a bien été validée !</h1>
        <a class ="menuItem" href = "controllerGab?section=homepage">Retour Accueil</a>
          </div>
          <%--<jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>--%>
    </body>
   
</html>
