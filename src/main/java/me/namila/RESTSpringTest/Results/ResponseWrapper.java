package me.namila.RESTSpringTest.Results;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unchecked")
public class ResponseWrapper<T> extends ResponseEntity<T>
{
	public ResponseWrapper( T t, HttpStatus status )
	{
		super( ( T ) new Resultset<>( t, status ), status );
	}
}
