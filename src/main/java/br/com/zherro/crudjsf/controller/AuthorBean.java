package br.com.zherro.crudjsf.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.zherro.crudjsf.bo.AuthorBO;
import br.com.zherro.crudjsf.model.Author;


@ManagedBean(name = "authorBean")
@ViewScoped
public class AuthorBean {
	
	@EJB
	AuthorBO authorBO;
	
	private Author author = new Author();
	
	private List<Author> authors;
	
	public void save() { 
		System.out.println(author);
		
		author.setActive(true);
		this.authorBO.save(author);
		this.author = new Author();
		this.authors = null;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public List<Author> getAuthors() {
		if( this.authors == null ) {
			return this.authorBO.getAll();
		}
		return this.authors;
	}
	
	public void edit(Author author) {
		this.author = author;
	}
	
	public void delete(Author author) {
		author.setActive(false);
		this.authorBO.delete(author);
		this.authors = null;
	}
	
}
