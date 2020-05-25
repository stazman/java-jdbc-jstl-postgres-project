package examples.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

public class BookTagDAOImpl implements BookTagDAO {
	
	Connection connection = null;
	PreparedStatement stmt = null;

	
	@Override
	public List<BookTag> getAllTagsForGivenBook(String isbn13) {
		
		List<BookTag> bookTags = new ArrayList<>();
		
		try {
			connection = DAOUtilities.getConnection();
			
			String sql = "SELECT book_tags.tag_name FROM book_tags WHERE isbn_13=?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
//			stmt.setString(2, tagName);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				BookTag bookTag = new BookTag();
				
				bookTag.setIsbn13(isbn13);

//				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setTagName(rs.getString("tag_name"));
				
				bookTags.add(bookTag);
				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	
		return bookTags;
	}
	
	
	
//	--------------------------------------------------------------------------------------------------------------------

	
	public List<BookTag> getBooksWithGivenTag(String isbn13) {
		
		List<BookTag> bookTags = new ArrayList<>();
		
//		List<Book> books = new ArrayList<>();
		
 
		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT book_tags.tag_name \n" + 
					"	FROM book_tags\n" + 
					"	INNER JOIN books \n" + 
					"	ON book_tags.isbn_13 = books.isbn_13\n" + 
					"	WHERE book_tags.isbn_13=?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			
			//????
			//SetString with book table properties??
			//try catch block for book but don't close ???
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				BookTag bookTag = new BookTag();
 
//				bookTag.setIsbn13(rs.getString("isbn_13"));
				bookTag.setTagName(rs.getString("tag_name"));
				
				bookTags.add(bookTag);		
			}
			
			//use if books.isbn_13 == bookTags.isbn_13 etc. ???
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return bookTags;
	}

	
	
	
	
	
//	--------------------------------------------------------------------------------------------------------------------

	
	
	@Override
	public boolean deleteTagFromBookByIsbn(String isbn13, String tagName) {
 
		try {
			connection = DAOUtilities.getConnection();
			
			String sql = "DELETE FROM book_tags WHERE isbn_13=? AND tag_name=?";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			stmt.setString(2, tagName);
			
 
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}

	}

	private void closeResources() {
		
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	
	
}
