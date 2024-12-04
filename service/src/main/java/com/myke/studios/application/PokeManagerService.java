package com.myke.studios.application;

import com.myke.studios.constant.ConstantEvent;
import com.myke.studios.domain.input.PokeManagerInputPort;
import com.myke.studios.infraestructure.dto.PokemonDto;
import com.myke.studios.infrastructure.api.endpoint.PokeApiEndPoint;
import com.myke.studios.infrastructure.controller.KafkaController;
import com.myke.studios.infrastructure.mapper.PokeManagerUrlMapper;
import com.myke.studios.pokemonevent.insert.PokemonInsertEvent;
import com.myke.studios.pokemonevent.insert.PokemonInsertEventBody;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Service of pokeapi.
 */
@RequiredArgsConstructor
@Service
public class PokeManagerService implements PokeManagerInputPort {

  /**
   * Endpoint.
   */
  @Value("${pokeapi.poke-api.pokemon-id}")
  private String endpoint;
  /**
   * Mapper.
   */
  private final PokeManagerUrlMapper pokeManagerUrlMapper;
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
  @Cacheable(value = "pokemonCache", key = "#nid")
  @Override
  public PokemonInsertEvent getPokemonByNid(String nid) {
    Map<String, String> getValueMap = new HashMap<>();
    getValueMap.put("{nid}",nid);
    String uri = pokeManagerUrlMapper.mapUrl(getValueMap,endpoint);
    PokemonDto pkmn = pokeApiEndPoint.doCallGetPokemon(uri);
    PokemonInsertEvent pokemonInsertEvent =
        new PokemonInsertEvent(new PokemonInsertEventBody(pkmn.pokedexNumber, pkmn.name));
    kafkaController.publish(pokemonInsertEvent,
        pokemonInsertEvent
            .getHeader()
            .getEventType(),
        pokemonInsertEvent
            .getHeader()
            .getId());
    return pokemonInsertEvent;

  }

}
