package com.code.weatherapi.client.decorator;

import com.code.weatherapi.cache.WeatherResponseCache;
import com.code.weatherapi.model.CacheWeatherResponse;
import com.code.weatherapi.model.WeatherResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Primary
public class OpenWeatherAppCache extends OpenWeatherAppDecorator {
  private static Logger log = LoggerFactory.getLogger(OpenWeatherAppCache.class);
  private WeatherResponseCache weatherResponseCache;

  public OpenWeatherAppCache(OpenWeatherAppClient openWeatherAppClient) {
    super(openWeatherAppClient);
    weatherResponseCache = WeatherResponseCache.getInstance();
  }

  @Override
  public WeatherResponse getWind(String zip) {
    synchronized (weatherResponseCache) {
      if (weatherResponseCache.containsKey(zip)) {
        return weatherResponseCache.get(zip).getWeatherResponse();
      }
    }
    WeatherResponse weatherResponse = super.getWind(zip);
    weatherResponseCache.put(zip, new CacheWeatherResponse(LocalDateTime.now(), weatherResponse));
    log.debug("Adding {} to the cache. New size is {}", weatherResponse,
        weatherResponseCache.size());
    return weatherResponse;
  }
}
