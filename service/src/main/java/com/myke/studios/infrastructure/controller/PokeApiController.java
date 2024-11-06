package com.myke.studios.infrastructure.controller;

import com.myke.studios.domain.input.PokeApiInputPort;
import com.myke.studios.jwt.JwtService;
import com.myke.studios.pokemonevent.insert.PokemonInsertEvent;
import com.myke.studios.shared.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Pokeapi Controller.
 */
@RestController
@RequestMapping(Constants.POKEMON_API_BASE_PATH)
@RequiredArgsConstructor
public class PokeApiController {

  /**
   * Interface to stablish contact with pokeapi service.
   */
  private final PokeApiInputPort pokeApiInputPort;

  /**
   * Security JWT service.
   */
  private final JwtService jwtService;

  /**
   * Get pokemon by nid.
   * @param nid .
   * @return pokemonDto.
   */
  @GetMapping(path = Constants.POKEMON_API_POKEMON_ID)
  public PokemonInsertEvent getPokemonByNid(@PathVariable String nid) {
    return this.pokeApiInputPort.getPokemonByNid(nid);
  }
}
