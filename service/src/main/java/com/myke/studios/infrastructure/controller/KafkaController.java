package com.myke.studios.infrastructure.controller;

import com.myke.studios.PokemonEvent;
import com.myke.studios.config.AbstractKafkaController;
import com.myke.studios.config.KafkaProducer;
import com.myke.studios.infraestructure.dto.PokemonDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka controller.
 */
@RestController
public class KafkaController extends AbstractKafkaController<PokemonEvent> {

  /**
   * Constructor.
   * @param kafkaProducer .
   */
  protected KafkaController(KafkaProducer<PokemonEvent> kafkaProducer) {
    super(kafkaProducer);
  }

}

