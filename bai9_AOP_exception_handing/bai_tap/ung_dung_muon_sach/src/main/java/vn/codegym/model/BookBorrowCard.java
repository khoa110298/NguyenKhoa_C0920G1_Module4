package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookBorrowCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer numberBorrow;

    public BookBorrowCard(Integer numberBorrow) {
        this.numberBorrow = numberBorrow;
    }

    public BookBorrowCard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberBorrow() {
        return numberBorrow;
    }

    public void setNumberBorrow(Integer numberBorrow) {
        this.numberBorrow = numberBorrow;
    }
}
