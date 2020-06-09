package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

@WebServlet("/ViewBooksWithGivenTag")
public class ViewBooksWithGivenTagServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tagName = request.getParameter("tagName");
		
		BookTagDAO dao = DAOUtilities.getBookTagDAO();
		
		List<BookTag> books = dao.getBooksWithGivenTag(tagName);
		
		request.setAttribute("books", books);
		
		request.getRequestDispatcher("allBooksWithGivenTag.jsp").forward(request, response);	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("allBooksWithGivenTag.jsp").forward(request, response);	
		
	}

}