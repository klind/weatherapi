package com.code.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatheraApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatheraApiApplication.class, args);
  }
}
