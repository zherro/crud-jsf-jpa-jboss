package br.com.zherro.crudjsf.bo;

import java.util.List;

import br.com.zherro.crudjsf.model.Book;

public interface BookBO {

	public void save(Book book);
	
	public void delete(Book book);
	
	public Book getById(Long id);
	
	public List<Book> getAll();

}
