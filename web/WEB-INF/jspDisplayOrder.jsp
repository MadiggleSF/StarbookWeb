<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:if test="${emptyOrder}">
            <p>Le panier est vide !</p>
        </c:if>

        <c:if test="${!emptyOrder}">

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




