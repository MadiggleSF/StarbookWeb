<%-- 
   Gab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/stylegab.css"/>
        <title>JSP Page</title>
       
    </head>
     <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    <body>
        <h1>Inscription</h1>
        <form name="INSCRIPTION" action="controllerGab" method="POST">
            <input type="hidden" name="section" value="signUp" /> 

            <table border="0" cellspacing="10">
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td><input type="text" name="surname" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>Prénom</td>
                        <td><input type="text" name="firstname" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>Mot de Passe</td>
                        <td><input type="password" name="pwd" value="" /></td>
                    <tr>
                        
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="mail" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>Tel portable</td>
                        <td><input type="text" name="cell" value="" /></td>
                    </tr>
                
                    <tr>
                        <td>Tel fixe</td>
                        <td><input type="text" name="landline" value="" /></td>
                    </tr>
                
                    <tr>
                        <td>Date de Naissance</td>
                        <td><input type="text" name="dob_day" value="" size="2" maxlength="2"/>/<input
                    type ="text" name="dob_month" value="" size="2" maxlength="2"/>/<input type =" text"
                    name ="dob_year" value="" size="2" maxlength="4"/></td>
                    </tr>
                 
                
                </tbody>
            </table>
        
        ${msg} 
        
        
        
       
        <br><br><input type="submit" value="Valider" name="Validation" />
        </form>
       
    </body>
     <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
</html>
