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
            <select name="deliveryList" >
                <option value="${sda.id}" selected>-> ${sda.street} (${sda.city})</option>                  
                <c:forEach var="d" items="${adList}">
                    <option value="${d.id}">${d.street} (${d.city})</option>
                </c:forEach>
            </select>

            <br>
            <input type="submit" value="Sélectionner" name="okDelivery" />


            <table border="0" cellspacing="10">               
                <tbody>
                    <tr>                        
                        <td>Rue</td>
                        <td><input type="text" name="sdaStreet" value="${sda.street}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="sdaCity" value="${sda.city}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="sdaZipcode" value="${sda.zipcode}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="sdaCountry" value="${sda.country}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="sdaOther" rows="4" cols="23" readonly="readonly" >
                            </textarea></td>

                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Modifier" name="modDelivery" />
            <input type="submit" value="Supprimer" name="delDelivery" />

        </form>


        <h4>Facturation</h4>
        <form name="billingForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="billingList">
                <option value="${sba.id}" selected>-> ${sba.street} (${sba.city}</option>
                <c:forEach var="b" items="${adList}">                    
                    <option value="${b.id}">${b.street} (${b.city})</option>                    
                </c:forEach>               
            </select>
            <br>
            <input type="submit" value="Sélectionner" name="okBilling" />     

            <table border="0" cellspacing="10">               
                <tbody>         
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
                        <td><textarea name="sbaOther" rows="4" cols="23">
                            </textarea></td>

                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Modifier" name ="modBilling" />
            <input type="submit" value="Supprimer" name ="delBilling" />
        </form>

        <a href="javascript:window.open('jspNewAddress.jsp','popup','width=400,height=600,left=50,to p=50,scrollbars=1')">Ajouter une adresse</a>

        <p><font color="red">${oMsgs}</font></p>            

        <p align="center"><a href="controllerBen?section=payment">Suivant</a></p>


    </body>
</html>
