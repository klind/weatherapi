package com.code.weatherapi.scheduler;

import com.code.weatherapi.cache.WeatherResponseCache;
import com.code.weatherapi.model.CacheWeatherResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

@Component
public class CacheScheduler {
  private static Logger log = LoggerFactory.getLogger(CacheScheduler.class);

  @Value("${cachettl}")
  private int cachettl;

  /**
   * Removing old values from cache.
   */
  @Scheduled(fixedDelayString = "${cachefixedDelayString}")
  public void removeOldCacheValues() {
    log.debug("Running scheduled service to remove older values from cache");
    WeatherResponseCache weatherResponseCache = WeatherResponseCache.getInstance();
    synchronized (weatherResponseCache) {
      Iterator<String> iterator = weatherResponseCache.keySet().iterator();
      while (iterator.hasNext()) {
        String key = (String) iterator.next();
        LocalDateTime now = LocalDateTime.now();
        CacheWeatherResponse cacheWeatherResponse = weatherResponseCache.get(key);
        LocalDateTime insertionTime = cacheWeatherResponse.getTime();
        long diffInSeconds = insertionTime.until(now, ChronoUnit.SECONDS);
        if (diffInSeconds >= cachettl) {
          iterator.remove();
          log.debug("Removing key {} from the cache. New size is {}", key,
              weatherResponseCache.size());
        }
      }
    }
  }
}
