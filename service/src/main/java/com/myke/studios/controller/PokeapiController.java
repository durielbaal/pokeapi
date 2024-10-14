package com.myke.studios.controller;

import com.myke.studios.dto.PokemonDto;
import com.myke.studios.service.PokeapiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controllers of Pokemon api management.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/pokemon")
public class PokeapiController {
  /**
   * Instance of Pokemon api services.
   */
  private final PokeapiService pokeapiService;

  /**
   * Searching of pokemon by id or name.
   * @param name name or id of pokemon we want to search.
   * @return the pokemon itself.
   */
  @GetMapping("/{name}")
  public PokemonDto getPokemon(@PathVariable String name) {
    return pokeapiService.getPokemonData(name);
  }
}
