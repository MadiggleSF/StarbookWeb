<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Starbook</title>
    </head>
    <body>
      

        <h4>Livraison</h4>
             <form name="Delivery" action="controllerGab" method="POST"> 
             <input type="hidden" name="section" value="signUp" />
             
            <table border="0" cellspacing="10">               
                <tbody>
                  
                    <tr>                        
                        <td>Rue</td>
                        <td><input type="text" name="dStreet" /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="dCity"  /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="dZipcode" /></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="dCountry"/></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="Other" rows="4" cols="20">
                            </textarea></td>

                    </tr>
                </tbody>
            </table>

        </form>


        <h4>Facturation</h4>
        <form name="Billing" action="controllerGab" method="POST">        
        <input type="hidden" name="section" value="signUp" />
          
            <table border="0" cellspacing="10">               
                <tbody>
                   
                        <td>Rue</td>
                        <td><input type="text" name="bStreet"  /></td>
                    </tr>
                    <tr>
                        <td>Ville</td>
                        <td><input type="text" name="bCity" /></td>
                    </tr>
                    <tr>
                        <td>Code postal</td>
                        <td><input type="text" name="bZipcode" /></td>
                    </tr>
                    <tr>
                        <td>Pays</td>
                        <td><input type="text" name="bCountry" /></td>
                    </tr>
                    <tr>
                        <td>Complément</td>
                        <td><textarea name="bOther" rows="4" cols="20">
                            </textarea></td>

                    </tr>
                </tbody>
            </table>
        
        
        
        <br><input type="submit" value="Valider" name="Validation" />
        </form>

     

    </body>
</html>
