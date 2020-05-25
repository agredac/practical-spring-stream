package com.example.practicalspringstreamcommon.common.events;

import java.io.Serializable;

// @Builder
// @Value
public class ExampleDomainEvent implements Serializable {

  private final String name;
  private final String action;
  private final String id;

  public ExampleDomainEvent(String name, String action, String id) {
    this.name = name;
    this.action = action;
    this.id = id;
  }

  public String name() {
    return name;
  }

  public String action() {
    return action;
  }

  public String id() {
    return id;
  }
}
