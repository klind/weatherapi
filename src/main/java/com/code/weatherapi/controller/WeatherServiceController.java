package com.code.weatherapi.controller;

import com.code.weatherapi.model.WeatherResponse;
import com.code.weatherapi.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

/**
 * WeatherServiceController.
 */
@RestController
@RequestMapping("/api/v1")
@Validated
public class WeatherServiceController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping("/wind")
  @ResponseBody
  public ResponseEntity<WeatherResponse> getWind(@RequestParam @Pattern(
      regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code is not valid") String zip) {
    return ResponseEntity.ok(weatherService.getWind(zip));
  }
}
