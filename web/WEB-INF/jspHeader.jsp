<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
    <div class="containerTop">
        <div class="element" id="titrePrincipal">
            <a href="controllerSeb"><img id="logo" src="images/starbook_logoText.png" alt="superlogo" /></a>
        </div>
        <!--<div class="element" id="titrePrincipal">
            <h1>Starbook</h1>-->

        <form class="element" method="POST" action="controllerSeb">
            <input type="hidden" name="section" value="search"/>

            <input type="search" name="search" placeholder="Entrez votre recherche ici" size="65"/>
            <select name="searchCategory">
                <option class="dropdown" value="title">Titre</option>
                <option class="dropdown" value="author">Auteur</option>
                <option class="dropdown" value="isbn">ISBN</option>
            </select>

            <input type="submit" name="sendResearch" value="Rechercher"/>
        </form>


        <nav class="element">
            <ul>
                <li><a href="controllerGab"><img src="images/login.png"></a></li>
                <li class="menuItem"><a id="monCompte" href="controllerGab"> <span class="topMenu">Mon compte</span></a></li>
                <li><a href="controllerML?section=DisplayCaddy"><img src="images/panierIcone.png"></a></li>
                <li class="menuItem"><a id="monPanier" href="controllerML?section=DisplayCaddy"> <span class="topMenu">Mon panier</span></a></li>
            </ul>
        </nav>
    </div>    



    <div class="sideBar">
        <ul class="menuGroup">
            <c:forEach var="genre" items="${genreList}">
                <li class="menuItem"><a href="controllerSeb?section=genreDetail&genreName=${genre.id}">${genre.name}</a></li>
            </c:forEach>
        </ul>
        <!--<nav class="element">
            <ul>
                <li><a href="controllerSeb?section=rayons">Rayons</a><br></li>

            </ul>
        </nav>-->
    </div>
</header>