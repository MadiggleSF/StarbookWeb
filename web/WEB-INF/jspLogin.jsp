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
        <title>JSP Page</title>
       
    </head>
    <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    <body>
        <h1>Connexion</h1>
        <form method="POST" action="controllerGab" name ="CONNEXION">
            <input type="hidden" name="section" value="login" />

            <table id="loginFrame" border="0" cellspacing="10">
            <!--V2<table id="loginFrame">-->
                <tbody>
                    <tr>
                        <td class="fieldLogin">Email</td>
                        <td class="inputLogin"><input type="text" name="login" value="${login}"/></td>
                    </tr>
                    <tr>
                        <td class="fieldLogin">Mot de passe</td>
                        <td class="inputLogin"><input type="password" name="password" value=""/></td>
                    </tr>
                </tbody>
            </table>

            ${msg}
            <br><br><input type="submit" value="Se connecter" name="Connexion"/><br><br>
            <a href="controllerGab?section=signUp">S'inscrire</a>
        </form> 
            
       
    </body>
     <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
</html>


