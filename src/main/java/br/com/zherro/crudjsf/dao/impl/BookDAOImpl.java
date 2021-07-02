package br.com.zherro.crudjsf.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.zherro.crudjsf.dao.BookDAO;
import br.com.zherro.crudjsf.model.Book;

@Named("bookDAO")
public class BookDAOImpl extends AbstractJPA implements BookDAO {

	@Override
	public void save(Book book) {
		if(book.getId() == null) {
			getEntityManager().persist(book);
		} else {
			getEntityManager().merge(book);
		}
	}

	@Override
	public void delete(Book book) {
		getEntityManager().merge(book);
		
	}

	@Override
	public Book getById(Long id) {
		String jpql = "select b from Book b where id = :id";
		Query query = getEntityManager().createQuery(jpql, Book.class);
		query.setParameter("id", id);
		Book book = (Book) query.getSingleResult();
		return book;
	}

	@Override
	public List<Book> getAll() {
		String jpql = "select b from Book b where b.active = true order by title";
		TypedQuery<Book> query = getEntityManager().createQuery(jpql, Book.class);
		List<Book> livros = query.getResultList();
		return livros;
	}

}
