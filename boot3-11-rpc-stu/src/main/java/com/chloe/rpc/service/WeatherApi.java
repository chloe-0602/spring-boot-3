package com.chloe.rpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

/**
 * ClassName: WeatherApi
 * Package: com.chloe.rpc.service
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 17:18
 * @Version 1.0
 */
public interface WeatherApi {
    @GetExchange(url = "https://weather110.market.alicloudapi.com/getWeather_40day", accept = "application/json")
    Mono<String> getWeather(@RequestParam("cityID") String cityID,
                            @RequestParam("cityName") String cityName);
}
