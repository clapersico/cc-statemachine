package it.prsprj.statemachine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProgramNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6544953216040924128L;
}
