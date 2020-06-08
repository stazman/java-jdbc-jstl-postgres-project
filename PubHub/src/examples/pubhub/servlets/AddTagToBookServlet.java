package examples.pubhub.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.utilities.DAOUtilities;

@WebServlet("/AddTagToBook")
public class AddTagToBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("allTagsForGivenBook.jsp").forward(request, response);
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookTagDAO db = DAOUtilities.getBookTagDAO();

		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tagName");
		
		//Add control flow to check for duplicate entries
		
		db.addTagToBookByIsbn(isbn13, tagName);
		
		
		//redirect with new tag shown in list
				
		request.getRequestDispatcher("allTagsForGivenBook.jsp").forward(request, response);
		
//		response.sendRedirect("allTagsForGivenBook.jsp");
		
	}
}