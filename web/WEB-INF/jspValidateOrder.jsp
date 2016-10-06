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
     
        

        <a href="">Retour à la modification</a>

        <h3>Méthode de livraison</h3>
        
        <form name="shippingMethod" action="controllerBen?shippingMethod" method="POST">
            <select name="shippingMethodList" size="1">
                <option selected value="noShipping"> ---------- </option>
                <option value="colissimo">Colissimo</option>
                <option value="chronopost">Chronopost</option>
                
            </select>
            <p>${shippingmsg}</p>
        </form>
        
        
        
        
        <h3>Adresse de livraison</h3>
        <p>
            
        </p>    

        <h3>Adresse de facturation</h3>
        <p>            
        </p>

        <a href="">Paiement</a>
    </body>
</html>
