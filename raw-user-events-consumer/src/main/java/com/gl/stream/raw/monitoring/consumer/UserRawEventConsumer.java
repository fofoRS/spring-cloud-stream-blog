package com.gl.stream.raw.monitoring.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class UserRawEventConsumer {

    Logger log = LoggerFactory.getLogger(UserRawEventConsumer.class);

    @Bean
    public Consumer<String> userRawEvents() {
        return eventPayloadAsString -> {
            log.info("Raw User event: {} \n", eventPayloadAsString);
        };
    }
}
