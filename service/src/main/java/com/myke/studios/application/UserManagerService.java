package com.myke.studios.application;

import com.myke.studios.constant.ConstantEvent;
import com.myke.studios.domain.input.UserManagementInputPort;
import com.myke.studios.infraestructure.dto.UserCredentialsDto;
import com.myke.studios.infrastructure.controller.KafkaController;
import com.myke.studios.shared.exception.UserManagerException;
import com.myke.studios.shared.exception.enums.UserManagerTypeException;
import com.myke.studios.userevent.login.UserLoginBody;
import com.myke.studios.userevent.login.UserLoginEvent;
import com.myke.studios.userevent.register.UserRegisterBody;
import com.myke.studios.userevent.register.UserRegisterEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<String> register(UserCredentialsDto userCredentialsDto) {
    try {
      UserRegisterBody userRegisterBody = new UserRegisterBody();
      userRegisterBody.setUsername(userCredentialsDto.getUsername());
      userRegisterBody.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));

      UserRegisterEvent userRegisterEvent =
          new UserRegisterEvent(userRegisterBody);
      kafkaController.publish(userRegisterEvent,
          userRegisterEvent
              .getHeader()
              .getEventType(),
          userRegisterEvent
              .getHeader()
              .getId());
      return ResponseEntity.ok("Register request completed... sending to database.");
    } catch (Exception e) {
      throw new UserManagerException(UserManagerTypeException.UNEXPECTED_REGISTER_ERROR);
    }

  }

  /**
   * Login of user system.
   * @param userCredentialsDto credentials.
   * @return user login event.
   */
  @Override
  public ResponseEntity<String> login(UserCredentialsDto userCredentialsDto) {
    try {
      UserLoginBody userLoginBody = new UserLoginBody();
      userLoginBody.setUsername(userCredentialsDto.getUsername());
      userLoginBody.setPassword(passwordEncoder.encode(userCredentialsDto.getPassword()));
      UserLoginEvent userLoginEvent =
          new UserLoginEvent(userLoginBody);
      kafkaController.publish(userLoginEvent,
          userLoginEvent
              .getHeader()
              .getEventType(),
          userLoginEvent
              .getHeader()
              .getId());
      return ResponseEntity.ok("login request completed...sending to database");
    } catch (Exception e) {
      throw new UserManagerException(UserManagerTypeException.UNEXPECTED_REGISTER_ERROR);
    }
  }
}
