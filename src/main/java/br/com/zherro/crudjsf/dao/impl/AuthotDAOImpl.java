package br.com.zherro.crudjsf.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.zherro.crudjsf.dao.AuthorDAO;
import br.com.zherro.crudjsf.model.Author;

@Named("authorDAO")
public class AuthotDAOImpl extends AbstractJPA implements AuthorDAO {

	@Override
	public void save(Author author) {
		if(author.getId() == null) {
			getEntityManager().persist(author);
		} else {
			getEntityManager().merge(author);
		}
	}

	@Override
	public void delete(Author author) {
		getEntityManager().merge(author);
		
	}

	@Override
	public Author getById(Long id) {
		String jpql = "select a from Author a where id = :id";
		Query query = getEntityManager().createQuery(jpql, Author.class);
		query.setParameter("id", id);
		Author author = (Author) query.getSingleResult();
		return author;
	}

	@Override
	public List<Author> getAll() {
		String jpql = "select a from Author a where a.active = true order by name";
		TypedQuery<Author> query = getEntityManager().createQuery(jpql, Author.class);
		List<Author> authors = query.getResultList();
		return authors;
	}

	@Override
	public List<Author> getByBook(Long idBook) {
		String jpql = "select a from Author a join fetch a.books l where l.id = :idBook order by a.name";
		TypedQuery<Author> query = getEntityManager().createQuery(jpql, Author.class);
		query.setParameter("idBook", idBook);
		List<Author> autores = query.getResultList();
		return autores;
	}

}
