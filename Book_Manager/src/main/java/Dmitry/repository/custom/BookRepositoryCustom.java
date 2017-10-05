package Dmitry.repository.custom;

import Dmitry.model.Book;

import java.util.List;

public interface BookRepositoryCustom {

    List<Book> findByTitle(String title);

}
