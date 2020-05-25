package com.example.practicalspringstreamlistener.application;

import com.example.practicalspringstreamcommon.events.ExampleDomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class) // Enabling usage of INPUT CHANNEL
public class Application {

  @StreamListener(Sink.INPUT)
  public void loggerListener(ExampleDomainEvent domainEvent) {
    log.debug("Recived an event for id {}", domainEvent.id());
  }
}
