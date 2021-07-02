package br.com.zherro.crudjsf.dao;

import java.util.List;

import br.com.zherro.crudjsf.model.Author;

public interface AuthorDAO {
	public void save(Author author);
	
	public void delete(Author author);
	
	public Author getById(Long id);
	
	public List<Author> getAll();
}
