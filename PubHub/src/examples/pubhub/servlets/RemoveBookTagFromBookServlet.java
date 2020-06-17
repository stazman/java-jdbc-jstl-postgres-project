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
		
		boolean isSuccess = db.deleteTagFromBookByIsbn(isbn13, tagName);
		
		if(isSuccess){
			request.getSession().setAttribute("message", "Tag removed");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect(request.getContextPath() + "/BookPublishing");
		} else {
			request.getSession().setAttribute("message", "There was a problem removing the tag");
			request.getSession().setAttribute("messageClass", "alert-danger");
			request.getRequestDispatcher("bookPublishingHome.jsp").forward(request, response);
		}
		
	}

}
