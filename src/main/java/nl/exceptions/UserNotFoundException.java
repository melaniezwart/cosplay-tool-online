package nl.exceptions;

/**
 * Created by mzwart on 9-1-2017.
 */
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message){
		super(message);
	}

}
