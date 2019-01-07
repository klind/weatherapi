
package com.code.weatherapi.model;

import java.io.Serializable;

public class WeatherResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private Wind wind;

  public WeatherResponse() {}

  public WeatherResponse(Wind wind) {
    super();
    this.wind = wind;
  }

  public Wind getWind() {
    return wind;
  }

  public void setWind(Wind wind) {
    this.wind = wind;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("WeatherResponse [wind=");
    builder.append(wind);
    builder.append("]");
    return builder.toString();
  }

}
