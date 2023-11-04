package com.fullcycle.FCCatalogo.domain.entity;

import java.text.DecimalFormat;

public class VideoFile extends BaseEntity {
  private String title;
  private Float duration;
  private String url;

  public void videoFile(String title, Float duration, String url) {
    this.setTitle(title);
    this.setDuration(duration);
    this.setUrl(url);
  }

  public void videoFile(String title, Float duration) {
    this.setTitle(title);
    this.setDuration(duration);
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

  public Float getDuration() {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    return Float.valueOf(decimalFormat.format(duration));

  }

  public void setDuration(Float duration) {
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    this.duration = Float.valueOf(decimalFormat.format(duration));
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
