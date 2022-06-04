package com.dao;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BookBean;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate stmt;

	public void addBook(BookBean book) {
		stmt.update("insert into books (name,author,category,price) values (?,?,?,?)", book.getName(), book.getAuthor(),
				book.getCategory(), book.getPrice());
	}

	public List<BookBean> getAllBooks() {
		return stmt.query("select * from books", new BeanPropertyRowMapper<BookBean>(BookBean.class));
	}

	public void deleteBook(int bookId) {
		stmt.update("delete from books where bookId = ? ",bookId);
	}

	public void updateBook(BookBean book) {
		stmt.update("update books set price = ? where bookid = ? ",book.getPrice(),book.getBookId());
		
	}
}
