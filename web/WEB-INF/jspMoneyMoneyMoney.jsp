

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Starbook</title>
        <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    </head>
    <body>
         <h1>Validation</h1>

        <p align="center">Validation du panier > Choix de l'adresse > Paiement > <strong>C'est parti !</strong></p>
        
        <p>La commande a été validée !</p>
        <p>Un mail de confirmation ainsi qu'un récapitulatif de vos achats vous a été envoyé à l'adresse
            <br>${cMail}</p>
        
        <p align="center"><a href="">Retour sur le site</a></p>
        <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
    </body>
</html>
