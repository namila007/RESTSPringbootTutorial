package me.namila.RESTSpringTest.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import static me.namila.RESTSpringTest.Constants.ApiConstants.MESSAGE_FOR_INVALID_BODY_ERROR;
import static me.namila.RESTSpringTest.Constants.ApiConstants.MESSAGE_FOR_INVALID_PARAMETERS_ERROR;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceEntityNotFound( ResourceNotFoundException ex )
	{
		ApiError apiError = createError( ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, ex );
		return new ResponseEntity<>( apiError, apiError.getStatus() );
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleConstraintViolationException( ConstraintViolationException e )
	{
		ApiError apiError = createError( MESSAGE_FOR_INVALID_PARAMETERS_ERROR, HttpStatus.BAD_REQUEST, e );
		return new ResponseEntity<>( apiError, apiError.getStatus() );
	}

	@Override
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatus status, WebRequest request )
	{
		ApiError apiError = createError( MESSAGE_FOR_INVALID_BODY_ERROR, HttpStatus.BAD_REQUEST, e );
		return new ResponseEntity<>( apiError, apiError.getStatus() );
	}

	private ApiError createError( String msg, HttpStatus status, Exception e )
	{
		ApiError apiError = new ApiError( status );
		apiError.setMessage( msg );
		apiError.setDebugMessage( e.getMessage() );
		return apiError;
	}

}
