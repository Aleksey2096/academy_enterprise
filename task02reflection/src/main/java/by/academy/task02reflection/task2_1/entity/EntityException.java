package by.academy.task02reflection.task2_1.entity;

public class EntityException extends Exception {

	public EntityException() {
		super();
	}

	public EntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityException(String message) {
		super(message);
	}

	public EntityException(Throwable cause) {
		super(cause);
	}

}
