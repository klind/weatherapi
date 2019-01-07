package com.code.weatherapi.shell;

import com.code.weatherapi.cache.WeatherResponseCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class WeatherShell {
  private static Logger log = LoggerFactory.getLogger(WeatherShell.class);

  /**
   * Clearing the cache.
   */
  @ShellMethod("Clear the cache")
  public void clearcache() {
    WeatherResponseCache weatherResponseCache = WeatherResponseCache.getInstance();
    synchronized (weatherResponseCache) {
      int size = weatherResponseCache.size();
      weatherResponseCache.clear();
      log.debug("Removed {} elements from the cache", size);
    }
  }
}
