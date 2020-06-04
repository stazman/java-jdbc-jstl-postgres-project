// Goals:

// Get all tags for given book
// Forward to bookDetails JSP



package examples.pubhub.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.dao.BookTagDAOImpl;
import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;


@WebServlet("/ViewTagsForBook")
public class ViewTagsForBookServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String isbn13 = request.getParameter("isbn13");
	
	BookTagDAO dao = DAOUtilities.getBookTagDAO();
	List<BookTag> bookTagList = dao.getAllTagsForGivenBook(isbn13);
	
	request.getSession().setAttribute("book_tags", bookTagList);
	
	request.getRequestDispatcher("allTagsForGivenBook.jsp").forward(request, response);
	
}

}



	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////


//	boolean isSuccess = database.addBook(book);
//
//	if(isSuccess){
//		req.getSession().setAttribute("message", "Book successfully published");
//		req.getSession().setAttribute("messageClass", "alert-success");
//
//// We use a redirect here instead of a forward, because we don't
//// want request data to be saved. Otherwise, when
//// a user clicks "refresh", their browser would send the data
//// again!
//// This would be bad data management, and it
//// could result in duplicate rows in a database.
//		resp.sendRedirect(req.getContextPath() + "/BookPublishing");
//	} else {
//		req.getSession().setAttribute("message", "There was a problem publishing the book");
//		req.getSession().setAttribute("messageClass", "alert-danger");
//		req.getRequestDispatcher("publishBook.jsp").forward(req, resp);
//
//	}





//package examples.pubhub.servlets;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class ViewTagsForBookServlet
// */
//@WebServlet("/ViewTagsForBookServlet")
//public class ViewTagsForBookServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ViewTagsForBookServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
