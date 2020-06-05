	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<header>
	
<!-- 	<h3> Tags for ${book} </h3>

 -->	<div class="container">
	
	  		<c:forEach var="book_tag" items="${book_tags}">
				<p><c:out value="${book_tag}" /></p>
  			</c:forEach>
	
	  </div>
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />