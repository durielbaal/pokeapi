package com.myke.studios.application;

import com.myke.studios.domain.input.PokeApiInputPort;
import com.myke.studios.infraestructure.dto.PokemonDto;
import com.myke.studios.infrastructure.api.endpoint.PokeApiEndPoint;
import com.myke.studios.infrastructure.mapper.PokeApiUrlMapper;
import com.myke.studios.shared.exception.PokeApiException;
import com.myke.studios.shared.exception.enums.PokeApiTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PokeApiService implements PokeApiInputPort {


  @Value("${pokeapi.poke-api.pokemon-id}")
  private String endpoint;
  private final PokeApiUrlMapper pokeApiUrlMapper;
  private final PokeApiEndPoint pokeApiEndPoint;


  /**
   * @param nid name or id of pokemon in pokedex.
   * @return the pokemon itself.
   */
  @Override
  public PokemonDto getPokemonByNid(String nid) {
    try{
      Map<String, String> getValueMap= new HashMap<String, String>();
      getValueMap.put("{nid}",nid);
      String uri=pokeApiUrlMapper.mapUrl(getValueMap,endpoint);
      return pokeApiEndPoint.doCallGetPokemon(uri);
    } catch (Exception e) {
      throw new PokeApiException(PokeApiTypeException.POKEMON_NOT_FOUND);
    }

  }
}
