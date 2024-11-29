package com.myke.studios.application;

import com.myke.studios.domain.input.UserManagementInputPort;
import com.myke.studios.infraestructure.dto.UserCredentialsDto;
import com.myke.studios.infrastructure.controller.KafkaController;
import com.myke.studios.shared.exception.UserManagerException;
import com.myke.studios.shared.exception.enums.UserManagerTypeException;
import com.myke.studios.userevent.register.UserRegisterBody;
import com.myke.studios.userevent.register.UserRegisterEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service of User management.
 */
@RequiredArgsConstructor
@Service
public class UserManagerService implements UserManagementInputPort {

  /**
   * Kafka controller.
   */
  private final KafkaController kafkaController;
  /**
   * BCryptPasswordEncoder.
   */
  private final PasswordEncoder passwordEncoder;

  /**
   * User register.
   * @param userCredentialsDto user credentials.
   * @return userRegisterEvent.
   */
  @Override
  public UserRegisterEvent register(UserCredentialsDto userCredentialsDto) {
    try {
      UserRegisterBody userRegisterBody = new UserRegisterBody();
      userRegisterBody.setUsername(userCredentialsDto.getUsername());
      userRegisterBody.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));

      UserRegisterEvent userRegisterEvent =
          new UserRegisterEvent(userRegisterBody);
      kafkaController.publish(userRegisterEvent,userRegisterEvent
          .getHeader()
          .getEventType());
      return userRegisterEvent;
    } catch (Exception e) {
      throw new UserManagerException(UserManagerTypeException.UNEXPECTED_REGISTER_ERROR);
    }

  }
}