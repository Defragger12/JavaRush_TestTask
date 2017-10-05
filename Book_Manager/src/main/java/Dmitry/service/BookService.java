package Dmitry.service;

import Dmitry.model.Book;

import java.util.List;

public interface BookService {
    public Book create(Book book);
    public Book delete(int id);
    public List<Book> findAll();
    public Book update(Book book);
    public Book findById(int id);
    public Book markAsReadById(int id);
    public List<Book> search(String title);
}
