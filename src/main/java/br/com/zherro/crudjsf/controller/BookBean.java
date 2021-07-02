package br.com.zherro.crudjsf.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.zherro.crudjsf.bo.BookBO;
import br.com.zherro.crudjsf.model.Book;

@ManagedBean(name = "bookBean")
@ViewScoped
public class BookBean {
	
	@EJB
	BookBO bookBO;
	
	private Book book = new Book();
	
	private List<Book> books;
	
	public void save() { 
		System.out.println(book);
		
		book.setActive(true);
		this.bookBO.save(book);
		this.book = new Book();
		this.books = null;
	}
	
	public Book getBook() {
		return book;
	}
	
	public List<Book> getBooks() {
		if( this.books == null ) {
			return this.bookBO.getAll();
		}
		return this.books;
	}
	
	public void edit(Book book) {
		this.book = book;
	}
	
	public void delete(Book book) {
		book.setActive(false);
		this.bookBO.delete(book);
		this.books = null;
	}
	
}
