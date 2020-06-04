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


@MultipartConfig // This annotation tells the server that this servlet has
// complex data other than forms
//Notice the lack of the @WebServlet annotation? This servlet is mapped the old
//fashioned way - Check the web.xml!
public class ViewTagsForBook extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("allTagsFromGivenBook.jsp").forward(request, response);
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



}

