package br.com.zherro.crudjsf.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.zherro.crudjsf.bo.AuthorBO;
import br.com.zherro.crudjsf.dao.AuthorDAO;
import br.com.zherro.crudjsf.model.Author;


@Stateless(name = "authorBO")
public class AuthorBoImpl implements AuthorBO {
	
	@Inject
	AuthorDAO authorDAO;

	@Override
	public void save(Author author) {
		authorDAO.save(author);		
	}

	@Override
	public void delete(Author author) {
		authorDAO.delete(author);	
	}

	@Override
	public Author getById(Long id) {
		return authorDAO.getById(id);
	}

	@Override
	public List<Author> getAll() {
		return authorDAO.getAll();
	}

}
