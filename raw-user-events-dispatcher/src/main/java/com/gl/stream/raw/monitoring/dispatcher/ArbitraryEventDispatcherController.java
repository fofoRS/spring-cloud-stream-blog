package com.gl.stream.raw.monitoring.dispatcher;

import com.gl.stream.raw.monitoring.model.RawUserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispatcher")
public class ArbitraryEventDispatcherController {

    private final StreamBridge streamBridge;
    private static final String OUTPUT_BINDING = "streamBridgeRawUserEvent-out-0";

    @Autowired
    public ArbitraryEventDispatcherController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    /**
     *  If we need to initiate a event pipeline outside of event-driven sources, Spring cloud stream provides the
     *  StreamBridge bean which allow us to send arbitrary event in an imperative way to a specific output binding.
     *  This is just another way to publishing event using Spring Cloud Stream.
     * @return
     */
    @PostMapping("/random")
    public ResponseEntity<Void> dispatchRandomEvent() {
        RawUserEvent event = EventLoaderSupplier.loadEvent().get();
        streamBridge.send(OUTPUT_BINDING,event);
        return ResponseEntity.ok().build();
    }
}
