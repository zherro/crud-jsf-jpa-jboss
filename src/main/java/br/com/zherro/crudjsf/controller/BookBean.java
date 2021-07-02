package br.com.zherro.crudjsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.zherro.crudjsf.bo.AuthorBO;
import br.com.zherro.crudjsf.bo.BookBO;
import br.com.zherro.crudjsf.model.Author;
import br.com.zherro.crudjsf.model.Book;

@ManagedBean(name = "bookBean")
@ViewScoped
public class BookBean {
	
	@EJB
	BookBO bookBO;
	
	@EJB
	AuthorBO authorBO;
	
	private Book book = new Book();
	
	private List<Book> books;
	
	private DualListModel<Author> authors;
	
	public void save() { 
		System.out.println(book);
		
		List<Author> assoiateds = this.authors.getTarget();
		this.book.setAuthors(assoiateds);
		
		book.setActive(true);
		this.bookBO.save(book);
		
		this.book = new Book();
		this.books = null;
		this.authors =  null;
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
		

		List<Author> available = this.authorBO.getAll();
		List<Author> selected = this.authorBO.getByBook(this.book.getId());
		
		
		for (int i = 0 ; i < available.size() ; i++) {
			for (int y = 0 ; y < selected.size() ; y++) {
				if(selected.get(y).getId() == available.get(i).getId()){
					available.remove(i);
					i=-1;
					break;
				}
			}
		}
        
        this.authors = new DualListModel<Author>(available, selected);
	}
	
	public void delete(Book book) {
		book.setActive(false);
		this.bookBO.delete(book);
		this.books = null;
	}

	public void selectedAuthors(TransferEvent event) {
		StringBuilder authorsName = new StringBuilder();
		for (Object item : event.getItems()) {
			Author author = (Author) item;
			authorsName.append(author.getName());
			authorsName.append("<br />");
		}
	}
	
	public DualListModel<Author> getAuthors() {
		if(authors == null) {
			List<Author> available = this.authorBO.getAll();
			List<Author> selected = new ArrayList<Author>();
			this.authors = new DualListModel<Author>(available, selected);
		}
		return this.authors;
	}

	public void setAuthors(DualListModel<Author> authors) {
		this.authors = authors;
	}
	
	
}
