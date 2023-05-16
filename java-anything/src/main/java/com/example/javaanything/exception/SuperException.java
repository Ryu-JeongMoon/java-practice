package com.example.javaanything.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SuperException extends RuntimeException {

  SuperException() {
  }

  SuperException(String message) {
    super(message);
  }

  @Override
  public synchronized Throwable fillInStackTrace() {
    log.error("touch SuperException.fillInStackTrace()");
    return super.fillInStackTrace();
  }
}
