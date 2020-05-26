package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public interface BookTagDAO {
	
	public List<BookTag> getAllTagsForGivenBook(String isbn13);
	public List<BookTag> getBooksWithGivenTag(String tagName);
	public List<BookTag> addTagToBookByIsbn(String isbn, String tagName);
	public boolean deleteTagFromBookByIsbn(String isbn13, String tagName);
}

