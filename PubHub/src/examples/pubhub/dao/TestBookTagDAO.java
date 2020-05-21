package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.BookTag;

public class TestBookTagDAO {

	public static void main(String[] args) {
		

		BookTagDAO dao = new BookTagDAOImpl();
		
	    List<BookTag> list = dao.getAllTagsForGivenBook("1111111111111");
	 
	    for (int i = 0; i < list.size(); i++){
	      BookTag t = list.get(i);
	      System.out.println(t);
	    }


	}

}
