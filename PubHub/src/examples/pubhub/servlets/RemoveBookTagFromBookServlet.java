package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.utilities.DAOUtilities;

@WebServlet("/RemoveBookTagFromBookServlet")
public class RemoveBookTagFromBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tagName");
		
		BookTagDAO db  = DAOUtilities.getBookTagDAO();
		
		//Needs logic to prevent duplicate entries
		
		db.deleteTagFromBookByIsbn(isbn13, tagName);
		
		//Needs improved navigation to update list
		
		request.getRequestDispatcher("allTagsForGivenBook.jsp").forward(request, response);
		
	}

}
