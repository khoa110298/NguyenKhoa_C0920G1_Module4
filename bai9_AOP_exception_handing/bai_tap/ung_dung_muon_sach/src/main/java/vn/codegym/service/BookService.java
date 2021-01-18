package vn.codegym.service;

import vn.codegym.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    String borrow(Integer id) throws Exception;

    String giveBack(Integer loanNumber, Integer id);
}
