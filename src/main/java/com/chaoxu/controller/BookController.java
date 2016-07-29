package com.chaoxu.controller;

import com.chaoxu.pojo.Book;
import com.chaoxu.service.BookService;
import com.chaoxu.util.SearchParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dell on 2016/7/29.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping( method = RequestMethod.GET)
    public String home(Model model,
                       @RequestParam (name = "p",required = false,defaultValue = "1") Integer pageNo,
                       HttpServletRequest request) {
        List<SearchParam> searchParamList = SearchParam.buiderSearchParam(request);

        //model.addAttribute("bookList", bookService.findAllBook());
        model.addAttribute("page",bookService.findBypage(pageNo,searchParamList));

        return "book/list";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newBook(Model model){

        model.addAttribute("TypeList",bookService.findAllBookType());
        model.addAttribute("publiserList",bookService.findAllPublisher());
        return "book/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveBook(Book book, RedirectAttributes redirectAttributes){
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message","添加成功");
        return "redirect:/book";
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String delBook(@PathVariable Integer id){
        bookService.delBook(id);

        return "redirect:/book";
    }

    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable Integer id){

        model.addAttribute("book",bookService.findBookById(id));
        model.addAttribute("TypeList",bookService.findAllBookType());
        model.addAttribute("publiserList",bookService.findAllPublisher());
        return"book/edit";
    }

    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.POST)
    public String edit(Book book){
       bookService.saveBook(book);
        return "redirect:/book";
    }


}
