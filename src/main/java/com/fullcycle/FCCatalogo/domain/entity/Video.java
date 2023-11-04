package com.fullcycle.FCCatalogo.domain.entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Video extends BaseEntity {
  private String title;
  private String description;
  private Integer launchedYear;
  private Boolean opened;
  private String rating;
  private Float duration;
  private List<Category> categories = new ArrayList<Category>();
  private List<Genre> genres = new ArrayList<Genre>();
  private List<CastMember> castMembers = new ArrayList<CastMember>();
  private List<VideoFile> videoFiles = new ArrayList<VideoFile>();

  public Video(UUID id, String title, String description, Integer launchedYear, Boolean opened) {
    super.setId(id);
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setOpened(opened);
  }

  public Video(String title, String description, Integer launchedYear, Boolean opened) {
    super.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setOpened(opened);
  }

  public Video(String title, String description, Integer launchedYear, Boolean opened, String rating, Float duration) {
    super.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setOpened(opened);
    this.setRating(rating);
    this.setDuration(duration);
  }

  public Video(String title, String description, Integer launchedYear, Float duration,
      List<Category> categories, List<Genre> genres, List<CastMember> castMembers) {
    super.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setDuration(duration);
    this.setCategories(categories);
    this.setGenres(genres);
    this.setCastMembers(castMembers);
  }

  public Video(String title, String description, Integer launchedYear, Float duration) {
    super.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setDuration(duration);
  }

  public Video(String title, String description, Integer launchedYear, Float duration, List<VideoFile> videoFiles) {
    super.generateUUID();
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setDuration(duration);
    this.setVideoFiles(videoFiles);
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    if (title == null)
      throw new IllegalArgumentException("title cannot be null");
    if (title.length() == 0)
      throw new IllegalArgumentException("title cannot be empty");
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getLaunchedYear() {
    return this.launchedYear;
  }

  public void setLaunchedYear(Integer launchedYear) {
    if (launchedYear == null)
      throw new IllegalArgumentException("launchedYear cannot be null");

    if (launchedYear < 1900)
      throw new IllegalArgumentException("launchedYear must be greater than 1900");

    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    if (launchedYear > currentYear)
      throw new IllegalArgumentException("launched year is greater than current year");
    this.launchedYear = launchedYear;
  }

  public Boolean isOpened() {
    return this.opened;
  }

  public Boolean getOpened() {
    return this.opened;
  }

  public void setOpened(Boolean opened) {
    this.opened = opened;
  }

  public String getRating() {
    return this.rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public Float getDuration() {
    return this.duration;
  }

  public void setDuration(Float duration) {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    this.duration = Float.valueOf(decimalFormat.format(duration));
  }

  public List<Category> getCategories() {
    return this.categories;
  }

  public void setCategories(List<Category> categories) {
    if (categories == null)
      throw new IllegalArgumentException("categories cannot be null");

    this.categories = categories;
  }

  public List<Genre> getGenres() {
    return this.genres;
  }

  public void setGenres(List<Genre> genres) {
    if (genres == null)
      throw new IllegalArgumentException("genres cannot be null");
    this.genres = genres;
  }

  public List<CastMember> getCastMembers() {
    return this.castMembers;
  }

  public void setCastMembers(List<CastMember> castMembers) {
    if (castMembers == null)
      throw new IllegalArgumentException("castMembers cannot be null");
    this.castMembers = castMembers;
  }

  public List<VideoFile> getVideoFiles() {
    return this.videoFiles;
  }

  public void setVideoFiles(List<VideoFile> videoFiles) {
    if (videoFiles == null)
      throw new IllegalArgumentException("videoFiles cannot be null");
    this.videoFiles = videoFiles;
  }

  public void addCategory(Category category) {
    if (category == null)
      throw new IllegalArgumentException("category cannot be null");

    this.categories.add(category);
  }

  public void removeCategory(Category category) {
    if (category == null)
      throw new IllegalArgumentException("category cannot be null");

    this.categories.removeIf(c -> this.categories.contains(category));
  }

  public void addGenre(Genre genre) {
    if (genre == null)
      throw new IllegalArgumentException("genre cannot be null");

    this.genres.add(genre);
  }

  public void removeGenre(Genre genre) {
    if (genre == null)
      throw new IllegalArgumentException("genre cannot be null");

    this.genres.removeIf(c -> this.genres.contains(genre));
  }

  public void addCastMember(CastMember castMember) {
    if (castMember == null)
      throw new IllegalArgumentException("castMember cannot be null");

    this.castMembers.add(castMember);
  }

  public void removeCasMember(CastMember castMember) {
    if (castMember == null)
      throw new IllegalArgumentException("castMember cannot be null");

    this.castMembers.removeIf(c -> this.castMembers.contains(castMember));
  }

  public Video createVideoWithFiles(String title, String description, Integer launchedYear, Float duration,
      List<Category> categories, List<Genre> genres, List<CastMember> castMembers, List<VideoFile> videoFiles) {
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setDuration(duration);
    this.setCategories(categories);
    this.setGenres(genres);
    this.setCastMembers(castMembers);
    this.setVideoFiles(videoFiles);

    return this;
  }

  public Video createVideoWithoutFiles(String title, String description, Integer launchedYear, Float duration,
      List<Category> categories, List<Genre> genres, List<CastMember> castMembers) {
    this.setTitle(title);
    this.setDescription(description);
    this.setLaunchedYear(launchedYear);
    this.setDuration(duration);
    this.setCategories(categories);
    this.setGenres(genres);
    this.setCastMembers(castMembers);

    return this;
  }

}
