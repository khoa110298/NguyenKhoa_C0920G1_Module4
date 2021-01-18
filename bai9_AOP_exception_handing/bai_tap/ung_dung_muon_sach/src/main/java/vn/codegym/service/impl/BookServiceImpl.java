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

    @Autowired
    private BookBorrowCardRepository bookBorrowCardRepository;

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
    public String borrow(Integer id) throws Exception {
        Book booksEntity = findById(id);
        if (booksEntity.getQuantity() == 0) {
            throw new Exception("Hết sách rồi !");
        } else {
            booksEntity.setQuantity(booksEntity.getQuantity() - 1);
            BookBorrowCard bookLoanCardEntity = new BookBorrowCard();
            bookLoanCardEntity.setId((int) (Math.random() * 100));
            bookLoanCardEntity.setNumberBorrow((int) ((Math.random() * 9999) + 1000));

            bookBorrowCardRepository.save(bookLoanCardEntity);
            return String.valueOf(bookLoanCardEntity.getNumberBorrow());
        }
    }

    @Override
    public String giveBack(Integer loanNumber, Integer id) {
        List<BookBorrowCard> bookLoanCardEntityList = bookBorrowCardRepository.findAll();
        boolean check = false;
        for (BookBorrowCard bookLoanCardEntity : bookLoanCardEntityList) {
            if (bookLoanCardEntity.getNumberBorrow().equals(loanNumber)) {
                check = true;
                Book book = findById(id);
                book.setQuantity(book.getQuantity() + 1);
                this.bookBorrowCardRepository.delete(bookLoanCardEntity);
                break;
            }
        }
        if (check) {
            return "Give Back Complete !";
        } else {
            return "Book Loan Number is not exist !";
        }
    }
}
