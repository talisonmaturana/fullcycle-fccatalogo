package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTests {

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Category((String) null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenIdIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Category((UUID) null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Category(""));
  }

  @Test
  public void createCategory() {
    final Category category = new Category("Category1");
    assertNotNull(category, "Category cannot be null");
    assertEquals(category.getName(), "Category1");
    assertTrue(category.isValidUUID(category.getId().toString()));
  }
}
