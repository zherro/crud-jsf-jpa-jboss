package br.com.zherro.crudjsf.bo;

import java.util.List;

import br.com.zherro.crudjsf.model.Author;

public interface AuthorBO {

	public void save(Author author);
	
	public void delete(Author author);
	
	public Author getById(Long id);
	
	public List<Author> getAll();

	public List<Author> getByBook(Long id);

}
