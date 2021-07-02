package br.com.zherro.crudjsf.dao;

import java.util.List;

import br.com.zherro.crudjsf.model.Book;

public interface BookDAO {
	public void save(Book book);
	
	public void delete(Book book);
	
	public Book getById(Long id);
	
	public List<Book> getAll();
}
