package nl.web;

/**
 * Created by mzwart on 11-1-2017.
 */
public class WebTodo {

	private String message;
	private int estimatedCost;
	private int estimatedTime;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public int getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
}
