<header>
    <div class="containerTop">
        <div class="element" id="titrePrincipal">
            <a href="controllerSeb"><img id="logo" src="images/starbook_logoText.png" alt="superlogo" /></a>
        </div>
        <!--<div class="element" id="titrePrincipal">
            <h1>Starbook</h1>-->

        <form class="element" method="POST" action="controllerSeb">
            <input type="hidden" name="section" value="search"/>

            <input type="search" name="search" placeholder="Entrez votre recherche ici" size="70"/>
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
                <li><a href="controllerGab"> Mon compte</a></li>
                <li><a href="controllerML?section=DisplayCaddy"><img src="images/panierIcone.png"></a></li>
                <li><a href="controllerML?section=DisplayCaddy"> Mon panier</a></li>
            </ul>
        </nav>
    </div>    



    <div class="containerBottom">
        <nav class="element">
            <ul>
                <li><a href="controllerSeb?section=rayons">Rayons</a><br></li>
                <li><a href="controllerSeb?section=events">Event</a><br></li>

            </ul>
        </nav>
    </div>
</header>