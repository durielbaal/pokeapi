package com.myke.studios.application;

import com.myke.studios.PokemonEvent;
import com.myke.studios.domain.input.PokeApiInputPort;
import com.myke.studios.infraestructure.dto.PokemonDto;
import com.myke.studios.infrastructure.api.endpoint.PokeApiEndPoint;
import com.myke.studios.infrastructure.controller.KafkaController;
import com.myke.studios.infrastructure.mapper.PokeApiUrlMapper;
import com.myke.studios.shared.exception.PokeApiException;
import com.myke.studios.shared.exception.enums.PokeApiTypeException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service of pokeapi.
 */
@RequiredArgsConstructor
@Service
public class PokeApiService implements PokeApiInputPort {

  /**
   * Endpoint.
   */
  @Value("${pokeapi.poke-api.pokemon-id}")
  private String endpoint;
  /**
   * Mapper.
   */
  private final PokeApiUrlMapper pokeApiUrlMapper;
  /**
   * Contract to connect with controller.
   */
  private final PokeApiEndPoint pokeApiEndPoint;
  /**
   * Kafka controller.
   */
  private final KafkaController kafkaController;

  /**
   * Get Pokemon by nid.
   * @param nid name or id of pokemon in pokedex.
   * @return the pokemon itself.
   */
  @Override
  public PokemonEvent getPokemonByNid(String nid) {

    try {
      Map<String, String> getValueMap = new HashMap<String, String>();
      getValueMap.put("{nid}",nid);
      String uri = pokeApiUrlMapper.mapUrl(getValueMap,endpoint);
      PokemonDto pkmn = pokeApiEndPoint.doCallGetPokemon(uri);
      PokemonEvent pokemonEvent = new PokemonEvent(pkmn,"POKEAPI","INSERT");
      kafkaController.publish(pokemonEvent,"INSERT");
      return pokemonEvent;
    } catch (Exception e) {
      throw new PokeApiException(PokeApiTypeException.POKEMON_NOT_FOUND);
    }

  }

}
