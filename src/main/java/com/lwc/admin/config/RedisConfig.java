package com.lwc.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;


@Slf4j
@Configuration
public class RedisConfig {
    @Bean
    public RedissonClient redissonClient() {
        Config conf = null;
        try {
            File file = new File("redis-config.yaml");
            if (file.exists()) {
                conf = Config.fromYAML(file);
            } else {
                //debugger可用，部署不可用，注意
                //ClassPathResource classPathResource = new ClassPathResource("redis-config.yaml");
                conf = Config.fromYAML(Thread.currentThread().getContextClassLoader().getResourceAsStream("redis-config.yaml"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Redisson.create(conf);
    }
}
