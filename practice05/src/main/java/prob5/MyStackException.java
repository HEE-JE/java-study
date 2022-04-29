package prob5;

public class MyStackException extends RuntimeException {
	private String message;
	
	MyStackException() {
//		super();
//		System.out.println("aa");
	}
	
	MyStackException(String err) {
//		super(err);
//		System.out.println(err);
	}
	
	public String getMessage() {
		message = "stack is empty";
		return "stack is empty";
	}
	
	public String getLocalizedMessage() {
		message = "stack is empty";
		return "stack is empty";
	}
	
//	public Class<?> getClass() {
//		return Prob5.MyStackException;
//	}
}