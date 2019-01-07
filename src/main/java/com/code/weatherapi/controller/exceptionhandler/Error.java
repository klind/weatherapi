package com.code.weatherapi.controller.exceptionhandler;

import org.springframework.http.HttpStatus;

public class Error {

  private HttpStatus status;
  private String message;

  public Error(String message, HttpStatus status) {
    this.status = status;
    this.message = message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
