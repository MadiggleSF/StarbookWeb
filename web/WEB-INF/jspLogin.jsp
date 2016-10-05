<%-- 
   Gab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Connexion</h1>
        <form method="POST" action="controllerGab" name ="CONNEXION">
            <input type="hidden" name="section" value="login" />
            Login : <input type="text" name="login" value="${login}" /><br><br>
            Mot de passe : <input type="password" name="password" value="${password}"/><br><br>
            <br><input type="submit" value="Se connecter" name="Connexion" /><br><br>
            <br><input type="submit" value="S'inscrire" name="Inscription" />
        </form>
    ${msg}
    </body>
</html>

        
   