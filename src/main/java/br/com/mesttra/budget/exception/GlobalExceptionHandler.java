package br.com.mesttra.budget.exception;

import br.com.mesttra.budget.response.ErrorResponse;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyValueException.class)
    public @ResponseBody
    ErrorResponse handlePropertyValueException(PropertyValueException e) {
        return new ErrorResponse("X001", e.getMessage());
    }
}
