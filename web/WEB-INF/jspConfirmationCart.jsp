<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <title>JSP Page</title>
    </head>
    <body>





        <!-- test 
        <h3>Test bouton</h3>
        <form class="inner" method="POST" action="controllerML">
            <input type="hidden" name="section" value="caddy" />
            <input type="hidden" name="clean" value="ok" />
            <input type="submit" name="cleanCart" value="Test CSS"><br>
        </form>


        <hr>
        <h3>Test tableau</h3>
        <table>
            <tr>
                <th> Aperçu </th>
                <th> Titre </th>
                <th> Quantité </th>
                <th> Prix unitaire </th>
                <th> Sous total </th>
            </tr>


            <tr class="insideTable">
                <td><img src="images/miserables.jpg" alt="Misérables" height="68" width="50"></td>
                <td>Les Misérables</td>  
                <td>2</td> 
                <td>2.50</td>
                <td>5</td>
                <td><a href="controllerML?section=caddy&inc=${i.isbn}"><img alt="+" src="images/Add.png"></a>
                    <a href="controllerML?section=caddy&dec=${i.isbn}"><img alt="-" src="images/button-decrease.png"></a>
                    <a href="controllerML?section=caddy&del=${i.isbn}"><img alt="X" src="images/button-remove.png"></a>
                </td>
            </tr>  
            <tr class="insideTable">
                <td><img src="images/hamlet.jpg" alt=Hamlet height="68" width="50"></td>
                <td>Hamlet</td>  
                <td>1</td> 
                <td>6.99</td>
                <td>6.99</td>
                <td><a href="controllerML?section=caddy&inc=${i.isbn}"><img alt="+" src="images/Add.png"></a>
                    <a href="controllerML?section=caddy&dec=${i.isbn}"><img alt="-" src="images/button-decrease.png"></a>
                    <a href="controllerML?section=caddy&del=${i.isbn}"><img alt="X" src="images/button-remove.png"></a>
                </td>
            </tr>
            <tr class="insideTable">
                <td><img src="images/zola_thereseraquin.jpg" alt="TR" height="68" width="50"></td>
                <td>Thérèse Raquin</td>  
                <td>1</td> 
                <td>2.99</td>
                <td>2.99</td>
                <td><a href="controllerML?section=caddy&inc=${i.isbn}"><img alt="+" src="images/Add.png"></a>
                    <a href="controllerML?section=caddy&dec=${i.isbn}"><img alt="-" src="images/button-decrease.png"></a>
                    <a href="controllerML?section=caddy&del=${i.isbn}"><img alt="X" src="images/button-remove.png"></a>
                </td>
            </tr>

        </table>
  
        <form class="inner" method="POST" action="controllerSeb">
            <input type="hidden" name="section" value="" />
            <input type="submit" name="" value="< Poursuivre vos achats" /><br>
        </form>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <form class="inner" method="POST" action="controllerML">
            <input type="hidden" name="section" value="caddy" />
            <input type="hidden" name="clean" value="ok" />
            <input type="submit" name="cleanCart" value="Passer votre commande" />
        </form>   -->   
        <div class="confirmation"><h5><span class="hop">Et hop !</span> C'est dans votre panier.</h5></div>
        <div id="containerConfirmation">
            <img class="mini" src="images/hamlet.jpg" alt="Hamlet" height="68" width="50"/>
            <span class="titleConfirmation"> Hamlet </span>
            <a href="controllerML"><img class="boutonPanier" src="images/panier.jpg" title="Voir le panier" alt="Voir le panier" height="24" width="24"/></a>
        </div>
    </body>
</html>
