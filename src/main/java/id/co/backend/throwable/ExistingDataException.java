package id.co.backend.throwable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ExistingDataException extends RuntimeException{
	private static final long serialVersionUID = -7709761715178137895L;

	public ExistingDataException(String message) {
		super(message);
	}
}
