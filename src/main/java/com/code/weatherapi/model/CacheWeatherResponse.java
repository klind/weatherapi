package com.code.weatherapi.model;

import java.time.LocalDateTime;

public class CacheWeatherResponse {

  private LocalDateTime time;
  private WeatherResponse weatherResponse;

  /**
   * 
   * @param time now.
   * @param weatherResponse weatherResponse.
   */
  public CacheWeatherResponse(LocalDateTime time, WeatherResponse weatherResponse) {
    super();
    this.time = time;
    this.weatherResponse = weatherResponse;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public WeatherResponse getWeatherResponse() {
    return weatherResponse;
  }

  public void setWeatherResponse(WeatherResponse weatherResponse) {
    this.weatherResponse = weatherResponse;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CacheWeatherResponse [time=");
    builder.append(time);
    builder.append(", weatherResponse=");
    builder.append(weatherResponse);
    builder.append("]");
    return builder.toString();
  }
}
