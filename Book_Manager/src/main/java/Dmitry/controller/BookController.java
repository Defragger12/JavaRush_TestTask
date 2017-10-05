package Dmitry.controller;

import Dmitry.model.Book;
import Dmitry.service.BookService;
import Dmitry.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.stereotype.Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView bookListPage(@RequestParam(required = false) Integer page) {
        ModelAndView mav = new ModelAndView("list");

        List<Book> bookList = bookService.findAll();

        PagedListHolder<Book> pagedListHolder = new PagedListHolder<>(bookList);
        pagedListHolder.setPageSize(10);
        int numberOfPages = pagedListHolder.getPageCount();
        mav.addObject("maxPages", numberOfPages);

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) page = 1;

        mav.addObject("page", page);
        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            bookList = pagedListHolder.getPageList();
            mav.addObject("bookList", bookList);
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            bookList = pagedListHolder.getPageList();
            mav.addObject("bookList", bookList);

        }

        return mav;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView bookSearchPage(@RequestParam(value = "searchstring", required = false) String s) {
        ModelAndView mav = new ModelAndView("list");

        List<Book> bookList = bookService.search(s);

        mav.addObject("bookList", bookList);

        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView newBookPage() {
        ModelAndView mav = new ModelAndView("form", "book", new Book());

        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute Book book, final RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();
        String message = "New book \"" + book.getTitle() + "\" was successfully added.";

        bookService.create(book);
        mav.setViewName("redirect:/list");

        redirectAttributes.addFlashAttribute("message", message);

        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editBookPage(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("edit");

        Book book = bookService.findById(id);

        mav.addObject("book", book);

        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView updateBook(@ModelAttribute Book book, @PathVariable Integer id, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView("redirect:/list");

        bookService.update(book);
        String message = "Book by " + bookService.findById(id).getAuthor() + " was successfully updated.";

        redirectAttributes.addFlashAttribute("message", message);

        return mav;
    }

    @RequestMapping(value = "/edit/{id}/read", method = RequestMethod.GET)
    public ModelAndView markAsReadById(@PathVariable Integer id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:" + request.getHeader("referer"));

        bookService.markAsReadById(id);

        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
        ModelAndView mav = new ModelAndView("redirect:/list");

        Book book = bookService.delete(id);
        String message = "Book \"" + book.getTitle() + "\" was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);

        return mav;
    }
}
