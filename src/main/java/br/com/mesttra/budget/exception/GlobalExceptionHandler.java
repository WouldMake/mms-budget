package br.com.mesttra.budget.exception;

import br.com.mesttra.budget.response.ErrorResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonParseException.class)
    public @ResponseBody
    ErrorResponse handlePropertyValueException(JsonParseException e) {
        return new ErrorResponse("X002", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    ErrorResponse handlePropertyValueException(MethodArgumentNotValidException e) {
        return new ErrorResponse("X003", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public @ResponseBody
    ErrorResponse handleBusinessException(BusinessException e) {
        return new ErrorResponse("X004", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonMappingException.class)
    public @ResponseBody
    ErrorResponse handleJsonMappingException(JsonMappingException e) {
        return new ErrorResponse("X005", e.getMessage());
    }
}
