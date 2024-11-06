package com.myke.studios.infrastructure.controller;

import com.myke.studios.abstracts.AbstractEvent;
import com.myke.studios.config.AbstractKafkaController;
import com.myke.studios.config.KafkaProducer;
import com.myke.studios.pokemonevent.insert.PokemonInsertEvent;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka controller.
 */
@RestController
public class KafkaController extends AbstractKafkaController<AbstractEvent<?, ?>> {

  /**
   * Constructor.
   * @param kafkaProducer .
   */
  protected KafkaController(KafkaProducer<AbstractEvent<?, ?>> kafkaProducer) {
    super(kafkaProducer);
  }

}

