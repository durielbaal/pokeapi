package com.myke.studios.domain.input;

import com.myke.studios.pokemonevent.insert.PokemonInsertEvent;

/**
 * Interface to connect service - controller.
 */
public interface PokeApiInputPort {

  /**
   * Get pokemon by nid.
   * @param nid .
   * @return pokemonDto itself.
   */
  PokemonInsertEvent getPokemonByNid(String nid);
}
