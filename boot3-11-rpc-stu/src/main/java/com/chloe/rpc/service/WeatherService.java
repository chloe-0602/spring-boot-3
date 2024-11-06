package com.chloe.rpc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: WeatherService
 * Package: com.chloe.rpc.service
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 16:19
 * @Version 1.0
 */
@Service
@Slf4j
public class WeatherService {
    public Mono<String> getWeather(String cityID, String cityName) {
        String appcode = "f10f8e9db8c84a7db7f5537cc9a10da7";

        WebClient webClient = WebClient.create();

        Map<String, String> map = new HashMap<>();
        map.put("cityID", cityID);
        map.put("cityName", cityName);

        Mono<String> stringMono = webClient.get()
                .uri("https://weather110.market.alicloudapi.com/getWeather_40day?cityID={cityID}&cityName={cityName}",map)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "APPCODE " + appcode)
                .retrieve()
                .bodyToMono(String.class);

        return stringMono;

    }
}
