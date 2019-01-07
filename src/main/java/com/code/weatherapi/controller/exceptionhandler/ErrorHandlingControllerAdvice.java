package com.code.weatherapi.controller.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
class ErrorHandlingControllerAdvice {
  private static Logger log = LoggerFactory.getLogger(ErrorHandlingControllerAdvice.class);

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  ErrorResponse onConstraintValidationException(
      final ConstraintViolationException constraintViolationException) {
    ErrorResponse error = new ErrorResponse();
    constraintViolationException.getConstraintViolations().stream()
        .forEach(c -> error.getErrors().add(new ConstraintError(c.getPropertyPath().toString(),
            c.getMessage(), HttpStatus.BAD_REQUEST)));
    return error;
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  Error onException(final Exception exception) {
    log.error("", exception);
    Error error = new Error("ControllerAdvice not setup to handle " + exception.getClass() + ": "
        + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    return error;
  }

}
