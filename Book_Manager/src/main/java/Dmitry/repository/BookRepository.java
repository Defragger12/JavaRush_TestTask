package Dmitry.repository;

import Dmitry.model.Book;
import Dmitry.repository.custom.BookRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryCustom {
}
