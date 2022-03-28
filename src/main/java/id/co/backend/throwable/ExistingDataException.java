package id.co.backend.throwable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundDataException extends RuntimeException{
	private static final long serialVersionUID = -7709761715178137895L;

	public NotFoundDataException(String message) {
		super(message);
	}
}
