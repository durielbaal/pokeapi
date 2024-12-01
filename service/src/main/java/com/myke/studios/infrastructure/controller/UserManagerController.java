package com.myke.studios.infrastructure.controller;

import com.myke.studios.domain.input.UserManagementInputPort;
import com.myke.studios.infraestructure.dto.UserCredentialsDto;
import com.myke.studios.shared.Constants;
import com.myke.studios.shared.exception.UserManagerException;
import com.myke.studios.shared.exception.enums.UserManagerTypeException;
import com.myke.studios.userevent.login.UserLoginEvent;
import com.myke.studios.userevent.register.UserRegisterEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Pokeapi Controller.
 */
@RestController
@RequestMapping(Constants.USER_MANAGEMENT_BASE_PATH)
@RequiredArgsConstructor
public class UserManagerController {

  /**
   * Interface to stablish contact with user service.
   */
  private final UserManagementInputPort userManagementInputPort;


  /**
   * Get pokemon by nid.
   * @param userCredentialsDto user credentials object.
   * @return pokemonDto.
   */
  @PostMapping(path = Constants.USER_MANAGEMENT_REGISTER)
  public ResponseEntity<UserRegisterEvent> userRegisterEvent(
      @RequestBody UserCredentialsDto userCredentialsDto) {
    try {
      UserRegisterEvent userRegisterEvent = this.userManagementInputPort
          .register(userCredentialsDto);
      return ResponseEntity.status(HttpStatus.CREATED)
          .body(userRegisterEvent);
    } catch (Exception e) {
      throw new UserManagerException(UserManagerTypeException
          .UNEXPECTED_REGISTER_ERROR);
    }

  }

  /**
   * Get pokemon by nid.
   * @param userCredentialsDto user credentials object.
   * @return pokemonDto.
   */
  @PostMapping(path = Constants.USER_MANAGEMENT_LOGIN)
  public ResponseEntity<UserLoginEvent> userLoginEvent(
      @RequestBody UserCredentialsDto userCredentialsDto) {
    try {
      UserLoginEvent userLoginEvent = this.userManagementInputPort
          .login(userCredentialsDto);
      return ResponseEntity.status(HttpStatus.CREATED)
          .body(userLoginEvent);
    } catch (Exception e) {
      throw new UserManagerException(UserManagerTypeException
          .UNEXPECTED_REGISTER_ERROR);
    }

  }
}
