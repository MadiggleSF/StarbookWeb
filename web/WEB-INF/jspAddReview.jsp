<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="POST" action="controllerSeb">

    <h1>Ajouter un commentaire</h1>
    <textarea name="comment" rows="10" cols="50" >
    </textarea>
    <select name="commentRate" >
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
    </select>
    <input type="submit" name="sendComment" value="Ok"/>
    <input type="hidden" name="section" value="comment"/>
    <input type="hidden" name="book" value="${book.isbn}"/>

</form>