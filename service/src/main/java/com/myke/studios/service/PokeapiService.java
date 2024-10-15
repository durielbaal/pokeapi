package com.myke.studios.service;

import com.myke.studios.dto.PokemonDto;
import com.myke.studios.errormanagement.CustomException;
import com.myke.studios.errormanagement.ErrorType;
import com.myke.studios.utils.Endpoints;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
  protected String pokemonEp = Endpoints.BASE_URL + Endpoints.POKEMON;

  /**
   * Searching of pokemon by id number or name.
   * @param pokemonName number or name of pokemon.
   * @return pokemon general info.
   */
  public PokemonDto getPokemonData(String pokemonName) {
    String url = UriComponentsBuilder.fromHttpUrl(pokemonEp + pokemonName)
              .toUriString();
    try {
      return restTemplate.getForObject(url, PokemonDto.class);
    } catch (HttpClientErrorException.NotFound e) {
      throw new CustomException(ErrorType.POKEMON_NOT_FOUND.getMessage());
    } catch (Exception e) {
      throw new CustomException(ErrorType.API_REQUEST_FAILED.getMessage());
    }
  }
}

