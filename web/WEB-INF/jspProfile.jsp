<%-- 
    Document   : jspProfile
    Created on : 12 oct. 2016, 11:13:50
    Author     : cdi307
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Profil</h1>
        
        
        <h2>Informations</h2>
        <form name="INSCRIPTION" action="controllerGab" method="POST">
        <input type="hidden" name="section" value="signUp" /> 
        <table border="0" cellspacing="10">
                <tbody>
                    <tr>
                        <td>Nom</td>
                        <td><input type="text" name="surname" value="${c.surname}" /></td>
                    </tr>
                    
                    <tr>
                        <td>Prénom</td>
                        <td><input type="text" name="firstname" value="${c.firstname}" /></td>
                    </tr>
                    
                   
                        
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="mail" value="${c.mail}" /></td>
                    </tr>
                    
                    <tr>
                        <td>Tel portable</td>
                        <td><input type="text" name="cell" value="${c.cell}" /></td>
                    </tr>
                
                    <tr>
                        <td>Tel fixe</td>
                        <td><input type="text" name="landline" value="${c.landline}" /></td>
                    </tr>
                
                    <tr>
                        <td>Date de Naissance</td>
                        <td><input type="text" name="dob_day" value="" size="2" maxlength="2"/>/<input
                    type ="text" name="dob_month" value="" size="2" maxlength="2"/>/<input type =" text"
                    name ="dob_year" value="" size="2" maxlength="4"/></td>
                    </tr>
                 
                
                </tbody>
            </table>
          </form>
        
        <br><br>
        
        <h2>Adresses</h2>
        <h4>Livraison</h4>
        <form name="deliveryForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="deliveryList">  
                <c:forEach var="d" items="${adList}">
                    <option value="${d.id}">${d.street} (${d.city})</option>
                </c:forEach>
                
            </select>             
           
            <table border="0" cellspacing="10">               
                <tbody>
                    <tr>                        
                        <td>Rue</td>
                        <td><input type="text" name="sdaStreet" value="${sda.street}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="sdaCity" value="${sda.city}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="sdaZipcode" value="${sda.zipcode}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="sdaCountry" value="${sda.country}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="sdaOther" rows="4" cols="23" readonly="readonly">
                            </textarea></td>

                    </tr>
                    
                <input type="submit" value="Modifier" name="Modifier Livraison" />
                </tbody>
            </table>

        </form>


        <h4>Facturation</h4>
        <form name="billingForm" action="controllerBen?section=shippingAddresses" method="POST">        
            <select name="billingList">
                   
                <c:forEach var="b" items="${adList}">
                    <option value="${b.id}">${b.street} (${b.city})</option>                    
                </c:forEach>               
            </select>        
            
            <table border="0" cellspacing="10">               
                <tbody>         
                    <tr>
                        <td>Rue</td>
                        <td><input type="text" name="sbaStreet" value="${sba.street}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="sbaCity" value="${sba.city}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="sbaZipcode" value="${sba.zipcode}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="sbaCountry" value="${sba.country}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="sbaOther" rows="4" cols="23" readonly="readonly">
                            </textarea></td>

                    </tr>
                    
                    
                <input type="submit" value="Modifier" name="Modifier Facturation" />    
                </tbody>
            </table>
        </form>
        
        <br><br>
        
        
        <h2>Historique des commandes</h2>
        
    
        
         <table border="0" cellspacing="10">
                <thead>
                    <tr>
                        <th><strong>Article</strong></th>
                        <th><strong>ISBN</strong></th>
                        <th><strong>Prix unitaire</strong></th>
                        <th><strong>Dont taxe</strong></th>
                        <th><strong>Quantité</strong></th>
                        <th><strong>Réduction</strong></th>                    
                        <th><strong>Prix</strong></th>
                    </tr>
                </thead>


                <c:forEach var="cl" items="${order}">
                    <tbody>
                        <tr>
                            <td>${cl.title}</td>
                            <td>${cl.isbn}</td>
                            <td>${cl.bookTaxedPrice} €</td>
                            <td></td>
                            <td>${cl.qty}</td>
                            <td>- ${cl.discountRate} €</td>
                            <td>${cl.finalLinePrice} €</td>                       
                        </tr>

                    </c:forEach>
                    <c:if test="${shippingType!=null}">
                        <tr>
                        <td></td>
                        <td></td>
                        <td>Livraison :</td>
                        <td></td>
                        <td>${shippingType}</td>
                        <td></td>
                        <td>0.00 €</td>
                    </tr>
                    </c:if>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong>TOTAL :</strong></td>
                        <td></td>
                        <td><strong>${orderQty}</strong></td>
                        <td></td>
                        <td><strong>${orderPrice} €</strong></td>
                    </tr>
                </tbody>
            </table>

        </c:if>

        <br><br>
        
        <h2>Commentaires</h2>
        
        <%--jsp include review--%>
        
        
        
        <br><br>
        
    </body>
</html>
