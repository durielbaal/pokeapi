package com.myke.studios.service;

import com.myke.studios.dto.PokemonDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Service of pokemon api management.
 */
@Service
public class PokeapiService {
  /**
   * restTemplate to connect API.
   */
  private final RestTemplate restTemplate = new RestTemplate();
  /**
   * base URL to connect API.
   */
  private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

  /**
   * Searching of pokemon by id number or name.
   * @param pokemonName aa.
   * @return aa.
   */
  public PokemonDto getPokemonData(String pokemonName) {
    String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + pokemonName)
              .toUriString();
    return restTemplate.getForObject(url, PokemonDto.class);
  }
}

