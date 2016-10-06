<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<img src="images/${book.picture}"  alt="authorImage"  height="200" width="140"/><br>
${book.title}
<c:if test="${book.subtitle} != null">
    /${book.subtitle}
</c:if>
<br>
${book.author.firstname} ${book.author.surname}<br>
${book.idiom}/${book.print}/${book.date}<br>
${book.summary}<br>
Prix: ${book.price} euros<br>
Stock: ${book.quantity}<br>
Pages:${book.pages}<br>
Poids:${book.weight}<br>


