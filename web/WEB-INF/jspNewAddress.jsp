<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="newForm" action="controllerBen?section=newAddress" method="POST">        
                      
            <input type="checkbox" name="daNew" value="ON" checked="checked" />
            <input type="checkbox" name="baNew" value="ON" checked="checked" />
            
            <table border="0" cellspacing="10">               
                <tbody>
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
            <input type="submit" value="Ajouter" name="okNew" />
        </form>
    </body>
</html>
