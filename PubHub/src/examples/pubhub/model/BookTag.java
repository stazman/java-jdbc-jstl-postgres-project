package examples.pubhub.model;

public class BookTag {
	
	private String isbn13;
	private String tagName;

	public BookTag() {
		this.isbn13 = null;
		this.tagName = null;
		
	}
	
	public String getISBN13() {
		return isbn13;
	}
	
	public void setISBN13(String isbn13) {
		this.isbn13 = isbn13;
	}
		
	public String getTagName() {
		return tagName;
	}
		
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	
}
