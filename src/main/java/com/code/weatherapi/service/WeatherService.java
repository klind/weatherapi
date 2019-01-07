package com.code.weatherapi.service;

import com.code.weatherapi.model.WeatherResponse;

/*
 * Weather service interface
 */
public interface WeatherService {

  /**
   * Returns the wind information for the specified zip code.
   * 
   * @param zip zip code
   * @return wind information
   */
  public WeatherResponse getWind(String zip);

}
