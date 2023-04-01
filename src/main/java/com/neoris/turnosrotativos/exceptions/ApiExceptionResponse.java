package com.neoris.turnosrotativos.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Map;

public class ApiExceptionResponse {

  private final Map<String, String> message;
  // private final Throwable throwable;
  private final HttpStatus httpStatus;
  private final LocalDate timestamp;

  public ApiExceptionResponse(Map<String, String> message, HttpStatus httpStatus) {
    this.message = message;
    // this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.timestamp = LocalDate.now();
  }

  public Map<String, String> getMessage() {
    return message;
  }

  // public Throwable getThrowable() {
  //   return throwable;
  // }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public LocalDate getTimestamp() {
    return timestamp;
  }
}