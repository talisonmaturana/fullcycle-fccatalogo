package com.fullcycle.FCCatalogo.domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum CastMemberType {
  TYPE1(1),
  TYPE2(2);

  private Integer type;
  private final static Map values = new HashMap<>();

  private CastMemberType(Integer type) {
    this.type = type;
  }

  static {
    for (CastMemberType type : CastMemberType.values()) {
      values.put(type.type, type);
    }
  }

  public Integer getType() {
    return this.type;
  }

  public static Boolean valueOf(CastMemberType type) {
    CastMemberType castMemberType = (CastMemberType) values.get(type.type);

    if (castMemberType == null)
      return false;
    return true;
  }
}

public class CastMember extends BaseEntity {

  public CastMember(UUID id, String name, CastMemberType type) {
    super.setId(id);
    this.setName(name);
    this.setType(type);
  }

  public CastMember(String name, CastMemberType type) {
    super.generateUUID();
    this.setName(name);
    this.setType(type);
  }

  public CastMember(String name) {
    super.generateUUID();
    this.setName(name);
  }

  private String name;
  private CastMemberType type;

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

  public CastMemberType getType() {
    return this.type;
  }

  public void setType(CastMemberType type) {
    if (type == null)
      throw new IllegalArgumentException("type cannot be null");
    if (!CastMemberType.valueOf(type))
      throw new IllegalArgumentException("type is not a valid enum");

    this.type = type;
  }

}
