<%-- 
    Document   : jspPayment
    Created on : 10 oct. 2016, 14:52:52
    Author     : cdi313
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Starbook</title>
    </head>
    <body>
        <h1>Paiement</h1>

        <p align="center">Validation du panier > Choix de l'adresse > <strong>Paiement</strong> > C'est parti !</p>

        <h3>Récapitulatif</h3>
        <jsp:include page="/controllerBen?section=displayOrder" flush="true"/>

        <h3>Adresses</h3>

        <h4>Livraison</h4>
        <p>
            ${sda.street} <br>
            ${sda.zipcode} ${sda.city} <br>
            ${sda.country}
        </p>
        <h4>Facturation</h4>
        <p>
            ${sba.street} <br>
            ${sba.zipcode} ${sba.city} <br>
            ${sba.country}
        </p>

        <h3>Méthode de paiement</h3>
        <select name="cardType">
            <option value="mastercard">Mastercard</option>
            <option value="visa">Visa</option>
            <option value="amex">American Express</option>
        </select>
        
        <table border="1" cellspacing="10">
            <tbody>
                <tr>
                    <td>Titulaire</td>
                    <td><input type="text" name="cardOwner" value="" /></td>
                </tr>
                <tr>
                    <td>Numéro de carte</td>
                    <td><input type="text" name="cardNumber" value="" /></td>
                </tr>
                <tr>
                    <td>Expiration</td>
                    <td><input type="text" name="cardMonth" value="MM" /> / <input type="text" name="cardYear" value="AAAA" /></td>
                </tr>
                <tr>
                    <td>Cryptogramme</td>
                    <td><input type="text" name="cardCrypto" value="" /></td>
                </tr>
            </tbody>
        </table>

        
        <a href="">Validation</a>
    </body>
</html>
