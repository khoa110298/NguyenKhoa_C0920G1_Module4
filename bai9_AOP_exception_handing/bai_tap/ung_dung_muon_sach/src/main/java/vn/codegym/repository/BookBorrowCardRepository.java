package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.BookBorrowCard;

public interface BookBorrowCardRepository extends JpaRepository<BookBorrowCard,Integer> {
}
