package com.code.weatherapi.service;

import com.code.weatherapi.client.decorator.OpenWeatherAppClient;
import com.code.weatherapi.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService {

  // Autowired com.code.weatherapi.client.decorator.OpenWeatherAppCache as @Primary
  @Autowired
  private OpenWeatherAppClient openWeatherAppClient;

  public WeatherServiceImpl() {}

  @Override
  public WeatherResponse getWind(String zip) {
    return openWeatherAppClient.getWind(zip);
  }
}
