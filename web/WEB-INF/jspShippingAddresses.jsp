<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h4>Livraison</h4>
        <form name="deliveryForm" action="controllerBen?section=shippingAddresses&selectDelivery=select.value" method="POST">        
            <select name="deliveryList" form="select.value">
                <option> ------------ </option>     
                <c:forEach var="d" items="${adList}">
                    <option>${d.id}. ${d.city}</option>
                </c:forEach>
            </select>             
            <input type="submit" value="OK" name="okDelivery" />
            <p>
                <br>Rue : ${sda.street}
                <br>Code Postal : ${sda.zipcode}
                <br>Ville : ${sda.city}
                <br>Pays : ${sda.country}
                <br>Complément : ${sda.other}
            </p>
        </form>

        <h4>Facturation</h4>
        <form name="billingForm" action="controllerBen?section=shippingAddresses&selectBilling=${b.id}" method="POST">        
            <select name="billingList">
                <option> ------------ </option>     
                <c:forEach var="b" items="${adList}">
                    <option>${b.id}. ${b.city}</option>                    
                </c:forEach>               
            </select>        
            <input type="submit" value="OK" name="okBilling" />
            <p>
                <br>Rue : ${sba.street}
                <br>Code Postal : ${sba.zipcode}
                <br>Ville : ${sba.city}
                <br>Pays : ${sba.country}
                <br>Complément : ${sba.other}
            </p>
        </form>  
            


    </body>
</html>
