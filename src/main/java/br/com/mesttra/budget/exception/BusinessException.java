package br.com.mesttra.budget.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BusinessException extends Throwable {

    private String message;

}
