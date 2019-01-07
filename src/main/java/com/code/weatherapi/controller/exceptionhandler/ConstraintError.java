package com.code.weatherapi.controller.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ConstraintError extends Error {

  private String fieldName;

  public ConstraintError(String fieldName, String message, HttpStatus status) {
    super(message, status);
    this.fieldName = fieldName;
  }

  public String getFieldName() {
    return fieldName;
  }

}
