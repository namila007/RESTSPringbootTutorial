package me.namila.RESTSpringTest.Controller;

import me.namila.RESTSpringTest.Model.Author;
import me.namila.RESTSpringTest.Model.Book;
import me.namila.RESTSpringTest.Results.ResponseWrapper;
import me.namila.RESTSpringTest.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

import static me.namila.RESTSpringTest.Constants.ApiConstants.MESSAGE_FOR_REGEX_NUMBER_MISMATCH;
import static me.namila.RESTSpringTest.Constants.ApiConstants.REGEX_FOR_NUMBERS;

@Validated
@RestController
@RequestMapping("/api/v1/author")
public class AuthorController
{

	@Autowired
	private AuthorService authorMainService;

	@GetMapping(value = "/{id}")
	public ResponseWrapper<Author> getAuthorById(
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id )
	{
		return new ResponseWrapper<>( authorMainService.getById( Integer.parseInt( id ) ), HttpStatus.OK );
	}

	@GetMapping()
	public ResponseWrapper<Page<Author>> getAuthorAll( Pageable pageable )
	{
		return new ResponseWrapper<>( authorMainService.getAll( pageable ), HttpStatus.OK );
	}

	@PostMapping
	public ResponseWrapper<Author> createAuthor( @Valid @RequestBody Author author )
	{
		return new ResponseWrapper<>( authorMainService.add( author ), HttpStatus.OK );
	}

	@DeleteMapping(value = "/{id}")
	public ResponseWrapper<Author> deleteAuthor(
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id )
	{
		return new ResponseWrapper<>( authorMainService.deleteById( Integer.parseInt( id ) ), HttpStatus.OK );
	}

	@PatchMapping(value = "/{id}")
	public ResponseWrapper<Author> UpdateAuthor( @Valid @RequestBody Author author,
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id )
	{
		return new ResponseWrapper<>( authorMainService.update( author, Integer.parseInt( id ) ), HttpStatus.OK );
	}

	@GetMapping(value = "/{id}/books")
	public ResponseWrapper<List<Book>> getAuthorBooksById(
			@Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id )
	{
		return new ResponseWrapper<>( authorMainService.getBooksById( Integer.parseInt( id ) ), HttpStatus.OK );
	}

}
