	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<header>
	
		<div class="container">
		
			<h2>Find books with a given tag</h2><br>
		
<!-- 		Form needs to be centered
 -->		
			<form action="ViewBooksWithGivenTag" method="post" class="form-horizontal">
	 
			  <div class="form-group">
			    <label for="tagName" class="col-sm-4 control-label"></label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Type in tag name/keyword" required="required" value="${param.tagName}" />
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-4 col-sm-1">
			      <button type="submit" class="btn btn-info">Find Books</button>
			    </div>
			  </div>
			  
			</form><br>
			
			<h3>Books with your tag (ISBN):</h3><br>
			
			<c:forEach var="book" items="${books}">
	  		
				<p><c:out value="${book.isbn13}" /></p>
					
         	</c:forEach>
		
		</div>
				
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />