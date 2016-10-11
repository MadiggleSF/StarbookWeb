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

        <p align="center">Validation du panier > <strong>Choix de l'adresse</strong> > Paiement > C'est parti !</p>

        <p><font color="red">${oMsgs}</font></p>
        
        <h3>Choix de l'adresse</h3>

        <h4>Livraison</h4>
        <form name="deliveryForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="deliveryList">
                <option> ------------ </option>     
                <c:forEach var="d" items="${adList}">
                    <option value="${d.id}">${d.id}. ${d.city}</option>
                </c:forEach>
            </select>             
            <input type="submit" value="OK" name="okDelivery" />
            <table border="0" cellspacing="10">               
                <tbody>
                    <tr>
                        <td></td>
                        <td>Adresse #${sda.id}</td>
                    </tr>
                    <tr>                        
                        <td>Rue</td>
                        <td><input type="text" name="sdaStreet" value="${sda.street}" /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="sdaCity" value="${sda.city}" /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="sdaZipcode" value="${sda.zipcode}" /></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="sdaCountry" value="${sda.country}" /></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="sdaOther" rows="4" cols="20">
                            </textarea></td>

                    </tr>
                </tbody>
            </table>

        </form>


        <h4>Facturation</h4>
        <form name="billingForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="billingList">
                <option> ------------ </option>     
                <c:forEach var="b" items="${adList}">
                    <option value="${b.id}">${b.id}. ${b.city}</option>                    
                </c:forEach>               
            </select>        
            <input type="submit" value="OK" name="okBilling" />
            <table border="0" cellspacing="10">               
                <tbody>
                    <tr>
                        <td></td>
                        <td>Adresse #${sba.id}</td>
                    </tr>
                    <tr>
                        <td>Rue</td>
                        <td><input type="text" name="sbaStreet" value="${sba.street}" /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="sbaCity" value="${sba.city}" /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="sbaZipcode" value="${sba.zipcode}" /></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="sbaCountry" value="${sba.country}" /></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="sbaOther" rows="4" cols="20">
                            </textarea></td>

                    </tr>
                </tbody>
            </table>
        </form>

        <p><font color="red">${oMsgs}</font></p>            

        <p align="center"><a href="controllerBen?section=payment">Suivant</a></p>


    </body>
</html>
