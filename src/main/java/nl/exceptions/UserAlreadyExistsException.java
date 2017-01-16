package nl.exceptions;

/**
 * Created by mzwart on 13-1-2017.
 */
public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException(String message){
		super(message);
	}

}
