package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GenreTests {

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre(null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Genre(""));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsEmptyAndCategoriesIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenNameIsNullAndCategoriesIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
  }

  @Test
  public void createGenreWithNameTest() {
    final Genre genre = new Genre("Genre1");

    assertNotNull(genre);
    assertEquals(genre.getName(), "Genre1");
    assertTrue(genre.isValidUUID(genre.getId().toString()));
  }

  @Test
  public void createGenreWithNameAndCategoriesTest() {
    final Category category1 = new Category("Category1");
    final Category category2 = new Category("Category2");

    List<Category> categories = new ArrayList<Category>();
    categories.add(category1);
    categories.add(category2);

    assertNotNull(categories);
    assertEquals(category1.getName(), "Category1");
    assertEquals(category2.getName(), "Category2");
    assertTrue(category1.isValidUUID(category1.getId().toString()));
    assertTrue(category2.isValidUUID(category2.getId().toString()));

    final Genre genre = new Genre("Genre1", categories);

    assertNotNull(genre);
    assertEquals(genre.getName(), "Genre1");
    assertTrue(genre.isValidUUID(genre.getId().toString()));
    assertEquals(2, genre.getCategories().size());
  }

  @Test
  public void addCategoryToGenreTest() {
    final Genre genre = new Genre("Genre1");
    assertNotNull(genre);
    assertNotNull(genre.getCategories());

    final Category category1 = new Category("Category1");
    final Category category2 = new Category("Category2");

    genre.addCategory(category1);
    genre.addCategory(category2);

    assertEquals(2, genre.getCategories().size());
  }

  @Test
  public void removeCategoryFromGenreTest() {
    final Genre genre = new Genre("Genre1");
    assertNotNull(genre);
    assertNotNull(genre.getCategories());

    final Category category1 = new Category("Category1");
    final Category category2 = new Category("Category2");

    genre.addCategory(category1);
    genre.addCategory(category2);
    assertEquals(2, genre.getCategories().size());

    genre.removeCategory(category1);
    assertEquals(1, genre.getCategories().size());

    genre.removeCategory(category2);
    assertEquals(0, genre.getCategories().size());
  }

}
