<jsp:include page="/WEB-INF/jspHeader.jsp" flush="true"/>

<h1>${author.surname} ${author.firstname}</h1><br>
<h2>${author.dob}/${author.dod}</h2><br>

<jsp:include flush="true" page="jspCatalog.jsp"/>
<jsp:include page="/WEB-INF/jspFooter.jsp" flush="true"/>