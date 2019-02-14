/**
 * 
 */
package com.in28minutes.rest.webservices.user.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 109726
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExceptin extends RuntimeException {

	/**
	 * @param message
	 */
	public UserNotFoundExceptin(String message) {
		super(message);
	}
}
