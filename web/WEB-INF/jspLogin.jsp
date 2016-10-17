<%-- 
   Gab
--%>

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
    
    <body>
     <jsp:include page="/WEB-INF/jspNavBar.jsp" flush="true"/>
        <div id="login">
            <h1>Connexion</h1>
            <form method="POST" action="controllerGab" name ="CONNEXION">
                <input type="hidden" name="section" value="login" />

                <table border="0" cellspacing="10">

                    <tbody>
                        <tr>
                            <td>Email</td>
                            <td><input type="text" name="login" value="${login}"/></td>
                        </tr>
                        <tr>
                            <td>Mot de passe</td>
                            <td><input type="password" name="password" value=""/></td>
                        </tr>
                    </tbody>
                </table>

                ${msg}
                <br><br><input type="submit" value="Se connecter" name="Connexion"/><br><br>
                <a class ="menuItem" href="controllerGab?section=signUp">S'inscrire</a>
            </form> 
        </div>
    </body>
    <%--<jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/> --%>
</html>


