package com.myke.studios.abstracts;

import java.util.Map;

/**
 * Abstract URL's Mappers.
 */
public abstract class AbstractUrlMapper {

  /**
   * poke manager base url.
   * @return url .
   */
  protected abstract String pokeManagerBaseUrl();

  /**
   * Map url.
   * @param pathVarMap .
   * @param endpoint .
   * @return .
   */
  public String mapUrl(Map<String, String> pathVarMap, String endpoint) {
    String url = pokeManagerBaseUrl().concat(endpoint);
    for (Map.Entry<String, String> entry : pathVarMap.entrySet()) {
      url = url.replace(entry.getKey(), entry.getValue());
    }
    return url;
  }
}
