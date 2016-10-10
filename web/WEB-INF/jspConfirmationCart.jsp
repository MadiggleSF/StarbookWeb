<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styleml.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Hello Confirmation Cart Test!</h3>
        <h5><span class="confirmation">Et hop !</span> C'est dans votre panier</h5>

        <!--<p>
            <img src="${i.picture}" class="miniatureflottante" alt="${i.title}" height="68" width="50">
        ${i.title}</p>-->

        <div class="container-img-texte">
            <p class="img-texte">
                <img src="images/hamlet.jpg" class="miniatureflottante" alt="Hamlet" height="68" width="50">
                Titre du livre qui doit être centré : Hamlet !!!
            </p>
        </div> 

        <!-- test -->
        <form method="POST" action="controllerML">
            <input type="hidden" name="section" value="caddy" />
            <input type="hidden" name="clean" value="ok" />
            <input type="submit" name="cleanCart" value="Test CSS"><br>
        </form>
    </body>
</html>
