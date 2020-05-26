package examples.pubhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	
	@Override
	public List<BookTag> getBooksWithGivenTag(String title) {
		
		List<BookTag> bookTags = new ArrayList<>();
		
		try {
			connection = DAOUtilities.getConnection();
			
			String sql = "SELECT * FROM books b WHERE b.isbn_13 IN (\n" + 
					"    SELECT bt.isbn_13 FROM book_tags bt WHERE bt.tag_name = ?)";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, title);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				BookTag bookTag = new BookTag();
 
				bookTag.setIsbn13(rs.getString("isbn_13"));
				
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

	
	@Override
	public List<BookTag> addTagToBookByIsbn(String isbn13, String tagName){
		
		List<BookTag> bookTags = new ArrayList<>();
		
		try {
			
			connection = DAOUtilities.getConnection();
			
			String sql = "INSERT INTO book_tags (isbn_13, tag_name) VALUES (?,?)";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, isbn13);
			stmt.setString(2, tagName);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				BookTag bookTag = new BookTag();
				
				bookTag.setIsbn13(rs.getString("isbn_13"));
				
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
		
	};
	
	
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
	
	
//	--------------------------------------------------------------------------------------------------------------------


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
