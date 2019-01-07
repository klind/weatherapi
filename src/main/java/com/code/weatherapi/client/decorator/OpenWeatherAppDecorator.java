package com.code.weatherapi.client.decorator;

import com.code.weatherapi.model.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public abstract class OpenWeatherAppDecorator implements OpenWeatherAppClient {

  protected OpenWeatherAppClient openWeatherAppClient;

  public OpenWeatherAppDecorator(OpenWeatherAppClient openWeatherAppClient) {
    this.openWeatherAppClient = openWeatherAppClient;
  }

  @Override
  public WeatherResponse getWind(String zip) {
    return openWeatherAppClient.getWind(zip);
  }

}
