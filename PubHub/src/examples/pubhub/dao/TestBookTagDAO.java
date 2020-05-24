package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public class TestBookTagDAO {

	public static void main(String[] args) {
		
		BookTagDAO btDao1 = new BookTagDAOImpl();
		
	    List<BookTag> list1 = btDao1.getAllTagsForGivenBook("1111111111111", "fiction");
	 
	    for (int i = 0; i < list1.size(); i++){
	      BookTag t = list1.get(i);
	      System.out.println(t);
	    }
	    
	    BookDAO bDao1 = new BookDAOImpl();
		
	    BookTagDAO btDao2 = new BookTagDAOImpl();
		
	    List<BookTag> list2 = btDao2.getBooksWithGivenTag("11111111111111", "fiction");
	 
	    for (int i = 0; i < list2.size(); i++){
	      BookTag t = list2.get(i);
	      System.out.println(t);
	    }
	    
	    


	}
	
	
	
	

}
