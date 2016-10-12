

<form method="POST" action="controllerSeb">
    <input type="hidden" name="section" value="search"/>
    
    Recherche: <input type="text" name="search" value=""/>
    <select name="searchCategory">
        <option value="title">Titre</option>
        <option value="author">Auteur</option>
        <option value="isbn">ISBN</option>
    </select>
    <%--Titre:<input type="radio" name="buttonGroup01" value="title" checked="checked" />
    Auteur:<input type="radio" name="buttonGroup01" value="author" />
    ISBN:<input type="radio" name="buttonGroup01" value="isbn" />--%>

    <input type="submit" name="sendResearch" value="Ok"/>
</form>
