package com.myke.studios.service;

import com.myke.studios.dto.PokemonDto;
import com.myke.studios.utils.Endpoints;
import com.myke.studios.utils.genericcomponent.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Service of pokemon api management.
 */
@Service
public class PokeapiService extends GenericService {


  /**
   * base URL to connect API.
   */
  protected String pokemonEp = Endpoints.BASE_URL + Endpoints.POKEMON;

  /**
   * Dependency Injection resTemplate.
   * @param restTemplate .
   */
  @Autowired
  protected PokeapiService(RestTemplate restTemplate) {
    super(restTemplate);
  }

  /**
   *  getResponse method specialized in pokemonDto responses, from genericService.
   * @param pokemonID endpoint.
   * @return response with pokemonDto type.
   */
  public PokemonDto getResponse(String pokemonID) {
    /**
     * response.
     */
    PokemonDto pkmn = super.getResponse(pokemonEp + pokemonID,PokemonDto.class);
    pkmn.setHeight(pkmn.height / 10);
    pkmn.setWeight(pkmn.weight / 10);
    return pkmn;
  }


}

