package com.code.weatherapi.cache;

import com.code.weatherapi.model.CacheWeatherResponse;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Cache implementation.
 */
public class WeatherResponseCache extends LinkedHashMap<String, CacheWeatherResponse> {
  private static final long serialVersionUID = 1L;
  private static WeatherResponseCache instance = new WeatherResponseCache();
  // The max cache size
  private static final int MAX_CACHE = 1000000;

  private WeatherResponseCache() {}

  public static WeatherResponseCache getInstance() {
    return instance;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > MAX_CACHE;
  }
}
