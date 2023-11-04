package com.fullcycle.FCCatalogo.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
public class VideoTests {

  @Test
  public void throwIllegalArgumentExceptionWhenTitleIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Video(null, "", 2023, true));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenTitleIsEmpty() {
    assertThrows(IllegalArgumentException.class, () -> new Video("", "", 2023, true));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenLaunchedYearIsNull() {
    assertThrows(IllegalArgumentException.class, () -> new Video("Video1", "", null, true));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenLaunchedYearIsGreaterThanToday() {
    assertThrows(IllegalArgumentException.class, () -> new Video("Video1", "", 2030, true));
  }

  @Test
  public void throwIllegalArgumentExceptionWhenLaunchedYearIsNotInRange() {
    assertThrows(IllegalArgumentException.class, () -> new Video("Video1", "", 1850, true));
  }

  @Test
  void createVideoWithTitleAndLaunchedYearTest() {
    final Video video = new Video("Video1", "My description", 2023, false);

    assertNotNull(video);
    assertEquals(video.getTitle(), "Video1");
    assertEquals(video.getLaunchedYear(), 2023);
    assertFalse(video.getOpened());
    assertTrue(video.isValidUUID(video.getId().toString()));
  }

  @Test
  void createVideoWithAllAttributesTest() {
    final Video video = new Video("Video1", "My description", 2023, false, "5.0", (Float) 10.3f);

    assertNotNull(video);
    assertEquals(video.getTitle(), "Video1");
    assertEquals(video.getLaunchedYear(), 2023);
    assertFalse(video.getOpened());
    assertTrue(video.isValidUUID(video.getId().toString()));
  }

  @Test
  void createVideoWithoutFilesTest() {
    final Category category1 = new Category("Category1");
    final Category category2 = new Category("Category2");
    final Genre genre1 = new Genre("Genre1");
    final Genre genre2 = new Genre("Genre2");
    final CastMember castMember1 = new CastMember("CastMember1");
    final CastMember castMember2 = new CastMember("CastMember2");

    List<Category> categories = new ArrayList<Category>();
    categories.add(category1);
    categories.add(category2);

    List<Genre> genres = new ArrayList<Genre>();
    genres.add(genre1);
    genres.add(genre2);

    List<CastMember> castMembers = new ArrayList<CastMember>();
    castMembers.add(castMember1);
    castMembers.add(castMember2);

    assertNotNull(categories);
    assertNotNull(genres);
    assertNotNull(castMembers);

    final Video video = new Video("Video1", "My description", 2023, 1.30f, categories, genres, castMembers);

    assertNotNull(video);
    assertEquals(video.getTitle(), "Video1");
    assertEquals(video.getLaunchedYear(), 2023);
    assertNotNull(video.getCategories());
    assertNotNull(video.getGenres());
    assertNotNull(video.getCastMembers());
    assertTrue(video.isValidUUID(video.getId().toString()));
  }

  @Test
  public void createVideoWithoutFilesWithCategoriesTest() {
    final Category category1 = new Category("Category1");
    final Category category2 = new Category("Category2");

    assertNotNull(category1);
    assertNotNull(category2);

    List<Category> categories = new ArrayList<Category>();
    categories.add(category1);
    categories.add(category2);

    assertNotNull(categories);

    final Video video = new Video("Video1", "My description", 2023, false, "5.0", (Float) 10.3f);
    video.setCategories(categories);

    assertNotNull(video);
    assertEquals(video.getTitle(), "Video1");
    assertTrue(video.isValidUUID(video.getId().toString()));
    assertEquals(category1.getName(), "Category1");
    assertEquals(category2.getName(), "Category2");
    assertTrue(category1.isValidUUID(category1.getId().toString()));
    assertTrue(category2.isValidUUID(category2.getId().toString()));
    assertEquals(2, video.getCategories().size());
  }

  @Test
  public void createVideoWithoutFilesWithGenresTest() {
    final Genre genre1 = new Genre("Genre1");
    final Genre genre2 = new Genre("Genre2");

    assertNotNull(genre1);
    assertNotNull(genre2);

    final Video video = new Video("Video1", "My description", 2023, false, "5.0", (Float) 10.3f);
    video.addGenre(genre1);
    video.addGenre(genre2);

    assertNotNull(video);
    assertEquals(video.getTitle(), "Video1");
    assertTrue(video.isValidUUID(video.getId().toString()));
    assertEquals(genre1.getName(), "Genre1");
    assertEquals(genre2.getName(), "Genre2");
    assertTrue(genre1.isValidUUID(genre1.getId().toString()));
    assertTrue(genre2.isValidUUID(genre2.getId().toString()));
    assertEquals(2, video.getGenres().size());
  }

  @Test
  public void createVideoWithoutFilesWithCastMembersTest() {
    final CastMember castMember1 = new CastMember("CastMember1");
    final CastMember castMember2 = new CastMember("CastMember2");

    assertNotNull(castMember1);
    assertNotNull(castMember2);

    final Video video = new Video("Video1", "My description", 2023, false, "5.0", (Float) 10.3f);
    video.addCastMember(castMember1);
    video.addCastMember(castMember2);

    assertNotNull(video);
    assertEquals(video.getTitle(), "Video1");
    assertTrue(video.isValidUUID(video.getId().toString()));
    assertEquals(castMember1.getName(), "CastMember1");
    assertEquals(castMember2.getName(), "CastMember2");
    assertTrue(castMember1.isValidUUID(castMember1.getId().toString()));
    assertTrue(castMember2.isValidUUID(castMember2.getId().toString()));
    assertEquals(2, video.getCastMembers().size());
  }
}
