<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Adresse de livraison</h3>
        <form name="deliveryForm" action="controllerBen?deliveryChoice" method="POST">        
            <select name="deliveryList">
                <option>-------------</option>            
            </select>        
        <p>
            <br>Rue :
            <br>Code Postal :
            <br>Ville :
            <br>Pays : 
            <br>Complément :
        </p>
        </form>
        
        <h3>Adresse de facturation</h3>
        <form name="billingForm" action="controllerBen?billingChoice" method="POST">
            <select name="billingList">
                <option>-------------</option>
            </select>        
        <p>
            <br>Rue :
            <br>Code Postal :
            <br>Ville :
            <br>Pays : 
            <br>Complément :
        </p>
        </form>


    </body>
</html>
