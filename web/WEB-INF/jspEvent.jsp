<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>

${event.name}<br>
D�but: ${event.start}<br>
Fin: ${event.end}<br>
<c:if test="${event.discountRate} != null">
Promotion: ${event.discountRate}
</c:if>
<h1>Livres pr�sent�s:</h1>
<hr>
<jsp:include page="/WEB-INF/jspCatalog.jsp" flush="true"/>

<jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>