	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
	  
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>PUBHUB <small>Book Publishing</small></h1>
		<hr class="book-primary">

		<table class="table table-striped table-hover table-responsive pubhub-datatable">
			<thead>
				<tr>
					<td>ISBN-13:</td>
					<td>Title:</td>
					<td>Author:</td>
					<td>Publish Date:</td>
					<td>Price:</td>
					<!-- <td>Tags:</td> -->
				</tr>
			</thead>
			<tbody>
			
			<!-- What does this represent??? Check videos -->
			
				<c:forEach var="book" items="${books}">
					<tr>
						<td><c:out value="${book.isbn13}" /></td>
						<td><c:out value="${book.title}" /></td>
						<td><c:out value="${book.author}" /></td>						
						<td><fmt:formatNumber value="${book.price }" type="CURRENCY"/></td>
						
						
						<!-- 

						Not <td><c:out value="${book.tags}" /></td>
						
						// BREAK
						
						// if (getBookByIsbn13.isbn13 == book.isbn13)
						
								loop over tag names (getBookByIsbn13.tag_name)
								
								return and display tag names
								
								continue
								
								
							else 
							
								
								continue
								

						 -->
					
						
						<td><form action="DownloadBook" method="get">
								<input type="hidden" name="isbn13" value="${book.isbn13}">
								<button class="btn btn-success">Download</button>
							</form></td>
						<td><form action="ViewBookDetails?isbn=${book.isbn13}" method="get">
								<input type="hidden" name="isbn13" value="${book.isbn13}">
								<button class="btn btn-primary">Details</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	  </div>
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />