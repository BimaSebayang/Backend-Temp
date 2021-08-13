package id.co.buara.varia.computama.throwable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptanceDataException extends RuntimeException{
	private static final long serialVersionUID = -7709761715178137895L;

	public NotAcceptanceDataException(String message) {
		super(message);
	}
}
