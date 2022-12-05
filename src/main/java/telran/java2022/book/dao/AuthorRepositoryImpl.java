package telran.java2022.book.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.java2022.book.model.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Optional<Author> findById(String name) {
		return Optional.ofNullable(em.find(Author.class, name));
	}

	@Override
	public Author save(Author author) {
		em.persist(author);
		return author;
	}

	@Override
	public void delete(Author authorName) {
		Author author = em.find(Author.class, authorName);
		em.remove(author);
	}

}
