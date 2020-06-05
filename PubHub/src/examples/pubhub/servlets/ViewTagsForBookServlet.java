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


@WebServlet("/ViewTagsForBook")
public class ViewTagsForBookServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String isbn13 = request.getParameter("isbn13");
	
	BookTagDAO dao = DAOUtilities.getBookTagDAO();
	List<BookTag> bookTagList = dao.getAllTagsForGivenBook(isbn13);
	
	request.setAttribute("book_tags", bookTagList);
	
	request.getRequestDispatcher("allTagsForGivenBook.jsp").forward(request, response);
	
}

}

