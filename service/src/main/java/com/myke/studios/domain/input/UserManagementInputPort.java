package com.myke.studios.domain.input;

import com.myke.studios.infraestructure.dto.UserCredentialsDto;
import com.myke.studios.userevent.register.UserRegisterEvent;

/**
 * User management input port.
 */
public interface UserManagementInputPort {

  /**
   * Register of users.
   * @param userDto object of user(dto).
   * @return Event with meta info and the user itself.
   */
  public UserRegisterEvent register(UserCredentialsDto userDto);
}
