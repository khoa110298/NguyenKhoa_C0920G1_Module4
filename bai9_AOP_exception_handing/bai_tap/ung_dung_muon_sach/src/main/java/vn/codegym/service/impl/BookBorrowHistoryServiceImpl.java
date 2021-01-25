package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.BookBorrowHistory;
import vn.codegym.repository.BookBorrowHistoryRepository;
import vn.codegym.service.BookBorrowHistoryService;

import java.util.List;

@Service
public class BookBorrowHistoryServiceImpl implements BookBorrowHistoryService {
    @Autowired
    BookBorrowHistoryRepository bookBorrowHistoryRepository;
    @Override
    public List<BookBorrowHistory> findAll() {
        return bookBorrowHistoryRepository.findAll();
    }

    @Override
    public BookBorrowHistory findById(Integer id) {
        return bookBorrowHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookBorrowHistory bookBorrowHistory) {
        bookBorrowHistoryRepository.save(bookBorrowHistory);
    }

    @Override
    public void remove(Integer id) {
        bookBorrowHistoryRepository.deleteById(id);
    }
}
