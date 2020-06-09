	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<header>
	
<!-- 	<h3> Tags for ${book} </h3>

 -->	
 
<!--  	Needs styling into table format 
 --> 	
 
 
 		<div class="container">
	
	  		<c:forEach var="book_tag" items="${book_tags}">
	  		
				<p><c:out value="${book_tag.tagName}" /></p>
					
				<form action="RemoveBookTagFromBookServlet" method="post">
					<input type="hidden" name="isbn13" name="isbn13" value="${book_tag.isbn13}">
					<input type="hidden" name="tagName" name="tagName" value="${book_tag.tagName}">
					<button type="submit">Delete</button>
				</form>
					
         	</c:forEach>
	
		</div>
		
<!-- 		Needs styling to be to the right of the results table
 -->		
		
		<div class="container">
		
			<form action="AddTagToBook" method="post" class="form-horizontal">
			  
			  <input type="hidden" class="form-control" id="isbn13" name="isbn13" required="required" value="${param.isbn13}" />
			  
			  <div class="form-group">
			    <label for="tagName" class="col-sm-4 control-label">Tag</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Tag Name" required="required" value="${param.tagName}" />
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-4 col-sm-1">
			      <button type="submit" class="btn btn-info">Add Tag</button>
			    </div>
			  </div>
			</form>
		
		</div>
		
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />