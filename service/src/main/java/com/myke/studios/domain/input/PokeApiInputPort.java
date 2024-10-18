package com.myke.studios.domain.input;

import com.myke.studios.infraestructure.dto.PokemonDto;

public interface PokeApiInputPort {
  PokemonDto getPokemonByNid(String nid);
}
