
package com.code.weatherapi.model;

import java.io.Serializable;

public class Wind implements Serializable {

  private static final long serialVersionUID = 1L;
  private Double speed;
  private Integer deg;

  public Wind() {}

  /**
   * 
   * @param speed wind speed.
   * @param deg wind degree.
   */
  public Wind(Double speed, Integer deg) {
    super();
    this.speed = speed;
    this.deg = deg;
  }

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Integer getDeg() {
    return deg;
  }

  public void setDeg(Integer deg) {
    this.deg = deg;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Wind [speed=");
    builder.append(speed);
    builder.append(", deg=");
    builder.append(deg);
    builder.append("]");
    return builder.toString();
  }

}
