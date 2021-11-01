package book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.beans.Book;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Oct 31, 2021
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
