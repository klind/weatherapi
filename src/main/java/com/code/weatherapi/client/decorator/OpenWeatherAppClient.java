package com.code.weatherapi.client.decorator;

import com.code.weatherapi.model.WeatherResponse;

public interface OpenWeatherAppClient {

  /**
   * Returns the wind information for the specified zip code.
   * 
   * @param zip zip code
   * @return wind information
   */
  public WeatherResponse getWind(String zip);

}
