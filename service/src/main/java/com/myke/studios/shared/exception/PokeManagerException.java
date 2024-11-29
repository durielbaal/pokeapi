package com.myke.studios.shared.exception;

import com.myke.studios.exception.PokemonException;
import com.myke.studios.shared.exception.enums.PokeManagerTypeException;

/**
 * Pokeapi Exception.
 */
public class PokeManagerException extends PokemonException {

  /**
   * Pokeapi Exception constructor.
   * @param ex enum with code, status and error message .
   */
  public PokeManagerException(PokeManagerTypeException ex) {
    super(ex.getCode(), ex.getStatus(), ex.getMessage(), null);
  }
}
