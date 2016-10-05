<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        
        <table border="0" cellspacing="10">
            <thead>
                <tr>
            
                    <th><b>Article</b></th>
                    <th><b>ISBN</b></th>
                    <th><b>Prix unitaire</b></th>
                    <th><strong>Dont taxe</strong></th>
                    <th><strong>Quantité</strong></th>
                    <th><strong>Réduction</strong></th>                    
                    <th><strong>Prix</strong></th>
                </tr>
            </thead>



            <c:forEach var="cl" items="${test}">
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
                </tbody>
            </c:forEach>
        </table>
    
        

   