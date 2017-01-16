package nl.exceptions;

/**
 * Created by mzwart on 10-1-2017.
 */
public class MaterialNotFoundException extends RuntimeException{

	public MaterialNotFoundException(String message){
		super(message);
	}
}
