package com.myke.studios.shared.exception.enums;

import com.myke.studios.exception.enums.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * User manager type exception.
 */
@RequiredArgsConstructor
@Getter
public enum UserManagerTypeException {
  /**
   * User not found enum exception.
   */
  UNEXPECTED_REGISTER_ERROR(ExceptionCode.C500000004.name(),
      HttpStatus.NOT_FOUND,"Unexpected register error");

  /**
   * Code of Exception.
   */
  private final String code;
  /**
   * Status of request.
   */
  private final HttpStatus status;
  /**
   * Message of error.
   */
  private  final  String message;
}
