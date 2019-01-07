package com.code.weatherapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.code.weatherapi.cache.WeatherResponseCache;
import com.code.weatherapi.service.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest{
  
  @Autowired
  private WeatherService weatherService;

  @Test
  public void testCache() {
    WeatherResponseCache weatherResponseCache = WeatherResponseCache.getInstance();
    assertNotNull(weatherService.getWind("89149"));
    assertNotNull(weatherResponseCache.get("89149"));
    assertNotNull(weatherService.getWind("89120"));
    assertNotNull(weatherResponseCache.get("89120"));
    assertEquals(2, weatherResponseCache.size());
    /*
     * try { Thread.sleep(20000); } catch (InterruptedException e) { e.printStackTrace(); }
     */
    assertEquals(0, weatherResponseCache.size());
    assertNotNull(weatherService.getWind("89123"));
    assertEquals(1, weatherResponseCache.size());
  }
}

