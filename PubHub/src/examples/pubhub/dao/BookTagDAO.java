package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public interface BookTagDAO {
	
	public List<BookTag> getAllTagsForGivenBook(String isbn13);
	public List<BookTag> getBooksWithGivenTag(String title);
	public List<BookTag> addTagToBookByIsbn(String isbn13, String tagName);
	public boolean deleteTagFromBookByIsbn(String isbn13, String tagName);
}

