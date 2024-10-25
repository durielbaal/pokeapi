package com.myke.studios.infrastructure.controller;

import com.myke.studios.config.AbstractKafkaController;
import com.myke.studios.config.KafkaProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka controller.
 */
@RestController
public class KafkaController extends AbstractKafkaController {

  /**
   * Constructor.
   * @param kafkaProducer .
   */
  protected KafkaController(KafkaProducer kafkaProducer) {
    super(kafkaProducer);
  }

  /**
   * Receiving message.
   * @param message itself.
   */
  @KafkaListener(topics = "pokemon-topic", groupId = "pokedb-group")
  public void consume(String message) {
    System.out.println("Mensaje recibido en Pokeapi en si misma: " + message);
  }
}

