package com.myke.studios.shared.exception;
import com.myke.studios.exception.PokemonException;
import com.myke.studios.exception.enums.GenericTypeException;
import com.myke.studios.shared.exception.enums.PokeApiTypeException;


public class PokeApiException  extends PokemonException {

  public PokeApiException(PokeApiTypeException ex){
    super(ex.getCode(), ex.getStatus(), ex.getMessage(), null);
  }
}
