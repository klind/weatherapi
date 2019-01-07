package com.code.weatherapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.code.weatherapi.client.decorator.OpenWeatherAppClient;
import com.code.weatherapi.controller.WeatherServiceController;
import com.code.weatherapi.model.WeatherResponse;
import com.code.weatherapi.model.Wind;
import com.code.weatherapi.service.WeatherService;
import com.code.weatherapi.service.WeatherServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class WeatherapiTests {

  @InjectMocks
  private WeatherServiceController weatherServiceController;

  @Mock
  private WeatherService weatherService;

  @InjectMocks
  private WeatherServiceImpl weatherServiceImpl;

  @Mock
  private OpenWeatherAppClient openWeatherAppClient;

  @Test
  public void contextLoads() {
    String zip = "89149";

    // Test WeatherServiceController
    when(weatherService.getWind(zip)).thenReturn(new WeatherResponse(new Wind(Double.valueOf(25), 5)));
    WeatherResponse weatherResponse = weatherServiceController.getWind(zip).getBody();
    verify(weatherService).getWind(zip);
    assertNotNull(weatherResponse);
    assertEquals(Double.valueOf(25), weatherResponse.getWind().getSpeed());
    assertEquals(Integer.valueOf(5), weatherResponse.getWind().getDeg());

    // Test WeatherServiceImpl
    when(openWeatherAppClient.getWind(zip)).thenReturn(new WeatherResponse(new Wind(Double.valueOf(25), 5)));
    weatherResponse = weatherServiceImpl.getWind(zip);
    verify(openWeatherAppClient).getWind(zip);
    assertNotNull(weatherResponse);
    assertEquals(Double.valueOf(25), weatherResponse.getWind().getSpeed());
    assertEquals(Integer.valueOf(5), weatherResponse.getWind().getDeg());

  }

}
