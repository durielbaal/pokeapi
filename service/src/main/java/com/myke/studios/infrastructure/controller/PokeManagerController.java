package com.myke.studios.infrastructure.controller;

import com.myke.studios.domain.input.PokeManagerInputPort;
import com.myke.studios.jwt.JwtService;
import com.myke.studios.pokemonevent.insert.PokemonInsertEvent;
import com.myke.studios.shared.Constants;
import com.myke.studios.shared.exception.PokeManagerException;
import com.myke.studios.shared.exception.enums.PokeManagerTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class PokeManagerController {

  /**
   * Interface to stablish contact with pokeapi service.
   */
  private final PokeManagerInputPort pokeManagerInputPort;

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
  public ResponseEntity<PokemonInsertEvent> getPokemonByNid(@PathVariable String nid) {
    try {
      PokemonInsertEvent pokemonInsertEvent =  this.pokeManagerInputPort.getPokemonByNid(nid);
      return ResponseEntity.status(HttpStatus.CREATED).body(pokemonInsertEvent);
    } catch (Exception e) {
      throw new PokeManagerException(PokeManagerTypeException.POKEMON_NOT_FOUND);
    }

  }


}
