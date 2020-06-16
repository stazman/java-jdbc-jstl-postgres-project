
	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<header style="display:flex;">	
 
 
 		<div class="container" style="width: 40%; padding-top: 200px; padding-bottom: 200px; margin-right: 10px;">
	
	  		<h3>Tags for this book</h3>
	  		<br>
	  		<table class="table table-striped table-hover table-responsive pubhub-datatable">
		  		<tbody>
			  		<c:forEach var="book_tag" items="${book_tags}">
						<tr>
							<td style="font-size: 26px;"><c:out value="${book_tag.tagName}" /></td>
							<td>
								<form action="RemoveBookTagFromBookServlet" method="post">
									<input type="hidden" name="isbn13" name="isbn13" value="${book_tag.isbn13}">
									<input type="hidden" name="tagName" name="tagName" value="${book_tag.tagName}">
									<button type="submit">Delete</button>
								</form>
							</td>
						</tr>
		         	</c:forEach>
	         	</tbody>
         	</table>
         		
		</div>
				
		
		<div class="container" style="float: left; width: 30%; padding-top: 200px; padding-bottom: 200px; margin-left: 10px;">
		
			<h3>Add a new tag</h3>
			<br>
			<form action="AddTagToBook" method="post" class="form-horizontal">
			  
			  <input type="hidden" class="form-control" id="isbn13" name="isbn13" required="required" value="${param.isbn13}" />
			  
			  <div class="form-group">
			    <!-- <label for="tagName" class="col-sm-4 control-label"></label> -->
			    <div>
			      <input type="text" class="form-control" id="tagName" name="tagName" placeholder="Tag Name" style="width: 60%; margin-left: 100px;" required="required" value="${param.tagName}" />
			    </div>
			  </div>
			  <div class="form-group">
			    <div>
			      <button type="submit" class="btn btn-info">Add Tag</button>
			    </div>
			  </div>
			</form>
		
		</div>
		
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />