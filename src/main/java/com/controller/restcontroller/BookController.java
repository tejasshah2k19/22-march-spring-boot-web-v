package com.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BookBean;
import com.dao.BookDao;

//response json 
@RestController
public class BookController {

	//CRUD 
	//book  - resource 
	//newbook - 	/book 		 POST 
	//readbook - 	/book/:id  	 GET 
	//modifybook - 	/book  		 PUT
	//removebook -  /book/:id 	 DELETE
	//getallbooks - /books 

	@Autowired
	BookDao bookDao; 
	
	@PostMapping("/book")
	public BookBean addBook(BookBean book) {

		bookDao.addBook(book);//use keyholder for bookId 
		return book;
	}
	
	@GetMapping("/books")
	public List<BookBean> getAllBooks(){
		return bookDao.getAllBooks();
	}

	//rest client 

	//json - dictionary - map 
	//{
		//key:value 
	//}

}
