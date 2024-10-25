package com.myke.studios.shared.exception;

import com.myke.studios.exception.PokemonException;
import com.myke.studios.shared.exception.enums.PokeApiTypeException;

/**
 * Pokeapi Exception.
 */
public class PokeApiException  extends PokemonException {

  /**
   * Pokeapi Exception constructor.
   * @param ex enum with code, status and error message .
   */
  public PokeApiException(PokeApiTypeException ex) {
    super(ex.getCode(), ex.getStatus(), ex.getMessage(), null);
  }
}
