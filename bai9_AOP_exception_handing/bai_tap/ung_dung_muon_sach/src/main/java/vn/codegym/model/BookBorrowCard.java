package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookBorrowCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameStudent;
    @OneToMany(mappedBy = "bookBorrowCard")
    private List<BookBorrowHistory> borrowHistoryList;

    public BookBorrowCard() {
    }

    public BookBorrowCard(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public List<BookBorrowHistory> getBorrowHistoryList() {
        return borrowHistoryList;
    }

    public void setBorrowHistoryList(List<BookBorrowHistory> borrowHistoryList) {
        this.borrowHistoryList = borrowHistoryList;
    }
}
