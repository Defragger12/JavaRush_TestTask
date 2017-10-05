package Dmitry.service;

import Dmitry.model.Book;
import Dmitry.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;

    @Override
    @Transactional
    public Book create(Book book) {
        Book createdBook = book;
        createdBook.setReadAlready("No");

        return bookRepository.save(createdBook);
    }

    @Override
    @Transactional
    public Book findById(int id) {
        return bookRepository.findOne(id);
    }

    @Override
    @Transactional
    public Book delete(int id) {
        Book deletedBook = bookRepository.findOne(id);

        bookRepository.delete(deletedBook);

        return deletedBook;
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book update(Book book) {
        Book updatedBook = bookRepository.findOne(book.getId());

        if (book.getTitle().equals(updatedBook.getTitle()) &&
            book.getIsbn().equals(updatedBook.getIsbn()) &&
            book.getDescription().equals(updatedBook.getDescription()) &&
            book.getPrintYear() == updatedBook.getPrintYear()) {
            return updatedBook;
        }

        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setIsbn(book.getIsbn());
        updatedBook.setPrintYear(book.getPrintYear());
        updatedBook.setReadAlready("No");

        return updatedBook;
    }

    @Override
    @Transactional
    public Book markAsReadById(int id) {
        Book updatedBook = bookRepository.findOne(id);

        updatedBook.setReadAlready("Yes");

        return updatedBook;
    }

    @Override
    @Transactional
    public List<Book> search(String s) {
        return bookRepository.findByTitle(s);
    }

}
