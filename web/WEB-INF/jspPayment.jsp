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

        <p><font color="red">${pMsgs}</font></p>

        <h3>Récapitulatif</h3>
        <jsp:include page="/controllerBen?section=displayOrder" flush="true"/>
        <hr>
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
        <hr>
        <h3>Méthode de paiement</h3>

        <form action="controllerBen?section=paymentCheck" method="POST">

            <table border="0" cellspacing="10">
                <tbody>
                    <tr>
                        <td></td>
                        <td>
                            <select name="cardType">
                                <option value="mastercard">Mastercard</option>
                                <option value="visa">Visa</option>
                                <option value="amex">American Express</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Titulaire</td>
                        <td><input type="text" name="ccOwner" value="" size="35"/></td>
                    </tr>

                    <tr>
                        <td>Numéro de carte</td>
                        <td><input type="text" name="ccNumber" value="" size="35" /></td>
                    </tr>
                    <tr>
                        <td>Expiration</td>
                        <td><input type="text" name="ccExpM" value="MM" size="2" maxlength="2"/> / <input type="text" name="ccExpY" value="AAAA" size="4" maxlength="4"/></td>
                    </tr>
                    <tr>
                        <td>Cryptogramme</td>
                        <td><input type="text" name="ccCrypto" value="" size="3" maxlength="3"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="okPayment" />
        </form>

        <p><font color="red">${pMsgs}</font></p>

        <p align="center"><a href="controllerBen?section=paymentCheck">Validation</a></p>
    </body>

</html>
