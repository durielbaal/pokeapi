package com.myke.studios.shared.exception;

import com.myke.studios.exception.PokemonException;
import com.myke.studios.shared.exception.enums.UserManagerTypeException;

/**
 * User manager exception handler customization.
 */
public class UserManagerException extends PokemonException {
  /**
   * User manager Exception constructor.
   * @param ex enum with code, status and error message .
   */
  public UserManagerException(UserManagerTypeException ex) {
    super(ex.getCode(), ex.getStatus(), ex.getMessage(), null);
  }
}
