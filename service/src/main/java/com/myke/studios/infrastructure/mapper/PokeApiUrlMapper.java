package com.myke.studios.infrastructure.mapper;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Mapper of pokeapi url.
 */
@Component
public class PokeApiUrlMapper {
  @Value("${pokeapi.poke-api.baseUrl}")
  private String pokeapiBaseUrl;



  public String mapUrl(Map<String,String > pathVarMap, String endpoint){
    String url=pokeapiBaseUrl.concat(endpoint);
    for (Map.Entry<String, String> entry : pathVarMap.entrySet()) {
      url = url.replace(entry.getKey(), entry.getValue());
    }
    return url;
  }
}
