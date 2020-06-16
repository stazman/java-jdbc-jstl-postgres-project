	<jsp:include page="header.jsp" />
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<header style="display: flex;">
	
 		<div class="container" style="aligh-items: center; justify-content: center; width: 40%; padding-top: 250px; padding-bottom: 225px; margin-right: 10px;">
		
			<h3>Search for Books by Tag</h3><br>
				
			<form action="ViewBooksWithGivenTag" method="post" class="form-horizontal">
	 
			  <div class="form-group" style="margin-left: 140px; margin-right: 0;">
<!-- 			    <label for="tagName" class="col-sm-4 control-label"></label>
 -->			<div class="col-sm-8">
			     	<input type="text" class="form-control" id="tagName" name="tagName" placeholder="Type in tag name search term(s)" required="required" value="${param.tagName}" />
			    </div>
			  </div>
			  <div class="form-group" style="margin-left: 140px; margin-right: 0;">
			  	<div class="col-sm-4">
			      <button type="submit" class="btn btn-info">Find Books</button>
			    </div>
			  </div>
			  
			</form><br>
			
		</div>
		
		<div class="container" style="float: left; width: 30%; padding-top: 250px; padding-bottom: 225px; margin-left: 10px;">
			
			<h3>Books with your tag (ISBN):</h3><br>
			
			<table class="table table-striped table-hover table-responsive pubhub-datatable">
		  		<tbody>
		  			<c:forEach var="book" items="${books}">
	  					<tr>
							<td><c:out value="${book.isbn13}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</div>
	
	</header>

	<!-- Footer -->
	<jsp:include page="footer.jsp" />