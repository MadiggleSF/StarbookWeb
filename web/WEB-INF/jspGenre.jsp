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
        <h1>${genre.name}</h1>
        <hr>
        <jsp:include page="/WEB-INF/jspCatalog.jsp" flush="true"/>
        
        <jsp:include page="jspFooter.jsp" flush="true"/>
    </body>
</html>

