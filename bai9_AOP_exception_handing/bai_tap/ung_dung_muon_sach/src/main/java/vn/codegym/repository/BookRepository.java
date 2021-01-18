package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
