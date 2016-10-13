<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Starbook</title>
        <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    </head>
    
    <body>
        <h1>Commande</h1>
        
        <p align="center"><strong>Validation du panier</strong> > Choix de l'adresse > Paiement > C'est parti !</p>
        
        <p><font color="red">${oMsgs}</font></p>
        
        <h3>Validation du panier</h3>

        <jsp:include page="/controllerBen?section=displayOrder" flush="true"/>
        

        <a href="controllerML?section=DisplayCaddy">Retour au panier</a>

        <h3>Méthode de livraison</h3>
        
        
        <form name="ShippingType" action="controllerBen?section=shippingType" method="POST">
            <select name="ShippingTypeList" size="1">
                <option value="Colissimo">Colissimo (+0.00 €)</option>
                <option value="Pigeon voyageur">Pigeon voyageur (+0.00 €)</option>
                <option value="Drone">Drone (+0.00 €)</option>
            </select>
      
            <p>${shippingMsg}</p>
        </form>
        
            <p><font color="red">${oMsgs}</font></p>
        
            <p align="center"><a href="controllerBen?section=shippingAddresses">Suivant</a></p>
        
        <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
    </body>
    
</html>
