package com.code.weatherapi.controller.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

class ErrorResponse {

  private List<Error> errors = new ArrayList<>();

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }
}
