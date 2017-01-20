package nl.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by mzwart on 9-1-2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleUserNotFoundException (UserNotFoundException e){
		this.logError(e);
		return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "User was not found. Did you make a typo?");
	}

	@ExceptionHandler({MaterialNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleMaterialNotFoundException (MaterialNotFoundException e){
		this.logError(e);
		return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Material was not found. Did you make a typo?");
	}

	@ExceptionHandler({UserAlreadyExistsException.class})
	public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException (UserAlreadyExistsException e){
		this.logError(e);
		return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "This user already exists, try a different name");
	}

	@ExceptionHandler({UserNotAuthorizedException.class})
	public ResponseEntity<ErrorResponse> handleUserNotAuthorizedException (UserNotAuthorizedException e){
		this.logError(e);
		return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "You are not authorized for this page");
	}

	@ExceptionHandler({FunctionalException.class})
	public ResponseEntity<ErrorResponse> handleFunctionalException (FunctionalException e){
		this.logError(e);
		return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorResponse> handleException (Exception e){
		this.logError(e);
		return this.createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong on our side, we're sorry.");
	}

	protected ResponseEntity<GlobalExceptionHandler.ErrorResponse> createResponseEntity(HttpStatus httpStatus, String error) {
		return new ResponseEntity(new GlobalExceptionHandler.ErrorResponse(httpStatus.value(), error), httpStatus);
	}

	protected void logError(Exception e){
		this.LOG.error("Exception thrown: " + e.getMessage());
		if(e.getCause() != null){
			this.LOG.error("Caused by: " + e.getCause().getMessage());
		}
	}

	protected class ErrorResponse{
		private int status;
		private String error;

		public ErrorResponse(int status, String error){
			this.status = status;
			this.error = error;
		}

		public int getStatus() {
			return status;
		}

		public String getError() {
			return error;
		}
	}
}
