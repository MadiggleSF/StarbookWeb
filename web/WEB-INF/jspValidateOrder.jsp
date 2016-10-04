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
        <jsp:include page="/controller?section=displayOrder" flush="true"/>
    <c:forEach var="i" items="${orderLines}">
        ${i.title} 
        (ISBN : ${i.isbn}) 
        Prix unitaire : ${i.bookTaxedPrice} 
        Quantité : ${i.qty}
        Prix : ${i.finalLinePrice}
    </c:forEach> 
        
        
        <a href="">Retour à la modification</a>
        
        <h3>Méthode de livraison</h3>
        <form name="ShippingType" action="controllerBen" method="POST">
            <select name="ShippingTypeList" size="1">
                <option> ---------- </option>
                <option>Colissimo</option>
                <option>Chronopost</option>
            </select>
        </form>
        
        <h3>Adresse de livraison</h3>
        
        <h3>Adresse de facturation</h3>
        
        <a href="">Paiement</a>
    </body>
</html>
