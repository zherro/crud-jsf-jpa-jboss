package br.com.zherro.crudjsf.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.zherro.crudjsf.bo.BookBO;
import br.com.zherro.crudjsf.dao.BookDAO;
import br.com.zherro.crudjsf.model.Book;

@Stateless(name = "bookBO")
public class BookBoImpl implements BookBO {
	
	@Inject
	BookDAO bookDAO;

	@Override
	public void save(Book book) {
		bookDAO.save(book);		
	}

	@Override
	public void delete(Book book) {
		bookDAO.delete(book);	
	}

	@Override
	public Book getById(Long id) {
		return bookDAO.getById(id);
	}

	@Override
	public List<Book> getAll() {
		return bookDAO.getAll();
	}

}
