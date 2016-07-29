package com.chaoxu.pojo;

import javax.persistence.*;

/**
 * Created by dell on 2016/7/29.
 */
@Entity
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("id desc ")
    private Integer id;
    private String bookname;
    private Float bookprice;
    private String bookauthor;
    private Integer booknum;

    @ManyToOne
    @JoinColumn(name ="typeid" )
    private BookType bookType;
    @ManyToOne
    @JoinColumn(name ="pubid" )
    private Publisher publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getBookprice() {
        return bookprice;
    }

    public void setBookprice(Float bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public Integer getBooknum() {
        return booknum;
    }

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookprice=" + bookprice +
                ", bookauthor='" + bookauthor + '\'' +
                ", booknum=" + booknum +
                ", bookType=" + bookType +
                ", publisher=" + publisher +
                '}';
    }
}
