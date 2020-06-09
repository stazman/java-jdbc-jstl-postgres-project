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
		

		BookTagDAO btDao2 = new BookTagDAOImpl();
		
	    List<BookTag> list2 = btDao2.getBooksWithGivenTag("fiction");
	 
	    for (int i = 0; i < list2.size(); i++){
	      BookTag t = list2.get(i);
	      System.out.println(t);
	    }
	    

		
//		--------------------------------------------------------------------------------------------------------------------


//		BookTagDAO btDao3 = new BookTagDAOImpl();
//		
//	    boolean didAdd = btDao3.addTagToBookByIsbn("3333333333333", "top ten novels of all time");
//	    
//	    System.out.println(didAdd);
//	    
//	    }

	    
		
//		--------------------------------------------------------------------------------------------------------------------

		
/*	    
		BookTagDAO btDao4 = new BookTagDAOImpl();
		
	    boolean didDelete = btDao4.deleteTagFromBookByIsbn("3333333333333", "fiction");
	 
	    System.out.println(didDelete);
	    
*/
	   
	}
}
	
