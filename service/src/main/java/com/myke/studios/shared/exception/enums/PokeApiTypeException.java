package com.myke.studios.shared.exception.enums;

import com.myke.studios.exception.enums.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Exception enum management.
 */
@RequiredArgsConstructor
@Getter
public enum PokeApiTypeException {
  /**
   * Pokemon not found enum exception.
   */
  POKEMON_NOT_FOUND(ExceptionCode.C500000002.name(), HttpStatus.NOT_FOUND,"Pokemon not found");
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
