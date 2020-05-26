package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public class TestBookTagDAO {
	
	public static void main(String[] args) {
		
		
	/*	
		BookTagDAO btDao1 = new BookTagDAOImpl();
		
	    List<BookTag> list1 = btDao1.getAllTagsForGivenBook("1111111111111");
	 
	    for (int i = 0; i < list1.size(); i++){
	      BookTag t = list1.get(i);
	      System.out.println(t);
	    }
	    
	*/
		
	
//		--------------------------------------------------------------------------------------------------------------------
		
	    
		//NOTE: The code for getBooksWithGivenTag() below is just a stub for now.
	    
//	    BookDAO bDao1 = new BookDAOImpl();
//	    
//	    //How to incorporate books based on BookTagDAOImpl ???
//		
//	    BookTagDAO btDao2 = new BookTagDAOImpl();
//		
//	    List<BookTag> list2 = btDao2.getBooksWithGivenTag("11111111111111", "fiction");
//	 
//	   
		
		
//		BookTagDAO btDao2 = new BookTagDAOImpl();
//		
//	    List<BookTag> list2 = btDao2.getBooksWithGivenTag("fiction");
//	 
//	    for (int i = 0; i < list2.size(); i++){
//	      BookTag t = list2.get(i);
//	      System.out.println(t);
//	    }
	    
		
//		--------------------------------------------------------------------------------------------------------------------

		
		BookTagDAO btDao3 = new BookTagDAOImpl();
//		
	    List<BookTag> list3 = btDao3.addTagToBookByIsbn("3333333333333", "fiction"); //the parameter here only needs to be the "access column" that's passed into
	    //the addTagToBookByIsbn method overall
	    
	    for (int i = 0; i < list3.size(); i++){
	      BookTag t = list3.get(i);
	      System.out.println(t);
	    }

		
//		--------------------------------------------------------------------------------------------------------------------

		
		
//	    BookTagDAO btDao4 = new BookTagDAOImpl();
//		
//	    boolean didDelete = btDao4.deleteTagFromBookByIsbn("3333333333333", "fiction");
//	 
//	    System.out.println(didDelete);
	    
	    
	}
	
}
