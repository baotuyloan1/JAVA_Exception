package com.baokey.ExceptionChaining;

public class InvalidBirthDayException extends Exception {

  public InvalidBirthDayException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidBirthDayException(Throwable cause) {
    super(cause);
  }
}
