package com.lemke.tasklist.exception;

public class RequiredFieldNotFilledException extends RuntimeException {

  public RequiredFieldNotFilledException(String fieldName) {
    super("Required field " + fieldName + ".");
  }

}
