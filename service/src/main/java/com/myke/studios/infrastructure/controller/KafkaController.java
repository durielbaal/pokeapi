package com.myke.studios.infrastructure.controller;

import com.myke.studios.config.AbstractKafkaController;
import com.myke.studios.config.KafkaProducer;
import com.myke.studios.infraestructure.dto.PokemonDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka controller.
 */
@RestController
public class KafkaController extends AbstractKafkaController<PokemonDto> {

  /**
   * Constructor.
   * @param kafkaProducer .
   */
  protected KafkaController(KafkaProducer<PokemonDto> kafkaProducer) {
    super(kafkaProducer);
  }

}

