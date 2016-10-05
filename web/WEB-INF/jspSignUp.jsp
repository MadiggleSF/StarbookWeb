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
        <h1>Inscription</h1>
        <form name="INSCRIPTION" action="controllerGab" method="POST">
            <input type="hidden" name="section" value="signUp" /> 
            Nom:<input type="text" name="surname" value="${surname}" /><br><br>
            Prénom:<input type="text" name="firstname" value="${firstname}" /><br><br>
            Mot de Passe:<input type="pwd" name="password" value="${pwd}" /><br><br>
            Email: <input type="text" name="mail" value="${mail}" /><br><br>
            Tel portable: <input type="text" name="cell" value="${cell}" /><br><br>
            Tel fixe: <input type="text" name="landline" value="${landline}" /><br><br>
            Date de Naissance: <input type="text" name="dob" value="${dob}"/><br><br>
            <br><input type="submit" value="Valider" name="Validation" />
            
            
            
        </form>
    ${msg}        
    </body>
</html>
