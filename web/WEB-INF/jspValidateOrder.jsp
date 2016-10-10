<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Starbook</title>
    </head>
    <body>
        <h1>Commande</h1>
        
        <h3>Récapitulatif de la commande</h3>

        <jsp:include page="/controllerBen?section=displayOrder" flush="true"/>
     
        

        <a href="">Retour au panier</a>

        <h3>Méthode de livraison</h3>
        
        
        <form name="ShippingType" action="controllerBen?section=shippingType" method="POST">
            <select name="ShippingTypeList" size="1">
                <option value="noShipping"> ----------- </option>
                <option value="colissimo">Colissimo</option>
                <option value="chronopost">Chronopost</option>
            </select>
      
            <p>${shippingMsg}</p>
        </form>

      


        <h3>Adresse</h3>        
        
        <jsp:include page="/controllerBen?section=shippingAddresses"/>  
        

        <a href="">Paiement</a>
    </body>
</html>
