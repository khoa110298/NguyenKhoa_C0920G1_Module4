package vn.codegym.model;

import javax.persistence.*;

@Entity
public class BookBorrowHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
    private BookBorrowCard bookBorrowCard;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    private String dateBorrow;

    public BookBorrowHistory() {
    }

    public BookBorrowHistory(BookBorrowCard bookBorrowCard, Book book, String dateBorrow) {
        this.bookBorrowCard = bookBorrowCard;
        this.book = book;
        this.dateBorrow = dateBorrow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookBorrowCard getBookBorrowCard() {
        return bookBorrowCard;
    }

    public void setBookBorrowCard(BookBorrowCard bookBorrowCard) {
        this.bookBorrowCard = bookBorrowCard;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }
}
