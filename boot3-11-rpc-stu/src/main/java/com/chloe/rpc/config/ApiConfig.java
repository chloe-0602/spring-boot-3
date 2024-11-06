package com.chloe.rpc.config;

import com.chloe.rpc.service.WeatherApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * ClassName: ApiConfig
 * Package: com.chloe.rpc.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 17:25
 * @Version 1.0
 */
@Configuration
public class ApiConfig {
    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(@Value("${aliyun.appcode}") String appcode) {

        // 1. 创建客户端
        WebClient client = WebClient.builder()
                .defaultHeader("Authorization", "APPCODE " + appcode)
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256 * 1024 * 1024);
                })
                .build();

        // 2.创建工厂
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();

        return factory;
    }

    @Bean
    WeatherApi weatherApi(HttpServiceProxyFactory httpServiceProxyFactory) {
        return httpServiceProxyFactory.createClient(WeatherApi.class);
    }
}
