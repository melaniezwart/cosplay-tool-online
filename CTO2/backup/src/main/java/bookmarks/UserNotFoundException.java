package bookmarks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mzwart on 5-1-2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String userId){
		super("Could not find user: " + userId + ".");
	}
}
