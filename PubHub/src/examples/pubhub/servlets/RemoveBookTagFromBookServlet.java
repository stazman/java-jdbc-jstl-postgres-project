package examples.pubhub.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.BookTagDAO;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class RemoveBookTagFromBookServlet
 */
@WebServlet("/RemoveBookTagFromBookServlet")
public class RemoveBookTagFromBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String isbn13 = request.getParameter("isbn13");
		
		String tagName = request.getParameter("tagName");
		
		BookTagDAO dao  = DAOUtilities.getBookTagDAO();
		boolean bookTag = dao.deleteTagFromBookByIsbn(isbn13, tagName);
		
		request.setAttribute("book_tag", bookTag);
		
		
		request.getRequestDispatcher("bookDetails.jsp").forward(request, response);

		
		
		
		
		
		
//		request.setAttribute("tagName", tagName);
		
//		doGet(request, response);
		
		
		
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RemoveBookTagFromBookServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
