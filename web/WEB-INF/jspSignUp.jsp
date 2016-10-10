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
            Mot de Passe:<input type="password" name="pwd" value="${pwd}" /><br><br>
            Email: <input type="text" name="mail" value="${mail}" /><br><br>
            Tel portable: <input type="text" name="cell" value="${cell}" /><br><br>
            Tel fixe: <input type="text" name="landline" value="${landline}" /><br><br>
            Date de Naissance (AAAA-MM-JJ):
            <input type="text" name="dob_year" value="${dob_year}" size="2"/>-<input
            type ="text" name="dob_month" value="${dob_month}" size="2"/>-<input type =" text"
            name ="dob_day" value="${dob_day}" size="2"><br><br>                             
            <br><input type="submit" value="Valider" name="Validation" />
            
            
            
        </form>
    ${msg}        
    </body>
</html>
