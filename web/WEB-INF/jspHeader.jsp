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
            <li class="menuItem"><a href="#home">Autobiographie</a></li>
            <li class="menuItem"><a href="#news">Poésie</a></li>
            <li class="menuItem"><a href="#contact">Roman</a></li>
        </ul>
        <!--<nav class="element">
            <ul>
                <li><a href="controllerSeb?section=rayons">Rayons</a><br></li>

            </ul>
        </nav>-->
    </div>
</header>