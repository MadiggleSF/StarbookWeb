<<<<<<< HEAD
<header>
    <div id="titrePrincipal">
        <h1>Starbook</h1>
        <img id="logo" src="images/starbook_logo.jpg" alt="superlogo"/>
    </div>

    <jsp:include page="jspLogin.jsp" flush="true"/>
    <jsp:include page="jspSearch.jsp" flush="true"/>

    <nav>
        <ul>
            <li><a href="controllerSeb">Accueil</a></li>
            <li><a href="controllerSeb?section=rayons">Rayons</a><br></li>
            <li><a href="controllerSeb?section=events">Event</a><br></li>
            <li><a href="controllerML?section=DisplayCaddy">Panier</a></li>
        </ul>
    </nav>
</header>