package com.solers.container.apps.sample;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PreDestroy;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = {
        "com.solers.container.apps","com.solers.skyfire"
})
@ImportResource({"classpath:sample-client-main-context.xml"})
public class Application {
    private static final Logger logger = getLogger(Application.class);

    @PreDestroy
    public void shutdown() {
        logger.info("Shutdown.");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
