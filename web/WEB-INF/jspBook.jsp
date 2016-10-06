<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

${book.picture}<br>
${book.title}/${book.subtitle}<br>
${book.author}<br>
${book.idiom}/${book.print}/${book.date}<br>
${book.summary}<br>
Prix: ${book.price} euros<br>
<c:if test="${book.quantity}>0">En Stock</c:if><br>
Pages:${book.pages}<br>
Poids:${book.weight}<br>


