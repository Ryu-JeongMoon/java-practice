package com.example.javaanything.exception;

class SubException extends SuperException {

  public static final SubException INSTANCE = new SubException("ERROR");

  SubException(String message) {
    super(message);
  }

  @Override
  public synchronized Throwable fillInStackTrace() {
    return this;
  }
}
