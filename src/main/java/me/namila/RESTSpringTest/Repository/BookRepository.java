package me.namila.RESTSpringTest.Repository;

import me.namila.RESTSpringTest.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
}
