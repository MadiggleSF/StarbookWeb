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
            Nom:<input type="text" name="surname" value="" /><br><br>
            Prénom:<input type="text" name="firstname" value="" /><br><br>
            Mot de Passe:<input type="password" name="pwd" value="" /><br><br>
            Email: <input type="text" name="mail" value="" /><br><br>
            Tel portable: <input type="text" name="cell" value="" /><br><br>
            Tel fixe: <input type="text" name="landline" value="" /><br><br>
            Date de Naissance :
            <input type="text" name="dob_day" value="JJ" size="2"/>/<input
            type ="text" name="dob_month" value="MM" size="2"/>/<input type =" text"
            name ="dob_year" value="AAAA
            
            
            " size="2"><br><br>                             
            <br><input type="submit" value="Valider" name="Validation" />
            
            
            
        </form>
    ${msg}        
    </body>
</html>
