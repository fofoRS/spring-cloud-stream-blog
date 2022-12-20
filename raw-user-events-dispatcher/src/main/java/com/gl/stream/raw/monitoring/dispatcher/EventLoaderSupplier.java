package com.gl.stream.raw.monitoring.dispatcher;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gl.stream.raw.monitoring.model.RawUserEvent;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class EventLoaderSupplier {
    public static Supplier<RawUserEvent> loadEvent() {
        return () -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<RawUserEvent> eventList = null;
            try {
                eventList = mapper.readValue(
                        new ClassPathResource("user-events.json").getInputStream(),
                        new TypeReference<List<RawUserEvent>>() {});
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            long milliseconds = System.currentTimeMillis();
            Random random = new Random(milliseconds);
            int randomNumber = random.nextInt(eventList.size());
            return eventList.get(randomNumber);
        };
    }



}
