package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowHistory> borrowHistoryList;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookBorrowHistory> getBorrowHistoryList() {
        return borrowHistoryList;
    }

    public void setBorrowHistoryList(List<BookBorrowHistory> borrowHistoryList) {
        this.borrowHistoryList = borrowHistoryList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
