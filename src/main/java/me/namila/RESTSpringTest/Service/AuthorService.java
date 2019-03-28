package me.namila.RESTSpringTest.Service;

import me.namila.RESTSpringTest.Model.Author;
import me.namila.RESTSpringTest.Model.Book;

import java.util.List;

/**
 * @author namila
 * @project RESTSpringTest
 * @date 3/26/2019
 * @time 9:59 AM
 */

public abstract class AuthorService implements MainService<Author>
{
	public abstract List<Book> getBooksById( int id );
}
