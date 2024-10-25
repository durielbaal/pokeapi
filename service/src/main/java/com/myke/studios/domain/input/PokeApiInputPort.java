package com.myke.studios.domain.input;

import com.myke.studios.infraestructure.dto.PokemonDto;

/**
 * Interface to connect service - controller.
 */
public interface PokeApiInputPort {

  /**
   * Get pokemon by nid.
   * @param nid .
   * @return pokemonDto itself.
   */
  PokemonDto getPokemonByNid(String nid);
}
