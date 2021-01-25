package vn.codegym.service;

import vn.codegym.model.Book;
import vn.codegym.model.BookBorrowHistory;

import java.util.List;

public interface BookBorrowHistoryService {
    List<BookBorrowHistory> findAll();

    BookBorrowHistory findById(Integer id);

    void save(BookBorrowHistory bookBorrowHistory);

    void remove(Integer id);
}
