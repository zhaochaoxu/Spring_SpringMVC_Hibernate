package com.chaoxu.pojo;

import javax.persistence.*;

/**
 * Created by dell on 2016/7/29.
 */
@Entity
@Table(name = "t_booktype")
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String booktype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}
