package com.code.weatherapi.client.decorator;

import com.code.weatherapi.model.WeatherResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class OpenWeatherAppClientImpl implements OpenWeatherAppClient {
  private static Logger log = LoggerFactory.getLogger(OpenWeatherAppClientImpl.class);

  @Value("${weatherurl}")
  private String weatherurl;

  @Value("${appid}")
  private String appid;

  @Autowired
  private RestTemplate restTemplate;

  public OpenWeatherAppClientImpl() {
    super();
  }

  @Override
  public WeatherResponse getWind(String zip) {
    Map<String, String> uriVars = new HashMap<String, String>();
    uriVars.put("appid", appid);
    uriVars.put("zip", zip);
    log.debug("Retreiving wind information for zip {}", zip);
    WeatherResponse result = restTemplate.getForObject(weatherurl, WeatherResponse.class, uriVars);
    log.debug("Retreived {} for zip {}", result, zip);
    return result;
  }

}
