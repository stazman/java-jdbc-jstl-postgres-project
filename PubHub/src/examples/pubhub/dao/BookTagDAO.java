package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public interface BookTagDAO {
	
	public List<BookTag> getAllTagsForGivenBook(String isbn);
	public List<BookTag> getBooksWithGivenTag(String tag_name);
	public List<BookTag> addTagToBookByIsbn (String isbn, String tag_name);
	public List<BookTag> deleteTagFromBookByIsbn (String isbn, String tag_name);
}

