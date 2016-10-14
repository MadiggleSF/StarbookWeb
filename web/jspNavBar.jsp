<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sideBar">
    <ul class="menuGroup">
        <c:forEach var="genre" items="${genreList}">
            <li class="menuItem"><a href="controllerSeb?section=genreDetail&genreName=${genre.id}">${genre.name}</a></li>
        </c:forEach>
    </ul>
</div>