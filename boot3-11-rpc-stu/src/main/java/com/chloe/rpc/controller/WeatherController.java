package com.chloe.rpc.controller;

import com.chloe.rpc.service.WeatherApi;
import com.chloe.rpc.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * ClassName: WeatherController
 * Package: com.chloe.rpc.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 16:18
 * @Version 1.0
 */
@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherApi weatherApi;

    @GetMapping("/weather")
    public Mono<String> weather(@RequestParam("cityID") String cityID, @RequestParam("cityName") String cityName){
        return weatherService.getWeather(cityID,cityName);
    }

    @GetMapping("/weather1")
    public Mono<String> weather1(String cityID, String cityName){
        return weatherApi.getWeather(cityID, cityName);
    }
}
