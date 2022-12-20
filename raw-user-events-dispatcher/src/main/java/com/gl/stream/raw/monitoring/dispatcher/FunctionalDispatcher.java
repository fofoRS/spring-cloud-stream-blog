package com.gl.stream.raw.monitoring.dispatcher;

import com.gl.stream.raw.monitoring.model.RawUserEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.function.Supplier;

@Configuration
public class FunctionalDispatcher {

    /**
     *  Initiate events pipeline using the new functional style.
     *  Spring cloud stream uses a pollable mechanisims to trigger the function every second
     *  We could fine tuned the pollable configuration (out of scope of this blog)
     * @return
     * @throws IOException
     */
    @Bean
    public Supplier<RawUserEvent> rawEventSupplier() throws IOException {
        return EventLoaderSupplier.loadEvent();
    }
}
