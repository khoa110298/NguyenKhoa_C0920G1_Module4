package vn.codegym.service;

import vn.codegym.model.BookBorrowCard;

import java.util.List;

public interface BookBorrowCardService {
    List<BookBorrowCard> findAll();

    void save(BookBorrowCard bookBorrowCard);
}
