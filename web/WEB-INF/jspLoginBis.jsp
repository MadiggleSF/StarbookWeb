<%-- 
   Gab
Copie de la jsplogin qui s'affichera au centre de la page lq l'utilisateur ne 
s'est ni encore inscrit ni encore connecté
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
        <form method="POST" action="controller" name ="CONNEXION_BIS">
            <input type="hidden" name="section" value="login" />
            Login : <input type="text" name="connection_login_bis" value="${login}" /><br><br>
            Mot de passe : <input type="password" name="connection_password_bis" value="${password}"/><br><br>
            <br><input type="submit" value="Se connecter" name="Connexion_bis" />
            <br><a href="controllerGab?section=signUp">S'inscrire</a>
        </form>
${msg}
    
    </body>
    <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
</html>

