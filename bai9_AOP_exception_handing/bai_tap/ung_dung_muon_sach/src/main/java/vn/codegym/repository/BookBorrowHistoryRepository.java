package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.BookBorrowHistory;

public interface BookBorrowHistoryRepository extends JpaRepository<BookBorrowHistory,Integer> {
}
