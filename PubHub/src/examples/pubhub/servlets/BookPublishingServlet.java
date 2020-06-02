package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.model.Book;
import examples.pubhub.utilities.DAOUtilities;

/*
 * This servlet will take you to the homepage for the Book Publishing module (level 100)
 */
@WebServlet("/BookPublishing")
public class BookPublishingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response, String String) throws ServletException, IOException {

		// Grab the list of Books from the Database
		
		BookDAO dao = DAOUtilities.getBookDAO();	
		List<Book> bookList = dao.getAllBooks();
		
		request.getSession().setAttribute("books", bookList);
		
		request.getRequestDispatcher("bookPublishingHome.jsp").forward(request, response);
	}
	
	
//	Overload doGet for bookTags???
	
	
			// BREAK
			
			// if (getBookByIsbn13.isbn13 == book.isbn13)
			
//					loop over tag names (getBookByIsbn13.tag_name)
					
//					return and display tag names
					
//					continue
					
					
//				else 
				
					
//					continue
					
			
	
}
