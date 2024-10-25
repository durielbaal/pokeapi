package com.myke.studios.shared;

/**
 * Constant and fixed values.
 */
public class Constants {

  /**
   * Fixed value of pokeapi.
   */
  public static final String POKEMON_API_BASE_PATH = "/api/pokeapi";
  /**
   * Endpoint to get pokemon by id.
   */
  public static final String POKEMON_API_POKEMON_ID = "/getPokemon/{nid}";
  /**
   * Endpoint to send a message through kafka.
   */
  public static final String SEND_MESSAGE = "/send";
}
