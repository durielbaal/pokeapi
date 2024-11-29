package com.myke.studios.infrastructure.mapper;

import com.myke.studios.abstracts.AbstractUrlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Mapper of pokeapi url.
 */
@Component
public class PokeManagerUrlMapper extends AbstractUrlMapper {

  /**
   * Base path.
   */
  @Value("${pokeapi.poke-api.baseUrl}")
  private String pokeManagerBaseUrl;

  /**
   * Base path.
   */
  @Override
  protected String pokeManagerBaseUrl() {
    return pokeManagerBaseUrl;
  }
}
