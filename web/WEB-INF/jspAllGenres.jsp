<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="genre" items="${genres}">
    <a href="controllerSeb?section=genreDetail&genreName=${genre.name}">${genre.name}</a><br>
</c:forEach>