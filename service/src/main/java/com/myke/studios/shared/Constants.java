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
   * Base path to user management.
   */
  public static final String USER_MANAGEMENT_BASE_PATH = "/api/auth";

  /**
   * REGISTER.
   */
  public static final String USER_MANAGEMENT_REGISTER = "/register";
  /**
   * REGISTER.
   */
  public static final String USER_MANAGEMENT_LOGIN = "/login";

  /**
   * Endpoint to send a message through kafka.
   */
  public static final String SEND_MESSAGE = "/send";
}
