package com.myke.studios.domain.input;

import com.myke.studios.infraestructure.dto.UserCredentialsDto;
import com.myke.studios.userevent.login.UserLoginEvent;
import com.myke.studios.userevent.register.UserRegisterEvent;
import org.springframework.http.ResponseEntity;

/**
 * User management input port.
 */
public interface UserManagementInputPort {

  /**
   * Register of users.
   * @param userDto object of user(dto).
   * @return Event with meta info and the user itself.
   */
  public ResponseEntity<String> register(UserCredentialsDto userDto);

  /**
   * Users login.
   * @param userDto .
   * @return .
   */
  public ResponseEntity<String> login(UserCredentialsDto userDto);
}
