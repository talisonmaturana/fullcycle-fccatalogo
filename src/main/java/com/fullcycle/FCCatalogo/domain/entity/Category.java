package com.fullcycle.FCCatalogo.domain.entity;

import java.util.UUID;

public class Category extends BaseEntity {

  private String name;

  public Category(String name) {
    super.generateUUID();
    this.setName(name);
  }

  public Category(UUID id) {
    super.setId(id);
  }

  public Category(UUID id, String name) {
    super.setId(id);
    this.setName(name);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    if (name == null)
      throw new IllegalArgumentException("name cannot be null");

    if (name.length() == 0)
      throw new IllegalArgumentException("name cannot be empty");

    this.name = name;
  }

}
