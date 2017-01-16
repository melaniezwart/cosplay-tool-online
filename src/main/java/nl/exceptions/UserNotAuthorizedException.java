package nl.exceptions;

/**
 * Created by mzwart on 16-1-2017.
 */
public class UserNotAuthorizedException extends RuntimeException {

	public UserNotAuthorizedException(String message ){
		super(message);
	}
}
