package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Book;
import vn.codegym.model.BookBorrowCard;
import vn.codegym.repository.BookBorrowCardRepository;
import vn.codegym.repository.BookRepository;
import vn.codegym.service.BookBorrowCardService;
import vn.codegym.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository booksRepository;

    @Override
    public List<Book> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        booksRepository.deleteById(id);
    }

}
