package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.BookBorrowCard;
import vn.codegym.repository.BookBorrowCardRepository;
import vn.codegym.service.BookBorrowCardService;

import java.util.List;
@Service
public class BookBorrowCardServiceImpl implements BookBorrowCardService {

    @Autowired
    private BookBorrowCardRepository bookBorrowCardRepository;

    @Override
    public List<BookBorrowCard> findAll() {
        return bookBorrowCardRepository.findAll();
    }

    @Override
    public void save(BookBorrowCard bookBorrowCard) {
        bookBorrowCardRepository.save(bookBorrowCard);
    }

}
