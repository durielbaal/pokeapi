package com.myke.studios.infrastructure.controller;

import com.myke.studios.domain.input.PokeApiInputPort;
import com.myke.studios.infraestructure.dto.PokemonDto;
import com.myke.studios.jwt.JwtService;
import com.myke.studios.shared.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.POKEMON_API_BASE_PATH)
@RequiredArgsConstructor
public class PokeApiController {
  private final PokeApiInputPort pokeApiInputPort;
  @Autowired
  private JwtService jwtService;
  @GetMapping(path = Constants.POKEMON_API_POKEMON_ID)
  public PokemonDto getPokemonByNid(@PathVariable String nid) {
    return this.pokeApiInputPort.getPokemonByNid(nid);
  }
}
