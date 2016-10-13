

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Starbook</title>
        <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
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
                        <td><select name="monthList">
                                <option name="1">Janv</option>
                                <option name="2">Fev</option>
                                <option name="3">Mars</option>
                                <option name="4">Avr</option>
                                <option name="5">Mai</option>
                                <option name="6">Juin</option>
                                <option name="7">Juil</option>
                                <option name="8">Aout</option>
                                <option name="9">Sept</option>
                                <option name="10">Oct</option>
                                <option name="11">Nov</option>
                                <option name="12">Dec</option>
                            </select>
                            / 
                            <select name="yearList">
                                <option>2017</option>
                                <option>2018</option>
                                <option>2019</option>
                                <option>2020</option>
                                <option>2021</option>
                                <option>2022</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Cryptogramme</td>
                        <td><input type="text" name="ccCrypto" value="" size="3" maxlength="3"/></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <input type="submit" name="okPayment" value="Validation" />
        </form>

        <p><font color="red">${pMsgs}</font></p>
        <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
    </body>

</html>
