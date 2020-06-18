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
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookTagDAO db = DAOUtilities.getBookTagDAO();

		String isbn13 = request.getParameter("isbn13");
		String tagName = request.getParameter("tagName");
		
		boolean isSuccess = db.addTagToBookByIsbn(isbn13, tagName);
		
		if(isSuccess){
			request.getSession().setAttribute("message", "Tag added");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect(request.getContextPath() + "/BookPublishing");
		} else {
			request.getSession().setAttribute("message", "There was a problem adding the tag");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("bookPublishingHome.jsp").forward(request, response);
		}
		
	}
}