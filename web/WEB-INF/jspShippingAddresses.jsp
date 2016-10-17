<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <title>Starbook</title>
        
    </head>
    <jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>
    <body>
        <h1>Commande</h1>

        <p align="center">Validation du panier > <strong>Choix de l'adresse</strong> > Paiement > C'est parti !</p>

        <p><font color="red">${oMsgs}</font></p>

        <h3>Choix de l'adresse</h3>

        <h4>Livraison</h4>
        <form name="deliveryForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="deliveryList" >
                <c:if test="${sda!=null}">        
                    <option value="${sda.id}" selected>-> ${sda.street} (${sda.city})</option>  
                </c:if>
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
                        <td><input type="text" name="sdaStreet" value="${sda.street}"  /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="sdaCity" value="${sda.city}"  /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="sdaZipcode" value="${sda.zipcode}" /></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="sdaCountry" value="${sda.country}"  /></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="sdaOther" rows="4" cols="23"  >
                            </textarea></td>

                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Enregistrer modifications" name="modDelivery" />
            <input type="submit" value="Supprimer" name="delDelivery" />

        </form>


        <h4>Facturation</h4>
        <form name="billingForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="billingList">
                <c:if test="${sba!=null}">   
                    <option value="${sba.id}" selected>-> ${sba.street} (${sba.city})</option>
                </c:if>
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
            <input type="submit" value="Enregistrer modifications" name ="modBilling" />
            <input type="submit" value="Supprimer" name ="delBilling" />
        </form>
        <br>
        <br>
        <form name="newFormAppears" action="controllerBen?section=shippingAddresses" method="POST">
            <input type="submit" value="Nouvelle adresse ?" name="okNewFormAppears" />
        </form>            
        <c:if test="${showNewForm}" scope="request" var="showNewForm">

            <h4>Nouvelle adresse</h4>
        </c:if>   

        <form name="newForm" action="controllerBen?section=shippingAddresses" method="POST" >   

            <c:if test="${showNewForm}" scope="request" var="showNewForm">
                <table border="0" cellspacing="10">               
                    <tbody>
                        <tr>
                            <td>Livraison</td>
                            <td><input type="checkbox" name="daNew" value="ON" checked="checked" /></td>
                        </tr>
                        <tr>
                            <td>Facturation</td>
                            <td><input type="checkbox" name="baNew" value="ON" checked="checked" /></td>
                        </tr>
                        <tr>                        
                            <td>Rue</td>
                            <td><input type="text" name="naStreet" value=""/></td>
                        </tr>
                        <tr>
                            <td>Ville</td>
                            <td><input type="text" name="naCity" value=""/></td>
                        </tr>
                        <tr>
                            <td>Code postal</td>
                            <td><input type="text" name="naZipcode" value=""/></td>
                        </tr>
                        <tr>
                            <td>Pays</td>
                            <td><input type="text" name="naCountry" value=""/></td>
                        </tr>
                        <tr>
                            <td>Complément</td>
                            <td><textarea name="naOther" rows="4" cols="23">
                                </textarea></td>

                        </tr>
                    </tbody>

                </table>

                <input type="submit" value="Ajouter" name="okNew"/>
            </c:if>
        </form>


        <p><font color="red">${oMsgs}</font></p>            

        <p align="center"><a href="controllerBen?section=payment">Suivant</a></p>

        <jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>
    </body>
    
</html>
