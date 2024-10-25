package com.myke.studios.infrastructure.api.endpoint;

import com.myke.studios.infraestructure.dto.PokemonDto;
import com.myke.studios.infrastructure.api.abstracts.AbstractPokeApiEndPoint;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Class of endpoints management.
 */
@Component
public class PokeApiEndPoint extends AbstractPokeApiEndPoint {

  /**
   * Constructor.
   * @param restTemplate .
   */
  public PokeApiEndPoint(RestTemplate restTemplate) {
    super(restTemplate);
  }

  /**
   * Call to get pokemon.
   * @param url .
   * @return the call to get the pokemon itself.
   */
  public PokemonDto doCallGetPokemon(final String url) {
    return doCall(url, HttpMethod.GET,null,null,PokemonDto.class);
  }
}
