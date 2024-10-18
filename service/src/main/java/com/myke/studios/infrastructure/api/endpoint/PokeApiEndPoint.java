package com.myke.studios.infrastructure.api.endpoint;

import com.myke.studios.infraestructure.dto.PokemonDto;
import com.myke.studios.infrastructure.api.abstracts.AbstractPokeApiEndPoint;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeApiEndPoint extends AbstractPokeApiEndPoint {

  public PokeApiEndPoint(RestTemplate restTemplate) {
    super(restTemplate);
  }
  public PokemonDto doCallGetPokemon(final String url){
    return doCall(url,HttpMethod.GET,null,null,PokemonDto.class);
  }
}
