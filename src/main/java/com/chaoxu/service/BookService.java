package com.chaoxu.service;

import com.chaoxu.dao.BookDao;
import com.chaoxu.dao.BookTypeDao;
import com.chaoxu.dao.PublisherDao;
import com.chaoxu.pojo.Book;
import com.chaoxu.pojo.BookType;
import com.chaoxu.pojo.Publisher;
import com.chaoxu.util.Page;
import com.chaoxu.util.SearchParam;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by dell on 2016/7/29.
 */
@Named
@Transactional
public class BookService {

    @Inject
    private BookDao bookDao;
    @Inject
    private BookTypeDao bookTypeDao;
    @Inject
    private PublisherDao publisherDao;

    public List<Book> findAllBook() {
        return bookDao.findAll();
    }

    public List<BookType> findAllBookType() {
        return bookTypeDao.findAll();
    }

    public List<Publisher> findAllPublisher() {
        return publisherDao.findAll();
    }

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    public void delBook(Integer id) {
        bookDao.delBookById(id);
    }

    public Page<Book> findBypage(Integer pageNo, List<SearchParam> searchParamList) {
        return bookDao.findByPageNo(pageNo,5,searchParamList);
    }
}
